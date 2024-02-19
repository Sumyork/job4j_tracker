package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int index = 0;
        while (index < Math.min(left.length(), right.length())) {
            int compareResult =  Integer.compare(left.charAt(index), right.charAt(index));
            if (compareResult != 0) {
                return compareResult;
            } else {
                index++;
            }
        }
        return left.length() - right.length();
    }
}
