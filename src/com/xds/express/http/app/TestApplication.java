package com.xds.express.http.app;

import android.app.Application;

/*
 * 储存全局变量
 */

public class TestApplication extends Application{
	private static TestApplication instance;
	
	public static TestApplication getInstance() {
		if(instance == null){
			instance = new TestApplication();
			return instance;
		}else {
			return instance;
		}
	}
	public void onCreat() {
		super.onCreate();
		instance = this;
	}
	
}
