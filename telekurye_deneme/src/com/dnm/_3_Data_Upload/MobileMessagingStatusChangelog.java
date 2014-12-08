package com.dnm._3_Data_Upload;

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

@DatabaseTable(tableName = "mobilemessagingstatuschangelog")
public class MobileMessagingStatusChangelog {

	@DatabaseField(generatedId = true) private int				Id;
	@DatabaseField private int									MobileMessagingId;
	@DatabaseField private int									MobileMessagingStatusTypeId;
	@DatabaseField private int									UserId_Create;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField private int									UserId_Modify;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;

	public void Insert() {
		try {
			Dao<MobileMessagingStatusChangelog, Integer> locationinsert = DatabaseHelper.getDbHelper().getMobileMessagingStatusChangelogDataHelper();

			MobileMessagingStatusChangelog existenceCheck = locationinsert.queryForId(this.Id);

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

	public static SyncRequest<List<MobileMessagingStatusChangelog>> GetAllDataForSync() {

		SyncRequest<List<MobileMessagingStatusChangelog>> sr = new SyncRequest<List<MobileMessagingStatusChangelog>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<MobileMessagingStatusChangelog, Integer> dao = DatabaseHelper.getDbHelper().getMobileMessagingStatusChangelogDataHelper();

			List<MobileMessagingStatusChangelog> data = dao.queryForAll();

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

	public int getMobileMessagingId() {
		return MobileMessagingId;
	}

	public void setMobileMessagingId(int mobileMessagingId) {
		MobileMessagingId = mobileMessagingId;
	}

	public int getMobileMessagingStatusTypeId() {
		return MobileMessagingStatusTypeId;
	}

	public void setMobileMessagingStatusTypeId(int mobileMessagingStatusTypeId) {
		MobileMessagingStatusTypeId = mobileMessagingStatusTypeId;
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

}