package org.copperhead;

public abstract class Enumerable<T> implements Iterable<T>  {
    public Enumerable<T> where(Condition<T> condition) {
        return new WhereEnumerable<T>(this, condition);
    }

    abstract boolean moveNext();

    abstract T current();

    public <V> Enumerable<V> select(Func<T,V> func) {
        return new SelectEnumerable<T,V>(this, func);
    }

    public java.util.Iterator<T> iterator(){
        return new EnumerableIterator<T>(this);
    }
}
