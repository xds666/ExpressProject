package com.xds.express.activity;



import com.xds.express.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SettingSafeNextActivity extends Activity {

	EditText password1,password2;
	Button finish;
	ImageView back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting_safe_next);
		
		password1 = (EditText)findViewById(R.id.password1);
		password2 = (EditText)findViewById(R.id.password2);
		finish = (Button)findViewById(R.id.next);
		back = (ImageView)findViewById(R.id.back);
		
		DisplayMetrics dm = getResources().getDisplayMetrics();
		int width = dm.widthPixels;
		
		password1.setWidth((int)(width*0.8));
		password2.setWidth((int)(width*0.8));
		finish.setWidth((int)(width*0.8));
		finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Toast.makeText(SettingSafeNextActivity.this, "δ�O��", Toast.LENGTH_SHORT).show();
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting_safe_next, menu);
		return true;
	}

}
