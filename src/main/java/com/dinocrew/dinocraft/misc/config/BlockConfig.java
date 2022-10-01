package com.dinocrew.dinocraft.misc.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import static com.dinocrew.dinocraft.misc.config.DinocraftConfig.text;
import static com.dinocrew.dinocraft.misc.config.DinocraftConfig.tooltip;

@Config(name = "block")
public final class BlockConfig implements ConfigData {

    @Environment(EnvType.CLIENT)
    static void setupEntries(ConfigCategory category, ConfigEntryBuilder entryBuilder) {
        var config = DinocraftConfig.get().block;
    }
}
