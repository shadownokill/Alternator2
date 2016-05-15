package com.shadow.alternator.fragment;

import com.shadow.alternator.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class WaringsFragment extends Fragment {

	private ListView list;
	private TextView text_empty;

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
