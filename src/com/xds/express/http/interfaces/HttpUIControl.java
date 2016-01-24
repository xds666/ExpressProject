package com.xds.express.http.interfaces;

/**
 * @author wsy
 * 在请求的时候 ，请求开始与请求结束的UI控制接口
 */
public interface HttpUIControl {

	/**
	 * HTTP刚刚开始请求的时候
	 */
	public void onPreViewAction();
	
	/**
	 * HTTP结束
	 */
	public void onAfterViewAction();
	
}
