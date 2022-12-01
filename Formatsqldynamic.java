package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Formatsqldynamic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		
	  Connection con = DriverManager.getConnection(url,user,pwd);
	  Statement st =con.createStatement();
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
      String sqlquery=String.format("insert into employee values(%d,'%s',%d,'%s')",eno,ename,esal,eadd);
      st.executeUpdate(sqlquery);
      System.out.println("records inserted succesfully");
      System.out.println("Do you want to insert one more record[yes/no]:");
      String option =sc.next();
      if(option.equalsIgnoreCase("No")) {
    	  break;
      }
      }
      sc.close();
	}

}
