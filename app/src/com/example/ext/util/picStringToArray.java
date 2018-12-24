package com.example.ext.util;


public class picStringToArray {
	
	public String[] stringToArray(String imgurl){
		
		String url = imgurl.substring(0,imgurl.length()-1);
		String[] a = url.split(","); 
		return a;
	}

}
