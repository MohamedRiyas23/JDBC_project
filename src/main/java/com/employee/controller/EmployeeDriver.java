package com.employee.controller;

import java.util.Scanner;

import com.employee.dao.EmployeeDao;

public class EmployeeDriver {

	public static void main(String[] args) {
		
		EmployeeDao dao=new EmployeeDao();
		Scanner sc=new Scanner(System.in);
		
		
		boolean loop=true;
		while(loop) {
			System.out.println("\n1.Add Employees \n2.Update salary using Id \n3.Update department using Id \n4.Delete using Id \n5.Fetch details using First Name \n6.Fetch details between salary range \n7.delete records \n8.Exit");
			System.out.println("Enter the choice: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				dao.addEmployees();
				break;}
			case 2:{
				dao.updateSalary();
				break;}
			case 3:{
				dao.updateDept();
				break;}
			case 4:{
				dao.deleteUsingId();
				break;}
			case 5:{
				dao.fetchUsingFirstName();
				break;}
			case 6:{
				dao.fetchBetRange();
				break;}
			case 7:{
				dao.deleteRecords();
				break;}
			case 8:{
				loop=false;
				break;
				}
			default:{
				System.out.println("invalid choice!!");
				break;}
			}
		}
		System.out.println("Thank You !");
		

	}

}
