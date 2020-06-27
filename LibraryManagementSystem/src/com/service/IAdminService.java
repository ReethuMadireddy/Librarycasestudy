package com.service;
import java.util.List; 

import com.pojo.Admin;
import com.pojo.Books;
import com.pojo.Users2;

public interface IAdminService {
	
	public List<Admin> getAllAdmins();
	public List<Books> getAllBooks();
	//public List<Users> getListOfBooks(int s);
	public boolean pwdCheck(int userid, String password );
	public void addBooks(Books b);
	public List<Books> issueBooks(int userid);
	public int getBalance(int id);
	public void removeBook(int id);
	public void removeUser(int user);
	public void closeConnection();
	
    
}
