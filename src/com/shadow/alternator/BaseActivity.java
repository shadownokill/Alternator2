package com.shadow.alternator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.shadow.alternator.util.ToastUtil;

public class BaseActivity extends FragmentActivity {
	public Title title;
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
	}
	
	public void bindTitle(){
		title = new Title();
	}

	public Activity getActivity() {
		return this;
	}
	
	public void showToast(String text, boolean state){
		ToastUtil.show(getActivity(), text, state);
	}
	
	class Title {
		TextView text_left,text_title, text_right;
		public Title(){
			text_left = (TextView) findViewById(R.id.text_left);
			text_title = (TextView) findViewById(R.id.text_title);
			text_right = (TextView) findViewById(R.id.text_right);

		}
	}
}
