package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xds.express.R;
import com.xds.express.widget.SwitchButton;

public class SettingRemindActivity extends Activity {

	ImageView back;
	ListView listview;
	ArrayList<String> data = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting_remind);
		back = (ImageView)findViewById(R.id.back);
		listview = (ListView)findViewById(R.id.remind);
		initData();
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
		
		MyAdapter adapter = new MyAdapter(this);
		listview.setAdapter(adapter);
	}

	public List<String> initData(){
		data.add("声音");
		data.add("振动");
		data.add("推送");
		data.add("提示软件更新信息");
		return data;
	}
	class MyAdapter extends BaseAdapter{

		LayoutInflater inflater;
		
		MyAdapter(Context context){
			this.inflater = LayoutInflater.from(context);
		}
		
		@Override
		public int getCount() {
			// TODO �Զ����ɵķ������
			return 4;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO �Զ����ɵķ������
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO �Զ����ɵķ������
			ViewHolder holder = new ViewHolder();
			
			if(convertView == null){
				convertView = inflater.inflate(R.layout.activity_setting_remind_listitem, null);
				holder.text = (TextView)convertView.findViewById(R.id.text);
				holder.button = (SwitchButton)convertView.findViewById(R.id.switchbutton);
				holder.text.setText(data.get(position));
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder)convertView.getTag();					
			}
			return convertView;
		}
		
	}
	
	class ViewHolder{
		TextView text;
		SwitchButton button;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting_remind, menu);
		return true;
	}

}
