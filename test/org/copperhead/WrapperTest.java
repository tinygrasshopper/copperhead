package org.copperhead;

import java.util.ArrayList;
import java.util.List;

import static org.copperhead.test.framework.TestAsserter.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jatinn
 * Date: 23/07/2012
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class WrapperTest {
    public void shouldReturnWrapperOverIteratable() {
        List<String> strings = new ArrayList<String>();
        strings.add("3");
        strings.add("2");
        strings.add("1");

        Enumeratable<String> enumerate = Wrapper.Enumerate(strings);

        assertEquals(true, enumerate.hasNext());
        assertEquals("3", enumerate.next());

        assertEquals(true, enumerate.hasNext());
        assertEquals("2", enumerate.next());

        assertEquals(true, enumerate.hasNext());
        assertEquals("1", enumerate.next());

        assertEquals(false, enumerate.hasNext());
    }

}
