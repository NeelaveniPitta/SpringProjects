package com.ashi;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootProfiles1Application {

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootProfiles1Application.class, args);
		
		DBConnection conn = context.getBean(DBConnection.class);
		System.out.println(conn.getDBinfo());
		
	}

}
