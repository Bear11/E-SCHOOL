package com.example.ext.activity.activities;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.baseData.GlobalStatic;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;

public class ActivityRelease extends Activity {

	protected static final int MESSAGETYPE = 0;
	private EditText acti_theme = null;
	private EditText timeup = null;
	private EditText acti_time = null;
	private EditText address = null;
	private EditText number = null;
	private EditText money = null;
	private EditText describe_details = null;
	private ImageView add_pic = null;
	private ImageView iv_check = null;
	private TextView t_fabu = null;
	private Button timepicker = null;
	private Button timepicker1 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		GlobalStatic.setFlagImageUp(1);// 设置图片上传类型
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.activity_release);
		// this.imv1 = (ImageView)findViewById(R.id.back);
		this.acti_theme = (EditText) findViewById(R.id.acti_theme);
		this.timeup = (EditText) findViewById(R.id.timeup);
		this.acti_time = (EditText) findViewById(R.id.acti_time);
		this.address = (EditText) findViewById(R.id.address);
		this.number = (EditText) findViewById(R.id.number);
		this.money = (EditText) findViewById(R.id.money);
		this.describe_details = (EditText) findViewById(R.id.describe_details);
		this.add_pic = (ImageView) findViewById(R.id.add_pic);
		this.iv_check = (ImageView) findViewById(R.id.iv_check);
		this.timepicker = (Button)findViewById(R.id.timepicker);
		this.timepicker1 = (Button)findViewById(R.id.timepicker1);
		this.t_fabu = (TextView)findViewById(R.id.t_fabu);
		this.t_fabu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				execute();
			}
		});

		this.timepicker.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Dialog dialog = new DatePickerDialog(ActivityRelease.this,// 当前上下文
						new DatePickerDialog.OnDateSetListener() { // 事件监听
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) { // 日期改变时触发
								timeup.setText(year + "-" + monthOfYear + "-"
										+ dayOfMonth); // 设置文本内容
							}}, 2016, 6, 29); // 默认的年、月、日
				dialog.show(); // 显示对话框
			}
		});
		this.timepicker1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Dialog dialog = new DatePickerDialog(ActivityRelease.this,// 当前上下文
						new DatePickerDialog.OnDateSetListener() { // 事件监听
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) { // 日期改变时触发
								acti_time.setText(year + "-" + monthOfYear + "-"
										+ dayOfMonth); // 设置文本内容
							}}, 2016, 6, 29); // 默认的年、月、日
				dialog.show(); // 显示对话框
			}
		});

	}

	private void execute() {
		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					String res = initData();
					Message msg_netData = new Message();
					msg_netData.obj = res;
					msg_netData.what = MESSAGETYPE;
					operate.sendMessage(msg_netData);
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Handler operate = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.obj.toString() != null && (!msg.obj.toString().equals(""))) {
				if (msg.obj.toString().equals("error"))
					Toast.makeText(ActivityRelease.this, "发表失败，请重试", 3000)
							.show();
				else
					Toast.makeText(ActivityRelease.this, "发表成功", 3000).show();

			} else {
				Toast.makeText(ActivityRelease.this, "解析出错", 3000).show();
			}
			switch (msg.what) {
			case MESSAGETYPE:
				break;
			default:
				break;
			}
		}
	};

	protected String initData() {
		String httpUrl;
		String res;
		final String acti_theme = this.acti_theme.getText().toString();
		final String timeup = "";// this.timeup.getText().toString();
		final String acti_time = "";// this.acti_time.getText().toString();
		final String address = this.address.getText().toString();
		final String number = this.number.getText().toString();
		final String money = "";// this.money.getText().toString();
		final String describe_details = this.describe_details.getText()
				.toString();
		httpUrl = GlobalFinal.path.concat("act_saveAct.action?");
		Map<String, String> map = new HashMap<String, String>();
		map.put("acti_theme", String.valueOf(acti_theme));// 页码
		map.put("timeup", String.valueOf(timeup));//
		map.put("acti_time", String.valueOf(acti_time));
		map.put("address", String.valueOf(address));
		map.put("number", String.valueOf(number));
		map.put("money", String.valueOf(money));
		map.put("describe_details", String.valueOf(describe_details));

		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		}

		else {
			res = res.substring(0, res.length() - 1);// ȥ���Ҵ����ţ�����ʣ���ַ�
		}

		return res;
	}
}
