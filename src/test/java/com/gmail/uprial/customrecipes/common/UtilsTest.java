package com.gmail.uprial.customrecipes.common;

import com.google.common.collect.Lists;
import org.junit.Test;

import static com.gmail.uprial.customrecipes.common.Utils.*;
import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void testJoinEmptyStrings() throws Exception {
        assertEquals("", joinStrings(",", Lists.newArrayList(new String[]{})));
    }

    @Test
    public void testJoinOneString() throws Exception {
        assertEquals("a", joinStrings(",", Lists.newArrayList("a")));
    }

    @Test
    public void testJoinSeveralStrings() throws Exception {
        assertEquals("a,b", joinStrings(",", Lists.newArrayList("a", "b")));
    }

    @Test
    public void testJoinPaths() throws Exception {
        assertEquals("a.b", joinPaths("a", "b"));
    }

    @Test
    public void testJoinRootEmptyPaths() throws Exception {
        assertEquals("b", joinPaths("", "b"));
    }

    @Test
    public void testJoinRightEmptyPaths() throws Exception {
        assertEquals("a.", joinPaths("a", ""));
    }
}