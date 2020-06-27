package com.service;

import java.util.List;

import com.dao.IUserDao;
import com.dao.UserDaoImpl;
import com.pojo.Books;

public class UserServiceImpl implements IUserService {
	
	
    private IUserDao dao=new UserDaoImpl();
    public void issueBooks(int user,String name,int days)
    {
    	 dao.issueBooks(user, name, days);
    }
    
    public int getBalance(int id)
    {
    	return dao.getBalance(id);
    }
    
    
	public List<Books> getName(String author)
	{
		return dao.getName(author);

	}
	public void closeConnection()
	{
		
	}


}
