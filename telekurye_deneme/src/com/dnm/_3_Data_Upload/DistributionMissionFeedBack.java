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
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.table.DatabaseTable;
import com.splunk.mint.Mint;

@DatabaseTable
public class DistributionMissionFeedBack {

	@DatabaseField(id = true) private int						Id;
	@DatabaseField private int									EndPointStatusId;
	@DatabaseField private int									UserDailyDistributionId;
	@DatabaseField private double								Latitude;
	@DatabaseField private double								Longitude;
	@DatabaseField private double								Accuracy;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;
	@DatabaseField private int									RelationId;
	@DatabaseField private String								RelationName;
	@DatabaseField private String								RelationPhone;
	@DatabaseField private String								RelationSurname;
	@DatabaseField private int									IdentityTypeId;
	@DatabaseField private String								IdentityNo;
	@DatabaseField private boolean								IsComplete;
	@DatabaseField private Double								ModifiedLatitude;
	@DatabaseField private Double								ModifiedLongitude;
	@DatabaseField private Double								ModifiedAccuracy;
	@DatabaseField private Double								CourierSelectedLatitude;
	@DatabaseField private Double								CourierSelectedLongitude;

	@DatabaseField private int									UserId_Create;
	@DatabaseField private int									UserId_Modify;
	@DatabaseField private boolean								EndDayStatus;
	@DatabaseField private Boolean								GotToStock;

	private List<DistributionMissionFeedBackPhoto>				Photos;

	public void Insert() {
		try {
			Dao<DistributionMissionFeedBack, Integer> pickupOrderinsert = (DatabaseHelper.getDbHelper()).getDistributionMissionFeedbackDataHelper();
			DistributionMissionFeedBack existenceCheck = pickupOrderinsert.queryForId(this.Id);

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

	public void Update() {
		try {
			Dao<DistributionMissionFeedBack, Integer> pickupOrderinsert = (DatabaseHelper.getDbHelper()).getDistributionMissionFeedbackDataHelper();

			pickupOrderinsert.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public static SyncRequest<List<DistributionMissionFeedBack>> GetAllDataForSync() {

		SyncRequest<List<DistributionMissionFeedBack>> sr = new SyncRequest<List<DistributionMissionFeedBack>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<DistributionMissionFeedBack, Integer> dao = DatabaseHelper.getDbHelper().getDistributionMissionFeedbackDataHelper();

			List<DistributionMissionFeedBack> data = dao.queryForAll();

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

	public static int GetRowCount() {
		int count = 0;

		try {
			Dao<DistributionMissionFeedBack, Integer> dao = DatabaseHelper.getDbHelper().getDistributionMissionFeedbackDataHelper();
			count = (int) dao.countOf();
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		return count;
	}

	public static void DeleteRow(int DistributionMissionID) {
		try {

			Dao<DistributionMissionFeedBack, Integer> dao = DatabaseHelper.getDbHelper().getDistributionMissionFeedbackDataHelper();
			DeleteBuilder<DistributionMissionFeedBack, Integer> deleteBuilder = dao.deleteBuilder();
			deleteBuilder.where().eq("UserDailyDistributionId", DistributionMissionID);
			deleteBuilder.delete();
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public static List<DistributionMissionFeedBack> getColumn(String ColumnName) throws SQLException {
		Dao<DistributionMissionFeedBack, Integer> dao = DatabaseHelper.getDbHelper().getDistributionMissionFeedbackDataHelper();
		List<DistributionMissionFeedBack> results = dao.queryBuilder().distinct().selectColumns(ColumnName).query();
		return results;
	}

	public static DistributionMissionFeedBack getRow(int id) {

		DistributionMissionFeedBack dmfb = null;

		try {
			Dao<DistributionMissionFeedBack, Integer> dao = DatabaseHelper.getDbHelper().getDistributionMissionFeedbackDataHelper();
			dmfb = dao.queryForAll().get(id);
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		return dmfb;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getEndPointStatusId() {
		return EndPointStatusId;
	}

	public void setEndPointStatusId(int endPointStatusId) {
		EndPointStatusId = endPointStatusId;
	}

	public int getUserDailyDistributionId() {
		return UserDailyDistributionId;
	}

	public void setUserDailyDistributionId(int userDailyDistributionId) {
		UserDailyDistributionId = userDailyDistributionId;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public double getAccuracy() {
		return Accuracy;
	}

	public void setAccuracy(double accuracy) {
		Accuracy = accuracy;
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

	public int getRelationId() {
		return RelationId;
	}

	public void setRelationId(int relationId) {
		RelationId = relationId;
	}

	public String getRelationName() {
		return RelationName;
	}

	public void setRelationName(String relationName) {
		RelationName = relationName;
	}

	public String getRelationPhone() {
		return RelationPhone;
	}

	public void setRelationPhone(String relationPhone) {
		RelationPhone = relationPhone;
	}

	public String getRelationSurname() {
		return RelationSurname;
	}

	public void setRelationSurname(String relationSurname) {
		RelationSurname = relationSurname;
	}

	public int getIdentityTypeId() {
		return IdentityTypeId;
	}

	public void setIdentityTypeId(int identityTypeId) {
		IdentityTypeId = identityTypeId;
	}

	public String getIdentityNo() {
		return IdentityNo;
	}

	public void setIdentityNo(String identityNo) {
		IdentityNo = identityNo;
	}

	public boolean isIsComplete() {
		return IsComplete;
	}

	public void setIsComplete(boolean isComplete) {
		IsComplete = isComplete;
	}

	public Double getModifiedLatitude() {
		return ModifiedLatitude;
	}

	public void setModifiedLatitude(Double modifiedLatitude) {
		ModifiedLatitude = modifiedLatitude;
	}

	public Double getModifiedLongitude() {
		return ModifiedLongitude;
	}

	public void setModifiedLongitude(Double modifiedLongitude) {
		ModifiedLongitude = modifiedLongitude;
	}

	public Double getModifiedAccuracy() {
		return ModifiedAccuracy;
	}

	public void setModifiedAccuracy(Double modifiedAccuracy) {
		ModifiedAccuracy = modifiedAccuracy;
	}

	public Double getCourierSelectedLatitude() {
		return CourierSelectedLatitude;
	}

	public void setCourierSelectedLatitude(Double courierSelectedLatitude) {
		CourierSelectedLatitude = courierSelectedLatitude;
	}

	public Double getCourierSelectedLongitude() {
		return CourierSelectedLongitude;
	}

	public void setCourierSelectedLongitude(Double courierSelectedLongitude) {
		CourierSelectedLongitude = courierSelectedLongitude;
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

	public boolean isEndDayStatus() {
		return EndDayStatus;
	}

	public void setEndDayStatus(boolean endDayStatus) {
		EndDayStatus = endDayStatus;
	}

	public Boolean getGotToStock() {
		return GotToStock;
	}

	public void setGotToStock(Boolean gotToStock) {
		GotToStock = gotToStock;
	}

	public List<DistributionMissionFeedBackPhoto> getPhotos() {
		return Photos;
	}

	public void setPhotos(List<DistributionMissionFeedBackPhoto> photos) {
		Photos = photos;
	}

}
