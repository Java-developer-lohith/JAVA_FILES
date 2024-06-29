package com.jdbc.StoreImages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveImage {
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","root");
		File img=new File("");
		FileInputStream fis=new FileInputStream(img);
		PreparedStatement ps=con.prepareStatement("onsert into images(image) values(?)");
		ps.setBinaryStream(1, fis,(int)img.length());
		ps.executeUpdate();
	}
}
