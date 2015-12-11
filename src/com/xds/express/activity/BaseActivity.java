package com.xds.express.activity;


import com.xds.express.http.utils.PagingResult;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;


public class BaseActivity extends Activity {

	private ProgressDialog progressDialog;
    private String TAG = "BaseActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initProgresDilaog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("正在加载中，请稍后...");
    }



    public void startShowDialog() {
        Log.i(TAG,"wsy showDialog");
        initProgresDilaog();
        progressDialog.show();
    }


    public void stopDimissDialog() {
        Log.i(TAG,"wsy dimissDialog");
        progressDialog.dismiss();
    }


    public void onServerComplete(boolean isSuccess, String type, String json, PagingResult pagingResult) {

    }


    public void onServerFinish(String type) {

    }


    public void onServerException(String type, Exception exception) {

    }
	
}
