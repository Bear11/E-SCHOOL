package com.example.ext.activity.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.example.ext.R;
import com.example.ext.activity.MainPage;
import com.example.ext.common.photo.dophoto.PhotoMainActivity;
import com.example.ext.util.ExitTabActivity;

public class SharingRelease extends Activity {
	private ImageView imv = null;
	private ImageView imv2 = null;
	private ImageView imv3 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.sharing_release);
		this.imv = (ImageView) findViewById(R.id.ic_back);
		this.imv2 = (ImageView) findViewById(R.id.words);
		this.imv3 = (ImageView) findViewById(R.id.pictures);
		imv.setOnClickListener(new OnClickListener() {
			// ��ť����¼�������������
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(SharingRelease.this, MainPage.class);
				startActivity(it);
			}
		});
		imv2.setOnClickListener(new OnClickListener() {
			// ��ť����¼�����ת���������ֽ���
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(SharingRelease.this, SharingWords.class);
				startActivity(it);
			}
		});
		imv3.setOnClickListener(new OnClickListener() {
			// ��ť����¼�����ת������ͼƬ����
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				Intent it = new Intent(SharingRelease.this,
//						SharingPicture.class);
//				startActivity(it);
				Intent it = new Intent(SharingRelease.this,
						SharingPicture.class);
		        startActivity(it);
			}
		});
	}
}
