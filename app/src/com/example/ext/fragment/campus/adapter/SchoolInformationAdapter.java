package com.example.ext.fragment.campus.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.ext.R;
import com.example.ext.fragment.campus.entity.SchoolInformationEntity;
import com.example.ext.util.ImageLoader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SchoolInformationAdapter extends BaseAdapter{

	private List<SchoolInformationEntity> list=new ArrayList<SchoolInformationEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	public SchoolInformationAdapter(Context mContext, List<SchoolInformationEntity> list) {
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
		final schoolInformation MI;
		if(arg1==null)
		{
			arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.school_informationx, arg2,false);
			MI = new schoolInformation();
			MI.name=(TextView)arg1.findViewById(R.id.name);
			MI.note=(TextView)arg1.findViewById(R.id.note);
			MI.createTime=(TextView)arg1.findViewById(R.id.createTime);
			MI.address=(TextView)arg1.findViewById(R.id.address);
			MI.Officialwebsite=(TextView)arg1.findViewById(R.id.Officialwebsite);
			MI.schoolType=(TextView)arg1.findViewById(R.id.schoolType);
			MI.image=(ImageView)arg1.findViewById(R.id.schoolImage);
			arg1.setTag(MI);
		}
		else
		{
			MI = (schoolInformation) arg1.getTag();
		}
		SchoolInformationEntity MF= list.get(arg0);
		//MI.name.setText(MF.getName());
//		MI.note.setText(MF.getNote());
//		MI.createTime.setText(MF.getCreateTime());
//		MI.address.setText(MF.getAddress());
//		MI.Officialwebsite.setText(MF.getOfficialwebsite());
//		MI.schoolType.setText(MF.getSchoolType());
//		imageloader.DisplayImage(MF.getImage(),MI.image);
		return arg1;
	}
	
	private class schoolInformation
	{
		private TextView name;
		private TextView note;
		private TextView createTime;
		private TextView address;
		private TextView schoolType;
		private TextView Officialwebsite;
		private ImageView image;
	}

}
