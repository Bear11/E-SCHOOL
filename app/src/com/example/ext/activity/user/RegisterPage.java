package com.example.ext.activity.user;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;

public class RegisterPage extends Activity {
	private Button register = null;
	private EditText userAct = null;
	private EditText userPwd = null;
	private EditText sp1 = null;
	private EditText sp2 = null;
	private int lo_school = 0;
	private int go_school = 0;
	private static final String FILENAME = "bcit";
	Map<String, String> map = new HashMap<String, String>();
	private String[] schools; 
	Map<String, String> sch = new HashMap<String, String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除导航栏
		setContentView(R.layout.registerpage);
		this.userAct = (EditText) findViewById(R.id.name);
		this.userPwd = (EditText) findViewById(R.id.pwd);
		this.sp1 = (EditText) findViewById(R.id.inSchool1);
		this.sp2 = (EditText) findViewById(R.id.toSchool1);
		this.register = (Button) findViewById(R.id.button_submit);
		// 建立数据源
		this.sp1.setOnClickListener(new OnClickListener() {
			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				execute2();
				AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPage.this, R.style.dialog);
				builder.setTitle("请选择您所在学校");
				builder.setIcon(R.drawable.logo);
				// 指定下拉列表的显示数据
				final String[] school = { "厦门理工学院", "朝阳科技大学", "元智大学", "台湾大学",
						"厦门大学" };
				// 设置一个下拉的列表选择项
				builder.setItems(schools,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								sp1.setText(school[which]);
							}
						});
				builder.show();
			}			
		});
        this.sp2.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				execute2();
				final String[] school = { "厦门理工学院", "朝阳科技大学", "元智大学", "台湾大学",
				"厦门大学" };
				AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPage.this, R.style.dialog);
				builder.setTitle("请选择您所去学校");
				builder.setIcon(R.drawable.logo);
				// 指定下拉列表的显示数据
				/*final String[] schools = { "厦门理工学院", "朝阳科技大学", "元智大学", "台湾大学",
						"厦门大学" };*/
				// 设置一个下拉的列表选择项
				builder.setItems(school,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								sp2.setText(school[which]);
								//sp存储
								setSchName(school[which]);
							}
						});
				builder.show();
			}			
		});
	
        this.register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				excute(2);
			}
		});
	}

	protected String doRegister() {
		String httpUrl;
		String res;
		Map<String, String> map = new HashMap<String, String>();
		httpUrl = GlobalFinal.path.concat("user_regist.action?");	
		map.put("userAct", userAct.getText().toString());
		map.put("userPwd", userPwd.getText().toString());
		//map.put("loSchool", (Integer.valueOf(lo_school)).toString());
		//map.put("goSchool", (Integer.valueOf(go_school)).toString());
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		return res;
	}

	// 注册
	protected void register(String res) {
		try {
			if (!"error".equals(res)) {
				if (res.equals("same")) {
					Toast.makeText(RegisterPage.this, "账户已存在",
							Toast.LENGTH_LONG).show();
				} else {
					JSONObject jsonObject = new JSONObject(res);
					String result = jsonObject.getString("msg");
					String userid = jsonObject.getString("userid");
					Toast.makeText(RegisterPage.this, "注册成功",
							Toast.LENGTH_SHORT).show();
					Intent it = new Intent(RegisterPage.this, LoginPage.class);
					startActivity(it);
				}
			} else {
				Toast.makeText(RegisterPage.this, "注册失败", Toast.LENGTH_SHORT)
						.show();
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
				// case 1:
				// String res = doLogin();
				// Message msg = new Message();
				// msg.what = 0;
				// msg.obj = res;
				// opera.sendMessage(msg);
				// break;
				case 2:
					String res = doRegister();
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
					register(res);
				} else {
					Toast.makeText(RegisterPage.this, GlobalFinal.errorTip,
							Toast.LENGTH_SHORT).show();
				}
				break;
			// case 1:
			// if (res != null && !res.equals("") && !res.equals("error")) {
			// register(res);
			// } else {
			// Toast.makeText(LoginActivity.this, GlobalFinal.errorTip,
			// Toast.LENGTH_SHORT)
			// .show();
			// }
			// break;
			default:
				break;
			}
		};
	};
	//执行线程2，获得所有学校列表
	private void execute2(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", " ");
		String httpUrl = GlobalFinal.path
				.concat("school_findAllSce.action?");
		HttpService_ http = new HttpService_();
		try {
			String res = http.loginPostData(httpUrl, map);
			if (res.equals("error")) {
				Toast.makeText(RegisterPage.this, "访问服务器失败",
						3000).show();
			} else {
				// 成功
				res = res.substring(0, res.length() - 1);
				String lists = ((res.split("schList")[1]).substring(2, (res.split("schList")[1]).length()));
				JSONObject json = new JSONObject(lists);

				JSONArray arry = json.getJSONArray("list");
				schools = new String[arry.length()];
				for (int i = 0; i < arry.length(); i++) {
					JSONObject obj = arry.getJSONObject(i);
					//Map<String, String> map = new HashMap<String, String>();
					// 獲得後台數據后向bean里填充數據
					//map.put(i, obj.getString("schoolName"));
					sch.put(obj.getString("schoolName").toString(), obj.getString("id").toString());
					schools[i] = obj.getString("schoolName").toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	void setSchName(String ids){
		//sp存储，获得id的值，并保存在文件中，以便其他页面调用
				SharedPreferences share = super.getSharedPreferences(FILENAME,
						Activity.MODE_PRIVATE);	// 指定操作的文件名称
				SharedPreferences.Editor edit = share.edit(); 	// 编辑文件
				edit.putString("school", ids) ;	// 保存字符串					
				edit.commit() ;	// 提交更新
	}
}
