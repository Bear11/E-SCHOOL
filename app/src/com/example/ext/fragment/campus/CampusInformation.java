package com.example.ext.fragment.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.share.ShareComment;
import com.example.ext.activity.share.SharingCenterDetail;
import com.example.ext.activity.user.LoginPage;
import com.example.ext.common.MyListView;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.fragment.campus.adapter.CampusCommentAdapter;
import com.example.ext.fragment.campus.entity.CampusCommentEntity;
import com.example.ext.fragment.campus.entity.CampusGroundEntity;
import com.example.ext.util.HttpService_;
import com.example.ext.util.ImageLoader;

public class CampusInformation extends Activity {
	
	private ImageView Click;
	private TextView name1;
	private TextView note1;
	private TextView time1;
	private TextView click1;
	private TextView comment1;
	private TextView forward1;
	private ImageView guanzhu; 
	
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	
	private CircleImageView headImage;
	private TextView fb_dis = null; // 点击至评论页面
	private  String id;
	private String username;
	private static final String FILENAME = "bcit";
	private MyListView listview;
	private ImageLoader imageloader;
	
	private CampusCommentAdapter adapter = null;
	List<CampusCommentEntity> list = new ArrayList<CampusCommentEntity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.information_ground);
		Click=(ImageView)findViewById(R.id.dianzanshu);
		this.fb_dis = (TextView) findViewById(R.id.fb_dis);
		
		imageloader = new ImageLoader(this);
		
		SharedPreferences sp = super.getSharedPreferences(FILENAME,
				Activity.MODE_PRIVATE);
		username = sp.getString("id", "");
		
		Intent it =super.getIntent();
		id=it.getStringExtra("id");
		final String name =it.getStringExtra("name");
		final String note = it.getStringExtra("note");
		final String click = it.getStringExtra("click");
		final String comment = it.getStringExtra("comment");
		final String forward = it.getStringExtra("forward");
		final String time=it.getStringExtra("time");
		final String head = it.getStringExtra("head");
		final String I1= it.getStringExtra("image1");
		final String I2= it.getStringExtra("image2");
		final String I3= it.getStringExtra("image3");
		
		
		name1=(TextView)findViewById(R.id.user_name);
		note1=(TextView)findViewById(R.id.edittext1);
		time1=(TextView)findViewById(R.id.tv_nowtime);
		click1=(TextView)findViewById(R.id.click_num);
		comment1=(TextView)findViewById(R.id.tv_discribe);
		forward1=(TextView)findViewById(R.id.tv_zfnum);
		listview=(MyListView)findViewById(R.id.com_list);
		guanzhu=(ImageView)findViewById(R.id.img_lookat);
		
		headImage=(CircleImageView)findViewById(R.id.img_pic);
		
		image1=(ImageView)findViewById(R.id.item_image_00);
		image2=(ImageView)findViewById(R.id.item_image_11);
		image3=(ImageView)findViewById(R.id.item_image_22);
		
		name1.setText(name);
		note1.setText(note);
		time1.setText(time);
		click1.setText(click);
		comment1.setText(comment);
		forward1.setText(forward);
		
		imageloader.DisplayImage(head,headImage);
		imageloader.DisplayImage(I1,image1);
		imageloader.DisplayImage(I2,image2);
		imageloader.DisplayImage(I2,image3);
		
		final String num=String.valueOf(Integer.valueOf(click)+1);
		
		excute(1);
		
		Click.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String res;
				String httpUrl;
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", username);//campus_surround的id
				map.put("clicknum", click);
				httpUrl = GlobalFinal.path.concat("click_addClick.action?");
				HttpService_ http = new HttpService_();
				res = http.loginPostData(httpUrl, map);
				Toast.makeText(CampusInformation.this, "贊！！", Toast.LENGTH_SHORT).show();
				click1.setText(num);
			}
		});
		guanzhu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String res;
				String httpUrl;
				Map<String, String> map = new HashMap<String, String>();
				if(id.equals(username))
				{
					Toast.makeText(CampusInformation.this, "请勿关注自己", Toast.LENGTH_SHORT).show();
				}
				else
				{
				
					map.put("id", id);
					map.put("username", username);
					httpUrl = GlobalFinal.path.concat("click_focus.action?");
					HttpService_ http = new HttpService_();
					res = http.loginPostData(httpUrl, map);
					Toast.makeText(CampusInformation.this, "已关注！！", Toast.LENGTH_SHORT).show();
					click1.setText(num);
				}
			}
		});
		
		this.fb_dis.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				comment();
				comment1();
			}
		});
	}
	protected String doLogin() {
		String res;
		String httpUrl;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		httpUrl = GlobalFinal.path.concat("click_firstComment.action?");
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			//{"list":[{"id":"1","userAct":"154","imageUrl":"","commentTime":"2016-10-27","content":"聽說名字的長短，可以影響到評論"}]}}
			JSONObject json =new JSONObject(lists);
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				list.add(new CampusCommentEntity(obj.getString("userAct"),obj.getString("imageUrl"),obj.getString("commentTime"),obj.getString("content")));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		adapter=new CampusCommentAdapter(this, list);
		adapter.notifyDataSetChanged();
		listview.setAdapter(adapter);
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
//						case 2:
//							String res2 = doRegister();
//							Message msg2 = new Message();
//							msg2.what = 1;
//							msg2.obj = res2;
//							opera.sendMessage(msg2);
//							break;

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
					Toast.makeText(CampusInformation.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
							.show();
				}
				break;
//			case 1:
//				if (res != null && !res.equals("") && !res.equals("error")) {
//					register(res);
//				} else {
//					Toast.makeText(LoginActivity.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
//							.show();
//				}
//				break;
			default:
				break;
			}
		};
	};
	
	
	private void comment() {
		Intent it = new Intent(CampusInformation.this, CampusInformationComment.class); // 实例化Intent
		it.putExtra("id", id);
		startActivity(it);
	}

	private void comment1() {
		/*int b = Integer.valueOf(tv_disnum.getText().toString());// 获得评论数
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", shareId);
		map.put("disnum", tv_disnum.getText().toString());
		String httpUrl = GlobalFinal.path.concat("share_addSharePls.action?");
		HttpService_ http = new HttpService_();
		try {
			String res = res = http.loginPostData(httpUrl, map);
			if (res.equals("error")) {
				Toast.makeText(SharingCenterDetail.this, "访问服务器失败", 5000)
						.show();
			} else {
				// 成功
				b++; // 评论数加1
				tv_disnum.setText(Integer.valueOf(b).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}

