package com.dao;
import java.util.List;

import com.pojo.Admin;
import com.pojo.Books;
import com.pojo.Users2;

public interface IAdminDao {

	public List<Admin> getAllAdmins();
	public List<Books> getAllBooks();
	//public List<Users> getListOfBooks(int s);
	public void addBooks(Books b);
	public List<Books> issueBooks(int id);
	public int getBalance(int s);
	public void removeBook(int id);
	public void removeUser(int id);
	public void closeConnection();
    
}
