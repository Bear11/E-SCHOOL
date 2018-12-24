package com.example.ext.fragment.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.fragment.campus.adapter.InformationGroundAdapter;
import com.example.ext.fragment.campus.entity.InformationGroundEntity;
import com.example.ext.util.HttpService_;
import com.lee.pullrefresh.ui.PullToRefreshBase;
import com.lee.pullrefresh.ui.PullToRefreshListView;
import com.lee.pullrefresh.ui.PullToRefreshBase.OnRefreshListener;


public class InformationGround extends Fragment
{
	private View parentView = null;
	private InformationGroundAdapter adapter = null;
	private ListView listview;
	private PullToRefreshListView mPullToRefresh;
	List<InformationGroundEntity> list = new ArrayList<InformationGroundEntity>();
	private ImageView image;
	protected static final int MESSAGETYPE = 0;
	private String Id;
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		parentView = inflater.inflate(R.layout.campus_information, container, false);
		mPullToRefresh=(PullToRefreshListView)parentView.findViewById(R.id.mPullRefreshListView);
		image=(ImageView)parentView.findViewById(R.id.school);
		
		listview=mPullToRefresh.getRefreshableView();
		mPullToRefresh.setPullLoadEnabled(true);
		mPullToRefresh.setPullRefreshEnabled(true);
		mPullToRefresh.setHasMoreData(true);
		
		SharedPreferences share = getActivity().getSharedPreferences("bcit",
				Activity.MODE_PRIVATE); 
		
		Id=share.getString("id", "0");
		
		excute(1);
		
		mPullToRefresh.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onPullDownToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub

				mPullToRefresh.onPullDownRefreshComplete();
				list.clear();
				excute(1);
				
			}

			@Override
			public void onPullUpToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				mPullToRefresh.onPullUpRefreshComplete();
				
			}
		});
		image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(),SchoolInformation.class);
				startActivity(it);
			}
		});
		return parentView;
	}
	protected String doLogin() {
		String res;
		String httpUrl;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userAct", Id);
		httpUrl = GlobalFinal.path.concat("campus_login.action?");
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			//"list":[{"id":"1","title":"學校動態","note":"厦门理工学院位于中国东南海滨城市——厦门。1981年建校（前身鹭江职业大学），是福建省属公立本科大学，实行省市共建、以市为主的管理体制。","imageUrl":"fdds","playTime":"2016-05-16","userAct":"1","schoolName":"廈門理工"},{"id":"1","title":"學校動態","note":"厦门理工学院位于中国东南海滨城市——厦门。1981年建校（前身鹭江职业大学），是福建省属公立本科大学，实行省市共建、以市为主的管理体制。","imageUrl":"fdds","playTime":"2016-05-16","userAct":"1","schoolName":"廈門理工"}]}}
			JSONObject json =new JSONObject(lists);
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				list.add(new InformationGroundEntity("dsdsfsds",obj.getString("imageUrl"),obj.getString("userAct"), obj.getString("note"), obj.getString("schoolName"), obj.getString("title"), obj.getString("playTime")));
			}
			//sp储存，存储用户id			
//			SharedPreferences sp = super.getSharedPreferences("global", LoginPage.MODE_PRIVATE);
//			Editor editor = sp.edit();				
//			editor.putString("userId", userId);
//			editor.commit();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adapter=new InformationGroundAdapter(getActivity(), list);
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
//						case 2:
//							String res2 = doRegister();
//							Message msg2 = new Message();
//							msg2.what = 1;
//							msg2.obj = res2;
//							opera.sendMessage(msg2);
//							break;

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
//			case 1:
//				if (res != null && !res.equals("") && !res.equals("error")) {
//					register(res);
//				} else {
//					Toast.makeText(LoginActivity.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
//							.show();
//				}
//				break;
			default:
				break;
			}
		};
	};
}
