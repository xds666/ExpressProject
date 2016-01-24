package com.xds.express.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.xds.express.R;
import com.xds.express.adapter.AgentSearchAdapter;
import com.xds.express.widget.ListViewCompat;
import com.xds.express.widget.SlideMessage;
import com.xds.express.widget.SlideView;

public class SearchAgentOtherActivity extends BaseActivity {

	private ListViewCompat listView;
	private List<AgentSearchAdapter.AgentSearchMessage> data = new ArrayList<AgentSearchAdapter.AgentSearchMessage>();

	private SlideView mLastSlideViewWithStatusOn;
	AgentSearchAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_agent_other);
		initView();
		initListener();
	}

	private void initView() {
		listView = (ListViewCompat) findViewById(R.id.lv_agent_search_other);

		for (int i = 0; i < 20; i++) {
			AgentSearchAdapter.AgentSearchMessage item = new AgentSearchAdapter.AgentSearchMessage();
			if (i % 3 == 0) {
				item.expressName = "申通快递";
				item.date = "12月18日";
				item.state = "";
				item.time = "19:00";
			} else {
				item.expressName = "顺丰快递";
				item.date = "11月11日";
				item.state = "收件";
				item.time = "19:00";
			}

			data.add(item);
		}
		adapter = new AgentSearchAdapter(this, data);
		listView.setAdapter(adapter);
	}

	private void initListener() {
//		listView.setonMyItemClickListener(new onMyItemClickListener() {
//			
//			@Override
//			public void onClick(SlideMessage data, int position) {
//				startActivity(new Intent(SearchAgentOtherActivity.this,AgentInfoActivity.class));
//			}
//		});
	}

}
