package ru.makarov.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Sample {
    public static void main(String[] args) {
        Student[] atts = {
                new Student("Vladimir", "rkt"),
                new Student("Alexandr", "rkt"),
                new Student("Vladislav", "rkt2")
        };

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int comp = o1.getName().compareTo(o2.getName());
                if (comp != 0) {    // names are different
                    return comp;
                }
                return comp;
            }
        };

        Arrays.sort(atts, comparator);

        Function<Student, Mark> func = new Function<Student, Mark>() {
            @Override
            public Mark apply(Student student) {
                return null;
            }
        };
    }

    public static void raw(List<Student> list, Function<Student, Mark> func) {
        for (Student att : list) {
            func.apply(att);
        }
    }
}
