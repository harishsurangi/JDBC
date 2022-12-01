package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Updatesinglerow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		String query="update employee set esal=9000 where ename='durga'";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement st =con.createStatement();
	    int updatecount=st.executeUpdate(query);
	    System.out.println("the number of rows effected:"+updatecount);
	    System.out.println("inserted single row");
	    con.close();
	}

}
