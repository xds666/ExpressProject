package com.xds.express.http;

import org.json.JSONObject;

import android.R.bool;
import android.content.Context;
import android.util.Log;

import com.xds.express.http.interfaces.BaseDialogControl;
import com.xds.express.http.interfaces.HttpUIControl;

/**
 * @author wsy 匿名内部类的形式 反馈请求结果
 */
public abstract class HttpResponseResult implements HttpUIControl {

	private Context mContext;
	private BaseDialogControl dialogControl;
	private boolean isShowDialog = false;
	private String dialogMsg;

	/**
	 * 默认不显示进度条
	 */
	public HttpResponseResult() {
		isShowDialog = false;
		dialogControl = null;
	}

	public HttpResponseResult(Context context) {
		this(context, "正在拼命加载，请稍后...");
	}

	public HttpResponseResult(Context context, String dialogMsg) {
		mContext = context;
		isShowDialog = true;
		dialogControl = (BaseDialogControl) context;
		this.dialogControl = dialogControl;
	}

	@Override
	public void onPreViewAction() {
		if (isShowDialog && dialogControl != null) {
			dialogControl.startShowDialog(this.dialogMsg);
		}
	}

	@Override
	public void onAfterViewAction() {
		if (isShowDialog && dialogControl != null) {
			dialogControl.stopDimissDialog();
		}
	}

	public void HttpResultJson(String json) {
		try {
			JSONObject jsonObject = new JSONObject(json);
			int rspResult = jsonObject.getInt("code");// 请求码 200,表示成功响应
			String rspReason = jsonObject.getString("info");
			if (rspResult == 200) {
				HttpResult(true, json);
			} else {
				HttpResult(false, rspReason);
			}
		} catch (Exception e) {
			e.printStackTrace();
			json = e.getMessage().toString();
			HttpResult(false, json);
		}
	}

	public abstract void HttpResult(boolean isSuccess,String json);

}
