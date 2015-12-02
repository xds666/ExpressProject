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
import com.xds.express.widget.SlideMessage;
import com.xds.express.widget.SlideView;

/**
 * Created by wsy on 2015/11/18.
 */
public class AgentSearchAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private SlideView mLastSlideViewWithStatusOn;

    private List<AgentSearchMessage> data = new ArrayList<AgentSearchMessage>();

    public AgentSearchAdapter(Context context, List<AgentSearchMessage> data) {
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
        AgentSearchViewHolder holder;
        SlideView slideView = (SlideView) convertView;
        if (slideView == null) {
            View itemView = inflater.inflate(R.layout.item_agent_search_list_layout, null);

            slideView = new SlideView(context);
            slideView.setContentView(itemView);

            holder = new AgentSearchViewHolder(slideView);
//            slideView.setOnSlideListener(new SlideView.OnSlideListener() {
//                @Override
//                public void onSlide(View view, int status) {
//
//                    if (mLastSlideViewWithStatusOn != null && mLastSlideViewWithStatusOn != view) {
//                        mLastSlideViewWithStatusOn.shrink();
//                    }
//
//                    if (status == SLIDE_STATUS_ON) {
//                        mLastSlideViewWithStatusOn = (SlideView) view;
//                    }
//                }
//            });
            slideView.setTag(holder);
        } else {
            holder = (AgentSearchViewHolder) slideView.getTag();
        }
        AgentSearchMessage item = data.get(position);
        item.slideView = slideView;
        item.slideView.shrink();

        holder.expressName.setText(item.expressName);
        holder.date.setText(item.date);
        holder.time.setText(item.time);
        if (!TextUtils.isEmpty(item.state)) {
            holder.dataLayout.setVisibility(View.GONE);
            holder.state.setVisibility(View.VISIBLE);
            holder.state.setText(item.state);
        }

        holder.deleteHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "删除位置：" + position, Toast.LENGTH_SHORT).show();
                data.remove(position);
                notifyDataSetChanged();
            }
        });

        return slideView;

    }

    public static class AgentSearchMessage extends SlideMessage {
        public String expressName;//快递名称
        public String date;//日期
        public String time;//时间
        public String state;//快递状态
    }

    class AgentSearchViewHolder {
        public TextView expressName;//快递名称
        public TextView date;//日期
        public TextView time;//时间
        public TextView state;//快递状态
        public LinearLayout dataLayout;
        public ViewGroup deleteHolder;


        public AgentSearchViewHolder(View view) {
            expressName = (TextView) view.findViewById(R.id.tv_agent_item_expressname);
            date = (TextView) view.findViewById(R.id.tv_agent_item_date);
            time = (TextView) view.findViewById(R.id.tv_agent_item_time);
            state = (TextView) view.findViewById(R.id.tv_agent_item_state);
            dataLayout = (LinearLayout) view.findViewById(R.id.tv_agent_item_time_layout);
            deleteHolder = (ViewGroup) view.findViewById(R.id.holder);

        }
    }
}
