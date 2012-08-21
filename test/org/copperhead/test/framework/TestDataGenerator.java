package org.copperhead.test.framework;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    public static List<String> listOfStrings(int start, int end) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i <= end - start; i++) {

            strings.add(String.valueOf(start + i));
        }
        return strings;
    }

    public static String[] arrayOfStrings(int start, int end) {
        String[] strings = new String[end - start + 1];
        for (int i = 0; i <= end - start; i++) {
            strings[i] = String.valueOf(start + i);
        }
        return strings;
    }

    public static Integer[] arrayOfInts(int start, int end) {
        Integer[] ints = new Integer[end - start + 1];
        for (int i = 0; i <= end - start; i++) {
            ints[i] = start + i;
        }
        return ints;
    }

    public static String[] arrayOfStrings(String... strings)   {
        return strings;
    }

    public static ArrayList<String> listOfStrings(String... strings)   {
        ArrayList<String> sl = new ArrayList<String>();
        for (String string : strings) {
            sl.add(string);
        };
        return sl;
    }

}
