package com.ashi.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "tcs.emp")
public class Employee {

	@Value("1010")
	private Integer empid;
	
	//@Value("${tcs.emp.name}")
	private String name;
	
	//@Value("${tcs.emp.age}")
	private Integer age;
	
	//@Value("${tcs.emp.phone}")
	private List<Long> phone;
	
	//@Value("${tcs.emp.salary}")
	private Double salary;
	
	
	
	
	@Autowired
	private  Address address;
	
	
	//Map
	private Map<String, String> govtId;
	
}
