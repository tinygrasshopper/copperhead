package org.copperhead;

import com.sun.xml.internal.ws.server.StatefulInstanceResolver;
import org.copperhead.lambda.Condition;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.Wrapper.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestAsserter.assertTrue;

public class EnumerableTest {
    public void shouldReturnWrapperOverIteratable() {
        List<String> strings = someStrings();

        Enumerable<String> enumerate = enumerate(strings);

        assertTrue(enumerate.moveNext());
        assertEquals("3", enumerate.current());

        assertTrue(enumerate.moveNext());
        assertEquals("2", enumerate.current());

        assertTrue(enumerate.moveNext());
        assertEquals("1", enumerate.current());

        assertFalse(enumerate.moveNext());
    }

    private List<String> someStrings() {
        List<String> strings = new ArrayList<String>();
        strings.add("3");
        strings.add("2");
        strings.add("1");
        return strings;
    }

    public void shouldWorkWithForEach(){
        List<String> strings = someStrings();
        Enumerable<String> enumerate = enumerate(strings);

        int counter = 3;
        for(String string:enumerate){
            assertEquals(String.valueOf(counter--),string);
        }
    }

    public void shouldWorkWithArrays(){
        String[] strings = new String [3];
        strings[0] = "3";
        strings[1] = "2";
        strings[2] = "1";
        Enumerable<String> enumerate = enumerate(strings);

        assertTrue(enumerate.moveNext());
        assertEquals("3", enumerate.current());

        assertTrue(enumerate.moveNext());
        assertEquals("2", enumerate.current());

        assertTrue(enumerate.moveNext());
        assertEquals("1", enumerate.current());

        assertFalse(enumerate.moveNext());
    }

    public void shouldCheckIfConditionTrueForAll(){
        String[] strings = new String [3];
        strings[0] = "3";
        strings[1] = "2";
        strings[2] = "1";

        assertTrue(enumerate(strings).all(new Condition<String>() { public boolean exec(String p) { return p.length() == 1;}}));
        assertTrue(enumerate(strings).any(new Condition<String>() { public boolean exec(String p) { return p == "1";}}));

        assertFalse(enumerate(strings).any(new Condition<String>() { public boolean exec(String p) { return p == "4";}}));
        assertFalse(enumerate(strings).all(new Condition<String>() { public boolean exec(String p) { return p == "1";}}));
    }

}
