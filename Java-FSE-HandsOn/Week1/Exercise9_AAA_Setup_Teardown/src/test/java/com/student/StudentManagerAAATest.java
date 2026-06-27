package com.student;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class StudentManagerAAATest {

    StudentManager manager;

    
    @Before
    public void setUp() {
        manager = new StudentManager();
        System.out.println("Setup completed");
    }

   
    @Test
    public void testAddStudent() {

       
        Student s1 = new Student("Prasanna", 95);

       
        manager.addStudent(s1);

       
        assertEquals(1, manager.getStudentCount());
    }

   
    @After
    public void tearDown() {
        manager = null;
        System.out.println("Teardown completed");
    }
}