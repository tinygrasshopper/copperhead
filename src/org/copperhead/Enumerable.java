package org.copperhead;

public abstract class Enumerable<T> implements Iterable<T>  {
    abstract boolean moveNext();

    abstract T current();

    public <V> Enumerable<V> select(Map<T,V> map) {
        return new SelectEnumerable<T,V>(this, map);
    }
    public <V> Enumerable<V> map(Map<T,V> map) {
        return new SelectEnumerable<T,V>(this, map);
    }

    public Enumerable<T> where(Condition<T> condition) {
        return new WhereEnumerable<T>(this, condition);
    }

    public java.util.Iterator<T> iterator(){
        return new EnumerableIterator<T>(this);
    }

    public <Q> Q inject(Q seed, Reducer<T,Q> reducer) {
        return reduce(seed, reducer);
    }

    public <Q> Q reduce(Q seed, Reducer<T,Q> reducer) {
        Q result = seed;
        for(T item: this)
            result = reducer.exec(item, result);
        return result;
    }
}
