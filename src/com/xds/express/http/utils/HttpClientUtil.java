package com.xds.express.http.utils;

import java.lang.reflect.Field;

import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.*;
import com.xds.express.http.interfaces.ServerListener;


/**
 * Http 请求
 * Created by Wusy on 2015/11/22.
 */
public class HttpClientUtil {

    //Base
    private static final int TIME_OUT = 15000;
    public static AsyncHttpClient mClient;
    private ServerListener executeListener;//请求执行监听器

    private boolean isshowDialog = false;//是否显示dialog

    private Context context;
    private ProgressDialog progressDialog;//网络请求dialog
    private String URL = "";//请求地址
    private String type = "";//请求类型

    public static AsyncHttpClient checkHttpClient() {
        if (mClient == null) {
            mClient = new AsyncHttpClient();
            mClient.setTimeout(TIME_OUT);
        }
        return mClient;
    }

    public static void httpPost(Context contxt, String url, String type, Object obj, ServerListener listener) {
        if (obj == null) {
            listener.onServerFinish(type);
            return;
        }
        if (!NetWorkUtil.isNetWorkConnected()) {
            Toast.makeText(contxt, "当前无网络状态，请稍后尝试！", Toast.LENGTH_SHORT);
            return;
        }
        Log.i("wsy http", "Type: " + type);
        Log.i("wsy http", "request url: " + url);
        //checkHttpClient();
        post(contxt, url, type, obj, listener);
    }

    public static void post(Context context, String url, final String type, Object obj, final ServerListener listener) {
        RequestParams params = switchToParams(obj);
        checkHttpClient().post(context,url ,params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                listener.startShowDialog();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                listener.stopDimissDialog();
            }

           
            @Override
			public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("wsy http", "Rsp: " + content);
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    int rspResult = jsonObject.getInt("code");//请求码 200,表示成功响应
                    String rspReason = jsonObject.getString("info");
                    PagingResult pagingResult = new PagingResult();
                    if (rspResult == 200) {
                        if (listener != null) {
                            listener.onServerComplete(true, type, content, pagingResult);
                        }
                    } else {
                        if (listener != null) {
                            listener.onServerComplete(false, type,
                                    rspReason, null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (listener != null) {
                        listener.onServerException(type, e);
                        Log.i("wsy http", " JSONException :" + e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                if (listener != null) {
                    listener.onServerException(type, (Exception) error);
                    ((Exception) error).printStackTrace();
                    Log.i("wsy http", " onFailure :" + error.toString());

                }
            }


        });
    }


    public static RequestParams switchToParams(Object obj) {
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
