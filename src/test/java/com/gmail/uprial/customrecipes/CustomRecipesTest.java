package com.gmail.uprial.customrecipes;

import com.gmail.uprial.customrecipes.helpers.TestConfigBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomRecipesTest extends TestConfigBase {
    @Rule
    public final ExpectedException e = ExpectedException.none();

    @Test
    public void testLoadException() throws Exception {
        e.expect(RuntimeException.class);
        e.expectMessage("[ERROR] Empty 'enabled-recipes' list");
        CustomRecipes.loadConfig(getPreparedConfig(""), getCustomLogger());
    }
}