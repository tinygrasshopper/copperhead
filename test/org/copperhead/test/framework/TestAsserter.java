package org.copperhead.test.framework;

public class TestAsserter {
    public static <T> void assertEquals(T expected, T actual) {
        if (expected instanceof Object) {
            if (!expected.equals(actual))
                fail("Expected " + expected + " was " + actual);
        } else {
            if (expected != actual)
                fail("Expected " + expected + " was " + actual);
        }
    }

    public static void assertTrue(boolean expected) {
        assertEquals(true, expected);
    }

    public static void assertFalse(boolean expected) {
        assertEquals(false, expected);
    }

    private static void fail(String message) {
        throw new TestException(message);
    }
}
