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

    public void shouldReturnLast(){
        String[] strings = new String [3];
        strings[0] = "3";
        strings[1] = "2";
        strings[2] = "1";

        assertEquals("1", enumerate(strings).last());
    }

    public void shouldReturnLastSatisfingCondition(){
        Integer[] integers = new Integer [5];
        integers[0] = 1;
        integers[1] = 2;
        integers[2] = 3;
        integers[3] = 4;
        integers[4] = 5;

        assertEquals(4, enumerate(integers).last(new Condition<Integer>() {
            @Override
            public boolean exec(Integer p) {
                return p % 2 ==0;
            }
        }));
    }
    public void shouldReturnFirst(){
        String[] strings = new String [3];
        strings[0] = "3";
        strings[1] = "2";
        strings[2] = "1";

        assertEquals("3", enumerate(strings).first());
    }

    public void shouldReturnFirstSatisfingCondition(){
        Integer[] integers = new Integer [5];
        integers[0] = 1;
        integers[1] = 2;
        integers[2] = 3;
        integers[3] = 4;
        integers[4] = 5;

        assertEquals(2, enumerate(integers).first(new Condition<Integer>() {
            @Override
            public boolean exec(Integer p) {
                return p % 2 ==0;
            }
        }));
    }

}
