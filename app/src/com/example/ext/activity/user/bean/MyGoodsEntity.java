package com.example.ext.activity.user.bean;

public class MyGoodsEntity {
	
	private String id;
	private String personId;
	private String goodsName;
	private String image;
	private String note;
	private String cost;
	private String num;
	private String imageUrl;
	private String name;
	
	public MyGoodsEntity(String id,String personId,String goodsName,String image,String note,
			String cost,String num,String imageUrl,String name)
	{
		this.id=id;
		this.personId=personId;
		this.goodsName=goodsName;
		this.image=image;
		this.note=note;
		this.cost=cost;
		this.num=num;
		this.imageUrl=imageUrl;
		this.name=name;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	  
}
