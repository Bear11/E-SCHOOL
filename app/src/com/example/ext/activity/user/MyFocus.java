package com.example.ext.activity.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.activity.user.bean.MyFocusAdapter;
import com.example.ext.activity.user.bean.MyFocusEntity;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.pullRefrash.PullDownListView;
import com.example.ext.fragment.campus.adapter.CampusGroundAdapter;
import com.example.ext.fragment.campus.entity.CampusGroundEntity;
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
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyFocus extends Fragment implements
PullDownListView.OnRefreshListioner{
	private String username = null;
	private View parentView = null;
	private Map<String, String> map=null;
	private TextView Name;
	private MyFocusAdapter adapter = null;
	private ListView listview;
	List<MyFocusEntity> list = new ArrayList<MyFocusEntity>();
	private static final String FILENAME = "bcit";
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		parentView = inflater.inflate(R.layout.my_focus, container, false);
		Name = (TextView)parentView.findViewById(R.id.name);
		this.listview = (ListView)parentView.findViewById(R.id.listview);
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
		httpUrl = GlobalFinal.path.concat("user2_getUserFollowView.action?");
		HttpRequestor http = new HttpRequestor();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			//{"ID":"1","userName":"4564","signature":"so what？","PERSONID":"1"}
			JSONObject json =new JSONObject(lists);
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				list.add(new MyFocusEntity(obj.getString("ID"),obj.getString("objPersonId"),obj.getString("userName"),obj.getString("signature"),obj.getString("imageUrl")));
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		adapter=new MyFocusAdapter(getActivity(), list);
		adapter.notifyDataSetChanged();
		listview.setAdapter(adapter);
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
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		
	}
}
