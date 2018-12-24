package com.example.ext.activity.user.bean;

public class CollectActivityEntity {

	private String image;
	private String playTime;
	private String x1;
	private String x2;
	
	public CollectActivityEntity(String image , String playTime,
			String x1,String x2)
	{
		this.image=image;
		this.playTime=playTime;
		this.x1=x1;
		this.x2=x2;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getX1() {
		return x1;
	}

	public void setX1(String x1) {
		this.x1 = x1;
	}

	public String getX2() {
		return x2;
	}

	public void setX2(String x2) {
		this.x2 = x2;
	}
	
}
