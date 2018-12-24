package com.example.ext.fragment.campus;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.example.ext.R;
import com.example.ext.activity.share.ShareComment;
import com.example.ext.activity.user.AddGoods;
import com.example.ext.activity.user.AddGoods.GridAdapter;
import com.example.ext.activity.user.AddGoods.GridAdapter.ViewHolder;
import com.example.ext.common.baseData.GlobalFinal;
import com.example.ext.common.baseData.GlobalStatic;
import com.example.ext.common.baseData.GlobalStaticFun;
import com.example.ext.common.photo.dophoto.AlbumActivity;
import com.example.ext.common.photo.dophoto.GalleryActivity;
import com.example.ext.common.photo.util.Bimp;
import com.example.ext.common.photo.util.FileUtils;
import com.example.ext.common.photo.util.Photograph;
import com.example.ext.common.photo.util.PublicWay;
import com.example.ext.common.photo.util.Res;
import com.example.ext.util.HttpService_;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AddCampusGround extends Activity {
	
	private EditText note;
	private EditText address;
	private TextView tv_send = null;
	private RelativeLayout layout;
	private String Note;
	private String Address;
	protected static final int MESSAGETYPE = 0;
	private String Id;
	
	private Dialog progressDialog = null;
	private PopupWindow pop = null;
	private LinearLayout ll_popup;
	private GridView noScrollgridview; // 九宫图对象
	private GridAdapter adapter;
	private View parentView;
	public static Bitmap bimap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.campus_ground_report);
		this.note = (EditText) findViewById(R.id.note);
		this.address = (EditText) findViewById(R.id.fb_dis);
		this.tv_send = (TextView) findViewById(R.id.send);
		layout = (RelativeLayout) findViewById(R.id.pop_layout);
		// 很重要的一句，避免了layout两边有间隙
		
		Res.init(this);
		bimap = BitmapFactory.decodeResource(getResources(),
				R.drawable.icon_addpic_unfocused); // 图像处理对象
		GlobalStatic.setFlagImageUp(7);
		parentView = getLayoutInflater().inflate(R.layout.campus_ground_report,
				null);
		
		PublicWay.activityList.add(this);
		
		SharedPreferences share = super.getSharedPreferences("bcit",
				Activity.MODE_PRIVATE); 
		
		Id=share.getString("id", "0");
		
		getWindow().setLayout(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		
		Init();
		
		tv_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				progressDialog = GlobalStaticFun.createLoadingDialog(
						AddCampusGround.this, GlobalFinal.picSaveTip);
				progressDialog.show();
				execute();
			}
		});
	}
	
	private void execute() {
		try {
			new Thread(new Runnable() {// ����һ���̵߳ķ��������ڰ�׿�����̨��������
						@Override
						public void run() {
							// ����������ݼ���ʵ�ִ���
							String res = initData();
							Message msg_netData = new Message();
							msg_netData.obj = res;
							msg_netData.what = MESSAGETYPE;// ��Ϊ�̵߳ı�ʶ�����ܺ�����в�ͬ��С�Ǵ���
							operate.sendMessage(msg_netData);
						}
					}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Handler operate = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if ("error".equals(msg)) {
				Toast.makeText(AddCampusGround.this, "上传失败 = =",
						Toast.LENGTH_SHORT).show();
				/*Intent it = new Intent(ShareComment.this, SharingCenterDetail.class); // 实例化Intent
				it.putExtra("vaule","error");	
				startActivity(it);*/
			} else {
				Toast.makeText(AddCampusGround.this, "上传成功~~", Toast.LENGTH_SHORT)
						.show();
				/*Intent it = new Intent(ShareComment.this, SharingCenterDetail.class); // 实例化Intent
				it.putExtra("vaule","success");	
				startActivity(it);*/
				//finish(); // 跳转回评论页面
			}
			switch (msg.what) {
			case MESSAGETYPE:
				progressDialog.dismiss();
				Toast.makeText(AddCampusGround.this,
						GlobalFinal.picSuccessTip, GlobalFinal.tipTime2).show();
				break;
			default:
				break;
			}
		}
	};

	protected String initData() {

		String res = null;
		
		HttpService_ http = new HttpService_();
		Map<String, String> map = new HashMap<String, String>();
		Note = note.getText().toString();
		Address= address.getText().toString();
		
		map.put("id", Id);
		map.put("note", Note); 
		map.put("address", Address);
		
		FileUtils.uploadFile(this,
				GlobalFinal.path.concat("AddCampusSurroundServlet.do"),
				map);
		
		//res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		} else {
		}
		return res;
	}
	
	public void Init() {
		// 在MainActivity中声明对话框对象
		pop = new PopupWindow(AddCampusGround.this);
		// 获取拍照、从相册获取照片和取消按钮的xml的文件对象
		View view = getLayoutInflater().inflate(R.layout.item_popupwindows,
				null); // 动态载入弹出窗界面
		// 获取放置拍照、从相册获取照片和取消按钮的LinearLayout的面板对象
		ll_popup = (LinearLayout) view.findViewById(R.id.ll_popup);

		pop.setWidth(LayoutParams.MATCH_PARENT);
		pop.setHeight(LayoutParams.WRAP_CONTENT);
		pop.setBackgroundDrawable(new BitmapDrawable());
		pop.setFocusable(true);
		pop.setOutsideTouchable(true);
		pop.setContentView(view);

		RelativeLayout parent = (RelativeLayout) view.findViewById(R.id.parent);
		Button bt1 = (Button) view.findViewById(R.id.item_popupwindows_camera);
		Button bt2 = (Button) view.findViewById(R.id.item_popupwindows_Photo);
		Button bt3 = (Button) view.findViewById(R.id.item_popupwindows_cancel);

		parent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});
		bt1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				photo();
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 从相册获取照片的界面
				Intent intent = new Intent(AddCampusGround.this,
						AlbumActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.activity_translate_in,
						R.anim.activity_translate_out);
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});
		bt3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});

		// 初始化缩略图控件
		noScrollgridview = (GridView) findViewById(R.id.noScrollgridview);
		noScrollgridview.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter = new GridAdapter(this);
		adapter.update();
		noScrollgridview.setAdapter(adapter);
		// int a = this.adapter.getCount();
		// System.out.println(a);
		// picArray = new String[adapter.getCount()];//图片数组的初始化
		noScrollgridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == Bimp.tempSelectBitmap.size()) {
					Log.i("ddddddd", "----------");
					ll_popup.startAnimation(AnimationUtils.loadAnimation(
							AddCampusGround.this,
							R.anim.activity_translate_in));
					pop.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
				} else {
					Intent intent = new Intent(AddCampusGround.this,
							GalleryActivity.class);
					intent.putExtra("position", "1");
					intent.putExtra("ID", arg2);
					startActivity(intent);
				}
			}
		});

	}

	/* -------------------以下是一个缩略图的适配器（开始）-------------------- */
	@SuppressLint("HandlerLeak")
	public class GridAdapter extends BaseAdapter {
		private LayoutInflater inflater; // 申明一个动态载入Activity的对象
		private int selectedPosition = -1; // 声明一个选中的位置变量
		private boolean shape; // 声明一个Boolean变量

		public boolean isShape() {
			return shape;
		}

		public void setShape(boolean shape) {
			this.shape = shape;
		}

		public GridAdapter(Context context) { // 适配器的构造函数
			inflater = LayoutInflater.from(context);
		}

		public void update() { // 更新适配器
			loading(); // 往适配器载入数据
		}

		public int getCount() {
			// 获取选择的图片的临时列表的大小，BaseAdapter的重载函数
			if (Bimp.tempSelectBitmap.size() == 9) {
				return 9;
			}
			return (Bimp.tempSelectBitmap.size() + 1);
		}

		public Object getItem(int arg0) { // BaseAdapter的重载函数
			return null;
		}

		public long getItemId(int arg0) { // BaseAdapter的重载函数
			return 0;
		}

		public void setSelectedPosition(int position) {
			selectedPosition = position;
		}

		public int getSelectedPosition() {
			return selectedPosition;
		}

		/*
		 * BaseAdapter最重要的重载函数,position是指当前dataset的位置，通过getCount和getItem来使用，
		 * convertView是指可以重用的视图，即刚刚出队的视图，parent是list。
		 */
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_published_grida,
						parent, false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.item_grida_image);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			if (position == Bimp.tempSelectBitmap.size()) {
				holder.image.setImageBitmap(BitmapFactory.decodeResource(
						getResources(), R.drawable.icon_addpic_unfocused));
				if (position == 9) {
					holder.image.setVisibility(View.GONE);
				}
			} else {
				holder.image.setImageBitmap(Bimp.tempSelectBitmap.get(position)
						.getBitmap());
				/*
				 * picArray[position] = Bimp.tempSelectBitmap.get(position)
				 * .getImagePath();
				 */
				// String imgPath =
				// Bimp.tempSelectBitmap.get(position).getImagePath();
				// map1.put(Integer.valueOf(position).toString(),imgPath);
				// map.put(position,imgPath); //将图片路径和位置对应好，储存于map集合中
				/*
				 * System.out.println("List选中上传的集合--" + map.size());
				 * System.out.println("List选中上传的集合Path--" + map.get(position));
				 */}
			// int a = position;
			// System.out.println(a);
			return convertView;
		}
	
		public class ViewHolder {
			public ImageView image;
		}

		Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					if (adapter != null) {
						adapter.notifyDataSetChanged();
					}
					break;
				}
				super.handleMessage(msg);
			}
		};

		public void loading() {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						if (Bimp.max == Bimp.tempSelectBitmap.size()) {
							Message message = new Message();
							message.what = 1;
							handler.sendMessage(message);
							break;
						} else {
							Bimp.max += 1;
							Message message = new Message();
							message.what = 1;
							handler.sendMessage(message);
							// break; // 新添加的，看看能不能使用
						}
					}
				}
			}).start();
		}
	}
		
	/* -------------------以上是一个缩略图的适配器（结束）-------------------- */

	public String getString(String s) {
		String path = null;
		if (s == null)
			return "";
		for (int i = s.length() - 1; i > 0; i++) {
			s.charAt(i);
		}
		return path;
	}

	protected void onRestart() {
		adapter.update();
		super.onRestart();
	}

	private static final int TAKE_PICTURE = 0x000001;

	public void photo() {
		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		Uri imageUri = null;
		imageUri = Uri.fromFile(new File(Environment
				.getExternalStorageDirectory(), "workupload.jpg"));
		// 指定照片保存路径（SD卡），workupload.jpg为一个临时文件，每次拍照后这个图片都会被替换
		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		// picArray[0] = imageUri;
		startActivityForResult(openCameraIntent, TAKE_PICTURE);
	}

	protected void onActivityResult(int requestCode, int resultCode,
			final Intent data) {
		switch (requestCode) {
		case TAKE_PICTURE:
			// 处理返回的图片数据，并刷新系统相册
			if (Bimp.tempSelectBitmap.size() < 9 && resultCode == RESULT_OK) {
				/*
				 * new Thread(new Runnable() {
				 * 
				 * @Override public void run() { // TODO Auto-generated method
				 * stub String fileName =
				 * String.valueOf(System.currentTimeMillis()); Bitmap bm =
				 * (Bitmap) data.getExtras().get("data");
				 * FileUtils.saveBitmap(bm, fileName);
				 * //看这里要不要改写saveBitmap方法，将路径返回出来 ImageItem takePhoto = new
				 * ImageItem(); takePhoto.setBitmap(bm);
				 * takePhoto.setImagePath(imgPath);
				 * Bimp.tempSelectBitmap.add(takePhoto); } }).start();
				 */
				// String fileName = String.valueOf(System.currentTimeMillis());
				// Bitmap bm = (Bitmap) data.getExtras().get("data");
				// FileUtils.saveBitmap(bm, fileName);
				// ImageItem takePhoto = new ImageItem();
				// takePhoto.setBitmap(bm);
				// Bimp.tempSelectBitmap.add(takePhoto);
				if (resultCode == Activity.RESULT_OK) {
					Photograph.BitmapDealAndReflashAlbum(getApplication(),
							resultCode);
				}
			}
			break;
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			for (int i = 0; i < PublicWay.activityList.size(); i++) {
				if (null != PublicWay.activityList.get(i)) {
					PublicWay.activityList.get(i).finish();
				}
			}
			System.exit(0);
		}
		return true;
	}

	

	/*
	 * 自定义拼接方法 目的：将图片数组转成一串字符串并返回 返回值： 拼接后的字符串 作者：zcc
	 * 注意：这里拼接出来的字符串最前面有一个逗号，在后台解析的时候得去掉
	 */
	private String picUrl(Map<String, String> a) {
		int length = Integer.valueOf(a.size());// 获取图片数组长度
		String url = " ";
		Set<String> k = a.keySet();// 相当于返回值类型，Set集合加上了范形，类型为String，k相当于变量名
		Iterator<String> it = k.iterator();
		// 利用迭代器来取值，通过Set集合
		while (it.hasNext()) {
			String key = it.next();
			url = url.concat(",").concat(a.get(key));
		}
		return url;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

}
