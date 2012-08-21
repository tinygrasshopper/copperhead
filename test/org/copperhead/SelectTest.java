package org.copperhead;


import org.copperhead.lambda.Map;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestAsserter.assertTrue;
import static org.copperhead.test.framework.TestDataGenerator.listOfStrings;

public class SelectTest {
    public void shouldProjectFromClass(){
        List<String> strings = listOfStrings("aaaa", "aaaaa", "aaaaaa");

        Enumerable<Integer> result = EnumeratorFactory.enumerate(strings)
                .select(new Map<String, Integer>() { public Integer exec(String p) { return new Integer(p.length()); }});

        assertTrue(result.moveNext());
        assertEquals(new Integer(4), result.current());

        assertTrue(result.moveNext());
        assertEquals(new Integer(5), result.current());

        assertTrue(result.moveNext());
        assertEquals(new Integer(6), result.current());


        assertFalse(result.moveNext());
    }

    public void shouldAlsoBeKnownAsMap(){
        List<String> strings = listOfStrings("aaaa", "aaaaa", "aaaaaa");

        Enumerable<Integer> result = EnumeratorFactory.enumerate(strings)
                .map(new Map<String, Integer>() {
                    public Integer exec(String p) {
                        return new Integer(p.length());
                    }
                });

        assertTrue(result.moveNext());
        assertEquals(new Integer(4), result.current());

        assertTrue(result.moveNext());
        assertEquals(new Integer(5), result.current());

        assertTrue(result.moveNext());
        assertEquals(new Integer(6), result.current());


        assertFalse(result.moveNext());
    }


}
