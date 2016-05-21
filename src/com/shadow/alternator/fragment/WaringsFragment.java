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
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.bean.DeviceAlarmModel;

public class WaringsFragment extends Fragment {

	private ListView list;
	private TextView text_empty;
	BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String s = intent.getExtras().getString("data");
			DeviceAlarmModel basicModel = new Gson().fromJson(s, DeviceAlarmModel.class);
			updateData(basicModel);
		}
	};

	private void updateData(DeviceAlarmModel basicModel) {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().registerReceiver(broadcastReceiver, new IntentFilter(AKeys.DEVICE_WARINGS_LOAD_SUCCESS));
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
		View v = inflater.inflate(R.layout.fragment_list, null);
		v.setBackgroundColor(getActivity().getResources().getColor(R.color.deep_blue));
		list = (ListView) v.findViewById(R.id.list);
		text_empty = (TextView) v.findViewById(R.id.text_empty);
		text_empty.setText("一切正常哦！");
		text_empty.setVisibility(View.VISIBLE);
		return v;
	}

}
