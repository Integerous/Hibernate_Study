package com.answeris.hb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //아이디 자동으로 증가
	private int id;
	private String title;
	private String content;
	private String writerId;
	private Date regDate;
	private int hit;
	
	@Column(name="`order`")
	private int order;//이대로 두면 쿼리문 만들때 문제 됌
	private boolean pub;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="note", cascade=CascadeType.ALL)
	//@Transient
	List<Comment> comments;
	
	
	public Note() {
		// TODO Auto-generated constructor stub
	}


	//값을 담을 때 사용하는 최소한의 데이터
	public Note(String title, String content, String writerId) {
		super();
		this.title = title;
		this.content = content;
		this.writerId = writerId;
	}
	

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", writerId=" + writerId + ", regDate="
				+ regDate + ", hit=" + hit + ", order=" + order + ", pub=" + pub + ", comments=" + comments + "]";
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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


	public boolean isPub() {
		return pub;
	}


	public void setPub(boolean pub) {
		this.pub = pub;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	
	
	
	
}
