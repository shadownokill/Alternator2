package com.shadow.alternator.fragment;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.activity.AlternatorRealTimeDetailActivity;
import com.shadow.alternator.bean.DeviceBasicModel;
import com.shadow.alternator.util.Dp;
import com.shadow.alternator.util.StringTool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class RealTimeWorkloadFragment extends Fragment {
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
		// 有功功率
		double speed = StringTool.str2double(basicModel.OIL_ACTIVEPOWER_TOTAL_Format, 0.0);
		float max = 60f;
		float degree = 190f;
		int degreeStart = -95;
		float speedperdegree = max / degree;
		int d = (int) (speed / speedperdegree);
		if (d + degreeStart > 170) {
			d = 265;
		}
		img_pointer.setRotation(d + degreeStart);

		setData(rlayout_1, basicModel.OIL_ACTIVEPOWER_A_Format + "kW", -1, (int) ((StringTool.str2double(basicModel.OIL_ACTIVEPOWER_A_Format, 0.0) / 60f) * 100));
		setData(rlayout_2, basicModel.OIL_ACTIVEPOWER_B_Format + "kW", -1, (int) ((StringTool.str2double(basicModel.OIL_ACTIVEPOWER_B_Format, 0.0) / 60f)) * 100);
		setData(rlayout_3, basicModel.OIL_ACTIVEPOWER_C_Format + "kW", -1, (int) ((StringTool.str2double(basicModel.OIL_ACTIVEPOWER_C_Format, 0.0) / 60f)) * 100);
		setData(rlayout_4, "PF(功率因素)", "", basicModel.OIL_COS_Format + "");
		setData(rlayout_5, "S(视在功率)", "", basicModel.OIL_APPARENTPOWER_TOTAL_Format + "");
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
		View v = inflater.inflate(R.layout.fragment_realtime_workload, null);
		v.setBackgroundColor(getActivity().getResources().getColor(R.color.deep_blue));
		img_face = (ImageView) v.findViewById(R.id.img_face);
		img_pointer = (ImageView) v.findViewById(R.id.img_pointer);
		rlayout_1 = (RelativeLayout) v.findViewById(R.id.rlayout_1);
		rlayout_2 = (RelativeLayout) v.findViewById(R.id.rlayout_2);
		rlayout_3 = (RelativeLayout) v.findViewById(R.id.rlayout_3);
		rlayout_4 = (RelativeLayout) v.findViewById(R.id.rlayout_4);
		rlayout_5 = (RelativeLayout) v.findViewById(R.id.rlayout_5);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		setData(rlayout_1, "0.0kW", -1, 0);
		setData(rlayout_2, "0.0kW", -1, 0);
		setData(rlayout_3, "0.0kW", -1, 0);
		setData(rlayout_4, "PF(功率因素)", "", "----");
		setData(rlayout_5, "S(视在功率)", "", "----");
		text_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), AlternatorRealTimeDetailActivity.class));
			}
		});
		img_pointer.setRotation(-95);
		Intent intent = new Intent(AKeys.DEVICE_REQUEST_REFRESH);
		getActivity().sendBroadcast(intent);
		return v;
	}

	private void setData(View v, String u, int resId, int per) {
		TextView unit = (TextView) v.findViewById(R.id.text_unit);
		TextView icon = (TextView) v.findViewById(R.id.text_icon);
		TextView text_per = (TextView) v.findViewById(R.id.text_per);
		unit.setText(u);
		if (resId != -1) {
			icon.setBackgroundResource(resId);
		}
		if (per > -1 && per < 101) {
			RelativeLayout.LayoutParams params = new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, Dp.dip2px(getActivity(), per));
			params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			text_per.setLayoutParams(params);
		}

	}

	private void setData(View v, String discri, String u, String value) {
		TextView unit = (TextView) v.findViewById(R.id.text_unit);
		TextView icon = (TextView) v.findViewById(R.id.text_icon);
		TextView text_value = (TextView) v.findViewById(R.id.text_value);
		unit.setText(u);
		icon.setText(discri);
		text_value.setText(value);

	}

}
