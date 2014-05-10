package com.cst.skeleton.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * 消息相关服务
 * @author MonsterStorm
 *
 */
public interface MsgService {
	public static final String PREFIX = "/messager/";
	
	/**
	 * 得到所有未读消息
	 * @param employeeId
	 * @param type
	 * @param cb
	 */
	@GET(PREFIX + "GetUnReadMessage/{employeeID}/{systemType}")
	public void getUnReadedMessages(@Path("employeeID") String employeeID, @Path("systemType") String systemType, Callback<Boolean> cb);
	
	/**
	 * 标记消息的状态为已读(按主题)
	 * @param employeeID
	 * @param groupID
	 * @param systemType
	 * @param cb
	 */
	//TODO GET不支持？，服务端奇葩的写法
	@POST(PREFIX + "SetReadStatusByGroup/{employeeID}/{groupID}/{systemType}")
	public void setReadStatusByGroup(@Path("employeeID") String employeeID, @Path("groupID") String groupID, @Path("systemType") String systemType, Callback<Boolean> cb);
	
	
	/**
	 * 删除邮件 （已发送或者收件箱的邮件放入垃圾箱，垃圾箱的邮件直接删除）
	 * @param groupIDs
	 * @param systemType
	 * @param cb
	 */
	//TODO not found
	@FormUrlEncoded
	@POST(PREFIX + "DeleteMessageStatusByGroup/{systemType}")
	public void deleteMessageStatusByGroup(@Field("groupIDs") List<String> groupIDs, @Path("systemType") String systemType, Callback<Boolean> cb);
	
	
}
