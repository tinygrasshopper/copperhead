package org.copperhead;

public interface Condition<T> {
    public boolean filter(T p);
}
