package com.cst.skeleton.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cst.ble.R;
import com.cst.skeleton.activity.base.BaseFragmentActivity;
import com.cst.skeleton.fragement.ContentFragment;
import com.cst.skeleton.fragement.WelcomeFragment;
import com.cst.skeleton.fragement.callback.Callbacks;

/**
 * main activity
 */
public class MainActivity extends BaseFragmentActivity implements Callbacks {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void initViews(Bundle savedInstanceState) {
		super.initViews(savedInstanceState);
		if (findViewById(R.id.fg_content) != null) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fg_content, new WelcomeFragment()).commit();
		}
	}

	/**
	 * Fragment回调
	 */
	@Override
	public void onAction(Fragment fg, Bundle data) {
		Intent detailIntent = new Intent(this, ContentActivity.class);
		detailIntent.putExtra(ContentFragment.ARG_ITEM_ID, String.valueOf(data.getInt("pos")));
		startActivity(detailIntent);
	}
}
