package com.example.ext.activity.share;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;

public class SharingWords extends Activity {
	private ImageView imv1 = null;
	private ImageView imv2 = null;
	private EditText describes = null;
	public String pId = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.sharing_words);
		this.describes = (EditText) findViewById(R.id.sw);

		this.imv1 = (ImageView) findViewById(R.id.iv_check);// 确认按钮
		this.imv2 = (ImageView) findViewById(R.id.back_to);// 确认按钮
		imv1.setOnClickListener(new OnClickListener() {
			// 点击事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Intent it = new Intent(SharingWords.this,
				// SharingRelease.class);
				// startActivity(it);
				excute();// 实现网络请求
			}
		});
		// 点击返回按钮返回上一页
		imv2.setOnClickListener(new OnClickListener() {
			// 点击事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	protected String doSharewords() {
		String httpUrl;
		String res;
		Map<String, String> map = new HashMap<String, String>();
		httpUrl = GlobalFinal.path.concat("share_saveShareWords.action?");
		// 从SharedPreference里取数据 
		String userId = gethh();
		map.put("userId", userId);
		map.put("describes", describes.getText().toString());
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		return res;

	}

	// 分享图片
	protected void shareWords(String res) {
		try {
			if ("error".equals(res)) {
				Toast.makeText(SharingWords.this, "分享失败，请重试",
						Toast.LENGTH_SHORT).show();
			} else {
				JSONObject jsonObject = new JSONObject(res);
				String result = jsonObject.getString("msg");
				Toast.makeText(SharingWords.this, "分享成功", Toast.LENGTH_SHORT)
						.show();
				DialogShow();// 显示Dialog框
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 网络请求
	protected void excute() {
		new Thread(new Runnable() {

			@Override
			public void run() {

				String res = doSharewords();
				Message msg = new Message();
				msg.what = 0;
				msg.obj = res;
				opera.sendMessage(msg);
			}
		}).start();
	}

	private Handler opera = new Handler() {
		public void handleMessage(Message msg) {
			String res = msg.obj.toString();
			switch (msg.what) {
			case 0:
				if (res != null && !res.equals("") && !res.equals("error")) {
					shareWords(res);
				} else {
					Toast.makeText(SharingWords.this, GlobalFinal.errorTip,
							Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}
		};
	};

	protected void DialogShow() {
		Dialog dialog = new AlertDialog.Builder(SharingWords.this) // 实例化对象
				.setTitle("请选择下一步操作") // 设置显示标题
				.setMessage("去分享中心看看？") // 设置显示内容
				.setPositiveButton("去看看", // 增加一个确定按钮
						new DialogInterface.OnClickListener() {// 设置操作监听
							public void onClick(DialogInterface dialog,
									int whichButton) { // 单击事件
								Intent it = new Intent(SharingWords.this,
										SharingRelease.class);
								startActivity(it);// 跳转至分享页面
							}
						}).setNeutralButton("继续分享", // 增加普通按钮
						new DialogInterface.OnClickListener() { // 设置监听操作
							public void onClick(DialogInterface dialog,
									int whichButton) {// 单击事件
								Intent it = new Intent(SharingWords.this,
										SharingWords.class);
							}
						}).setNegativeButton("取消", // 增加取消按钮
						new DialogInterface.OnClickListener() {// 设置操作监听
							public void onClick(DialogInterface dialog,
									int whichButton) {
							}
						}).create(); // 创建Dialog
		dialog.show(); // 显示对话框
	}
	private String gethh() {
		// sp存储读取用户id值
		SharedPreferences share = super.getSharedPreferences("bcit",
				Activity.MODE_PRIVATE); // 指定操作的文件名称
		// SharedPreferences.Editor edit = share.edit(); // 编辑文件
		pId = share.getString("id", "0");
		return pId;
	}
}
