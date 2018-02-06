package com.robert.data.repository;

import com.robert.data.domain.Employee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup()");
    }

    @After
    public void release() {
        ctx = null;
        System.out.println("release()");
    }

    @Test
    public void findByName() {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee.toString());
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 23);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void findByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("test", 23);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void getEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee.toString());
    }

    @Test
    public void queryParam1() {
        List<Employee> employees = employeeRepository.queryParam1("test1", 20);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void queryParam2() {
        List<Employee> employees = employeeRepository.queryParam2("test1", 20);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void queryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void queryLike2() {
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void getCount() {
        System.out.println(employeeRepository.getCount());
    }
}