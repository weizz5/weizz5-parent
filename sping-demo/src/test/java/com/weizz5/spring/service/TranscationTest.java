package com.weizz5.spring.service;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/31
 */
public class TranscationTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01() throws SQLException {
        DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");

        System.out.println(dataSource.getConnection());

        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);

    }

    @Test
    public void test02() throws SQLException {
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();


    }

    @Test
    public void test03() throws SQLException {
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.checkout("zhangsan",1);
    }

}
