package com.xds.express.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.xds.express.R;



/**
 * @author Wusy
 * create time 2015年11月17日下午10:12:41
 * 寄件Activity
 */
public class ShippingActivity extends BaseActivity implements OnClickListener{
	
	//View
	private TextView searchOther;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shipping);
		initView();
		initListener();
	}
	
	private void initView(){
		searchOther = (TextView) findViewById(R.id.tv_shpping_search_other);
	}
	
	private void initListener(){
		searchOther.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_shpping_search_other:
			startActivity(new Intent(ShippingActivity.this,ShippingRecordActivity.class));
			break;

		default:
			break;
		}
	}

}
