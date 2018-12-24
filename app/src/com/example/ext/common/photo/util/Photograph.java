package com.example.ext.common.photo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.format.DateFormat;

/**
 * 
 * @author Administrator
 * 处理返回的图片数据，并刷新系统相册
 * context代表Activity对象，resultCode拍照完后返回的结果编码
 */
public class Photograph {
	public static void BitmapDealAndReflashAlbum(Context context,int resultCode) {
		if (Bimp.tempSelectBitmap.size() < 9 && resultCode == Activity.RESULT_OK) {
			//设置图片文件的名称
			String fileName = DateFormat.format("yyyyMMddkkmmss",System.currentTimeMillis()).toString();
			//获取缓存的图片Bitmap对象
			String path = Environment.getExternalStorageDirectory()+"/workupload.jpg";
			Bitmap camorabitmap = null;
			try {
				InputStream is = new FileInputStream(path);
				if(is != null){
					BitmapFactory.Options opts=new BitmapFactory.Options();
					opts.inTempStorage = new byte[100 * 1024];
					opts.inPreferredConfig = Bitmap.Config.RGB_565;
					opts.inPurgeable = true;
					opts.inSampleSize = 4;
					opts.inInputShareable = true;
					camorabitmap =BitmapFactory.decodeStream(is,null, opts); 
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			Bitmap camorabitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/workupload.jpg"); 				
			 if(null != camorabitmap ){
		         // 下面这两句是对图片按照一定的比例缩放，这样就可以完美地显示出来。
		         int scale = ImageThumbnail.reckonThumbnail(camorabitmap.getWidth(),camorabitmap.getHeight(), 500, 600);   
		         Bitmap bitmap = ImageThumbnail.PicZoom(camorabitmap, camorabitmap.getWidth() / scale,camorabitmap.getHeight() / scale); 
		         //下面是普通缩略图
//		         Bitmap bm = ImageThumbnail.PicZoom(camorabitmap, camorabitmap.getWidth() / scale,camorabitmap.getHeight() / scale);  
		         //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常  
		         //保存经过处理的照片
		         FileUtils.saveBitmap(bitmap, fileName);
		       //显示刚拍完的照片的缩略图
				ImageItem takePhoto = new ImageItem();
				takePhoto.setBitmap(bitmap);
				takePhoto.setImagePath(FileUtils.SDPATH + fileName + ".jpg");
				Bimp.tempSelectBitmap.add(takePhoto);	
		       }
	
			//保存完后，需要刷新系统相册 	
			File f = new File(FileUtils.SDPATH, fileName + ".jpg");
			Uri localUri = Uri.fromFile(f);
			Intent localIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, localUri);
			context.sendBroadcast(localIntent);	
		}
	}
}
