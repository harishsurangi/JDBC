package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertsinglerecord {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		String query="insert into employee values(100,'durga',1000,'hyd')";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement st =con.createStatement();
	    st.executeUpdate(query);
	    System.out.println("values inserted sucessfully");
	    con.close();
	}
	

}

