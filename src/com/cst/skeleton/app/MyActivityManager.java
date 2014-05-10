package com.cst.skeleton.app;

import java.util.ArrayList;
import java.util.List;

import com.cst.stormdroid.utils.log.SDLog;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;

public class MyActivityManager {
	private static final String TAG = MyActivityManager.class.getSimpleName();
	// 管理Activity
	private List<Activity> mActivityList;
	
	private MyApplication mApp;
	
	public MyActivityManager(MyApplication app) {
		this.mApp = app;
	}

	// -------------------------App 管理---------------------
	//退出一个activity
	public void pull(final Activity activity) {
		SDLog.d(TAG + "_pull: ", activity.getClass().getSimpleName());
		if (mActivityList == null) {
			return;
		}
		mActivityList.remove(activity);
	}

	//进入
	public void push(final Activity activity) {
		SDLog.d(TAG + "_push: ", activity.getClass().getSimpleName());
		if (mActivityList == null) {
			mActivityList = new ArrayList<Activity>();
		}
		if (mActivityList.indexOf(activity) == -1) {
			mActivityList.add(activity);
		}
	}

	//退出程序
	public void exitApp(final Activity activity) {
		SDLog.d(TAG + "_exitApp: ", activity.getClass().getSimpleName());
		if (mActivityList != null) {
			for (Activity a : mActivityList) {
				if (a != activity) {
					a.finish();
				}
			}
		}
		activity.moveTaskToBack(true);
		new Handler().postDelayed(new Runnable() {
			public void run() {
				activity.finish();
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(0);
			}
		}, 200);
	}
}
