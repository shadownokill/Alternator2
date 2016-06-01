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
import com.shadow.alternator.bean.DeviceBasicModel;

/**
 * 实时信息详细数据
 * 发电机
 * @author 林知礼
 *
 */
public class RealTimeDetail1Fragment extends Fragment {
	private TextView text_value1;
	private TextView text_value2;
	private TextView text_value3;
	private TextView text_value4;
	private TextView text_value5;
	private TextView text_value6;
	private TextView text_value7;
	private TextView text_value8;
	private TextView text_value9;
	private TextView text_value10;
	private TextView text_value11;
	private TextView text_value12;
	private TextView text_value13;
	private TextView text_value14;
	private TextView text_value15;
	private TextView text_value16;
	private TextView text_value17;
	private TextView text_value18;
	private RelativeLayout rlayout;
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

	private void updateData(DeviceBasicModel basicModel) {
		text_value1.setText(basicModel.DES_SPEED+"");
		text_value2.setText(basicModel.DES_WATER_TEMP_Format+"");
		text_value3.setText(basicModel.DES_LUB_PREESURE_Format+"");
		text_value4.setText(basicModel.DES_FUEL_LEVEL_Format+"");
		text_value5.setText(basicModel.DES_BATT_VOLT_Format+"");
		text_value6.setText(basicModel.DES_CHARGE_VOLT_Format+"");
		text_value7.setText(basicModel.OIL_DES_HOUR+":"+basicModel.OIL_DES_MIN);
		text_value8.setText(basicModel.OIL_CBT+"");
		text_value9.setText("N/A");
		text_value10.setText(basicModel.DES_LUB_TEMP+"");
		text_value11.setText("N/A");
		text_value12.setText("N/A");
		text_value13.setText("N/A");
		text_value14.setText("N/A");
		text_value15.setText("N/A");
		text_value16.setText("N/A");
		text_value17.setText("N/A");
		text_value18.setText("N/A");
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
		View v = inflater.inflate(R.layout.fragment_realtime_detail1, null);
		text_value1 = (TextView) v.findViewById(R.id.text_value1);
		text_value2 = (TextView) v.findViewById(R.id.text_value2);
		text_value3 = (TextView) v.findViewById(R.id.text_value3);
		text_value4 = (TextView) v.findViewById(R.id.text_value4);
		text_value5 = (TextView) v.findViewById(R.id.text_value5);
		text_value6 = (TextView) v.findViewById(R.id.text_value6);
		text_value7 = (TextView) v.findViewById(R.id.text_value7);
		text_value8 = (TextView) v.findViewById(R.id.text_value8);
		text_value9 = (TextView) v.findViewById(R.id.text_value9);
		text_value10 = (TextView) v.findViewById(R.id.text_value10);
		text_value11 = (TextView) v.findViewById(R.id.text_value11);
		text_value12 = (TextView) v.findViewById(R.id.text_value12);
		text_value13 = (TextView) v.findViewById(R.id.text_value13);
		text_value14 = (TextView) v.findViewById(R.id.text_value14);
		text_value15 = (TextView) v.findViewById(R.id.text_value15);
		text_value16 = (TextView) v.findViewById(R.id.text_value16);
		text_value17 = (TextView) v.findViewById(R.id.text_value17);
		text_value18 = (TextView) v.findViewById(R.id.text_value18);
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
