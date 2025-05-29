package com.ashi;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ashi.entities.Moter;

public class SpringMainApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		// ApplicationContext context = new
		// FileSystemXmlApplicationContext("E:\\gitLocalRepo\\SpringProjects\\SpringBean_lifecycles\\ApplicationContext.xml");

		// Arrays.stream(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);
		Moter moter = context.getBean("moter", Moter.class);
		moter.doWork();
		
		//closing ioc continer the only predistory works
		context.close();
		
	}
}
