package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;


import com.xds.express.Express;
import com.xds.express.R;
import com.xds.express.R.id;
import com.xds.express.R.layout;
import com.xds.express.adapter.CurrentExpressMenuAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CurrentExpressMenuActivity extends BaseActivity {

private String[] company_name = {"申通"};
	
	private String[] pick_way = {"自己拿","送货上门"};
	
	private String[] status = {"test123","未收件","已失效"};
	
	private int num = 3;	//快递数量
	private ListView express_menu;					
	private CurrentExpressMenuAdapter adapter;	
	private List<Express> mData=new ArrayList<Express>();	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_express_menu,false);
		Log.i("123", "123");
		express_menu = (ListView) findViewById(R.id.express_menu);
		initData();
		initView();
	}
	
	
	public void initView() {
		adapter = new CurrentExpressMenuAdapter(this, mData);
		express_menu.setAdapter(adapter);
		//为每个ListItem设置监听事件
		express_menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(CurrentExpressMenuActivity.this,CurrentExpressInfoActivity.class);
				startActivity(intent);
				
			}
		});
	}
	
	
	public void initData(){
		for(int i=0;i<num;i++)
		{
			Express item = new Express(company_name[0], pick_way[0], status[i]);
			Log.i("test", "num"+i);
			mData.add(item);
		}
	}
}
