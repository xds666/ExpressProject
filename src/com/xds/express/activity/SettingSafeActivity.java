package com.xds.express.activity;



import com.xds.express.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SettingSafeActivity extends Activity {

	ImageView back;
	int height,width;
	EditText phoneNumber,checkNumber;
	Button next,get;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting_safe);
		back = (ImageView)findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
		phoneNumber = (EditText)findViewById(R.id.phonenumber);
		checkNumber = (EditText)findViewById(R.id.check_number);
		next = (Button)findViewById(R.id.next);
		get = (Button)findViewById(R.id.get);
		
		//��ȡ�ֻ�����ֱ���
		DisplayMetrics dm = getResources().getDisplayMetrics();
		height = dm.heightPixels;
		width = dm.widthPixels;
		
		//���������ռ�����Ȱٷֱ�
		phoneNumber.setWidth((int)(width*0.8));
		next.setWidth((int)(width*0.8));
		checkNumber.setWidth((int)(width*0.8*0.7));
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				startActivity(new Intent(SettingSafeActivity.this, SettingSafeNextActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting_safe, menu);
		return true;
	}

}
