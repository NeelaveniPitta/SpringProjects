package com.ashi;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class DemoRepo2 implements DBConnection {

	@Autowired
	DataSource dSource;
	
	public String getDBinfo() throws SQLException {
		Connection connection = dSource.getConnection();
		  DatabaseMetaData metaData = connection.getMetaData();

		    String dbInfo = "Database Product Name: " + metaData.getDatabaseProductName() + "\n"
		                  + "Database Product Version: " + metaData.getDatabaseProductVersion() + "\n"
		                  + "Database URL: " + metaData.getURL() + "\n"
		                  + "Database Username: " + metaData.getUserName() + "\n"
		                  + "Driver Name: " + metaData.getDriverName() + "\n"
		                  + "Driver Version: " + metaData.getDriverVersion();
		return dbInfo;
	}
}
