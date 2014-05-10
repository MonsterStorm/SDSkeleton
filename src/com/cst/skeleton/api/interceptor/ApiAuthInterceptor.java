package com.cst.skeleton.api.interceptor;

import retrofit.RequestInterceptor;

import com.cst.skeleton.app.MyApplication;

/**
 * 认证
 * @author MonsterStorm
 * 
 */
public class ApiAuthInterceptor implements RequestInterceptor {

	private MyApplication mApp;

	public ApiAuthInterceptor(MyApplication app) {
		this.mApp = app;
	}

	@Override
	public void intercept(RequestFacade request) {
	}
}