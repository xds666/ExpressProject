package com.xds.express.http.interfaces;


/*
 * Activity网络加载的时候的dialog的控制器
 */

public interface BaseDialogControl {

	/*
	 * Dialog show
	 */
	public void startShowDialog(String message);
	
	
	/*
	 * Dialog dismiss
	 */
	public void stopDimissDialog();
}
