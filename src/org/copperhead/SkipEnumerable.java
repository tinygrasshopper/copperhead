package org.copperhead;

public class SkipEnumerable<T> extends Enumerable<T>{
    private final Enumerable<T> inner;
    private final int skipBy;
    private boolean skippedElements;

    public SkipEnumerable(Enumerable<T> inner, int skipBy) {
        this.inner = inner;
        this.skipBy = skipBy;
        this.skippedElements = false;
    }

    @Override
    public boolean moveNext() {
        int counter = 0;
        while (counter++ < skipBy && !skippedElements)
            if(!inner.moveNext())
                return false;
        this.skippedElements = true;
        return inner.moveNext();
    }

    @Override
    public T current() {
        return inner.current();
    }
}
