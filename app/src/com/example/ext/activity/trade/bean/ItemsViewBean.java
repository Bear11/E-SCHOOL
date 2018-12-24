package com.example.ext.activity.trade.bean;
/*
 * ItemsViewBean
 * 作为适配器的容器
 * */
public class ItemsViewBean {

	private String id; // 主键id
	private String name; // 物品名
	private String number; // 物品数量
	private String discribe; // 物品描述
	private String type; // 物品类型，确定是否为赠品或失物
	private String imageUrl; //图片
	private String personId; // 物品拥有者
	private String pname; //用户名
	private String sex; //用户性别
	private String playTime; // 发表时间
	private String school; // 所在学校
	private String phoneNumber; //联系电话
	
	//构造方法
	public ItemsViewBean(String id, String name, String number, String discribe, String type, String imageUrl,
			String personId, String pname, String sex, String playTime, String school, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.discribe = discribe;
		this.type = type;
		this.imageUrl = imageUrl;
		this.personId = personId;
		this.pname = pname;
		this.sex = sex;
		this.playTime = playTime;
		this.school = school;
		this.phoneNumber = phoneNumber;
	}
	
	//toString()方法
	@Override
	public String toString() {
		return "ItemsViewBean [id=" + id + ", name=" + name + ", number=" + number + ", discribe=" + discribe
				+ ", type=" + type + ", imageUrl=" + imageUrl + ", personId=" + personId + ", pname=" + pname + ", sex="
				+ sex + ", playTime=" + playTime + ", school=" + school + ", phoneNumber=" + phoneNumber + "]";
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	  
}
