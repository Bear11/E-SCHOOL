package com.example.ext.activity.campus.bean;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ext.R;
import com.example.ext.util.ImageLoader;
import com.example.ext.util.picStringToArray;

public class SeceneryListAdapter extends BaseAdapter{
	
	private List<SeceneryBean> mData;
	private Context mContext;
	private ImageLoader imageLoader1;
	private ImageLoader imageLoader2;
	private ImageLoader imageLoader3;
	private AtPicTo1 mCallBack1; // 定义了一个接口的变量
	private AtPicTo2 mCallBack2; // 定义了一个接口的变量
	private AtPicTo3 mCallBack3; // 定义了一个接口的变量
	private String[] imgsUrl1;
	private String[] imgsUrl2;
	private String[] imgsUrl3;
	public String[] titles = { "朝阳科技大学", "厦门理工学院", "元智大学"};
	/*
	 * 自定义接口，以便实现listview中控件的监听事件，这里是实现跳转到图片详情页面
	 * 
	 */

	public interface AtPicTo1 {

		public void click1(View v);
	}
	public interface AtPicTo2 {

		public void click2(View v);
	}
	public interface AtPicTo3 {

		public void click3(View v);
	}
	
	public SeceneryListAdapter(Context mContext, List<SeceneryBean> mData,AtPicTo1 callBack1,AtPicTo2 callBack2,AtPicTo3 callBack3) {
		this.mContext = mContext;
		this.mData = mData;
		imageLoader1 = new ImageLoader(mContext);
		imageLoader2 = new ImageLoader(mContext);
		imageLoader3 = new ImageLoader(mContext);
		mCallBack1 = callBack1;
		mCallBack2 = callBack2;
		mCallBack3 = callBack3;
	}

	@Override
	public int getCount() {
		return mData == null ? 0 : mData.size();
	}

	@Override
	public SeceneryBean getItem(int position) {

		return mData.get(position);	
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;

		if (convertView == null) {
			convertView = (ViewGroup) LayoutInflater.from(mContext).inflate(
					R.layout.list_item_secenery, parent, false);			
			vh = new ViewHolder();
			vh.schoolName = (TextView) convertView.findViewById(R.id.schoolName);
			vh.img_sch_view = (ImageView) convertView.findViewById(R.id.img_school_view);
			vh.img_sour_view = (ImageView) convertView.findViewById(R.id.img_surround_view);
			vh.img_cas_view = (ImageView) convertView.findViewById(R.id.img_photo_view);
            vh.schNum = (TextView) convertView.findViewById(R.id.img_school_view_num);
            vh.sourNum = (TextView) convertView.findViewById(R.id.img_surround_view_num);
            vh.casNum = (TextView) convertView.findViewById(R.id.img_photo_view_num);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		SeceneryBean bean = mData.get(position);
       
		vh.schoolName.setText(bean.getSchoolName());
		/*vh.img_sch_view.setImageResource(R.drawable.item02);
		vh.img_sour_view.setImageResource(R.drawable.item03);
		vh.img_cas_view.setImageResource(R.drawable.item04);*/
		picStringToArray a = new picStringToArray();
		String img1 = bean.getInnerSchool(); //校内
		imgsUrl1 = a.stringToArray(img1); //截取字符串并存储进imgUrl1数组
		
		picStringToArray b = new picStringToArray();
		String img2 = bean.getOutSchool(); //校外
		imgsUrl2 = b.stringToArray(img2); //截取字符串并存储进imgUrl2数组
		
		picStringToArray c = new picStringToArray();
		String img3 = bean.getByCasual(); //随手拍
		imgsUrl3 = c.stringToArray(img3); //截取字符串并存储进imgUrl3数组
		
		//每类图片取得第一张图片路径并显示，取得图片长度并显示在相应图片位置上
		boolean isNet = true;
		if (isNet) {
			imageLoader1.DisplayImage(imgsUrl1[0], vh.img_sch_view,R.drawable.plugin_camera_no_pictures);
			//Bitmap bitmap1 = BitmapFactory.decodeFile(imgsUrl1[0]);
			Bitmap bitmap1 = imageLoader1.getBitmap(imgsUrl1[0]);
			roundBitmapByShader(bitmap1, 90, 90, 10); //设置圆角
			String a1 = Integer.valueOf(imgsUrl1.length).toString();
			vh.schNum.setText("数量"+"("+a1+")");
		
			imageLoader2.DisplayImage(imgsUrl2[0], vh.img_sour_view,R.drawable.plugin_camera_no_pictures);
			//Bitmap bitmap2 = BitmapFactory.decodeFile(imgsUrl2[0]);
			Bitmap bitmap2 = imageLoader1.getBitmap(imgsUrl1[0]);
			roundBitmapByShader(bitmap2, 90, 90, 10); //设置圆角
			String a2 = Integer.valueOf(imgsUrl2.length).toString();
			vh.sourNum.setText("数量"+"("+a2+")");
			
			imageLoader3.DisplayImage(imgsUrl3[0], vh.img_cas_view,R.drawable.plugin_camera_no_pictures);
			//Bitmap bitmap3 = BitmapFactory.decodeFile(imgsUrl3[0]);
			Bitmap bitmap3 = imageLoader1.getBitmap(imgsUrl1[0]);
			roundBitmapByShader(bitmap3, 90, 90, 10); //设置圆角
			String a3 = Integer.valueOf(imgsUrl3.length).toString();
			vh.casNum.setText("数量"+"("+a3+")");
			
		} else {
			/*File file1 = new File(imgsUrl1[0]);
			File file2 = new File(imgsUrl2[0]);
			File file3 = new File(imgsUrl3[0]);
			if (file.exists() ) {
				Bitmap bitmap = BitmapFactory.decodeFile(bean
						.getInnerSchool());
				vh.img_sch_view.setImageBitmap(bitmap);*/
			}
		
		
		vh.img_sch_view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCallBack1.click1(v); //调用接口的方法
			}
		});
		vh.img_sch_view.setTag(position);
		vh.img_sour_view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCallBack2.click2(v); //调用接口的方法
			}
		});
		vh.img_sour_view.setTag(position);
		vh.img_cas_view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCallBack3.click3(v); //调用接口的方法
			}
		});
		vh.img_cas_view.setTag(position);

	  //  vh.dianzanshu.setTag(position);
	  //给Button添加单击事件  添加Button之后ListView将失去焦点  需要的直接把Button的焦点去掉 
	  //  vh.dianzanshu.setOnClickListener(myListener1);
	    //vh.dianzanshu.setOnClickListener(MyListener(position));  
	    
	    
	    //图片先放放，后面再做
