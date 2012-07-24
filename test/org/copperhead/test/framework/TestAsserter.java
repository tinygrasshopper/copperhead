package org.copperhead.test.framework;

public class TestAsserter {
    public static <T> void assertEquals(T expected, T actual) {
        if (expected instanceof Object) {
            if (!expected.equals(actual))
                throw new TestException();
        } else {
            if(expected != actual)
                throw new TestException();
        }
    }
}
