package com.xds.express.activity;

import com.xds.express.R;
import com.xds.express.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CurrentExpressInfoActivity extends Activity {
	
	private Button submit,back;
	TextView status;
	RelativeLayout time,pick_way;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_express_info);
		
		InitView();
		
	}

	public void InitView() {
		submit = (Button)findViewById(R.id.submit);
		back  = (Button)findViewById(R.id.back);
		status = (TextView)findViewById(R.id.status_tv);
		time = (RelativeLayout)findViewById(R.id.time_rl);
	}
	/*
	 * 快递失效的时候，提交按钮变得无法点击并且变灰
	 */
	public void TimeOut(){
		status.setText("已失效");
		submit.setClickable(false);
		submit.setBackgroundColor(808080);
	}
	
	
	private void InitListener(){
		back.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		time.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
			}
		});
	}
	
	public void HaveRecived() {
		
	}
}
