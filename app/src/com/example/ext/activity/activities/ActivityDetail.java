package com.example.ext.activity.activities;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.user.PersonalcenterAccess;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;
import com.example.ext.util.ImageLoader;

public class ActivityDetail extends Activity {
	protected static final int MESSAGETYPE = 0;
	private ImageView imv1 = null; // 活动图片
	private ImageView back = null; // 返回按钮
	private ImageView xialakuang = null; // 下拉框
	private ImageView phonecall = null; // 电话图标
	private ImageView likeiton = null; // 收藏
	private TextView topic = null; // 主题
	private TextView username = null; // 发布人
	private TextView timeup = null; // 截止时间
	private TextView activityTime = null; // 活动时间
	private TextView address = null; // 活动地址
	private TextView number = null; // 报名人数
	private TextView shengyu = null; // 剩余票数
	private TextView price = null; // 价格
	private TextView describe = null; // 活动详情
	private TextView join = null; // 报名按钮
	private String actId = "";// 活动表id
	private String actPId = "";// 活动分享者id
	private String pId = "";// 用户id
	private String pName = "";// 用户名
    private ImageView picshow = null;//商品图片
    private ImageLoader imageLoader;//引用
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.activity_detail);
		this.topic = (TextView) findViewById(R.id.topic);
		this.username = (TextView) findViewById(R.id.username);
		this.timeup = (TextView) findViewById(R.id.timeup);
		this.activityTime = (TextView) findViewById(R.id.activity_time);
		this.address = (TextView) findViewById(R.id.address);
		this.number = (TextView) findViewById(R.id.act_number);
		this.shengyu = (TextView) findViewById(R.id.shengyu);
		this.price = (TextView) findViewById(R.id.price);
		this.describe = (TextView) findViewById(R.id.describe_details);
		this.join = (TextView) findViewById(R.id.join);
		this.back = (ImageView) findViewById(R.id.back);
		this.phonecall = (ImageView) findViewById(R.id.img_call);
		this.likeiton = (ImageView) findViewById(R.id.img_like);
		this.xialakuang = (ImageView) findViewById(R.id.xialakuang);
		this.picshow = (ImageView) findViewById(R.id.pic_show);
		Intent it = super.getIntent(); // 取得启动此程序的Intent
		actId = it.getStringExtra("aid"); // 取得设置的活动表id
		actPId = it.getStringExtra("pid"); // 取得设置的活动分享者id

		execute();
		// 监听返回按钮
		this.back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		// 点击用户名进入个人访问页面
		this.username.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(ActivityDetail.this,
						PersonalcenterAccess.class);
				startActivity(it);
			}
		});
		// 点击参与活动按钮执行此线程
		this.join.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				executeActjoin();
			}
		});
		// 点击下拉框按钮
		this.xialakuang.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		// 点击收藏按钮
		this.likeiton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*
				 * String res; String httpUrl; httpUrl =
				 * GlobalFinal.path.concat("share_findByShareId.action?");
				 * HttpService_ http = new HttpService_(); Map<String, String>
				 * map = new HashMap<String, String>(); map.put("actId",
				 * actId);// 把活动表id传至我的收藏后台 res = http.loginPostData(httpUrl,
				 * map); if (res.equals("error")) {
				 * Toast.makeText(ActivityDetail.this, "收藏失败，请重试", 3000).show();
				 * } else { Toast.makeText(ActivityDetail.this,
				 * "恭喜您，收藏成功，可以在我的收藏找到哦！", 3000).show(); }
				 */
				Toast.makeText(ActivityDetail.this, "恭喜您，收藏成功...", 3000)
						.show();
			}
		});
		this.phonecall.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("unused")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String phonenumber = "18850565256";
				// 如果输入不为空创建打电话的Intent
				if (phonenumber != null) {
					Intent phoneIntent = new Intent(
							"android.intent.action.CALL", Uri.parse("tel:"
									+ phonenumber));
					startActivity(phoneIntent);
				} else {
					Toast.makeText(ActivityDetail.this, "此用户还未添加电话号码",
							Toast.LENGTH_LONG).show();
				}
			}
		});

	}

	private void execute() {
		try {
			new Thread(new Runnable() {// ����һ���̵߳ķ��������ڰ�׿�����̨��������
						@Override
						public void run() {
							// ����������ݼ���ʵ�ִ���
							String res = initData();
							Message msg_netData = new Message();
							msg_netData.obj = res;
							msg_netData.what = MESSAGETYPE;// ��Ϊ�̵߳ı�ʶ�����ܺ�����в�ͬ��С�Ǵ���
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
				initListView(msg.obj.toString());
			} else {
				Toast.makeText(ActivityDetail.this, "解析出错", 3000).show();
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

		String res;
		String httpUrl;
		httpUrl = GlobalFinal.path.concat("act_findByActivitiesId.action?");
		HttpService_ http = new HttpService_();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", actId);// 把id传至后台
		res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		} else {

		}
		return res;
	}

	// 得到值了进行解析和初始化数据
	protected void initListView(String res) {
		try {

			JSONObject obj = new JSONObject(res);
			obj = obj.getJSONObject("activities");

			// 通过用户id来获得用户名等信息
			pName = getPersonName(actPId);
			this.username.setText(pName);// 对取得的用户id进行显示
			this.topic.setText(obj.getString("activities.topic").toString());
			this.timeup
					.setText(obj.getString("activities.deadLine").toString());
			this.activityTime.setText(obj.getString("activities.actTime")
					.toString());
			this.address
					.setText(obj.getString("activities.address").toString());
			this.number.setText(obj.getString("activities.limitNumber")
					.toString());
			this.shengyu.setText(obj.getString("activities.remainNumber")
					.toString());
			this.price.setText(obj.getString("activities.price").toString());
			this.describe.setText(obj.getString("activities.discribe")
					.toString());
			this.price.setText(obj.getString("activities.price").toString());
            String picString = "";
            picString = obj.getString("activities.picture").toString();
            imageLoader = new ImageLoader(getBaseContext()); 
            imageLoader.DisplayImage(picString,picshow,R.drawable.plugin_camera_no_pictures);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private String gethh() {
		// sp存储读取用户id值
		SharedPreferences share = super.getSharedPreferences("bcit",
				Activity.MODE_PRIVATE); // 指定操作的文件名称
		// SharedPreferences.Editor edit = share.edit(); // 编辑文件
		pId = share.getString("id", "0");
		return pId;
	}

	// 通过用户id来获得用户名
	private String getPersonName(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		String httpUrl = GlobalFinal.path.concat("user_findByUserId.action?");
		HttpService_ http = new HttpService_();
		try {
			String res = res = http.loginPostData(httpUrl, map);
			if (res.equals("error")) {
				Toast.makeText(ActivityDetail.this, "用户名无法获取", 5000).show();
			} else {
				JSONObject obj = new JSONObject(res);
				obj = obj.getJSONObject("userInformation");
				pName = obj.getString("userInformation.userAct").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pName;

	}

	private void executeActjoin() {
		try {
			new Thread(new Runnable() {// ����һ���̵߳ķ��������ڰ�׿�����̨��������
						@Override
						public void run() {
							// ����������ݼ���ʵ�ִ���
							String res = initActData();
							Message msg_netData = new Message();
							msg_netData.obj = res;
							msg_netData.what = MESSAGETYPE;// ��Ϊ�̵߳ı�ʶ�����ܺ�����в�ͬ��С�Ǵ���
							operate1.sendMessage(msg_netData);
						}
					}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Handler operate1 = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.obj.toString() != null && (!msg.obj.toString().equals(""))) {
				if (msg.obj.toString().equals("error")) {
					Toast.makeText(ActivityDetail.this, "报名失败，请重试", 3000)
							.show();
				} else {
					Toast.makeText(ActivityDetail.this, "恭喜您，报名成功，请准时参加活动哦！",
							3000).show();
				}
			} else {
				Toast.makeText(ActivityDetail.this, "解析出错", 3000).show();
			}
			switch (msg.what) {
			case MESSAGETYPE:
				break;
			default:
				break;
			}
		}
	};

	protected String initActData() {
		String httpUrl;
		String res;
		httpUrl = GlobalFinal.path.concat("actj_saveActJoin.action?");
		Map<String, String> map = new HashMap<String, String>();
		HttpService_ http = new HttpService_();
		// Map<String, String> map1 = new HashMap<String, String>();
		pId = gethh();
		map.put("pId", pId);// 把用户id传至后台
		map.put("actId", actId);// 把活动表id传至后台
		res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		} else {
			res = res.substring(0, res.length() - 1);
		}
		return res;
	}

}
