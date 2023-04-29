package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	/*
	 * JDBC requires 2 things. 
	 * 
	 * 1.) JDBC Driver for MySQL DB. -MySQL Connector JAR file internally has MySQL JDBC Driver.
	 * 	--- Add the JAR file to JDBCSetup/WebContent/WEB-INF/lib folder
	 * 
	 * 2.) Use JDBC API - Refer below.
	 */
	private Connection connection;
	
	//Constructor to establish the connection
	public DBConnection(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException 
	{
		//Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); // Class.forName will invoke the Java's Class Loader - Loading the JDBC Driver.
		
		//Get Connection
		this.connection = DriverManager.getConnection(dbURL,user,pwd);// Driver Manager actually Creates the Connection to the Database.		
	}
	
	//To retrieve the connection whenever we want to use it.
	public Connection getDBConnection()
	{
		return this.connection;
	}
	
	//Close the Connection
	public void closeConnection() throws SQLException
	{
		if(this.connection !=null) // Check whether there is an active connection.
		{
			this.connection.close();
		}
	}
	
	
	
}
