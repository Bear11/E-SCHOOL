package com.example.ext.activity.user;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;













import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.fragment.campus.entity.CampusCommentEntity;
import com.example.ext.util.HttpRequestor;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyInformation extends Activity{

	private TextView Phone = null;
	private TextView name = null;
	private TextView Username = null;
	private TextView schoolName = null;
	private TextView emailAdd = null;
	private TextView back;
	private CircleImageView head;
	private String username = null;
	private ImageLoader imageloader;
	private Map<String, String> map=null;
	private static final String FILENAME = "bcit";
	
	private ImageView change;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.my_information);
		imageloader = new ImageLoader(this);
		this.Phone = (TextView)findViewById(R.id.phone);
		this.name = (TextView)findViewById(R.id.name1);
		this.Username = (TextView)findViewById(R.id.username1);
		this.schoolName = (TextView)findViewById(R.id.school);
		this.emailAdd = (TextView)findViewById(R.id.com);
		this.change=(ImageView)findViewById(R.id.gai);
		this.head=(CircleImageView)findViewById(R.id.my_defalft_headpic);
		this.back=(TextView)findViewById(R.id.back);
		SharedPreferences sp = super.getSharedPreferences(FILENAME, LoginPage.MODE_PRIVATE);
		username = sp.getString("id", "");
		
		//强行调整图片大小
		Drawable drawable=getResources().getDrawable(R.drawable.icon_woman); 
		drawable.setBounds(0, 0, 35, 50);
		name.setCompoundDrawables(drawable, null, null, null);
		
		change.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MyInformation.this,MyInformationUpdate.class);
				it.putExtra("name", name.getText().toString());
				it.putExtra("phone", Phone.getText().toString());
				it.putExtra("schoolName", schoolName.getText().toString());
				it.putExtra("emailAdd", emailAdd.getText().toString());
				startActivity(it);
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
		map.put("id", username);
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
				Phone.setText(obj.getString("phoneNo"));
				name.setText(obj.getString("userName"));
				Username.setText(obj.getString("userAct"));
				schoolName.setText(obj.getString("SchoolName"));
				emailAdd.setText(obj.getString("emailAdd"));
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
					Toast.makeText(MyInformation.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
							.show();
				}
				break;
			default:
				break;
			}
		};
	};
}
