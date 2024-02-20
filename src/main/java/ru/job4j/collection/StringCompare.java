package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int compare = Integer.compare(left.length(), right.length());
        for (int index = 1; index < left.length() && index < right.length(); ++index) {
            int result = Character.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
                return result;
            }
        }
        return compare;
    }
}
