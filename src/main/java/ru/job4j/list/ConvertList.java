package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] numbers : list) {
            for (int number : numbers) {
                result.add(number);
            }
        }
        return result;
    }
}
