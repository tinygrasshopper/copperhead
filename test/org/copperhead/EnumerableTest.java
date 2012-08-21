package org.copperhead;

import org.copperhead.lambda.Condition;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.EnumeratorFactory.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestAsserter.assertFalse;
import static org.copperhead.test.framework.TestAsserter.assertTrue;
import static org.copperhead.test.framework.TestDataGenerator.arrayOfInts;
import static org.copperhead.test.framework.TestDataGenerator.arrayOfStrings;

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
        String[] strings = arrayOfStrings("3", "2", "1");
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
        String[] strings = arrayOfStrings("3", "2", "1");

        assertTrue(enumerate(strings).all(new Condition<String>() { public boolean exec(String p) { return p.length() == 1;}}));
        assertTrue(enumerate(strings).any(new Condition<String>() { public boolean exec(String p) { return p == "1";}}));

        assertFalse(enumerate(strings).any(new Condition<String>() { public boolean exec(String p) { return p == "4";}}));
        assertFalse(enumerate(strings).all(new Condition<String>() { public boolean exec(String p) { return p == "1";}}));
    }

    public void shouldReturnLast(){
        String[] strings = arrayOfStrings("3", "2", "1");

        assertEquals("1", enumerate(strings).last());
    }

    public void shouldReturnLastSatisfingCondition(){
        Integer[] integers = arrayOfInts(1,5);

        assertEquals(4, enumerate(integers).last(new Condition<Integer>() {
            @Override
            public boolean exec(Integer p) {
                return p % 2 ==0;
            }
        }));
    }
    public void shouldReturnFirst(){
        String[] strings = arrayOfStrings("3", "2", "1");

        assertEquals("3", enumerate(strings).first());
    }

    public void shouldReturnFirstSatisfingCondition(){
        Integer[] integers = arrayOfInts(1,5);

        assertEquals(2, enumerate(integers).first(new Condition<Integer>() {
            @Override
            public boolean exec(Integer p) {
                return p % 2 ==0;
            }
        }));
    }

}
