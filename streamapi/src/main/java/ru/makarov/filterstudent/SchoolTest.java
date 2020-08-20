package ru.makarov.filterstudent;

import java.util.Arrays;
import java.util.List;

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

        School schoolA = new School();
        List<Student> groupA = schoolA.collect(group, student -> (student.getScore() >= 70 && student.getScore() <= 100));
        List<Student> groupB = schoolA.collect(group, student -> (student.getScore() >= 50 && student.getScore() < 70));
        List<Student> groupC = schoolA.collect(group, student -> (student.getScore() >= 0 && student.getScore() < 50));

        groupA.stream()
                .map(student -> (student.getSurname() + " " + student.getScore() + " ;"))
                .forEach(System.out::print);

        System.out.println();

        groupB.stream()
                .map(student -> (student.getSurname() + " " + student.getScore() + " ;"))
                .forEach(System.out::print);
        System.out.println();

        groupC.stream()
                .map(student -> (student.getSurname() + " " + student.getScore() + " ;"))
                .forEach(System.out::print);
    }

}
