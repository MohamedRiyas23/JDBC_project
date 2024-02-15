package com.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LoginDao {
	Scanner sc=new Scanner(System.in);
	
	static String url="jdbc:postgresql://localhost:5432/employee";
	static String userName="postgres";
	static String password="root"; 
	static Connection con=null;
	
	static Set<String> emailid=new HashSet<String>();
	static List <String> passwords= new ArrayList<String>();
	
	static String query1="SELECT email FROM sign_up";
	static String query2="SELECT password FROM sign_up";
	
	static Statement stmt= null;
	static ResultSet rs=null;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url, userName, password);
			stmt = con.createStatement();
			
			rs=stmt.executeQuery(query1);
			while(rs.next()) {
				emailid.add(rs.getString(1));
			}
			
			rs=stmt.executeQuery(query2);
			while(rs.next()) {
				passwords.add(rs.getString(1));
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void login() {
		System.out.println("Enter the email id:");
		String uemail=sc.next();
		System.out.println("Enter the password:");
		String upassword=sc.next();
		
		String query="INSERT INTO login values(?,?,?,?)";
		PreparedStatement pstmt=null;
		if(emailid.contains(uemail) && passwords.contains(upassword) ) {
			
			try {
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, uemail);
				pstmt.setInt(2, (int)Math.random()*100000);
				pstmt.setString(3,LocalDate.now().toString());
				pstmt.setString(4, LocalTime.now().toString());
				pstmt.execute();
				
				System.out.println("**********Welcome you've logged in successfully!!**********");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("*********mismatch of email and password!!*********");
		}
	}
	public void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
