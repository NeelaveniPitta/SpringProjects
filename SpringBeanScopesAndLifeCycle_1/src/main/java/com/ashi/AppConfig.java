package com.ashi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ashi.entities.ProductStore;

@Configuration
@ComponentScan("com.ashi")
public class AppConfig {

	@Bean("p1")
	@Scope(scopeName = "prototype")
	public ProductStore productStore() {
		return ProductStore.getInstance();
		
	}
	
	@Bean("p2")
	public ProductStore productStore1() {
		return ProductStore.getInstance();
		
	}
	
	
}
