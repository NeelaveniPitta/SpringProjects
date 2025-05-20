package com.ashi;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ashi.entities.Product;

public class MainApplication 
{
    public static void main( String[] args )
    {
        
    		
    	
		/*
		 * AnnotationConfigApplicationContext context = new
		 * AnnotationConfigApplicationContext(); context.register(AppConfig.class);
		 * context.refresh();
		 * 
		 * //IOC container objects list
		 * System.out.println("==========IOC Conteainer > Spring Beans===============");
		 * String[] springbeans = context.getBeanDefinitionNames();
		 * Arrays.stream(springbeans).forEach(System.out::println);
		 * System.out.println("==========================================\n");
		 * 
		 * //requesting ioc to get the Product object Product product1 =
		 * context.getBean("product1",Product.class); Product product1_1 =
		 * context.getBean("product1",Product.class);
		 * 
		 * //requesting ioc to get the Product object Product product2 =
		 * context.getBean("product2",Product.class);
		 * 
		 * System.out.println(product1); System.out.println(product1_1);
		 * 
		 * 
		 * System.out.println(product2);
		 * 
		 * System.out.println(product1 == product2);
		 */
    	
    	
    	//XML configuration
    	
    	ApplicationContext context = new FileSystemXmlApplicationContext("S:\\gitLocalRepo\\SpringProjects\\SpringBeanScopesAndLifeCycles\\ApplicationContext.xml");
    	
    	System.out.println("==========IOC Conteainer > Spring Beans===============");
    	String[] springbeans = context.getBeanDefinitionNames();
    	Arrays.stream(springbeans).forEach(System.out::println);
    	System.out.println("=======================================================");
    	 
    	//requesting IOC 
    	Product productObj1 = context.getBean("product",Product.class);
    	
    Product productObj2 = context.getBean("product",Product.class);
    Product productObj3 = context.getBean("product",Product.class);
    
    System.out.println(productObj1);
    System.out.println(productObj2);
    
    System.out.println(productObj3);
    
    productObj3.setId(101);
    
    System.out.println("id in productObj1 :"+productObj1.getId());
    System.out.println("id in productObj2 :"+productObj2.getId());
    System.out.println("id in productObj3 :"+productObj3.getId());

    System.out.println(productObj1 == productObj2);
    	 
    	 
    	   
    	
    	
    }
}
