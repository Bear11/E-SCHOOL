package com.example.ext.fragment.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.activities.ActivityDetail;
import com.example.ext.activity.activities.bean.ActivitiesAdapter;
import com.example.ext.activity.activities.bean.ActivitiesBean;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.pullRefrash.PullDownListView;
import com.example.ext.util.HttpService_;
import com.example.ext.util.SetInternetUtil;

public class ActivityRecruitment extends Fragment implements
PullDownListView.OnRefreshListioner{
	
	private View parentView;	
	private ActivitiesAdapter adapter;
	private ListView mListView;
	private List<ActivitiesBean> mData = new ArrayList<ActivitiesBean>();
	public static final int MESSAGETYPE = 0;// ��Ϣ����
	private ArrayList<Map<String, Object>> list1;
	private PullDownListView mPullDownView = null;
	private Handler mHandler = new Handler();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView=inflater.inflate(R.layout.activity_recruitment, container, false);
		mPullDownView = (PullDownListView) parentView
				.findViewById(R.id.data_list);
		// this.ed1 = (TextView) parentView.findViewById(R.id.edittext1);
		mPullDownView.setRefreshListioner(this);
		mListView = mPullDownView.mListView;
		if (SetInternetUtil.isNetworkConnected(getActivity())) { // 判断网络是否可用，并设置网络
			execute();
		}
		return parentView;
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
				initListView(msg.obj.toString());
			} else {
				Toast.makeText(getActivity(), "解析出错", 3000).show();
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
		httpUrl = GlobalFinal.path.concat("act_findAllAct.action?");
		Map<String, String> map = new HashMap<String, String>();
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

	// 程序逻辑：后台将数据传至前台，解析完将字符串存至Bean集合，然后适配器由此获得源数据，并将结果传至Listview进行显示。
	protected void initListView(String res) {
		try {

			String lists = ((res.split("actList")[1]).substring(2,
					(res.split("actList")[1]).length()));
			JSONObject json = new JSONObject(lists);

			JSONArray arry = json.getJSONArray("list");
			for (int i = 0; i < arry.length(); i++) {
				JSONObject obj = arry.getJSONObject(i);
				Map<String, String> map = new HashMap<String, String>();
				this.mData.add(new ActivitiesBean(obj.getString("id"), obj
						.getString("actTime"), obj.getString("topic"), obj
						.getString("address"), obj.getString("discribe"), obj
						.getString("picture"), obj.getString("personId"), obj
						.getString("state"), obj.getString("playTime"), obj
						.getString("deadLine"), obj
						.getString("limitNumber"), obj
						.getString("remainNumber"), obj
						.getString("price")));
			}
			// 使用的是getActivity来获取Fragment中包含的activity，获得当前对象，相当于this的功能
			adapter = new ActivitiesAdapter(getActivity(), mData);// 第一参数也可能是getActivity().getApplicationContext()
			mListView.setAdapter(adapter);
			/*if (adapter != null) {
				adapter.notifyDataSetChanged();
			} else {
				mListView.setAdapter(adapter);
			}*/

			// 设置点击事件
			this.mListView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					ActivitiesBean map = (ActivitiesBean) ActivityRecruitment.this.adapter
							.getItem(arg2-1);					
					String aid = map.getId();// 活动表id
					String pid = map.getPersonId();// 发布者id
					// 带值跳转
					Intent it = new Intent(getActivity(),
							ActivityDetail.class); // 实例化Intent
					it.putExtra("aid", aid);
					it.putExtra("pid", pid);
					ActivityRecruitment.this.startActivity(it);
 
				 
				}
			});
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		mHandler.postDelayed(new Runnable() {

			public void run() {
				if (SetInternetUtil.isNetworkConnected(getActivity())) { // 判断网络是否可用，并设置网络
					mData.clear();
					execute();
					// if (sa != null) {
					// sa.notifyDataSetChanged();
					// }
				}
				mPullDownView.onRefreshComplete();// 这里表示刷新处理完成后把上面的加载刷新界面隐藏

			}
		}, 1000);
	}
	@Override 
	public void onLoadMore() {
		// TODO Auto-generated method stub
		mHandler.postDelayed(new Runnable() {
			public void run() {
				if (SetInternetUtil.isNetworkConnected(getActivity())) { // 判断网络是否可用，并设置网络
					execute();
					// 自动置底————不自动置底TRANSCRIPT_MODE_DISABLED
				}
				mPullDownView.onLoadMoreComplete();// 这里表示加载更多处理完成后把下面的加载更多界面（隐藏或者设置字样更多）
			}
		}, 1000);
	}
	}
	

/*public class ActivityRecruitment extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recruitment);
	
}	
}*/