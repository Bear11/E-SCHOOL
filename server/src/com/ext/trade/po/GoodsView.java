package com.ext.trade.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class GoodsView {

	private int id; // 主键id
	private String name; // 商品名
	private int number; // 商品数量
	private String discribe; // 商品描述
	private double price; // 商品价格
	private int personId; // 商品拥有者
	private String pname; //用户名
	private int lSchoolId; //学校id
	private String school; //用户所在学校
	private int sex; //用户性别
	private Date playTime; // 发表时间
	private int state; //存货状态,新增的字段
	private int clickNumber; //点赞数
	private int commentNumber; //评论数
	private int forwardNumber; //转发量
	private String imageUrl; //商品图片
	private String phoneNumber; //联系方式
	// 设置自增长
	public GoodsView() {
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.personId = DatabaseUtils.INVALID_INT_ID;
		this.lSchoolId = DatabaseUtils.INVALID_INT_ID;
	}

	// 重写toString()方法
	@Override
	public String toString() {
		return "GoodsView [id=" + id + ", name=" + name + ", number=" + number
				+ ", discribe=" + discribe + ", price=" + price + ", personId="
				+ personId + ", pname=" + pname + ", lSchoolId=" + lSchoolId
				+ ", school=" + school + ", sex=" + sex + ", playTime="
				+ playTime + ", state=" + state + ", clickNumber="
				+ clickNumber + ", commentNumber=" + commentNumber
				+ ", forwardNumber=" + forwardNumber + ", imageUrl=" + imageUrl
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	// 取得get和set方法

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public int getForwardNumber() {
		return forwardNumber;
	}

	public void setForwardNumber(int forwardNumber) {
		this.forwardNumber = forwardNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getlSchoolId() {
		return lSchoolId;
	}

	public void setlSchoolId(int lSchoolId) {
		this.lSchoolId = lSchoolId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
