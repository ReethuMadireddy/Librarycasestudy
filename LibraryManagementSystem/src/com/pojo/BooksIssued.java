package com.pojo;

public class BooksIssued {
	private int uid;
	private int bid;
	private int days;
	
	public BooksIssued(int days) {
		super();
		this.days = days;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBid() {
		return bid;
	}
	public BooksIssued() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "BooksIssued [uid=" + uid + ", bid=" + bid + ", days=" + days + "]";
	}
	public BooksIssued(int uid, int bid, int days) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.days = days;
	}
	
}
