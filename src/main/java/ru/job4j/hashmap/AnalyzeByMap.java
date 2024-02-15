package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double averageScoreOfAllPupils = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                averageScoreOfAllPupils += subject.score();
                count++;
            }
        }
        return averageScoreOfAllPupils / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double averageScoreOfPupil = 0;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                averageScoreOfPupil += subject.score();
            }
            labels.add(new Label(pupil.name(), averageScoreOfPupil / subjects.size()));
            averageScoreOfPupil = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> gradesBySubject = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                gradesBySubject.put(subject.name(), gradesBySubject.getOrDefault(subject.name(),  0) + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : gradesBySubject.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double averageScoreOfPupil = 0;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                averageScoreOfPupil += subject.score();
            }
            labels.add(new Label(pupil.name(), averageScoreOfPupil));
            averageScoreOfPupil = 0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> gradesBySubject = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                gradesBySubject.put(subject.name(), gradesBySubject.getOrDefault(subject.name(),  0) + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : gradesBySubject.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
