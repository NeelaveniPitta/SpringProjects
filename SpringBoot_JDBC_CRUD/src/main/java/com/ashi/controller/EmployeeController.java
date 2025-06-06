package com.ashi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ashi.services.EmployeeService;

import lombok.Getter;

@Controller
@Getter
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 


}
