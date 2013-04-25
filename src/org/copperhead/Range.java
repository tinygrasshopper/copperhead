package org.copperhead;

public class Range<T> {
    T start;

    private Range(T start) {
        this.start = start;
    }

    public static <T> Range<T> from(T start){
        return new Range<T>(start);
    }

    public Range
}
