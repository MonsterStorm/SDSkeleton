package com.cst.skeleton.api;

import retrofit.RestAdapter;
import retrofit.RestAdapter.Log;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.GsonConverter;

import com.cst.skeleton.api.interceptor.ApiAuthInterceptor;
import com.cst.skeleton.api.interceptor.ApiErrorHandler;
import com.cst.skeleton.app.MyApplication;
import com.cst.stormdroid.utils.Config;
import com.cst.stormdroid.utils.log.SDLog;
import com.google.gson.Gson;

/**
 * 封装所有API
 * @author MonsterStorm
 * 
 */
public class ApiServices {
	private final String mBaseUrl;

	private final MyApplication mApp;

	// services

	public ApiServices(MyApplication app) {
		this.mApp = app;
		mBaseUrl = Configs.getString(Configs.BASE_URL);
		init();
	}

	public void init() {
		Gson gson = MyApplication.getDefaultGson();
		RestAdapter.Builder builder = new RestAdapter.Builder()
				.setServer(mBaseUrl)
				.setConverter(new GsonConverter(gson))
				.setRequestInterceptor(new ApiAuthInterceptor(mApp))
				.setErrorHandler(new ApiErrorHandler());
		
		if(Config.mDebug == true){
			builder.setLogLevel(LogLevel.FULL)
			.setLog(new Log() {
				@Override
				public void log(String arg) {
					SDLog.d("rest", arg);
				}
			});
		}
		
		RestAdapter restAdapter = builder.build();
		
		//注册服务
//		mUserService = restAdapter.create(UserService.class);
//		mTaskService = restAdapter.create(TaskService.class);
//		mMsgService = restAdapter.create(MsgService.class);
//		mOrganizationService = restAdapter.create(OrganizationService.class);
	}

	// --------------------getters & setters------------------------------
}
