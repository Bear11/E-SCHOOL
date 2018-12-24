package com.example.ext.activity.campus;

import java.util.ArrayList;
import java.util.List;

import com.example.ext.R;
import com.example.ext.fragment.campus.CampusGround;
import com.example.ext.fragment.campus.InformationGround;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class CampusGroundDetail extends FragmentActivity implements OnCheckedChangeListener{

	private View parentView;
	private RadioGroup radioGroup;
	private RadioButton rbTongZhi, rbDongTai;
	private ViewPager  vp;

	List<Fragment> list = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	//	parentView = inflater.inflate(R.layout.titie_header_informationground, container, false);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
		setContentView(R.layout.titie_header_informationground);
		
		Intent it = getIntent();
		int l=Integer.valueOf(it.getStringExtra("l"));
		
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
		rbTongZhi = (RadioButton)findViewById(R.id.rbTongZhi1);
		rbDongTai = (RadioButton)findViewById(R.id.rbDongTai1);
		vp=(ViewPager)findViewById(R.id.id_page_vp);
	//	iv_add = (ImageView) parentView.findViewById(R.id.iv_add); 
		
		list = new ArrayList<Fragment>();
		InformationGround tzf=new InformationGround();
		CampusGround dtf=new CampusGround();
		list.add(tzf);
		list.add(dtf);
		
		ZxzcAdapter zxzc = new ZxzcAdapter(getSupportFragmentManager(), list);
		vp.setAdapter(zxzc);
		zxzc.notifyDataSetChanged();
		
		radioGroup.setOnCheckedChangeListener(this);
		
		if(l==1)
		{
			rbTongZhi.setChecked(true);
		}
		else
			rbDongTai.setChecked(true);
		
		
		
		
		
		
		//�����л�
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
		
//		//����ұ���ʾ
//		iv_add.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                AddPopWindow addPopWindow = new AddPopWindow(getActivity());
//                addPopWindow.showPopupWindow(iv_add);
//            }
//
//        });

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
		public ZxzcAdapter(FragmentManager fm,List<Fragment> list) {
			super(fm);
			this.list=list;			
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
