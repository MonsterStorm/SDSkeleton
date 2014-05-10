package com.cst.skeleton.app;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import android.app.Activity;

import com.cst.skeleton.api.adapter.ByteArrayTypeAdapter;
import com.cst.skeleton.api.adapter.TimestampTypeAdapter;
import com.cst.stormdroid.app.SDBaseApplication;
import com.cst.stormdroid.utils.Config;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * APP管理
 * @author MonsterStorm
 * 
 */
public class MyApplication extends SDBaseApplication {
	// 任务执行器
	private ScheduledExecutorService mExecutorService;
	// Activity Manager
	private MyActivityManager mActivityManager;

	public MyApplication() {
		super();
		Config.enableDebug(true);
		mActivityManager = new MyActivityManager(this);
		mExecutorService = new ScheduledThreadPoolExecutor(2);
	}

	/**
	 * 退出app
	 * @param activity
	 */
	public void exit(Activity activity) {
		if (mActivityManager != null) {
			mActivityManager.exitApp(activity);
		}
	}

	// ---------------------------getters & setters--------------------------
	public static MyApplication getApp(){
		return (MyApplication)getInstance();
	}
	

	public MyActivityManager getActivityManager() {
		return mActivityManager;
	}

	public ScheduledExecutorService getExecutorService() {
		return mExecutorService;
	}
	
	public static Gson getDefaultGson(){
		return new GsonBuilder()
		.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//设置序列化的时候名字对应，因为后台的首字都是大写，java都是小写，因而必须加该字段以便对应
		.registerTypeAdapter(Date.class, new TimestampTypeAdapter())
		.registerTypeAdapter(byte[].class, new ByteArrayTypeAdapter())
		.create();
	}
}
