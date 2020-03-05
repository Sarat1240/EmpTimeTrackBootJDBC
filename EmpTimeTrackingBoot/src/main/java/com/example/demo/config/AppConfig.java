package com.example.demo.config;

import java.sql.SQLException;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.example.demo.service"),
@ComponentScan("com.example.demo.*") })
public class AppConfig {

	static JdbcTemplate jdbcTemplateObj;
    static SimpleDriverDataSource dataSourceObj;
 
    // Database Configuration Parameters
    static String DB_USERNAME = "root";
    static String DB_PASSWORD = "root";
    static String DB_URL = "jdbc:mysql://localhost:3306/emptimetrackingboot";
 
    public static SimpleDriverDataSource getDatabaseConnection()  {
        dataSourceObj = new SimpleDriverDataSource();
        try {           
            dataSourceObj.setDriver(new com.mysql.jdbc.Driver());
            dataSourceObj.setUrl(DB_URL);
            dataSourceObj.setUsername(DB_USERNAME);
            dataSourceObj.setPassword(DB_PASSWORD);
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return dataSourceObj;
    }
 }

