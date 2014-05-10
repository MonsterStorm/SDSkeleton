package com.cst.skeleton.api.interceptor;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * 调用失效
 * @author MonsterStorm
 *
 */
public class ApiErrorHandler implements ErrorHandler {

	@Override
	public Throwable handleError(RetrofitError cause) {
		if (cause.getResponse() != null) {
			int status = cause.getResponse().getStatus();
		}
		return cause;
	}

}