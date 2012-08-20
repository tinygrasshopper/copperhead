package org.copperhead;

import org.copperhead.collection.ArrayEnumerator;
import org.copperhead.collection.IterableEnumerator;

public class EnumeratorFactory {
    public static <T> Enumerable<T> enumerate(java.lang.Iterable<T> list) {
        return new IterableEnumerator<T>(list);
    }
    public static <T> Enumerable<T> enumerate(T[] array) {
        return new ArrayEnumerator<T>(array);
    }
}
