package org.copperhead;

import org.copperhead.iterator.EnumerableIterator;
import org.copperhead.lambda.Condition;
import org.copperhead.lambda.Map;
import org.copperhead.lambda.Reducer;

public abstract class Enumerable<T> implements Iterable<T>  {
    public abstract boolean moveNext();

    public abstract T current();

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

    public boolean all(Condition<T> condition){
        for(T item: this)
            if(!condition.exec(item))
                return false;
        return true;
    }

    public boolean any(Condition<T> condition){
        for(T item: this)
            if(condition.exec(item))
                return true;
        return false;
    }

    public T last() {
        return this.last(new Condition<T>() {
           public boolean exec(T p) {
                return true;
            }
        });
    }

    public T last(Condition<T> condition) {
        T lastValidItem = null;
        for(T item: this)
            if(condition.exec(item))
                lastValidItem = item;
        return lastValidItem;
    }

    public T first() {
        return this.first(new Condition<T>() {
            public boolean exec(T p) {
                return true;
            }
        });
    }

    public T first(Condition<T> condition) {
        for(T item: this)
            if(condition.exec(item))
                return item;
        return null;
    }

    public SkipEnumerable<T> skip(int count) {
        return new SkipEnumerable<T>(this, count);
    }


}
