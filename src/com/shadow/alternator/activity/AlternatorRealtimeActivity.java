package com.shadow.alternator.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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
import com.shadow.alternator.AKeys;
import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.bean.DeviceBasicModel;
import com.shadow.alternator.fragment.ControllerFragment;
import com.shadow.alternator.fragment.RealTimeElectricFragment;
import com.shadow.alternator.fragment.RealTimeWorkloadFragment;
import com.shadow.alternator.fragment.RealtimeEngineFragment;
import com.shadow.alternator.fragment.WaringsFragment;
import com.shadow.alternator.request.AlternatorCallBack;
import com.shadow.alternator.request.AlternatorRequest;

interface GetBasicModel {
	public DeviceBasicModel getModel();
}

public class AlternatorRealtimeActivity extends BaseActivity implements GetBasicModel {

	private HorizontalScrollView hsv_titles;
	private LinearLayout llayout_titles;
	private ViewPager viewpager;
	private DetailPagerAdapter adapter;
	private String id = "";
	private DeviceBasicModel basicModel;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_fragments);
		id = getIntent().getExtras().getString("id");
		initView();
		getRealTimeData();
		getWarings();
		getIO();
		getStatus();
	}
	
	private void getWarings(){
		AlternatorRequest.getAlarms(id, new AlternatorCallBack(){
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				
				Intent intent = new Intent(AKeys.DEVICE_WARINGS_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						getWarings();
					}
				}, 1000);
			}
			
			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						getWarings();
					}
				}, 1000);
			}
		});
	}
	private void getIO(){
		AlternatorRequest.getDeviceIO(id, new AlternatorCallBack(){
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				
				Intent intent = new Intent(AKeys.DEVICE_IO_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						getIO();
					}
				}, 1000);
			}
			
			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						getIO();
					}
				}, 1000);
			}
		});
	}
	private void getStatus(){
		AlternatorRequest.getDeviceIO(id, new AlternatorCallBack(){
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				
				Intent intent = new Intent(AKeys.DEVICE_STATUS_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						getStatus();
					}
				}, 1000);
			}
			
			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						getStatus();
					}
				}, 1000);
			}
		});
	}

	private void getRealTimeData() {
		AlternatorRequest.getDeviceInfo(id, new AlternatorCallBack() {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				basicModel = new Gson().fromJson(data, DeviceBasicModel.class);
				Intent intent = new Intent(AKeys.DEVICE_BASIC_INFO_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						getRealTimeData();
					}
				}, 1000);
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						getRealTimeData();
					}
				}, 1000);
			}
		});
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
			fragments.add(new RealtimeEngineFragment());
			fragments.add(new RealTimeWorkloadFragment());
			RealTimeElectricFragment f1 = new RealTimeElectricFragment();
			Bundle bundle = new Bundle();
			bundle.putInt("page", 3);
			f1.setArguments(bundle);
			fragments.add(f1);
			RealTimeElectricFragment f2 = new RealTimeElectricFragment();
			Bundle bundle2 = new Bundle();
			bundle2.putInt("page", 4);
			f2.setArguments(bundle2);
			fragments.add(f2);
			fragments.add(new ControllerFragment());
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

	@Override
	public DeviceBasicModel getModel() {
		// TODO Auto-generated method stub
		return basicModel;
	}

}
