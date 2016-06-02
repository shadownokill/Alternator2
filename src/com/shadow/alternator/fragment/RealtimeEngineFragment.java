package com.shadow.alternator.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.activity.AlternatorRealTimeDetailActivity;
import com.shadow.alternator.bean.DeviceBasicModel;
import com.shadow.alternator.util.Dp;
import com.shadow.alternator.util.StringTool;

public class RealtimeEngineFragment extends Fragment {
	private ImageView img_face;
	private ImageView img_pointer;
	private RelativeLayout rlayout_1;
	private RelativeLayout rlayout_2;
	private RelativeLayout rlayout_3;
	private RelativeLayout rlayout_4;
	private RelativeLayout rlayout_5;
	private TextView text_detail;

	BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String s = intent.getExtras().getString("data");
			DeviceBasicModel basicModel = new Gson().fromJson(s, DeviceBasicModel.class);
			updateData(basicModel);
		}
	};

	/**
	 * 更新页面数据
	 * @param basicModel
	 */
	private void updateData(DeviceBasicModel basicModel) {
		int speed = basicModel.DES_SPEED;
		//最大转速
		float max = 2400f;
		//最大可用角度
		float degree = 240f;
		//起始角度
		int degreeStart = -120;
		//每一转速对应角度
		float speedperdegree = max / degree;
		//旋转角度
		int d = (int) (speed / speedperdegree);
		img_pointer.setRotation(d + degreeStart);
		setData(rlayout_1, (basicModel.DES_WATER_TEMP == 32768?"+++":(basicModel.DES_WATER_TEMP+""))+"℃", R.drawable.icon_shuiwen, (int)(basicModel.DES_WATER_TEMP/120.0f) , RelativeLayout.ALIGN_PARENT_BOTTOM);
		setData(rlayout_2, basicModel.DES_FUEL_LEVEL_Format + "%", R.drawable.icon_youwei, basicModel.DES_FUEL_LEVEL, RelativeLayout.ALIGN_PARENT_BOTTOM);
		setData(rlayout_3, basicModel.DES_LUB_PREESURE_Format+"kPa", R.drawable.icon_youya, (int)(StringTool.str2double(basicModel.DES_LUB_PREESURE_Format, 0.0)/1000f), RelativeLayout.ALIGN_PARENT_BOTTOM);//\n("+basicModel.DES_LUB_PREESURE+"Bar)
		setData(rlayout_4, basicModel.DES_BATT_VOLT_Format+"V", R.drawable.icon_dianchi, (int)((StringTool.str2double(basicModel.DES_BATT_VOLT_Format, 0.0)/60f)*100), RelativeLayout.ALIGN_PARENT_LEFT);
		setData(rlayout_5, basicModel.DES_CHARGE_VOLT_Format+"V", R.drawable.icon_chongdian, (int)((StringTool.str2double(basicModel.DES_CHARGE_VOLT_Format, 0.0)/60f)*100), RelativeLayout.ALIGN_PARENT_LEFT);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().registerReceiver(broadcastReceiver, new IntentFilter(AKeys.DEVICE_BASIC_INFO_LOAD_SUCCESS));
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		getActivity().unregisterReceiver(broadcastReceiver);
	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_engine, null);
		v.setBackgroundColor(getActivity().getResources().getColor(R.color.deep_blue));
		img_face = (ImageView) v.findViewById(R.id.img_face);
		img_pointer = (ImageView) v.findViewById(R.id.img_pointer);
		rlayout_1 = (RelativeLayout) v.findViewById(R.id.rlayout_1);
		rlayout_2 = (RelativeLayout) v.findViewById(R.id.rlayout_2);
		rlayout_3 = (RelativeLayout) v.findViewById(R.id.rlayout_3);
		rlayout_4 = (RelativeLayout) v.findViewById(R.id.rlayout_4);
		rlayout_5 = (RelativeLayout) v.findViewById(R.id.rlayout_5);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		img_pointer.setRotation(-120);
		setData(rlayout_1, "----", R.drawable.icon_shuiwen, 0, RelativeLayout.ALIGN_PARENT_BOTTOM);
		setData(rlayout_2, "####", R.drawable.icon_youwei, 0, RelativeLayout.ALIGN_PARENT_BOTTOM);
		setData(rlayout_3, "0kPa", R.drawable.icon_youya, 0, RelativeLayout.ALIGN_PARENT_BOTTOM);
		setData(rlayout_4, "V", R.drawable.icon_dianchi, 0, RelativeLayout.ALIGN_PARENT_LEFT);
		setData(rlayout_5, "V", R.drawable.icon_chongdian, 0, RelativeLayout.ALIGN_PARENT_LEFT);
		text_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), AlternatorRealTimeDetailActivity.class));
			}
		});
		Intent intent = new Intent(AKeys.DEVICE_REQUEST_REFRESH);
		getActivity().sendBroadcast(intent);
		return v;
	}

	private void setData(View v, String u, int resId, int per, int rule) {
		TextView unit = (TextView) v.findViewById(R.id.text_unit);
		TextView icon = (TextView) v.findViewById(R.id.text_icon);
		TextView text_per = (TextView) v.findViewById(R.id.text_per);
		unit.setText(u);
		if (resId != -1) {
			icon.setBackgroundResource(resId);
		}
		if (per > -1 && per < 101) {
			RelativeLayout.LayoutParams params;
			if (rule == RelativeLayout.ALIGN_PARENT_BOTTOM) {
				params = new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, Dp.dip2px(getActivity(), per));
			} else {
				params = new LayoutParams(Dp.dip2px(getActivity(), per), RelativeLayout.LayoutParams.MATCH_PARENT);
			}
			params.addRule(rule);
			text_per.setLayoutParams(params);
		}

	}
}
