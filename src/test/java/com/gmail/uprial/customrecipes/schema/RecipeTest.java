package com.gmail.uprial.customrecipes.schema;

import com.gmail.uprial.customrecipes.config.InvalidConfigException;
import com.gmail.uprial.customrecipes.helpers.TestConfigBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.gmail.uprial.customrecipes.schema.Recipe.getFromConfig;
import static org.junit.Assert.assertEquals;

public class RecipeTest extends TestConfigBase {
    @Rule
    public final ExpectedException e = ExpectedException.none();

    @Test
    public void testNull() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Null definition of recipe-key 'r'");
        getFromConfig(getPreparedConfig(
                        "?:"),
                getCustomLogger(), "r");
    }

    @Test
    public void testNullName() throws Exception {
        e.expect(RuntimeException.class);
        e.expectMessage("Empty name of recipe 'r'. Use default value NULL");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " z: y"),
                getDebugFearingCustomLogger(), "r");
    }

    @Test
    public void testEmptyName() throws Exception {
        e.expect(RuntimeException.class);
        e.expectMessage("Empty name of recipe 'r'. Use default value NULL");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: "),
                getDebugFearingCustomLogger(), "r");
    }

    @Test
    public void testNullDescription() throws Exception {
        e.expect(RuntimeException.class);
        e.expectMessage("Empty description of recipe 'r'. Use default value NULL");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test"),
                getDebugFearingCustomLogger(), "r");
    }

    @Test
    public void testDescriptionAsString() throws Exception {
        e.expect(RuntimeException.class);
        e.expectMessage("Empty description of recipe 'r'. Use default value NULL");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test",
                        " description: test"),
                getDebugFearingCustomLogger(), "r");
    }

    @Test
    public void testNullRecipe() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Empty recipe of recipe 'r'");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test",
                        " description:",
                        "  - test"),
                getCustomLogger(), "r");
    }

    @Test
    public void testNotFullRecipe() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("recipe of recipe 'r' should have 3 rows");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test",
                        " description:",
                        "  - test",
                        " recipe:",
                        "  - EGG EGG EGG"),
                getCustomLogger(), "r");
    }

    @Test
    public void testEmptyMaterial() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Empty material of recipe 'r'");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test",
                        " description:",
                        "  - test",
                        " recipe:",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG"),
                getCustomLogger(), "r");
    }

    @Test
    public void testWrongMaterial() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Unknown material of recipe 'r' 'test'");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test",
                        " description:",
                        "  - test",
                        " recipe:",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        " material: test"),
                getCustomLogger(), "r");
    }
    @Test
    public void testEmptyAmount() throws Exception {
        e.expect(RuntimeException.class);
        e.expectMessage("Empty amount of recipe 'r'");
        getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test",
                        " description:",
                        "  - test",
                        " recipe:",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        " material: PIG_SPAWN_EGG"),
                getDebugFearingCustomLogger(), "r");
    }

    @Test
    public void testWhole() throws Exception {
        Recipe recipe = getFromConfig(getPreparedConfig(
                        "r:",
                        " name: test",
                        " description:",
                        "  - test",
                        " recipe:",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        "  - EGG EGG EGG",
                        " material: PIG_SPAWN_EGG",
                        " amount: 1"),
                getParanoiacCustomLogger(), "r");
        assertEquals("PIG_SPAWN_EGG~'test(test)'=[EGG,EGG,EGG,EGG,EGG,EGG,EGG,EGG,EGG]", recipe.toString());
    }
}