package com.robert.data.repository;

import com.robert.data.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}
