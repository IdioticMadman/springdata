package com.robert.data.dao.impl;

import com.robert.data.dao.StudentDao;
import com.robert.data.domain.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentDaoSpringImplTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup()");
    }

    @After
    public void release() {
        ctx = null;
        System.out.println("release()");
    }

    @Test
    public void query() {
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        List<Student> query = dao.query();
        for (Student student : query) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void save() {
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setName("jdbc");
        student.setAge(40);
        dao.save(student);
    }
}