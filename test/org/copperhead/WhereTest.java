package org.copperhead;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestAsserter.assertTrue;

public class WhereTest {

    public void shouldFilterUsingWhere() {
        List<String> strings = new ArrayList<String>();
        strings.add("one1");
        strings.add("two1");
        strings.add("three2");

        Enumerable<String> val =  Wrapper.Enumerate(strings)
                .where(new Lambda<String>() { public boolean filter(String p) { return p.endsWith("1");}});

        assertTrue(val.moveNext());
        assertEquals("one1", val.current());
        assertTrue(val.moveNext());
        assertEquals("two1", val.current());
        assertFalse(val.moveNext());
    }
    public void shouldChainWhere() {
        List<String> strings = new ArrayList<String>();
        strings.add("one1");
        strings.add("two1");
        strings.add("three2");

        Enumerable<String> val =  Wrapper.Enumerate(strings)
                .where(new Lambda<String>() { public boolean filter(String p) { return p.endsWith("1");}})
                .where(new Lambda<String>() { public boolean filter(String p) { return p.startsWith("o");}});

        assertTrue(val.moveNext());
        assertEquals("one1", val.current());
        assertFalse(val.moveNext());
    }
}
