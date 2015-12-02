package com.xds.express.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xds.express.R;
import com.xds.express.adapter.RecordAdapter.RecordMessage;
import com.xds.express.adapter.RecordAdapter.RecordViewHolder;
import com.xds.express.widget.SlideMessage;
import com.xds.express.widget.SlideView;

/**
 * @author Wusy
 * create time 2015年11月17日下午10:27:38
 * 寄件记录适配器
 */
public class ShippingRecordAdapter extends BaseAdapter{
	
	private LayoutInflater inflater;
	private List<ShippingMessage> data = new ArrayList<ShippingMessage>();
	private Context context;
	
	public ShippingRecordAdapter(Context context,List<ShippingMessage> data){
		inflater = LayoutInflater.from(context);
		this.data = data;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		RecordViewHolder holder;
		SlideView slideView = (SlideView) convertView;
		if (slideView == null) {
			View itemView = inflater.inflate(
					R.layout.item_shipping_record_list, null);

			slideView = new SlideView(context);
			slideView.setContentView(itemView);

			holder = new RecordViewHolder(slideView);
//			slideView.setOnSlideListener(new SlideView.OnSlideListener() {
//				@Override
//				public void onSlide(View view, int status) {
//
//					if (mLastSlideViewWithStatusOn != null
//							&& mLastSlideViewWithStatusOn != view) {
//						mLastSlideViewWithStatusOn.shrink();
//					}
//
//					if (status == SLIDE_STATUS_ON) {
//						mLastSlideViewWithStatusOn = (SlideView) view;
//					}
//				}
//			});
			slideView.setTag(holder);
		} else {
			holder = (RecordViewHolder) slideView.getTag();
		}
		ShippingMessage item = data.get(position);
		item.slideView = slideView;
		item.slideView.shrink();
		if (!TextUtils.isEmpty(item.state)) {
			holder.timeLayout.setVisibility(View.GONE);
			holder.state.setVisibility(View.VISIBLE);
			holder.state.setText(item.state);
			holder.expressName.setText(item.expressName);
		}else{
			holder.expressName.setText(item.expressName);
			holder.time.setText(item.time);
			holder.data.setTag(item.data);
		}
		

		holder.deleteHolder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "删除位置：" + position, Toast.LENGTH_SHORT)
						.show();
				data.remove(position);
				notifyDataSetChanged();
			}
		});

		return slideView;

	}
	
	public static class ShippingMessage extends SlideMessage {
		public String expressName;// 快递名称
		public String state;// 快递状态 评价 未评价
		public String time;// 
		public String data;// 
	}

	class RecordViewHolder {
		public TextView expressName;// 快递名称
		public TextView state;// 快递状态
		public TextView time;// 
		public TextView data;// 
		public LinearLayout timeLayout;
		

		public ViewGroup deleteHolder;

		public RecordViewHolder(View view) {
			expressName = (TextView) view
					.findViewById(R.id.item_shipping_name);
			state = (TextView) view.findViewById(R.id.item_shipping_state);
			time = (TextView) view.findViewById(R.id.item_shipping_time);
			data = (TextView) view.findViewById(R.id.item_shipping_data);
			timeLayout = (LinearLayout) view.findViewById(R.id.item_shipping_time_layout);

			deleteHolder = (ViewGroup) view.findViewById(R.id.holder);

		}
	}

}
