package com.example.ext.fragment.campus;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.HttpService_;

public class CampusInformationComment extends Activity {

	protected static final int MESSAGETYPE = 0;
	private EditText ed1 = null;
	private TextView tv_send = null;
	private RelativeLayout layout;
	private String describe = null;
	public String pId = " "; // 用户id
	private String username;
	private String cid;
	private static final String FILENAME = "bcit";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.share_comment);
		this.ed1 = (EditText) findViewById(R.id.fb_dis);
		this.tv_send = (TextView) findViewById(R.id.send);
		layout = (RelativeLayout) findViewById(R.id.pop_layout);
		// 很重要的一句，避免了layout两边有间隙
		getWindow().setLayout(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);

		
		/*
		 * 添加选择窗口范围监听可以优先获取触点，即不再执行onTouchEvent()函数，
		 * 点击其他地方时执行onTouchEvent()函数销毁Activity
		 */
		// layout.setOnClickListener(new OnClickListener() {
		//
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Toast.makeText(getApplicationContext(), "提示：点击窗口外部关闭窗口！",
		// Toast.LENGTH_SHORT).show();
		// }
		// });
		tv_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				execute();
				finish();
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
			if ("error".equals(msg)) {
				Toast.makeText(CampusInformationComment.this, "评论失败，请重试",
						Toast.LENGTH_SHORT).show();
				/*Intent it = new Intent(ShareComment.this, SharingCenterDetail.class); // 实例化Intent
				it.putExtra("vaule","error");	
				startActivity(it);*/
			} else {
				Toast.makeText(CampusInformationComment.this, "评论成功", Toast.LENGTH_SHORT)
						.show();
				/*Intent it = new Intent(ShareComment.this, SharingCenterDetail.class); // 实例化Intent
				it.putExtra("vaule","success");	
				startActivity(it);*/
				//finish(); // 跳转回评论页面
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
		httpUrl = GlobalFinal.path
				.concat("click_comment.action?");
		HttpService_ http = new HttpService_();
		Map<String, String> map = new HashMap<String, String>();
		describe = ed1.getText().toString();
		Intent it =super.getIntent();
		cid=it.getStringExtra("id");	
		SharedPreferences sp = super.getSharedPreferences(FILENAME,
				Activity.MODE_PRIVATE);
		username = sp.getString("id", "");
		//Intent it = super.getIntent(); // 取得启动此程序的Intent
		//pId = gethh(); // 取得设置的評論人id
		//final String shareId = it.getStringExtra("id"); // 取得设置的分享表id
		map.put("id", cid);// 把id传至后台
		map.put("describe", describe.toString());
		map.put("username", username);
		res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		} else {
		}
		return res;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

	String gethh() {
		// sp存储读取用户id值
		SharedPreferences share = super.getSharedPreferences("bcit",
				Activity.MODE_PRIVATE); // 指定操作的文件名称
		// SharedPreferences.Editor edit = share.edit(); // 编辑文件

		pId = share.getString("id", "0");
		return pId;
	}

}
