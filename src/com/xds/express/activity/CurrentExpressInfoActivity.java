package com.xds.express.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xds.express.R;
import com.xds.express.R.layout;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CurrentExpressInfoActivity extends BaseActivity {
	
	private Button submit;
	private TextView status,pick_date;
	private Spinner pick_time,pick_way;
	private RelativeLayout time_rl;
	private String time[] = new String[]{"09:00--10:30","10:30--12:00","14:00--15:30","15:30--17:00"};
	private String pick_ways[] = new String[]{"自取","上门","代领"};
	
	
	private String str;
	private int mYear;    
    private int mMonth;  
    private int mDay;
    
    private static final int SHOW_DATAPICK = 0;   
    private static final int DATE_DIALOG_ID = 1; 
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_express_info);
		
		submit = (Button)findViewById(R.id.submit);
		status = (TextView)findViewById(R.id.status_tv);
		pick_date = (TextView)findViewById(R.id.pick_date);
		pick_time = (Spinner)findViewById(R.id.pick_time);
		pick_way = (Spinner)findViewById(R.id.pick_way);
		time_rl = (RelativeLayout)findViewById(R.id.time_rl);
		
		
		time_rl.setVisibility(View.INVISIBLE);
		
		pick_way.setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
			
			@Override
			public void onChildViewRemoved(View parent, View child) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void onChildViewAdded(View parent, View child) {
				// TODO 自动生成的方法存根
				
			}
		});
	
		
		
		
		initializeViews();
		
		final Calendar c = Calendar.getInstance(); 
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		
		setDateTime();
		
		setTime(pick_time);
		setWay(pick_way);
	}



	private void setDateTime(){  
	       final Calendar c = Calendar.getInstance();    
	         
	       mYear = c.get(Calendar.YEAR);    
	       mMonth = c.get(Calendar.MONTH);    
	       mDay = c.get(Calendar.DAY_OF_MONTH);   
	    
	       updateDateDisplay();   
	    }


		private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {    
		    
		       public void onDateSet(DatePicker view, int year, int monthOfYear,    
		              int dayOfMonth) {    
		           mYear = year;    
		           mMonth = monthOfYear;    
		           mDay = dayOfMonth;    
		  
		           updateDateDisplay();  
		       }    
		    };



		private void updateDateDisplay(){  
	       pick_date.setText(new StringBuilder().append("\t").append(mYear).append("-")  
	               .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1)).append("-")  
	               .append((mDay < 10) ? "0" + mDay : mDay));   
	    }






		private void initializeViews() {
			
			pick_date = (TextView) findViewById(R.id.pick_date);
			pick_time = (Spinner) findViewById(R.id.pick_time);
			
			pick_date.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {  
		               Message msg = new Message();   
		               if (pick_date.equals((TextView) v)) {    
		                  msg.what = CurrentExpressInfoActivity.SHOW_DATAPICK;  
		                  Log.d("1", "1");
		               }    
		               CurrentExpressInfoActivity.this.dateandtimeHandler.sendMessage(msg);   
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
//			SimpleAdapter simpleAdapter = new SimpleAdapter(this,timeItems,R.layout.time_item,new String[]{"Logo","time"}, new int[]{R.id.Logo,R.id.time});
			SimpleAdapter simpleAdapter = new SimpleAdapter(this,timeItems,R.layout.item_time,new String[]{"time"}, new int[]{R.id.time});
			spinner.setAdapter(simpleAdapter);
			
			
		}
		
		private void setWay(Spinner spinner){
			List<Map<String, Object>> wayItems = new ArrayList<Map<String,Object>>();
			for (int i = 0; i < pick_ways.length; i++) {
				Map<String, Object> wayItem = new HashMap<String, Object>();
				wayItem.put("pick_way", pick_ways[i]);
				wayItems.add(wayItem);
				SimpleAdapter simpleAdapter = new SimpleAdapter(this, wayItems, R.layout.item_way, new String[]{"pick_way"}, new int[]{R.id.way});
				spinner.setAdapter(simpleAdapter);
			}
		}
		
		Handler dateandtimeHandler = new Handler() {  
		    
		       @SuppressWarnings("deprecation")
			@Override    
		       public void handleMessage(Message msg) {    
		           switch (msg.what) {    
		           case CurrentExpressInfoActivity.SHOW_DATAPICK:    
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
//		       case TIME_DIALOG_ID:  
//		           return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute, true);  
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
