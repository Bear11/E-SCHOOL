package com.example.ext.activity.share.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ext.R;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.util.ImageLoader;

public class ShareAdapter extends BaseAdapter {

	private List<ShareBean> mData;
	private Context mContext;
	private ImageLoader imageLoader;
	private ImageLoader imageLoader1;
	String[] imgsUrl;
	private LinearLayout layout;
	private ImageView shareType;

	public ShareAdapter(Context mContext, List<ShareBean> mData) {
		this.mContext = mContext;
		this.mData = mData;
		imageLoader = new ImageLoader(mContext);
		imageLoader1 = new ImageLoader(mContext);
		this.imgsUrl = imgsUrl;
		this.layout = layout;
		this.shareType = shareType;
	}

	@Override
	public int getCount() {
		return mData == null ? 0 : mData.size();
	}

	@Override
	public ShareBean getItem(int position) {

		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;
		// MyListener myListener1=null;
		if (convertView == null) {
			convertView = (ViewGroup) LayoutInflater.from(mContext).inflate(
					R.layout.list_item_share, parent, false);
			vh = new ViewHolder();
			vh.mHead = (CircleImageView)convertView.findViewById(R.id.img_pic);
			vh.mIv1 = (ImageView) convertView.findViewById(R.id.item_image_0);
			vh.mIv2 = (ImageView) convertView.findViewById(R.id.item_image_1);
			vh.mIv3 = (ImageView) convertView.findViewById(R.id.item_image_2);
			vh.mName = (TextView) convertView.findViewById(R.id.user_name);
			vh.mDiscribe = (TextView) convertView.findViewById(R.id.edt1);
			layout = (LinearLayout) convertView.findViewById(R.id.item_image_layout);
			shareType = (ImageView) convertView.findViewById(R.id.share_type);
			
			vh.clickNumber = (TextView) convertView
					.findViewById(R.id.clickNumber);
			// 对点赞数设置单击事件
			// vh.dianzanshu = (Button)
			// convertView.findViewById(R.id.dianzanshu);

			vh.commentNumber = (TextView) convertView
					.findViewById(R.id.commentNumber);
			vh.forwardNumber = (TextView) convertView
					.findViewById(R.id.forwardNumber);
			vh.mTime = (TextView) convertView.findViewById(R.id.now_time);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		vh.mName.setTag(position);

		ShareBean bean = mData.get(position);
       
		vh.mName.setText(bean.getName());
		vh.mDiscribe.setText(bean.getDiscribe());
		vh.clickNumber.setText(bean.getClickNumber());
		vh.commentNumber.setText(bean.getCommentNumber());
		vh.forwardNumber.setText(bean.getForwardNumber());
		vh.mTime.setText(bean.getPlayTime());
		imageLoader1.DisplayImage(bean.getImageUrl(),vh.mHead,R.drawable.my_defalft_headpic);
		// vh.dianzanshu.setTag(position);
		// 给Button添加单击事件 添加Button之后ListView将失去焦点 需要的直接把Button的焦点去掉
		// vh.dianzanshu.setOnClickListener(myListener1);
		// vh.dianzanshu.setOnClickListener(MyListener(position));

		// 获得图片路径，解析后显示图片，三张
		// 图片先放放，后面再做
		int type = Integer.valueOf(bean.getTypeId());
		if (type == 2) // 判断是否为图片类型
		{
			shareType.setImageResource(R.drawable.icon_views);
			layout.setVisibility(View.VISIBLE); //设置可见
			String url = bean.getPicture();
			// http://localhost:8080/ext_web/picture/share_pics/20161014002343.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002342.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002341.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002047.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002045.jpg,
			url = url.substring(0, url.length() - 1);
			// http://localhost:8080/ext_web/picture/share_pics/20161014002343.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002342.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002341.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002047.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002045.jpg
			imgsUrl = url.split(",");
			
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					String pic1 = imgsUrl[0];
					boolean isNet = true;
					if (isNet) {
						imageLoader.DisplayImage(pic1, vh.mIv1,R.drawable.plugin_camera_no_pictures);
					} else {
						File file = new File(pic1);
						if (file.exists()) {
							Bitmap bitmap = BitmapFactory.decodeFile(bean
									.getPicture());
							vh.mIv1.setImageBitmap(bitmap);
						}
					}
 
				}
				if (i == 1) {
					String pic2 = imgsUrl[1];
					imageLoader.DisplayImage(pic2, vh.mIv2,R.drawable.plugin_camera_no_pictures);
				}
				if (i == 2) {
					String pic3 = imgsUrl[2];
					imageLoader.DisplayImage(pic3, vh.mIv3,R.drawable.plugin_camera_no_pictures);
				}
			}
		}else{
			layout.setVisibility(View.GONE); //设置不可见
			shareType.setImageResource(R.drawable.icon_wenzi);
		}

		/*
		 * boolean isNet = true; if (isNet) {
		 * imageLoader.DisplayImage(imgsUrl[i], vh.mIv1); } else { File file =
		 * new File(bean.getPicture()); if (file.exists()) { Bitmap bitmap =
		 * BitmapFactory.decodeFile(bean.getPicture());
		 * vh.mIv1.setImageBitmap(bitmap); } }
		 */

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

		private TextView mName;

		private TextView mTime;

		private CircleImageView mHead; //头像
		
		private ImageView mIv1;

		private ImageView mIv2;

		private ImageView mIv3;

		private TextView mDiscribe;

		// private Button dianzanshu;

		private TextView clickNumber;

		private TextView commentNumber;

		private TextView forwardNumber;
		

	}
}
