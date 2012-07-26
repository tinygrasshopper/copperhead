package org.copperhead.collection;

import org.copperhead.Enumerable;

public class ArrayEnumerator<T> extends Enumerable<T> {
    private T[] array;
    private int counter;

    public ArrayEnumerator(T[] array) {
        this.array = array;
        counter = -1;
    }

    @Override
    public boolean moveNext() {
        return ++counter < array.length;
    }

    @Override
    public T current() {
        return array[counter];
    }
}
