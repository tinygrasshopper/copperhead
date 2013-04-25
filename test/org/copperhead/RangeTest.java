package org.copperhead;

import static org.copperhead.test.framework.TestAsserter.assertEquals;

public class RangeTest {
    public void shouldGenerateARangeOfNumbers(){
        Enumerable<Integer> range = from(4).to(8);

        assertEquals(true, range.moveNext());
        assertEquals(4, range.current());

        assertEquals(true, range.moveNext());
        assertEquals(5, range.current());

        assertEquals(true, range.moveNext());
        assertEquals(6, range.current());

        assertEquals(true, range.moveNext());
        assertEquals(7, range.current());

        assertEquals(true, range.moveNext());
        assertEquals(8, range.current());

        assertEquals(false, range.moveNext());

    }
}
