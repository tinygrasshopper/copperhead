package org.copperhead.lambda;

public interface Reducer<P, Q> {
    Q exec(P item,Q prevResult);
}
