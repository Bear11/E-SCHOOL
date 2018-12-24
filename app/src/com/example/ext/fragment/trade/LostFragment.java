package com.example.ext.fragment.trade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.trade.ItemsRelease;
import com.example.ext.activity.trade.bean.ItemsViewAdapter;
import com.example.ext.activity.trade.bean.ItemsViewAdapter.AtCallback;
import com.example.ext.activity.trade.bean.ItemsViewBean;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.pullRefrash.PullDownListView;
import com.example.ext.util.HttpService_;
import com.example.ext.util.SetInternetUtil;

public class LostFragment extends Fragment implements PullDownListView.OnRefreshListioner, AtCallback {

	private View parentView = null;
	private ItemsViewAdapter adapter; // 适配器的定义
	private ListView mListView; // ListView
	private List<ItemsViewBean> mData = new ArrayList<ItemsViewBean>(); // 将ItemsViewBean传至数组方便适配器的填充
	public static final int MESSAGETYPE = 0;// 线程参数
	private ArrayList<Map<String, Object>> list1;
	private PullDownListView mPullDownView = null;
	private Handler mHandler = new Handler();
	//定义一个发布物品的按钮
	private ImageView iv_addpic = null; 

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		parentView = inflater.inflate(R.layout.lostfround, container, false);// view_pager
		mPullDownView = (PullDownListView) parentView.findViewById(R.id.data_list);
		// this.ed1 = (TextView) parentView.findViewById(R.id.edittext1);
		this.iv_addpic = (ImageView) parentView.findViewById(R.id.imv_add);
		mPullDownView.setRefreshListioner(this);
		mListView = mPullDownView.mListView;
		if (SetInternetUtil.isNetworkConnected(getActivity())) { // 判断网络是否可用，并设置网络
			execute();
		}
		// 对发布按钮监听，跳转至发布页面
		this.iv_addpic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(),ItemsRelease.class);
				startActivity(it);
			}
		});
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
				Toast.makeText(getActivity(), GlobalFinal.errorHttp, GlobalFinal.tipTime3).show();
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
		httpUrl = GlobalFinal.path.concat("itemsV_findAllItemsView.action?");
		Map<String, String> map = new HashMap<String, String>();
		map.put("flag", "0"); //給map数组传一个flag值为0，标识这边是失物，1为赠品
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		}

		else {
			res = res.substring(0, res.length() - 1);
		}

		return res;
	}

	// 程序逻辑：后台将数据传至前台，解析完将字符串存至Bean集合，然后适配器由此获得源数据，并将结果传至Listview进行显示。
	protected void initListView(String res) {
		try {

			String lists = ((res.split("iVList")[1]).substring(2, (res.split("iVList")[1]).length()));
			JSONObject json = new JSONObject(lists);

			JSONArray arry = json.getJSONArray("list");
			for (int i = 0; i < arry.length(); i++) {
				JSONObject obj = arry.getJSONObject(i);
				Map<String, String> map = new HashMap<String, String>();
				this.mData.add(new ItemsViewBean(obj.getString("id"), obj.getString("name"), obj.getString("number"),
						obj.getString("discribe"), obj.getString("type"), obj.getString("imageUrl"),
						obj.getString("personId"), obj.getString("pname"), obj.getString("sex"),
						obj.getString("playTime"), obj.getString("school"), obj.getString("phoneNumber")));
			}
			// 使用的是getActivity来获取Fragment中包含的activity，获得当前对象，相当于this的功能
			adapter = new ItemsViewAdapter(getActivity(), mData,this);// 第一参数也可能是getActivity().getApplicationContext()
			mListView.setAdapter(adapter);
			/*
			 * if (adapter != null) { adapter.notifyDataSetChanged(); } else {
			 * mListView.setAdapter(adapter); }
			 */
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
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

	@Override
	public void click(View v) {
		// TODO Auto-generated method stub
		// 取得mData中第 v.getTag()个数据值，其实就是电话号码的值，再对取出的值进行处理
		// 这个机制要清楚，先从适配器中拿到这是listview中第几个，然后根据这个再回到Activity中获得相应的数据
		String pno = mData.get((Integer) v.getTag()).getPhoneNumber().toString();
		if (pno != null) {
			Intent phoneIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + pno));
			startActivity(phoneIntent);
		} else {
			Toast.makeText(getActivity(), "此用户还未添加电话号码", Toast.LENGTH_LONG).show();
		}

	}

}
