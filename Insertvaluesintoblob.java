package com.Blob;

import java.io.File;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Insertvaluesintoblob {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		Connection con = DriverManager.getConnection(url,user,pwd);
		PreparedStatement pst =con.prepareStatement("insert into persons values(?,?)");
		pst.setString(1,"harish");
		File f = new File("C:\\Users\\Haris\\Pictures\\picpink.jpg");
		FileInputStream fis = new FileInputStream(f);
		pst.setBinaryStream(2, fis);
		System.out.println("inserting image path:::::"+f.getAbsolutePath());
		int updatecount=pst.executeUpdate();
		if(updatecount==0) {
			System.out.println("not inserted");
		}
		else {
			System.out.println("inserted successfully");
		}
		con.close();
	}

}