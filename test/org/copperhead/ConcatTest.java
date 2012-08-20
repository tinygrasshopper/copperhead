package org.copperhead;

import org.copperhead.test.framework.TestAsserter;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.Wrapper.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertTrue;

public class ConcatTest {
    public void shouldConcatTwoEnumerables() {
        String[] strings = new String[3];
        strings[0] = "1";
        strings[1] = "2";
        strings[2] = "3";

        List<String> strings2 = new ArrayList<String>();
        strings2.add("1");
        strings2.add("2");
        strings2.add("3");

        Enumerable<String> concated = enumerate(strings).concat(enumerate(strings2));

        assertTrue(concated.moveNext());
        assertEquals("1", concated.current());
        assertTrue(concated.moveNext());
        assertEquals("2", concated.current());
        assertTrue(concated.moveNext());
        assertEquals("3", concated.current());
        assertTrue(concated.moveNext());
        assertEquals("1", concated.current());
        assertTrue(concated.moveNext());
        assertEquals("2", concated.current());
        assertTrue(concated.moveNext());
        assertEquals("3", concated.current());


    }
}
