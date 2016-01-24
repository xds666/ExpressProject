package com.xds.express.app;

import android.app.Application;

/*
 * 储存全局变量
 */

public class ExpressApplication extends Application{
	
	private static ExpressApplication instance;
	
	public static ExpressApplication getInstance() {
		if(instance == null){
			instance = new ExpressApplication();
			return instance;
		}else {
			return instance;
		}
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
	}
}
