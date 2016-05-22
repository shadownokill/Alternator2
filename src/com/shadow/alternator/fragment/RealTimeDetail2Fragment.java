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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.bean.DeviceBasicModel;

public class RealTimeDetail2Fragment extends Fragment {
	private TextView text_1;
	private TextView text_2;
	private TextView text_3;
	private TextView text_4;
	private TextView text_5;
	private TextView text_6;
	private TextView text_7;
	private TextView text_8;
	private TextView text_9;
	private TextView text_10;
	private TextView text_11;
	private TextView text_12;
	private TextView text_13;
	private TextView text_14;
	private TextView text_15;
	private TextView text_16;
	private TextView text_17;
	private TextView text_18;
	private TextView text_19;
	private TextView text_20;
	private TextView text_21;
	private TextView text_22;
	private TextView text_23;
	private TextView text_24;
	private TextView text_25;
	private TextView text_26;
	private RelativeLayout rlayout;
	private TextView text_detail;
	private LinearLayout llayout,llayout_t1;
	private int page = 0;
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
		if (page == 1) {

			text_1.setText(basicModel.OIL_VOLT_AB + "");
			text_2.setText(basicModel.OIL_VOLT_BC + "");
			text_3.setText(basicModel.OIL_VOLT_CA + "");
			text_4.setText(basicModel.OIL_VOLT_A + "");
			text_5.setText(basicModel.OIL_VOLT_B + "");
			text_6.setText(basicModel.OIL_VOLT_C + "");
			text_7.setText(basicModel.GEN_FREQ_Format + "");
			text_8.setText(basicModel.OIL_CURRENT_A_Format + "");
			text_9.setText(basicModel.OIL_CURRENT_B_Format + "");
			text_10.setText(basicModel.OIL_CURRENT_C_Format + "");
			text_11.setText(basicModel.OIL_ACTIVEPOWER_A_Format + "");
			text_12.setText(basicModel.OIL_ACTIVEPOWER_B_Format + "");
			text_13.setText(basicModel.OIL_ACTIVEPOWER_C_Format + "");
			text_14.setText(basicModel.OIL_REACTIVEPOWER_A+ "");
			text_15.setText(basicModel.OIL_REACTIVEPOWER_B + "");
			text_16.setText(basicModel.OIL_REACTIVEPOWER_C + "");
			text_17.setText(basicModel.OIL_APPARENTPOWER_A_Format + "");
			text_18.setText(basicModel.OIL_APPARENTPOWER_B_Format + "");
			text_19.setText(basicModel.OIL_APPARENTPOWER_C_Format + "");
			text_20.setText(basicModel.OIL_COS_A_Format + "");
			text_21.setText(basicModel.OIL_COS_B_Format + "");
			text_22.setText(basicModel.OIL_COS_C_Format + "");

			text_23.setText(basicModel.OIL_ACTIVEPOWER_TOTAL_Format + "");
			text_24.setText(basicModel.OIL_REACTIVEPOWER_TOTAL_Format + "");
			text_25.setText(basicModel.OIL_APPARENTPOWER_TOTAL_Format + "");
			text_26.setText(basicModel.OIL_COS_Format + "");
		} else {
			text_1.setText(basicModel.MAIN_VOLT_AB + "");
			text_2.setText(basicModel.MAIN_VOLT_BC + "");
			text_3.setText(basicModel.MAIN_VOLT_CA + "");
			text_4.setText(basicModel.MAIN_VOLT_A + "");
			text_5.setText(basicModel.MAIN_VOLT_B + "");
			text_6.setText(basicModel.MAIN_VOLT_C + "");
			text_7.setText(basicModel.MAIN_FREQ_Format + "");
			
			text_8.setText("");
			text_9.setText("");
			text_10.setText("");
			
			text_11.setText("");
			text_12.setText("");
			text_13.setText("");
			
			text_14.setText("");
			text_15.setText("");
			text_16.setText("");
			
			text_17.setText("");
			text_18.setText("");
			text_19.setText("");
			
			text_20.setText("");
			text_21.setText("");
			text_22.setText("");

			text_23.setText("");
			text_24.setText("");
			text_25.setText("");
			text_26.setText("");

		}
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		page = getArguments().getInt("page");
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
		View v = inflater.inflate(R.layout.fragment_realtime_detail2, null);
		text_1 = (TextView) v.findViewById(R.id.text_1);
		text_2 = (TextView) v.findViewById(R.id.text_2);
		text_3 = (TextView) v.findViewById(R.id.text_3);
		text_4 = (TextView) v.findViewById(R.id.text_4);
		text_5 = (TextView) v.findViewById(R.id.text_5);
		text_6 = (TextView) v.findViewById(R.id.text_6);
		text_7 = (TextView) v.findViewById(R.id.text_7);
		text_8 = (TextView) v.findViewById(R.id.text_8);
		text_9 = (TextView) v.findViewById(R.id.text_9);
		text_10 = (TextView) v.findViewById(R.id.text_10);
		text_11 = (TextView) v.findViewById(R.id.text_11);
		text_12 = (TextView) v.findViewById(R.id.text_12);
		text_13 = (TextView) v.findViewById(R.id.text_13);
		text_14 = (TextView) v.findViewById(R.id.text_14);
		text_15 = (TextView) v.findViewById(R.id.text_15);
		text_16 = (TextView) v.findViewById(R.id.text_16);
		text_17 = (TextView) v.findViewById(R.id.text_17);
		text_18 = (TextView) v.findViewById(R.id.text_18);
		text_19 = (TextView) v.findViewById(R.id.text_19);
		text_20 = (TextView) v.findViewById(R.id.text_20);
		text_21 = (TextView) v.findViewById(R.id.text_21);
		text_22 = (TextView) v.findViewById(R.id.text_22);
		text_23 = (TextView) v.findViewById(R.id.text_23);
		text_24 = (TextView) v.findViewById(R.id.text_24);
		text_25 = (TextView) v.findViewById(R.id.text_25);
		text_26 = (TextView) v.findViewById(R.id.text_26);
		rlayout = (RelativeLayout) v.findViewById(R.id.rlayout);
		llayout = (LinearLayout) v.findViewById(R.id.llayout);
		llayout_t1 = (LinearLayout) v.findViewById(R.id.llayout_t1);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		text_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().finish();
			}
		});
		if (page != 1) {
			llayout.setVisibility(View.GONE);
			llayout_t1.setVisibility(View.GONE);
		}
		Intent intent = new Intent(AKeys.DEVICE_REQUEST_REFRESH);
		getActivity().sendBroadcast(intent);
		return v;
	}

}
