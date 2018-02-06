package com.robert.data.dao.impl;

import com.robert.data.dao.StudentDao;
import com.robert.data.domain.Student;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoSpringImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> query() {
        String sql = "SELECT id, name, age FROM student";
        final List<Student> students = new ArrayList<Student>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                students.add(Student.create(id, name, age));
            }
        });
        return students;
    }

    public void save(Student student) {
        String sql = "INSERT INTO student(name,age) VALUE(?,?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge());
    }
}
