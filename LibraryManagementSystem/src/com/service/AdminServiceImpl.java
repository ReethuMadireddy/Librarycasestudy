package com.service;

import com.dao.IAdminDao;


import java.util.*;
import com.pojo.Admin;
import com.pojo.Books;
import com.pojo.Users2;
import com.dao.IAdminDao;
import com.dao.AdminDaoImpl;

public class AdminServiceImpl implements IAdminService{
	
	public boolean pwdCheck(int userid,String password)
	{
	      return true;
	      
	}
	public List<Books> getAllBooks()
	{
		return dao.getAllBooks();
	}
	
	private IAdminDao dao = new AdminDaoImpl();
	
	public List<Admin> getAllAdmins()
	{
		return dao.getAllAdmins();
	}
	public void addBooks(Books b)
	{
	     dao.addBooks(b);
	}
	public List<Books> issueBooks(int userid)
	{
		return dao.issueBooks(userid);
	}

	public void removeBook(int id)
	{
		dao.removeBook(id);
	}
	public int getBalance(int id)
	{
		return dao.getBalance(id);
	}
	
	public void removeUser(int id)
	{
		dao.removeUser(id);
	}
	public void closeConnection()
	{
		
	}
}
