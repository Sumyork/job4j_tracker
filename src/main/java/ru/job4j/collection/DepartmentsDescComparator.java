package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftElements = left.split("/");
        String[] rightElements = right.split("/");
        int result = rightElements[0].compareTo(leftElements[0]);
        if (result == 0) {
            for (int index = 1; index < Math.min(leftElements.length, rightElements.length); index++) {
                result = leftElements[index].compareTo(rightElements[index]);
                if (result != 0) {
                    return result;
                }
            }
        } else {
            return result;
        }
        return Integer.compare(left.length(), right.length());
    }
}
