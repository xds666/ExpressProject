package com.xds.express.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.xds.express.R;

/**
 * @author Wusy
 * create time 2015年11月17日下午10:40:05
 * 查看寄件详情
 */

public class ShippingSeeActivity extends BaseActivity{
	
	private Button submit;
	private TextView status,arrive_date;
	private Spinner arrive_time;
	private String time[] = new String[]{"09:00--10:30","10:30--12:00","14:00--15:30","15:30--17:00"};
	
	private int mYear;
	private int mMonth;
	private int mDay;
	
	private static final int SHOW_DATAPICK = 0;
	private static final int DATE_DIALOG_ID = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shipping_see);
		setTitle("寄件");
		
		
		arrive_date = (TextView)findViewById(R.id.arrive_date);
		arrive_time = (Spinner)findViewById(R.id.arrive_time);
		
		initializeViews();
		
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		
		setDateTime();
		
		setTime(arrive_time);
	}
	
	private void setDateTime(){
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		
		updateDateDisplay();
	}
	
	
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			
			updateDateDisplay();
			
		}
	};
	
	
	private void updateDateDisplay() {
		arrive_date.setText(new StringBuilder().append("\t").append(mYear).append("-")  
	               .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1)).append("-")  
	               .append((mDay < 10) ? "0" + mDay : mDay));
		
	}


	/**
	 * 
	 */
	private void initializeViews() {
		arrive_date.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {  
	               Message msg = new Message();   
	               if (arrive_date.equals((TextView) v)) {    
	                  msg.what = ShippingSeeActivity.SHOW_DATAPICK;  
	                  Log.d("1", "1");
	               }    
	               ShippingSeeActivity.this.dateandtimeHandler.sendMessage(msg);   
	               Log.d("2", "2");
	            }  
	        });
	}

	private void setTime(Spinner spinner){
		List<Map<String,Object>> timeItems = new ArrayList<Map<String,Object>>();
		for(int i=0;i<time.length;i++)
		{
			Map<String,Object> timeItem = new HashMap<String,Object>();
			//timeItem.put("Logo", R.drawable.comment);
			timeItem.put("time", time[i]);
			timeItems.add(timeItem);
		}
//		SimpleAdapter simpleAdapter = new SimpleAdapter(this,timeItems,R.layout.time_item,new String[]{"Logo","time"}, new int[]{R.id.Logo,R.id.time});
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,timeItems,R.layout.item_time,new String[]{"time"}, new int[]{R.id.time});
		spinner.setAdapter(simpleAdapter);
		
		
	}
	
	Handler dateandtimeHandler = new Handler() {  
	    
	       @SuppressWarnings("deprecation")
		@Override    
	       public void handleMessage(Message msg) {    
	           switch (msg.what) {    
	           case ShippingSeeActivity.SHOW_DATAPICK:    
	               showDialog(DATE_DIALOG_ID);    
	               break;     
	       }    
	    
	    };
	};
	protected Dialog onCreateDialog(int id) {    
	       switch (id) {    
	       case DATE_DIALOG_ID:    
	           return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,    
	                  mDay);  
//	       case TIME_DIALOG_ID:  
//	           return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute, true);  
	       }  
	             
	       return null;    
	    }    
	    
	    @Override    
	    protected void onPrepareDialog(int id, Dialog dialog) {    
	       switch (id) {    
	       case DATE_DIALOG_ID:    
	           ((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);    
	           break;  
	    }   
	}
	
	
}
