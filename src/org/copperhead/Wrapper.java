package org.copperhead;

public class Wrapper {
    public static <T> Enumerable<T> enumerate(java.lang.Iterable<T> list) {
        return new IterableEnumerator<T>(list);
    }
}
