package com.shadow.alternator.util;

import android.content.Context;

public class Dp {
	public static int dip2px(Context context, double dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
