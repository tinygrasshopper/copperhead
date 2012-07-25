package org.copperhead;

public class WhereEnumerable<T> extends Enumerable<T> {
    private Enumerable<T> inner;
    private Lambda<T> condition;
    private T current;

    public WhereEnumerable(Enumerable<T> inner, Lambda<T> condition) {
        this.inner = inner;
        this.condition = condition;
    }

    @Override
    public boolean moveNext() {
        while(inner.moveNext()){
            current = inner.current();
            if(condition.filter(current))
                return true;
        }
        return false;
    }

    @Override
    public T current() {
        return current;
    }
}
