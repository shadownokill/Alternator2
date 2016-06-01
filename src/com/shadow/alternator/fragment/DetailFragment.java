package com.shadow.alternator.fragment;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.shadow.alternator.R;
import com.shadow.alternator.activity.AlternatorDetailActivity;
import com.shadow.alternator.activity.AlternatorDetailActivity.AlternatorDetail;
import com.shadow.alternator.bean.DeviceModel;

/**
 * 设备详情单页
 * @author 林知礼
 *
 */
public class DetailFragment extends Fragment {

	private ListView list;
	private int page = -1;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		page = getArguments().getInt("page");
	};

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	/**
	 * 发电机
	 * @param model
	 */
	private void p0(DeviceModel model) {
		ArrayList<AlternatorDetail> data = new ArrayList<AlternatorDetail>();
		AlternatorDetail a1 = new AlternatorDetail();
		a1.setName(model.genunit_name);
		a1.setType("编号");
		data.add(a1);

		AlternatorDetail a2 = new AlternatorDetail();
		a2.setName(model.genunit_brand);
		a2.setType("品牌");
		data.add(a2);

		AlternatorDetail a3 = new AlternatorDetail();
		a3.setName(model.genunit_version);
		a3.setType("型号");
		data.add(a3);

		AlternatorDetail a4 = new AlternatorDetail();
		a4.setName(model.genunit_ratepower);
		a4.setType("额定功率");
		data.add(a4);

		AlternatorDetail a5 = new AlternatorDetail();
		a5.setName(model.genunit_sn);
		a5.setType("序列号");
		data.add(a5);

		AlternatorDetail a6 = new AlternatorDetail();
		a6.setName(model.genunit_product);
		a6.setType("生产厂家");
		data.add(a6);

		AlternatorDetail a7 = new AlternatorDetail();
		a7.setName(model.genunit_prodata);
		a7.setType("生产日期");
		data.add(a7);

		AlternatorDetail a8 = new AlternatorDetail();
		a8.setName("");
		a8.setType("保修截止日期");
		data.add(a8);

		ContentAdapter adapter = new ContentAdapter(getActivity(), data);
		list.setAdapter(adapter);
	}

	/**
	 * 发动机
	 * @param model
	 */
	private void p1(DeviceModel model) {

		ArrayList<AlternatorDetail> data = new ArrayList<AlternatorDetail>();

		AlternatorDetail a2 = new AlternatorDetail();
		a2.setName(model.engine_brand);
		a2.setType("品牌");
		data.add(a2);

		AlternatorDetail a3 = new AlternatorDetail();
		a3.setName(model.engine_version);
		a3.setType("型号");
		data.add(a3);

		AlternatorDetail a4 = new AlternatorDetail();
		a4.setName(model.engine_ratepower);
		a4.setType("额定功率");
		data.add(a4);

		AlternatorDetail a5 = new AlternatorDetail();
		a5.setName(model.engine_sn);
		a5.setType("序列号");
		data.add(a5);

		AlternatorDetail a6 = new AlternatorDetail();
		a6.setName(model.engine_product);
		a6.setType("生产厂家");
		data.add(a6);

		AlternatorDetail a7 = new AlternatorDetail();
		a7.setName(model.engine_prodata);
		a7.setType("生产日期");
		data.add(a7);

		ContentAdapter adapter = new ContentAdapter(getActivity(), data);
		list.setAdapter(adapter);

	}

	private void p2(DeviceModel model) {
		ArrayList<AlternatorDetail> data = new ArrayList<AlternatorDetail>();

		AlternatorDetail a2 = new AlternatorDetail();
		a2.setName(model.gen_brand);
		a2.setType("品牌");
		data.add(a2);

		AlternatorDetail a3 = new AlternatorDetail();
		a3.setName(model.gen_version);
		a3.setType("型号");
		data.add(a3);

		AlternatorDetail a4 = new AlternatorDetail();
		a4.setName(model.gen_ratepower);
		a4.setType("额定功率");
		data.add(a4);

		AlternatorDetail a5 = new AlternatorDetail();
		a5.setName(model.gen_sn);
		a5.setType("序列号");
		data.add(a5);

		AlternatorDetail a6 = new AlternatorDetail();
		a6.setName(model.gen_product);
		a6.setType("生产厂家");
		data.add(a6);

		AlternatorDetail a7 = new AlternatorDetail();
		a7.setName(model.gen_prodata);
		a7.setType("生产日期");
		data.add(a7);

		ContentAdapter adapter = new ContentAdapter(getActivity(), data);
		list.setAdapter(adapter);

	}

	private void p3(DeviceModel model) {
		ArrayList<AlternatorDetail> data = new ArrayList<AlternatorDetail>();

		AlternatorDetail a2 = new AlternatorDetail();
		a2.setName(model.ctrl_brand);
		a2.setType("品牌");
		data.add(a2);

		AlternatorDetail a3 = new AlternatorDetail();
		a3.setName(model.ctrl_version);
		a3.setType("型号");
		data.add(a3);

		AlternatorDetail a5 = new AlternatorDetail();
		a5.setName(model.ctrl_sn);
		a5.setType("序列号");
		data.add(a5);

		AlternatorDetail a6 = new AlternatorDetail();
		a6.setName(model.ctrl_product);
		a6.setType("生产厂家");
		data.add(a6);

		AlternatorDetail a7 = new AlternatorDetail();
		a7.setName(model.ctrl_prodata);
		a7.setType("生产日期");
		data.add(a7);

		ContentAdapter adapter = new ContentAdapter(getActivity(), data);
		list.setAdapter(adapter);

	}

	public void setData(DeviceModel model) {
		if (model == null) {
			return;
		}
		switch (page) {
		case 0:
			p0(model);
			break;
		case 1:
			p1(model);
			break;
		case 2:
			p2(model);
			break;
		case 3:
			p3(model);
			break;

		}

	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_list, null);
		// v.setBackgroundColor(getResources().getColor(R.color.deep_blue));
		list = (ListView) v.findViewById(R.id.list);
		setData(((AlternatorDetailActivity) getActivity()).getModel());
		return v;
	}

	class ContentAdapter extends BaseAdapter {
		Context context;
		ArrayList<AlternatorDetail> data;

		public ContentAdapter(Context context, ArrayList<AlternatorDetail> data) {
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
			Holder holder;
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(R.layout.item_text_content, null);
				holder = new Holder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}
			holder.text_content.setText(data.get(position).getName());
			holder.text_type.setText(data.get(position).getType());
			return convertView;
		}

		class Holder {
			TextView text_content;
			TextView text_type;

			public Holder(View v) {
				text_content = (TextView) v.findViewById(R.id.text_content);
				text_type = (TextView) v.findViewById(R.id.text_type);

			}
		}

	}

}
