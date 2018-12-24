package com.example.ext.fragment.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.activity.user.LoginPage;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.adbanner.ImagePagerAdapter;
import com.example.ext.common.imageCarousel.bannerview.CircleFlowIndicator;
import com.example.ext.common.imageCarousel.bannerview.ViewFlow;
import com.example.ext.fragment.campus.adapter.CampusGroundAdapter;
import com.example.ext.fragment.campus.adapter.SchoolInformationAdapter;
import com.example.ext.fragment.campus.entity.CampusGroundEntity;
import com.example.ext.fragment.campus.entity.SchoolInformationEntity;
import com.example.ext.util.HttpService_;
import com.example.ext.util.ImageLoader;
import com.lee.pullrefresh.ui.PullToRefreshBase;
import com.lee.pullrefresh.ui.PullToRefreshListView;
import com.lee.pullrefresh.ui.PullToRefreshBase.OnRefreshListener;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.common.imageCarousel.bannerview.CircleFlowIndicator;

public class SchoolInformation extends Activity{
	
	private TextView name;
	private TextView note;
	
	private SchoolInformationAdapter adapter = null;
	List<SchoolInformationEntity> list = null;
	private ListView listview;
	private ImageLoader imageloader;
	
	private ViewFlow mViewFlow;
	private ArrayList<String> imageUrlList = new ArrayList<String>();
	private CircleFlowIndicator mFlowIndicator;
	ArrayList<String> linkUrlArray = new ArrayList<String>();
	ArrayList<String> titleList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.school_information);
		this.listview=(ListView)findViewById(R.id.list);
		name=(TextView)findViewById(R.id.name);
		note=(TextView)findViewById(R.id.note);
		
		imageloader = new ImageLoader(this);
		//image=(ImageView)arg1.findViewById(R.id.schoolImage);
		initView();
		imageUrlList
			.add("http://pic.pimg.tw/pcstar/48c922d34517c.jpg");
		imageUrlList
			.add("http://album.udn.com/community/img/PSN_PHOTO/elleninseattle/f_6120735_1.jpg");
		imageUrlList
			.add("http://image.tianjimedia.com/uploadImages/2011/145/XYCD8HC1Q7JD_1.jpg");
		imageUrlList
			.add("http://img.aiimg.com/uploads/userup/1010/140029544931.jpg");

		linkUrlArray
			.add("http://blog.csdn.net/finddreams/article/details/44301359");
		linkUrlArray
			.add("http://blog.csdn.net/finddreams/article/details/43486527");
		linkUrlArray
			.add("http://blog.csdn.net/finddreams/article/details/44648121");
		linkUrlArray
			.add("http://blog.csdn.net/finddreams/article/details/44619589");
		titleList.add("6日晚朝阳天空突现迷人彩虹");
		titleList.add("'学霸'占据一片江山，学渣逆袭");
		titleList.add("校园晨跑活动正式招募中，欢迎加入 ");
		titleList.add("送送送新品来啦，欢迎父老乡亲领取！ ");
		initBanner(imageUrlList);
		
		
		
		excute(1);
	}
	protected String doLogin() {
		String res;
		String httpUrl;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "1");
		httpUrl = GlobalFinal.path.concat("campus_schoolInformation.action?");
		HttpService_ http = new HttpService_();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			String lists =((res.split("busList")[1]).substring(2,(res.split("busList")[1]).length()));
			JSONObject jsonObject = new JSONObject(res);
			
			JSONObject json =new JSONObject(lists);
			JSONArray array = json.getJSONArray("list");
			for(int i=0;i<=array.length();i++)
			{
				//"list":[{"id":"1","schoolName":"廈門理工","note":"厦门理工学院位于中国东南海滨城市——厦门。1981年建校（前身鹭江职业大学），是福建省属公立本科大学，实行省市共建、以市为主的管理体制。2004年经教育部批准升本并更名为“厦门理工学院”。2007年5月，通过学士学位授权单位及专业评估；2011年9月，成为教育部“卓越工程师教育培养计划”高校；2011年10月，成为国家首批“服务国家特殊需求专业硕士学位研究生教育试点高校”；2012年6月，顺利通过教育部本科教学合格评估。2013年1月，福建省人民政府批准为“省重点建设高校”。","createTime":"1981年","address":"福建省厦门市","schoolType":"理工类","Officialwebsite":"http:\/\/www.xmut.edu.cn","schoolImage":"http:\/\/g.hiphotos.baidu.com\/baike\/c0%3Dbaike80%2C5%2C5%2C80%2C26\/sign=2afecf7bf01f3a294ec5dd9cf84cd754\/42a98226cffc1e172c28e2944a90f603728de984.jpg"}]}
				JSONObject obj = array.getJSONObject(i);
//				list.add(new SchoolInformationEntity(
//						obj.getString("schoolName"),
//						obj.getString("note"),
//						obj.getString("schoolImage"), 
//						obj.getString("createTime"), 
//						obj.getString("address"), 
//						obj.getString("schoolType"), 
//						obj.getString("Officialwebsite")));
				//"list":[{"id":"1","schoolName":"厦门理工学院","schoolDescribe":"完美的大学"
				name.setText(obj.getString("schoolName"));
				note.setText(obj.getString("schoolDescribe"));
				
				
				
			}
//			adapter=new SchoolInformationAdapter(this, list);
//			adapter.notifyDataSetChanged();
//			listview.setAdapter(adapter);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
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
					Toast.makeText(SchoolInformation.this, GlobalFinal.errorTip, Toast.LENGTH_SHORT)
							.show();
				}
				break;

			default:
				break;
			}
		};
	};
	private void initView() {
		mViewFlow = (ViewFlow) findViewById(R.id.viewflow);

	}
	private void initBanner(ArrayList<String> imageUrlList) {

		mViewFlow.setAdapter(new ImagePagerAdapter(this, imageUrlList,
				linkUrlArray, titleList).setInfiniteLoop(true));
		mViewFlow.setmSideBuffer(imageUrlList.size()); // 实际图片张数，
														// 我的ImageAdapter实际图片张数为3

		mViewFlow.setTimeSpan(3500);
		mViewFlow.setSelection(imageUrlList.size() * 1000); // 设置初始位置
		mViewFlow.startAutoFlowTimer(); // 启动自动播放
	}
}
