package org.copperhead;

public class ArrayEnumerator<T> extends Enumerable<T> {
    private T[] array;
    private int counter;

    public ArrayEnumerator(T[] array) {
        this.array = array;
        counter = -1;
    }

    @Override
    boolean moveNext() {
        return ++counter < array.length;
    }

    @Override
    T current() {
        return array[counter];
    }
}
