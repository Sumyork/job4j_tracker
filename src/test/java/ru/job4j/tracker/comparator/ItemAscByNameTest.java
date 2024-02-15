package ru.job4j.tracker.comparator;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemAscByNameTest {
    @Test
    void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "test3"),
                new Item(1, "test1"),
                new Item(2, "test2"),
                new Item(5, "test5"),
                new Item(4, "test4"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "test1"),
                new Item(2, "test2"),
                new Item(3, "test3"),
                new Item(4, "test4"),
                new Item(5, "test5"));
        assertThat(items).isEqualTo(expected);
    }
}