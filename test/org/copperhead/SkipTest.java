package org.copperhead;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.Wrapper.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestAsserter.assertTrue;

public class SkipTest {
    public void shouldSkipAGivenNumberOfElements(){
        List<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");

        Enumerable<String> e = enumerate(strings).skip(2);
        e.moveNext();
        assertEquals("3", e.current());
        e.moveNext();
        assertEquals("4", e.current());

        e = e.skip(10);

        assertFalse(e.moveNext());
    }
}
