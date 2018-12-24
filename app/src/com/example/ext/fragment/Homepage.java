package com.example.ext.fragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.ext.R;
import com.example.ext.activity.campus.CampusGroundDetail;
import com.example.ext.activity.campus.SeceneryAlbum;
import com.example.ext.activity.system.SystemMessage;
import com.example.ext.activity.trade.TradeLost;
import com.example.ext.common.imageCarousel.adbanner.BaseWebActivity;
import com.example.ext.common.imageCarousel.adbanner.ImagePagerAdapter;
import com.example.ext.common.imageCarousel.bannerview.CircleFlowIndicator;
import com.example.ext.common.imageCarousel.bannerview.ViewFlow;
import com.example.ext.common.qrCode.CaptureActivity;
import com.example.ext.fragment.activities.ActivitySharing;
import com.example.ext.fragment.campus.CampusGround;
import com.example.ext.fragment.campus.CampusInformation;
import com.example.ext.fragment.campus.LandscapeMap;

public class Homepage extends Fragment {
	private View parentView;
	public View noticeView;
	private ViewFlow mViewFlow;
	private CircleFlowIndicator mFlowIndicator;
	private ArrayList<String> imageUrlList = new ArrayList<String>();
	ArrayList<String> linkUrlArray = new ArrayList<String>();
	ArrayList<String> titleList = new ArrayList<String>();
	private LinearLayout notice_parent_ll;
	private LinearLayout notice_ll;
	private ViewFlipper notice_vf;
	private int mCurrPos;
	private RelativeLayout ads1; // 广告栏一
	private RelativeLayout ads2; // 广告栏二
	private RelativeLayout ads3; // 广告栏三
	// *//**
	// * ͼƬ��Դid
	// *//*

	private ImageView imv1 = null; // 功能按钮
	private ImageView imv2 = null;// 功能按钮
	private ImageView imv3 = null;// 功能按钮
	private ImageView imv4 = null;// 功能按钮
	private ImageView imv5 = null;// 功能按钮
	private ImageView imv6 = null;// 功能按钮
	private ImageView imv7 = null;// 功能按钮
	private ImageView imv8 = null;// 功能按钮
	private ImageView seSchool = null; // 学校下拉框按钮初始化
	private ImageView imv_sysmes = null;// 系统消息按钮
	private ImageView qrcode = null; // 二维码扫描按钮
	private TextView school = null;
	public static final int SCAN_CODE = 1;
	// private ImageView imageView1 = null;
	// private ImageView imageView2 = null;
	// Ϊ��ʵ���ֲ��¼ӵ�
	private static final String LOG_TAG = "Homepage";
	private String schName = "";

	/*
	 * private ImageHandler handler = new ImageHandler( new
	 * WeakReference<Homepage>(this));
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.homepage, container, false);
		// 设置状态栏透明
		initView();
		/*
		 * imageUrlList .add(R.drawable.pic_ads1);
		 */
		imageUrlList.add("http://pic.pimg.tw/pcstar/48c922d34517c.jpg");
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
		//initRollNotice();

		this.imv1 = (ImageView) parentView.findViewById(R.id.zixun);
		this.imv2 = (ImageView) parentView.findViewById(R.id.ground);
		this.imv3 = (ImageView) parentView.findViewById(R.id.views);
		this.imv4 = (ImageView) parentView.findViewById(R.id.maps);
		this.imv5 = (ImageView) parentView.findViewById(R.id.activitys);
		this.imv6 = (ImageView) parentView.findViewById(R.id.yiwus);
		this.imv7 = (ImageView) parentView.findViewById(R.id.shares);
		this.imv8 = (ImageView) parentView.findViewById(R.id.classes);
		this.seSchool = (ImageView) parentView.findViewById(R.id.select);
		this.imv_sysmes = (ImageView) parentView.findViewById(R.id.iv_message);
		this.qrcode = (ImageView) parentView.findViewById(R.id.qrcode);
		this.school = (TextView) parentView.findViewById(R.id.se_school);
		this.ads1 = (RelativeLayout) parentView.findViewById(R.id.title_layout);
		/*this.ads1 = (RelativeLayout) getActivity().getLayoutInflater().inflate(
				R.id.title_layout, null);
		this.ads2 = (RelativeLayout) getActivity().getLayoutInflater().inflate(
				R.id.pic1_layout, null);
		this.ads3 = (RelativeLayout) getActivity().getLayoutInflater().inflate(
				R.id.run_layout, null);*/
		 this.ads2 = (RelativeLayout) parentView.findViewById(R.id.pic1_layout);
		 this.ads3 = (RelativeLayout) parentView.findViewById(R.id.run_layout);
		// 点击可以下拉选择学校
		seSchool.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Toast.makeText(getActivity(), "选择成功",
				// Toast.LENGTH_SHORT).show();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity(), R.style.dialog);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("选择想了解的学校");
				builder.setIcon(R.drawable.logo);
				// 指定下拉列表的显示数据
				final String[] schools = { "厦门理工学院", "朝阳科技大学", "元智大学", "台湾大学",
						"厦门大学" };
				// 设置一个下拉的列表选择项
				builder.setItems(schools,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								school.setText(schools[which]);
								// Toast.makeText(MainActivity.this, "选择的城市为：" +
								// cities[which], Toast.LENGTH_SHORT).show();
							}
						});
				builder.show();
			}
		});
		// 点击系统消息按钮跳转至系统消息界面
		imv_sysmes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(), SystemMessage.class);
				startActivity(it);
			}
		});
		qrcode.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(), CaptureActivity.class);
				startActivityForResult(it, SCAN_CODE);
			}
		});
		ads1.setOnClickListener(new OnClickListener() {

			// TODO Auto-generated method stub
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(), CampusInformation.class);
				startActivity(it);
			}

		});

		ads2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				Intent it = new Intent(getActivity(), CampusGround.class);
