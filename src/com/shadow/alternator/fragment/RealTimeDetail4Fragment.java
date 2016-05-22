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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.bean.DeviceIOModel;

public class RealTimeDetail4Fragment extends Fragment {
	private RelativeLayout rlayout;
	private TextView text_detail;
	private TextView text_oil;
	private TextView text_start;
	private TextView text_1;
	private TextView text_2;
	private TextView text_3;
	private TextView text_4;
	private TextView text_5;
	private TextView text_6;

	BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String s = intent.getExtras().getString("data");
			DeviceIOModel basicModel = new Gson().fromJson(s, DeviceIOModel.class);
			updateData(basicModel);
		}
	};

	private void updateData(DeviceIOModel basicModel) {
		if (basicModel.in_custom1 == 1) {
			text_1.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_1.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom2 == 1) {
			text_2.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_2.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom3 == 1) {
			text_3.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_3.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom4 == 1) {
			text_4.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_4.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom5 == 1) {
			text_5.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_5.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom6 == 1) {
			text_6.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_6.setBackgroundResource(R.drawable.bg_circle_off);
		}

		if (basicModel.out_oil == 1) {
			text_oil.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_oil.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.des_maint == 1) {
			text_start.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_start.setBackgroundResource(R.drawable.bg_circle_off);
		}
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().registerReceiver(broadcastReceiver, new IntentFilter(AKeys.DEVICE_IO_LOAD_SUCCESS));
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
		View v = inflater.inflate(R.layout.fragment_realtime_detail4, null);

		text_oil = (TextView) v.findViewById(R.id.text_oil);
		text_start = (TextView) v.findViewById(R.id.text_start);
		text_1 = (TextView) v.findViewById(R.id.text_1);
		text_2 = (TextView) v.findViewById(R.id.text_2);
		text_3 = (TextView) v.findViewById(R.id.text_3);
		text_4 = (TextView) v.findViewById(R.id.text_4);
		text_5 = (TextView) v.findViewById(R.id.text_5);
		text_6 = (TextView) v.findViewById(R.id.text_6);
		rlayout = (RelativeLayout) v.findViewById(R.id.rlayout);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		text_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().finish();
			}
		});
		Intent intent = new Intent(AKeys.DEVICE_REQUEST_REFRESH);
		getActivity().sendBroadcast(intent);
		return v;
	}

}
