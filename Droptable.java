package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Droptable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		String query="drop table employee";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement st =con.createStatement();
	    st.executeUpdate(query);
	    System.out.println("table dropped sucessfully");
	    con.close();
	}

}
