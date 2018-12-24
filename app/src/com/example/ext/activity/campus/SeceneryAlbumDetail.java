package com.example.ext.activity.campus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.activity.campus.bean.GalleryView;
import com.example.ext.activity.campus.bean.SeceneryAlbumAdapter;
import com.example.ext.common.baseData.GlobalStatic;
import com.example.ext.util.ExitTabActivity;
import com.example.ext.util.picStringToArray;

public class SeceneryAlbumDetail extends Activity {

	/************************** 定义控件 ************************************/
	private TextView tvTitle; // title
	private GalleryView gallery; // 画廊
	private SeceneryAlbumAdapter adapter; // 适配器
	private picStringToArray picToString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 去除标题栏
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secenery_album_detail);
		//Intent it = super.getIntent();
		//String imgUrl = it.getStringExtra("img1");
		//将得到的数据转化成字符串数组
		//GlobalStatic.setmData(picToString.stringToArray(imgUrl));
		
		// 初始化控件
		initRes();
	}

	private void initRes() {
		tvTitle = (TextView) findViewById(R.id.tvTitle);
		gallery = (GalleryView) findViewById(R.id.mygallery);

		adapter = new SeceneryAlbumAdapter(this);
		adapter.createReflectedImages();
		gallery.setAdapter(adapter);

		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				tvTitle.setText(adapter.titles[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		// 图片点击事件，显示图片信息
		gallery.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(SeceneryAlbumDetail.this, "img " + (position + 1) + " selected", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}
}