//	    boolean isNet = true;
//		if (isNet) {
//			imageLoader.DisplayImage(bean.getPicture(), vh.mIv);
//		} else {
//			File file = new File(bean.getPicture());
//			if (file.exists()) {
//				Bitmap bitmap = BitmapFactory.decodeFile(bean.getPicture());
//				vh.mIv.setImageBitmap(bitmap);
//			}
//		}
	    
	    //对于listview中的每个控件都实现点击事件方法是重写getview（）方法，在这里面来进行
	    
		return convertView;
	}
	
	public class ViewHolder {
	
		private TextView schoolName; //學校名w
		private ImageView img_sch_view; //校内图片
		private TextView schNum; //校内图片张数
		private ImageView img_sour_view; //周边美景
		private TextView sourNum; //周边美景图片张数
		private ImageView img_cas_view; //随手拍	
		private TextView casNum; //随手拍图片张数
	}
	
	/**
	* 利用BitmapShader绘制圆角图片
	*
	* @param bitmap
	* 待处理图片
	* @param outWidth
	* 结果图片宽度，一般为控件的宽度
	* @param outHeight
	* 结果图片高度，一般为控件的高度
	* @param radius
	* 圆角半径大小
	* @return
	* 结果图片
	*/
	private Bitmap roundBitmapByShader(Bitmap bitmap, int outWidth, int outHeight, int radius) {
	if(bitmap == null) {
	throw new NullPointerException("Bitmap can't be null");
	}
	// 初始化缩放比
	float widthScale = outWidth * 1.0f / bitmap.getWidth();
	float heightScale = outHeight * 1.0f / bitmap.getHeight();
	Matrix matrix = new Matrix();
	matrix.setScale(widthScale, heightScale);

	// 初始化绘制纹理图
	BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
	// 根据控件大小对纹理图进行拉伸缩放处理
	bitmapShader.setLocalMatrix(matrix);

	// 初始化目标bitmap
	Bitmap targetBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);

	// 初始化目标画布
	Canvas targetCanvas = new Canvas(targetBitmap);

	// 初始化画笔
	Paint paint = new Paint();
	paint.setAntiAlias(true);
	paint.setShader(bitmapShader);

	// 利用画笔将纹理图绘制到画布上面
	targetCanvas.drawRoundRect(new RectF(0, 0, outWidth, outWidth), radius, radius, paint);

	return targetBitmap;
	}
}
