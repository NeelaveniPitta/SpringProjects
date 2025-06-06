package com.ashi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Publisher;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashi.entites.EmpEntity;

//i this we need to write method declarations
@Repository
public class EmployeeRepository {

	@Autowired
	private DataSource dataSource;

	public List<EmpEntity> getAllEmmployees() throws SQLException {
		String qry = "select * from emp";

		List<EmpEntity> employees = new ArrayList<EmpEntity>();

		Connection connection = dataSource.getConnection();

		PreparedStatement pstm = connection.prepareStatement(qry);

		ResultSet res = pstm.executeQuery();

		// load resultset object to List<EmpEntities>
		while (res.next()) {
			EmpEntity emp = new EmpEntity(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4),
					res.getDouble(5));

			employees.add(emp);

		}

		return employees;

	}
	
	// add employee
	
	public boolean addEmployee(EmpEntity emp) throws SQLException {
		String qry = "insert into emp values(?,?,?,?,?)";
		Connection connection = dataSource.getConnection();
		PreparedStatement pstm = connection.prepareStatement(qry);
		pstm.setInt(1, emp.getId());
		pstm.setString(2, emp.getName());
		pstm.setInt(3, emp.getAge());
		pstm.setString(4, emp.getDepartment());
		pstm.setDouble(5, emp.getSalary());
		int k = pstm.executeUpdate();
		return k>0;
	}
	
	
	// delete employee

	public boolean deleteEmployee(Integer eid) throws SQLException {
		String qry = "delete from emp where id = ?";

		Connection connection = dataSource.getConnection();

		PreparedStatement pstm = connection.prepareStatement(qry);
		pstm.setInt(1, eid);
		
		int rows = pstm.executeUpdate();
		return rows > 0; //rows = 0 ---> no deletions 
	}
	
	
	
	//Get employee By ID
	public EmpEntity getEmployee(Integer id) throws SQLException {
		String qry = "select * from emp where id = ?";
        EmpEntity emp = null;
		Connection connection = dataSource.getConnection();

		PreparedStatement pstm = connection.prepareStatement(qry);
		pstm.setInt(1, id);
		
		ResultSet res = pstm.executeQuery();
		if(res.next()) {
		  emp = new EmpEntity(res.getInt("id"), res.getString("name"), res.getInt("age"), res.getString("department"), res.getDouble("salary"));
		}
		
		return emp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
