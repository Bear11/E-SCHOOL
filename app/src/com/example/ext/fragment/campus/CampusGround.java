package com.example.ext.fragment.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
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

import com.example.ext.R;
import com.example.ext.activity.MainPage;
import com.example.ext.activity.user.LoginPage;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.fragment.activities.ActivityRecruitment;
import com.example.ext.fragment.campus.adapter.CampusGroundAdapter;
import com.example.ext.fragment.campus.adapter.InformationGroundAdapter;
import com.example.ext.fragment.campus.entity.CampusGroundEntity;
import com.example.ext.fragment.campus.entity.InformationGroundEntity;
import com.example.ext.fragment.share.SharingCenter;
import com.example.ext.util.HttpService_;
import com.lee.pullrefresh.ui.PullToRefreshBase;
import com.lee.pullrefresh.ui.PullToRefreshListView;
import com.lee.pullrefresh.ui.PullToRefreshBase.OnRefreshListener;

public class CampusGround extends Fragment{
//	private View parentView;
//	private RadioGroup radioGroup;
//	private RadioButton rbTongZhi, rbDongTai;
//	private ViewPager  vp;
//
//	List<Fragment> list = null;
//   // private ImageView iv_add;
//	
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		parentView = inflater.inflate(R.layout.campus_ground, container, false);
//
//		
//		return parentView;
//	}
	private View parentView = null;
	private CampusGroundAdapter adapter = null;
	List<CampusGroundEntity> list = new ArrayList<CampusGroundEntity>();
	private TextView zyx;
	private ListView listview;
	private String userAct;
	private ImageView add;
	private PullToRefreshListView mPullToRefresh;
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		parentView = inflater.inflate(R.layout.campus_ground, container, false);
		//setContentView(R.layout.campus_ground);
		this.listview=(ListView)parentView.findViewById(R.id.list);
		this.add=(ImageView)parentView.findViewById(R.id.add); 
		SharedPreferences sp = getActivity().getSharedPreferences("global", LoginPage.MODE_PRIVATE);
		userAct = sp.getString("userId", "");
		mPullToRefresh=(PullToRefreshListView)parentView.findViewById(R.id.mPullRefreshListView);
		
		listview=mPullToRefresh.getRefreshableView();
		mPullToRefresh.setPullLoadEnabled(true);
		mPullToRefresh.setPullRefreshEnabled(true);
		mPullToRefresh.setHasMoreData(true);
		
		
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
		
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "点的好！！！", Toast.LENGTH_SHORT).show();
				Intent it = new Intent(getActivity(),AddCampusGround.class);
				startActivity(it);
			}
		});
		return parentView;
	}
	protected String doLogin() {
		String res;
		String httpUrl;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userAct", userAct);
		httpUrl = GlobalFinal.path.concat("campus1_login.action?");
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			
			JSONObject json =new JSONObject(lists);
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				
				//"id":"1","userAct":"哈林小子","head":"","address":"朝阳科技大学","note":"这里挺好玩的，周边有很多吃和玩的地方，欢迎来玩！","imageUrl":"http:\/\/img5.duitang.com\/uploads\/item\/201507\/05\/20150705000710_zwPH5.thumb.224_0.jpeg","playTime":"2016-10-20 12:28:59","clickNumber":"0","commentNumber":"0","forwardNumber":"0","schoolName":"朝阳科技大学"}
				
				list.add(new CampusGroundEntity(obj.getInt("id"),
						obj.getString("imageUrl"),
						obj.getString("userAct"), 
						obj.getString("note"), 
						obj.getString("playTime"), 
						obj.getString("schoolName"), 
						obj.getString("clickNumber"), 
						obj.getString("commentNumber"), 
						obj.getString("forwardNumber"),
						obj.getString("head")));
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		adapter=new CampusGroundAdapter(getActivity(), list);
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
