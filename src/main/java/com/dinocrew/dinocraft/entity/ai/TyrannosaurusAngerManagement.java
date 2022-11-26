package com.dinocrew.dinocraft.entity.ai;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Streams;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TyrannosaurusAngerManagement {
    @VisibleForTesting
    protected static final int CONVERSION_DELAY = 2;
    @VisibleForTesting
    protected static final int MAX_ANGER = 470;
    private static final int DEFAULT_ANGER_DECREASE = 1;
    private int conversionDelay = Mth.randomBetweenInclusive(RandomSource.create(), 0, CONVERSION_DELAY);
    int highestAnger;
    private static final Codec<Pair<UUID, Integer>> SUSPECT_ANGER_PAIR = RecordCodecBuilder.create(
            instance -> instance.group(
                            ExtraCodecs.UUID.fieldOf("uuid").forGetter(Pair::getFirst), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("anger").forGetter(Pair::getSecond)
                    )
                    .apply(instance, Pair::of)
    );
    private final Predicate<Entity> filter;
    @VisibleForTesting
    protected final ArrayList<Entity> suspects;
    private final TyrannosaurusAngerManagement.Sorter suspectSorter;
    @VisibleForTesting
    protected final Object2IntMap<Entity> angerBySuspect;
    @VisibleForTesting
    protected final Object2IntMap<UUID> angerByUuid;

    public static Codec<TyrannosaurusAngerManagement> codec(Predicate<Entity> entityPredicate) {
        return RecordCodecBuilder.create(
                instance -> instance.group(SUSPECT_ANGER_PAIR.listOf().fieldOf("suspects").orElse(Collections.emptyList()).forGetter(TyrannosaurusAngerManagement::createUuidAngerPairs))
                        .apply(instance, list -> new TyrannosaurusAngerManagement(entityPredicate, list))
        );
    }

    public TyrannosaurusAngerManagement(Predicate<Entity> filter, List<Pair<UUID, Integer>> uuids) {
        this.filter = filter;
        this.suspects = new ArrayList<>();
        this.suspectSorter = new TyrannosaurusAngerManagement.Sorter(this);
        this.angerBySuspect = new Object2IntOpenHashMap<>();
        this.angerByUuid = new Object2IntOpenHashMap<>(uuids.size());
        uuids.forEach(pair -> this.angerByUuid.put(pair.getFirst(), pair.getSecond()));
    }

    private List<Pair<UUID, Integer>> createUuidAngerPairs() {
        return Streams.concat(
                        this.suspects.stream().map(entity -> Pair.of(entity.getUUID(), this.angerBySuspect.getInt(entity))),
                        this.angerByUuid.object2IntEntrySet().stream().map(entry -> Pair.of(entry.getKey(), entry.getIntValue()))
                )
                .collect(Collectors.toList());
    }

    public void tick(ServerLevel level, Predicate<Entity> predicate) {
        --this.conversionDelay;
        if (this.conversionDelay <= 0) {
            this.convertFromUuids(level);
            this.conversionDelay = CONVERSION_DELAY;
        }

        ObjectIterator<Object2IntMap.Entry<UUID>> objectIterator = this.angerByUuid.object2IntEntrySet().iterator();

        while(objectIterator.hasNext()) {
            Object2IntMap.Entry<UUID> entry = objectIterator.next();
            int i = entry.getIntValue();
            if (i <= 1) {
                objectIterator.remove();
            } else {
                entry.setValue(i - DEFAULT_ANGER_DECREASE);
            }
        }

        ObjectIterator<Object2IntMap.Entry<Entity>> objectIterator2 = this.angerBySuspect.object2IntEntrySet().iterator();

        while(objectIterator2.hasNext()) {
            Object2IntMap.Entry<Entity> entry2 = objectIterator2.next();
            int j = entry2.getIntValue();
            Entity entity = entry2.getKey();
            Entity.RemovalReason removalReason = entity.getRemovalReason();
            if (j > 1 && predicate.test(entity) && removalReason == null) {
                entry2.setValue(j - DEFAULT_ANGER_DECREASE);
            } else {
                this.suspects.remove(entity);
                objectIterator2.remove();
                if (j > 1 && removalReason != null) {
                    switch (removalReason) {
                        case CHANGED_DIMENSION, UNLOADED_TO_CHUNK, UNLOADED_WITH_PLAYER ->
                                this.angerByUuid.put(entity.getUUID(), j - DEFAULT_ANGER_DECREASE);
                    }
                }
            }
        }

        this.sortAndUpdateHighestAnger();
    }

    private void sortAndUpdateHighestAnger() {
        this.highestAnger = 0;
        this.suspects.sort(this.suspectSorter);
        if (this.suspects.size() == 1) {
            this.highestAnger = this.angerBySuspect.getInt(this.suspects.get(0));
        }

    }

    private void convertFromUuids(ServerLevel level) {
        ObjectIterator<Object2IntMap.Entry<UUID>> objectIterator = this.angerByUuid.object2IntEntrySet().iterator();

        while(objectIterator.hasNext()) {
            Object2IntMap.Entry<UUID> entry = objectIterator.next();
            int i = entry.getIntValue();
            Entity entity = level.getEntity(entry.getKey());
            if (entity != null) {
                this.angerBySuspect.put(entity, i);
                this.suspects.add(entity);
                objectIterator.remove();
            }
        }

    }

    public int increaseAnger(Entity entity, int offset) {
        boolean bl = !this.angerBySuspect.containsKey(entity);
        int i = this.angerBySuspect.computeInt(entity, (entityx, integer) -> Math.min(MAX_ANGER, (integer == null ? 0 : integer) + offset));
        if (bl) {
            int j = this.angerByUuid.removeInt(entity.getUUID());
            i += j;
            this.angerBySuspect.put(entity, i);
            this.suspects.add(entity);
        }

        this.sortAndUpdateHighestAnger();
        return i;
    }

    public void clearAnger(Entity entity) {
        this.angerBySuspect.removeInt(entity);
        this.suspects.remove(entity);
        this.sortAndUpdateHighestAnger();
    }

    @Nullable
    private Entity getTopSuspect() {
        return this.suspects.stream().filter(this.filter).findFirst().orElse(null);
    }

    public int getActiveAnger(@Nullable Entity entity) {
        return entity == null ? this.highestAnger : this.angerBySuspect.getInt(entity);
    }

    public Optional<LivingEntity> getActiveEntity() {
        return Optional.ofNullable(this.getTopSuspect()).filter(entity -> entity instanceof LivingEntity).map(entity -> (LivingEntity)entity);
    }

    @VisibleForTesting
    protected record Sorter(TyrannosaurusAngerManagement angerManagement) implements Comparator<Entity> {
        public int compare(Entity first, Entity second) {
            if (first.equals(second)) {
                return 0;
            } else {
                int i = this.angerManagement.angerBySuspect.getOrDefault(first, 0);
                int j = this.angerManagement.angerBySuspect.getOrDefault(second, 0);
                this.angerManagement.highestAnger = Math.max(this.angerManagement.highestAnger, Math.max(i, j));
                boolean bl = TyrannosaurusAngerLevel.byAnger(i).isAngry();
                boolean bl2 = TyrannosaurusAngerLevel.byAnger(j).isAngry();
                if (bl != bl2) {
                    return bl ? -1 : 1;
                } else {
                    boolean bl3 = first instanceof Player;
                    boolean bl4 = second instanceof Player;
                    if (bl3 != bl4) {
                        return bl3 ? -1 : 1;
                    } else {
                        return Integer.compare(j, i);
                    }
                }
            }
        }
    }
}
