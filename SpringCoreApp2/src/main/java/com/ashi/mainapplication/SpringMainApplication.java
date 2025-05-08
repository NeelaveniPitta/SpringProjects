package com.ashi.mainapplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ashi.entities.Employee;

public class SpringMainApplication {
	
	public static void main(String[] args) {
		
	   ApplicationContext context = new FileSystemXmlApplicationContext("S:\\gitLocalRepo\\SpringProjects\\SpringCoreApp2\\ApplicationContext.xml");
		 
		
		//Singleton objects => default scope of Spring Bean in IOC container is Singleton
		 Employee employee = context.getBean("emp",Employee.class);
		
		 //Employee employee1 = context.getBean("emp",Employee.class);
		 
		 System.out.println(employee);
		 
		 //System.out.println(employee1);
		 
		 
		 
		 
		 
		 
		
	}
	
}
