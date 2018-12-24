package com.example.ext.activity.system;

import com.example.ext.R;
import com.example.ext.util.ExitTabActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class SystemMessage extends Activity{
	private ImageView back = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.system_message);
		this.back = (ImageView) findViewById(R.id.back_to);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
