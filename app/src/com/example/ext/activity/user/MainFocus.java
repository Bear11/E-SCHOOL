package com.example.ext.activity.user;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ext.R;
import com.example.ext.activity.trade.FragmentAdapter;
import com.example.ext.fragment.trade.LostFragment;
import com.example.ext.fragment.trade.TradeFragment;

public class MainFocus extends FragmentActivity {

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
    private MyFriends mChatFg;  
    private MyFocus mFriendFg;  
     
    /** 
     * ViewPager的当前选中页 
     */  
    private int currentIndex;  
    /** 
     * 屏幕的宽度 
     */  
    private int screenWidth;  
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.mainfocus);
        findById();  
        init();  
        initTabLineWidth(); 	
	}
	 private void findById() {  
	          
	        mTabChatTv = (TextView) this.findViewById(R.id.id_chat_tv);  
	        mTabFriendTv = (TextView) this.findViewById(R.id.id_friend_tv);  
	  
	        mTabLineIv = (ImageView) this.findViewById(R.id.id_tab_line_iv);  
	  
	        mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);  
	    }  
	  
	    private void init() {  
	        mFriendFg = new MyFocus();
	        
	        mChatFg = new MyFriends();  
	        mFragmentList.add(mFriendFg);
	        mFragmentList.add(mChatFg); 
	        
	  
	        mFragmentAdapter = new FragmentAdapter(  
	                this.getSupportFragmentManager(), mFragmentList);  
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
	        getWindow().getWindowManager().getDefaultDisplay()  
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
}
