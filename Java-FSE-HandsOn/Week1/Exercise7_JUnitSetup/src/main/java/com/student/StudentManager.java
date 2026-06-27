package com.student;

import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public int getStudentCount() {
        return students.size();
    }
}