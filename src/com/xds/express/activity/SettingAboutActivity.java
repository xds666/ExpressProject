package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;

import com.xds.express.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class SettingAboutActivity extends Activity {

	ListView about;
	List<String> list;
	ImageView back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting_about);
		back = (ImageView)findViewById(R.id.back);
		about = (ListView)findViewById(R.id.about);
		about.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, initData()));
		back.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO �Զ����ɵķ������
						finish();
					}
				});
	}

	public List<String> initData(){
		list = new ArrayList<String>();
		list.add("功能介绍");
		list.add("合作伙伴介绍");
		list.add("使用帮助和反馈");
		return list;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting_about, menu);
		return true;
	}

}
