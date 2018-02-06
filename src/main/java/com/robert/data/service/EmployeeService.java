package com.robert.data.service;

import com.robert.data.domain.Employee;
import com.robert.data.repository.EmployeeCrudRepository;
import com.robert.data.repository.EmployeePageAndSortRepository;
import com.robert.data.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeCrudRepository employeeCrudRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           EmployeeCrudRepository employeeCrudRepository,
                           EmployeePageAndSortRepository employeePageAndSortRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCrudRepository = employeeCrudRepository;
    }

    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }

    @Transactional
    public void saveAll(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }
}
