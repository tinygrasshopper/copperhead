package org.copperhead;

import org.copperhead.lambda.Reducer;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.EnumeratorFactory.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;
import static org.copperhead.test.framework.TestDataGenerator.listOfStrings;

public class ReduceTest {

    public void shouldReduceTheCollectionWithTheFunction() {
        List<String> strings = listOfStrings("aa", "bb", "cc");

        String actual = enumerate(strings).reduce("", new Reducer<String,String>() { public String exec(String item, String prevResult) { return prevResult.concat(item); } });

        assertEquals("aabbcc", actual);
    }

    public void shouldAlsoBeKnownAsInject() {
        List<String> strings = listOfStrings("aa", "bb", "cc");

        String actual = enumerate(strings).inject("", new Reducer<String, String>() {
            public String exec(String item, String prevResult) {
                return prevResult.concat(item);
            }
        });

        assertEquals("aabbcc", actual);
    }
}
