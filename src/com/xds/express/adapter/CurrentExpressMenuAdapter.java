package com.xds.express.adapter;

import java.util.List;







import com.xds.express.Express;
import com.xds.express.R;
import com.xds.express.activity.CurrentExpressMenuActivity;
import com.xds.express.widget.ExpressItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CurrentExpressMenuAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	List<Express> mData = null;
	
	
	public CurrentExpressMenuAdapter(Context mcontext,List<Express> mData) {
		mInflater = LayoutInflater.from(mcontext);
		this.mData = mData;
		
	}
	

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return mData.size();
	}

	@Override
	public Express getItem(int position) {
		// TODO 自动生成的方法存根
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ExpressItem express=null;
		if(convertView == null){
			express = new ExpressItem();
			convertView = mInflater.inflate(R.layout.list_item_express, null);
			express.setCompany((TextView)convertView.findViewById(R.id.company_name));
			express.setPick_way((TextView)convertView.findViewById(R.id.pick_way));
			express.setStatus((TextView)convertView.findViewById(R.id.status));
			
			express.getCompany().setText(getItem(position).getCompany());
			express.getPick_way().setText(getItem(position).getPick_way());
			express.getStatus().setText(getItem(position).getStatus());
			convertView.setTag(express);
		}else{
			express = (ExpressItem)convertView.getTag();
		}
		return convertView;
	}
}
