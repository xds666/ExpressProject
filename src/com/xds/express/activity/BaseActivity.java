package com.xds.express.activity;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xds.express.R;
import com.xds.express.http.interfaces.BaseDialogControl;


public class BaseActivity extends Activity implements BaseDialogControl{

	private ProgressDialog progressDialog;
    private String TAG = "BaseActivity";
    
    //View
    private ImageButton baseBackBtn;
    private TextView baseTitleTxt;
    private FrameLayout baseContainer;
    private RelativeLayout baseTitleLayout;
    
    //value
    private boolean isHaveTitle = true;//是否需要标题 默认有

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public void setContentView(int layoutResID) {
    	View view = initBaseView(layoutResID);
    	super.setContentView(view);
    }
    
    public void setContentView(int layoutResID,boolean isHaveTitle) {
    	this.isHaveTitle = isHaveTitle;
    	View view = initBaseView(layoutResID);
    	super.setContentView(view);
    }
    
    public View initBaseView(int layoutResID){
    	View view = LayoutInflater.from(this).inflate(R.layout.activity_base,null);
    	View mainView = LayoutInflater.from(this).inflate(layoutResID,null);
    	baseTitleLayout = (RelativeLayout) view.findViewById(R.id.base_title_layout);
    	baseBackBtn = (ImageButton) view.findViewById(R.id.base_back);
    	baseTitleTxt = (TextView) view.findViewById(R.id.base_title);
    	baseContainer = (FrameLayout) view.findViewById(R.id.base_container);
    	baseBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {	finish();}
		});
    	
    	if (!isHaveTitle) {
    		baseTitleLayout.setVisibility(View.GONE);
		}
    	
    	baseContainer.addView(mainView);
    	return view;
    }

    
    // http dialog
    public void initProgresDilaog(String message) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(message);
    }
    
	@Override
    public void stopDimissDialog() {
        Log.i(TAG,"wsy dimissDialog");
        progressDialog.dismiss();
    }

	@Override
	public void startShowDialog(String message) {
		initProgresDilaog(message);
        progressDialog.show();
	}

	//title listener
	
	@Override
	public void setTitle(CharSequence title) {
		baseTitleTxt.setText(title);
	}
	
}
