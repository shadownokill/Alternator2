package com.shadow.alternator;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MyAccountInfoActivity extends BaseActivity {
	private EditText edit;
	private TextView text_hint;
	private ListView list;
	private ArrayList<AccountInfo> infos = new ArrayList<MyAccountInfoActivity.AccountInfo>();

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_account_info);
		initView();
	}

	private void initView() {
		bindTitle();
		edit = (EditText) findViewById(R.id.edit);
		text_hint = (TextView) findViewById(R.id.text_hint);
		list = (ListView) findViewById(R.id.list);


	}

	class AccountInfoAdapter extends BaseAdapter {

		Context context;
		ArrayList<AccountInfo> infos;
		public AccountInfoAdapter(Context context, ArrayList<AccountInfo> infos){
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
			return null;
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
