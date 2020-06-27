package com.presentation;

import com.service.IAdminService;


import com.service.IUserService;
import com.service.IBooksService;
import com.pojo.Books;
import com.pojo.Users2;
import com.pojo.Admin;
import com.service.AdminServiceImpl;
import com.service.UserServiceImpl;
import com.service.BooksServiceImpl;

import java.util.*;

public class Test {

	public static void main(String[] args) {

		int choice;
		Scanner sc = new Scanner(System.in);

		IAdminService adminService = new AdminServiceImpl();
		IUserService userService = new UserServiceImpl();
		System.out.println("1.login as admin");
		System.out.println("2.login as user");
		choice = sc.nextInt();
		while (choice<=2) {

			switch (choice) {
			case 1:
				System.out.println("enter userid and password");
				int userid = sc.nextInt();
				String password = sc.next();
				boolean b = adminService.pwdCheck(userid, password);
				if (b == true) {

					System.out.println("login successful");
					
					System.out.println("-----------------------------");
                          
					int choice1;
					Scanner sc1 = new Scanner(System.in);
					System.out.println("1.add books to library");
					System.out.println("2.remove books to library");
					System.out.println("3.get list of books issued");
					System.out.println("4.get balance of the user");
					System.out.println("5.delete user account from library");
					System.out.println("6.terminate");
					choice1 = sc.nextInt();
					
					switch (choice1) {
					case 1:

						System.out.println("enter id,name,quantity,author");
						adminService.addBooks(new Books(sc.nextInt(), sc.next(), sc.nextInt(), sc.next()));
						break;
					case 2:
						System.out.println("enter id to delete from library ");
						int id = sc.nextInt();
						adminService.removeBook(id);

						break;

					case 3:
						System.out.println("enter the userid to view the details of books issued");
						int userid1=(sc.nextInt());
						;
						System.out.println(adminService.issueBooks( userid1));
						
						break;

					case 4:
						System.out.println("enter userid to view balance");
						int id1 = sc.nextInt();
						System.out.println(adminService.getBalance(id1));
						break;

					case 5:
						System.out.println("enter userid to delete user");
						int user = sc.nextInt();
						adminService.removeUser(user);
						break;
					case 6:
						adminService.closeConnection();
						System.out.println("disconnected");
						System.exit(0);
						break;
					
					}

					break;
				} else {
					System.out.println("login failed");
				}

				break;
			         
			case 2:
				System.out.println("enter userid and password");
				int user = sc.nextInt();
				String password1 = sc.next();
                
				
				
				int choice2;
				Scanner sc2 = new Scanner(System.in);
				System.out.println("1.select books from library");
				System.out.println("2.get list of books by author name");
				System.out.println("3.check available balance in account");
				System.out.println("4.terminate");
				choice2 = sc.nextInt();

				switch (choice2) {
				case 1:
					
				     String name=sc.next();
				     int days=sc.nextInt();
					userService.issueBooks(user,name,days);
					break;
				case 2:
					System.out.println("enter author name");
					String author = sc2.next();
					System.out.println(userService.getName(author));
					break;
				case 3:
					System.out.println("user balance is");
					 System.out.println(adminService.getBalance(user));
						
					break;
				case 4:
					userService.closeConnection();
					System.out.println("disconnected");
					System.exit(0);
				}
				break;
				
			default :
				System.out.println("Logged Out");
				break;
			}

		}

	}
}


