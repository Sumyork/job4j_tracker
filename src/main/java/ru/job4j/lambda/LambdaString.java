package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaString {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(
                "hello",
                "hello123",
                "good",
                "goodDay"
        );
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        stringList.sort(comparatorText);
        System.out.println(stringList);
        stringList.sort(comparatorDescSize);
        System.out.println(stringList);
    }
}