//				startActivity(it);
				changeFragment(new CampusGround());
			}
		});
		ads3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				changeFragment(new ActivitySharing());

			}
		});
		imv1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// changeFragment(new InformationGround());
				// Intent it = new Intent(getActivity(),
				// InformationGround.class);
				// startActivity(it);
				// if (savedInstanceState == null) {
				/*
				 * getFragmentManager() .beginTransaction()
				 * .addToBackStack(null) //����ǰfragment���뵽����ջ��
				 * .replace(R.id.homepage, new InformationGround()).commit();
				 */
				Intent it = new Intent(getActivity(), CampusGroundDetail.class);
				it.putExtra("l", "1");
				startActivity(it);

			}
			// }
		});
		// ����ܱ߰�ť��  ת
		imv2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// changeFragment(new InformationGround());
				Intent it = new Intent(getActivity(), CampusGroundDetail.class);
				it.putExtra("l", "2");
				startActivity(it);
			}
		});
		// ����羰��ť��ת
		imv3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// changeFragment(new LandscapeMap());
				Intent it = new Intent(getActivity(), SeceneryAlbum.class);
				startActivity(it);
			}
		});
		// ���У԰��ͼ��ť��ת
		imv4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				changeFragment(new LandscapeMap());
			}
		});
		// �������?ť��ת
		imv5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				changeFragment(new ActivitySharing());
			}
		});
		// ������ﰴť��ת
		imv6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent it = new Intent(getActivity(), TradeLost.class);
				startActivity(it);
			}
		});
		// ������?ť��ת
		imv7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				changeFragment(new ActivitySharing());
			}
		});
		//課程表跳轉按鈕
		imv8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// changeFragment(new Trade());
			}
		});
		return parentView;

	}

	private void initView() {
		mViewFlow = (ViewFlow) parentView.findViewById(R.id.viewflow);
		mFlowIndicator = (CircleFlowIndicator) parentView
				.findViewById(R.id.viewflowindic);
	}

	/*private void initRollNotice() {
		FrameLayout main_notice = (FrameLayout) parentView
				.findViewById(R.id.main_notice);
		notice_parent_ll = (LinearLayout) getActivity().getLayoutInflater()
				.inflate(R.layout.layout_notice, null);
		notice_ll = ((LinearLayout) this.notice_parent_ll
				.findViewById(R.id.homepage_notice_ll));
		notice_vf = ((ViewFlipper) this.notice_parent_ll
				.findViewById(R.id.homepage_notice_vf));
		main_notice.addView(notice_parent_ll);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (isAdded()) {
					getActivity().runOnUiThread(new Runnable() {
						@Override
						public void run() {
							moveNext();
							Log.d("Task", "下一个");
						}
					});
				}

			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0, 3000);
	}*/

	/*private void moveNext() {
		setView(this.mCurrPos, this.mCurrPos + 1);
		this.notice_vf.setInAnimation(getActivity(), R.anim.in_bottomtop);
		this.notice_vf.setOutAnimation(getActivity(), R.anim.out_bottomtop);
		this.notice_vf.showNext();
	}*/

	/*private void setView(int curr, int next) {
		//noticeView = (LinearLayout)parentView.findViewById(R.id.notice_item);
		//View noticeView = (LinearLayout) parentView.findViewById(R.id.notice_item);
		noticeView = getActivity().getLayoutInflater().inflate(
				R.layout.notice_item,null);
		//android.widget.LinearLayout{5153f89 V.E...... ......I. 0,0-0,0 #7f09017e app:id/notice_item}
		TextView notice_tv = (TextView) noticeView.findViewById(R.id.notice_tv);
		if ((curr < next) && (next > (titleList.size() - 1))) {
			next = 0;
		} else if ((curr > next) && (next < 0)) {
			next = titleList.size() - 1;
		}
		notice_tv.setText(titleList.get(next));
		notice_tv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Bundle bundle = new Bundle();
				bundle.putString("url", linkUrlArray.get(mCurrPos));
				bundle.putString("title", titleList.get(mCurrPos));
				Intent intent = new Intent(getActivity(), BaseWebActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		if (notice_vf.getChildCount() > 1) {
			notice_vf.removeViewAt(0);
		}
		notice_vf.addView(noticeView, notice_vf.getChildCount());
		mCurrPos = next;
	}
*/
	private void initBanner(ArrayList<String> imageUrlList) {

		mViewFlow.setAdapter(new ImagePagerAdapter(getActivity(), imageUrlList,
				linkUrlArray, titleList).setInfiniteLoop(true));
		mViewFlow.setmSideBuffer(imageUrlList.size()); // 实际图片张数，
														// 我的ImageAdapter实际图片张数为3

		mViewFlow.setFlowIndicator(mFlowIndicator);
		mViewFlow.setTimeSpan(3500);
		mViewFlow.setSelection(imageUrlList.size() * 1000); // 设置初始位置
		mViewFlow.startAutoFlowTimer(); // 启动自动播放
	}

	/*
	 * private void setImageBackground(int selectItems) { for (int i = 0; i <
	 * tips.length; i++) { if (i == selectItems) {
	 * tips[i].setBackgroundResource(R.drawable.page_indicator_focused); } else
	 * { tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused); } }
	 * }
	 */

	private void changeFragment(Fragment targetFragment) {
		// resideMenu.clearIgnoredViewList();
		getFragmentManager().beginTransaction()
				.replace(R.id.homepage, targetFragment, "fragment")
				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
				.commit();
	}

}
