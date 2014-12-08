package com.dnm._96_Data_kullanilmayanlar;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dnm._1_Database.DatabaseHelper;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.splunk.mint.Mint;

@DatabaseTable(tableName = "missions")
public class Missions {

	@DatabaseField(id = true) private int						UserDailyLeafletLocationId;
	@DatabaseField private int									AssignedQty;
	@DatabaseField private int									AssignedPartQty;
	@DatabaseField private int									WorkOrderId;
	@DatabaseField private String								Description;
	@DatabaseField private int									UserDailyLeafletId;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	OperationalDate;
	@DatabaseField private int									UserId;
	@DatabaseField private int									LocationPartId;
	@DatabaseField private String								LocationName;
	@DatabaseField private String								SpatialData;
	@DatabaseField private String								Address;
	@DatabaseField private int									LocationId;

	public void Insert() {

		try {
			Dao<Missions, Integer> missionInsert = (DatabaseHelper.getDbHelper()).getMissionsDataHelper();
			Missions existenceCheck = missionInsert.queryForId(this.UserDailyLeafletLocationId);
			if (existenceCheck != null) {
				missionInsert.update(this);
			} else {
				missionInsert.create(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public static SyncRequest<List<Missions>> GetAllDataForSync() {

		SyncRequest<List<Missions>> sr = new SyncRequest<List<Missions>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<Missions, Integer> dao = DatabaseHelper.getDbHelper().getMissionsDataHelper();

			List<Missions> data = dao.queryForAll();

			sr.setTypedObjects(data);

		} catch (SQLException e) {
			e.printStackTrace();
			Mint.logException(e);
		} catch (ParseException e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		return sr;
	}

	public int getUserDailyLeafletLocationId() {
		return UserDailyLeafletLocationId;
	}

	public void setUserDailyLeafletLocationId(int userDailyLeafletLocationId) {
		UserDailyLeafletLocationId = userDailyLeafletLocationId;
	}

	public int getAssignedQty() {
		return AssignedQty;
	}

	public void setAssignedQty(int assignedQty) {
		AssignedQty = assignedQty;
	}

	public int getAssignedPartQty() {
		return AssignedPartQty;
	}

	public void setAssignedPartQty(int assignedPartQty) {
		AssignedPartQty = assignedPartQty;
	}

	public int getWorkOrderId() {
		return WorkOrderId;
	}

	public void setWorkOrderId(int workOrderId) {
		WorkOrderId = workOrderId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getUserDailyLeafletId() {
		return UserDailyLeafletId;
	}

	public void setUserDailyLeafletId(int userDailyLeafletId) {
		UserDailyLeafletId = userDailyLeafletId;
	}

	public Date getOperationalDate() {
		return OperationalDate;
	}

	public void setOperationalDate(Date operationalDate) {
		OperationalDate = operationalDate;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getLocationPartId() {
		return LocationPartId;
	}

	public void setLocationPartId(int locationPartId) {
		LocationPartId = locationPartId;
	}

	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	public String getSpatialData() {
		return SpatialData;
	}

	public void setSpatialData(String spatialData) {
		SpatialData = spatialData;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getLocationId() {
		return LocationId;
	}

	public void setLocationId(int locationId) {
		LocationId = locationId;
	}

}
