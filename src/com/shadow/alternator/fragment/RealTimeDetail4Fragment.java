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
	private TextView text_i1;
	private TextView text_o1;
	private TextView text_i0;
	private TextView text_o0;
	private TextView text_i2;
	private TextView text_o2;
	private TextView text_i3;
	private TextView text_o3;
	private TextView text_i4;
	private TextView text_o4;
	private TextView text_i5;
//	private TextView text_o5;
	private TextView text_os;
	private TextView text_i6;
	private TextView text_o6;
	private TextView text_i7;
	private TextView text_o7;
	private TextView text_i8;
	private TextView text_o8;
	private RelativeLayout rlayout;
	private TextView text_detail;
	


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
		if (basicModel.in_alarm_stopemerg == 1) {
			text_i0.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i0.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.out_oil == 1) {
			text_o0.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_o0.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.des_maint == 1) {
			text_os.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_os.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom1 == 1) {
			text_i1.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i1.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom2 == 1) {
			text_i2.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i2.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom3 == 1) {
			text_i3.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i3.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom4 == 1) {
			text_i4.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i4.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom5 == 1) {
			text_i5.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i5.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom6 == 1) {
			text_i6.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i6.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom7 == 1) {
			text_i7.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i7.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.in_custom8 == 1) {
			text_i8.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			text_i8.setBackgroundResource(R.drawable.bg_circle_off);
		}

		
		
		if (basicModel.out_custom1 == 1) {
			text_o1.setBackgroundResource(R.drawable.bg_circle_on);
		}else {
			text_o1.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.out_custom2 == 1) {
			text_o2.setBackgroundResource(R.drawable.bg_circle_on);
		}else {
			text_o2.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.out_custom3 == 1) {
			text_o3.setBackgroundResource(R.drawable.bg_circle_on);
		}else {
			text_o3.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.out_custom4 == 1) {
			text_o4.setBackgroundResource(R.drawable.bg_circle_on);
		}else {
			text_o4.setBackgroundResource(R.drawable.bg_circle_off);
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

		text_i1 = (TextView) v.findViewById(R.id.text_i1);
		text_o1 = (TextView) v.findViewById(R.id.text_o1);
		text_i0 = (TextView) v.findViewById(R.id.text_i0);
		text_o0 = (TextView) v.findViewById(R.id.text_o0);
		text_i2 = (TextView) v.findViewById(R.id.text_i2);
		text_o2 = (TextView) v.findViewById(R.id.text_o2);
		text_i3 = (TextView) v.findViewById(R.id.text_i3);
		text_o3 = (TextView) v.findViewById(R.id.text_o3);
		text_i4 = (TextView) v.findViewById(R.id.text_i4);
		text_o4 = (TextView) v.findViewById(R.id.text_o4);
		text_i5 = (TextView) v.findViewById(R.id.text_i5);
		//text_o5 = (TextView) v.findViewById(R.id.text_o5);
		text_os = (TextView) v.findViewById(R.id.text_os);
		text_i6 = (TextView) v.findViewById(R.id.text_i6);
		text_o6 = (TextView) v.findViewById(R.id.text_o6);
		text_i7 = (TextView) v.findViewById(R.id.text_i7);
		text_o7 = (TextView) v.findViewById(R.id.text_o7);
		text_i8 = (TextView) v.findViewById(R.id.text_i8);
		text_o8 = (TextView) v.findViewById(R.id.text_o8);
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
