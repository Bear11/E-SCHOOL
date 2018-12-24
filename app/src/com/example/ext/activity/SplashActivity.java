package com.example.ext.activity;


import com.example.ext.R;
import com.example.ext.activity.user.LoginPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.activity_splash);

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						int version =  Integer.valueOf(android.os.Build.VERSION.SDK);
						startActivity(new Intent(SplashActivity.this, LoginPage.class));
						if(version > 5 ){  
			                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);  
			            }  
						finish();
					}
				});
			}
		}).start();

	}
}
