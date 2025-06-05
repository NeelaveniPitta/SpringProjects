package com.ashi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("std")
public class StudentRepository {
  
	@Autowired
	private DataSource dSource;
	
	String qryString = "select * from student1";
	
	public List<StudnetDTO> getAllStduents() throws SQLException{
		
		List<StudnetDTO> stdsDtos = new  ArrayList<StudnetDTO>();
		Connection connection = dSource.getConnection();
		PreparedStatement pstmPreparedStatement = connection.prepareStatement(qryString);
		ResultSet res = pstmPreparedStatement.executeQuery();
		
		while(res.next()) {
			StudnetDTO dto = new StudnetDTO(res.getInt(1), res.getString(2), res.getDouble(3));
			stdsDtos.add(dto);
		}
		return stdsDtos;
		
		
	}
	
	
}
