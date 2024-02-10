package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    HashSet<String> uniqueTasks = new HashSet<>();

    public HashSet<String> extractNumber(List<Task> tasks) {
        for (Task task : tasks) {
            uniqueTasks.add(task.getNumber());
        }
        return uniqueTasks;
    }
}
