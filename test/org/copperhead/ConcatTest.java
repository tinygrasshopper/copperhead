package org.copperhead;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.EnumeratorFactory.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertTrue;
import static org.copperhead.test.framework.TestDataGenerator.arrayOfStrings;
import static org.copperhead.test.framework.TestDataGenerator.listOfStrings;

public class ConcatTest {
    public void shouldConcatTwoEnumerables() {
        String[] strings = arrayOfStrings(1,3);

        List<String> strings2 = listOfStrings(1,3);

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
