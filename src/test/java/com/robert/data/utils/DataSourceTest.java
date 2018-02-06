package com.robert.data.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataSourceTest {
    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup()");
    }

    @After
    public void release() {
        ctx = null;
        System.out.println("release()");
    }

    @Test
    public void testDataSource() {
        System.out.println("testDataSource()");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println("jdbcTemplate()");
        JdbcTemplate dataSource = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(dataSource);
    }

}
