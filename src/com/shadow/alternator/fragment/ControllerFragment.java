package com.shadow.alternator.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shadow.alternator.AKeys;
import com.shadow.alternator.R;
import com.shadow.alternator.activity.AlternatorRealTimeDetailActivity;
import com.shadow.alternator.bean.DeviceCommandModel;
import com.shadow.alternator.bean.DeviceStatusModel;
import com.shadow.alternator.request.AlternatorCallBack;
import com.shadow.alternator.request.AlternatorRequest;
import com.shadow.alternator.util.StringTool;
import com.shadow.alternator.util.ToastUtil;
import com.shadow.alternator.util.WindowLoading;

public class ControllerFragment extends Fragment {

	private ImageView img_l1;
	private ImageView img_l3;
	private ImageView img_l5;
	private ImageView img_l2;
	private ImageView img_l4;
	private ImageView img_c1;
	private ImageView img_c2;
	private ImageView img_c3;
	private ImageView img_c4;
	private ImageView img_c5;
	private ImageView img_c6;
	private RelativeLayout rlayout;
	private TextView text_detail;

	BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String s = intent.getExtras().getString("data");
			DeviceStatusModel basicModel = new Gson().fromJson(s, DeviceStatusModel.class);
			statusModel = basicModel;
			// ---------------------------------------------------//

			// basicModel.led_stop = 1;
			// basicModel.led_comprehensive_format = 2;
			// basicModel.led_normal_gen = 1;

