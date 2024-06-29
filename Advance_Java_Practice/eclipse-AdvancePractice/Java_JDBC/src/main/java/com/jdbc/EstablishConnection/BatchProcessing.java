package com.jdbc.EstablishConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProcessing {
	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","root");
		
		//By using Statement interface
		Statement st=con.createStatement();
		st.addBatch("insert into employee(id,name,age) values(109,'Hello',23)");	
		st.addBatch("insert into employee(id,name,age) values(110,'Hi',23)");
		st.addBatch("insert into employee(id,name,age) values(111,'Bro',23)");
		st.executeBatch();
		
		//By using Prepared Statement interface
		PreparedStatement ps=con.prepareStatement("insert into employee(id,name,age) values(?,?,?)");
		Scanner s=new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.println("Enter id: ");
			int id=s.nextInt();
			System.out.println("Enter Name: ");
			String name=s.next();
			System.out.println("Enter Age: ");
			int age=s.nextInt();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.addBatch();
		}
		ps.executeBatch();

	}
}
