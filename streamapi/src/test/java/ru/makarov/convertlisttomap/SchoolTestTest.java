package ru.makarov.convertlisttomap;

import org.junit.Assert;
import org.junit.Test;
import ru.makarov.filterstudent.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SchoolTestTest {

    @Test
    public void collector() {
        List<Student> group = Arrays.asList(
                new Student("Makarov", 100),
                new Student("Ivanov1", 60),
                new Student("Ivanov2", 80),
                new Student("Makarov", 50),
                new Student("Ivanov4", 20),
                new Student("Ivanov5", 70),
                new Student("Ivanov6", 10),
                new Student("Makarov", 35)
        );
        Map<String, Student> groupStudent = group.stream().collect(SchoolTest.collector());
        Assert.assertEquals(groupStudent.get("Makarov").getScore(), 100);
    }
}