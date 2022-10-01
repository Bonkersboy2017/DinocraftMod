package com.dinocrew.dinocraft.misc.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import static com.dinocrew.dinocraft.misc.config.DinocraftConfig.text;
import static com.dinocrew.dinocraft.misc.config.DinocraftConfig.tooltip;

@Config(name = "entity")
public final class EntityConfig implements ConfigData {

    public boolean naturallyGenerateDinos;

    @Environment(EnvType.CLIENT)
    static void setupEntries(ConfigCategory category, ConfigEntryBuilder entryBuilder) {
        var config = DinocraftConfig.get().entity;
        var natural = category.addEntry(entryBuilder.startBooleanToggle(text("naturally_generate_dinos"), config.naturallyGenerateDinos)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> config.naturallyGenerateDinos = newValue)
                .setTooltip(tooltip("naturally_generate_dinos"))
                .requireRestart()
                .build()
        );
    }
}
