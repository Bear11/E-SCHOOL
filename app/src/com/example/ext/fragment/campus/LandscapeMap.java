package com.example.ext.fragment.campus;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.ext.R;

public class LandscapeMap extends Fragment implements OnCheckedChangeListener {
	private View parentView;
	private RadioGroup radioGroup;
	private RadioButton rbTongZhi, rbDongTai;
	private ViewPager vp;

	List<Fragment> list = null;

	// private ImageView iv_add;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.landscape_map, container, false);
		radioGroup = (RadioGroup) parentView.findViewById(R.id.radioGroup2);
		rbTongZhi = (RadioButton) parentView.findViewById(R.id.rbTongZhi2);
		rbDongTai = (RadioButton) parentView.findViewById(R.id.rbDongTai2);
		vp = (ViewPager) parentView.findViewById(R.id.viewpagerHuDong2);
		// iv_add = (ImageView) parentView.findViewById(R.id.iv_add);

		list = new ArrayList<Fragment>();
		LandscapeWall tzf = new LandscapeWall();
		CampuMap dtf = new CampuMap();
		list.add(tzf);
		list.add(dtf);

		ZxzcAdapter zxzc = new ZxzcAdapter(getChildFragmentManager(), list);
		vp.setAdapter(zxzc);
		zxzc.notifyDataSetChanged();

		radioGroup.setOnCheckedChangeListener(this);
		rbTongZhi.setChecked(true);

		// �����л�
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					rbTongZhi.setChecked(true);
					break;
				case 1:
					rbDongTai.setChecked(true);
					break;

				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		// //����ұ���ʾ
		// iv_add.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// AddPopWindow addPopWindow = new AddPopWindow(getActivity());
		// addPopWindow.showPopupWindow(iv_add);
		// }
		//
		// });

		return parentView;
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int cheakedId) {
		if (cheakedId == rbTongZhi.getId()) {
			vp.setCurrentItem(0);
		} else if (cheakedId == rbDongTai.getId()) {
			vp.setCurrentItem(1);
		}
	}

	class ZxzcAdapter extends FragmentStatePagerAdapter {

		List<Fragment> list;

		public ZxzcAdapter(FragmentManager fm, List<Fragment> list) {
			super(fm);
			this.list = list;
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {

			return list.size();
		}

	}

}
