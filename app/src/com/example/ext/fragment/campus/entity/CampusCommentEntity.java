package com.example.ext.fragment.campus.entity;

public class CampusCommentEntity {
	private String name; 
	private String imageUrl;
	private String commentTime;
	private String content;
	
	public CampusCommentEntity(String name,String imageUrl,String commentTime
			,String content)
	{
		this.name=name;
		this.imageUrl=imageUrl;
		this.commentTime=commentTime;
		this.content=content;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
