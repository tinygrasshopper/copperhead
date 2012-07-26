package org.copperhead.lambda;

public interface Condition<T> {
    public boolean exec(T p);
}
