package com.shadow.alternator.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shadow.alternator.R;
import com.shadow.alternator.activity.AlternatorRealTimeDetailActivity;

public class ControllerFragment extends Fragment {


	TextView text_detail;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_controller, null);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		text_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), AlternatorRealTimeDetailActivity.class));
			}
		});
		return v;
	}

}
