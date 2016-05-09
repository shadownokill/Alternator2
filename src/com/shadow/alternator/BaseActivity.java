package com.shadow.alternator;

import com.shadow.alternator.util.ToastUtil;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
	}

	public Activity getActivity() {
		return this;
	}
	
	public void showToast(String text, boolean state){
		ToastUtil.show(getActivity(), text, state);
	}
}
