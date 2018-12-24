package com.example.ext.activity.share;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

import com.example.ext.R;
import com.example.ext.activity.share.bean.ShareFirstCommentAdapter;
import com.example.ext.activity.share.bean.ShareFirstCommentBean;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.HttpService_;
import com.example.ext.util.ImageLoader;

public class SharingCenterDetail extends Activity {

	public static final int MESSAGETYPE = 0;
	private String pId = " "; // 用户id
	private String shareId = null;
	private int dzs = 0;
	private int pls = 0;
	private int zfl = 0;
	private int flag = 0; // 判断按钮是否被点击两次或多次
	// private String personId = null;//分享者id
	private CircleImageView iv_userpic = null; // 用户头像
	private TextView tv_username = null; // 用户名
	private ImageView iv_xlk = null; // 下拉框按钮
	private TextView fb_dis = null; // 点击至评论页面
	private TextView tv_nowtime = null; // 分享的时间
	private TextView tv_describe = null; // 分享内容
	private TextView tv_clicknum = null; // 点赞数
	private TextView tv_disnum = null; // 评论数
	private TextView tv_zfnum = null; // 转发量
	private ImageView dianzanshu = null; // 点赞数按钮
	private ImageView pinglunshu = null; // 评论数按钮
	private ImageView zhuanfaliang = null; // 转发量按钮
	private ImageView lookat = null; // 关注按钮
	private ImageView image1 = null; //显示图片1
	private ImageView image2 = null; //显示图片2
	private ImageView image3 = null; //显示图片3

