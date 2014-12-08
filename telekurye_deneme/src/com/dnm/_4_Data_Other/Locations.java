package com.dnm._4_Data_Other;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.dnm._1_Database.DatabaseHelper;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.splunk.mint.Mint;

@DatabaseTable(tableName = "locations")
public class Locations implements Comparator<Locations> {

	@DatabaseField(generatedId = true) private int				Id;
	@DatabaseField private int									UserId;
	@DatabaseField private Float								Latitude;
	@DatabaseField private Float								Longitude;
	@DatabaseField private int									UserId_Create;
	@DatabaseField private int									UserId_Modify;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;
	@DatabaseField private Float								Accuracy;
	@DatabaseField private Float								Speed;
	@DatabaseField private Long									LocationTime;

	public void Insert() {
		try {
			Dao<Locations, Integer> locationinsert = DatabaseHelper.getDbHelper().getLocationsDataHelper();

			Locations existenceCheck = locationinsert.queryForId(this.Id);

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

	public static SyncRequest<List<Locations>> GetAllDataForSync() {

		SyncRequest<List<Locations>> sr = new SyncRequest<List<Locations>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<Locations, Integer> dao = DatabaseHelper.getDbHelper().getLocationsDataHelper();

			List<Locations> data = dao.queryForAll();

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

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public Float getLatitude() {
		return Latitude;
	}

	public void setLatitude(Float latitude) {
		Latitude = latitude;
	}

	public Float getLongitude() {
		return Longitude;
	}

	public void setLongitude(Float longitude) {
		Longitude = longitude;
	}

	public int getUserId_Create() {
		return UserId_Create;
	}

	public void setUserId_Create(int userId_Create) {
		UserId_Create = userId_Create;
	}

	public int getUserId_Modify() {
		return UserId_Modify;
	}

	public void setUserId_Modify(int userId_Modify) {
		UserId_Modify = userId_Modify;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public Float getAccuracy() {
		return Accuracy;
	}

	public void setAccuracy(Float accuracy) {
		Accuracy = accuracy;
	}

	public Float getSpeed() {
		return Speed;
	}

	public void setSpeed(Float speed) {
		Speed = speed;
	}

	public Long getLocationTime() {
		return LocationTime;
	}

	public void setLocationTime(Long locationTime) {
		LocationTime = locationTime;
	}

	@Override
	public int compare(Locations lhs, Locations rhs) {
		float change1 = lhs.getAccuracy();
		float change2 = rhs.getAccuracy();

		if (change1 < change2)
			return -1;
		if (change1 > change2)
			return 1;

		return 0;
	}

}
