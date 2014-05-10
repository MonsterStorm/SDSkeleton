package com.cst.skeleton.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

/**
 * base template activity
 * @author MonsterStorm
 * 
 */
public class BaseFragmentActivity extends FragmentActivity {
	// default handler
	protected Handler mHandler = new Handler();

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		initViews(savedInstanceState);
		initActionBar(savedInstanceState);
		initData(savedInstanceState);
		bindActions(savedInstanceState);
	}

	/**
	 * init views used for activity
	 */
	protected void initViews(Bundle savedInstanceState) {
	}

	/**
	 * init action bar
	 */
	protected void initActionBar(Bundle savedInstanceState) {
	}

	/**
	 * init data
	 */
	protected void initData(Bundle savedInstanceState) {
	}

	/**
	 * bind actions for the view
	 */
	protected void bindActions(Bundle savedInstanceState) {
	}

	// --------------------getter and setter--------------------------
	public Handler getHandler() {
		return mHandler;
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
