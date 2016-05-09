package com.shadow.alternator.fragment;

import android.support.v4.app.Fragment;

import com.shadow.alternator.util.ToastUtil;

public class BaseFragment extends Fragment {
	public void showToast(String text, boolean state) {
		ToastUtil.show(getActivity(), text, state);
	}
}
