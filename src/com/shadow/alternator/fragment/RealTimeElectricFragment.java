package com.shadow.alternator.fragment;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.activity.AlternatorRealTimeDetailActivity;
import com.shadow.alternator.bean.DeviceBasicModel;
import com.shadow.alternator.util.Dp;

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
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
/**
 * 图表
 * 发电/市电
 * @author 林知礼
 *
 */
public class RealTimeElectricFragment extends Fragment {
	private ImageView img_face;
	private ImageView img_pointer;
	private RelativeLayout rlayout_1;
	private RelativeLayout rlayout_2;
	private RelativeLayout rlayout_3;
	private RelativeLayout rlayout_4;
	private RelativeLayout rlayout_5;
	private TextView text_detail;
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
		if (page == 3) {
			int a = basicModel.OIL_VOLT_A;
			int b = basicModel.OIL_VOLT_B;
			int c = basicModel.OIL_VOLT_C;
			setData(rlayout_1, a+"V", "L1-2", (int) ((a/60f)*100));
			setData(rlayout_2, b+"V", "L2-3", (int) ((b/60f)*100));
			setData(rlayout_3, c+"V", "L3-1", (int) ((c/60f)*100));
			setData(rlayout_4, "F(频率)", "Hz", "" + basicModel.GEN_FREQ_Format);
		}else{
			int a = basicModel.MAIN_VOLT_A;
			int b = basicModel.MAIN_VOLT_B;
			int c = basicModel.MAIN_VOLT_C;
			setData(rlayout_1, a+"V", "L1-2", (int) ((a/60f)*100));
			setData(rlayout_2, b+"V", "L2-3", (int) ((b/60f)*100));
			setData(rlayout_3, c+"V", "L3-1", (int) ((c/60f)*100));
			setData(rlayout_4, "F(频率)", "Hz", "" + basicModel.MAIN_FREQ_Format);
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
		View v = inflater.inflate(R.layout.fragment_realtime_electric, null);
		v.setBackgroundColor(getActivity().getResources().getColor(R.color.deep_blue));
		img_face = (ImageView) v.findViewById(R.id.img_face);
		img_pointer = (ImageView) v.findViewById(R.id.img_pointer);
		rlayout_1 = (RelativeLayout) v.findViewById(R.id.rlayout_1);
		rlayout_2 = (RelativeLayout) v.findViewById(R.id.rlayout_2);
		rlayout_3 = (RelativeLayout) v.findViewById(R.id.rlayout_3);
		rlayout_4 = (RelativeLayout) v.findViewById(R.id.rlayout_4);
		rlayout_5 = (RelativeLayout) v.findViewById(R.id.rlayout_5);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		setData(rlayout_1, "0.0V", "L1-2", 0);
		setData(rlayout_2, "0.0V", "L2-3", 0);
		setData(rlayout_3, "0.0V", "L3-1", 0);
		setData(rlayout_4, "F(频率)", "Hz", "0.0");
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

	private void setData(View v, String u, String un, int per) {
		TextView unit = (TextView) v.findViewById(R.id.text_unit);
		TextView icon = (TextView) v.findViewById(R.id.text_icon);
		TextView text_per = (TextView) v.findViewById(R.id.text_per);
		unit.setText(u);
		icon.setText(un);

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
