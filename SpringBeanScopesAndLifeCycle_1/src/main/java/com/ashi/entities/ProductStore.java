package com.ashi.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//i am using singleton design pattern

//@Component("productStore")
//@Scope(scopeName = "prototype")
public class ProductStore {
	
	private static ProductStore instance = null;
	
	private ProductStore() {
		
	}
	
	public static ProductStore getInstance() {
		if(instance == null) {
			instance = new ProductStore();
		}
		return instance;
	}
		
}
