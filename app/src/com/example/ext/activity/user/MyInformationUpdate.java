package com.example.ext.activity.user;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.HttpRequestor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyInformationUpdate extends Activity{
	
	private String name;
	private String phone;
	private String schoolName;
	private String emildAdd;
	
	private static final String FILENAME = "bcit";
	private String username;
	
	
	private EditText Name; 
	private EditText Phone;
	private EditText where;
	private EditText signature;
	
	private TextView boom;
	private TextView phone1;
	private TextView where1;
	private TextView signature1;
	
	private Map<String, String> map=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.my_informationupdate);
		SharedPreferences sp = super.getSharedPreferences(FILENAME, LoginPage.MODE_PRIVATE);
		username = sp.getString("id", "");
		Intent it = super.getIntent();
		this.name=it.getStringExtra("name");
		this.phone=it.getStringExtra("phone");
		this.schoolName=it.getStringExtra("schoolName");
		this.emildAdd=it.getStringExtra("emailAdd");
		
		
		this.Name=(EditText)findViewById(R.id.name);
		this.Phone=(EditText)findViewById(R.id.phone);
		this.signature=(EditText)findViewById(R.id.signature);
		this.boom=(TextView)findViewById(R.id.boom);
		this.phone1=(TextView)findViewById(R.id.phone1);
		this.signature1=(TextView)findViewById(R.id.signatures);
		
		Name.setText(name);
		Phone.setText(phone);
		signature.setText(emildAdd);
		map = new HashMap<String, String>();
		
		boom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String res;
				String httpUrl;
				map.put("x", "1");
				map.put("id",username);
				map.put("name", Name.getText().toString());
				map.put("phone", Phone.getText().toString());
				map.put("emild", signature.getText().toString());
				httpUrl = GlobalFinal.path.concat("user1_updateInformation.action?");
				HttpRequestor http = new HttpRequestor();
				res = http.loginPostData(httpUrl, map);
				//excute(1);
			}
		});
		phone1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String res;
				String httpUrl;
				map.put("x", "2");
				map.put("id",username);
				map.put("name", Name.getText().toString());
				map.put("phone", Phone.getText().toString());
				map.put("emild", signature.getText().toString());
				httpUrl = GlobalFinal.path.concat("user1_updateInformation.action?");
				HttpRequestor http = new HttpRequestor();
				res = http.loginPostData(httpUrl, map);
			}
		});
		signature1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String res;
				String httpUrl;
				map.put("x", "4");
				map.put("id",username);
				map.put("name", Name.getText().toString());
				map.put("phone", Phone.getText().toString());
				map.put("emild", signature.getText().toString());
				httpUrl = GlobalFinal.path.concat("user1_updateInformation.action?");
				HttpRequestor http = new HttpRequestor();
				res = http.loginPostData(httpUrl, map);
			}
		});
		
	}
	

}
