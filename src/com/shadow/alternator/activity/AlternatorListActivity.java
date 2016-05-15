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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shadow.alternator.BaseActivity;
import com.shadow.alternator.R;
import com.shadow.alternator.util.StringTool;

public class AlternatorListActivity extends BaseActivity {
	private EditText edit;
	private TextView text_hint;
	private ListView list;
	private ArrayList<Alternator> infos = new ArrayList<Alternator>();
	private AlternatorAdapter adapter;
	private String account = "";
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_list);
		account = getIntent().getExtras().getString("account"); 
		initView();
	}

	private void initView() {
		bindTitle();
		edit = (EditText) findViewById(R.id.edit);
		text_hint = (TextView) findViewById(R.id.text_hint);
		list = (ListView) findViewById(R.id.list);
		bindTitle();
		title.text_left.setText(account);
		title.text_left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		Alternator info = new Alternator();
		info.setIp("192.168.1.1");
		info.setName("成都特斯拉云网络技术有限公司");
		infos.add(info);
		infos.add(info);
		infos.add(info);
		infos.add(info);

		adapter = new AlternatorAdapter(this, infos);
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
			Intent intent = new Intent(AlternatorListActivity.this, AlternatorDetailActivity.class);
			startActivity(intent);
		}
	};

	class AlternatorAdapter extends BaseAdapter {

		Context context;
		ArrayList<Alternator> infos;

		public AlternatorAdapter(Context context, ArrayList<Alternator> infos) {
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
				convertView = LayoutInflater.from(context).inflate(R.layout.item_alternatot, null);
				holder = new Holder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}
			holder.img_icon.setImageResource(R.drawable.logo);
			holder.text_name.setText(infos.get(position).getName());
			holder.text_ip.setText(infos.get(position).getIp());
			holder.img_a1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(context, AlternatorRealtimeActivity.class);
					startActivity(intent);
				}
			});
			return convertView;
		}

		class Holder {
			 ImageView img_icon;
			 TextView text_name;
			 TextView text_ip;
			 LinearLayout llayout_action;
			 ImageView img_a1;
			 ImageView img_a2;
			 ImageView img_a3;
			


			public Holder(View v) {
				img_icon = (ImageView) v.findViewById(R.id.img_icon);
				text_name = (TextView) v.findViewById(R.id.text_name);
				text_ip = (TextView) v.findViewById(R.id.text_ip);
				llayout_action = (LinearLayout) v.findViewById(R.id.llayout_action);
				img_a1 = (ImageView) v.findViewById(R.id.img_a1);
				img_a2 = (ImageView) v.findViewById(R.id.img_a2);
				img_a3 = (ImageView) v.findViewById(R.id.img_a3);
			}

		}

	}

	class Alternator {
		private String icon, name, ip, id;

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		

	}


}
