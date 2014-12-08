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

@DatabaseTable
public class DistributionMissionFeedBackPhoto {

	@DatabaseField(generatedId = true) private int				Id;
	@DatabaseField private String								Photo;
	@DatabaseField private int									UserId_Create;
	@DatabaseField private int									UserId_Modify;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField private int									DmissionFBId;
	@DatabaseField private Boolean								AlwaysUploadPhoto;
	@DatabaseField private Double								OrientationValue;

	public void Insert() {
		try {
			Dao<DistributionMissionFeedBackPhoto, Integer> pickupOrderinsert = (DatabaseHelper.getDbHelper()).getDistributionMissionFeedbackPhotoDataHelper();
			DistributionMissionFeedBackPhoto existenceCheck = pickupOrderinsert.queryForId(this.Id);

			if (existenceCheck != null) {
				pickupOrderinsert.update(this);
			} else {
				pickupOrderinsert.create(this);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public static SyncRequest<List<DistributionMissionFeedBackPhoto>> GetAllDataForSync() {

		SyncRequest<List<DistributionMissionFeedBackPhoto>> sr = new SyncRequest<List<DistributionMissionFeedBackPhoto>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<DistributionMissionFeedBackPhoto, Integer> dao = DatabaseHelper.getDbHelper().getDistributionMissionFeedbackPhotoDataHelper();

			List<DistributionMissionFeedBackPhoto> data = dao.queryForAll();

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

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
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

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public int getDmissionFBId() {
		return DmissionFBId;
	}

	public void setDmissionFBId(int dmissionFBId) {
		DmissionFBId = dmissionFBId;
	}

	public Boolean getAlwaysUploadPhoto() {
		return AlwaysUploadPhoto;
	}

	public void setAlwaysUploadPhoto(Boolean alwaysUploadPhoto) {
		AlwaysUploadPhoto = alwaysUploadPhoto;
	}

	public Double getOrientationValue() {
		return OrientationValue;
	}

	public void setOrientationValue(Double orientationValue) {
		OrientationValue = orientationValue;
	}

}
