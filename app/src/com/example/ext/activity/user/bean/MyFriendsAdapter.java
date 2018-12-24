package com.example.ext.activity.user.bean;

import java.util.ArrayList;
import java.util.List;

import com.example.ext.R;
import com.example.ext.activity.user.PersonalcenterAccess;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.util.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyFriendsAdapter extends BaseAdapter{

	private List<MyFriendsEntity> list=new ArrayList<MyFriendsEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	
	public MyFriendsAdapter(Context mContext,List<MyFriendsEntity> list) {
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
		// TODO Auto-generated method stub
		final MyFriends MI;
		final int i=arg0;
		if(arg1==null)
		{
			arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.my_frientsx, arg2,false);
			MI = new MyFriends();
			MI.headImage=(CircleImageView)arg1.findViewById(R.id.head);
			MI.name=(TextView)arg1.findViewById(R.id.name);
			MI.signature=(TextView)arg1.findViewById(R.id.signature);
			
			arg1.setTag(MI);
		}
		else
		{
			MI = (MyFriends) arg1.getTag();
		}
		MyFriendsEntity MF= list.get(arg0);
		MI.name.setText(MF.getName());
		MI.signature.setText(MF.getSignature());
		
		imageloader.DisplayImage(MF.getHeadImage(),MI.headImage);
		
		arg1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MyFriendsEntity MF1= list.get(i);
				Intent it = new Intent(mContext,PersonalcenterAccess.class);
				
				it.putExtra("id",MF1.getObjPersonId());
				
				mContext.startActivity(it);
			}
		});
		
		return arg1;
	}

	private class MyFriends
	{
		private CircleImageView headImage;
		private TextView name;
		private TextView signature;
	}
	
}
