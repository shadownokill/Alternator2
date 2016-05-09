package com.shadow.alternator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.shadow.alternator.util.StringTool;
import com.shadow.alternator.util.ToastUtil;

public class LoginActivity extends BaseActivity {
	private ImageView img_logo;
	private EditText edit_account;
	private EditText edit_pwd;
	private TextView text_check;
	private TextView text_login;
	private TextView text_;
	private TextView text_forget;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void initView() {
		img_logo = (ImageView) findViewById(R.id.img_logo);
		edit_account = (EditText) findViewById(R.id.edit_account);
		edit_pwd = (EditText) findViewById(R.id.edit_pwd);
		text_check = (TextView) findViewById(R.id.text_check);
		text_login = (TextView) findViewById(R.id.text_login);
		text_ = (TextView) findViewById(R.id.text_);
		text_forget = (TextView) findViewById(R.id.text_forget);
		
		text_login.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (check()) {
					//login 
				}
			}
		});
	}

	private boolean check() {
		if (StringTool.isEmpty(edit_account)) {
			ToastUtil.show(getActivity(), "«Î ‰»Î’À∫≈", false);
			return false;
		}
		if (StringTool.isEmpty(edit_pwd)) {
			ToastUtil.show(getActivity(), "«Î ‰»Î√‹¬Î", false);
			return false;
		}

		return true;
	}
}
