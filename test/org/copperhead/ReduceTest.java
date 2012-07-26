package org.copperhead;

import org.copperhead.lambda.Reducer;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.Wrapper.enumerate;
import static org.copperhead.test.framework.TestAsserter.assertEquals;

public class ReduceTest {

    public void shouldReduceTheCollectionWithTheFunction() {
        List<String> strings = new ArrayList<String>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");

        String actual = enumerate(strings).reduce("", new Reducer<String,String>() { public String exec(String item, String prevResult) { return prevResult.concat(item); } });

        assertEquals("aabbcc", actual);
    }

    public void shouldAlsoBeKnownAsInject() {
        List<String> strings = new ArrayList<String>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");

        String actual = enumerate(strings).inject("", new Reducer<String, String>() {
            public String exec(String item, String prevResult) {
                return prevResult.concat(item);
            }
        });

        assertEquals("aabbcc", actual);
    }
}
