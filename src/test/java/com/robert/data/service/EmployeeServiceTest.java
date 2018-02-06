package com.robert.data.service;

import com.robert.data.domain.Employee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTest {
    private ApplicationContext ctx = null;
    private EmployeeService employeeService;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup()");
    }

    @After
    public void release() {
        ctx = null;
        System.out.println("release()");
    }


    @Test
    public void update() {
        employeeService.update(1, 50);
    }

    @Test
    public void saveAll() {
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setAge(100 - i);
            employee.setName("test" + i);
            employees.add(employee);
        }
        employeeService.saveAll(employees);
    }
}