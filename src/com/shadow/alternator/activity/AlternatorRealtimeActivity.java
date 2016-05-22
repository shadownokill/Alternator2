package com.shadow.alternator.activity;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.shadow.alternator.bean.DeviceAlarmModel;
import com.shadow.alternator.bean.DeviceBasicModel;
import com.shadow.alternator.bean.DeviceIOModel;
import com.shadow.alternator.bean.DeviceStatusModel;
import com.shadow.alternator.fragment.ControllerFragment;
import com.shadow.alternator.fragment.RealTimeElectricFragment;
import com.shadow.alternator.fragment.RealTimeWorkloadFragment;
import com.shadow.alternator.fragment.RealtimeEngineFragment;
import com.shadow.alternator.fragment.WaringsFragment;
import com.shadow.alternator.request.AlternatorCallBack;
import com.shadow.alternator.request.AlternatorRequest;
import com.shadow.alternator.util.ToastUtil;

interface GetBasicModel {
	public DeviceBasicModel getModel1();

	public DeviceAlarmModel getModel2();

	public DeviceIOModel getModel3();

	public DeviceStatusModel getModel4();
}

public class AlternatorRealtimeActivity extends BaseActivity implements GetBasicModel {

	private HorizontalScrollView hsv_titles;
	private LinearLayout llayout_titles;
	private ViewPager viewpager;
	private DetailPagerAdapter adapter;
	private String id = "";
	private DeviceBasicModel basicModel;
	private DeviceAlarmModel alarmModel;
	private DeviceIOModel ioModel;
	private DeviceStatusModel statusModel;
	private static final int REFRESH_TIME = 1000 ;
	private boolean loada = false;
	private boolean loadb = false;
	private boolean loadc = false;
	private boolean loadd = false;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		registerReceiver(broadcastReceiver, new IntentFilter(AKeys.DEVICE_REQUEST_REFRESH));
		setContentView(R.layout.activity_fragments);
		id = getIntent().getExtras().getString("id");
		initView();
		getRealTimeData();
		getWarings();
		getIO();
		getStatus();
	}

	BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			//update();
		}
	};

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		getActivity().unregisterReceiver(broadcastReceiver);
	}

	private void update() {
		getRealTimeDataSingle();
		getWaringsSingle();
		getIOSingle();
		getStatusSingle();
	}

	private void getWarings() {
		AlternatorRequest.getAlarms(id, new AlternatorCallBack() {
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
						if (isFinishing()) {
							return;
						}
						getWarings();
					}
				}, REFRESH_TIME);
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (isFinishing()) {
							return;
						}
						getWarings();
					}
				}, REFRESH_TIME);
			}
		});
	}

	private void getWaringsSingle() {
		if (loadd) {
			return;
		}

		loadd = true;
		AlternatorRequest.getAlarms(id, new AlternatorCallBack() {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);

				Intent intent = new Intent(AKeys.DEVICE_WARINGS_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				loadd = false;
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				loadd = false;
			}
		});
	}

	private void getIO() {
		AlternatorRequest.getDeviceIO(id, new AlternatorCallBack() {
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
						if (isFinishing()) {
							return;
						}
						getIO();
					}
				}, REFRESH_TIME);
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (isFinishing()) {
							return;
						}
						getIO();
					}
				}, REFRESH_TIME);
			}
		});
	}

	private void getIOSingle() {
		if (loadc) {
			return;
		}
		loadc = true;
		AlternatorRequest.getDeviceIO(id, new AlternatorCallBack() {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);

				Intent intent = new Intent(AKeys.DEVICE_IO_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				loadc = false;
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				loadc = false;
			}
		});
	}

	private void getStatus() {
		AlternatorRequest.getDeviceIO(id, new AlternatorCallBack() {
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
						if (isFinishing()) {
							return;
						}
						getStatus();
					}
				}, REFRESH_TIME);
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (isFinishing()) {
							return;
						}
						getStatus();
					}
				}, REFRESH_TIME);
			}
		});
	}

	private void getStatusSingle() {
		if (loadb) {
			return;
		}
		loadb = true;
		AlternatorRequest.getDeviceIO(id, new AlternatorCallBack() {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);

				Intent intent = new Intent(AKeys.DEVICE_STATUS_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				loadb = false;
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				loadb = false;
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
				//ToastUtil.show(AlternatorRealtimeActivity.this, "数据已更新", true);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (isFinishing()) {
							return;
						}
						getRealTimeData();
					}
				}, REFRESH_TIME);
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (isFinishing()) {
							return;
						}
						getRealTimeData();
					}
				}, REFRESH_TIME);
			}
		});
	}

	private void getRealTimeDataSingle() {
		if (loada) {
			return;
		}
		loada = true;
		AlternatorRequest.getDeviceInfo(id, new AlternatorCallBack() {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				basicModel = new Gson().fromJson(data, DeviceBasicModel.class);
				Intent intent = new Intent(AKeys.DEVICE_BASIC_INFO_LOAD_SUCCESS);
				intent.putExtra("data", data);
				sendBroadcast(intent);
				loada = false;
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				loada = false;
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
	public DeviceBasicModel getModel1() {
		// TODO Auto-generated method stub
		return basicModel;
	}

	@Override
	public DeviceAlarmModel getModel2() {
		// TODO Auto-generated method stub
		return alarmModel;
	}

	@Override
	public DeviceIOModel getModel3() {
		// TODO Auto-generated method stub
		return ioModel;
	}

	@Override
	public DeviceStatusModel getModel4() {
		// TODO Auto-generated method stub
		return statusModel;
	}

}
