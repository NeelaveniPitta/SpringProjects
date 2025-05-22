package com.ashi;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashi.entities.ProductStore;

public class MainApplication {
	public static void main(String[] args) {
//       ProductStore pStore = ProductStore.getInstance();
//       System.out.println(pStore);
//       
//
//       ProductStore pStore1 = ProductStore.getInstance();
//       System.out.println(pStore1);
//    	    
//       

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		// IOC container objects list
		System.out.println("==========IOC Conteainer > Spring Beans===============");
		String[] springbeans = context.getBeanDefinitionNames();
		Arrays.stream(springbeans).forEach(System.out::println);
		System.out.println("==========================================\n");
		
		//requesting the object of the productStore
		
//		ProductStore pro1 = context.getBean("productStore",ProductStore.class);
//		System.out.println(pro1);
//		
//		ProductStore pro2 = context.getBean("productStore",ProductStore.class);
//		System.out.println(pro2);
		
		ProductStore p1 = context.getBean("p1",ProductStore.class);
		ProductStore p2 = context.getBean("p2",ProductStore.class);
		
		ProductStore p1_1 = context.getBean("p1",ProductStore.class);
		System.out.println(p1_1);
		
		System.out.println(p1);
		System.out.println(p2);
		
		

	}
}
