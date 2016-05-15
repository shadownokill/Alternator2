package com.shadow.alternator.activity;

import java.util.ArrayList;

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

import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.util.StringTool;
import com.shadow.alternator.util.ToastUtil;

public class MyAccountInfoActivity extends BaseActivity {
	private EditText edit;
	private TextView text_hint;
	private ListView list;
	private ArrayList<AccountInfo> infos = new ArrayList<MyAccountInfoActivity.AccountInfo>();
	private AccountInfoAdapter adapter;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_list);
		initView();
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
				ToastUtil.show(getActivity(), "Menu", true);
			}
		});
		title.text_title.setText("特斯拉云");
		AccountInfo info = new AccountInfo();
		info.setAddress("成都市三环路东二段龙潭总部经济城成致路6号多元总部7-1-1");
		info.setNum("12");
		info.setTitle("成都特斯拉云网络技术有限公司");
		infos.add(info);

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
			intent.putExtra("account", infos.get(position).getTitle());
			startActivity(intent);
		}
	};

	class AccountInfoAdapter extends BaseAdapter {

		Context context;
		ArrayList<AccountInfo> infos;

		public AccountInfoAdapter(Context context, ArrayList<AccountInfo> infos) {
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
			holder.img_icon.setImageResource(R.drawable.logo);
			holder.text_title.setText(infos.get(position).getTitle());
			holder.text_content.setText(infos.get(position).getAddress());
			holder.text_arrow.setText(infos.get(position).getNum());
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
