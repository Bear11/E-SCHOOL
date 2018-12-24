package com.example.ext.activity.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.ext.R;
import com.example.ext.activity.trade.FragmentAdapter;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.util.HttpRequestor;
import com.example.ext.util.ImageLoader;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;




public class PersonalCenter extends  Fragment {
	private static final String FILENAME = "bcit";
	private View parentView;
	private RadioGroup rg1, rg2;
	private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
	private TextView name=null; //用户名
	private TextView school = null; //学校
	private TextView Signature = null;//签名
	private CircleImageView head;
	private ImageLoader imageloader;
	private String username="123";
	
	public static FragmentActivity instance = null;
	
	//收藏与分享
	private List<Fragment> mFragmentList = new ArrayList<Fragment>();  
    private FragmentAdapter mFragmentAdapter;
      
    private ViewPager mPageVp;  
    /** 
     * Tab显示内容TextView 
     */  
    private TextView mTabChatTv, mTabFriendTv;  
    /** 
     * Tab的那个引导线 
     */  
    private ImageView mTabLineIv;  
    /** 
     * Fragment 
     */  
    private MyShare mChatFg;  
    private MyCollection mFriendFg;  
     
    /** 
     * ViewPager的当前选中页 
     */  
    private int currentIndex;  
    /** 
     * 屏幕的宽度 
     */  
    private int screenWidth;  
    
    
    private static final String TAG = "YAYUN";
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.personal_center, container, false);
		SharedPreferences sp = getActivity().getSharedPreferences(FILENAME,
				Activity.MODE_PRIVATE);
		username = sp.getString("id", "");
		
		imageloader = new ImageLoader(getActivity());
		
		instance = getActivity();
		
		this.rg1 = (RadioGroup) parentView.findViewById(R.id.rg1);
		this.rg2 = (RadioGroup) parentView.findViewById(R.id.rg2);
		// ��һ��
		this.rb1 = (RadioButton) parentView.findViewById(R.id.lesson);
		this.rb2 = (RadioButton) parentView.findViewById(R.id.me);
		this.rb3 = (RadioButton) parentView.findViewById(R.id.concern);
		// �ڶ���
		
		this.rb7 = (RadioButton) parentView.findViewById(R.id.goods);
