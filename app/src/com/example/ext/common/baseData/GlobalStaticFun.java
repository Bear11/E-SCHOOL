package com.example.ext.common.baseData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;
import com.example.ext.util.HttpService_;

public class GlobalStaticFun {
	/**
	 * EditText默认位置的隐藏取消
	 */
	public static OnFocusChangeListener onFocusAutoClearHintListener = new OnFocusChangeListener() {
		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			EditText textView = (EditText) v;
			String hint;
			if (hasFocus) {
				hint = textView.getHint().toString();
				textView.setTag(hint);
				textView.setHint("");
			} else {
				hint = textView.getTag().toString();
				textView.setHint(hint);
			}
		}
	};

	/**
	 * 
	 * @param listView
	 * @date 日期: 2015年7月14日 上午9:20:25
	 * @author 作者： ZhengChenHui
	 * @description 描述:自适应高度
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// Precondition
			return;
		}
		int totalHeight = 0;
		for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0); // 计算子项View 的宽高
			totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setLayoutParams(params);
	}

	/**
	 * 
	 * @param cusId
	 * @param itemId
	 * @date 日期: 2015年7月15日 下午4:26:06
	 * @author 作者： ZhengChenHui
	 * @description 描述:添加经验值
	 */
	public static void submitExperData(String cusId, String itemId) {
		String httpUrl = GlobalFinal.path
				.concat("customerMobile_saveExperience.action?");
		Map<String, String> map = new HashMap<String, String>();
		map.put("cusId", cusId);
		map.put("username", GlobalStatic.getUsername());
		map.put("itemId", itemId);
		HttpService_ http = new HttpService_();
		String res = http.loginPostData(httpUrl, map);
		// if (res.equals("error")) {
		// Toast.makeText(context, GlobalFinal.errorTip,
		// GlobalFinal.tipTime2).show();
		// }
	}

	/**
	 * 得到自定义的progressDialog
	 * 
	 * @param context
	 * @param msg
	 * @return
	 */
	public static Dialog createLoadingDialog(final Context context, String msg) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
		// 加载动画
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.loading_anim);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText(msg);// 设置加载信息

		final Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

		loadingDialog.setCancelable(false);// 不可以用“返回键”取消
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
		new Handler().postDelayed(new Runnable() {
			public void run() {
				if (loadingDialog != null && loadingDialog.isShowing()) {
					loadingDialog.cancel();
				}
			}
		}, 10000);
		loadingDialog.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface arg0) {
				Toast.makeText(context, GlobalFinal.errorTip, Toast.LENGTH_SHORT).show();
			}
		});
		return loadingDialog;

	}
	/**
	 * 
	 * @param context 上下文
	 * @param msg 提示文字
	 * @param caltime 延迟关闭时间
	 * @return
	 * @date 日期: 2015年7月21日 上午11:28:40
	 * @author 作者： ZhengChenHui
	 * @description 描述:得到自定义的progressDialog
	 */
	public static Dialog createLoadingTimeDialog(final Context context, String msg,int caltime) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
		// 加载动画
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.loading_anim);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText(msg);// 设置加载信息

		final Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

		loadingDialog.setCancelable(false);// 不可以用“返回键”取消
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
		new Handler().postDelayed(new Runnable() {
			public void run() {
				if (loadingDialog != null && loadingDialog.isShowing()) {
					loadingDialog.cancel();
				}
			}
		}, caltime);
		loadingDialog.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface arg0) {
				Toast.makeText(context, GlobalFinal.errorTip, Toast.LENGTH_SHORT).show();
			}
		});
		return loadingDialog;

	}
	/**
	 * 
	 * @param context
	 * @param spinnerlayout
	 * @param textView
	 * @param textViewId
	 * @param myspinnerAdapter
	 * @param listSpanner
	 * @date 日期: 2015年7月15日 下午4:33:39
	 * @author 作者： ZhengChenHui
	 * @param spinnerlayout1
	 * @param textViewId
	 * @param textView
	 * @param listSpanner
	 * @param spItemClick
	 * @description 描述:spinner展开
	 */
/*	public static void showWindowSP(Context context,
			final RelativeLayout spinnerlayout, ListAdapter myspinnerAdapter,
			final ArrayList<SpannerData> listSpanner, final TextView textView,
			final TextView textViewId) {
		LayoutInflater inflater1 = LayoutInflater.from(context);
		LinearLayout layout = (LinearLayout) inflater1.inflate(
				R.layout.mypinner_dropdown, null);
		ListView listView1 = (ListView) layout.findViewById(R.id.listView);
		listView1.setAdapter(myspinnerAdapter);
		final PopupWindow popupWindow = new PopupWindow(spinnerlayout);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(spinnerlayout.getWidth());
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置一个透明的背景，不然无法实现点击弹框外，弹框消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击弹框外部，弹框消失
		popupWindow.setOutsideTouchable(true);
		popupWindow.setFocusable(true);
		popupWindow.setContentView(layout);
		// 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏移
		popupWindow.showAsDropDown(spinnerlayout, 0, 0);
		popupWindow.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss() {
				spinnerlayout
						.setBackgroundResource(R.drawable.preference_single_item1);
			}
		});
		// listView的item点击事件
		listView1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				textView.setText(listSpanner.get(arg2).getValue());
				textViewId.setText(listSpanner.get(arg2).getKey());
				popupWindow.dismiss();
			}
		});
	}
	public ArrayList<GoodsClassify> initListSpanner() {
		ArrayList<GoodsClassify> listSpanner = new ArrayList<GoodsClassify>();
		String httpUrl = GlobalFinal.path
				.concat("orderMobile_goodsTypeList.action?");
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", GlobalStatic.getUsername());
		HttpService_ http = new HttpService_();
		String res = http.loginPostData(httpUrl, map);
		if (res.equals("error")) {
			res = "";
		} else {
			res = res.replace("\\", "");
			res = res.substring(0, res.length() - 1);
		}
		if (res != null && (!res.equals(""))) {
			try {
				JSONObject json = new JSONObject(res.substring(8, res.length())
						.replace("<br>", "\n"));
				JSONArray arry = json.getJSONArray("list");
				for (int i = 0; i < arry.length(); i++) {
					JSONObject obj = arry.getJSONObject(i);
					listSpanner.add(new GoodsClassify(obj.getString("id"), obj
							.getString("name"), obj.getString("orderCode")));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			listSpanner = new ArrayList<GoodsClassify>();
		}
		return listSpanner;
	}*/
}
