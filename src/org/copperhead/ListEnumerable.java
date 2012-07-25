package org.copperhead;

import java.util.List;

public class ListEnumerable<T> extends Enumerable<T> {

    private final List<T> collection;
    private int current;

    public ListEnumerable(List<T> list) {
        this.collection = list;
        this.current = 0;
    }

    @Override
    public boolean moveNext() {
        return current < collection.size();
    }

    @Override
    public T current() {
        if (moveNext()) {
            return collection.get(this.current++);
        } else {
            return null;
        }
    }

}
