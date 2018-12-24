package com.example.ext.activity.activities.bean;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
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

public class ActivitiesAdapter extends BaseAdapter {

	private List<ActivitiesBean> mData;
	private Context mContext;
	private ImageLoader imageLoader;

	public ActivitiesAdapter(Context mContext, List<ActivitiesBean> mData) {

		this.mContext = mContext;
		this.mData = mData;
		imageLoader = new ImageLoader(mContext);
	}

	@Override
	public int getCount() {
		return mData == null ? 0 : mData.size();
	}

	@Override
	public ActivitiesBean getItem(int position) {

		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;
		// MyListener myListener1=null;
		if (convertView == null) {
			convertView = (ViewGroup) LayoutInflater.from(mContext).inflate(
					R.layout.list_item_activities, parent, false);
			vh = new ViewHolder();
			// vh.mIv = (ImageView) convertView.findViewById(R.id.iv_goodsurl);
			vh.palytime = (TextView) convertView.findViewById(R.id.playtime);
			// vh.eyeonNumber = (TextView)
			// convertView.findViewById(R.id.eye_on);
			vh.money = (TextView) convertView.findViewById(R.id.free_charge);

			vh.theme = (TextView) convertView.findViewById(R.id.theme);
			vh.picture = (ImageView) convertView.findViewById(R.id.imv_theme1);

			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		vh.theme.setTag(position);

		ActivitiesBean bean = mData.get(position);

		vh.theme.setText(bean.getTopic());
		Double price = Double.valueOf(bean.getPrice());
		int p = (int)Math.floor(price);//取整
		vh.money.setText("￥"+p);
		//vh.palytime.setText(format("yyyy-MM-dd",bean.getPlayTime()));
		vh.palytime.setText(bean.getPlayTime());
		//ActivitiesBean [id=5, actTime=2016-08-19 18:30:03, topic=篮球时间到了,开打开打, 
		//address=朝阳科技大学篮球场, discribe=来吧,追梦的少年,在这青春岁月里,燃烧你的卡路里,跟着我们一起尽情狂奔,
		//体验不一样的假期,没有什么比运动更让人激动了,欢迎参与,
		// picture=http://192.168.1.7:8080/ext_web/picture/pic_ads5.png, personId=5, state=0, 
		//playTime=2016-09-22, deadLine=2016-09-23 16:30:03, limitNumber=25, remainNumber=20, price=0.0]
		// 图片先放放，后面再做
		 boolean isNet = true;
		 if (isNet) { 
			 //http://192.168.43.224:8080/ext_web/picture/activities_pics/pic_ads4.jpg
		  imageLoader.DisplayImage(bean.getPicture(), vh.picture);
		 } else {
		 File file = new File(bean.getPicture());
		 if (file.exists()) {
		 Bitmap bitmap = BitmapFactory.decodeFile(bean.getPicture());
		 vh.picture.setImageBitmap(bitmap);
		 }
		 }

		// 对于listview中的每个控件都实现点击事件方法是重写getview（）方法，在这里面来进行

		return convertView;
	}

	/*
	 * public class MyListener implements OnClickListener{ int mPosition; public
	 * MyListener(int inPosition){ mPosition= inPosition; }
	 * 
	 * @Override public void onClick(View v) { // TODO Auto-generated method
	 * stub //Toast.makeText(getApplicationContext(), "成功",
	 * Toast.LENGTH_SHORT).show(); // Toast.makeText(getApplicationContext(),
	 * "Button is OFF!", Toast.LENGTH_SHORT).show();
	 * 
	 * }
	 * 
	 * }
	 */

	public class ViewHolder {

		private TextView theme; // 主题

		private TextView palytime; // 发布时间

		private TextView money; // 费用

		private ImageView picture; // 图片路径

		// private TextView eyeonNumber; //浏览量

	}
	@SuppressLint("SimpleDateFormat")
	public static String format(String format, String time) {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = df.parse(time);
			SimpleDateFormat df1 = new SimpleDateFormat(format);
			result = df1.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
