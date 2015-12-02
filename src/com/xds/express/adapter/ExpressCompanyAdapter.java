package com.xds.express.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xds.express.ExpressMessage;
import com.xds.express.R;

/**
 * @author Wusy create time 2015年11月19日下午10:11:54 快递公司适配器查询
 */
public class ExpressCompanyAdapter extends BaseExpandableListAdapter {

	private List<ExpressMessage> data = new ArrayList<ExpressMessage>();
	private Context context;

	public ExpressCompanyAdapter(Context context, List<ExpressMessage> data) {
		this.context = context;
		this.data = data;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return data.get(groupPosition).getExpressName();
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		childViewHolder holder = null;
		// 第一次加载的时候是空,则加载布局id
		if (convertView == null) {
			// 定义缓冲
			holder = new childViewHolder();
			// 通过子对象位置 可以加载不同的view
			// 添加父容器
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_express_company_layout, null);
			// 获取控件对象
			holder.expressPhone = (TextView) convertView
					.findViewById(R.id.tv_item_express_msg_phone);
			holder.expressName = (TextView) convertView
					.findViewById(R.id.tv_item_express_msg_name);
			holder.expressAddress = (TextView) convertView
					.findViewById(R.id.tv_item_express_msg_location);
			convertView.setTag(holder);// 存入缓冲
		} else {
			holder = (childViewHolder) convertView.getTag();
		}

		// 加载数据
		holder.expressPhone.setText(data.get(groupPosition).getExpressPhone());
		holder.expressName.setText(data.get(groupPosition).getExpressName());
		holder.expressAddress.setText(data.get(groupPosition)
				.getExpressAddress());

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return data.get(groupPosition).getExpressName();
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ParentViewHolder holder = null;
		// 第一次加载的时候是空,则加载布局id
		if (convertView == null) {
			// 定义缓冲
			holder = new ParentViewHolder();
			// 通过子对象位置 可以加载不同的view
			// 添加父容器
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_express_company_group, null);
			// 获取控件对象
			holder.groupImg = (ImageView) convertView
					.findViewById(R.id.express_group_img);
			holder.expressName = (TextView) convertView
					.findViewById(R.id.express_group_name);
			convertView.setTag(holder);// 存入缓冲
		} else {
			holder = (ParentViewHolder) convertView.getTag();
		}

		// 加载数据
		holder.expressName.setText(data.get(groupPosition).getExpressName());
		// 这里选中图标改变
		if (isExpanded) {
			holder.groupImg.setBackgroundResource(R.drawable.group_down);
		} else {
			holder.groupImg.setBackgroundResource(R.drawable.group_right);

		}

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	public class childViewHolder {
		public TextView expressName;
		public TextView expressAddress;
		public TextView expressPhone;
	}

	public class ParentViewHolder {
		public ImageView groupImg;
		public TextView expressName;
	}

}
