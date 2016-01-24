package com.xds.express.http.utils;

import java.lang.reflect.Field;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.xds.express.http.HttpResponseResult;


/**
 * Http 请求
 * Created by Wusy on 2015/11/22.
 */
public class HttpClientUtil {

    //Base
    private static final int TIME_OUT = 15000;
    private static AsyncHttpClient mClient;

    private  static AsyncHttpClient checkHttpClient() {
        if (mClient == null) {
            mClient = new AsyncHttpClient();
            mClient.setTimeout(TIME_OUT);
        }
        return mClient;
    }

    public static void httpPost(Context contxt, String url, Object obj, HttpResponseResult listener) {
    
        if (!NetWorkUtil.isNetWorkConnected()) {
            Toast.makeText(contxt, "当前无网络状态，请稍后尝试！", Toast.LENGTH_SHORT);
            return;
        }
        Log.i("wsy http", "request url: " + url);
        //checkHttpClient();
        post(contxt, url,obj, listener);
    }

    private static void post(Context context, String url,Object obj, final HttpResponseResult listener) {
        RequestParams params = switchToParams(obj);
        checkHttpClient().post(context,url ,params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
            	listener.onPreViewAction();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                listener.onAfterViewAction();
            }

           
            @Override
			public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("wsy http", "Rsp: " + content);
                listener.HttpResultJson(content);
                listener.onAfterViewAction();
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                    ((Exception) error).printStackTrace();
                    Log.i("wsy http", " onFailure :" + error.toString());
                    listener.HttpResultJson(content);
                    listener.onAfterViewAction();
            }

        });
    }


    private static RequestParams switchToParams(Object obj) {
        RequestParams params = new RequestParams();
        //解析数据
        Field[] fields = obj.getClass().getFields();
        // 开始转换每一个public类型的变量
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                if (field.getType() == String.class) {
                    // 属性值为null, 用空字符串取代
                    String value = ((field.get(obj) == null) ? "" : String
                            .valueOf(field.get(obj)));
                    params.put(field.getName(), value);
                }
                // int类型
                else if (field.getType() == int.class) {
                    int temp = field.getInt(obj);
                    String value = Integer.toString(temp);
                    params.put(field.getName(), value);
                }
                //float
                else if (field.getType() == float.class) {
                    float temp = field.getFloat(obj);
                    String value = Float.toString(temp);
                    params.put(field.getName(), value);
                }
                //double
                else if (field.getType() == double.class) {
                    double temp = field.getDouble(obj);
                    String value = Double.toString(temp);
                    params.put(field.getName(), value);
                }
                // boolean类型
                else if (field.getType() == boolean.class) {
                    boolean temp = field.getBoolean(obj);
                    String value = String.valueOf(temp);
                    params.put(field.getName(), String.valueOf(value));
                }
                // Object类型（WeiboObject类型)
                else {
                    Object fieldObject = field.get(obj);
                    if (fieldObject instanceof Object) {
                        // 如果对象中含有对象类型的变量 递归遍历
                        switchToParams(fieldObject);
                    } else {
                        continue;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return params;
    }


}
