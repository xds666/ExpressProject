package com.xds.express.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.xds.express.R;
import com.xds.express.widget.SlideMessage;
import com.xds.express.widget.SlideView;

/**
 * @author Wusy create time 2015年11月18日下午10:50:05 历史记录适配器
 */
public class RecordAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private Context context;
	private SlideView mLastSlideViewWithStatusOn;

	private List<RecordMessage> data = new ArrayList<RecordMessage>();

	public RecordAdapter(Context context, List<RecordMessage> data) {
		inflater = LayoutInflater.from(context);
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		RecordViewHolder holder;
		SlideView slideView = (SlideView) convertView;
		if (slideView == null) {
			View itemView = inflater.inflate(
					R.layout.item_record_list_layout, null);

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
		RecordMessage item = data.get(position);
		item.slideView = slideView;
		item.slideView.shrink();
		holder.expressName.setText(item.expressName);
		holder.state.setText(item.state);

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

	public static class RecordMessage extends SlideMessage {
		public String expressName;// 快递名称
		public String state;// 快递状态 评价 未评价
	}

	class RecordViewHolder {
		public TextView expressName;// 快递名称
		public TextView state;// 快递状态
		public ViewGroup deleteHolder;

		public RecordViewHolder(View view) {
			expressName = (TextView) view
					.findViewById(R.id.tv_record_item_expressname);
			state = (TextView) view.findViewById(R.id.tv_record_item_state);
			deleteHolder = (ViewGroup) view.findViewById(R.id.holder);

		}
	}
}
