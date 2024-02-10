package ru.job4j.list;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expected = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void when3on3ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {4, 5, 8},
                {3, 0, 11},
                {-3, 4, 7}
        };
        List<Integer> expected = Arrays.asList(
                4, 5, 8, 3, 0, 11, -3, 4, 7
        );
        List<Integer> result = list.toList(input);
        assertThat(result).containsAll(expected);
    }
}