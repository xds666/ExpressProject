package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.xds.express.R;
import com.xds.express.adapter.RecordAdapter;
import com.xds.express.adapter.RecordAdapter.RecordMessage;
import com.xds.express.widget.ListViewCompat;

/**
 * @author Wusy
 * create time 2015年11月18日下午9:50:34
 * 历史记录首页
 */
public class RecordActivity extends BaseActivity{
	
	private ListViewCompat listView;
	private RecordAdapter adapter;
	
	private List<RecordMessage> data = new ArrayList<RecordMessage>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record_index);
		initView();
		initListener();
	}
	
	private void initView(){
		setTitle("历史记录");
		listView = (ListViewCompat) findViewById(R.id.lv_record_index);
		//测试数据
		for (int i = 0; i < 4; i++) {
			RecordMessage recordMessage = new RecordMessage();
			if (i%2 == 0) {
				recordMessage.expressName = "邮政";
				recordMessage.state = "未评价";
			}else{
				recordMessage.expressName = "顺丰";
				recordMessage.state = "已评价";
			}
			data.add(recordMessage);
		}
		adapter = new RecordAdapter(this, data);
		listView.setAdapter(adapter);
	}
	
	private void initListener(){
//		listView.setonMyItemClickListener(new onMyItemClickListener() {
//			
//			@Override
//			public void onClick(SlideMessage data, int position) {
//				startActivity(new Intent(RecordActivity.this,RecordEvaluteNoneActivity.class));
//			}
//		});
//		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				RecordMessage recordMessage = data.get(position);
				if (recordMessage.state.equals("已评价")) {
					startActivity(new Intent(RecordActivity.this,RecordEvaluteActivity.class));				
				}else{
					startActivity(new Intent(RecordActivity.this,RecordEvaluteNoneActivity.class));				
				}
			}
		});
	}
	
}
