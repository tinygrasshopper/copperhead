package org.copperhead.test.framework;
import org.copperhead.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jatinn
 * Date: 23/07/2012
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
public class TestRunner {
    public static void main(String[] args) throws Throwable{
        List<Class> classList = new ArrayList<Class>();
        classList.add(EnumerableTest.class);
        classList.add(WhereTest.class);
        classList.add(SelectTest.class);
        classList.add(ReduceTest.class);
        classList.add(SkipTest.class);
        classList.add(ConcatTest.class);
        classList.add(RangeTest.class);

        try {
            for (Class klass : classList) {
                if (klass.getName().endsWith("Test")) {
                    Object testClassInstance = klass.newInstance();
                    for (Method method : klass.getMethods()) {
                        if (method.getName().startsWith("should")) {
                            System.out.println(testClassInstance.getClass().getName()+ " " + method.getName());
                            method.invoke(testClassInstance);
                        }
                    }
                }
            }
            System.out.println("***************************");
            System.out.println("Success!!!");
            System.out.println("***************************");
        } catch (InvocationTargetException e) {
            System.out.println("---------------------------");
            if(e.getCause() instanceof TestException) {
                System.out.println("Assertion Error");
            }

            e.getCause().printStackTrace();
            System.out.println("---------------------------");

        }
    }
}
