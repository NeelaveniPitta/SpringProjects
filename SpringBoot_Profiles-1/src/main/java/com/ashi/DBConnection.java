package com.ashi;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public interface DBConnection {

	 String getDBinfo() throws SQLException;
	
	
}
