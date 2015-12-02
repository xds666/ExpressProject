package com.xds.express.login;

import com.xds.express.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Register3 extends Activity {

	EditText name,school,office,number;
	Button enter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register3);

		DisplayMetrics dm = getResources().getDisplayMetrics();
		int width = dm.widthPixels;
		
		name = (EditText)findViewById(R.id.name);
		school = (EditText)findViewById(R.id.school);
		office = (EditText)findViewById(R.id.office);
		number = (EditText)findViewById(R.id.number);
		enter = (Button)findViewById(R.id.enter);
		name.setWidth((int)(width*0.8));
		school.setWidth((int)(width*0.8));
		office.setWidth((int)(width*0.8));
		number.setWidth((int)(width*0.8));
		enter.setWidth((int)(width*0.8));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register3, menu);
		return true;
	}

}
