package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 1),
                new Job("Impl task1", 1)
        );
        Comparator<Job> combine = new JobAscByName().thenComparing(new JobDescByPriority()
                .thenComparing(new JobDescByNameLength()));
        jobs.sort(combine);
        System.out.println(jobs);
    }
}
