package org.copperhead.collection;

import org.copperhead.Enumerable;

import java.util.Iterator;

public class IterableEnumerator<T> extends Enumerable<T> {

    private final Iterator<T> iterator;

    public IterableEnumerator(Iterable<T> iterable) {
        this.iterator = iterable.iterator();
    }

    @Override
    public boolean moveNext() {
        return iterator.hasNext();
    }

    @Override
    public T current() {
        if (moveNext()) {
            return iterator.next();
        } else {
            return null;
        }
    }

}
