package com.example.ext.activity.user.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ext.R;
import com.example.ext.activity.share.SharingCenterDetail;
import com.example.ext.activity.user.PersonalcenterAccess;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.util.HttpRequestor;
import com.example.ext.util.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyShareAdapter extends BaseAdapter{
	private List<MyShareEntity> list=new ArrayList<MyShareEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	private Map<String, String> map=null;
	
	 
	
	public MyShareAdapter(Context mContext,List<MyShareEntity> list){
		// TODO Auto-generated constructor stub
		this.mContext=mContext;
		this.list=list;
		imageloader = new ImageLoader(mContext);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
				final myShare MI;
				final int i=arg0;
				if(arg1==null)
				{
					arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.my_sharex, arg2,false);
					MI = new myShare();
					MI.name=(TextView)arg1.findViewById(R.id.user_name);
					MI.time=(TextView)arg1.findViewById(R.id.now_time);
					MI.headImage=(CircleImageView)arg1.findViewById(R.id.img_pic);
					MI.note=(TextView)arg1.findViewById(R.id.edittext1);
					//MI.image=(ImageView)arg1.findViewById(R.id.goods_image);
					MI.click=(TextView)arg1.findViewById(R.id.click);
					MI.comment=(TextView)arg1.findViewById(R.id.comment);
					
					arg1.setTag(MI);
				}
				else
				{
					MI = (myShare) arg1.getTag();
				}
				MyShareEntity MF= list.get(arg0);
				MI.name.setText(MF.getName());
				MI.note.setText(MF.getNote());
				MI.time.setText(MF.getTime());
				MI.click.setText(MF.getClick());
				MI.comment.setText(MF.getComment());
				
				imageloader.DisplayImage(MF.getHeadImage(),MI.headImage);
				
				arg1.setOnLongClickListener(new OnLongClickListener() {
					
					@Override
					public boolean onLongClick(View arg0) {
						// TODO Auto-generated method stub
						String res;
						String httpUrl;
						MyShareEntity MF1= list.get(i);
						map = new HashMap<String, String>();
						map.put("id", MF1.getId());
						httpUrl = GlobalFinal.path.concat("userShare_deleteShare.action?");
						HttpRequestor http = new HttpRequestor();
						res = http.loginPostData(httpUrl, map);
						return true;
					}
				});
				
				arg1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						MyShareEntity MF1= list.get(i);
						Intent it = new Intent(mContext,SharingCenterDetail.class);
						
						it.putExtra("sid", MF1.getId());
						it.putExtra("pid", MF1.getPERSONID());
						it.putExtra("pname", MF1.getName());
						
						mContext.startActivity(it);
					}
				});
				
				return arg1;
	}
	
	private class myShare
	{
		private TextView name;
		private TextView time;
		private CircleImageView headImage;
		private ImageView image;
		private TextView note;
		private TextView click;
		private TextView comment;
		private TextView forward;
	}
	
	
}
