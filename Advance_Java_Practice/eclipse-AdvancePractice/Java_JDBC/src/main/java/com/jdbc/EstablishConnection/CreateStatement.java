package com.jdbc.EstablishConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {
	public static void main(String[] args) throws SQLException {
		//Registering the driver is not mandatory
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","root");
		//We can create statement in three ways
		//By using Statement interface
		Statement st=con.createStatement();
		st.execute("select * from employee");
		ResultSet rs1=st.getResultSet();
		while(rs1.next()) {
			System.out.println(rs1.getInt(1));
			System.out.println(rs1.getString(2));
			System.out.println(rs1.getInt(3));
		}
		System.out.println("*************");
		
		//By using Prepared Statement interface
		PreparedStatement ps=con.prepareStatement("select * from employee");
		ps.execute();
		ResultSet rs2=ps.getResultSet();
		while(rs2.next()) {
			System.out.println(rs2.getInt(1));
			System.out.println(rs2.getString(2));
			System.out.println(rs2.getInt(3));
			
		}
		System.out.println("*************");
		
		//By using CallableStatement interface
		CallableStatement cs=con.prepareCall("select * from employee");
		cs.execute();
		ResultSet rs3=cs.getResultSet();
		while(rs3.next()) {
			System.out.println(rs3.getInt(1));
			System.out.println(rs3.getString(2));
			System.out.println(rs3.getInt(3));
			
		}
	}
}
