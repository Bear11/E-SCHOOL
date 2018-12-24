package com.example.ext.activity.trade.bean;

public class GoodsViewBean {

	private String id; // 主键id
	private String name; // 商品名
	private String number; // 商品数量
	private String discribe; // 商品描述
	private String price; // 商品价格
	private String personId; // 商品拥有者
	private String pname; //用户名
	private String school; //用户所在学校
	private String lSchoolId; //用户所在学校id
	private String sex; //用户性别
	private String playTime; // 发表时间
	private String state; //存货状态,新增的字段
	private String clickNumber; //点赞数
	private String commentNumber; //评论数
	private String forwardNumber; //转发量
	private String imageUrl; //图片
	private String phoneNumber; //联系电话
    //构造方法
	public GoodsViewBean(String id, String name, String number, String discribe, String price, String personId,
			String pname, String school, String lSchoolId, String sex, String playTime, String state,
			String clickNumber, String commentNumber, String forwardNumber, String imageUrl, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.discribe = discribe;
		this.price = price;
		this.personId = personId;
		this.pname = pname;
		this.school = school;
		this.lSchoolId = lSchoolId;
		this.sex = sex;
		this.playTime = playTime;
		this.state = state;
		this.clickNumber = clickNumber;
		this.commentNumber = commentNumber;
		this.forwardNumber = forwardNumber;
		this.imageUrl = imageUrl;
		this.phoneNumber = phoneNumber;
	}

	//toString()方法
	@Override
	public String toString() {
		return "GoodsViewBean [id=" + id + ", name=" + name + ", number=" + number + ", discribe=" + discribe
				+ ", price=" + price + ", personId=" + personId + ", pname=" + pname + ", school=" + school
				+ ", lSchoolId=" + lSchoolId + ", sex=" + sex + ", playTime=" + playTime + ", state=" + state
				+ ", clickNumber=" + clickNumber + ", commentNumber=" + commentNumber + ", forwardNumber="
				+ forwardNumber + ", imageUrl=" + imageUrl + ", phoneNumber=" + phoneNumber + "]";
	}

    // get,set方法
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(String clickNumber) {
		this.clickNumber = clickNumber;
	}

	public String getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(String commentNumber) {
		this.commentNumber = commentNumber;
	}

	public String getForwardNumber() {
		return forwardNumber;
	}

	public void setForwardNumber(String forwardNumber) {
		this.forwardNumber = forwardNumber;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getlSchoolId() {
		return lSchoolId;
	}
	public void setlSchoolId(String lSchoolId) {
		this.lSchoolId = lSchoolId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
