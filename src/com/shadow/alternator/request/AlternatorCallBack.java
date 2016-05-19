package com.shadow.alternator.request;

import java.io.IOException;
import java.net.UnknownHostException;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Handler;
import android.util.Log;

import com.shadow.alternator.util.WindowLoading;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * 网络事件回调
 * 
 * @author L
 * 
 */
public class AlternatorCallBack implements Callback {
	public static final int ERROR_DATA = 1, ERROR_NET = 2, ERROR_UNKNOW = 3;

	public void onSuccess(String data) throws Exception {
		if (loading != null) {
			loading.dismiss();
		}
	};

	public String getData() {
		if (data != null) {
			return data.toString();
		}
		if (dataArray != null) {
			return dataArray.toString();
		}
		return "";
	}

	public void onDataError(int code, String msg) {
	};

	public void onUnknowError() {
	};

	public void onNetError(int code) {
	};

	public void onProgress(int progress) {
	}

	public boolean onCancel() {
		return false;
	}

	public void onError(int type, int code, String msg) {
		if (loading != null) {
			loading.dismiss();
		}
		switch (type) {
		case ERROR_DATA:
			onDataError(code, msg);
			break;
		case ERROR_NET:
			onNetError(code);
			break;
		case ERROR_UNKNOW:
			onUnknowError();
			break;

		default:
			break;
		}
	};

	private Call call;
	private JSONObject data = null;
	private JSONArray dataArray = null;
	private String[] tag = null;
	private WindowLoading loading;

	public AlternatorCallBack(WindowLoading loading) {
		this.loading = loading;
	}

	public WindowLoading getWindowLoading() {
		return loading;
	}

	public void setWindowLoading(WindowLoading loading) {
		this.loading = loading;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}

	public AlternatorCallBack() {
	}

	public AlternatorCallBack(String[] tag) {
		this.tag = tag;
	}

	public WindowLoading getLoading() {
		return loading;
	}

	public void setCall(Call call) {
		this.call = call;
	}

	public void cancelRequest() {
		if (call != null) {
			call.cancel();
		}
	}

	public String[] getTag() {
		return tag;
	}

	private Handler handler = new Handler();

	private void onSuccess(JSONObject jsonObject) throws Exception {
		onSuccess(jsonObject.toString());
	}

	private void onSuccess(JSONArray jsonArray) throws Exception {
		onSuccess(jsonArray.toString());
	}

	@Override
	public void onFailure(Request arg0, final IOException arg1) {
		// TODO Auto-generated method stub
		// 请求被取消
		if (call != null && call.isCanceled()) {
			return;
		}
		handler.post(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (arg1 instanceof UnknownHostException) {
					onError(ERROR_NET, 0, "网络情况不好，请检查网络设置");
					return;
				}
				onError(ERROR_UNKNOW, 0, null);
			}
		});
	}

	@Override
	public void onResponse(final Response arg0) {
		// TODO Auto-generated method stub
		// 请求被取消
		if (call != null && call.isCanceled()) {
			return;
		}
		// 网络访问成功
		final int netCode = arg0.code();
		final String netMsg = arg0.message();
		if (arg0.isSuccessful()) {
			String jsonStr = null;
			try {
				jsonStr = arg0.body().string();
				Log.e("DATA",  jsonStr);
				data = null;
				data = new JSONObject(jsonStr);
			} catch (Exception e) {
				// TODO Auto-generated catch block

				try {
					dataArray = null;
					dataArray = new JSONArray(jsonStr);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					handler.post(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							onError(ERROR_UNKNOW, 0, null);
						}
					});

					return;
				}

			}
			handler.post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (data != null) {
						try {
							onSuccess(data);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							onError(ERROR_UNKNOW, 0, null);
						}
					}
					if (dataArray != null) {
						try {
							onSuccess(dataArray);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							onError(ERROR_UNKNOW, 0, null);
						}
					}
					if (data == null && dataArray == null) {
						try {
							onSuccess("");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							onError(ERROR_UNKNOW, 0, null);
						}
					}

				}
			});
		} else {
			handler.post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					// if (FamiApplication.DEBUG) {
					// ToastUtil.show("<DEBUG MODE> Error code :" + netCode +
					// " Error Message : " + netMsg);
					// }
					onError(ERROR_NET, netCode, "网络情况不好，请检查网络设置");
				}
			});

		}
	}
}