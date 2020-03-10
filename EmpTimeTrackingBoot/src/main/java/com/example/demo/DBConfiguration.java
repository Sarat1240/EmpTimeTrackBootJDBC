package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfiguration {

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate();
	}
	
	  @Bean
	    public DataSource getDataSource()
	    {
	        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
	        dataSourceBuilder.url("jdbc:mysql://localhost:3306/emptimetrackingboot");
	        dataSourceBuilder.username("root");
	        dataSourceBuilder.password("admin");
	        return dataSourceBuilder.build();
	    }
	
}
