package org.copperhead;

import java.util.Iterator;

public abstract class Enumerable<T>  {
    public void remove() {
        throw new RuntimeException();
    }

    public Enumerable<T> where(Lambda<T> lambda) {
        return new WhereEnumerable<T>(this, lambda);
    }

    abstract boolean moveNext();

    abstract T current();
}
