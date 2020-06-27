package com.pojo;

public class Users2 {
	private int id;
	private int password;
	private int balance;
	private String name ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Users2(int id, int password, int balance, String name) {
		super();
		this.id = id;
		this.password = password;
		this.balance = balance;
		this.name = name;
	}
	public Users2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Users2 [id=" + id + ", password=" + password + ", balance=" + balance + ", name=" + name + "]";
	}

}

