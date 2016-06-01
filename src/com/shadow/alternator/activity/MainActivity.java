package com.shadow.alternator.activity;

import com.shadow.alternator.R;
import com.shadow.alternator.R.id;
import com.shadow.alternator.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
/**
 * 开屏页
 * @author 林知礼
 *
 */
public class MainActivity extends Activity {

	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img = (ImageView) findViewById(R.id.img);
	}

	
	private boolean in = false;

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus && !in) {
			in = true;
			count2Start();
		}
	}

	private void count2Start() {
		new CountDownTimer(3000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, LoginActivity.class));
				finish();
			}
		}.start();
	}
}
