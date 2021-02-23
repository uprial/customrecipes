package com.gmail.uprial.customrecipes.schema;

import com.gmail.uprial.customrecipes.CustomRecipes;
import com.gmail.uprial.customrecipes.config.ConfigReaderMaterial;
import com.gmail.uprial.customrecipes.config.ConfigReaderNumbers;
import com.gmail.uprial.customrecipes.config.ConfigReaderSimple;
import com.gmail.uprial.customrecipes.common.CustomLogger;
import com.gmail.uprial.customrecipes.config.InvalidConfigException;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Locale;

public final class Recipe {
    @SuppressWarnings("FieldCanBeLocal")
    private static final int DEFAULT_AMOUNT = 1;
    @SuppressWarnings("FieldCanBeLocal")
    private static final int MIN_AMOUNT = 1;
    @SuppressWarnings("FieldCanBeLocal")
    private static final int MAX_AMOUNT = 64;

    private final String keyLC;
    private String name;
    private List<String> description;
    private RecipeRecipe recipe;
    private Material material;
    private int amount;

    @SuppressWarnings("BooleanParameter")
    private Recipe(String key, String name, List<String> description, RecipeRecipe recipe, Material material, int amount) {
        this.keyLC = key.toLowerCase(Locale.getDefault());
        this.name = name;
        this.description = description;
        this.recipe = recipe;
        this.material = material;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public List<String> getDescription() {
        return description;
    }

    public Material getMaterial() {
        return material;
    }

    public int getAmount() {
        return amount;
    }

    public ShapedRecipe getShapedRecipe(CustomRecipes plugin) {
        return recipe.getShapedRecipe(plugin, keyLC, getItemStack());
    }

    @SuppressWarnings({"BooleanParameter", "AccessingNonPublicFieldOfAnotherObject"})
    public static Recipe getFromConfig(FileConfiguration config, CustomLogger customLogger, String key) throws InvalidConfigException {
        String name = ConfigReaderSimple.getString(config,key + ".name",
                String.format("name of recipe-key '%s'", key));
        List<String> description = ConfigReaderSimple.getStringList(config, customLogger,
                key + ".description", String.format("description of recipe '%s'", key));;
        RecipeRecipe recipe = RecipeRecipe.getFromConfig(config, key + ".recipe",
                String.format("recipe of recipe '%s'", key));
        Material material = ConfigReaderMaterial.getMaterial(config,
                key + ".material", String.format("material of recipe '%s'", key));
        int amount = ConfigReaderNumbers.getInt(config, customLogger,
                key + ".amount", String.format("amount of recipe '%s'", key), MIN_AMOUNT, MAX_AMOUNT, DEFAULT_AMOUNT);

        return new Recipe(key, name, description, recipe, material, amount);
    }

    private ItemStack getItemStack() {
        ItemStack result = new ItemStack(material);
        ItemMeta meta = result.getItemMeta();

        if(description != null) {
            meta.setLore(description);
        }

        meta.setDisplayName(name);
        result.setItemMeta(meta);
        result.setAmount(amount);

        return result;
    }

    public String toString() {
        String descriptionString = (description == null) ? "" : (" (" + StringUtils.join(description, " ") + ')');

        return material + "~'" + name + descriptionString + "'=" + recipe;
    }
}
