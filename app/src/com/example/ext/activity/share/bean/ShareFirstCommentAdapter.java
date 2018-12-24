package com.example.ext.activity.share.bean;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ext.R;

public class ShareFirstCommentAdapter extends BaseAdapter {

	private List<ShareFirstCommentBean> mData;
	private Context mContext;

	public ShareFirstCommentAdapter(Context mContext,
			List<ShareFirstCommentBean> mData) {
		this.mContext = mContext;
		this.mData = mData;
	}

	@Override
	public int getCount() {
		return mData == null ? 0 : mData.size();
	}

	@Override
	public ShareFirstCommentBean getItem(int position) {

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
					R.layout.list_item_share_firstcomment, parent, false);
			vh = new ViewHolder();
			vh.mName = (TextView) convertView.findViewById(R.id.user_name);
			vh.mTime = (TextView) convertView.findViewById(R.id.nowtime);
			vh.mDiscribe = (TextView) convertView.findViewById(R.id.content);

			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		vh.mName.setTag(position);

		ShareFirstCommentBean bean = mData.get(position);

		vh.mName.setText(bean.getName());
		vh.mTime.setText(bean.getCommentTime());
		vh.mDiscribe.setText(bean.getContent());

		// 对于listview中的每个控件都实现点击事件方法是重写getview（）方法，在这里面来进行

		return convertView;
	}

	public class ViewHolder {

		private TextView mName;

		private TextView mTime;

		private TextView mDiscribe;

	}
}
