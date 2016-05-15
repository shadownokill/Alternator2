package com.shadow.alternator.activity;

import java.util.ArrayList;

import android.content.Context;
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
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.fragment.EngineFragment;
import com.shadow.alternator.fragment.WaringsFragment;

public class AlternatorRealtimeActivity extends BaseActivity {

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
		// 报警，发动机，负载，发电，市电，控制器
		llayout_titles.addView(getTypeTitleView("报警", 0));
		llayout_titles.addView(getTypeTitleView("发动机", 1));
		llayout_titles.addView(getTypeTitleView("负载", 2));
		llayout_titles.addView(getTypeTitleView("发电", 3));
		llayout_titles.addView(getTypeTitleView("市电", 4));
		llayout_titles.addView(getTypeTitleView("控制器", 5));
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
				TypeTitle.off(llayout_titles.getChildAt(4));
				TypeTitle.off(llayout_titles.getChildAt(5));
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
			fragments.add(new WaringsFragment());
			fragments.add(new EngineFragment());
			fragments.add(new EngineFragment());
			fragments.add(new EngineFragment());
			fragments.add(new EngineFragment());
			fragments.add(new EngineFragment());
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

	class DetailFragment extends Fragment {

		private ListView list;

		@Override
		@Nullable
		public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View v = inflater.inflate(R.layout.fragment_list, null);
			v.setBackgroundColor(getResources().getColor(R.color.deep_blue));
			list = (ListView) v.findViewById(R.id.list);
			ArrayList<AlternatorDetail> data = new ArrayList<AlternatorDetail>();
			for (int i = 0; i < 10; i++) {
				AlternatorDetail detail = new AlternatorDetail();
				detail.setName("TestName " + i);
				detail.setType("TestType " + i);
				data.add(detail);
			}
			ContentAdapter adapter = new ContentAdapter(getActivity(), data);
			list.setAdapter(adapter);
			return v;
		}

		class ContentAdapter extends BaseAdapter {
			Context context;
			ArrayList<AlternatorDetail> data;

			public ContentAdapter(Context context, ArrayList<AlternatorDetail> data) {
				this.context = context;
				this.data = data;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return data.size();
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				Holder holder;
				if (convertView == null) {
					convertView = LayoutInflater.from(context).inflate(R.layout.item_text_content, null);
					holder = new Holder(convertView);
					convertView.setTag(holder);
				} else {
					holder = (Holder) convertView.getTag();
				}
				holder.text_content.setText(data.get(position).getName());
				holder.text_type.setText(data.get(position).getType());
				return convertView;
			}

			class Holder {
				TextView text_content;
				TextView text_type;

				public Holder(View v) {
					text_content = (TextView) v.findViewById(R.id.text_content);
					text_type = (TextView) v.findViewById(R.id.text_type);

				}
			}

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
			this.name = name;
		}

	}

}