			// ---------------------------------------------------//
			updateData(basicModel);
		}
	};
	private DeviceStatusModel statusModel;

	private void updateData(DeviceStatusModel basicModel) {
		if (basicModel.led_stop == 1) {
			img_c1.setImageResource(R.drawable.icon_c1_on);
		} else {
			img_c1.setImageResource(R.drawable.icon_c1);
		}
		if (basicModel.led_manual == 1) {
			img_c2.setImageResource(R.drawable.icon_c2_on);
		} else {
			img_c2.setImageResource(R.drawable.icon_c2);
		}
		if (basicModel.led_auto == 1) {
			img_c3.setImageResource(R.drawable.icon_c3_on);
		} else {
			img_c3.setImageResource(R.drawable.icon_c3);
		}
		if (basicModel.led_test == 1) {
			img_c4.setImageResource(R.drawable.icon_c4_on);
		} else {
			img_c4.setImageResource(R.drawable.icon_c4);
		}
		if (basicModel.led_comprehensive_format == 1) {
			img_c5.setImageResource(R.drawable.icon_c5_on);
		} else if (basicModel.led_comprehensive_format == 0) {
			img_c5.setImageResource(R.drawable.icon_c5);
		} else {

		}

		if (basicModel.led_normal_gen == 1) {
			img_l1.setBackgroundResource(R.drawable.bg_circle_on);
		} else if (basicModel.led_normal_gen == 0) {
			img_l1.setBackgroundResource(R.drawable.bg_circle_off);
		} else {

		}
		if (basicModel.led_close_units == 1) {
			img_l2.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			img_l2.setBackgroundResource(R.drawable.bg_circle_off);
		}
		// if (basicModel.led_close_main == 1) {
		// img_l3.setBackgroundResource(R.drawable.bg_circle_on);
		// }else{
		// img_l3.setBackgroundResource(R.drawable.bg_circle_off);
		// }
		if (basicModel.led_close_main == 1) {
			img_l4.setBackgroundResource(R.drawable.bg_circle_on);
		} else {
			img_l4.setBackgroundResource(R.drawable.bg_circle_off);
		}
		if (basicModel.led_normal_main == 1) {
			img_l5.setBackgroundResource(R.drawable.bg_circle_on);
		} else if (basicModel.led_normal_main == 0) {
			img_l5.setBackgroundResource(R.drawable.bg_circle_off);
		} else {

		}

		shake(basicModel);
	}

	private boolean l1 = false, l2 = false, l3 = false;
	private boolean r1 = false, r2 = false, r3 = false;

	private void shake(final DeviceStatusModel basicModel) {
		if (basicModel.led_comprehensive_format == 1) {
			img_c5.setImageResource(R.drawable.icon_c5_on);
		} else if (basicModel.led_comprehensive_format == 0) {
			img_c5.setImageResource(R.drawable.icon_c5);
		} else {
			if (r1) {
				return;
			}
			r1 = true;
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (basicModel.led_comprehensive_format == 2) {

						if (l1) {
							img_c5.setImageResource(R.drawable.icon_c5_on);
							l1 = false;
						} else {
							img_c5.setImageResource(R.drawable.icon_c5);
							l1 = true;
						}
					}
					new Handler().postDelayed(this, 200);
				}
			}, 200);
		}

		if (basicModel.led_normal_gen == 1) {
			img_l1.setBackgroundResource(R.drawable.bg_circle_on);
		} else if (basicModel.led_normal_gen == 0) {
			img_l1.setBackgroundResource(R.drawable.bg_circle_off);
		} else {
			if (r2) {
				return;
			}
			r2 = true;
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (basicModel.led_normal_gen == 2) {

						if (l2) {
							img_l1.setBackgroundResource(R.drawable.bg_circle_on);
							l2 = false;
						} else {
							img_l1.setBackgroundResource(R.drawable.bg_circle_off);
							l2 = true;
						}
					}
					new Handler().postDelayed(this, 200);
				}
			}, 200);
		}

		if (basicModel.led_normal_main == 1) {
			img_l5.setBackgroundResource(R.drawable.bg_circle_on);
		} else if (basicModel.led_normal_main == 0) {
			img_l5.setBackgroundResource(R.drawable.bg_circle_off);
		} else {
			if (r3) {
				return;
			}
			r3 = true;
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (basicModel.led_normal_main == 2) {

						if (l3) {
							img_l5.setBackgroundResource(R.drawable.bg_circle_on);
							l3 = false;
						} else {
							img_l5.setBackgroundResource(R.drawable.bg_circle_off);
							l3 = true;
						}
					}
					new Handler().postDelayed(this, 200);
				}
			}, 200);
		}
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().registerReceiver(broadcastReceiver, new IntentFilter(AKeys.DEVICE_STATUS_LOAD_SUCCESS));
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		getActivity().unregisterReceiver(broadcastReceiver);
	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_controller, null);
		v.setBackgroundColor(Color.parseColor("#1b1b1b"));
		img_l1 = (ImageView) v.findViewById(R.id.img_l1);
		img_l3 = (ImageView) v.findViewById(R.id.img_l3);
		img_l5 = (ImageView) v.findViewById(R.id.img_l5);
		img_l2 = (ImageView) v.findViewById(R.id.img_l2);
		img_l4 = (ImageView) v.findViewById(R.id.img_l4);
		img_c1 = (ImageView) v.findViewById(R.id.img_c1);
		img_c2 = (ImageView) v.findViewById(R.id.img_c2);
		img_c3 = (ImageView) v.findViewById(R.id.img_c3);
		img_c4 = (ImageView) v.findViewById(R.id.img_c4);
		img_c5 = (ImageView) v.findViewById(R.id.img_c5);
		img_c6 = (ImageView) v.findViewById(R.id.img_c6);
		rlayout = (RelativeLayout) v.findViewById(R.id.rlayout);
		text_detail = (TextView) v.findViewById(R.id.text_detail);
		text_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), AlternatorRealTimeDetailActivity.class));
			}
		});
		Intent intent = new Intent(AKeys.DEVICE_REQUEST_REFRESH);
		getActivity().sendBroadcast(intent);
		// 0停机/复位; 1手动; 2自动; 3带载试机; 4启动
		img_c1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (statusModel==null) {
					return;
				}
				DeviceCommandModel commandModel = new DeviceCommandModel();
				commandModel.cmd_id = 100;
				commandModel.code = 0;
				commandModel.dev_id = statusModel.dev_id;
				// 0成功; 1设备不在线; 2命令错误; 3设备否定响应
				// -1设备无响应
				command(commandModel);
			}
		});
		img_c2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (statusModel==null) {
					return;
				}
				DeviceCommandModel commandModel = new DeviceCommandModel();
				commandModel.cmd_id = 100;
				commandModel.code = 1;
				commandModel.dev_id = statusModel.dev_id;
				// 0成功; 1设备不在线; 2命令错误; 3设备否定响应
				// -1设备无响应
				command(commandModel);
			}
		});
		img_c3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (statusModel==null) {
					return;
				}
				DeviceCommandModel commandModel = new DeviceCommandModel();
				commandModel.cmd_id = 100;
				commandModel.code = 2;
				commandModel.dev_id = statusModel.dev_id;
				// 0成功; 1设备不在线; 2命令错误; 3设备否定响应
				// -1设备无响应
				command(commandModel);
			}
		});
		img_c4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (statusModel==null) {
					return;
				}
				DeviceCommandModel commandModel = new DeviceCommandModel();
				commandModel.cmd_id = 100;
				commandModel.code = 3;
				commandModel.dev_id = statusModel.dev_id;
				// 0成功; 1设备不在线; 2命令错误; 3设备否定响应
				// -1设备无响应
				command(commandModel);
			}
		});
		img_c5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
		img_c6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (statusModel==null) {
					return;
				}
				DeviceCommandModel commandModel = new DeviceCommandModel();
				commandModel.cmd_id = 100;
				commandModel.code = 4;
				commandModel.dev_id = statusModel.dev_id;
				// 0成功; 1设备不在线; 2命令错误; 3设备否定响应
				// -1设备无响应
				command(commandModel);
			}
		});
		return v;
	}

	private void command(DeviceCommandModel commandModel) {
		AlternatorRequest.command(new Gson().toJson(new Gson().toJson(commandModel)), new AlternatorCallBack(new WindowLoading(text_detail)) {
			@Override
			public void onSuccess(String data) throws Exception {
				// TODO Auto-generated method stub
				super.onSuccess(data);
				if (!StringTool.isEmpty(data)) {
					if ("0".equals(data)) {
						ToastUtil.show(getActivity(), "操作成功", true);
					}
					if ("1".equals(data)) {
						ToastUtil.show(getActivity(), "设备不在线", true);
					}
					if ("2".equals(data)) {
						ToastUtil.show(getActivity(), "命令错误", true);
					}
					if ("3".equals(data)) {
						ToastUtil.show(getActivity(), "设备否定响应", true);
					}
					if ("-1".equals(data)) {
						ToastUtil.show(getActivity(), "设备无响应", true);
					}
				}
			}
			
			@Override
			public void onError(int type, int code, String msg) {
				// TODO Auto-generated method stub
				super.onError(type, code, msg);
				//ToastUtil.show(getActivity(), "操作失败", true);
			}
		});

	}
}
