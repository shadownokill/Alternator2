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

import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.fragment.RealTimeDetail1Fragment;
import com.shadow.alternator.fragment.RealTimeDetail2Fragment;
import com.shadow.alternator.fragment.RealTimeDetail4Fragment;

public class AlternatorRealTimeDetailActivity extends BaseActivity {

	private HorizontalScrollView hsv_titles;
	private LinearLayout llayout_titles;
	private ViewPager viewpager;
	private DetailPagerAdapter adapter;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_fragments);
		initView();
	}

	private View getTypeTitleView(String type, final int index) {

		View v = LayoutInflater.from(this).inflate(R.layout.item_type, null);
		TextView name = (TextView) v.findViewById(R.id.text_tab);
		TextView text_line = (TextView) v.findViewById(R.id.text_line);
		v.setBackgroundColor(getResources().getColor(R.color.deep_blue2));
		name.setText(type);
		name.setTextColor(Color.WHITE);
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
			name.setTextColor(Color.parseColor("#FFFFFF"));
		}
	}

	private void initView() {
		hsv_titles = (HorizontalScrollView) findViewById(R.id.hsv_titles);
		llayout_titles = (LinearLayout) findViewById(R.id.llayout_titles);
		hsv_titles.setBackgroundColor(getResources().getColor(R.color.deep_blue2));
		llayout_titles.addView(getTypeTitleView("发动机", 0));
		llayout_titles.addView(getTypeTitleView("发电", 1));
		llayout_titles.addView(getTypeTitleView("市电", 2));
		llayout_titles.addView(getTypeTitleView("控制器", 3));
		TypeTitle.on(llayout_titles.getChildAt(0));
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				hsv_titles.scrollTo((int) llayout_titles.getChildAt(arg0).getX(), 0);
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

		title.text_title.setText("实时信息");
		viewpager.setAdapter(new DetailPagerAdapter(getSupportFragmentManager()));
	}

	class DetailPagerAdapter extends FragmentPagerAdapter {
		private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

		public DetailPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
			fragments.add(new RealTimeDetail1Fragment());
			RealTimeDetail2Fragment d1 = new RealTimeDetail2Fragment();
			Bundle bundle = new Bundle();
			bundle.putInt("page", 1);
			d1.setArguments(bundle);
			fragments.add(d1);
			RealTimeDetail2Fragment d2 = new RealTimeDetail2Fragment();
			Bundle bundle2 = new Bundle();
			bundle2.putInt("page", 2);
			d2.setArguments(bundle2);
			fragments.add(d2);
			fragments.add(new RealTimeDetail4Fragment());
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

}
