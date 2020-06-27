package com.pojo;

public class Admin {
	
	private int userid;
	private String password;
	
	public Admin()
	{
		
	}
	public Admin(int userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void display()
	{
		System.out.println(userid);
		System.out.println(password);
		
	}
}
