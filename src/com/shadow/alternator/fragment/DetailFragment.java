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
import com.shadow.alternator.activity.AlternatorDetailActivity.AlternatorDetail;

public class DetailFragment extends Fragment {


	private ListView list;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_list, null);
		v.setBackgroundColor(getResources().getColor(R.color.deep_blue));
		list = (ListView) v.findViewById(R.id.list);
		ArrayList<AlternatorDetail> data = new ArrayList<AlternatorDetail>();
		for (int i = 0; i < 10; i++) {
			AlternatorDetail detail = new AlternatorDetail();
			detail.setName("TestName " + i);
			detail.setType("TestType " + i);
			data.add(detail);
		}
		ContentAdapter adapter = new ContentAdapter(getActivity(), data);
		list.setAdapter(adapter);
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
