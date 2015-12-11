package com.xds.express.http.interfaces;

import com.xds.express.http.utils.PagingResult;


/*
 * 网络请求完成结果监听器(一般用于停止进度条、异常处理等)
 */


public interface ServerListener extends BaseDialogControl{

	/**
	 * 当前有网络情况，网络请求执行后监听回调
	 * @param isSuccess	时候响应成功
	 * @param type	请求类型
	 * @param json	返回json数据
	 * @param pagingResult	返回控制页码基类
	 */
	public void onServerComplete(boolean isSuccess,String type,String json,PagingResult pagingResult);
	
	
	/**
	 * 网络请求结束调用，目前用于停止dialog
	 * @param type
	 */
	public void onServerFinish(String type);
	
	/**
	 * 网络请求出现异常时调用
	 * @param type
	 * @param exception
	 */
	public void onServerException(String type,Exception exception);
}
