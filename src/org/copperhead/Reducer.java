package org.copperhead;

public interface Reducer<P, Q> {
    Q exec(P item,Q prevResult);
}
