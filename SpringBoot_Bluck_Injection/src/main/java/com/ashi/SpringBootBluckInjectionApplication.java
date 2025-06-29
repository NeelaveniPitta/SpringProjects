package com.ashi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.ashi.model.Employee;

@SpringBootApplication
//@PropertySource("classpath:employee.properties")
public class SpringBootBluckInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootBluckInjectionApplication.class, args);
		
		
		  Employee emp = context.getBean(Employee.class);
		  System.out.println(emp);
	}

}
