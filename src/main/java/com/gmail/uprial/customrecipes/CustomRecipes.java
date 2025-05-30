package com.gmail.uprial.customrecipes;

import com.gmail.uprial.customrecipes.common.CustomLogger;
import com.gmail.uprial.customrecipes.config.InvalidConfigException;
import com.gmail.uprial.customrecipes.schema.Recipe;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.gmail.uprial.customrecipes.CustomRecipesCommandExecutor.COMMAND_NS;

public final class CustomRecipes extends JavaPlugin {
    private final String CONFIG_FILE_NAME = "config.yml";
    private final File configFile = new File(getDataFolder(), CONFIG_FILE_NAME);

    private CustomLogger consoleLogger = null;
    private CustomRecipesConfig customRecipesConfig = null;

    private final Set<NamespacedKey> addedKeys = new HashSet<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        consoleLogger = new CustomLogger(getLogger());
        customRecipesConfig = loadConfig(getConfig(), consoleLogger);

        loadRecipes();

        getCommand(COMMAND_NS).setExecutor(new CustomRecipesCommandExecutor(this));
        consoleLogger.info("Plugin enabled");
    }

    void reloadConfig(CustomLogger userLogger) {
        reloadConfig();
        unloadRecipe();
        customRecipesConfig = loadConfig(getConfig(), userLogger, consoleLogger);
        loadRecipes();
    }

    @Override
    public void onDisable() {
        unloadRecipe();
        consoleLogger.info("Plugin disabled");
    }

    @Override
    public void saveDefaultConfig() {
        if (!configFile.exists()) {
            saveResource(CONFIG_FILE_NAME, false);
        }
    }

    private void loadRecipes() {
        List<Recipe> recipes = customRecipesConfig.getRecipes();
        for(Recipe recipe : recipes) {
            final ShapedRecipe shapedRecipe = recipe.getShapedRecipe(this);
            getServer().addRecipe(shapedRecipe);
            addedKeys.add(shapedRecipe.getKey());
        }
    }

    private void unloadRecipe() {
        for(NamespacedKey key : addedKeys) {
            getServer().removeRecipe(key);
        }
        addedKeys.clear();
    }

    @Override
    public FileConfiguration getConfig() {
        return YamlConfiguration.loadConfiguration(configFile);
    }

    static CustomRecipesConfig loadConfig(FileConfiguration config, CustomLogger customLogger) {
        return loadConfig(config, customLogger, null);
    }

    private static CustomRecipesConfig loadConfig(FileConfiguration config, CustomLogger mainLogger, CustomLogger secondLogger) {
        CustomRecipesConfig customRecipesConfig = null;
        try {
            boolean isDebugMode = CustomRecipesConfig.isDebugMode(config, mainLogger);
            mainLogger.setDebugMode(isDebugMode);
            if(secondLogger != null) {
                secondLogger.setDebugMode(isDebugMode);
            }

            customRecipesConfig = CustomRecipesConfig.getFromConfig(config, mainLogger);
        } catch (InvalidConfigException e) {
            mainLogger.error(e.getMessage());
        }

        return customRecipesConfig;
    }
}
