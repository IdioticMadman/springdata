package com.robert.data.repository;

import com.robert.data.domain.Employee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeJpaRepositoryTest {


    private ApplicationContext ctx = null;
    private EmployeeJpaRepository jpaRepository;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        jpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup()");
    }

    @After
    public void release() {
        ctx = null;
        System.out.println("release()");
    }

    @Test
    public void testFilter() {

        //排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        //分页
        Pageable pageable = new PageRequest(0, 5, sort);
        //过滤条件
        Page<Employee> employeePage = jpaRepository.findAll(new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Integer> age = root.get("age");
                return cb.gt(age, 50);
            }
        }, pageable);
        long totalElements = employeePage.getTotalElements();
        int totalPages = employeePage.getTotalPages();
        int size = employeePage.getSize();
        int number = employeePage.getNumber();
        int numberOfElements = employeePage.getNumberOfElements();
        List<Employee> content = employeePage.getContent();
        System.out.println("总的页数：" + totalPages);
        System.out.println("总的条目数：" + totalElements);
        System.out.println("页面大小：" + size);
        System.out.println("当前页码：" + number);
        System.out.println("当前页码数据的条目数：" + numberOfElements);
        System.out.println("content：" + content);
    }
}