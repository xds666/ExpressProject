package com.xds.express.activity;

import com.xds.express.R;
import com.xds.express.R.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class IndexActivity extends Activity implements OnClickListener {
	
	private RelativeLayout send,stepped,history,price_query,company_query,service;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		initView();
		initListener();
	}

	
	private void initView() {
		// TODO 自动生成的方法存根
		send = (RelativeLayout)findViewById(R.id.send_rl);
		stepped = (RelativeLayout)findViewById(R.id.stepped_rl);
		history = (RelativeLayout)findViewById(R.id.history_rl);
		price_query = (RelativeLayout)findViewById(R.id.price_query_rl);
		company_query = (RelativeLayout)findViewById(R.id.company_query_rl);
		service = (RelativeLayout)findViewById(R.id.service_rl);
	}
			
	
	private void initListener() {
		// TODO 自动生成的方法存根
		send.setOnClickListener(this);
		stepped.setOnClickListener(this);
		history.setOnClickListener(this);
		price_query.setOnClickListener(this);
		company_query.setOnClickListener(this);
		service.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.send_rl:
			startActivity(new Intent(IndexActivity.this,ShippingActivity.class));
			break;
		case R.id.stepped_rl:
			startActivity(new Intent(IndexActivity.this,ShippingRecordActivity.class));
			break;
		case R.id.history_rl:
			startActivity(new Intent(IndexActivity.this,RecordActivity.class));
			break;
		case R.id.price_query_rl:
			break;
		case R.id.company_query_rl:
			startActivity(new Intent(IndexActivity.this,ExpressCompanyActivity.class));
			break;
		case R.id.service_rl:
			startActivity(new Intent(IndexActivity.this,ServiceActivity.class));
			break;
		}
	}
}
