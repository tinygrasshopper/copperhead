package org.copperhead;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jatinn
 * Date: 23/07/2012
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public class Wrapper {
    public static <T> Enumerable<T> Enumerate(List<T> list) {
        return new ListEnumerable<T>(list);
    }
}
