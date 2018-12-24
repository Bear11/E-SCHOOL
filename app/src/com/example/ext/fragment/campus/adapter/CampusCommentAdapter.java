package com.example.ext.fragment.campus.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.ext.R;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.fragment.campus.CampusInformation;
import com.example.ext.fragment.campus.entity.CampusCommentEntity;
import com.example.ext.fragment.campus.entity.CampusGroundEntity;
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

public class CampusCommentAdapter extends BaseAdapter{

	private List<CampusCommentEntity> list=new ArrayList<CampusCommentEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	public CampusCommentAdapter(Context mContext, List<CampusCommentEntity> list) {
		// TODO Auto-generated method stub
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
		final comment c;
		if(arg1==null)
		{
			arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.information_groundx, arg2,false);
			c = new comment();
			c.name=(TextView)arg1.findViewById(R.id.name);
			c.note=(TextView)arg1.findViewById(R.id.text);
			c.time=(TextView)arg1.findViewById(R.id.time);
			c.image=(CircleImageView)arg1.findViewById(R.id.head);
			arg1.setTag(c);
		}
		else
		{
			c = (comment) arg1.getTag();
		}
		CampusCommentEntity c1= list.get(arg0);
		c.name.setText(c1.getName());
		c.time.setText(c1.getCommentTime());
		c.note.setText(c1.getContent());
		imageloader.DisplayImage(c1.getImageUrl(),c.image);

//		arg1.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				CampusGroundEntity c1= list.get(i);
//				Intent it = new Intent(mContext,CampusInformation.class);
//				it.putExtra("id", String.valueOf(c1.getId()));
//				it.putExtra("name",c1.getUserAct());
//				it.putExtra("note",c1.getNote());
//				it.putExtra("click", c1.getClick());
//				it.putExtra("comment", c1.getComment());
//				it.putExtra("forward", c1.getForward());
//				mContext.startActivity(it);
//			}
//		});
		return arg1;
	}

	private class comment
	{
		private TextView name;
		private CircleImageView image;
		private TextView time;
		private TextView note;
	}
}
