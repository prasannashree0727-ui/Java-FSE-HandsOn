package com.student;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StudentManagerTest {

    @Test
    public void testAddStudent() {
        StudentManager manager = new StudentManager();

        Student s1 = new Student("Prasanna", 90);
        manager.addStudent(s1);

        assertEquals(1, manager.getStudentCount());
    }
}