package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;



import com.xds.express.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class SettingGeneralActivity extends Activity {

	ListView language;
	List<String> list;
	ImageView back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting_general);
		language = (ListView)findViewById(R.id.general);
		back = (ImageView)findViewById(R.id.back);
		language.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, initData()));
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
		list.add("你猜猜我是什么？我也不知道，得问文帆哥");
		return list;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting_general, menu);
		return true;
	}

}
