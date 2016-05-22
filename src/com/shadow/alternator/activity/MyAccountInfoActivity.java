package com.shadow.alternator.activity;

import java.util.ArrayList;

import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.bean.CompanyModel;
import com.shadow.alternator.bean.UserModel;
import com.shadow.alternator.request.AlternatorCallBack;
import com.shadow.alternator.request.AlternatorRequest;
import com.shadow.alternator.util.SimpleCacheUtil;
import com.shadow.alternator.util.StringTool;
import com.shadow.alternator.util.ToastUtil;
import com.shadow.alternator.util.WindowLoading;
import com.squareup.picasso.Picasso;

public class MyAccountInfoActivity extends BaseActivity {
	private EditText edit;
	private TextView text_hint;
	private ListView list;
	private ArrayList<CompanyModel> infos = new ArrayList<CompanyModel>();
	private AccountInfoAdapter adapter;
	private UserModel userModel;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_list);
		userModel = new Gson().fromJson(getIntent().getExtras().getString("data"), UserModel.class);

		initView();
	}
	
	boolean first = true;
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus && first) {
			first = false;
			getCompanyInfo();
		}
	}

	private void getCompanyInfo() {
		AlternatorCallBack callBack = new AlternatorCallBack() {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				CompanyModel companyModel = new Gson().fromJson(data, CompanyModel.class);
				title.text_title.setText(companyModel.company_name);
				infos.add(companyModel);
				adapter.notifyDataSetChanged();
			}

			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				ToastUtil.show(getActivity(), StringTool.isEmpty(msg) ? "获取公司信息失败" : msg, false);
			}
		};
		callBack.setWindowLoading(new WindowLoading(list));
		
		AlternatorRequest.getCompanyInfo(userModel.user_company_id+"", callBack);
	}

	private void initView() {
		bindTitle();
		edit = (EditText) findViewById(R.id.edit);
		text_hint = (TextView) findViewById(R.id.text_hint);
		list = (ListView) findViewById(R.id.list);
		bindTitle();
		title.text_left.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.menu), null, null, null);
		title.text_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastUtil.show(getActivity(), "退出登录", true);
				SimpleCacheUtil.setSavePassword(getActivity(), false);
				SimpleCacheUtil.savePassword(getActivity(), "", "");
				startActivity(new Intent(getActivity(), LoginActivity.class));
				finish();
			}
		});

		adapter = new AccountInfoAdapter(this, infos);
		list.setAdapter(adapter);
		list.setOnItemClickListener(onItemClickListener);

		edit.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				text_hint.setVisibility(hasFocus ? View.GONE : View.VISIBLE);
			}
		});
		edit.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				text_hint.setVisibility(!StringTool.isEmpty(s.toString()) ? View.GONE : View.VISIBLE);
			}
		});
	}

	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(MyAccountInfoActivity.this, AlternatorListActivity.class);
			intent.putExtra("account", infos.get(position).company_name);
			intent.putExtra("cid", infos.get(position).company_id+"");
			startActivity(intent);
		}
	};

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		moveTaskToBack(true);
	}
	class AccountInfoAdapter extends BaseAdapter {

		Context context;
		ArrayList<CompanyModel> infos;

		public AccountInfoAdapter(Context context, ArrayList<CompanyModel> infos) {
			this.context = context;
			this.infos = infos;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return infos.size();
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
				convertView = LayoutInflater.from(context).inflate(R.layout.item_account_info, null);
				holder = new Holder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}
			Picasso.with(context).load(infos.get(position).company_logo).placeholder(R.drawable.logo).into(holder.img_icon);
			holder.text_title.setText(infos.get(position).company_name);
			holder.text_content.setText(infos.get(position).company_address);
			holder.text_arrow.setText("");//infos.get(position).company_id+""
			return convertView;
		}

		class Holder {
			ImageView img_icon;
			TextView text_title;
			TextView text_content;
			TextView text_arrow;

			public Holder(View v) {
				img_icon = (ImageView) v.findViewById(R.id.img_icon);
				text_title = (TextView) v.findViewById(R.id.text_title);
				text_content = (TextView) v.findViewById(R.id.text_content);
				text_arrow = (TextView) v.findViewById(R.id.text_arrow);
			}

		}

	}

	class AccountInfo {
		private String icon, title, address, num;

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getNum() {
			return num;
		}

		public void setNum(String num) {
			this.num = num;
		}

	}
}
