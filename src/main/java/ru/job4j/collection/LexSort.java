package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] wordsLeft = left.split("\\.");
        String[] rightLeft = right.split("\\.");
        Integer first = Integer.parseInt(wordsLeft[0]);
        Integer second = Integer.parseInt(rightLeft[0]);
        return first.compareTo(second);
    }
}
