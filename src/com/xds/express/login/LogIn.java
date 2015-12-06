package com.xds.express.login;

import java.io.IOException;

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
import com.xds.express.activity.MainActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends Activity {

	Button sign, submit;
	EditText phonenumber, password;
	int height, width;
	public String url="http://xiaodishu.coding.io/index.php/member/login/index/1/get_users/";
	HttpClient client = new DefaultHttpClient();
	ProgressDialog progress;
	
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			
			switch(msg.what){
			case 0:
				progress.dismiss();
				Toast.makeText(LogIn.this, "test", Toast.LENGTH_SHORT).show();
				
				break;
			case 1:
				break;
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_log_in);
		submit = (Button) findViewById(R.id.submit);
		sign = (Button) findViewById(R.id.signin);
		phonenumber = (EditText) findViewById(R.id.phonenumber);
		password = (EditText) findViewById(R.id.password);

		// ��ȡ��Ļ����
		DisplayMetrics dm = getResources().getDisplayMetrics();
		height = dm.heightPixels;
		width = dm.widthPixels;

	
		int i = (int) ((int) height * 0.4);
		submit.setWidth(i);
		sign.setWidth(i);
		phonenumber.setWidth(i);
		password.setWidth(i);
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			
				
				if(TextUtils.isEmpty(phonenumber.getText().toString())||TextUtils.isEmpty(password.getText().toString())){
					Toast.makeText(LogIn.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
				}else{
					progress = ProgressDialog.show(LogIn.this, "test", "登录中");
			//		new Login(phonenumber.getText().toString(), password.getText().toString()).start();
					asyncHttpClientRequest(phonenumber.getText().toString(), password.getText().toString());
				}
				
			}
		});
		sign.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(LogIn.this, Register.class));
			}
		});
		
		
	}
	
	public void asyncHttpClientRequest(String username, String password){
		AsyncHttpClient client = new AsyncHttpClient();
	
		RequestParams params = new RequestParams();
		params.put("username", username);
		params.put("password", password);
		
		client.post(url, params, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				
				Log.i("��������", new String(arg2));
				progress.dismiss();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
			
				progress.dismiss();
				Toast.makeText(LogIn.this, "��������ʧ�ܣ����Ժ�����", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	/*
	class Login extends Thread{
		String username;
		String password;
		
		Login(String username, String password){
		this.username = username;
		this.password = password;
		}
		
		@Override
		public void run() {
			
			super.run();
			try {
			final HttpPost httpRequest = new HttpPost(url+username+"/"+password);			
			HttpResponse httpResponse = client.execute(httpRequest);
			if(httpResponse.getStatusLine().getStatusCode() == 200){
				Log.i("���ز���", "200");
				handler.sendEmptyMessage(0);
			}
			} catch (ClientProtocolException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}

}
