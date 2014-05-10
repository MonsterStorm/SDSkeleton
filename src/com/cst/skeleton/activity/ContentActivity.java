package com.cst.skeleton.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.cst.ble.R;
import com.cst.skeleton.activity.base.BaseFragmentActivity;
import com.cst.skeleton.fragement.ContentFragment;

/**
 * 展示具体内容
 * @author MonsterStorm
 *
 */
public class ContentActivity extends BaseFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
	}
	
	@Override
	protected void initActionBar(Bundle savedInstanceState) {
		super.initActionBar(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	protected void initData(Bundle savedInstanceState) {
		super.initData(savedInstanceState);
		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			arguments.putString(ContentFragment.ARG_ITEM_ID, getIntent().getStringExtra(ContentFragment.ARG_ITEM_ID));
			ContentFragment fragment = new ContentFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().add(R.id.fg_content, fragment).commit();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
