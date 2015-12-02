package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Int2;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.xds.express.R;
import com.xds.express.adapter.ShippingRecordAdapter;
import com.xds.express.adapter.ShippingRecordAdapter.ShippingMessage;
import com.xds.express.widget.ListViewCompat;

/**
 * @author Wusy create time 2015年11月17日下午10:25:02 查看寄件记录
 */
public class ShippingRecordActivity extends Activity {

	// View
	private ListViewCompat listView;
	private ShippingRecordAdapter adapter;
	private List<ShippingMessage> data = new ArrayList<ShippingMessage>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shipping_record);
		initView();
		initListener();
	}

	private void initView() {
		listView = (ListViewCompat) findViewById(R.id.lv_shipping_record);
		// 测试数据
		for (int i = 0; i < 10; i++) {
			ShippingMessage message = new ShippingMessage();
			if (i % 2 == 0) {
				message.data = "2015年11月11日";
				message.time = "09:00~12:00";
				message.state = "";
				message.expressName = "天天快递";
			} else {
				message.data = "2015年11月11日";
				message.time = "09:00~12:00";
				message.state = "已收件";
				message.expressName = "中国邮政快递";

			}
			data.add(message);
		}

		adapter = new ShippingRecordAdapter(this, data);
		listView.setAdapter(adapter);
	}

	private void initListener() {
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

			}
		});
	}

}
