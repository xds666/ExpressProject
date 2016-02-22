package com.xds.express.activity.login;

import java.io.IOException;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xds.express.R;
import com.xds.express.activity.BaseActivity;
import com.xds.express.activity.MainActivity;
import com.xds.express.http.HttpClientUtil;
import com.xds.express.http.HttpResponseResult;
import com.xds.express.servers.UserLoginServer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

	/*
	 * 2016年2月22日19:25:28 添加test
	 */
	Button sign, submit;
	EditText phonenumber, password;
	CheckBox saveInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_log_in,false);
		submit = (Button) findViewById(R.id.submit);
		sign = (Button) findViewById(R.id.login_signin);
		phonenumber = (EditText) findViewById(R.id.phonenumber);
		password = (EditText) findViewById(R.id.password);
		saveInfo = (CheckBox)findViewById(R.id.saveUserInfo);
		
		Map<String, String> map = UserLoginServer.getSaveUserInfo(getApplicationContext());
		
		if (map!=null) {
			phonenumber.setText(map.get("username"));
			password.setText(map.get("password"));
		}
		
		/*
		 * 登陆事件
		 */
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String account = phonenumber.getText().toString().trim();
				String psw = password.getText().toString().trim();
				
//				if(TextUtils.isEmpty(account)||TextUtils.isEmpty(psw)){
//					Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
//				}else{
//					dologing(account,psw);
//				}
//				
				if (saveInfo.isChecked()) {
					Log.d("success", "save username and password");
					boolean result = UserLoginServer.saveUserInfo(getApplicationContext(),account,psw);
					if(result)
					{
						Toast.makeText(getApplicationContext(), "SUCCESS", 2000).show();
					}
				}
				
				
				startActivity(new Intent(LoginActivity.this,MainActivity.class));
				finish();
			}
		});
		sign.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, Register.class));
			}
		});
	}
	
	public void dologing(String account,String psw){
		HttpClientUtil.httpPost(this, UserLoginServer.ADDRESS, new UserLoginServer(account,psw,"get_users")
		, new HttpResponseResult(this) {
			
			@Override
			public void HttpResult(boolean isSuccess, String json) {
				if (isSuccess) {
					Log.i("wsy",json);
				}else{
					Toast.makeText(LoginActivity.this, json, Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}

}
