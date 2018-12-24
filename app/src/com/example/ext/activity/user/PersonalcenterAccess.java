package com.example.ext.activity.user;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.fragment.campus.CampusInformation;
import com.example.ext.util.HttpRequestor;
import com.example.ext.util.HttpService_;
import com.example.ext.util.ImageLoader;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalcenterAccess extends Activity{

	private TextView name=null; //用户名
	private TextView school = null; //学校
	private TextView where = null;
	private TextView phone1=null;
	private TextView username=null;
	private TextView com=null;
	
	private CircleImageView head;
	private TextView name1=null;
	private TextView phone;
	private TextView username1;
	private TextView com1;
	private Map<String, String> map=null;
	private String id;
	private static final String FILENAME = "bcit";
	private ImageLoader imageloader;
	private Button focus;
	private Button back;
	private String userName;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personalcenter_access);
		imageloader = new ImageLoader(this);
		this.school=(TextView)findViewById(R.id.where);
		this.where=(TextView)findViewById(R.id.where1);
		this.phone1=(TextView)findViewById(R.id.phone1);
		this.username=(TextView)findViewById(R.id.username2);
		this.com=(TextView)findViewById(R.id.com1);
		
		this.head=(CircleImageView)findViewById(R.id.my_defalft_headpic);
		this.name1=(TextView)findViewById(R.id.name1);
		this.phone=(TextView)findViewById(R.id.phone);
		this.username1=(TextView)findViewById(R.id.username1);
		this.com1=(TextView)findViewById(R.id.com);
		this.focus=(Button)findViewById(R.id.focus);
		this.back=(Button)findViewById(R.id.back);
		
		SharedPreferences sp = super.getSharedPreferences(FILENAME, LoginPage.MODE_PRIVATE);
		userName = sp.getString("id", "");
		
		Intent it =super.getIntent();
		
		id = it.getStringExtra("id");
		
		Drawable drawable=getResources().getDrawable(R.drawable.icon_woman); 
		drawable.setBounds(0, 0, 35, 50);
		school.setCompoundDrawables(drawable, null, null, null);
		
		Drawable drawable1=getResources().getDrawable(R.drawable.address); 
		drawable1.setBounds(0, 0, 50, 50);
		where.setCompoundDrawables(drawable1, null, null, null);
		
		drawable1=getResources().getDrawable(R.drawable.icon_phone_blue); 
		drawable1.setBounds(0, 0, 50, 50);
		phone1.setCompoundDrawables(drawable1, null, null, null);
		
		drawable1=getResources().getDrawable(R.drawable.user2); 
		drawable1.setBounds(0, 0, 50, 50);
		username.setCompoundDrawables(drawable1, null, null, null);
		
		drawable1=getResources().getDrawable(R.drawable.email); 
		drawable1.setBounds(0, 0, 50, 50);
		com.setCompoundDrawables(drawable1, null, null, null);
		
		focus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(userName.equals(id))
				{
					Toast.makeText(PersonalcenterAccess.this, "不能关注自己！！", Toast.LENGTH_SHORT).show();
				}
				else
				{
					String res;
					String httpUrl;
					Map<String, String> map = new HashMap<String, String>();
					map.put("id", id);
					map.put("username", userName);
					httpUrl = GlobalFinal.path.concat("click_focus.action?");
					HttpService_ http = new HttpService_();
					res = http.loginPostData(httpUrl, map);
					Toast.makeText(PersonalcenterAccess.this, "已关注！！", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		excute(1);
		
	}
	
	protected String doLogin() {
		String res;
		String httpUrl;
		map = new HashMap<String, String>();
		map.put("id", id);
		httpUrl = GlobalFinal.path.concat("user1_getMyInformation.action?");
		HttpRequestor http = new HttpRequestor();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			//"list":[{"ID":"1","userAct":"1","phoneNo":"154541","SchoolName":"廈門理工","emailAdd":"65457@qq.com"}]
			JSONObject json =new JSONObject(lists);
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				phone.setText(obj.getString("phoneNo"));
				name1.setText(obj.getString("userName"));
				username1.setText(obj.getString("userAct"));
				where.setText(obj.getString("SchoolName"));
				com1.setText(obj.getString("emailAdd"));
				imageloader.DisplayImage(obj.getString("imageUrl"),this.head);
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
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
					Toast.makeText(PersonalcenterAccess.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
							.show();
				}
				break;
			default:
				break;
			}
		};
	};
	
}
