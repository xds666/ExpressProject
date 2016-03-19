package com.xds.express.welcome;

import com.xds.express.R;
import com.xds.express.activity.login.LoginActivity;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Window;

public class FirstWelcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_first_welcome);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				//判断是否第一次运行(写入内存)
				SharedPreferences share = FirstWelcome.this.getSharedPreferences("share", MODE_PRIVATE);
				Editor editor = share.edit();
				boolean isFirstRun = share.getBoolean("isFirstRun", true);
				if(isFirstRun){
					editor.putBoolean("isFirstRun", false);
					editor.commit();
					Log.i("isFirstRun", "第一次运行");
					startActivity(new Intent(FirstWelcome.this, Welcome.class));
					FirstWelcome.this.finish();
				}else{
					startActivity(new Intent(FirstWelcome.this, LoginActivity.class));
					FirstWelcome.this.finish();
					Log.i("isFirstRun", "不是第一次运行");
				}
				
			}
		}, 2000);
	}

}