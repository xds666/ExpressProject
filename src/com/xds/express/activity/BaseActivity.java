package com.xds.express.activity;

import com.xds.express.R;
import com.xds.express.R.*;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class BaseActivity extends Activity {

	private ImageButton back;
	private TextView title_tv;
	private RelativeLayout title_rl;
	private View contentView;
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		
		back = (ImageButton)findViewById(R.id.back);
		title_tv = (TextView)findViewById(R.id.title_tv);
		
		
		title_rl = (RelativeLayout)findViewById(R.id.title_rl);
		
	}
	
	/*
	 * 设置区域内容
	 * @param resId
	 * 资源文件ID
	 */
	
	public void setContentLayout(int resId) {
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		contentView = inflater.inflate(resId, null);
		
		LayoutParams laytouParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
		contentView.setLayoutParams(laytouParams);
		contentView.setBackgroundDrawable(null);
		
		if (null != title_rl) {
			title_rl.addView(contentView);
		}
	}
	
}
