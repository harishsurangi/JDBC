package com.metadata.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Gettabledetails {

	public static void main(String[] args) throws Exception {
	 	// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery("select * from employee");
		java.sql.ResultSetMetaData rsmd=rs.getMetaData();
		int count=rsmd.getColumnCount();
		for(int i=1;i<=count;i++) {
			System.out.println("column Number:"+i);
			System.out.println("column Name:"+rsmd.getCatalogName(i));
			System.out.println("column Type:"+rsmd.getColumnType(i));
			System.out.println("column Size:"+rsmd.getColumnDisplaySize(i));
			System.out.println("------------------");
		}
		con.close();
	}
}
		
