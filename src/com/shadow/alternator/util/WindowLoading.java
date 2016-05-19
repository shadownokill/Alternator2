package com.shadow.alternator.util;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.shadow.alternator.R;

/**
 * loading
 * 
 * @author L
 * 
 */
public class WindowLoading {
	private PopupWindow popupWindow;
	private View parent, view;
	private String text = "";

	public WindowLoading(View parent) {
		this.parent = parent;
		if (parent == null || parent.getContext() == null) {
			return;
		}
		init();
	}

	public WindowLoading(View parent, String text) {
		this.parent = parent;
		if (parent == null || parent.getContext() == null) {
			return;
		}
		this.text = text;
		init();
	}

	private void init() {
		view = LayoutInflater.from(parent.getContext()).inflate(R.layout.window_loading, null);
		TextView textview = (TextView) view.findViewById(R.id.text);
		if (StringTool.isEmpty(text)) {
			textview.setVisibility(View.GONE);
		} else {
			textview.setText(text);
		}
		popupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
	}

	public void show() {
		if (popupWindow == null || parent == null || parent.getContext() == null) {
			return;
		}
		popupWindow.showAtLocation(parent, Gravity.CENTER, 0, 0);
	}

	private Handler handler = new Handler();

	public void dismiss() {
		popupWindow.dismiss();
	}
}
