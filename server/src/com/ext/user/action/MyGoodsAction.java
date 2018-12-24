package com.ext.user.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.user.bo.UserFollowViewBo;
import com.ext.user.bo.UserGoodsViewBo;
import com.ext.user.bo.MyGoodsBo;
import com.ext.user.po.UserFollow;
import com.ext.user.po.UserGoodsView;
import com.ext.user.po.MyGoods;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class MyGoodsAction extends QssActionSupprot{
	private String msg;
	private int flag;
	private int id;
	private String name;
	private String number;
	private String price;
	private String disprice;
	private String userId;
	private UserGoodsView UserGoodsView;
	private UserGoodsViewBo UserGoodsViewBo;
	private MyGoods MyGoods;
	private MyGoodsBo MyGoodsBo;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDisprice() {
		return disprice;
	}
	public void setDisprice(String disprice) {
		this.disprice = disprice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public UserGoodsView getUserGoodsView() {
		return UserGoodsView;
	}
	public void setUserGoodsView(UserGoodsView userGoodsView) {
		UserGoodsView = userGoodsView;
	}
	public UserGoodsViewBo getUserGoodsViewBo() {
		return UserGoodsViewBo;
	}
	public void setUserGoodsViewBo(UserGoodsViewBo userGoodsViewBo) {
		UserGoodsViewBo = userGoodsViewBo;
	}
	public MyGoodsBo getMyGoodsBo() {
		return MyGoodsBo;
	}
	public void setMyGoodsBo(MyGoodsBo myGoodsBo) {
		MyGoodsBo = myGoodsBo;
	}
	public MyGoods getMyGoods() {
		return MyGoods;
	}
	public void setMyGoods(MyGoods myGoods) {
		MyGoods = myGoods;
	}
	public String getUserFollowView()
	{
		String id = getParam("id").toString();
		List<UserGoodsView> list = new ArrayList<UserGoodsView>();
		try {
			list = UserGoodsViewBo.getUserGoodsView(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String setGoods()
	{
		msg = null;
		int userid_1 = Integer.valueOf(getParam("id").toString());// 用户账号
		String note = getParam("note").toString();
		String name =getParam("name").toString();
		String num = getParam("num").toString();
		String price =getParam("price").toString();
		//String userName = getParam("userName").toString();// 用户昵称
		//String imageUrl = getParam("imageUrl").toString();// 用户头像
		//int sex = Integer.valueOf(getParam("sex").toString());// 用户性别
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String commentTime=format.format(date);
		MyGoods.setName(name);
		MyGoods.setNumber(Integer.valueOf(num));
		MyGoods.setPrice(Integer.valueOf(price));
		MyGoods.setDiscribe(note);
		MyGoods.setPlayTime(commentTime);
		MyGoods.setPERSONID(Integer.valueOf(userid_1));
		MyGoods.setImage("dsdsf");

		
		//userInformation.setSex(sex);
		try {
			MyGoodsBo.saveMyGoodsBo(MyGoods);
			msg = "success";
		} catch (Exception e){
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String updateGoods() {
		msg = " ";
		int x= Integer.valueOf(getParam("x").toString());
		String pid=getParam("gid").toString();
		
		try {
			
				msg = getMyGoodsBo().updateGoods(x,pid);
			
			if (msg.equals("success")) {
				msg = "success";
			} else {
				msg = "error";
			}
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}
	
}
