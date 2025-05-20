package com.ashi.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("product")
//@Scope(scopeName = "prototype")
public class Product {
	
	

	private int id;
	private String name;
	private String description;
	private int price;
	
	
//	public static Product getProduct() {
//		return new Product();
//	}
//	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
