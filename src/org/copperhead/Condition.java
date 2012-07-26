package org.copperhead;

public interface Condition<T> {
    public boolean exec(T p);
}
