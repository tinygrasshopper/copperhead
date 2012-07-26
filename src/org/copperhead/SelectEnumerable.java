package org.copperhead;

public class SelectEnumerable<T, V> extends Enumerable<V> {
    private final Enumerable<T> inner;
    private final Func<T, V> func;
    private V current;

    public SelectEnumerable(Enumerable<T> inner, Func<T, V> func) {
        this.inner = inner;
        this.func = func;
    }

    @Override
    boolean moveNext() {
        while(inner.moveNext()){
            current = func.exec(inner.current());
            return true;
        }
        return false;
    }

    @Override
    V current() {
        return current;
    }
}
