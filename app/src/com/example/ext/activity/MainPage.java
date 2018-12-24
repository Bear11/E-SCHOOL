package com.example.ext.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.share.SharingRelease;
import com.example.ext.activity.trade.TradeLost;
import com.example.ext.activity.user.PersonalCenter;
import com.example.ext.fragment.Homepage;
import com.example.ext.fragment.activities.ActivitySharing;
import com.example.ext.util.ExitTabActivity;

public class MainPage extends FragmentActivity implements
		OnCheckedChangeListener {

	private RadioGroup rg;
	private RadioButton rb1, rb2, rb3, rb4, rb5;
   //	���ڻ������ת���������
	private ImageView imv1 = null;
	private boolean isExtit=false;//标记用户退出  
	private String schName = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		setContentView(R.layout.mainpage);
		this.rg = (RadioGroup) findViewById(R.id.rg);
		this.rb1 = (RadioButton) findViewById(R.id.rb1);
		this.rb2 = (RadioButton) findViewById(R.id.rb2);
		this.rb3 = (RadioButton) findViewById(R.id.rb3);
		this.rb4 = (RadioButton) findViewById(R.id.rb4);
		this.rb5 = (RadioButton) findViewById(R.id.rb5);
		 //	���ڻ������ת���������
//		this.imv1 = (ImageView)findViewById(R.id.imv_theme1);
//		imv1.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View arg0) {
//				
//				Intent it = new Intent(MainPage.this, ActivityDetail.class);
//				//it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);			
//				startActivity(it);			
//			}			
//		});	

		setUpMenu();

	}

	private Handler hand=new Handler(){  
        @Override  
        public void handleMessage(Message msg) {  
            super.handleMessage(msg);  
            //标记用户是否退出  
            isExtit=false;  
        }  
    };
	
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        //判断用户是否退出  
        if(keyCode==KeyEvent.KEYCODE_BACK){  
  
            if(!isExtit){  
                isExtit=true;  
                Toast.makeText(getApplicationContext(),"再按一次退出",Toast.LENGTH_SHORT).show();  
                hand.sendEmptyMessageDelayed(0,3000);  
            }else{  
                finish();  
                System.exit(0);  
            }  
        }  
        return false;  
    }  
    
	private void setUpMenu() {
		// TODO Auto-generated method stub
		rg = (RadioGroup) findViewById(R.id.rg);
		rb1 = (RadioButton) findViewById(R.id.rb1);
		rb2 = (RadioButton) findViewById(R.id.rb2);
		rb3 = (RadioButton) findViewById(R.id.rb3);
		rb4 = (RadioButton) findViewById(R.id.rb4);
		rb5 = (RadioButton) findViewById(R.id.rb5);
		rg.setOnCheckedChangeListener(this);
		rb1.setChecked(true);
		// OnCheckedChangeListener listener = null;
	}

	private void changeFragment(Fragment targetFragment) {
		// resideMenu.clearIgnoredViewList();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.main_fragment, targetFragment, "fragment")
				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
				.commit();
	}

	public void onCheckedChanged(RadioGroup arg0, int checkedId) {

		if (rb1.getId() == checkedId) {
			changeFragment(new Homepage());
			
		} else if (rb2.getId() == checkedId) {
			changeFragment(new ActivitySharing());
			// changeFragment(new JieYueFragment());
		} else if (rb3.getId() == checkedId) {
			// changeFragment(new SharingRelease());
			Intent it = new Intent(MainPage.this, SharingRelease.class);
			startActivity(it);
		} else if (rb4.getId() == checkedId) {
			//changeFragment(new Trade());			
			Intent it = new Intent(MainPage.this, TradeLost.class);
			startActivity(it);
		} else if (rb5.getId() == checkedId) {
//			Intent it1 = new Intent(MainPage.this, PersonalCenter.class);
//			startActivity(it1);
			changeFragment(new PersonalCenter());
		}
	}
	String getSchName() {
		// sp存储读取用户id值
		SharedPreferences share = super.getSharedPreferences("bcit",
				Activity.MODE_PRIVATE); // 指定操作的文件名称
		// SharedPreferences.Editor edit = share.edit(); // 编辑文件

		schName = share.getString("school", "1");
		return schName;
	}

}
