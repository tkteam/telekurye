package com.telekurye.yedek;

import com.dnm._2_Data_Download.DistributionMission;
import com.dnm._2_Data_Download.MobileMessaging;
import com.dnm._2_Data_Download.PickupMission;
import com.dnm._96_Data_kullanilmayanlar.Missions;
import com.splunk.mint.Mint;
import com.telekurye.utils.LiveData;

public class ObjectToDatabase {

	public void setAllData() {
		// setBuildingType();
		// setDistributionMissionFeedbackRelation();
		// setEndPointStatus();
		// setIdentityType();
		setMissions();
		setMobileMessaging();
		// setMobileMessagingStatusType();
		// setMobileMessagingType();
		setPickupMission();
		setDistributionMission();
	}

	public void setDistributionMission() {

		try {
			for (int i = 0; i < LiveData.DistributionMission.getTargetObject().size(); i++) {

				DistributionMission data = LiveData.DistributionMission.getTargetObject().get(i);
				data.Insert();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public void setMissions() {

		try {
			for (int i = 0; i < LiveData.Missions.getTargetObject().size(); i++) {

				Missions data = LiveData.Missions.getTargetObject().get(i);
				data.Insert();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public void setMobileMessaging() {

		try {
			for (int i = 0; i < LiveData.MobileMessaging.getTargetObject().size(); i++) {

				MobileMessaging data = LiveData.MobileMessaging.getTargetObject().get(i);
				data.Insert();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public void setPickupMission() {

		try {
			for (int i = 0; i < LiveData.PickupMission.getTargetObject().size(); i++) {

				PickupMission data = LiveData.PickupMission.getTargetObject().get(i);
				data.Insert();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

}
