package com.ashi;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ashi.entities.Employee;

@SpringBootApplication
//@Configuration
//@ComponetScan("com.ashi")
public class SpringBootApp2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootApp2Application.class, args);
		//contect.register(SpringBootApp2Application.class);
		
		//i need print all the springBeans in the IOC container 
		
		Arrays.stream(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);
		
		
	}

//    @Bean("emp")
//    Employee getEmployee() {
//		return new Employee();
//	}
//	
//	

}
