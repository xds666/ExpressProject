package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;







import com.xds.express.R;
import com.xds.express.R.id;
import com.xds.express.R.layout;
import com.xds.express.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SettingActivity extends Activity {
	ListView list1, list2;
	List<String> initList1, initList2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting);
		list1 = (ListView) findViewById(R.id.list1);
		list2 = (ListView) findViewById(R.id.list2);
		

		list1.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, initData1()));
		list2.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, initData2()));
		
		list1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO �Զ����ɵķ������
				switch (arg2) {
				case 0:
					startActivity(new Intent(SettingActivity.this,
							SettingGeneralActivity.class));
					break;
				case 1:
					startActivity(new Intent(SettingActivity.this, SettingRemindActivity.class));
					break;
				case 2:
					startActivity(new Intent(SettingActivity.this, SettingSafeActivity.class));
					break;
				case 3:
					break;
				case 4:
					startActivity(new Intent(SettingActivity.this, SettingAboutActivity.class));
					break;
				}
			}
		});
		list2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO �Զ����ɵķ������
				switch (arg2) {
				case 0:
					finish();
					break;
				}
			}
		});
		
	}

	public List<String> initData1() {
		initList1 = new ArrayList<String>();
		initList1.add("ͨ通用");
		initList1.add("消息提醒");
		initList1.add("账号安全问题");
		initList1.add("用户协议");
		initList1.add("关于软件");
		return initList1;
	}

	public List<String> initData2() {
		initList2 = new ArrayList<String>();
		initList2.add("退出当前账号");
		return initList2;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}
}
