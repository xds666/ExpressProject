package com.xds.express.OnclickListener;

import android.view.View;
import android.view.View.OnClickListener;
import com.xds.express.activity.*;

public class OnIndexPageChange implements OnClickListener{
	private int index = 0;
	
	public OnIndexPageChange(int i){
		index = i;
	}
	
	public void onClick(View v) {
		//MainActivity.getPager().setCurrentItem(index);
		
	}

}
