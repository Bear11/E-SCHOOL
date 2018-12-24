package com.example.ext.activity.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.activity.share.SharingCenterDetail;
import com.example.ext.activity.share.bean.ShareBean;
import com.example.ext.activity.user.bean.MyShareAdapter;
import com.example.ext.activity.user.bean.MyShareEntity;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.fragment.share.SharingCenter;
import com.example.ext.util.HttpRequestor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MyShare extends Fragment{
	
	private String username = null;
	private View parentView = null;
	private Map<String, String> map=null;
	private MyShareAdapter adapter = null;
	private ListView listview=null;
	List<MyShareEntity> list = new ArrayList<MyShareEntity>();
	private static final String FILENAME = "bcit";
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		parentView = inflater.inflate(R.layout.my_share, container, false);
		
		this.listview=(ListView)parentView.findViewById(R.id.list);
		
		SharedPreferences sp = getActivity().getSharedPreferences(FILENAME, LoginPage.MODE_PRIVATE);
		username = sp.getString("id", "");
		
		excute(1);
		return parentView;
	}
	protected String doLogin() {
		String res;
		String httpUrl;
		map = new HashMap<String, String>();
		map.put("id", username);
		httpUrl = GlobalFinal.path.concat("userShare_getMyShareView.action?");
		HttpRequestor http = new HttpRequestor();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			//{"id":"1","userAct":"1","imageUrl":"fdfdfdf","DISCRIBE":"“段子”本是相声中的一个艺术术语，指的是相声作品中一节或一段艺术内容，而随着人们对“段子”一词的频繁使用其内涵也悄悄地发生了变化","TYPEID":"1","PICTURE":"http://img0.imgtn.bdimg.com/it/u=1525828724,2491393840&fm=21&gp=0.jpg","PERSONID":"1","STATE":"启用","PLAYTIME":"2016-05-09 00:00:00.0","clickNumber":"0","commentNumber":"0","forwardNumber":"0"}]}
			JSONObject json =new JSONObject(lists);
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				list.add(new MyShareEntity(obj.getString("id"),obj.getString("PERSONID"),obj.getString("userAct"),
						obj.getString("PLAYTIME"),obj.getString("DISCRIBE"),
						obj.getString("imageUrl"),obj.getString("imageUrl"),
						obj.getString("clickNumber"),obj.getString("commentNumber"),
						obj.getString("forwardNumber")));
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		adapter=new MyShareAdapter(getActivity(), list);
		adapter.notifyDataSetChanged();
		listview.setAdapter(adapter);
		
//		this.listview.setOnItemLongClickListener(new OnItemLongClickListener() {
//
//			@Override
//			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
//					int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				String res;
//				String httpUrl;
//				MyShareEntity map1 = (MyShareEntity) MyShare.this.adapter
//						.getItem(arg2-1);
//				String id = map1.getId();// 分享id
//				map.put("id", id);
//				httpUrl = GlobalFinal.path.concat("userShare__deleteShare.action?");
//				HttpRequestor http = new HttpRequestor();
//				res = http.loginPostData(httpUrl, map);
//				return true;
//			}
//		});
		
	}
	
	// 网络请求
			protected void excute(final int i) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						switch (i) {
						case 1:
							String res = doLogin();
							Message msg = new Message();
							msg.what = 0;
							msg.obj = res;
							opera.sendMessage(msg);
							break;

						default:
							break;
						}
					}
				}).start();
			}

			
	private Handler opera = new Handler() {
		public void handleMessage(Message msg) {
			String res = msg.obj.toString();
			switch (msg.what) {
			case 0:
				if (res != null && !res.equals("") && !res.equals("error")) {
					login(res);
				} else {
					Toast.makeText(getActivity(), GlobalFinal.errorTip, Toast.LENGTH_SHORT)
							.show();
				}
				break;
			default:
				break;
			}
		};
	};
	
	public void refresh() {
		onCreate(null);
	}
	
}