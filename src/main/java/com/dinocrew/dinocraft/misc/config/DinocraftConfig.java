package com.dinocrew.dinocraft.misc.config;

import com.dinocrew.dinocraft.Dinocraft;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Category;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.TransitiveObject;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

@Config(name = Dinocraft.MOD_ID)
public class DinocraftConfig extends PartitioningSerializer.GlobalData {
    @Category("block")
    @TransitiveObject
    public BlockConfig block = new BlockConfig();

    @Category("entity")
    @TransitiveObject
    public EntityConfig entity = new EntityConfig();

    @Category("worldgen")
    @TransitiveObject
    public WorldgenConfig worldgen = new WorldgenConfig();

    public static DinocraftConfig get() {
        if (!Dinocraft.areConfigsInit) {
            AutoConfig.register(DinocraftConfig.class, PartitioningSerializer.wrap(GsonConfigSerializer::new));
            Dinocraft.areConfigsInit = true;
        }
        return AutoConfig.getConfigHolder(DinocraftConfig.class).getConfig();
    }

    public static Text text(String key) {
        return Text.translatable("option." + Dinocraft.MOD_ID + "." + key);
    }

    public static Text tooltip(String key) {
        return Text.translatable("tooltip." + Dinocraft.MOD_ID + "." + key);
    }

    @Environment(EnvType.CLIENT)
    public static Screen buildScreen(Screen parent) {
        var configBuilder = ConfigBuilder.create().setParentScreen(parent).setTitle(text("component.title"));
        configBuilder.setSavingRunnable(() -> AutoConfig.getConfigHolder(DinocraftConfig.class).save());
        var block = configBuilder.getOrCreateCategory(text("block"));
        var entity = configBuilder.getOrCreateCategory(text("entity"));
        var item = configBuilder.getOrCreateCategory(text("item"));
        var worldgen = configBuilder.getOrCreateCategory(text("worldgen"));
        ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();
        BlockConfig.setupEntries(block, entryBuilder);
        EntityConfig.setupEntries(entity, entryBuilder);
        ItemConfig.setupEntries(item, entryBuilder);
        WorldgenConfig.setupEntries(worldgen, entryBuilder);
        return configBuilder.build();
    }
}
