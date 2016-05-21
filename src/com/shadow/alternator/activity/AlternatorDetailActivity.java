package com.shadow.alternator.activity;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.bean.DeviceModel;
import com.shadow.alternator.fragment.DetailFragment;
import com.shadow.alternator.util.StringTool;

 interface GetModel{
	public DeviceModel getModel();
}
public class AlternatorDetailActivity extends BaseActivity implements GetModel{

	
	private HorizontalScrollView hsv_titles;
	private LinearLayout llayout_titles;
	private ViewPager viewpager;
	private DetailPagerAdapter adapter;
	private String did = "";
	private DeviceModel deviceModel;
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_fragments);
		did = getIntent().getExtras().getString("did");
		deviceModel = new Gson().fromJson(getIntent().getExtras().getString("data"), DeviceModel.class);
		initView();
	}

	private View getTypeTitleView(String type, final int index) {

		View v = LayoutInflater.from(this).inflate(R.layout.item_type, null);
		TextView name = (TextView) v.findViewById(R.id.text_tab);
		TextView text_line = (TextView) v.findViewById(R.id.text_line);
		name.setText(type);
		text_line.setVisibility(View.INVISIBLE);
		v.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewpager.setCurrentItem(index, true);
			}
		});
		return v;
	}


	static class TypeTitle {
		public static void on(View v) {
			TextView text_line = (TextView) v.findViewById(R.id.text_line);
			TextView name = (TextView) v.findViewById(R.id.text_tab);
			text_line.setVisibility(View.VISIBLE);
			name.setTextColor(v.getContext().getResources().getColor(R.color.orange));
		}

		public static void off(View v) {
			TextView text_line = (TextView) v.findViewById(R.id.text_line);
			TextView name = (TextView) v.findViewById(R.id.text_tab);
			text_line.setVisibility(View.INVISIBLE);
			name.setTextColor(Color.parseColor("#333333"));
		}
	}

	private void initView() {
		hsv_titles = (HorizontalScrollView) findViewById(R.id.hsv_titles);
		llayout_titles = (LinearLayout) findViewById(R.id.llayout_titles);
		llayout_titles.addView(getTypeTitleView("发电机组", 0));
		llayout_titles.addView(getTypeTitleView("发动机", 1));
		llayout_titles.addView(getTypeTitleView("发电机", 2));
		llayout_titles.addView(getTypeTitleView("控制器", 3));
		TypeTitle.on(llayout_titles.getChildAt(0));
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				TypeTitle.off(llayout_titles.getChildAt(0));
				TypeTitle.off(llayout_titles.getChildAt(1));
				TypeTitle.off(llayout_titles.getChildAt(2));
				TypeTitle.off(llayout_titles.getChildAt(3));
				TypeTitle.on(llayout_titles.getChildAt(arg0));
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		bindTitle();
		title.text_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		title.text_title.setText("机组详情");
		viewpager.setAdapter(new DetailPagerAdapter(getSupportFragmentManager()));
	}

	class DetailPagerAdapter extends FragmentPagerAdapter {
		private ArrayList<DetailFragment> fragments = new ArrayList<DetailFragment>();

		public DetailPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
			DetailFragment d1 = new DetailFragment();
			Bundle b1 = new Bundle(); 
			b1.putInt("page", 0);
			d1.setArguments(b1);
			fragments.add(d1);
			
			DetailFragment d2 = new DetailFragment();
			Bundle b2 = new Bundle(); 
			b2.putInt("page", 1);
			d2.setArguments(b2);
			fragments.add(d2);
			
			DetailFragment d3 = new DetailFragment();
			Bundle b3 = new Bundle(); 
			b3.putInt("page", 2);
			d3.setArguments(b3);
			fragments.add(d3);
			
			DetailFragment d4 = new DetailFragment();
			Bundle b4 = new Bundle(); 
			b4.putInt("page", 3);
			d4.setArguments(b4);
			fragments.add(d4);
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments.size();
		}

	}

	public static class AlternatorDetail {
		private String type, name;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			if (StringTool.isEmpty(name)) {
				this.name = "";
				return;
			}
			this.name = name;
		}

	}

	@Override
	public DeviceModel getModel() {
		// TODO Auto-generated method stub
		return deviceModel;
	}
}
