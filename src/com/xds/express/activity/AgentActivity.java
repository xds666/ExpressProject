package com.xds.express.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xds.express.R;

public class AgentActivity extends Activity {

    private TextView searchOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);
        searchOther = (TextView) findViewById(R.id.agent_tile_layout);
        searchOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgentActivity.this,SearchAgentOtherActivity.class));
            }
        });
    }

}
