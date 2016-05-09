/**
 * 
 */
package com.shadow.alternator.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shadow.alternator.R;

public class ToastUtil {

	private static Toast toast;
	private static TextView tv;
	private static Drawable ok, error;

	private static void initIcons(Context context) {
		if (ok == null) {
			ok = context.getResources().getDrawable(R.drawable.ic_launcher);
		}
		if (error == null) {
			error = context.getResources().getDrawable(R.drawable.ic_launcher);
		}
	}

	public static void show(Context context, String text, boolean state) {
		initIcons(context);
		if (toast == null) {
			View v = LayoutInflater.from(context).inflate(
					R.layout.common_toast, null);
			tv = (TextView) v.findViewById(R.id.toast_text);
			tv.setText(text);
			toast = new Toast(context);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.setView(v);
		} else {
			tv.setText(text);
		}
		tv.setCompoundDrawablesWithIntrinsicBounds(null, state ? ok : error,
				null, null);
		toast.show();
	}

	public static void init(Context context) {
		if (toast == null) {
			View v = LayoutInflater.from(context).inflate(
					R.layout.common_toast, null);
			tv = (TextView) v.findViewById(R.id.toast_text);
			toast = new Toast(context);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.setView(v);
		}
	}
}
