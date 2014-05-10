package com.cst.skeleton.activity;

import android.view.ActionMode;

import com.cst.ble.R;
import com.cst.skeleton.activity.base.BaseActivity;

/**
 * 关于
 * @author MonsterStorm
 * 
 */
public class AboutActivity extends BaseActivity {
	@Override
	public void onActionModeFinished(ActionMode mode) {
		super.onActionModeFinished(mode);
		setContentView(R.layout.activity_about);
	}
}
