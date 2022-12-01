package com.Blob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertblobindb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		String query="create table persons(name varchar(50),image BLOB)";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("connection established");
		Statement st =con.createStatement();
	    st.executeUpdate(query);
	    System.out.println("table created sucessfully");
	    con.close();
	}

}
