package com.pool.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.*;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class Connectionpool {
	public static void main(String[] args) throws Exception {
		MysqlConnectionPoolDataSource  ds= new MysqlConnectionPoolDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/mydb");
		ds.setUser("root");
		ds.setPassword("Password1");
		Connection con=ds.getConnection();
		Statement st =con.createStatement();
		ResultSet  rs =st.executeQuery("select * from employee");
	      System.out.println("eno\tename\tesalary\teaddress");
	      System.out.println("------------------------------------------");
	      boolean flag=false;
		   while(rs.next()) {
			   
			   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
			   flag=true;
		   }
		   if(flag==false) {
			   System.out.println("no records available");
		   }
		    con.close();
		
	}
}
