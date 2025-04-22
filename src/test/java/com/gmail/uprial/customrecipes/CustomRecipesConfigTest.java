package com.gmail.uprial.customrecipes;

import com.gmail.uprial.customrecipes.config.InvalidConfigException;
import com.gmail.uprial.customrecipes.helpers.TestConfigBase;
import org.bukkit.configuration.InvalidConfigurationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CustomRecipesConfigTest extends TestConfigBase {
    @Rule
    public final ExpectedException e = ExpectedException.none();

    @Test
    public void testEmptyDebug() throws Exception {
        e.expect(RuntimeException.class);
        e.expectMessage("Empty 'debug' flag. Use default value false");
        CustomRecipesConfig.isDebugMode(getPreparedConfig(""), getDebugFearingCustomLogger());
    }

    @Test
    public void testNormalDebug() throws Exception {
        assertTrue(CustomRecipesConfig.isDebugMode(getPreparedConfig("debug: true"), getDebugFearingCustomLogger()));
    }

    @Test
    public void testEmpty() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Empty 'enabled-recipes' list");
        loadConfig(getDebugFearingCustomLogger(), "");
    }

    @Test
    public void testNotMap() throws Exception {
        e.expect(InvalidConfigurationException.class);
        e.expectMessage("Top level is not a Map.");
        loadConfig("x");
    }

    @Test
    public void testNoEnabledRecipes() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Empty 'enabled-recipes' list");
        loadConfig("x:");
    }

    @Test
    public void testEmptyEnabledRecipesList() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Empty 'enabled-recipes' list");
        loadConfig("enabled-recipes:");
    }

    @Test
    public void testNoDefinitionOfEnabledRecipes() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Null definition of recipe-key 'x'");
        loadConfig("enabled-recipes:",
                " - x");
    }

    @Test
    public void testDuplicateKeyInEnabledRecipes() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Key 'x' in 'enabled-recipes' is not unique");
        loadConfig("enabled-recipes:",
                " - x",
                " - x",
                "x:",
                " name: test",
                " recipe:",
                "  - EGG EGG EGG",
                "  - EGG EGG EGG",
                "  - EGG EGG EGG",
                " material: PIG_SPAWN_EGG");
    }

    @Test
    public void testDuplicateKeyInEnabledRecipesWithDifferentCase() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Key 'X' in 'enabled-recipes' is not unique");
        loadConfig("enabled-recipes:",
                " - x",
                " - X",
                "x:",
                " name: test",
                " recipe:",
                "  - EGG EGG EGG",
                "  - EGG EGG EGG",
                "  - EGG EGG EGG",
                " material: PIG_SPAWN_EGG");
    }

    @Test
    public void testNormalConfig() throws Exception {
        assertEquals(
                "recipes: [PIG_SPAWN_EGG~'test'=[EGG,EGG,EGG,EGG,EGG,EGG,EGG,EGG,EGG]]",
                loadConfig("enabled-recipes:",
                        " - x",
                        "x:",
                        " name: test",
                        " recipe:",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        " material: PIG_SPAWN_EGG").toString());
    }
}