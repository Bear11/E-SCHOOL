package com.example.ext.fragment.campus.adapter;

import java.util.ArrayList;
import java.util.List;





import com.example.ext.R;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.fragment.campus.entity.InformationGroundEntity;
import com.example.ext.util.ImageLoader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationGroundAdapter extends BaseAdapter{

	private List<InformationGroundEntity> list=new ArrayList<InformationGroundEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	public InformationGroundAdapter(Context mContext, List<InformationGroundEntity> list) {
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
		final MyInformation MI;
		if(arg1==null)
		{
			arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.campus_informationx, arg2,false);
			MI = new MyInformation();
			MI.name=(TextView)arg1.findViewById(R.id.user_name);
			MI.text=(TextView)arg1.findViewById(R.id.edt1);
			//MI.school=(TextView)arg1.findViewById(R.id.school);
			//MI.title=(TextView)arg1.findViewById(R.id.title);
			MI.time=(TextView)arg1.findViewById(R.id.now_time);
			MI.imagehead=(CircleImageView)arg1.findViewById(R.id.img_pic);
			MI.image=(ImageView)arg1.findViewById(R.id.item_image_0);
			arg1.setTag(MI);
		}
		else
		{
			MI = (MyInformation) arg1.getTag();
		}
		InformationGroundEntity MF= list.get(arg0);
		MI.name.setText(MF.getName());
		MI.text.setText(MF.getText());
		//MI.school.setText(MF.getSchool());
		//MI.title.setText(MF.getTitle());
		MI.time.setText(MF.getTime());
		imageloader.DisplayImage("http://imgsrc.baidu.com/forum/w%3D580/sign=fd6c8a38c995d143da76e42b43f18296/552fee198618367a657f19e62f738bd4b21ce592.jpg", MI.imagehead);
		imageloader.DisplayImage(MF.getImage(),MI.image);
		return arg1;
	}
	public class MyInformation
	{
		TextView name=null;
		TextView text= null;
		TextView school=null;
		TextView title = null;
		TextView time = null;
		CircleImageView imagehead=null;
		ImageView image=null;
	}

	
}
