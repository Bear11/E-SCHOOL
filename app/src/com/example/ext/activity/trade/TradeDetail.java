package com.example.ext.activity.trade;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;
import com.example.ext.util.ImageLoader;

public class TradeDetail extends Activity {

	public static final int MESSAGETYPE = 0;
	// private String personId = null;//分享者id
	private ImageView iv_back = null; // 返回按钮
	private TextView iv_jubao = null; // 举报
	private ImageView iv_tradepic = null;// 物品图片，后面实现
	private TextView tv_goodsprice = null; // 商品价格
	private TextView tv_buyicon = null; // 购买按钮

	private ImageView iv_userpic = null; // 用户头像
	private TextView tv_username = null; // 用户名
	private ImageView iv_sex = null; // 用户性别，在适配器中判断好显示
	private TextView tv_nowtime = null; // 发表的时间
	private TextView tv_inschool = null; // 所在学校
	private TextView tv_describe = null; // 物品描述
	private TextView tv_pnum = null; // 电话号码
	private TextView tr_dis = null; // 评论区点击按钮，点击评论
	private ImageView goods = null; // 商品图片
	private String gid = ""; // 商品id
	private String pid = ""; // 商品发布人id
	private String pname = ""; // 商品发布人姓名
	private String phoneNum = ""; // 电话号码
	private ImageLoader imageLoader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.trade_detail);

		/******************************** 实例化控件 *************************************/
		this.iv_back = (ImageView) findViewById(R.id.back);
		this.iv_jubao = (TextView) findViewById(R.id.jubao);
		this.tv_goodsprice = (TextView) findViewById(R.id.goods_price);
		this.tv_buyicon = (TextView) findViewById(R.id.buy_icon);
		this.iv_userpic = (ImageView) findViewById(R.id.td_img_pic);
		this.tv_username = (TextView) findViewById(R.id.td_user_name);
		this.tv_nowtime = (TextView) findViewById(R.id.td_now_time);
		this.tv_inschool = (TextView) findViewById(R.id.td_inschool);
		this.tv_describe = (TextView) findViewById(R.id.td_trade_dsc);
		this.tv_pnum = (TextView) findViewById(R.id.phone_num);
		this.goods = (ImageView) findViewById(R.id.trade_pic);

		// 接收TradeFragment的Intent传值
		Intent it = super.getIntent();
		gid = it.getStringExtra("gid"); // 取得商品id，以便于查询商品详情信息
		pid = it.getStringExtra("pid"); // 取得发布人id
		pname = it.getStringExtra("pname"); // 取得商品发布人id名字
		execute(); // 执行线程

		// 点击购买按钮
		tv_buyicon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog();
			}
		});
		// 点击返回按钮
		iv_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	/*
	 * 线程定义 执行线程，获得商品详情信息
	 */
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
				initListView(msg.obj.toString());
			} else {
				Toast.makeText(TradeDetail.this, "解析出错", 3000).show();
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
		httpUrl = GlobalFinal.path.concat("goodsV_findById.action?");
		HttpService_ http = new HttpService_();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", gid);// 把商品id传至后台
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
			// 获得Jason串，取得其中的商品信息
			JSONObject obj = new JSONObject(res);
			obj = obj.getJSONObject("goodsView"); // 得到JSON对象
			String price = obj.getString("goodsView.price").toString(); // 得到商品价格
			String pname = obj.getString("goodsView.pname").toString(); // 得到用户名
			String playTime = obj.getString("goodsView.playTime").toString(); // 得到发表时间
			String school = obj.getString("goodsView.school").toString(); // 得到用户所在学校
			String discribe = obj.getString("goodsView.discribe").toString(); // 得到商品描述
			String phoneNumber = obj.getString("goodsView.phoneNumber")
					.toString(); // 得到联系方式
			phoneNum = phoneNumber; // 传递给全局变量
			String goodsPic = obj.getString("goodsView.imageUrl").toString(); // 得到商品图片
			tv_goodsprice.setText(price);// 对取得的商品价格进行显示
			tv_username.setText(pname);// 对取得的用户名进行显示
			tv_nowtime.setText(playTime); // 对取得的发布时间进行显示
			tv_inschool.setText(school); // 对用户所在学校进行显示
			tv_describe.setText(discribe); // 对取得的商品描述进行显示
			String phoneNumber1 = phoneNumber.substring(0, 3) + "********"
					+ phoneNumber.substring(11, phoneNumber.length());
			tv_pnum.setText(phoneNumber1); // 对取得的电话号码进行显示
			// 显示商品图片
			imageLoader = new ImageLoader(getBaseContext());
			boolean isNet = true;
			if (isNet) {
				imageLoader.DisplayImage(goodsPic, goods,
						R.drawable.plugin_camera_no_pictures);
			} else {
				File file = new File(goodsPic);
				if (file.exists()) {
					Bitmap bitmap = BitmapFactory.decodeFile(goodsPic);
					this.goods.setImageBitmap(bitmap);
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	protected void dialog() {
		/*
		 * Builder dialog = new AlertDialog.Builder(TradeDetail.this); // 实例化对象
		 * builder.setMessage("确认要联系卖主吗？"); builder.setTitle("提示");
		 * builder.setPositiveButton("直接联系", new OnClickListener() {
		 * 
		 * @Override public void onClick(DialogInterface arg0, int arg1) { //
		 * TODO Auto-generated method stub arg0.dismiss(); // 对话框消失 if (phoneNum
		 * != "") { Intent phoneIntent = new Intent(
		 * "android.intent.action.CALL", Uri.parse("tel:" + phoneNum));
		 * startActivity(phoneIntent); } else { Toast.makeText(TradeDetail.this,
		 * "此用户还未添加电话号码", Toast.LENGTH_LONG).show(); } }
		 * }).setNegativeButton("取消", new OnClickListener() {
		 * 
		 * @Override public void onClick(DialogInterface arg0, int arg1) { //
		 * TODO Auto-generated method stub arg0.dismiss(); // 对话框消失 } });
		 * builder.show();
		 */
		Dialog dialog = new AlertDialog.Builder(TradeDetail.this) // 实例化对象
				.setIcon(R.drawable.icon_phone_blue) // 设置显示图片
				.setTitle("确定信息") // 设置显示标题
				.setMessage("确认要联系卖主吗？") // 设置显示内容
				.setPositiveButton("直接联系", // 增加一个确定按钮
						new DialogInterface.OnClickListener() {// 设置操作监听
							public void onClick(DialogInterface dialog,
									int whichButton) { // 单击事件
								dialog.dismiss(); // 对话框消失
								if (phoneNum != "") {
									Intent phoneIntent = new Intent(
											"android.intent.action.CALL", Uri
													.parse("tel:" + phoneNum));
									startActivity(phoneIntent);
								}
							}
						}).setNeutralButton("小纸条", // 增加普通按钮
						new DialogInterface.OnClickListener() { // 设置监听操作
							public void onClick(DialogInterface dialog,
									int whichButton) {// 单击事件
								dialog.dismiss(); // 对话框消失
								Toast.makeText(TradeDetail.this, "功能开发中...",
										Toast.LENGTH_LONG).show();
							}
						}).setNegativeButton("取消", // 增加取消按钮
						new DialogInterface.OnClickListener() {// 设置操作监听
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss(); // 对话框消失
							}
						}).create(); // 创建Dialog
		dialog.show(); // 显示对话框
	}
}
