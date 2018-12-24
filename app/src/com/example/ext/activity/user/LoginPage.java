package com.example.ext.activity.user;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.MainPage;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.baseData.GlobalStaticFun;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;
import com.example.ext.util.SetInternetUtil;

public class LoginPage extends Activity {
	private Button bt1 = null;
	private AutoCompleteTextView userEdit = null;
	private EditText pwdEdit = null;
	private TextView regist = null ;
	private static final String FILENAME = "bcit";
	public String id = " ";
	private Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.loginpage);
		this.userEdit = (AutoCompleteTextView) findViewById(R.id.E1);
		this.pwdEdit = (EditText) findViewById(R.id.E23);
		this.bt1 = (Button) findViewById(R.id.login);
		this.regist = (TextView) findViewById(R.id.regist);
		
		regist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(LoginPage.this,RegisterPage.class);
				startActivity(it);
			}
		});
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {		
				bt1.setClickable(false); //不能再按				
				if(userEdit.getText().toString() == null || "".equals(userEdit.getText().toString()))
				{
					Toast.makeText(LoginPage.this, "用户名不能为空", Toast.LENGTH_SHORT).show();				 
					bt1.setClickable(true); //可以再按
				}else if(pwdEdit.getText().toString() == null || "".equals(pwdEdit.getText().toString())){
					Toast.makeText(LoginPage.this, "密码不能为空", Toast.LENGTH_SHORT).show();	
					bt1.setClickable(true); //可以再按
				}
				else{
					if (!SetInternetUtil.isNetworkConnected(LoginPage.this)) { // 判断网络是否可用，并设置网络					
						   bt1.setClickable(true);
						}
					dialog = GlobalStaticFun.createLoadingTimeDialog(LoginPage.this, "正在登录中...",20000);
					dialog.show();
					dialog.setOnCancelListener(null);
					excute(1); //满足条件则执行线程
					bt1.setClickable(true); //可以再按
				}				
			}
		});
	}
		protected String doLogin() {
			String res;
			String httpUrl;
			Map<String, String> map = new HashMap<String, String>();
			
		
				map.put("userAct", userEdit.getText().toString());
				map.put("userPwd", pwdEdit.getText().toString());
				httpUrl = GlobalFinal.path.concat("user_login.action?");
				HttpService_ http = new HttpService_();
				res = http.loginPostData(httpUrl, map);
				return res;
			
			
		}
		// 登录
		protected void login(String res) {
			try {
				/*if(res == " ")
				{
					;//若为空，则不执行什么
				}
				else{*/
					JSONObject jsonObject = new JSONObject(res);
					String result = jsonObject.getString("flag");
					String userId = jsonObject.getString("userid");
					//sp储存，存储用户id			
					hh(userId);				
									
					if ("0".equals(result)) {
						dialog.dismiss();
						Toast.makeText(LoginPage.this, "账号或密码错误，请确认后重新登录", Toast.LENGTH_SHORT).show();
					} else {
						dialog.dismiss();
						Toast.makeText(LoginPage.this, "登录成功", Toast.LENGTH_SHORT).show();
						Intent it = new Intent(LoginPage.this,
								 MainPage.class);
								 startActivity(it);
					}
				
				}
				 catch (JSONException e) {
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
//							case 2:
//								String res2 = doRegister();
//								Message msg2 = new Message();
//								msg2.what = 1;
//								msg2.obj = res2;
//								opera.sendMessage(msg2);
//								break;

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
						dialog.dismiss();
						/*Toast.makeText(LoginPage.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
								.show();*/
						Toast.makeText(LoginPage.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
						.show();
					}
					break;
//				case 1:
//					if (res != null && !res.equals("") && !res.equals("error")) {
//						register(res);
//					} else {
//						Toast.makeText(LoginActivity.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
//								.show();
//					}
//					break;
				default:
					break;
				}
			};
		};
		void hh(String ids){
			//sp存储，获得id的值，并保存在文件中，以便其他页面调用
					SharedPreferences share = super.getSharedPreferences(FILENAME,
							Activity.MODE_PRIVATE);	// 指定操作的文件名称
					SharedPreferences.Editor edit = share.edit(); 	// 编辑文件
					edit.putString("id", ids) ;	// 保存字符串					
					edit.commit() ;	// 提交更新
		}
}







