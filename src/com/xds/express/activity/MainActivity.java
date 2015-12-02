package com.xds.express.activity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.R.layout;
import android.app.ActionBar;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.app.Notification.Action;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.ViewConfiguration;
import android.view.Window;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.*;
import android.widget.TabHost.TabSpec;

import com.xds.express.*;
import com.xds.express.adapter.IndexPagerAdapter;
import com.xds.express.fragment.*;

public class MainActivity extends FragmentActivity{


	
	Context context = null;
	LocalActivityManager manager = null;
	ViewPager pager = null;
	TabHost tabHost =null;
	Button btn1,btn2,btn3;
	RelativeLayout rl1,rl2,rl3;
	
	
	private int offset = 0;
    private int currIndex = 0;
    private int bmpW;
    private ImageView cursor;
    private int SelectedColor,UnSelectedColor,Selected_bgcolor,white;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		context = MainActivity.this;
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		
		InitImageView();
        initRelativeLayout();
        initPagerViewer();
        

		
	}

	private void InitImageView() {
        cursor = (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.cursor)
        .getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / 3 - bmpW)/2 ;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        LayoutParams params = cursor.getLayoutParams();
        params.width=screenW/3;
        cursor.setLayoutParams(params);
        cursor.setImageMatrix(matrix);
    }

	private void initRelativeLayout() {
        rl1 = (RelativeLayout)findViewById(R.id.rl1);
        rl2 = (RelativeLayout)findViewById(R.id.rl2);
        rl3 = (RelativeLayout)findViewById(R.id.rl3);

        rl1.setOnClickListener(new MyOnClickListener(0));
        rl2.setOnClickListener(new MyOnClickListener(1));
        rl3.setOnClickListener(new MyOnClickListener(2));
        
    }
	
	private void initPagerViewer() {
        pager = (ViewPager) findViewById(R.id.viewpage);
        final ArrayList<View> list = new ArrayList<View>();
        Intent intent = new Intent(context, IndexActivity.class);
        list.add(getView("A", intent));
        Intent intent2 = new Intent(context, CurrentExpressMenuActivity.class);
        list.add(getView("B", intent2));
        Intent intent3 = new Intent(context, SettingActivity.class);
        list.add(getView("C", intent3));

        pager.setAdapter(new IndexPagerAdapter(list));
        pager.setCurrentItem(0);
       pager.setOnPageChangeListener(new MyOnPageChangeListener());
    }
	
	private View getView(String id, Intent intent) {
        return manager.startActivity(id, intent)
        		.getDecorView();
    }

	
	
	public class MyOnPageChangeListener implements OnPageChangeListener {

        int one = offset * 2 + bmpW;
        int two = one * 2;

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            UnSelectedColor=getResources().getColor(R.color.title_unforcus_color);
            SelectedColor=getResources().getColor(R.color.title_forcus_color);
            Selected_bgcolor = getResources().getColor(R.color.selected_bgcolor);
            white=getResources().getColor(R.color.white);
            RelativeLayout rl1 = (RelativeLayout)findViewById(R.id.rl1);
            RelativeLayout rl2 = (RelativeLayout)findViewById(R.id.rl2);
            RelativeLayout rl3 = (RelativeLayout)findViewById(R.id.rl3);
            switch (arg0) {
            case 0:
//            	text1.setTextColor(SelectedColor);
//                text3.setTextColor(UnSelectedColor);
//                text2.setTextColor(UnSelectedColor);
            	rl1.setBackgroundColor(Selected_bgcolor);
            	rl2.setBackgroundColor(white);
            	rl3.setBackgroundColor(white);
                if (currIndex == 1) {
                    animation = new TranslateAnimation(one, 0, 0, 0);
                    
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, 0, 0, 0);
                   
                }
                break; 
            case 1:
//            	rl2.setTextColor(SelectedColor);
//                rl3.setTextColor(UnSelectedColor);
//                rl1.setTextColor(UnSelectedColor);
                rl2.setBackgroundColor(Selected_bgcolor);
                rl3.setBackgroundColor(white);
                rl1.setBackgroundColor(white);
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, one, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, one, 0, 0);    
                }
                break;
            case 2:
//            	rl3.setTextColor(SelectedColor);
//                rl1.setTextColor(UnSelectedColor);
//                rl2.setTextColor(UnSelectedColor);
            	rl3.setBackgroundColor(Selected_bgcolor);
                rl1.setBackgroundColor(white);
                rl2.setBackgroundColor(white);
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, two, 0, 0);
                } else if (currIndex == 1) {
                    animation = new TranslateAnimation(one, two, 0, 0);
                }
                break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);
            animation.setDuration(300);
           cursor.startAnimation(animation);
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            
        }
    }
    
    
    
    
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            pager.setCurrentItem(index);
            
        }
    };
	


}
