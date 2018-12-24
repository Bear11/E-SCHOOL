 package com.example.ext.common.baseData;


public class GlobalStatic {

	private static String username;// 登陆账号
	//记录图片操做类型,1标识分享图片，2标识发布易物，3标识活动图片，4标识
	private static int flagImageUp;
	//记录风景墙图片路径的静态变量
	private static String[] mData;
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		GlobalStatic.username = username;
	}
	public static int getFlagImageUp() {
		return flagImageUp;
	}
	public static void setFlagImageUp(int flagImageUp) {
		GlobalStatic.flagImageUp = flagImageUp;
	}
	public static String[] getmData() {
		return mData;
	}
	public static void setmData(String[] mData) {
		GlobalStatic.mData = mData;
	}
	
	
}