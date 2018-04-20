package com.answeris.hb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name="Book") //테이블명과 다를 경우 이거 넣어줘야함
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //기본키 자동생성하기위해. IDENTITY는 기본키 생성을 데이터베이스에 위임하는 방법. 주로MySQL, PostgresSQL 등에서 사용
	private int id;
	
	//@Column(name="title") //컬럼명과 다를 경우 이거 넣어줘야함
	private String title;
	private String coverImg;
	private String writerId;
	private Date regDate;
	private int hit;
	
	@Column(name="`order`")
	private int order;
	
	@OneToOne(mappedBy="book", cascade=CascadeType.ALL) // 여기서 book은 BookDetail 엔티티에 있는 private Book book의 book이다. 자식은 참조키가 있지만 부모는 참조키가 없으므로.
	private BookDetail bookDetail; //자식레코드도 함께 레코드 가져오기 위해서

	
	public Book() {
		// TODO Auto-generated constructor stub
	}


	public Book(String title, String coverImg, String writerId) {
		super();
		this.title = title;
		this.coverImg = coverImg;
		this.writerId = writerId;
	}


	public Book(int id, String title, String coverImg, String writerId, Date regDate, int hit, int order) {
		super();
		this.id = id;
		this.title = title;
		this.coverImg = coverImg;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
		this.order = order;
	}

	

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", coverImg=" + coverImg + ", writerId=" + writerId
				+ ", regDate=" + regDate + ", hit=" + hit + ", order=" + order + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCoverImg() {
		return coverImg;
	}


	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}


	public String getWriterId() {
		return writerId;
	}


	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	
	
	
	
	public BookDetail getBookDetail() {
		return bookDetail;
	}


	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}
	
	
	


}
