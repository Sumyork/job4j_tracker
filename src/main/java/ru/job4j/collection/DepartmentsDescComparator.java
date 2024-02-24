package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = Character.compare(right.charAt(1), left.charAt(1));
        if (result != 0) {
            return result;
        } else {
            for (int index = 2; index < Math.min(left.length(), right.length()); index++) {
                result = Character.compare(left.charAt(index), right.charAt(index));
                if (result != 0) {
                    return result;
                }
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
