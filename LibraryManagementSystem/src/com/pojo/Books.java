package com.pojo;

public class Books {
	private int bookid;
	private String bookname;
	private int quantity;
	private String author;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", quantity=" + quantity + ", author=" + author
				+ "]";
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookid, String bookname, int quantity, String author) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.quantity = quantity;
		this.author = author;
	}
	
	
}
