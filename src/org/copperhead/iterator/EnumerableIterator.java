package org.copperhead.iterator;

import org.copperhead.Enumerable;

import java.util.Iterator;

public class EnumerableIterator<T> implements Iterator<T> {
    private Enumerable<T> enumerable;

    public EnumerableIterator(Enumerable<T> enumerable) {
        this.enumerable = enumerable;
    }

    @Override
    public boolean hasNext() {
        return enumerable.moveNext();
    }

    @Override
    public T next() {
        return enumerable.current();
    }

    @Override
    public void remove() {
        throw new RuntimeException("Not implemented");
    }
}
