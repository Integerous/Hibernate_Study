package com.answeris.hb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class BookDetail {
	
	@Id
	private int id;
	private int pageCount;
	private int width;
	private int height;
	private String publisher;
	private Date pubDate;
	//참조키 private int bookId;
	
	//@OneToOne(cascade=CascadeType.ALL)
	@OneToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="bookId")
	private Book book;
	
	
	public BookDetail() {
		// TODO Auto-generated constructor stub
	}

	//기본값 있는 것들 빼고 
	public BookDetail(int pageCount, String publisher) {
		super();
		this.pageCount = pageCount;
		this.publisher = publisher;
	}
	
	
	public BookDetail(int id, int pageCount, int width, int height, String publisher, Date pubDate, Book book) {
		super();
		this.id = id;
		this.pageCount = pageCount;
		this.width = width;
		this.height = height;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.book = book;
	}

	
	
	

	@Override
	public String toString() {
		return "BookDetail [id=" + id + ", pageCount=" + pageCount + ", width=" + width + ", height=" + height
				+ ", publisher=" + publisher + ", pubDate=" + pubDate + ", book=" + book + "]";
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Date getPubDate() {
		return pubDate;
	}


	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
