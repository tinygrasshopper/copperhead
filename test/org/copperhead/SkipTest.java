package org.copperhead;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.EnumeratorFactory.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestDataGenerator.listOfStrings;

public class SkipTest {
    public void shouldSkipAGivenNumberOfElements(){
        List<String> strings = listOfStrings(1, 5);

        Enumerable<String> e = enumerate(strings).skip(2);
        e.moveNext();
        assertEquals("3", e.current());
        e.moveNext();
        assertEquals("4", e.current());

        e = e.skip(10);

        assertFalse(e.moveNext());
    }
}
