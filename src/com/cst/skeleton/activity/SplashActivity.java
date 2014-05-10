package com.cst.skeleton.activity;

import android.os.Bundle;

import com.cst.ble.R;
import com.cst.skeleton.activity.base.BaseActivity;
import com.cst.stormdroid.utils.intent.IntentHelper;

/**
 * splash
 * @author MonsterStorm
 * 
 */
public class SplashActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(IntentHelper.newIntent(SplashActivity.this, MainActivity.class));
			}
		}, 3000);
	}
}
