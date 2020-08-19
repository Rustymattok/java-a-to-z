package ru.makarov.filterstudent;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    private List<Student> students;

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter((predict))
                .collect(Collectors.toList());
    }
}
