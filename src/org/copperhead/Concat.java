package org.copperhead;

public class Concat<T> extends Enumerable<T> {

    private final Enumerable<T> one;
    private final Enumerable<T> two;

    boolean oneComplete=false;

    public Concat(Enumerable<T> one, Enumerable<T> two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public boolean moveNext() {
        if (!oneComplete) {
            boolean oneCanMove = one.moveNext();
            if (oneCanMove)
                return true;
        }
        oneComplete = true;
        return two.moveNext();
    }

    @Override
    public T current() {
        if (!oneComplete) return one.current();
        else return two.current();
    }
}
