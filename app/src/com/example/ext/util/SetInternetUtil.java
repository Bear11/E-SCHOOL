package com.example.ext.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

public class SetInternetUtil {
	// 声明网络服务类对象
	private static InternetService internetService;

	public static boolean isNetworkConnected(final Context context) {
		if (context == null) {
			return false;
		}
		internetService = new InternetService(context); // 初始化网络服务实例
		if (internetService.isAirplaneModeOn()) {
			Toast.makeText(context, "温馨提示:您正处于飞行模式！！！", 3000).show();
			return false;
		} else {
			if (!internetService.isNetworkConnected()) {
				if (!internetService.isWifiEnabled()) {
					Dialog dialog = new AlertDialog.Builder(context)
							.setIcon(android.R.drawable.btn_star)
							.setTitle("网络设置").setMessage("请选择连接方式？")
							.setPositiveButton("Wifi", new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									internetService.toggleWiFi(true);
									Toast.makeText(context,
											"温馨提示:连接Wifi需要时间，请您稍等！", 4000)
											.show();
								}
							}).setNegativeButton("取消", new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub

								}
							}).setNeutralButton("移动数据", new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									try {
										internetService.toggleGprs(true);
										Toast.makeText(context,
												"温馨提示:连接移动数据需要时间，请您稍等！", 4000)
												.show();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}).create();
					dialog.show();
					return false;
				} else {
					if (internetService.isMobileConnected()) {
						Toast.makeText(context, "温馨提示:您当前的网络不可用！！！", 4000)
								.show();
						return false;
					} else {
						new AlertDialog.Builder(context).setTitle("网络设置")
								.setMessage("Wifi不可用，是否连接移动数据？")
								.setPositiveButton("是", new OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										try {
											internetService.toggleGprs(true);
											Toast.makeText(context,
													"温馨提示:连接移动数据需要时间，请您稍等！",
													4000).show();
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}).setNegativeButton("否", null).show();
						return false;
					}
				}
			}// 判断网络是否连接可用结束
		}
		return true;
	}

	public static void getAllWifiList(Context context) {
		internetService = new InternetService(context); // 初始化网络服务实例
		if (internetService.getAllWifiList() != null
				&& !internetService.isWifiEnabled()) {
			Toast.makeText(context, "温馨提示:附近有wifi", 5000).show();
		}
		;
	}

}
