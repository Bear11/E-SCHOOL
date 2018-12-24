package com.example.ext.activity.trade.bean;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ext.R;
import com.example.ext.util.ImageLoader;

public class GoodsViewAdapter extends BaseAdapter{

	private List<GoodsViewBean> mData;
	private Context mContext;
	private ImageLoader imageLoader;

	public GoodsViewAdapter(Context mContext, List<GoodsViewBean> mData) {
		this.mContext = mContext;
		this.mData = mData;
		imageLoader = new ImageLoader(mContext);
	}


	@Override
	public int getCount() {
		return mData == null ? 0 : mData.size();
	}

	@Override
	public GoodsViewBean getItem(int position) {

		return mData.get(position);	
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;
	//	MyListener myListener1=null;
		if (convertView == null) {
			convertView = (ViewGroup) LayoutInflater.from(mContext).inflate(
					R.layout.list_item_trade, parent, false);			
			vh = new ViewHolder();
		   //	vh.mIv = (ImageView) convertView.findViewById(R.id.iv_goodsurl);
			vh.mName = (TextView) convertView.findViewById(R.id.user_name);
			vh.mTime = (TextView) convertView.findViewById(R.id.now_time);
			vh.school = (TextView) convertView.findViewById(R.id.inschool);
			vh.price = (TextView) convertView.findViewById(R.id.price);
			vh.mDiscribe = (TextView) convertView.findViewById(R.id.describe);
			vh.clickNumber = (TextView) convertView.findViewById(R.id.dianzanshu1);
			vh.mIv = (ImageView) convertView.findViewById(R.id.pic_show);
		    //对点赞数设置单击事件
		//	vh.dianzanshu = (Button) convertView.findViewById(R.id.dianzanshu);						
			vh.commentNumber = (TextView) convertView.findViewById(R.id.pinglunshu1);
			vh.forwardNumber = (TextView) convertView.findViewById(R.id.zhuanfaliang1);
			vh.phoneNumber = (TextView) convertView.findViewById(R.id.phone_nom);

			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		vh.mName.setTag(position);
		GoodsViewBean bean = mData.get(position);
       
		vh.mName.setText(bean.getPname());
		vh.mTime.setText(bean.getPlayTime());
	    vh.mDiscribe.setText(bean.getDiscribe());
	    vh.school.setText(bean.getSchool());
	    vh.price.setText(bean.getPrice());
	    vh.clickNumber.setText(bean.getClickNumber());
	    vh.commentNumber.setText(bean.getCommentNumber());
	    vh.forwardNumber.setText(bean.getForwardNumber());	
	    //让联系方式加密显示，只显示前三位数字
	    String pno = bean.getPhoneNumber();
	    String pno_pass = pno.substring(0,3)+"********"+pno.substring(11,pno.length());
	    vh.phoneNumber.setText(pno_pass);	
	  //  vh.dianzanshu.setTag(position);
	  //给Button添加单击事件  添加Button之后ListView将失去焦点  需要的直接把Button的焦点去掉 
	  //  vh.dianzanshu.setOnClickListener(myListener1);
	    //vh.dianzanshu.setOnClickListener(MyListener(position));  
	    
	    
	    //   图片先放放，后面再做
	    boolean isNet = true;
		if (isNet) {
			imageLoader.DisplayImage(bean.getImageUrl(), vh.mIv);
		} else {
			File file = new File(bean.getImageUrl());
			if (file.exists()) {
				Bitmap bitmap = BitmapFactory.decodeFile(bean.getImageUrl());
				vh.mIv.setImageBitmap(bitmap);
			}
		}
	    
	    //对于listview中的每个控件都实现点击事件方法是重写getview（）方法，在这里面来进行
	    
		return convertView;
	}

	
	/* public class MyListener implements OnClickListener{  
         int mPosition;  
         public MyListener(int inPosition){  
             mPosition= inPosition;  
         }  
         @Override  
         public void onClick(View v) {  
             // TODO Auto-generated method stub  
             //Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();  
        	 // Toast.makeText(getApplicationContext(), "Button is OFF!", Toast.LENGTH_SHORT).show();
        
         }  
           
     }*/
	
	
	public class ViewHolder {
		
		private TextView mName; //用户名
		
		private TextView mTime; //发表时间
		
		private TextView school; //所在学校
		
		private TextView price; //商品价格
		
		private ImageView mIv;  //图片描述	
		
		private TextView mDiscribe; //商品描述
        
		private TextView clickNumber;  //点赞数
		
		private TextView commentNumber; //评论数
		
		private TextView forwardNumber; //转发量
		
		private TextView phoneNumber; //电话号码
		
		
	}
}
