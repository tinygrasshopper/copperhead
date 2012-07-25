package org.copperhead;

public abstract class Enumerable<T>  {
    public void remove() {
        throw new RuntimeException();
    }

    public Enumerable<T> where(Condition<T> condition) {
        return new WhereEnumerable<T>(this, condition);
    }

    abstract boolean moveNext();

    abstract T current();

    public <V> Enumerable<V> select(Proc<T,V> proc) {
        return new SelectEnumberable<T,V>(this, proc);
    }
}
