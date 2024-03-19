package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0.0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(element -> new Tuple(element.name(), element.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0.0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(
                                Subject::name,
                                Collectors.averagingDouble(Subject::score)
                        )
                );
        return map.entrySet()
                .stream()
                .map(element -> new Tuple(element.getKey(), element.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(element -> new Tuple(element.name(), element.subjects().stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(
                                Subject::name,
                                Collectors.summingDouble(Subject::score)
                        )
                );
        return map.entrySet()
                .stream()
                .map(element -> new Tuple(element.getKey(), element.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }
}
