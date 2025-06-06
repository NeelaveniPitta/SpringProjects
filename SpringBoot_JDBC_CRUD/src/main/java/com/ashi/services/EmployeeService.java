package com.ashi.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ashi.entites.EmpEntity;
import com.ashi.repository.EmployeeRepository;

//this service class is reposible to give the implemetaion of the repository
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	
    public List<EmpEntity> getEmployees() throws SQLException {
    	return repo.getAllEmmployees();
    }
    
    public boolean delete(Integer eid) throws SQLException {
    	return repo.deleteEmployee(eid);
    }
    
	
}
