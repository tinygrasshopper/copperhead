package org.copperhead;

import static org.copperhead.EnumeratorFactory.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestAsserter.assertTrue;
import static org.copperhead.test.framework.TestDataGenerator.arrayOfStrings;

public class TakeTest {
    public void shouldTakeTheSpecifiedNumberOfElementsFromTheEnumeration() {
        Enumerable<String> strings = enumerate(arrayOfStrings("a","b","c","x","y", "z"));

        strings=strings.take(3);
        assertTrue(strings.moveNext());
        assertEquals("a", strings.current());
        assertTrue(strings.moveNext());
        assertEquals("b", strings.current());
        assertTrue(strings.moveNext());
        assertEquals("c", strings.current());
        assertFalse(strings.moveNext());
    }

    public void shouldReturnFalseIfEnumerableEndsBeforeLimit(){
        Enumerable<String> strings = enumerate(arrayOfStrings("a","b"));
        strings=strings.take(3);
        assertTrue(strings.moveNext());
        assertEquals("a", strings.current());
        assertTrue(strings.moveNext());
        assertEquals("b", strings.current());
        assertFalse(strings.moveNext());
    }
}
