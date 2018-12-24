package com.example.ext.activity.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.activity.trade.TradeRelease;
import com.example.ext.activity.user.bean.MyFocusAdapter;
import com.example.ext.activity.user.bean.MyFocusEntity;
import com.example.ext.activity.user.bean.MyGoodsAdapter;
import com.example.ext.activity.user.bean.MyGoodsEntity;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.HttpRequestor;
import com.lee.pullrefresh.ui.PullToRefreshBase;
import com.lee.pullrefresh.ui.PullToRefreshListView;
import com.lee.pullrefresh.ui.PullToRefreshBase.OnRefreshListener;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MyGoods extends Activity{

	private static final String FILENAME = "bcit";
	private String username;
	private Map<String, String> map=null;
	private ListView listview;
	private MyGoodsAdapter adapter = null;
	private List<MyGoodsEntity> list = new ArrayList<MyGoodsEntity>();
	private PullToRefreshListView mPullToRefresh;
	private ImageView add;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.my_goods);
		this.add=(ImageView)findViewById(R.id.jia);
		mPullToRefresh=(PullToRefreshListView)findViewById(R.id.mPullRefreshListView);
		SharedPreferences sp = super.getSharedPreferences(FILENAME, LoginPage.MODE_PRIVATE);
		username = sp.getString("id", "");
		
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
				Intent it = new Intent(MyGoods.this,TradeRelease.class);
				startActivity(it);
			}
		});
	}
	
	protected String doLogin() {
		String res;
		String httpUrl;
		map = new HashMap<String, String>();
		map.put("id", username);
		httpUrl = GlobalFinal.path.concat("user3_getUserFollowView.action?");
		HttpRequestor http = new HttpRequestor();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			JSONObject json =new JSONObject(lists);
//{"busList":{"list":[{"ID":"2","userAct":"5","name":"电饭煲","number":"1","price":"100","discribe":"马上要离开这边了,所以想尽快把一些可卖的东西给出售掉,这个电饭煲都没怎么用过,有意者请私聊","image":"http://192.168.43.224:8080/ext_web/picture/trade_pics/trade/pic_dianfanbao2.jpg"}]}}
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				list.add(new MyGoodsEntity(obj.getString("ID"),
						obj.getString("userAct"),
						obj.getString("name"),
						obj.getString("image"),
						obj.getString("discribe"),
						obj.getString("price"),
						obj.getString("number"),
						obj.getString("imageUrl"),
						obj.getString("userAct1")));
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		adapter=new MyGoodsAdapter(this, list);
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
					Toast.makeText(MyGoods.this, GlobalFinal.errorTip, 

Toast.LENGTH_SHORT)
							.show();
				}
				break;
			default:
				break;
			}
		};
	};
	
}
