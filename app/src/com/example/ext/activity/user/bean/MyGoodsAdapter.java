package com.example.ext.activity.user.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ext.R;
import com.example.ext.activity.trade.TradeDetail;
import com.example.ext.activity.user.GoodsDetails;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.fragment.campus.adapter.InformationGroundAdapter.MyInformation;
import com.example.ext.fragment.campus.entity.InformationGroundEntity;
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

public class MyGoodsAdapter extends BaseAdapter{
	
	private List<MyGoodsEntity> list=new ArrayList<MyGoodsEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	private Map<String, String> map=null;
	public MyGoodsAdapter(Context mContext,List<MyGoodsEntity> list){
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
		// TODO Auto-generated method stubm 
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
				final myGoods MI;
				final int i=arg0;
				if(arg1==null)
				{
					arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.my_goodsx, arg2,false);
					MI = new myGoods();
					MI.goodsName=(TextView)arg1.findViewById(R.id.user_name);
					MI.note=(TextView)arg1.findViewById(R.id.describe);
					MI.cost=(TextView)arg1.findViewById(R.id.price);
					MI.num=(TextView)arg1.findViewById(R.id.num);
					MI.image=(ImageView)arg1.findViewById(R.id.pic_show);
					MI.imageUrl=(CircleImageView)arg1.findViewById(R.id.img_pic);
					arg1.setTag(MI);
				}
				else
				{
					MI = (myGoods) arg1.getTag();
				}
				MyGoodsEntity MF= list.get(arg0);
				MI.goodsName.setText(MF.getName());
				MI.note.setText(MF.getNote());
				MI.cost.setText(MF.getCost());
				MI.num.setText(MF.getNum());
				imageloader.DisplayImage(MF.getImage(),MI.image);
				imageloader.DisplayImage(MF.getImageUrl(),MI.imageUrl);
				
				arg1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						MyGoodsEntity MF1= list.get(i);
						
						Intent it = new Intent(mContext,GoodsDetails.class);
						
						it.putExtra("gid", MF1.getId());
						it.putExtra("pid", MF1.getPersonId());
						it.putExtra("name", MF1.getName());
						it.putExtra("image", MF1.getImageUrl());
						it.putExtra("goodsImage", MF1.getImage());
						it.putExtra("cost", MF1.getCost());
						it.putExtra("note", MF1.getNote());
						it.putExtra("num", MF1.getNum());
						
						mContext.startActivity(it);
					}
				});
				
				arg1.setOnLongClickListener(new OnLongClickListener() {
					
					@Override
					public boolean onLongClick(View arg0) {
						// TODO Auto-generated method stub
						String res;
						String httpUrl;
						MyGoodsEntity MF1= list.get(i);
						map = new HashMap<String, String>();
						map.put("id", MF1.getId());
						httpUrl = GlobalFinal.path.concat("user3_deleteGoods.action?");
						HttpRequestor http = new HttpRequestor();
						res = http.loginPostData(httpUrl, map);
						return true;
					}
				});
				
				return arg1;
	}
	
	private class myGoods
	{
		private TextView goodsName;
		private ImageView image;
		private CircleImageView imageUrl;
		private TextView note;
		private TextView cost;
		private TextView num;
	}

}
