package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.pojo.Books;

public class UserDaoImpl implements IUserDao {
	private static Connection conn;
	static {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reethu1", "root", "pass");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void issueBooks(int userid,String name,int days) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from Books where bookname=?");
			stmt.setString(1, name);
			ResultSet rset=stmt.executeQuery();
			int book_id = 0;
			while (rset.next()) {
				book_id = rset.getInt(1);
			}
			
			int balance = getBalance(userid);	
			
			updateBalance(balance-(5*days),userid);
			insertIntoBooksissued(userid,book_id,days);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
					}
	

	private void insertIntoBooksissued(int userid, int book_id, int days) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOOKSISSUED VALUES (?,?,?)");
		stmt.setInt(1, userid);
		stmt.setInt(2,book_id);
		stmt.setInt(3,days);
		stmt.execute();
	}


	private void updateBalance(int balance, int userid) throws SQLException  { 
		PreparedStatement stmt = conn.prepareStatement("update Users2 set balance = ? where id =?");
		stmt.setInt(1, balance);
		stmt.setInt(2,userid);
		stmt.execute();
	}


	public int getBalance(int id) {
		{
			try {
			
				
				Statement stmt=conn.createStatement();
				ResultSet rset=stmt.executeQuery("select balance from Users2 where id="+id);
				
				while (rset.next()) {
					return rset.getInt(1);
				}
		
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	}

	public List<Books> getName(String author) {
		List<Books> list = new LinkedList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from Books where author=?");
			stmt.setString(1, author);
			ResultSet rset=stmt.executeQuery();
		
			while(rset.next())
			{
				Books b=new Books(rset.getInt(1),rset.getString(2),rset.getInt(1),rset.getString(2));
				list.add(b);
			}
		
			stmt.close();
					
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void closeConnection()
	{
	
	}
	}
