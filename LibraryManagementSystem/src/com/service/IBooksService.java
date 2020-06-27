package com.service;

import java.util.List;

import com.pojo.Admin;
import com.pojo.Books;

public interface IBooksService {
	
	public List<Books> getBooks();
	public void addBooks(int id,String name,int cost,String author);
	

	


	


	
}
