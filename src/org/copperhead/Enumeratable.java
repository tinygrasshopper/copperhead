package org.copperhead;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jatinn
 * Date: 23/07/2012
 * Time: 18:45
 * To change this template use File | Settings | File Templates.
 */
public class Enumeratable<T> implements Iterator<T> {

    private final List<T> collection;
    private int current;

    public Enumeratable(List<T> list) {
        this.collection = list;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return current < collection.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return collection.get(this.current++);
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new RuntimeException();
    }
}
