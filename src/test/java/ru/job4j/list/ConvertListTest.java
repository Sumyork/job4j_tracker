package ru.job4j.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ConvertListTest {
    @Test
    public void whenTwoList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1});
        list.add(new int[] {2, 3});
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenFourList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1});
        list.add(new int[] {4, 7, 12, 3});
        list.add(new int[] {2, 3});
        list.add(new int[] {0, 1, 5});
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expected = Arrays.asList(1, 4, 7, 12, 3, 2, 3, 0, 1, 5);
        assertThat(result).containsAll(expected);
    }
}