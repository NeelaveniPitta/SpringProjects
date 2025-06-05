package com.ashi;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ashi.databaseconnection.DBConnect;
import com.ashi.databaseconnection.OracleConnection;
import com.ashi.repository.StudentRepository;

@SpringBootApplication
public class SpringBootApp3Application {

	@Autowired
	private DBConnect connect;
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootApp3Application.class, args);
		
//		OracleConnection orcl = context.getBean("orcl",OracleConnection.class);
//		
//		Connection connection = orcl.getConnection();
//		System.out.println("connection obj "+connection);
		
		/*
		 * DataSource ds = context.getBean("dataSource",DataSource.class); try {
		 * Connection connection = ds.getConnection();
		 * System.out.println("connection object :"+connection); } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		
		StudentRepository repo = context.getBean("std",StudentRepository.class);
		
		System.out.println("students list :");
		try {
			System.out.println(repo.getAllStduents());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
     //DataSource
	 @Bean
     DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(connect.getDriverClass());
        ds.setUrl(connect.getUrl());
        ds.setUsername(connect.getUsername());
        ds.setPassword(connect.getPassword());
        return ds;
    }
	

}
