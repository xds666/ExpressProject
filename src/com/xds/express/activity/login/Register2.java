package com.xds.express.activity.login;

import com.xds.express.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Register2 extends Activity {

	EditText password1,password2;
	Button next;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register2);
		password1 = (EditText)findViewById(R.id.password1);
		password2 = (EditText)findViewById(R.id.password2);
		next = (Button)findViewById(R.id.next);
		
		DisplayMetrics dm = getResources().getDisplayMetrics();
		int width = dm.widthPixels;
		
		password1.setWidth((int)(width*0.8));
		password2.setWidth((int)(width*0.8));
		next.setWidth((int)(width*0.8));
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				startActivity(new Intent(Register2.this, Register3.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register2, menu);
		return true;
	}

}
