package ru.makarov.streamapiimprove;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> String.valueOf(right.getScore()).compareTo(String.valueOf(left.getScore())))
                .takeWhile(student -> student.getScore() > bound )
                .collect(Collectors.toList());
    }
}
