package ru.makarov.convertlisttomap;

import ru.makarov.filterstudent.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
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
                new Student("Makarov", 35)
        );
        Map<String, Student> groupMap = group.stream().collect(collector());
    }

    public static BinaryOperator<Student> dublicate() {
        return (a, b) -> {
            System.out.println("found dublicate - return first");
            return a;
        };
    }

    public static Collector<Student, ?, Map<String,Student>>  collector(){
        return Collectors.toMap(
                Student::getSurname,
                e -> e,
                dublicate()
        );
    }
}
