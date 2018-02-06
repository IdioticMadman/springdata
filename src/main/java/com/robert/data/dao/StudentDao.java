package com.robert.data.dao;

import com.robert.data.domain.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有学生
     *
     * @return
     */
    List<Student> query();

    /**
     * 保存学生
     *
     * @param student
     */
    void save(Student student);
}
