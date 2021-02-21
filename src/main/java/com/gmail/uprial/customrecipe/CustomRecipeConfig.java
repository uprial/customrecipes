package com.gmail.uprial.customrecipe;

import com.gmail.uprial.customrecipe.common.CustomLogger;
import com.gmail.uprial.customrecipe.config.ConfigReaderSimple;
import com.gmail.uprial.customrecipe.config.InvalidConfigException;
import org.bukkit.configuration.file.FileConfiguration;

public final class CustomRecipeConfig {
    private final boolean enabled;

    private CustomRecipeConfig(boolean enabled) {
        this.enabled = enabled;
    }

    static boolean isDebugMode(FileConfiguration config, CustomLogger customLogger) throws InvalidConfigException {
        return ConfigReaderSimple.getBoolean(config, customLogger, "debug", "'debug' flag", false);
    }

    public boolean isEnabled() {
        return enabled;
    }

    static CustomRecipeConfig getFromConfig(FileConfiguration config, CustomLogger customLogger) throws InvalidConfigException {
        boolean enabled = ConfigReaderSimple.getBoolean(config, customLogger, "enabled", "'enabled' flag", true);

        return new CustomRecipeConfig(enabled);
    }

    public String toString() {
        return String.format("enabled: %b", enabled);
    }
}
