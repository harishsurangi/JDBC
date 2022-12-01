package com.transactions.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertdata {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		String query="select * from wages ";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("connected succesfully");
		Statement st =con.createStatement();
	     ResultSet rs =st.executeQuery(query); 
	     System.out.println("name"+"\t"+"slary");
	     while(rs.next()) {
	    	 System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
	     }
	    con.close();
	   
	}

}
