package com.users.controller;

import java.util.Scanner;

import com.users.dao.LoginDao;
import com.users.dao.SignUpDao;

public class UsersDriver {

	public static void main(String[] args) {
		SignUpDao sud=new SignUpDao();
		LoginDao ld=new LoginDao();
		
		boolean loop=true;
		while(loop) {
			System.out.println("\n1.SignUp\n2.Login\n3.Exit");
			Scanner sc=new Scanner(System.in);
			System.out.println("\nEnter the choice:");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				sud.signUp();
				break;
			}
			case 2:{
				ld.login();
				break;
			}
			case 3:{
				loop=false;
				ld.closeCon();
				break;
			}
			default:{
				System.out.println("*******invalid choice!!!!*******");
			}
			}
		}

	}

}