	private ImageView type_icon = null; //分享的类型图片
	private LinearLayout layout_for_pic; //图片的布局
	private ListView mListView;
	private ShareFirstCommentAdapter adapter;
	private List<ShareFirstCommentBean> mData = new ArrayList<ShareFirstCommentBean>();
	private String pname = "";
	private String imageUrl = "";
	private String[] imgUrl ; //存放图片数组的，用于显示图片的轮播
	private ImageLoader imageLoader = null; //显示图片所用
	private ImageLoader imageLoader1 = null; //显示图片所用
	// private int state = 0; //用于判断关注按钮是否被按下
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.sharing_center_detail);

		this.iv_userpic = (CircleImageView) findViewById(R.id.img_pic);
		this.tv_username = (TextView) findViewById(R.id.user_name);
		this.iv_xlk = (ImageView) findViewById(R.id.img_pic2);
		this.fb_dis = (TextView) findViewById(R.id.fb_dis);
		this.tv_nowtime = (TextView) findViewById(R.id.tv_nowtime);
		this.tv_describe = (TextView) findViewById(R.id.edittext1);
		this.tv_clicknum = (TextView) findViewById(R.id.click_num);
		this.tv_disnum = (TextView) findViewById(R.id.tv_discribe);
		this.tv_zfnum = (TextView) findViewById(R.id.tv_zfnum);
		this.dianzanshu = (ImageView) findViewById(R.id.dianzanshu);
		this.pinglunshu = (ImageView) findViewById(R.id.pinglunshu);
		this.zhuanfaliang = (ImageView) findViewById(R.id.zhuanfaliang);
		this.lookat = (ImageView) findViewById(R.id.img_lookat);
		this.image1 = (ImageView) findViewById(R.id.item_image_00);
		this.image2 = (ImageView) findViewById(R.id.item_image_11);
		this.image3 = (ImageView) findViewById(R.id.item_image_22);
		imageLoader = new ImageLoader(this);
		imageLoader1 = new ImageLoader(this);
		this.type_icon = (ImageView) findViewById(R.id.type_icon);
		this.layout_for_pic = (LinearLayout) findViewById(R.id.item_image_layout);
		this.mListView = (ListView) findViewById(R.id.com_list);
		Intent it = super.getIntent(); // 取得启动此程序的Intent
		shareId = it.getStringExtra("sid"); // 取得设置的分享表id
		final String personId = it.getStringExtra("pid"); // 取得设置的分享表id
		imageUrl= it.getStringExtra("imageUrl"); // 取得设置的分享表id
		pname = it.getStringExtra("pname"); // 取得设置的分享表id
		execute(); // 执行线程
		executeFcomment(); // 执行线程2

		// 点击点赞按钮
		this.dianzanshu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				flag++; // 判断按钮是否点击的次数是不是超过两次
				if (flag > 1) {
					Toast.makeText(SharingCenterDetail.this, "您已经赞过啦", 3000)
							.show();
				} else {

					arg0.setBackgroundResource(R.drawable.icon_dianzan_red); // 控制颜色改变
					int a = Integer.valueOf(tv_clicknum.getText().toString());// 获得点赞数
					Map<String, String> map = new HashMap<String, String>();
					map.put("id", shareId);
					// map.put("pid", personId);
					map.put("clicknum", tv_clicknum.getText().toString());
					String httpUrl = GlobalFinal.path
							.concat("share_addShareGal.action?");
					HttpService_ http = new HttpService_();
					try {
						String res = http.loginPostData(httpUrl, map);
						if (res.equals("error")) {
							Toast.makeText(SharingCenterDetail.this, "访问服务器失败",
									5000).show();
						} else {
							// 成功
							a++; // 点赞数加1
							tv_clicknum.setText(String.valueOf(a));
							Toast.makeText(SharingCenterDetail.this,
									"恭喜您，点赞成功", 5000).show();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		this.pinglunshu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				comment();
				comment1();

			}
		});
		this.zhuanfaliang.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showShare();
				int c = Integer.valueOf(tv_zfnum.getText().toString());// 获得评论数
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", shareId);
				map.put("zflnum", tv_zfnum.getText().toString());
				String httpUrl = GlobalFinal.path
						.concat("share_addShareZfl.action?");
				HttpService_ http = new HttpService_();
				try {
					String res = http.loginPostData(httpUrl, map);
					if (res.equals("error")) {
						Toast.makeText(SharingCenterDetail.this, "访问服务器失败",
								5000).show();
					} else {
						// 成功
						c++; // 转发量加1
						tv_zfnum.setText(Integer.valueOf(c).toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
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
		//点击关注按钮
		this.lookat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				lookat.setImageResource(R.drawable.icon_lookat_have);
				lookat.setClickable(false);
		 		/*String res;
				String httpUrl;
				httpUrl = GlobalFinal.path.concat("share_findByShareId.action?");
				HttpService_ http = new HttpService_();
				Map<String, String> map = new HashMap<String, String>();
				map.put("actId", actId);// 把活动表id传至我的收藏后台
				res = http.loginPostData(httpUrl, map);
				if (res.equals("error")) {
					Toast.makeText(ActivityDetail.this, "收藏失败，请重试", 3000).show();
				} else {
					Toast.makeText(ActivityDetail.this, "恭喜您，收藏成功，可以在我的收藏找到哦！", 3000).show();
				}		*/
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
				Toast.makeText(SharingCenterDetail.this, "解析出错", 3000).show();
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
		httpUrl = GlobalFinal.path.concat("share_findByShareId.action?");
		HttpService_ http = new HttpService_();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", shareId);// 把id传至后台
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
			obj = obj.getJSONObject("share");
			String personId = obj.getString("share.personId").toString();// obj.getString("share.personId")
			String playTime = obj.getString("share.playTime").toString();
			String discribe = obj.getString("share.discribe").toString();
			String clickNumber = obj.getString("share.clickNumber").toString();
			String commentNumber = obj.getString("share.commentNumber")
					.toString();
			String forwardNumber = obj.getString("share.forwardNumber")
					.toString();
			String typeId = obj.getString("share.typeId")
					.toString();
			String picUrl = obj.getString("share.picture")
					.toString();
			imageLoader1.DisplayImage(imageUrl, this.iv_userpic, R.drawable.my_defalft_headpic);
			
			//http://192.168.43.224:8080/ext_web/picture/share_pics/20161019191859.jpg,http://192.168.43.224:8080/ext_web/picture/share_pics/20161019191858.jpg,http://192.168.43.224:8080/ext_web/picture/share_pics/20161019191857.jpg,
			this.tv_username.setText(pname);// 对取得的用户id进行显示
			this.tv_nowtime.setText(playTime); // 对取得的分享时间进行显示
			this.tv_describe.setText(discribe); // 对取得的分享内容进行显示
			this.tv_clicknum.setText(clickNumber); // 对取得的分享点赞数进行显示
			this.tv_disnum.setText(commentNumber); // 对取得的分享评论量进行显示
			this.tv_zfnum.setText(forwardNumber); // 对取得的分享转发量进行显示
            
			int type = Integer.valueOf(typeId);
			if (type == 2) // 判断是否为图片类型
			{
				type_icon.setImageResource(R.drawable.icon_views);
				layout_for_pic.setVisibility(View.VISIBLE); //设置可见
				picUrl = picUrl.substring(0, picUrl.length() - 1);
				imgUrl = picUrl.split(",");
				for (int i = 0; i < 3; i++) {
					if (i == 0) {
						String pic1 = imgUrl[0];
				        imageLoader.DisplayImage(pic1,this.image1);
					}
					if (i == 1) {
						String pic2 = imgUrl[1];
						imageLoader.DisplayImage(pic2, this.image2);
					}
					if (i == 2) {
						String pic3 = imgUrl[2];
						imageLoader.DisplayImage(pic3, this.image3);
					}
				}
			}else{
				layout_for_pic.setVisibility(View.GONE); //设置不可见
				type_icon.setImageResource(R.drawable.icon_wenzi);
			}
			
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void executeFcomment() {
		try {
			new Thread(new Runnable() {// ����һ���̵߳ķ��������ڰ�׿�����̨��������
						@Override
						public void run() {
							// ����������ݼ���ʵ�ִ���
							String res = initFcData();
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
				initFcListView(msg.obj.toString());
			} else {
				Toast.makeText(SharingCenterDetail.this, "解析出错", 3000).show();
			}
			switch (msg.what) {
			case MESSAGETYPE:
				break;
			default:
				break;
			}
		}
	};

	protected String initFcData() {
		String httpUrl;
		String res;
		httpUrl = GlobalFinal.path.concat("sharefcview_findAllFCView.action?");
		// http://192.168.43.224:8080/ext_web/sfview_listAllByShareId.action?
		Map<String, String> map = new HashMap<String, String>();
		HttpService_ http = new HttpService_();
		// Map<String, String> map1 = new HashMap<String, String>();
		map.put("sid", shareId);// 把id传至后台
		res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {  
			res = "";
		} else {
			res = res.substring(0, res.length() - 1);
		}
		return res;
	}

	// 程序逻辑：后台将数据传至前台，解析完将字符串存至Bean集合，然后适配器由此获得源数据，并将结果传至Listview进行显示。
	protected void initFcListView(String res) {
		try {

			String lists = ((res.split("sharefcList")[1]).substring(2,
					(res.split("sharefcList")[1]).length()));
			JSONObject json = new JSONObject(lists);
			JSONArray arry = json.getJSONArray("list");
			for (int i = 0; i < arry.length(); i++) {
				JSONObject obj = arry.getJSONObject(i);
				Map<String, String> map = new HashMap<String, String>();
				this.mData.add(new ShareFirstCommentBean(obj.getString("id"),
						obj.getString("shareId"), obj.getString("objpersonId"),
						obj.getString("name"), obj.getString("commentTime"),
						obj.getString("content"), obj.getString("floor")));
			}
			// 使用的是getActivity来获取Fragment中包含的activity，获得当前对象，相当于this的功能
			adapter = new ShareFirstCommentAdapter(this, mData);// 第一参数也可能是getActivity().getApplicationContext()
			mListView.setAdapter(adapter); 
			setListViewHeightBasedOnChildren(mListView);

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

	private void comment() {
		Intent it = new Intent(SharingCenterDetail.this, ShareComment.class); // 实例化Intent
		it.putExtra("sid", shareId);
		startActivity(it);
	}

	private void comment1() {
		int b = Integer.valueOf(tv_disnum.getText().toString());// 获得评论数
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
		}
	}

	private void showShare() {
		ShareSDK.initSDK(this);
		OnekeyShare oks = new OnekeyShare();
		// 关闭sso授权
		oks.disableSSOWhenAuthorize();

		// 分享时Notification的图标和文字 2.5.9以后的版本不调用此方法
		// oks.setNotification(R.drawable.ic_launcher,
		// getString(R.string.app_name));
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle(getString(R.string.share));
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl("http://sharesdk.cn");
		// text是分享文本，所有平台都需要这个字段
		oks.setText("我是分享文本");
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		// oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl("http://sharesdk.cn");
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("我是测试评论文本");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite(getString(R.string.app_name));
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://sharesdk.cn");

		// 启动分享GUI
		oks.show(this);
	}

	public void setListViewHeightBasedOnChildren(ListView listView) {
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
			// listAdapter.getCount（）返回数据项的数量
			View listItem = listAdapter.getView(i, null, listView);
			// 策画子项View 的宽高
			listItem.measure(0, 0);
			// 统计所有子项的总高度
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight（）获取子项间分隔符占用的高度
		// params.height最后获得全部ListView完全显示须要的高度
		listView.setLayoutParams(params);
	}

}
