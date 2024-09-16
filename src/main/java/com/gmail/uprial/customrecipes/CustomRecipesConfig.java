package com.gmail.uprial.customrecipes;

import com.gmail.uprial.customrecipes.common.CustomLogger;
import com.gmail.uprial.customrecipes.config.ConfigReaderSimple;
import com.gmail.uprial.customrecipes.config.InvalidConfigException;
import com.gmail.uprial.customrecipes.schema.Recipe;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static com.gmail.uprial.customrecipes.config.ConfigReaderSimple.getKey;

public final class CustomRecipesConfig {
    private final List<Recipe> recipes;

    private CustomRecipesConfig(final List<Recipe> recipes) {
        this.recipes = recipes;
    }

    List<Recipe> getRecipes() {
        return recipes;
    }

    static boolean isDebugMode(FileConfiguration config, CustomLogger customLogger) throws InvalidConfigException {
        return ConfigReaderSimple.getBoolean(config, customLogger, "debug", "'debug' flag", false);
    }

    Recipe searchRecipeByItemStack(ItemStack itemStack) {
        if (itemStack.getItemMeta() == null) {
            return null;
        }
        for(Recipe recipe : recipes) {
            if (recipe.getName().equals(itemStack.getItemMeta().getDisplayName())
                && recipe.getMaterial().equals(itemStack.getType())
                && (recipe.getAmount() == itemStack.getAmount())) {
                if(recipe.getDescription() == null) {
                    if(itemStack.getItemMeta().getLore() == null) {
                        return recipe;
                    }
                } else {
                    if ((itemStack.getItemMeta().getLore() != null)
                        && (recipe.getDescription().equals(itemStack.getItemMeta().getLore()))) {
                        return recipe;
                    }
                }
            }
        }
        return null;
    }

    public static CustomRecipesConfig getFromConfig(FileConfiguration config, CustomLogger customLogger) throws InvalidConfigException {
        List<Recipe> recipes = new ArrayList<>();
        Set<String> names = new HashSet<>();
        Set<String> keys = new HashSet<>();

        List<?> recipesConfig = config.getList("enabled-recipes");
        if((recipesConfig == null) || (recipesConfig.size() <= 0)) {
            throw new InvalidConfigException("Empty 'enabled-recipes' list");
        }

        int recipesConfigSize = recipesConfig.size();
        for(int i = 0; i < recipesConfigSize; i++) {
            String key = getKey(recipesConfig.get(i), "'enabled-recipes'", i);
            String keyLC = key.toLowerCase(Locale.getDefault());
            if(keys.contains(keyLC)) {
                throw new InvalidConfigException(String.format("Key '%s' in 'enabled-recipes' is not unique", key));
            }
            Recipe recipe = Recipe.getFromConfig(config, customLogger, key);

            String nameLC = recipe.getName().toLowerCase(Locale.getDefault());
            if(names.contains(nameLC)) {
                throw new InvalidConfigException(String.format("Name '%s' of recipes-key '%s' is not unique", recipe.getName(), key));
            }

            recipes.add(recipe);
            names.add(nameLC);
            keys.add(keyLC);
        }

        return new CustomRecipesConfig(recipes);
    }

    public String toString() {
        return String.format("recipes: %s", recipes.toString());
    }
}
