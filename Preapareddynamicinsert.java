package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Preapareddynamicinsert {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		
	  Connection con = DriverManager.getConnection(url,user,pwd);
	  String sqlquery="insert into employee values(?,?,?,?)";
	  PreparedStatement pst =con.prepareStatement(sqlquery);
      Scanner sc= new Scanner(System.in);
      while(true) {
      System.out.println("enter employee number");
      int eno=sc.nextInt();
      System.out.println("enter employee name");
      String ename=sc.next();
      System.out.println("enter employee salary");
      int esal=sc.nextInt();
      System.out.println("enter employee address");
      String eadd=sc.next();
      pst.setInt(1, eno);
      pst.setString(2, ename);
      pst.setDouble(3,esal);
      pst.setString(4,eadd);
       int rowcount= pst.executeUpdate();
     
      System.out.println("Do you want to insert one more record[yes/no]:");
      String option =sc.next();
      if(option.equalsIgnoreCase("No")) {
    	  break;
      }
      
      System.out.println("no pf rows effected"+rowcount);
      }
      sc.close();
	}

}
