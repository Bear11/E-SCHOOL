package com.example.ext.activity.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.campus.bean.SeceneryBean;
import com.example.ext.activity.campus.bean.SeceneryListAdapter;
import com.example.ext.activity.campus.bean.SeceneryListAdapter.AtPicTo1;
import com.example.ext.activity.campus.bean.SeceneryListAdapter.AtPicTo2;
import com.example.ext.activity.campus.bean.SeceneryListAdapter.AtPicTo3;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.baseData.GlobalStatic;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;
import com.example.ext.util.SetInternetUtil;
import com.example.ext.util.picStringToArray;

public class SeceneryAlbum extends Activity implements AtPicTo1, AtPicTo2, AtPicTo3 {

	/************************** 定义控件 ************************************/
	protected static final int MESSAGETYPE = 0;
	private ListView listview; // listView
	private SeceneryListAdapter adapter; // 列表adapter
	private List<SeceneryBean> mData = new ArrayList<SeceneryBean>();
	private String[] url;
	/*private AtPicTo1 mPicTo1 ;
	private AtPicTo1 mPicTo2;
	private AtPicTo1 mPicTo3;*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secenery_album);
		this.listview = (ListView) findViewById(R.id.list_view);
		// Toast.makeText(SeceneryAlbum.this, "hello world", 3000).show();
		//listview.setAdapter(adapter);
		// 判断网络是否可用，并设置网络
		if (SetInternetUtil.isNetworkConnected(this)) {
			// 如果网络OK的话则执行线程
			execute();
			// listview.setAdapter(adapter);
		}
	}

	// 线程定义，访问后台
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
				Toast.makeText(SeceneryAlbum.this, GlobalFinal.errorHttp, 3000).show();
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
		httpUrl = GlobalFinal.path.concat("sceView_findAllSceView.action?");
		Map<String, String> map = new HashMap<String, String>();
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		} else {
			res = res.substring(0, res.length() - 1);
		}
		return res;
	}

	// 程序逻辑：后台将数据传至前台，解析完将字符串存至Bean集合，然后适配器由此获得源数据，并将结果传至Listview进行显示。
	/**
	 * @param res
	 */
	protected void initListView(String res) {
		try {
			String lists = ((res.split("sceViList")[1]).substring(2, (res.split("sceViList")[1]).length()));
			JSONObject json = new JSONObject(lists);

			JSONArray arry = json.getJSONArray("list");
			for (int i = 0; i < arry.length(); i++) {
				JSONObject obj = arry.getJSONObject(i);
				Map<String, String> map = new HashMap<String, String>();
				// 獲得後台數據后向bean里填充數據
				this.mData.add(new SeceneryBean(obj.getString("id"),obj.getString("schoolId"),obj.getString("schoolName"),obj.getString("innerSchool"), obj.getString("outSchool"), obj.getString("byCasual")));
			}
			// 使用的是getActivity来获取Fragment中包含的activity，获得当前对象，相当于this的功能
			adapter = new SeceneryListAdapter(this, mData,this,this,this);//
			// 第一参数也可能是getActivity().getApplicationContext()
			listview.setAdapter(adapter);

			// 设置点击事件
			/*
			 * this.listview.setOnItemClickListener(new OnItemClickListener() {
			 * 
			 * @Override public void onItemClick(AdapterView<?> arg0, View arg1,
			 * int arg2, long arg3) { SeceneryBean map = (SeceneryBean)
			 * SeceneryAlbum.this.adapter.getItem(arg2 - 1); String sid =
			 * map.getId();// 分享id //String pid = map.getPersonId();// 分享者id
			 * //String pname = map.getName(); // 分享者名称 // 带值跳转 Intent it = new
			 * Intent(SeceneryAlbum.this, SeceneryAlbumDetail.class); //
			 * 实例化Intent it.putExtra("sid", sid); //it.putExtra("pid", pid);
			 * //it.putExtra("pname", pname);
			 * SeceneryAlbum.this.startActivity(it); }
			 * 
			 * });
			 */
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 点击校内美景跳转至美景详情页面
	@Override
	public void click1(View v) {
		// TODO Auto-generated method stub
		/*String img1 = mData.get((Integer) v.getTag()).getInnerSchool().toString();
		int b = (Integer) v.getTag();
		picStringToArray ss = new picStringToArray();
		url = ss.stringToArray(img1);
		
		GlobalStatic.setmData(url);  
		Intent it = new Intent(SeceneryAlbum.this, SeceneryAlbumDetail.class);
	    //将图片信息传递给img1变量
		//it.putExtra("img1", img1);
		startActivity(it);*/
	}

	// 点击校园周边跳转至周边图片详情页面
	@Override
	public void click2(View v) {
		// TODO Auto-generated method stub
		/*String img1 = mData.get((Integer) v.getTag()).getOutSchool().toString();
		picStringToArray ss = new picStringToArray();
		url = ss.stringToArray(img1);
		GlobalStatic.setmData(url);  
		Intent it = new Intent(SeceneryAlbum.this, SeceneryAlbumDetail.class);
	    //将图片信息传递给img1变量
		//it.putExtra("img1", img1);
		startActivity(it);*/

	}

	// 点击随手拍跳转至随手拍详情页面
	@Override
	public void click3(View v) {
		// TODO Auto-generated method stub
	    /*String img1 = mData.get((Integer) v.getTag()).getByCasual().toString();
	    picStringToArray ss = new picStringToArray();
		url = ss.stringToArray(img1);
		GlobalStatic.setmData(url);  
		Intent it = new Intent(SeceneryAlbum.this, SeceneryAlbumDetail.class);
	    //将图片信息传递给img1变量
		//it.putExtra("img1", img1);
		startActivity(it);*/
	}

}
