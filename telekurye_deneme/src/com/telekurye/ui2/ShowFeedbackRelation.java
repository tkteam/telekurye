package com.telekurye.ui2;

import com.telekurye.utils.Tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ShowFeedbackRelation extends MasterActivity implements OnClickListener {

	Button		btn1, btn2, btn3, btn5, btn7, btn8, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
	private int	valueListviewItem;
	private int	valueEndpointStatusId;
	private int	valueFeedbackRelationId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout._6_yakinlik);
		btn1 = (Button) findViewById(R.id.btnYakinlik1);
		btn2 = (Button) findViewById(R.id.btnYakinlik2);
		btn3 = (Button) findViewById(R.id.btnYakinlik3);
		btn5 = (Button) findViewById(R.id.btnYakinlik5);
		btn7 = (Button) findViewById(R.id.btnYakinlik7);
		btn8 = (Button) findViewById(R.id.btnYakinlik8);
		btn10 = (Button) findViewById(R.id.btnYakinlik10);
		btn11 = (Button) findViewById(R.id.btnYakinlik11);
		btn12 = (Button) findViewById(R.id.btnYakinlik12);
		btn13 = (Button) findViewById(R.id.btnYakinlik13);
		btn14 = (Button) findViewById(R.id.btnYakinlik14);
		btn15 = (Button) findViewById(R.id.btnYakinlik15);
		btn16 = (Button) findViewById(R.id.btnYakinlik16);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {

			valueListviewItem = extras.getInt("DistributionMissionID");
			valueEndpointStatusId = extras.getInt("endpointstatusid");
			valueFeedbackRelationId = extras.getInt("feedbackrelationid");

		}

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn10.setOnClickListener(this);
		btn11.setOnClickListener(this);
		btn12.setOnClickListener(this);
		btn13.setOnClickListener(this);
		btn14.setOnClickListener(this);
		btn15.setOnClickListener(this);
		btn16.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		Intent i = new Intent(ShowFeedbackRelation.this, DistributionMissionFeedBackUi.class);

		switch (v.getId()) {
			case R.id.btnYakinlik1:
				i.putExtra("feedbackrelationid", 1);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik2:
				i.putExtra("feedbackrelationid", 2);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik3:
				i.putExtra("feedbackrelationid", 3);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik5:
				i.putExtra("feedbackrelationid", 5);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik7:
				i.putExtra("feedbackrelationid", 7);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik8:
				i.putExtra("feedbackrelationid", 8);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik10:
				i.putExtra("feedbackrelationid", 10);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik11:
				i.putExtra("feedbackrelationid", 11);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik12:
				i.putExtra("feedbackrelationid", 12);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik13:
				i.putExtra("feedbackrelationid", 13);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik14:
				i.putExtra("feedbackrelationid", 14);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik15:
				i.putExtra("feedbackrelationid", 15);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnYakinlik16:
				i.putExtra("feedbackrelationid", 16);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
		}

	}

	@Override
	public void onBackPressed() {

	}
}
