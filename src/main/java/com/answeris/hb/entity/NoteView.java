package com.answeris.hb.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class NoteView extends Note{
	
	private int commentCount;
	
	
	
	public NoteView() {
		// TODO Auto-generated constructor stub
	}


	
	

	/*public NoteView(int commentCount) {
		super();
		this.commentCount = commentCount;
	}*/
	public NoteView(int id, String title, String content, Date regDate, int hit, boolean pub, int commentCount) {
		super(id, title, content, regDate, hit, pub);
		// TODO Auto-generated constructor stub
		this.commentCount = commentCount;
	}





	@Override
	public String toString() {
		return "NoteView [note="+super.toString()+",commentCount=" + commentCount + "]";
	}





	public int getComementCount() {
		return commentCount;
	}


	public void setComementCount(int comementCount) {
		this.commentCount = comementCount;
	}
	
	
	
}
