package com.example.ext.activity.user.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.ext.R;
import com.example.ext.activity.user.PersonalcenterAccess;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.util.HttpRequestor;
import com.example.ext.util.ImageLoader;

public class MyFocusAdapter extends BaseAdapter{
	private List<MyFocusEntity> list=new ArrayList<MyFocusEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	private Map<String, String> map=null;
	public MyFocusAdapter(Context mContext, List<MyFocusEntity> list) {
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
		final Focus F;
		final int i=arg0;
		if(arg1==null)
		{
			arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.my_focus_listview, arg2,false);
			F = new Focus();
			F.T1=(TextView)arg1.findViewById(R.id.name);
			F.T2=(TextView)arg1.findViewById(R.id.signature);
			F.image=(CircleImageView)arg1.findViewById(R.id.head);
			arg1.setTag(F);
		}
		 else {
				F = (Focus) arg1.getTag();
			}
		MyFocusEntity MF= list.get(arg0);
		F.T1.setText(MF.getUserName());
		F.T2.setText(MF.getSignature());
		imageloader.DisplayImage(MF.getImageUrl(),F.image);
		
		arg1.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				// TODO Auto-generated method stub
				String res;
				String httpUrl;
				MyFocusEntity MF1= list.get(i);
				map = new HashMap<String, String>();
				map.put("id", MF1.getID());
				httpUrl = GlobalFinal.path.concat("user2_deleteUserFollow.action?");
				HttpRequestor http = new HttpRequestor();
				res = http.loginPostData(httpUrl, map);
				return true;
			}
		});
		
		arg1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MyFocusEntity MF1= list.get(i);
				Intent it = new Intent(mContext,PersonalcenterAccess.class);
				
				it.putExtra("id",MF1.getObjPersonId());
				
				mContext.startActivity(it);
			}
		});
		
		return arg1;
	}
	public class Focus
	{
		TextView T1;
		TextView T2;
		CircleImageView image;
	}
}
