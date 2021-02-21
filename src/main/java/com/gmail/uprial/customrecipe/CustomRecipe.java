package com.gmail.uprial.customrecipe;

import com.gmail.uprial.customrecipe.common.CustomLogger;
import com.gmail.uprial.customrecipe.config.InvalidConfigException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

import static com.gmail.uprial.customrecipe.CustomRecipeCommandExecutor.COMMAND_NS;

public final class CustomRecipe extends JavaPlugin {
    private final String CONFIG_FILE_NAME = "config.yml";
    private final File configFile = new File(getDataFolder(), CONFIG_FILE_NAME);

    private CustomLogger consoleLogger = null;
    private CustomRecipeConfig customRecipeConfig = null;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        consoleLogger = new CustomLogger(getLogger());
        customRecipeConfig = loadConfig(getConfig(), consoleLogger);

        getCommand(COMMAND_NS).setExecutor(new CustomRecipeCommandExecutor(this));
        consoleLogger.info("Plugin enabled");
    }

    public CustomRecipeConfig getCustomRecipeConfig() {
        return customRecipeConfig;
    }

    void reloadConfig(CustomLogger userLogger) {
        reloadConfig();
        customRecipeConfig = loadConfig(getConfig(), userLogger, consoleLogger);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
        consoleLogger.info("Plugin disabled");
    }

    @Override
    public void saveDefaultConfig() {
        if (!configFile.exists()) {
            saveResource(CONFIG_FILE_NAME, false);
        }
    }

    @Override
    public FileConfiguration getConfig() {
        return YamlConfiguration.loadConfiguration(configFile);
    }

    private static CustomRecipeConfig loadConfig(FileConfiguration config, CustomLogger customLogger) {
        return loadConfig(config, customLogger, null);
    }

    private static CustomRecipeConfig loadConfig(FileConfiguration config, CustomLogger mainLogger, CustomLogger secondLogger) {
        CustomRecipeConfig customRecipeConfig = null;
        try {
            boolean isDebugMode = CustomRecipeConfig.isDebugMode(config, mainLogger);
            mainLogger.setDebugMode(isDebugMode);
            if(secondLogger != null) {
                secondLogger.setDebugMode(isDebugMode);
            }

            customRecipeConfig = CustomRecipeConfig.getFromConfig(config, mainLogger);
        } catch (InvalidConfigException e) {
            mainLogger.error(e.getMessage());
        }

        return customRecipeConfig;
    }
}
