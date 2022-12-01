package com.Blob;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrieveblobfromdb {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		Connection con = DriverManager.getConnection(url,user,pwd);
		PreparedStatement pst =con.prepareStatement("select * from persons");
		ResultSet rs=pst.executeQuery();
		FileOutputStream os= new FileOutputStream("D:\\eclipsepic\\picpink_new1.png");
		if(rs.next()) {
			String name=rs.getString(1);
			InputStream is=rs.getBinaryStream(2);
			byte[] buffer = new byte[1024];
			while(is.read(buffer)>0) {
				os.write(buffer);
			}
			os.flush();
			System.out.println("image is available in your d drive at your  choosed location");
		}
		con.close();
	}

}
