package com.shadow.alternator;

import android.app.Application;
import android.content.Context;

public class AlternatorApplication extends Application {
	public static final boolean DEBUG = true;

	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(getApplicationContext());

		
	}

}
