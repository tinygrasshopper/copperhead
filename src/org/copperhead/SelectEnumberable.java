package org.copperhead;

public class SelectEnumberable<T, V> extends Enumerable<V> {
    private final Enumerable<T> inner;
    private final Proc<T, V> proc;
    private V current;

    public SelectEnumberable(Enumerable<T> inner, Proc<T, V> proc) {
        this.inner = inner;
        this.proc = proc;
    }

    @Override
    boolean moveNext() {
        while(inner.moveNext()){
            current = proc.map(inner.current());
            return true;
        }
        return false;
    }

    @Override
    V current() {
        return current;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
