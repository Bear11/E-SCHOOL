package com.example.ext.activity.user;

import java.util.HashMap;
import java.util.Map;

import com.example.ext.R;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.util.HttpRequestor;
import com.example.ext.util.ImageLoader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GoodsDetails extends Activity{
	
	private ImageView goodsImage;
	private TextView cost;
	private TextView num;
	private TextView Name;
	private ImageView head;
	private TextView note;
	private TextView jian;
	private TextView add;
	private Map<String, String> map=null;
	
	private ImageLoader imageloader;
	
	private String Num;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.goodsdetails);
		this.goodsImage=(ImageView)findViewById(R.id.trade_pic);
		this.cost=(TextView)findViewById(R.id.goods_price);
		this.num=(TextView)findViewById(R.id.num);
		this.Name=(TextView)findViewById(R.id.td_user_name);
		this.head=(ImageView)findViewById(R.id.td_img_pic);
		this.note=(TextView)findViewById(R.id.td_trade_dsc);
		this.jian=(TextView)findViewById(R.id.buy_icon);
		this.add=(TextView)findViewById(R.id.buy_icon2);
		
		imageloader = new ImageLoader(this);
		map = new HashMap<String, String>();
		
		Intent it = super.getIntent();
		String GoodsImage=it.getStringExtra("goodsImage");
		String Cost=it.getStringExtra("cost");
		this.Num=it.getStringExtra("num");
		final String gid=it.getStringExtra("gid");
		String name=it.getStringExtra("name");
		String Head=it.getStringExtra("image");
		String Note=it.getStringExtra("note");
		
//		MarginLayoutParams margin9 = new MarginLayoutParams(
//				goodsImage.getLayoutParams());
//		margin9.setMargins(400, 10, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
//		RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(margin9);
//		layoutParams9.height = 600;//设置图片的高度
//		layoutParams9.width = 800; //设置图片的宽度
//		goodsImage.setLayoutParams(layoutParams9);
		
		imageloader.DisplayImage(GoodsImage, this.goodsImage);
		cost.setText(Cost);
		num.setText(Num);
		Name.setText(name);
		imageloader.DisplayImage(Head, this.head);
		note.setText(Note);
		if(Integer.valueOf(Num)==0)
		{
			jian.setText("已售完！！");
		}
		
		
		
		jian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(Integer.valueOf(Num)==0)
				{
					Toast.makeText(getApplicationContext(),"已售完~~",Toast.LENGTH_SHORT).show(); 
					jian.setText("已售完！！");
				}
				else
				{
					Num=String.valueOf(Integer.valueOf(Num)-1);
					num.setText(Num);
					String res;
					String httpUrl;
					map.put("x", Num);
					map.put("gid", gid);
					httpUrl = GlobalFinal.path.concat("user3_updateGoods.action?");
					HttpRequestor http = new HttpRequestor();
					res = http.loginPostData(httpUrl, map);
				}
				
			}
		});
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
					jian.setText("未售完减少库存");
				Num=String.valueOf(Integer.valueOf(Num)+1);
				num.setText(Num);
				String res;
				String httpUrl;
				map.put("x", Num);
				map.put("gid", gid);
				httpUrl = GlobalFinal.path.concat("user3_updateGoods.action?");
				HttpRequestor http = new HttpRequestor();
				res = http.loginPostData(httpUrl, map);
				
			}
		});
		
	}

}
