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

@DatabaseTable(tableName = "LeafletFeedBackData")
public class LeafletFeedBackData {

	@DatabaseField(generatedId = true) private int				Id;
	@DatabaseField private Integer								UserDailyLeafletLocationId;
	@DatabaseField private String								LeafletLocationName;
	@DatabaseField private Integer								UserDailyLeafletId;
	@DatabaseField private float								Latitude;
	@DatabaseField private float								Longitude;
	@DatabaseField private int									Accuracy;
	@DatabaseField private int									Floor;
	@DatabaseField private int									Capacity;
	@DatabaseField private int									Quantity;
	@DatabaseField private int									BuildingTypeId;
	@DatabaseField private int									UserId_Create;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField private int									UserId_Modify;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;
	@DatabaseField private String								BuildingName;

	public void Insert() {
		try {
			Dao<LeafletFeedBackData, Integer> locationinsert = (DatabaseHelper.getDbHelper()).getLeafletFeedBackDataDataHelper();
			LeafletFeedBackData existenceCheck = locationinsert.queryForId(this.Id);

			if (existenceCheck != null) {
				locationinsert.update(this);
			} else {
				locationinsert.create(this);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public static SyncRequest<List<LeafletFeedBackData>> GetAllDataForSync() {

		SyncRequest<List<LeafletFeedBackData>> sr = new SyncRequest<List<LeafletFeedBackData>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<LeafletFeedBackData, Integer> dao = DatabaseHelper.getDbHelper().getLeafletFeedBackDataDataHelper();

			List<LeafletFeedBackData> data = dao.queryForAll();

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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Integer getUserDailyLeafletLocationId() {
		return UserDailyLeafletLocationId;
	}

	public void setUserDailyLeafletLocationId(Integer userDailyLeafletLocationId) {
		UserDailyLeafletLocationId = userDailyLeafletLocationId;
	}

	public String getLeafletLocationName() {
		return LeafletLocationName;
	}

	public void setLeafletLocationName(String leafletLocationName) {
		LeafletLocationName = leafletLocationName;
	}

	public Integer getUserDailyLeafletId() {
		return UserDailyLeafletId;
	}

	public void setUserDailyLeafletId(Integer userDailyLeafletId) {
		UserDailyLeafletId = userDailyLeafletId;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void setLatitude(float latitude) {
		Latitude = latitude;
	}

	public float getLongitude() {
		return Longitude;
	}

	public void setLongitude(float longitude) {
		Longitude = longitude;
	}

	public int getAccuracy() {
		return Accuracy;
	}

	public void setAccuracy(int accuracy) {
		Accuracy = accuracy;
	}

	public int getFloor() {
		return Floor;
	}

	public void setFloor(int floor) {
		Floor = floor;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getBuildingTypeId() {
		return BuildingTypeId;
	}

	public void setBuildingTypeId(int buildingTypeId) {
		BuildingTypeId = buildingTypeId;
	}

	public int getUserId_Create() {
		return UserId_Create;
	}

	public void setUserId_Create(int userId_Create) {
		UserId_Create = userId_Create;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public int getUserId_Modify() {
		return UserId_Modify;
	}

	public void setUserId_Modify(int userId_Modify) {
		UserId_Modify = userId_Modify;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public String getBuildingName() {
		return BuildingName;
	}

	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}

}
