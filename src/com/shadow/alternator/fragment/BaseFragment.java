package com.shadow.alternator.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.shadow.alternator.R;
import com.shadow.alternator.util.ToastUtil;

public class BaseFragment extends Fragment {

	public Title title;

	public void showToast(String text, boolean state) {
		ToastUtil.show(getActivity(), text, state);
	}

	public void bindTitle(View v) {
		title = new Title(v);
	}

	class Title {
		TextView text_left, text_title, text_right;

		public Title(View v) {
			text_left = (TextView) v.findViewById(R.id.text_left);
			text_title = (TextView) v.findViewById(R.id.text_title);
			text_right = (TextView) v.findViewById(R.id.text_right);

		}
	}
}
