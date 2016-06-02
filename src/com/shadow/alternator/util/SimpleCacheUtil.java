package com.shadow.alternator.util;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * 缓存
 * @author 保存一些基础信息
 *
 */
public class SimpleCacheUtil {

	private static SharedPreferences get(Context context) {
		return context.getSharedPreferences("SimpleCache", Context.MODE_PRIVATE);
	}

	/**
	 * 设置保存密码
	 * @param context
	 * @param save
	 */
	public static void setSavePassword(Context context, boolean save) {
		get(context).edit().putBoolean("savePassword", save).commit();
	}

	/**
	 * 是否保存密码
	 * @param context
	 * @return
	 */
	public static boolean isSavePassword(Context context) {
		return get(context).getBoolean("savePassword", false);
	}

	/**
	 * 保存登录信息
	 * @param context
	 * @param account
	 * @param password
	 */
	public static void savePassword(Context context, String account, String password) {
		get(context).edit().putString("account", account).commit();
		get(context).edit().putString("password", password).commit();
	}

	/**
	 * 获取登录信息 
	 * @param context
	 * @return
	 */
	public static String[] getPassword(Context context) {
		String password = get(context).getString("password", "");
		String account = get(context).getString("account", "");
		return new String[] { account, password };
	}
}
