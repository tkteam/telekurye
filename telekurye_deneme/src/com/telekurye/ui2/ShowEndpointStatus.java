package com.telekurye.ui2;

import com.telekurye.utils.Tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ShowEndpointStatus extends MasterActivity implements OnClickListener {

	Button		btn1, btn9, btn10, btn11, btn12, btn13, btn17, btn18, btn20, btn21, btn26;
	private int	valueListviewItem;
	private int	valueEndpointStatusId;
	private int	valueFeedbackRelationId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout._5_teslim);

		btn1 = (Button) findViewById(R.id.btnTeslim1);
		btn9 = (Button) findViewById(R.id.btnTeslim9);
		btn10 = (Button) findViewById(R.id.btnTeslim10);
		btn11 = (Button) findViewById(R.id.btnTeslim11);
		btn12 = (Button) findViewById(R.id.btnTeslim12);
		btn13 = (Button) findViewById(R.id.btnTeslim13);
		btn17 = (Button) findViewById(R.id.btnTeslim17);
		btn18 = (Button) findViewById(R.id.btnTeslim18);
		btn20 = (Button) findViewById(R.id.btnTeslim20);
		btn21 = (Button) findViewById(R.id.btnTeslim21);
		btn26 = (Button) findViewById(R.id.btnTeslim26);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {

			valueListviewItem = extras.getInt("DistributionMissionID");
			valueEndpointStatusId = extras.getInt("endpointstatusid");
			valueFeedbackRelationId = extras.getInt("feedbackrelationid");

		}

		btn1.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn10.setOnClickListener(this);
		btn11.setOnClickListener(this);
		btn12.setOnClickListener(this);
		btn13.setOnClickListener(this);
		btn17.setOnClickListener(this);
		btn18.setOnClickListener(this);
		btn20.setOnClickListener(this);
		btn21.setOnClickListener(this);
		btn26.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		Intent i;

		switch (v.getId()) {
			case R.id.btnTeslim1:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 1);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim9:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 9);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim10:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 10);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim11:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 11);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim12:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 12);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim13:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 13);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim17:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 17);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim18:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 18);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim20:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 20);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim21:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 21);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				i.putExtra("OpenTab", 1);
				startActivity(i);
				finish();
				break;
			case R.id.btnTeslim26:
				i = new Intent(ShowEndpointStatus.this, DistributionMissionFeedBackUi.class);
				i.putExtra("endpointstatusid", 26);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
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
