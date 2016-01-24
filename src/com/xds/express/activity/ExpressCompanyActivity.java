package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.xds.express.ExpressMessage;
import com.xds.express.R;
import com.xds.express.adapter.ExpressCompanyAdapter;

/**
 * @author Wusy
 * create time 2015年11月19日下午9:58:52
 * 快递公司查询
 */
public class ExpressCompanyActivity extends BaseActivity{
	
	private ExpandableListView listView;
	private ExpressCompanyAdapter adapter;
	
	private List<ExpressMessage> data =new ArrayList<ExpressMessage>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_express_company);
		setTitle("快递公司查询");
		listView = (ExpandableListView) findViewById(R.id.express_index_listview);
		listView.setGroupIndicator(null);
		//测试数据
		for (int i = 0; i < 20; i++) {
			ExpressMessage message = new ExpressMessage();
			if (i%2==0) {
				message.setExpressAddress("广州大学");
				message.setExpressName("申通快递公司");
				message.setExpressPhone("110");
			}else{
				message.setExpressAddress("广州大学华软软件学院");
				message.setExpressName("顺丰快递公司");
				message.setExpressPhone("120");
			}
			data.add(message);
		}
		
		adapter = new ExpressCompanyAdapter(this,data);
		listView.setAdapter(adapter);
	}
}
