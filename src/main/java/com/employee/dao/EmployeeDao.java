package com.employee.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.employee.dto.Employee;

public class EmployeeDao {
	static String url="jdbc:postgresql://localhost:5432/employee";
	static String userName="postgres";
	static String password="root";
	
	static Connection con=null;
	
	static {
		try {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection(url, userName, password);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	Scanner sc=new Scanner(System.in);
	public Employee employeeDetails() {
		System.out.println("Enter employee id:");
		int eid=sc.nextInt();
		System.out.println("Enter employee first name:");
		String efname=sc.next();
		System.out.println("Enter employee last name:");
		String elname=sc.next();
		System.out.println("Enter employee department:");
		sc.nextLine();
		String edept=sc.nextLine();
		System.out.println("Enter the employee salary:");
		double esal=sc.nextDouble();
		
		return new Employee( eid, efname,elname,edept,esal);
	}
	
	public void addEmployees() {
		PreparedStatement pstmt=null;
		String query="INSERT INTO emp_details VALUES(?,?,?,?,?)";
		System.out.println("Enter how many employees do you want to add:");
		int count=sc.nextInt();
		
		for(int i=1;i<=count;i++) {
			Employee emp=employeeDetails();
			try {
				pstmt=con.prepareStatement(query);
				pstmt.setInt(1, emp.getId());
				pstmt.setString(2, emp.getFirstName());
				pstmt.setString(3, emp.getLastName());
				pstmt.setString(4, emp.getDept());
				pstmt.setDouble(5, emp.getSal());
				pstmt.execute();
				System.out.println("***Employee got added***");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void updateSalary() {
		
		System.out.println("Enter the employee id of whom you want to update the salary:");
		int upid=sc.nextInt();
		System.out.println("Enter the salary that you want to update:");
		double upsal=sc.nextDouble();
		String query_u="update emp_details set sal= "+upsal+" where id= "+upid;
		try {
			Statement stmt=con.createStatement();
			stmt.execute(query_u);
			System.out.println("***Salary updated successfully!!***");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void updateDept() {
		
		System.out.println("Enter the employee id of whom you want to update the department:");
		int upid=sc.nextInt();
		System.out.println("Enter the department that you want to update:");
		String upDept=sc.next();
		String query_u="update emp_details set dept= '"+upDept+"'"+" where id= "+upid;
		try {
			Statement stmt=con.createStatement();
			stmt.execute(query_u);
			System.out.println("***Dept updated successfully!!***");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void deleteUsingId() {
		System.out.println("Enter the employee id of whom you want to delete:");
		int upid=sc.nextInt();
		
		
		String query_u="delete from emp_details where id= "+upid;
		try {
			Statement stmt=con.createStatement();
			stmt.execute(query_u);
			System.out.println("***employee deleted successfully!!***");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void fetchUsingFirstName() {
		System.out.println("Enter the first name of whom you want to fetch:");
		String fname=sc.next();
		
		String query_u="select * from emp_details where first_name= '"+fname+"'";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query_u);
			while(rs.next()) {
				System.out.println("id = "+rs.getInt(1));
				System.out.println("First Name = "+rs.getString(2));
				System.out.println("Last Name = "+rs.getString(3));
				System.out.println("Dept = "+rs.getString(4));
				System.out.println("salary = "+rs.getDouble(5));
				System.out.println("----------------------------------------------------");
			}
			System.out.println("***employee details fetched successfully!!***");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
public void fetchBetRange() {
		
		System.out.println("Enter the starting range of salary:");
		int startRange=sc.nextInt();
		System.out.println("Enter the ending range of salary:");
		int endRange=sc.nextInt();
		String query_u="select * from emp_details where sal between "+startRange+" and "+endRange;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query_u);
			while(rs.next()) {
				System.out.println("id = "+rs.getInt(1));
				System.out.println("First Name = "+rs.getString(2));
				System.out.println("Last Name = "+rs.getString(3));
				System.out.println("Dept = "+rs.getString(4));
				System.out.println("salary = "+rs.getDouble(5));
				System.out.println("----------------------------------------------------");
			}
			System.out.println("***employee details fetched successfully!!***");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

public void deleteRecords() {
	
	
	String query_u="delete from emp_details";
	try {
		
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("select count_employees()");
		rs.next();
		int count = rs.getInt(1);
		if(count!=0) {
			Statement stmt1=con.createStatement();
			stmt1.execute(query_u);
			System.out.println("***records from the table deleted successfully!!***");
		}
		else {
			System.out.println("***your table is already empty!!***");
		}
	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
	
}
