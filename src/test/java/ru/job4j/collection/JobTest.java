package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class JobTest {
    @Test
    public void whenComparatorAscByNameAndProperty() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndProperty() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Impl task", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndDeskPropertyAndDescNameLength() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority()
                .thenComparing(new JobDescByNameLength()));
        int result = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task1", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int result = cmpNamePriority.compare(
                new Job("Write test", 2),
                new Job("Reboot server", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByProperty() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int result = cmpNamePriority.compare(
                new Job("Write test", 1),
                new Job("Fix bug", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int result = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByProperty() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int result = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Reboot server", 2)
        );
        assertThat(result).isGreaterThan(0);
    }
}