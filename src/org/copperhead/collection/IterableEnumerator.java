package org.copperhead.collection;

import org.copperhead.Enumerable;

import java.util.Iterator;

public class IterableEnumerator<T> extends Enumerable<T> {

    private final Iterator<T> iterator;
    private T current;

    public IterableEnumerator(Iterable<T> iterable) {
        this.iterator = iterable.iterator();
    }

    @Override
    public boolean moveNext() {
        if(iterator.hasNext()){
            current = iterator.next();
            return true;
        }
        else return false;
    }

    @Override
    public T current() {
        return current;
    }

}
