package com.example.ext.activity.user.bean;

import java.util.ArrayList;
import java.util.List;

import com.example.ext.R;
import com.example.ext.common.imageCarousel.CircleImageView;
import com.example.ext.util.ImageLoader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CollectAdapter extends BaseAdapter{

	private List<MyShareEntity> list1= new ArrayList<MyShareEntity>(); 
	
	private List<CollectActivityEntity> list2= new ArrayList<CollectActivityEntity>(); 
	//itemA类的type标志
    private static final int TYPE_A = 0;

    private static final int TYPE_B = 1;
    
    private Context context;
    
    private ImageLoader imageloader;
    
    private List<Object> data = new ArrayList<Object>();
	
	public CollectAdapter(Context context,List<MyShareEntity> list1,
			List<CollectActivityEntity> list2 ) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.list1=list1;
		this.list2=list2;
		
		data.addAll(list1);
		data.addAll(list2);
		
		imageloader = new ImageLoader(context);
	}
    
	 /**
     * 获得itemView的type
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int result = 0;
        if (data.get(position) instanceof MyShareEntity) {
            result = TYPE_A;
        } else if (data.get(position) instanceof CollectActivityEntity) {
            result = TYPE_B;
        }
        return result;
    }
	
    /**
     * 获得有多少中view type
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		 return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		myShare myShare = null;
		collect collect = null;
		int type = getItemViewType(arg0);
		if(arg1==null)
		{
			myShare = new myShare();
			collect = new collect();
			
			 switch (type) {
             case TYPE_A:
            	 arg1 = View.inflate(context, R.layout.my_sharex, null);
            	 myShare.name=(TextView)arg1.findViewById(R.id.user_name);
            	 myShare.time=(TextView)arg1.findViewById(R.id.now_time);
            	 myShare.headImage=(CircleImageView)arg1.findViewById(R.id.img_pic);
            	 myShare.note=(TextView)arg1.findViewById(R.id.edittext1);
					//MI.image=(ImageView)arg1.findViewById(R.id.goods_image);
            	 myShare.click=(TextView)arg1.findViewById(R.id.click);
            	 myShare.comment=(TextView)arg1.findViewById(R.id.comment);
                 arg1.setTag(R.id.tag_first, myShare);
                 break;
             case TYPE_B:
            	 arg1 = View.inflate(context, R.layout.list_item_activities, null);
            	 collect.image = (ImageView) arg1.findViewById(R.id.imv_theme1);
            	 collect.playTime = (TextView) arg1.findViewById(R.id.playtime);
            	 arg1.setTag(R.id.tag_second, collect);
                 break;
         }
			
		}
		else
		{
			 //根据不同的type来获得tag
            switch (type) {
                case TYPE_A:
                	myShare = (myShare) arg1.getTag(R.id.tag_first);
                    break;
                case TYPE_B:
                	collect = (collect) arg1.getTag(R.id.tag_second);
                    break;
            }
		}
		
		Object o = data.get(arg0);
        //根据不同的type设置数据
        switch (type) {
            case TYPE_A:
            	MyShareEntity a = (MyShareEntity) o;
            	myShare.name.setText(a.getName());
            	myShare.note.setText(a.getNote());
            	myShare.time.setText(a.getTime());
            	myShare.click.setText(a.getClick());
            	myShare.comment.setText(a.getComment());
            	imageloader.DisplayImage(a.getHeadImage(),myShare.headImage);
                break;

            case TYPE_B:
            	CollectActivityEntity b = (CollectActivityEntity) o;
            	collect.playTime.setText(b.getPlayTime());

                break;
        }
		
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
	
	private class collect
	{
		private ImageView image;
		private TextView playTime;
	}
	
}
