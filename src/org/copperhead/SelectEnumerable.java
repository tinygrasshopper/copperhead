package org.copperhead;

import org.copperhead.lambda.Map;

public class SelectEnumerable<T, V> extends Enumerable<V> {
    private final Enumerable<T> inner;
    private final Map<T, V> map;
    private V current;

    public SelectEnumerable(Enumerable<T> inner, Map<T, V> map) {
        this.inner = inner;
        this.map = map;
    }

    @Override
    public boolean moveNext() {
        while(inner.moveNext()){
            current = map.exec(inner.current());
            return true;
        }
        return false;
    }

    @Override
    public V current() {
        return current;
    }
}
