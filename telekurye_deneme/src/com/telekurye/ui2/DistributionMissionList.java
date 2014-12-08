package com.telekurye.ui2;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.dnm._2_Data_Download.DistributionMission;
import com.dnm._3_Data_Upload.DistributionMissionFeedBack;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.telekurye.utils.LiveData;

public class DistributionMissionList extends MasterActivity {

	ListView						distributionMissionList;
	Button							btnGeri;
	DistributionMissionListAdapter	disadpt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout._3_distribution_mission_layout);
		distributionMissionList = (ListView) findViewById(R.id.distribution_mission_list);
		btnGeri = (Button) findViewById(R.id.button1_geri);

		btnGeri.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i1 = new Intent(DistributionMissionList.this, MainMenu.class);
				startActivity(i1);

			}
		});

		distributionMissionList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

				Intent i = new Intent(DistributionMissionList.this, DistributionMissionFeedBackUi.class);
				i.putExtra("DistributionMissionID", LiveData.DistributionMission.getTargetObject().get(position).getId());
				i.putExtra("endpointstatusid", -1);
				i.putExtra("feedbackrelationid", -1);
				i.putExtra("OpenTab", 0);
				startActivity(i);

			}
		});

		distributionMissionList.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {

				return true;
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();

		// ******************************************************* bu kýsým orj. uyg. olmayacak
		// final Login lg = new Login();
		//
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// lg.sendDatabaseRecord();
		//
		// }
		// }).start();
		// *******************************************************

		DistributionMissionFeedBack dmf = new DistributionMissionFeedBack();
		SyncRequest<List<DistributionMissionFeedBack>> kayitlar = dmf.GetAllDataForSync();

		for (int i = 0; i < kayitlar.getTypedObjects().size(); i++) {
			for (int j = 0; j < LiveData.DistributionMission.getTargetObject().size(); j++) {

				if (kayitlar.getTypedObjects().get(i).getUserDailyDistributionId() == LiveData.DistributionMission.getTargetObject().get(j).getId()) {
					LiveData.DistributionMission.getTargetObject().remove(j);
				}

			}
		}

		disadpt = new DistributionMissionListAdapter(DistributionMissionList.this, LiveData.DistributionMission.getTargetObject());
		distributionMissionList.setAdapter(disadpt);
		disadpt.notifyDataSetChanged();

	}

	@Override
	public void onBackPressed() {
	}

}

class DistributionMissionListAdapter extends BaseAdapter {
	private Context							mContext;
	private ArrayList<DistributionMission>	distributionMissions;

	public DistributionMissionListAdapter(Context c, ArrayList<DistributionMission> targetObject) {

		this.mContext = c;
		this.distributionMissions = targetObject;

	}

	public class Holder {

		TextView	txt_name;
		TextView	txt_adres;
		TextView	txt_code;

	}

	public View getView(int pos, View child, ViewGroup parent) {

		Holder mHolder;
		LayoutInflater layoutInflater;
		if (child == null) {
			layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			mHolder = new Holder();

			child = layoutInflater.inflate(R.layout._z_distribution_mission_row, null);
			mHolder.txt_name = (TextView) child.findViewById(R.id.dist_name_text);
			mHolder.txt_adres = (TextView) child.findViewById(R.id.dist_adress_text);
			mHolder.txt_code = (TextView) child.findViewById(R.id.dist_unique_code);

			child.setTag(mHolder);
		} else {
			mHolder = (Holder) child.getTag();
		}

		mHolder.txt_name.setText(distributionMissions.get(pos).getName() + " " + distributionMissions.get(pos).getSurname());
		mHolder.txt_adres.setText(distributionMissions.get(pos).getAdressText().toLowerCase());
		mHolder.txt_code.setText("" + distributionMissions.get(pos).getUniqueCode());

		return child;
	}

	public int getCount() {

		return distributionMissions.size();
	}

	public Object getItem(int position) {

		return null;
	}

	public long getItemId(int position) {

		return 0;
	}

}
