package ru.makarov.convertlisttomap;

import ru.makarov.filterstudent.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SchoolTest {
    public static void main(String[] args) {
        List<Student> group = Arrays.asList(
                new Student("Makarov", 100),
                new Student("Ivanov1", 60),
                new Student("Ivanov2", 80),
                new Student("Ivanov3", 50),
                new Student("Ivanov4", 20),
                new Student("Ivanov5", 70),
                new Student("Ivanov6", 10),
                new Student("Ivanov7", 35)
        );

        Map<String, Student> groupMap = group.stream().distinct().collect(Collectors.toMap(
                Student::getSurname,
                e -> e
        ));
    }
}
