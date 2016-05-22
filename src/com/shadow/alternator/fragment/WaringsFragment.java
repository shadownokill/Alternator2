package com.shadow.alternator.fragment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.bean.DeviceAlarmModel;

public class WaringsFragment extends Fragment {

	private ListView list;
	private TextView text_empty;
	private ArrayList<String> data = new ArrayList<String>();
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
		try {
			data.clear();
			getObjectValue(basicModel);
			if (data.size() == 0) {
				text_empty.setVisibility(View.VISIBLE);
				list.setVisibility(View.GONE);
			} else {
				text_empty.setVisibility(View.GONE);
				list.setVisibility(View.VISIBLE);
			}
			if (adapter != null) {
				adapter.notifyDataSetChanged();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getObjectValue(Object object) throws Exception {
		if (object != null) {// if (object!=null ) ----begin
			// 拿到该类
			Class<?> clz = object.getClass();
			// 获取实体类的所有属性，返回Field数组
			Field[] fields = clz.getDeclaredFields();
			for (Field field : fields) {// --for() begin
				System.out.println(field.getGenericType());// 打印该类的所有属性类型

				String key = field.getName();
				String value = field.get(object) + "";
				Log.e("", key + ":" + value);
				if ("1".equals(value)) {
					data.add(DeviceAlarmModel.getAlarmName(key));
				}
			}// for() --end

		}// if (object!=null ) ----end
	}

	// 把一个字符串的第一个字母大写、效率是最高的、
	// private static String getMethodName(String fildeName) throws Exception {
	// byte[] items = fildeName.getBytes();
	// items[0] = (byte) ((char) items[0] - 'a' + 'A');
	// return new String(items);
	// }

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
		adapter = new WaringsAdapter(getActivity(), data);
		list.setAdapter(adapter);
		Intent intent = new Intent(AKeys.DEVICE_REQUEST_REFRESH);
		getActivity().sendBroadcast(intent);
		return v;
	}

	private WaringsAdapter adapter;

	class WaringsAdapter extends BaseAdapter {
		Context context;
		ArrayList<String> data;

		public WaringsAdapter(Context context, ArrayList<String> data) {
			this.context = context;
			this.data = data;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder;
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(R.layout.item_waring, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.text.setText(data.get(position));
			return convertView;
		}

		class ViewHolder {
			public TextView text;

			public ViewHolder(View v) {
				text = (TextView) v.findViewById(R.id.text);
			}
		}
	}

}
