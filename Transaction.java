package com.transactions.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("connected succesfully");
		Statement st =con.createStatement();
	     ResultSet rs =st.executeQuery("select * from wages"); 
	     System.out.println("name"+"\t"+"slary");
	     while(rs.next()) {
	    	 System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
	     }
	    System.out.println("transaction begins");
	    con.setAutoCommit(false);
	    st.executeUpdate("update wages set salary=salary-1000 where name='harish'");
	    st.executeUpdate("update wages set salary=salary+1000 where name='modi'");
	    System.out.println("can u please confirm yes r no");
	    Scanner sc= new Scanner(System.in);
	    String option=sc.next();
	    if(option.equalsIgnoreCase("yes")) {
	    	con.commit();
	    	System.out.println("transaction completed");
	    }
	    else {
	    	con.rollback();
	    	System.out.println("transaction rollback");
	    }
	    ResultSet rs1 =st.executeQuery("select * from wages"); 
	     System.out.println("name"+"\t"+"slary");
	     while(rs1.next()) {
	    	 System.out.println(rs1.getString(1)+"\t"+rs1.getInt(2));
	     }
	    con.close();
	}

}
