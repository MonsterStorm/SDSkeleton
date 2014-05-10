package com.cst.skeleton.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * 用户服务
 * @author MonsterStorm
 * 
 */
public interface UserService {
	public static final String PREFIX = "/security/";

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param cb
	 */
	@GET(PREFIX + "privateLogin/{username}/{password}")
	public void login(@Path("username") String username, @Path("password") String password, Callback<Boolean> cb);


}
