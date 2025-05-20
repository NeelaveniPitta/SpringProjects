package com.ashi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ashi.entities.Product;

@Configuration
//@ComponentScan(basePackages = {"com.ashi"})
@ComponentScan("com.ashi")
public class AppConfig {
	
	@Bean(name = "product1")
	@Scope(scopeName = "singleton")
	public Product getProduct() {
		return new Product();
	}
	
	@Bean(name = "product2")
	@Scope(scopeName = "singleton")
	public Product getProduct1() {
		return new Product();
	}
	

}
