package com.zxin.java.jdk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DriverTest {

	private static final Logger logger = LoggerFactory.getLogger(DriverTest.class);
	
	String driverName = "com.mysql.jdbc.Driver";
	
	public void test() throws Exception{
		
		Class.forName(driverName);
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");){
			Statement statement = connection.createStatement();  
			ResultSet rs = statement.executeQuery("select * from emp");  
			while(rs.next()){
				System.out.println(rs.getInt(1) + "\t"+ rs.getString(2));  
				System.out.println(rs.getInt("id") + "  " + rs.getString("name"));  
			}
		} catch (SQLException e) {
			logger.warn("", e);
		}
	}
	
}
