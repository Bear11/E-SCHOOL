package com.example.ext.activity.trade;

import java.util.HashMap;
import java.util.Map;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.fragment.trade.LostFragment;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;

/*
 * ItemsRelease为物品发布实现类
 * 填写物品详情即可发布，选择发布时是发布的失物还是赠送物品，这里将两者在一个页面来实现了
 * 点击发布存入items表中
 * 发布后可在失物招领或赠送物品列表中找到
 * */
public class ItemsRelease extends Activity {

	protected static final int MESSAGETYPE = 0;// 线程参数
	private ImageView backButtom = null; // 返回按钮
	private TextView sendButtom = null; // 发送按钮
	private ImageView goods_addpic = null; // 添加图片
	private EditText goodsname = null; // 商品名称
	private EditText phonenumber = null; // 联系方式
	private EditText goodsdescribe = null; // 商品描述
	private String pId = ""; // 用户id
	private RadioGroup radioFlag = null ; //单选按钮
	private RadioButton cFlag1 = null; //单选按钮状态1，选择失物
	private RadioButton cFlag2 = null; //单选按钮状态2，选择赠送物品
	private int flag = 0; //定义此变量来区别是发布失物还是赠送，将其状态传递至后台

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.lost_release);
		/******************************** 实例化控件 *************************************/
		this.backButtom = (ImageView) findViewById(R.id.back);
		this.sendButtom = (TextView) findViewById(R.id.send);
		this.goods_addpic = (ImageView) findViewById(R.id.goods_add_pic);
		this.goodsname = (EditText) findViewById(R.id.goodsname);
		this.phonenumber = (EditText) findViewById(R.id.phone_number);
		this.goodsdescribe = (EditText) findViewById(R.id.goodsdescribe);
		this.radioFlag = (RadioGroup) findViewById(R.id.for_choose);
		this.cFlag1 = (RadioButton) findViewById(R.id.items_lost);
		this.cFlag2 = (RadioButton) findViewById(R.id.items_give);
        
		// 返回按钮点击事件，点击返回上以页面
		backButtom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish(); // 直接结束当前画面
			}
		});
		// 点击发送按钮，执行线程，将商品数据导入后台，存入数据库
		sendButtom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				execute();// 执行线程
			}
		});
		//对单选按钮进行监听，获得两种状态
		radioFlag.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				int a = radioFlag.getCheckedRadioButtonId();
				switch(a){
				case R.id.items_lost:
					flag = 0;	
					break;
				case R.id.items_give:
					flag = 1;
					break;
					
				}	
			}
		});
		
		
	}

	// 主线程，执行HTTP请求
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
    //对线程传回的值进行判断和处理
	private Handler operate = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.obj.toString() != null && (!msg.obj.toString().equals(""))) {
				if (!msg.obj.toString().equals("error")) {
					Toast.makeText(ItemsRelease.this, "恭喜您，物品发布成功！", GlobalFinal.tipTime3).show();
					DialogShow(); //执行toast框的显示
				} else {
					Toast.makeText(ItemsRelease.this, GlobalFinal.errorTip, GlobalFinal.tipTime3).show();
				}
			} else {
				Toast.makeText(ItemsRelease.this, GlobalFinal.errorHttp, GlobalFinal.tipTime3).show();
			}
			switch (msg.what) {
			case MESSAGETYPE:
				break;
			default: 
				break;
			}
		}
	}; 

	// 初始化数据,将页面获得的数据传至map数组，通过http请求将map的值传递给后台相应的action层获得
	protected String initData() {

		String res;
		String httpUrl;
		httpUrl = GlobalFinal.path.concat("items_saveItems.action?");
		HttpService_ http = new HttpService_();
		Map<String, String> map = new HashMap<String, String>();
		pId = gethh(); // 得到用户id值
		map.put("personId", pId); // 将用户id传至后台
		map.put("goodsname", this.goodsname.getText().toString());// 将商品名传至后台
		map.put("phonenumber", this.phonenumber.getText().toString());// 将联系方式传至后台
		map.put("goodsdescribe", this.goodsdescribe.getText().toString());// 将商品描述传至后台
		//
		map.put("flag",Integer.valueOf(flag).toString()); // 将物品类型传递给后台，0标识失物，1标识赠品
		res = http.loginPostData(httpUrl, map);
		return res;
	}

	/*
	 * function 通过sp存储方法获得用户id 
	 * 参数 无
	 *  返回 用户id
	 */
	private String gethh() {
		// sp存储读取用户id值
		SharedPreferences share = super.getSharedPreferences("bcit", Activity.MODE_PRIVATE); // 指定操作的文件名称
		// SharedPreferences.Editor edit = share.edit(); // 编辑文件
		pId = share.getString("id", "0");
		return pId;
	}
	/*
	 * function 展示toast框，以便用户选择
	 * 参数 无
	 * 返回 toast内容  
	 */
	protected void DialogShow() {
		Dialog dialog = new AlertDialog.Builder(ItemsRelease.this) // 实例化对象
				.setTitle("请选择下一步操作") // 设置显示标题
				.setMessage("去失物招领处看看？") // 设置显示内容
				.setPositiveButton("去看看", // 增加一个确定按钮
						new DialogInterface.OnClickListener() {// 设置操作监听
							public void onClick(DialogInterface dialog,
									int whichButton) { // 单击事件
								Intent it = new Intent(ItemsRelease.this,
										LostFragment.class);
								startActivity(it);// 跳转至二手市场页面
							}
						}).setNeutralButton("继续发布", // 增加普通按钮
						new DialogInterface.OnClickListener() { // 设置监听操作
							public void onClick(DialogInterface dialog,
									int whichButton) {// 单击事件
								Intent it = new Intent(ItemsRelease.this,
										ItemsRelease.class);
							}
						}).setNegativeButton("取消", // 增加取消按钮
						new DialogInterface.OnClickListener() {// 设置操作监听
							public void onClick(DialogInterface dialog,
									int whichButton) {
							}
						}).create(); // 创建Dialog
		dialog.show(); // 显示对话框
	}
}
