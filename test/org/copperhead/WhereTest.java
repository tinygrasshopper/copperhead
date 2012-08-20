package org.copperhead;

import org.copperhead.lambda.Condition;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.EnumeratorFactory.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestAsserter.assertTrue;

public class WhereTest {

    public void shouldFilterUsingWhere() {
        List<String> strings = new ArrayList<String>();
        strings.add("one1");
        strings.add("two1");
        strings.add("three2");

        Enumerable<String> val =  enumerate(strings)
                .where(new Condition<String>() {
                    public boolean exec(String p) {
                        return p.endsWith("1");
                    }
                })
                .where(new Condition<String>() { public boolean exec(String p) { return p.endsWith("1");}});

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

        Enumerable<String> val =  enumerate(strings)
                .where(new Condition<String>() { public boolean exec(String p) { return p.endsWith("1");}})
                .where(new Condition<String>() { public boolean exec(String p) { return p.startsWith("o");}});

        assertTrue(val.moveNext());
        assertEquals("one1", val.current());
        assertFalse(val.moveNext());
    }
}
