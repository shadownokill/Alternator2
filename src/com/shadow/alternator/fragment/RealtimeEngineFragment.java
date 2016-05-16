package com.shadow.alternator.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shadow.alternator.R;
import com.shadow.alternator.activity.AlternatorRealTimeDetailActivity;

public class RealtimeEngineFragment extends Fragment {
	private ImageView img_face;
	private ImageView img_pointer;
	private RelativeLayout rlayout_1;
	private RelativeLayout rlayout_2;
	private RelativeLayout rlayout_3;
	private RelativeLayout rlayout_4;
	private RelativeLayout rlayout_5;
	private TextView text_detail;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_engine, null);
		v.setBackgroundColor(getActivity().getResources().getColor(R.color.deep_blue));
		img_face = (ImageView) v.findViewById(R.id.img_face);
		img_pointer = (ImageView) v.findViewById(R.id.img_pointer);
		rlayout_1 = (RelativeLayout) v.findViewById(R.id.rlayout_1);
		rlayout_2 = (RelativeLayout) v.findViewById(R.id.rlayout_2);
		rlayout_3 = (RelativeLayout) v.findViewById(R.id.rlayout_3);
		rlayout_4 = (RelativeLayout) v.findViewById(R.id.rlayout_4);
		rlayout_5 = (RelativeLayout) v.findViewById(R.id.rlayout_5);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		setData(rlayout_1, "----", R.drawable.search, 50);
		setData(rlayout_2, "####", R.drawable.search, 50);
		setData(rlayout_3, "0kPa\n(0.0Bar)", R.drawable.search, 50);
		setData(rlayout_4, "V", R.drawable.search, 50);
		setData(rlayout_5, "V", R.drawable.search, 50);
		text_detail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), AlternatorRealTimeDetailActivity.class));
			}
		});
		return v;
	}
	
	private void setData(View v,String u, int resId, int per){
		TextView unit = (TextView) v.findViewById(R.id.text_unit);
		TextView icon = (TextView) v.findViewById(R.id.text_icon);
		unit.setText(u);
		icon.setBackgroundResource(resId);
		
	}
}
