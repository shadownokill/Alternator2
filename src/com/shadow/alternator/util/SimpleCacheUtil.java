package com.shadow.alternator.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SimpleCacheUtil {

	private static SharedPreferences get(Context context) {
		return context.getSharedPreferences("SimpleCache", Context.MODE_PRIVATE);
	}

	public static void setSavePassword(Context context, boolean save) {
		get(context).edit().putBoolean("savePassword", save).commit();
	}

	public static boolean isSavePassword(Context context) {
		return get(context).getBoolean("savePassword", false);
	}

	public static void savePassword(Context context, String account, String password) {
		get(context).edit().putString("account", account).commit();
		get(context).edit().putString("password", password).commit();
	}

	public static String[] getPassword(Context context) {
		String password = get(context).getString("password", "");
		String account = get(context).getString("account", "");
		return new String[] { account, password };
	}
}
