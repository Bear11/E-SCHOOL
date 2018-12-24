package com.example.ext.fragment.campus.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.ext.R;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.fragment.campus.CampusInformation;
import com.example.ext.fragment.campus.adapter.InformationGroundAdapter.MyInformation;
import com.example.ext.fragment.campus.entity.CampusGroundEntity;
import com.example.ext.fragment.campus.entity.InformationGroundEntity;
import com.example.ext.util.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CampusGroundAdapter extends BaseAdapter{

	private List<CampusGroundEntity> list=new ArrayList<CampusGroundEntity>();
	private Context mContext= null;
	private ImageLoader imageloader;
	
	String[] imgsUrl;
	String[] imgsUrl1;
	
	public CampusGroundAdapter(Context mContext, List<CampusGroundEntity> list) {
		// TODO Auto-generated method stub
		this.mContext=mContext;
		this.list=list;
		this.imgsUrl = imgsUrl;
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
				final campus c;
				if(arg1==null)
				{
					arg1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.campus_groundx, arg2,false);
					c = new campus();
					c.name=(TextView)arg1.findViewById(R.id.user_name);
					c.head= (CircleImageView)arg1.findViewById(R.id.img_pic);
					c.text=(TextView)arg1.findViewById(R.id.edt1);
					//c.school=(Button)arg1.findViewById(R.id.school);
					c.time=(TextView)arg1.findViewById(R.id.now_time);
					c.click1=(TextView)arg1.findViewById(R.id.clickNumber);
					c.comment1=(TextView)arg1.findViewById(R.id.commentNumber);
					c.forward1=(TextView)arg1.findViewById(R.id.forwardNumber);
					c.image0 = (ImageView)arg1.findViewById(R.id.item_image_0);
					c.image1= (ImageView)arg1.findViewById(R.id.item_image_1);
					c.image2 = (ImageView)arg1.findViewById(R.id.item_image_2);
					arg1.setTag(c);
				}
				else
				{
					c = (campus) arg1.getTag();
				}
				
				
//			    boolean isNet = true;
//				if (isNet) {
//					imageloader.DisplayImage(bean.getPicture(), vh.mIv);
//				} else {
//					File file = new File(bean.getPicture());
//					if (file.exists()) {
//						Bitmap bitmap = BitmapFactory.decodeFile(bean.getPicture());
//						vh.mIv.setImageBitmap(bitmap);
//					}
//				}
				
				
				CampusGroundEntity c1= list.get(arg0);
				final int i=arg0;
				c.name.setText(c1.getUserAct());
				
				c.text.setText(c1.getNote());
				//c.school.setText(c1.getSchoolName());
				c.time.setText(c1.getTime());
				c.click1.setText(c1.getClick());
				c.comment1.setText(c1.getComment());
				c.forward1.setText(c1.getForward());
				//imageloader.DisplayImage(c1.getImage(),c.image0);
				imageloader.DisplayImage(c1.getHead(),c.head);
				
				
					String url = c1.getImage();
					// http://localhost:8080/ext_web/picture/share_pics/20161014002343.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002342.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002341.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002047.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002045.jpg,
					url = url.substring(0, url.length()-1);
					// http://localhost:8080/ext_web/picture/share_pics/20161014002343.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002342.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002341.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002047.jpg,http://localhost:8080/ext_web/picture/share_pics/20161014002045.jpg
					imgsUrl = url.split(" ");
//					
					//String as = imgsUrl[2];
							
					imageloader.DisplayImage(imgsUrl[0], c.image0);
					
					imageloader.DisplayImage(imgsUrl[1], c.image1);
						
					imageloader.DisplayImage(imgsUrl[2], c.image2);
						
				
				
				arg1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						CampusGroundEntity c1= list.get(i);
						
						String url = c1.getImage();
						url = url.substring(0, url.length()-1);
						imgsUrl1 = url.split(" ");
						
						Intent it = new Intent(mContext,CampusInformation.class);
						it.putExtra("id", String.valueOf(c1.getId()));
						it.putExtra("head", c1.getHead());
						it.putExtra("name",c1.getUserAct());
						it.putExtra("note",c1.getNote());
						it.putExtra("click", c1.getClick());
						it.putExtra("comment", c1.getComment());
						it.putExtra("forward", c1.getForward());
						it.putExtra("image1", imgsUrl1[0]);
						it.putExtra("image2", imgsUrl1[1]);
						it.putExtra("image3", imgsUrl1[2]);
						mContext.startActivity(it);
					}
				});
				return arg1;
	}
	
	private class campus
	{
		private CircleImageView head;
		private ImageView image0;
		private ImageView image1;
		private ImageView image2;
		private TextView name;
		private TextView text;
		private Button school;
		private TextView time;
		private TextView click1;
		private TextView comment1;
		private TextView forward1;
	}
	

}
