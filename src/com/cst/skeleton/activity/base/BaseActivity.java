package com.cst.skeleton.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cst.skeleton.app.MyApplication;

public class BaseActivity extends Activity {
	// default handler
	protected Handler mHandler;
	protected MyApplication mApp;

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		initBeforeAll();
		initViews();
		initActionBar();
		initData();
		bindActions();
	}
	
	/**
	 * init before all
	 */
	private void initBeforeAll(){
		mApp = (MyApplication) MyApplication.getInstance();
		mHandler = new Handler();
	}

	/**
	 * init views used for activity
	 */
	protected void initViews() {
	}

	/**
	 * init action bar
	 */
	protected void initActionBar() {
	}

	/**
	 * init data
	 */
	protected void initData() {
	}

	/**
	 * bind actions for the view
	 */
	protected void bindActions() {
	}

	// --------------------getter and setter--------------------------
	public Handler getHandler() {
		return mHandler;
	}
	
	public MyApplication getApp() {
		return mApp;
	}
	
	@Override
	public void finish() {
		super.finish();
		this.overridePendingTransition(com.cst.stormdroid.R.anim.anim_slide_left_in, com.cst.stormdroid.R.anim.anim_slide_right_out);
	}
	
	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		this.overridePendingTransition(com.cst.stormdroid.R.anim.anim_slide_right_in, com.cst.stormdroid.R.anim.anim_slide_left_out);
	}
	
	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		super.startActivityForResult(intent, requestCode);
		this.overridePendingTransition(com.cst.stormdroid.R.anim.anim_slide_right_in, com.cst.stormdroid.R.anim.anim_slide_left_out);
	}
}
