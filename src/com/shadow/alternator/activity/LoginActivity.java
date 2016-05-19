package com.shadow.alternator.activity;

import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.R.id;
import com.shadow.alternator.R.layout;
import com.shadow.alternator.bean.UserModel;
import com.shadow.alternator.request.AlternatorCallBack;
import com.shadow.alternator.request.AlternatorRequest;
import com.shadow.alternator.util.SimpleCacheUtil;
import com.shadow.alternator.util.StringTool;
import com.shadow.alternator.util.ToastUtil;
import com.shadow.alternator.util.WindowLoading;

public class LoginActivity extends BaseActivity {
	private ImageView img_logo;
	private EditText edit_account;
	private EditText edit_pwd;
	private TextView text_check;
	private TextView text_login;
	private TextView text_;
	private TextView text_forget;

	private boolean check = false;

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

		text_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (check()) {
					// login
					UserModel model = new UserModel();
					model.user_name = edit_account.getText().toString();
					model.user_pwd = edit_pwd.getText().toString();
					login(model);
				}
			}
		});
		String[] logininfo = SimpleCacheUtil.getPassword(this);
		check = SimpleCacheUtil.isSavePassword(this);
		if (check) {
			text_check.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.check_on), null, null, null);
			edit_account.setText(logininfo[0]);
			edit_pwd.setText(logininfo[1]);
		} else {
			if (!StringTool.isEmpty(logininfo[0])) {
				edit_account.setText(logininfo[0]);
			}
			text_check.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.check_off), null, null, null);
		}

		text_check.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (SimpleCacheUtil.isSavePassword(getActivity())) {
					SimpleCacheUtil.setSavePassword(getActivity(), false);
					text_check.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.check_off), null, null, null);
				} else {
					SimpleCacheUtil.setSavePassword(getActivity(), true);
					text_check.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.check_on), null, null, null);
				}
			}
		});
	}

	boolean first = true;

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus && first && SimpleCacheUtil.isSavePassword(this)) {
			first = false;
			String[] logininfo = SimpleCacheUtil.getPassword(this);
			UserModel model = new UserModel();
			model.user_name = logininfo[0];
			model.user_pwd = logininfo[1];
			login(model);
		}
	}

	public void login(UserModel model) {
		AlternatorCallBack callBack = new AlternatorCallBack(new WindowLoading(text_login)) {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				JSONObject jo = new JSONObject(data);
				jo = jo.optJSONObject("UserInfo");
				if (jo == null) {
					ToastUtil.show(getActivity(), "登录失败\n请检查账号密码是否输入有误", false);
					return;
				}
				// UserModel m = new Gson().fromJson(jo.toString(),
				// UserModel.class);
				if (SimpleCacheUtil.isSavePassword(getActivity())) {
					SimpleCacheUtil.savePassword(getActivity(), getTag()[0], getTag()[1]);
				}
				startActivity(new Intent(LoginActivity.this, MyAccountInfoActivity.class).putExtra("data", jo.toString()));
				finish();
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				ToastUtil.show(getActivity(), StringTool.isEmpty(msg) ? "登录失败" : msg, false);
			}
		};
		callBack.setTag(new String[] { model.user_name, model.user_pwd });
		AlternatorRequest.login(model, callBack);
	}

	private boolean check() {
		if (StringTool.isEmpty(edit_account)) {
			ToastUtil.show(getActivity(), "请输入账号", false);
			return false;
		}
		if (StringTool.isEmpty(edit_pwd)) {
			ToastUtil.show(getActivity(), "请输入密码", false);
			return false;
		}

		return true;
	}
}
