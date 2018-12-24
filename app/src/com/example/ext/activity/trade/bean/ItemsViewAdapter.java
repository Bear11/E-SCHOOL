package com.example.ext.activity.trade.bean;

import java.io.File;
import java.util.List;

import com.example.ext.R;
import com.example.ext.util.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * ItemsViewAdapter适配器
 * 调用ItemsViewBean类，完成数据的调用和填充
 * */
public class ItemsViewAdapter extends BaseAdapter implements OnClickListener{

	private List<ItemsViewBean> mData;
	private Context mContext;
	private ImageLoader imageLoader;
	private String pno = ""; // 将获得的电话号码当成全局变量，以便函数的传值使用
	private AtCallback mCallback; // 定义了一个接口的变量
	/*
	 * 自定义接口，以便实现listview中控件的监听事件，这里是实现@功能
	 * 
	 */

	public interface AtCallback {

		public void click(View v);
	}

	public ItemsViewAdapter(Context mContext, List<ItemsViewBean> mData, AtCallback callback) {
		this.mContext = mContext;
		this.mData = mData;
		imageLoader = new ImageLoader(mContext);
		mCallback = callback;
	}

	@Override
	public int getCount() {
		return mData == null ? 0 : mData.size();
	}

	@Override
	public ItemsViewBean getItem(int position) {

		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	// 重写getView方法，完成数据从哪来到哪去的过程（适配器的精髓所在）
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;
		// MyListener myListener1=null;
		if (convertView == null) {
			convertView = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.list_item_lost, parent, false);
			vh = new ViewHolder();
			vh.mIv = (ImageView) convertView.findViewById(R.id.pic_show);
			vh.mName = (TextView) convertView.findViewById(R.id.user_name);
			vh.mTime = (TextView) convertView.findViewById(R.id.now_time);
			vh.school = (TextView) convertView.findViewById(R.id.inschool);
			vh.mDiscribe = (TextView) convertView.findViewById(R.id.describe);
			vh.mPhoneNo = (TextView) convertView.findViewById(R.id.phone_nomber);
			// 将@按钮取得便于做按钮的监听事件，点击@ 按钮，即可调用call function
			vh.atButton = (ImageView) convertView.findViewById(R.id.img_pic2);
			// 对点赞数设置单击事件
			// vh.dianzanshu = (Button)
			// convertView.findViewById(R.id.dianzanshu);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		ItemsViewBean bean = mData.get(position);

		vh.mName.setText(bean.getPname());
		vh.mTime.setText(bean.getPlayTime());
		vh.mDiscribe.setText(bean.getDiscribe());
		vh.school.setText(bean.getSchool());
		// 让联系方式加密显示，只显示前三位数字
		pno = bean.getPhoneNumber();
		String pno_pass = pno.substring(0, 3) + "********" + pno.substring(11, pno.length());
		vh.mPhoneNo.setText(pno_pass);
		// 对@按钮的事件监听，采用接口回调的方式来实现，简单理解就是在这里定义了接口，在Activity中实现，重要的知识点
		vh.atButton.setOnClickListener(this);
		vh.atButton.setTag(position);
		/* {

			@Override
			public void onClick(View v) {
				mCallBack.click(v); //调用接口的方法
				// TODO Auto-generated method stub
				
				 * if (pno != null) {
				 * 
				 * Intent phoneIntent = new Intent(
				 * "android.intent.action.CALL", Uri.parse("tel:" + pno));
				 * startActivity(phoneIntent); } else {
				 * Toast.makeText(getApplicationContext(), "此用户还未添加电话号码",
				 * Toast.LENGTH_LONG).show(); }
				 
			}
		}*/
		// vh.dianzanshu.setTag(position);
		// 给Button添加单击事件 添加Button之后ListView将失去焦点 需要的直接把Button的焦点去掉
		// vh.dianzanshu.setOnClickListener(myListener1);
		// vh.dianzanshu.setOnClickListener(MyListener(position));

		 //图片先放放，后面再做
		 boolean isNet = true;
		 if (isNet) {
		 imageLoader.DisplayImage(bean.getImageUrl(), vh.mIv, R.drawable.plugin_camera_no_pictures);
		 } else {
		 File file = new File(bean.getImageUrl());
		 if (file.exists()) {
		 Bitmap bitmap = BitmapFactory.decodeFile(bean.getImageUrl());
		 vh.mIv.setImageBitmap(bitmap);
		 }
		 }

		// 对于listview中的每个控件都实现点击事件方法是重写getview（）方法，在这里面来进行

		return convertView;
	}

	/*
	 * public class MyListener implements OnClickListener{ int mPosition; public
	 * MyListener(int inPosition){ mPosition= inPosition; }
	 * 
	 * @Override public void onClick(View v) { // TODO Auto-generated method
	 * stub //Toast.makeText(getApplicationContext(), "成功",
	 * Toast.LENGTH_SHORT).show(); // Toast.makeText(getApplicationContext(),
	 * "Button is OFF!", Toast.LENGTH_SHORT).show();
	 * 
	 * }
	 * 
	 * }
	 */

	public class ViewHolder {

		private TextView mName; // 用户名

		private TextView mTime; // 发表时间

		private TextView school; // 所在学校

		private ImageView mIv; // 暂时不管，图片描述

		private TextView mDiscribe; // 物品描述

		private TextView mPhoneNo; // 联系方式

		private ImageView atButton; // @按钮

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mCallback.click(v); //调用接口的方法
	}
}
