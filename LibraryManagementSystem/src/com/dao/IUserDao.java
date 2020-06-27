package com.dao;

import java.util.List;

import com.pojo.Books;


public interface IUserDao {
	public void issueBooks(int user,String name,int days);
	public int getBalance(int id);
	public List<Books> getName(String author);
	public void closeConnection();

}
