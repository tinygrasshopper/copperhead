package org.copperhead;

public class TakeEnumerable<T> extends Enumerable<T> {
    private final Enumerable<T> enumerable;
    private final int limit;
    private int counter = 0;

    public TakeEnumerable(Enumerable<T> enumerable, int limit) {
        this.enumerable = enumerable;

        this.limit = limit;
    }

    @Override
    public boolean moveNext() {
        if(counter++ > limit)
            return false;
        else return this.enumerable.moveNext();
    }

    @Override
    public T current() {
        return enumerable.current();
    }
}
