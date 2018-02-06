package com.robert.data.repository;

import com.robert.data.domain.Employee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

//public interface EmployeeRepository extends Repository<Employee, Integer> {
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {
    Employee findByName(String name);

    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    /**
     * 查询最大的Id对应的员工
     *
     * @return
     */
    @Query("select o from Employee o where id = (select max(id) from Employee)")
    Employee getEmployeeByMaxId();

    /**
     * 根据姓名和年龄查询，占位符下标
     *
     * @param name
     * @param age
     * @return
     */
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    List<Employee> queryParam1(String name, Integer age);

    /**
     * 根据姓名和年龄查询，占位符索引
     *
     * @param name
     * @param age
     * @return
     */
    @Query("select e from Employee e where e.name=:name and e.age=:age ")
    List<Employee> queryParam2(@Param("name") String name, @Param("age") Integer age);

    /**
     * 根据名字模糊查询，下标
     *
     * @param name
     * @return
     */
    @Query("select e from Employee e where e.name like %?1%")
    List<Employee> queryLike1(String name);

    /**
     * 根据名字模糊查询，索引
     *
     * @param name
     * @return
     */
    @Query("select e from Employee e where e.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    /**
     * 通过sql查询数量
     *
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT COUNT(1) FROM employee")
    long getCount();

    @Modifying
    @Query("update Employee e set e.age = :age where e.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);
}
