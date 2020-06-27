package com.dao;

import java.sql.Connection;



import com.pojo.Admin;
import com.pojo.Books;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AdminDaoImpl implements IAdminDao {
	private static Connection conn;
	int id;
	String name;
	int cost;
	String author;
	int userid;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reethu1", "root", "pass");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean pwdCheck(int userid, String password) {
		try {
			boolean b = false;
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from Admin");

			while (rset.next()) {
				if (rset.getInt(1) == (userid) && rset.getString(2).equals(password)) {
					b = true;
					
				}
				break;
			}

			stmt.close();

			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Books> getAllBooks()
	{
		List<Books> list=new ArrayList();
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from Books");
			
			while(rset.next())
			{
				Books b=new Books(rset.getInt(1),rset.getString(2),rset.getInt(1),rset.getString(2));
				list.add(b);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public void addBooks(Books b) {
		try {
			
			PreparedStatement pstmt = conn.prepareStatement("insert into Books values(?,?,?,?)");
			
			
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getBookname());
			pstmt.setInt(4, b.getQuantity());
  			pstmt.setString(3, b.getAuthor());
  			
  			pstmt.execute();
  			System.out.println("books added to library successfylly..");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Books> issueBooks(int userid)
	{
		List<Books> list=new ArrayList();
		try {

			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select Books.bookid,Books.bookname,Books.quantity,Books.author from Books join booksissued on books.bookid = bid JOIN users2 on id = uid  where id ="+userid);
			while(rset.next())
			{
				Books b=new Books(rset.getInt(1),rset.getString(2),rset.getInt(1),rset.getString(2));
				list.add(b);
			}
			stmt.close();
			System.out.println("Books issued succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getBalance(int id)
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

	public void removeBook(int id) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from Books where bookid=?");
			pstmt.setInt(1, id);
			
			pstmt.execute();
			System.out.println("book removed succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public List<Users> getListOfBooks(int s)
	{
	List<Users> list=new ArrayList();
	try
	{
		Statement stmt=conn.createStatement();
		PreparedStatement pstmt=conn.prepareStatement("select id,booksissued from Users1 where id=?");
		pstmt.setInt(1, s);
		ResultSet rset=pstmt.executeQuery();
		System.out.println("id\booksissued");
		
		while(rset.nextInt())
		{
			list.add(new Users(rset.getInt(1),rset.getString(2)));
		}
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	}*/
	public void removeUser(int id) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from Users2 where id=?");
			pstmt.setInt(1, id);
			
			pstmt.execute();
			System.out.println("user removed succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}
	public void closeConnection()
	{
		try {
			conn.close();
		}
		catch (Exception e)
		{
			
		}
	}

	
	}
