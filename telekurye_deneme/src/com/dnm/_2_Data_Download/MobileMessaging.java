package com.dnm._2_Data_Download;

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

@DatabaseTable(tableName = "mobilemessaging")
public class MobileMessaging {

	@DatabaseField(id = true) private int						Id;
	@DatabaseField private String								MessageDescription;
	@DatabaseField private String								MessageText;
	@DatabaseField private int									MobileMessagingTypeId;
	@DatabaseField private int									Receiver_UserId;
	@DatabaseField private int									Sender_UserId;
	@DatabaseField private Boolean								IsDeletedByReceiver;
	@DatabaseField private Boolean								IsDeletedBySender;
	@DatabaseField private Boolean								IsRead;
	@DatabaseField private int									UserId_Create;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField private int									UserId_Modify;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;

	public void Insert() {
		try {
			Dao<MobileMessaging, Integer> dataHelper = DatabaseHelper.getDbHelper().getMobileMessagingDataHelper();
			MobileMessaging existenceCheck = dataHelper.queryForId(this.Id);
			if (existenceCheck != null) {
				dataHelper.update(this);
			} else {
				dataHelper.create(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}

	}

	public static SyncRequest<List<MobileMessaging>> GetAllDataForSync() {

		SyncRequest<List<MobileMessaging>> sr = new SyncRequest<List<MobileMessaging>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<MobileMessaging, Integer> dao = DatabaseHelper.getDbHelper().getMobileMessagingDataHelper();

			List<MobileMessaging> data = dao.queryForAll();

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

	public String getMessageDescription() {
		return MessageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		MessageDescription = messageDescription;
	}

	public String getMessageText() {
		return MessageText;
	}

	public void setMessageText(String messageText) {
		MessageText = messageText;
	}

	public int getMobileMessagingTypeId() {
		return MobileMessagingTypeId;
	}

	public void setMobileMessagingTypeId(int mobileMessagingTypeId) {
		MobileMessagingTypeId = mobileMessagingTypeId;
	}

	public int getReceiver_UserId() {
		return Receiver_UserId;
	}

	public void setReceiver_UserId(int receiver_UserId) {
		Receiver_UserId = receiver_UserId;
	}

	public int getSender_UserId() {
		return Sender_UserId;
	}

	public void setSender_UserId(int sender_UserId) {
		Sender_UserId = sender_UserId;
	}

	public Boolean getIsDeletedByReceiver() {
		return IsDeletedByReceiver;
	}

	public void setIsDeletedByReceiver(Boolean isDeletedByReceiver) {
		IsDeletedByReceiver = isDeletedByReceiver;
	}

	public Boolean getIsDeletedBySender() {
		return IsDeletedBySender;
	}

	public void setIsDeletedBySender(Boolean isDeletedBySender) {
		IsDeletedBySender = isDeletedBySender;
	}

	public Boolean getIsRead() {
		return IsRead;
	}

	public void setIsRead(Boolean isRead) {
		IsRead = isRead;
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