//
//
		name=(TextView)parentView.findViewById(R.id.name);
		school=(TextView)parentView.findViewById(R.id.school);
		Signature=(TextView)parentView.findViewById(R.id.signature);
		head=(CircleImageView)parentView.findViewById(R.id.head);
		
		//强行调整图片大小
		Drawable drawable=getResources().getDrawable(R.drawable.icon_woman); 
		drawable.setBounds(0, 0, 35, 50);
		name.setCompoundDrawables(drawable, null, null, null);
		
		Drawable drawable_1=getResources().getDrawable(R.drawable.school); 
		drawable_1.setBounds(0, 0, 35, 35);
		school.setCompoundDrawables(drawable_1, null, null, null);
		
		
		
		excute(1);
		
		this.rb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(),MyCurriculum.class);
				startActivity(it);
			}
		});
		this.rb2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(),MyInformation.class);
				startActivity(it);
			}
		});
		this.rb3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(),MainFocus.class);
				startActivity(it);
			}
		});
		
		
		
		this.rb7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getActivity(),MyGoods.class);
				startActivity(it);
			}
		});
		return parentView;
	}
	
	protected String getPerson_Center() {
		String res;
		String httpUrl;
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		httpUrl = GlobalFinal.path.concat("user_getPersonCenter.action?");
		HttpRequestor http = new HttpRequestor();
		res = http.loginPostData(httpUrl, map);
		return res;
	}
	// 登录
	protected void login(String res) {
		try {
			JSONObject jsonObject = new JSONObject(res);
			String result = jsonObject.getString("flag");
			String userId = jsonObject.getString("userid");
			String userName = jsonObject.getString("username");
			String signature = jsonObject.getString("signature");
			String lSchoolId = jsonObject.getString("LSchoolId");
			String head=jsonObject.getString("head");
			
			if ("0".equals(result)) {
				Toast.makeText(getActivity(), "账号尚未登录", Toast.LENGTH_SHORT).show();
			} else {
				//Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
				
			}
			name.setText(userName);
			school.setText(lSchoolId);
			Signature.setText(signature);
			imageloader.DisplayImage(head,this.head);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//分享与收藏
		findById();  
		init();
		initTabLineWidth(); 
		
	}
	
	// 网络请求
			protected void excute(final int i) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						switch (i) {
						case 1:
							String res = getPerson_Center();
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
					Toast.makeText(getActivity(), GlobalFinal.errorTip, Toast.LENGTH_SHORT)
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
//	private void changeFragment(Fragment targetFragment) {
//		// resideMenu.clearIgnoredViewList();
//		getFragmentManager().beginTransaction()
//				.replace(R.id.ss, targetFragment, "fragment")
//				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//				.commit();
//	}
	
	 private void findById() {  
         
	        mTabChatTv = (TextView) parentView.findViewById(R.id.id_chat_tv);  
	        mTabFriendTv = (TextView) parentView.findViewById(R.id.id_friend_tv);  
	  
	        mTabLineIv = (ImageView) parentView.findViewById(R.id.id_tab_line_iv);  
	  
	        mPageVp = (ViewPager) parentView.findViewById(R.id.id_page_vp);  
	    }  
	 
	 private void init() {  
	        mFriendFg = new MyCollection();
	        
	        mChatFg = new MyShare();  
	        mFragmentList.add(mChatFg);
	        mFragmentList.add(mFriendFg); 
	        
	  
	        mFragmentAdapter = new FragmentAdapter(  
	        		getActivity().getSupportFragmentManager(), mFragmentList);  
	        mPageVp.setAdapter(mFragmentAdapter);  
	        mPageVp.setCurrentItem(0);  
	  
	        mPageVp.setOnPageChangeListener(new OnPageChangeListener() {  
	  
	            /** 
	             * state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做。 
	             */  
	            @Override  
	            public void onPageScrollStateChanged(int state) {  
	  
	            }
	  
	            /** 
	             * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比 
	             * offsetPixels:当前页面偏移的像素位置 
	             */  
	            @Override  
	            public void onPageScrolled(int position, float offset,  
	                    int offsetPixels) {  
	                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv  
	                        .getLayoutParams();  
	  
	                Log.e("offset:", offset + "");  
	                /** 
	                 * 利用currentIndex(当前所在页面)和position(下一个页面)以及offset来 
	                 * 设置mTabLineIv的左边距 滑动场景： 
	                 * 记3个页面, 
	                 * 从左到右分别为0,1,2  
	                 * 0->1; 1->2; 2->1; 1->0 
	                 */  
	  
	                if (currentIndex == 0 && position == 0)// 0->1  
	                {  
	                    lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 2) + currentIndex  
	                            * (screenWidth / 2));  
	  
	                } else if (currentIndex == 1 && position == 0) // 1->0  
	                {  
	                    lp.leftMargin = (int) (-(1 - offset)  
	                            * (screenWidth * 1.0 / 2) + currentIndex  
	                            * (screenWidth / 2));  
	  
	                }//	                    else if (currentIndex == 1 && position == 1) // 1->2  
//	                {  
//	                    lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 2) + currentIndex  
//	                            * (screenWidth / 2));  
//	                } else if (currentIndex == 2 && position == 1) // 2->1  
//	                {  
//	                    lp.leftMargin = (int) (-(1 - offset)  
//	                            * (screenWidth * 1.0 / 2) + currentIndex  
//	                            * (screenWidth / 2));  
//	                }  
	                mTabLineIv.setLayoutParams(lp);  
	            }  
	  
	            @Override  
	            public void onPageSelected(int position) {  
	            	resetTextView();  
	                switch (position) {  
	                case 0:  
	                    mTabChatTv.setTextColor(0xff0db8f6);  
	                    break;  
	                case 1:  
	                    mTabFriendTv.setTextColor(0xff0db8f6);  
	                    break;  
	                  
	                }  
	                currentIndex = position;  
	            }  
	        });  
	  
	    }  
	 
	 /** 
	     * 设置滑动条的宽度为屏幕的1/3(根据Tab的个数而定) 
	     */  
	    private void initTabLineWidth() {  
	        DisplayMetrics dpMetrics = new DisplayMetrics();  
	        getActivity().getWindow().getWindowManager().getDefaultDisplay()  
	                .getMetrics(dpMetrics);  
	        screenWidth = dpMetrics.widthPixels;  
	        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv  
	                .getLayoutParams();  
	        lp.width = screenWidth / 2;  
	        mTabLineIv.setLayoutParams(lp);  
	    }  
	  
	    /** 
	     * 重置颜色 
	     */  
	    private void resetTextView() {  
	        mTabChatTv.setTextColor(0xff666666);  
	        mTabFriendTv.setTextColor(0xff666666);  
	         
	    }
	    @Override
		public void onDestroy() {
	      super.onDestroy();
	      Log.d(TAG, "MainActivity-nDestroy: ");
	      
	    }
		
}
