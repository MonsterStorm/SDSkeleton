package com.cst.skeleton.callback.base;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;

import com.cst.stormdroid.utils.log.SDLog;
import com.cst.stormdroid.utils.toast.ToastHelper;

/**
 * 基类回调类
 * @author MonsterStorm
 * 
 */
public abstract class BaseCallback<T> implements Callback<T> {

	public Activity mContext;

	public BaseCallback(Activity context) {
		this.mContext = context;
	}

	@Override
	public void success(T data, Response response) {
	}

	@Override
	public void failure(RetrofitError error) {
		if (error != null) {
			SDLog.e(this.getClass().getSimpleName(), error.getMessage());
		}
		if (mContext.isFinishing() == false && error != null) {
			ToastHelper.showToast(mContext, String.valueOf("发生错误 " + error.getMessage() + " !"));
		} else {
			ToastHelper.showToast(mContext, "发生错误");
		}
	}
}
