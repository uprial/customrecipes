package com.gmail.uprial.customrecipes.schema;

import com.gmail.uprial.customrecipes.config.InvalidConfigException;
import com.gmail.uprial.customrecipes.helpers.TestConfigBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.gmail.uprial.customrecipes.schema.RecipeRecipe.getFromConfig;
import static org.junit.Assert.assertEquals;

public class RecipeRecipeTest extends TestConfigBase {
    @Rule
    public final ExpectedException e = ExpectedException.none();

    @Test
    public void testNull() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Empty RR");
        getFromConfig(getPreparedConfig(
                        "?:"),"rr", "RR");
    }

    @Test
    public void testEmpty() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Empty RR");
        getFromConfig(getPreparedConfig(
                "rr:",
                " x: y"),"rr", "RR");
    }

    @Test
    public void testLessThan3Rows() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("RR should have 3 rows");
        getFromConfig(getPreparedConfig(
                "rr:",
                " - a"),"rr", "RR");
    }

    @Test
    public void testLessThan3Cols() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("RR should have 3 cols at row 1");
        getFromConfig(getPreparedConfig(
                "rr:",
                " - a",
                " - a",
                " - a"),"rr", "RR");
    }

    @Test
    public void testWrongMaterial() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("Invalid material 'a' in RR at row 1, col 1");
        getFromConfig(getPreparedConfig(
                "rr:",
                " - a a a",
                " - a",
                " - a"),"rr", "RR");
    }

    @Test
    public void testLessThan3ColsInTheMiddle() throws Exception {
        e.expect(InvalidConfigException.class);
        e.expectMessage("RR should have 3 cols at row 2");
        getFromConfig(getPreparedConfig(
                "rr:",
                " - EGG EGG EGG",
                " - a",
                " - a"),"rr", "RR");
    }

    @Test
    public void testWhole() throws Exception {
        RecipeRecipe recipeRecipe = getFromConfig(getPreparedConfig(
                        "rr:",
                        " - EGG EGG EGG",
                        " - EGG EGG EGG",
                        " - EGG EGG EGG"), "rr", "RR");
        assertEquals("[EGG,EGG,EGG,EGG,EGG,EGG,EGG,EGG,EGG]", recipeRecipe.toString());
    }
}