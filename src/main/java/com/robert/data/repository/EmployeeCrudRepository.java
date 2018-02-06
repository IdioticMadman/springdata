package com.robert.data.repository;

import com.robert.data.domain.Employee;

import org.springframework.data.repository.CrudRepository;

/**
 * CRUD操作
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {
}
