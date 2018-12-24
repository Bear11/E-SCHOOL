package com.example.ext.common.photo.dophoto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.ext.activity.activities.ActivityRelease;
import com.example.ext.activity.share.SharingPicture;
import com.example.ext.activity.trade.TradeRelease;
import com.example.ext.activity.user.AddGoods;
import com.example.ext.common.baseData.GlobalStatic;
import com.example.ext.common.photo.adapter.FolderAdapter;
import com.example.ext.common.photo.util.Bimp;
import com.example.ext.common.photo.util.PublicWay;
import com.example.ext.common.photo.util.Res;
import com.example.ext.fragment.campus.AddCampusGround;
import com.example.ext.util.ExitTabActivity;

/**
 * 这个类主要是用来进行显示包含图片的文件夹
 *
 * @author king
 * @QQ:595163260
 * @version 2014年10月18日 下午11:48:06
 */
public class ImageFile extends Activity {

	private FolderAdapter folderAdapter;
	private Button bt_cancel;
	private Context mContext;

	protected void onCreate(Bundle savedInstanceState) {
		ExitTabActivity.getInstance().addActivity(this);// 把每一个打开的Activity添加到退出集合事件里
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(Res.getLayoutID("plugin_camera_image_file"));
		PublicWay.activityList.add(this);
		mContext = this;
		bt_cancel = (Button) findViewById(Res.getWidgetID("cancel"));
		bt_cancel.setOnClickListener(new CancelListener());
		GridView gridView = (GridView) findViewById(Res
				.getWidgetID("fileGridView"));
		TextView textView = (TextView) findViewById(Res
				.getWidgetID("headerTitle"));
		textView.setText(Res.getString("photo"));
		folderAdapter = new FolderAdapter(this);
		gridView.setAdapter(folderAdapter);
	}

	private class CancelListener implements OnClickListener {// 取消按钮的监听
		public void onClick(View v) {
			// 清空选择的图片
			Bimp.tempSelectBitmap.clear();
			Intent intent = new Intent();
			// intent.setClass(mContext, PhotoMainActivity.class);
			if(GlobalStatic.getFlagImageUp()==1){
				intent.setClass(mContext, SharingPicture.class);
			}
			else if(GlobalStatic.getFlagImageUp()==2)
			{
				intent.setClass(mContext, ActivityRelease.class);
			}
			else if(GlobalStatic.getFlagImageUp()==3)
			{
				intent.setClass(mContext, TradeRelease.class);
			}
			else if(GlobalStatic.getFlagImageUp()==6)
			{
				intent.setClass(mContext, AddGoods.class);
			}
			else if(GlobalStatic.getFlagImageUp()==7)
			{
				intent.setClass(mContext, AddCampusGround.class);
			}
			startActivity(intent);

		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent();
			if(GlobalStatic.getFlagImageUp()==1){
				intent.setClass(mContext, SharingPicture.class);
			}
			else if(GlobalStatic.getFlagImageUp()==2)
			{
				intent.setClass(mContext, ActivityRelease.class);
			}
			else if(GlobalStatic.getFlagImageUp()==3)
			{
				intent.setClass(mContext, TradeRelease.class);
			}
			else if(GlobalStatic.getFlagImageUp()==6)
			{
				intent.setClass(mContext, AddGoods.class);
			}
			else if(GlobalStatic.getFlagImageUp()==7)
			{
				intent.setClass(mContext, AddCampusGround.class);
			}
			startActivity(intent);
		}
		return true;
	}

}
