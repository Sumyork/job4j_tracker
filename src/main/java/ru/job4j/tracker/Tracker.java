package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[10];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] copyItems = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null) {
                copyItems[index] = item;
            }
        }
        copyItems = Arrays.copyOf(copyItems, size);
        for (int index = 0; index < copyItems.length; index++) {
            System.out.println(copyItems[index]);
        }
        return copyItems;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
               result[index] = item;
               count++;
            }
        }
        result = Arrays.copyOf(result, count);
        for (int index = 0; index < result.length; index++) {
            System.out.println(result[index]);
        }
        return result;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}