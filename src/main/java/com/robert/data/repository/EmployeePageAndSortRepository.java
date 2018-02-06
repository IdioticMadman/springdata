package com.robert.data.repository;

import com.robert.data.domain.Employee;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePageAndSortRepository extends PagingAndSortingRepository<Employee, Integer> {
}
