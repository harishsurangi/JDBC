package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Createtable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       
		String url ="jdbc:mysql://localhost:3306/mydbs";
		String user="root";
		String pwd="Password1";
		String query="create table employee(eno int,ename varchar(50),esal int,eadd varchar(50))";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("connection established");
		Statement st =con.createStatement();
	    st.executeUpdate(query);
	    System.out.println("table created sucessfully");
	    con.close();
	 
		
	}

}
