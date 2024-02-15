package com.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

public class SignUpDao {
	Scanner sc=new Scanner(System.in);
	static String url="jdbc:postgresql://localhost:5432/employee";
	static String userName="postgres";
	static String password="root";
	static Connection con=null;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url, userName, password);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void signUp() {
		System.out.println("Enter the name:");
		String uname=sc.nextLine();
		System.out.println("Enter the email id:");
		String uemail=sc.next();
		System.out.println("Enter the password (8 char only):");
		String upassword=sc.next();
		System.out.println("Again enter the password to confirm:");
		String ucpassword=sc.next();
		
		String query="INSERT INTO sign_up VALUES(?,?,?)";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, uname);
			pstmt.setString(2, uemail);
			try {
				if(upassword.equals(ucpassword)) {
					pstmt.setString(3, upassword);
				}
				else {
					System.out.println("******password is mismatch!!!******");
				}
			}
			catch(PSQLException e) {
				System.out.println("****please enter the same password that you entered before!!!*****");
			}
			pstmt.execute();
			System.out.println("*****Registered successfully!!!!******");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SignUpDao sud=new SignUpDao();
		sud.signUp();
	}
}
