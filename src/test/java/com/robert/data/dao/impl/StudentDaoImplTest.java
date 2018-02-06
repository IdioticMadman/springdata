package com.robert.data.dao.impl;

import com.robert.data.dao.StudentDao;
import com.robert.data.domain.Student;

import org.junit.Test;

import java.util.List;

public class StudentDaoImplTest {

    @Test
    public void query() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> query = studentDao.query();
        for (Student student : query) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void save() {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(30);
        studentDao.save(student);
    }
}