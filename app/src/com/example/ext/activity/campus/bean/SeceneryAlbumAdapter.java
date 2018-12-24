package com.example.ext.activity.campus.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalStatic;
import com.example.ext.util.ImageLoader;
import com.example.ext.util.MemoryCache;

public class SeceneryAlbumAdapter extends BaseAdapter{

	private ImageView[] mImages;		// 定义一个图片的显示数组
	private Context mContext;
	//private List<ImageLoader> imageList;
	private ImageLoader imageLoader;
	public List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	private String[] pathName;
	Map<String, Object> map = new HashMap<String, Object>();
	//private String aa = "";
	
	/*public Integer[] imgs = { R.drawable.item01, R.drawable.item02, R.drawable.item03,
							  R.drawable.item04, R.drawable.item05};*/
	public String[] titles = { "01", "02", "03", "04", "05", "06", "07"};

	//得到全局静态变量图片路径值
	public String[] imgs = GlobalStatic.getmData();
	
	public SeceneryAlbumAdapter(Context c) 
	{
		this.mContext = c;
		imageLoader = new ImageLoader(mContext);
		//list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imgs.length; i++) {
			//HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("image", imgs[i]);
			list.add(map); 
		}
		//[{image=http://192.168.43.224:8080/ext_web/picture/secenery_pics/cyut/inner/inner1.jpg}, {image=http://192.168.43.224:8080/ext_web/picture/secenery_pics/cyut/inner/inner2.jpg}, {image=http://192.168.43.224:8080/ext_web/picture/secenery_pics/cyut/inner/inner3.jpg}, {image=http://192.168.43.224:8080/ext_web/picture/secenery_pics/cyut/inner/inner4.jpg}, {image=http://192.168.43.224:8080/ext_web/picture/secenery_pics/cyut/inner/inner5.jpg}, {image=http://192.168.43.224:8080/ext_web/picture/secenery_pics/cyut/inner/inner7.jpg}]
		mImages = new ImageView[list.size()];
		pathName = new String[list.size()];
		
	}

	/** ���䵹Ӱ */
	public boolean createReflectedImages() 
	{
		MemoryCache memoryCache = new MemoryCache();
		final int reflectionGap = 4;
		final int Height = 200;
		int index = 0;
		/*private Map<ImageView, String> imageViews = Collections
				.synchronizedMap(new WeakHashMap<ImageView, String>());*/
		for (Map<String, Object> map : list) {
			//Integer id = (Integer) map.get("image");
			// ��ȡԭʼͼ
			//Bitmap originalImage = BitmapFactory.decodeResource(mContext.getResources(), id);	
			pathName[index] = (String) map.get("image");
			//imageList.add(index, new ImageLoader(mContext));
			//Bitmap originalImage = imageList.get(index).getBitmap(pathName[index]);
			String aa = pathName[index];
			Bitmap originalImage = imageLoader.getBitmap(pathName[index]);
			//imageList.get(index);
			//String aa = pathName[index];
			int width = originalImage.getWidth();
			int height = originalImage.getHeight();
			float scale = Height / (float)height;
			
			Matrix sMatrix = new Matrix();
			sMatrix.postScale(scale, scale);
			Bitmap miniBitmap = Bitmap.createBitmap(originalImage, 0, 0,
					originalImage.getWidth(), originalImage.getHeight(), sMatrix, true);
			
			//�Ƿ�ԭͼƬ���ݣ���ʡ�ڴ�
			originalImage.recycle();

			int mwidth = miniBitmap.getWidth();
			int mheight = miniBitmap.getHeight();
			Matrix matrix = new Matrix();
			matrix.preScale(1, -1);			// ͼƬ����任���ӵͲ��򶥲��ĵ�Ӱ��
			Bitmap reflectionImage = Bitmap.createBitmap(miniBitmap, 0, mheight/2, mwidth, mheight/2, matrix, false);	// ��ȡԭͼ�°벿��
			Bitmap bitmapWithReflection = Bitmap.createBitmap(mwidth, (mheight + mheight / 2), Config.ARGB_8888);			// ������ӰͼƬ���߶�Ϊԭͼ3/2��

			Canvas canvas = new Canvas(bitmapWithReflection);	// ���Ƶ�Ӱͼ��ԭͼ + ��� + ��Ӱ��
			canvas.drawBitmap(miniBitmap, 0, 0, null);		// ����ԭͼ
			Paint paint = new Paint();
			canvas.drawRect(0, mheight, mwidth, mheight + reflectionGap, paint);		// ����ԭͼ�뵹Ӱ�ļ��
			canvas.drawBitmap(reflectionImage, 0, mheight + reflectionGap, null);	// ���Ƶ�Ӱͼ

			paint = new Paint();
			LinearGradient shader = new LinearGradient(0, miniBitmap.getHeight(), 0, bitmapWithReflection.getHeight()
					+ reflectionGap, 0x70ffffff, 0x00ffffff, TileMode.CLAMP);
			paint.setShader(shader);	// ���Խ���Ч��
			paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));		// ��Ӱ����Ч��
			canvas.drawRect(0, mheight, mwidth, bitmapWithReflection.getHeight() + reflectionGap, paint);		// ���Ƶ�Ӱ����ӰЧ��

			ImageView imageView = new ImageView(mContext);
			imageView.setImageBitmap(bitmapWithReflection);		// ���õ�ӰͼƬ
			imageView.setLayoutParams(new GalleryView.LayoutParams((int)(width * scale),
					(int)(mheight * 3 / 2.0 + reflectionGap)));
			imageView.setScaleType(ScaleType.MATRIX);
			mImages[index++] = imageView;
		}
		return true;
	}

	@Override
	public int getCount() {
		return imgs.length;
	}

	@Override
	public Object getItem(int position) {
		return mImages[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return mImages[position];		// ��ʾ��ӰͼƬ����ǰ��ȡ���㣩
	}

	public float getScale(boolean focused, int offset) {
		return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
	}

}
