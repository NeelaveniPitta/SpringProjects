package com.ashi.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "emp.add")
public class Address {

	 private String city;
	 private String state;
	 private Integer pincode;
}
