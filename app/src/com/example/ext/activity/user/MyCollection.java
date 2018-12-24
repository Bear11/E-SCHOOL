package com.example.ext.activity.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.activity.user.bean.CollectActivityEntity;
import com.example.ext.activity.user.bean.CollectAdapter;
import com.example.ext.activity.user.bean.MyShareAdapter;
import com.example.ext.activity.user.bean.MyShareEntity;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.HttpRequestor;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

public class MyCollection extends Fragment{

	private View parentView = null;
	private ListView listview=null;
	private static final String FILENAME = "bcit";
	private String username = null;
	private Map<String, String> map=null;
	
	private CollectAdapter adapter;
	
	List<MyShareEntity> list = new ArrayList<MyShareEntity>();
	
	List<CollectActivityEntity> collect= new ArrayList<CollectActivityEntity>();
	
	private String[] lists;
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		parentView = inflater.inflate(R.layout.my_collection, container, false);
		
		this.listview=(ListView)parentView.findViewById(R.id.listview11);
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
		httpUrl = GlobalFinal.path.concat("collect_getMyShareCollect.action?");
		HttpRequestor http = new HttpRequestor();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	
	protected String doLogin_2() {
		String res;
		String httpUrl;
		map = new HashMap<String, String>();
		map.put("id", username);
		httpUrl = GlobalFinal.path.concat("collect_getMyActivityView.action?");
		HttpRequestor http = new HttpRequestor();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	
	// 登录
	protected void login(String res) {
		
		
		lists=res.split(";");
		
		String list1=lists[0];
		
		String list2=lists[1];
		
		try {
			
			
			
			String slist =((list1.split("busList")[1]).substring(2,(list1.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(list1);
			JSONObject json =new JSONObject(slist);
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
		
		
		try {
			String alist =((list2.split("busList")[1]).substring(2,(list2.split("busList")[1]).length()));
			JSONObject jsonObject1 = new JSONObject(list2);
			JSONObject json1 =new JSONObject(alist);
			JSONArray array1 = json1.getJSONArray("list");
			for(int i=0;i<=array1.length();i++)
			{
				JSONObject obj = array1.getJSONObject(i);
				collect.add(new CollectActivityEntity(obj.getString("PICTURE"),
						obj.getString("PLAYTIME"),
						obj.getString("PICTURE"),
						obj.getString("PICTURE")));
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		adapter=new CollectAdapter(getActivity(), this.list,collect);
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
							String res = doLogin()+";"+doLogin_2();
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
	
}
