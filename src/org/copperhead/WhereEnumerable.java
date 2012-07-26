package org.copperhead;

import org.copperhead.lambda.Condition;

public class WhereEnumerable<T> extends Enumerable<T> {
    private Enumerable<T> inner;
    private Condition<T> condition;
    private T current;

    public WhereEnumerable(Enumerable<T> inner, Condition<T> condition) {
        this.inner = inner;
        this.condition = condition;
    }

    @Override
    public boolean moveNext() {
        while(inner.moveNext()){
            current = inner.current();
            if(condition.exec(current))
                return true;
        }
        return false;
    }

    @Override
    public T current() {
        return current;
    }
}
