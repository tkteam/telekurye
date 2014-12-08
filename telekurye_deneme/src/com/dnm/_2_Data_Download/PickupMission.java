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

@DatabaseTable(tableName = "PickupMission")
public class PickupMission {

	@DatabaseField(id = true) private int						Id;
	@DatabaseField private String								Material;
	@DatabaseField private int									QuantityPerPackage;
	@DatabaseField private int									PickUpQuantity;
	@DatabaseField private int									UserId_Create;
	@DatabaseField private int									UserId_Modify;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField private String								AddressText;
	@DatabaseField private String								MissionDescription;
	@DatabaseField private double								Latitude;
	@DatabaseField private double								Longitude;
	@DatabaseField private int									CourierId;
	@DatabaseField private int									WorkOrderId;
	@DatabaseField private int									RawMaterialId;
	@DatabaseField private int									WareHouseId;
	@DatabaseField private String								Barcodes;
	@DatabaseField private Integer								ParsingLevelLocationTypeId;
	@DatabaseField private Integer								PickUpFeedBackStatusId;
	@DatabaseField private Integer								PickupMissionStatusId;
	@DatabaseField private String								WorkerDepartmentName;
	@DatabaseField private String								WorkerNameSurname;
	@DatabaseField private String								WorkerPhone;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	StartTime;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	EndTime;
	@DatabaseField private int									TotalWeight;
	@DatabaseField private String								CompanyTitle;

	public void Insert() {

		try {
			Dao<PickupMission, Integer> pmissionInsert = (DatabaseHelper.getDbHelper()).getPickupMissionDataHelper();
			PickupMission existenceCheck = pmissionInsert.queryForId(this.Id);

			if (existenceCheck != null) {
				pmissionInsert.update(this);
			} else {
				pmissionInsert.create(this);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	public static SyncRequest<List<PickupMission>> GetAllDataForSync() {

		SyncRequest<List<PickupMission>> sr = new SyncRequest<List<PickupMission>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<PickupMission, Integer> dao = DatabaseHelper.getDbHelper().getPickupMissionDataHelper();

			List<PickupMission> data = dao.queryForAll();

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

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public int getQuantityPerPackage() {
		return QuantityPerPackage;
	}

	public void setQuantityPerPackage(int quantityPerPackage) {
		QuantityPerPackage = quantityPerPackage;
	}

	public int getPickUpQuantity() {
		return PickUpQuantity;
	}

	public void setPickUpQuantity(int pickUpQuantity) {
		PickUpQuantity = pickUpQuantity;
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

	public String getAddressText() {
		return AddressText;
	}

	public void setAddressText(String addressText) {
		AddressText = addressText;
	}

	public String getMissionDescription() {
		return MissionDescription;
	}

	public void setMissionDescription(String missionDescription) {
		MissionDescription = missionDescription;
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

	public int getCourierId() {
		return CourierId;
	}

	public void setCourierId(int courierId) {
		CourierId = courierId;
	}

	public int getWorkOrderId() {
		return WorkOrderId;
	}

	public void setWorkOrderId(int workOrderId) {
		WorkOrderId = workOrderId;
	}

	public int getRawMaterialId() {
		return RawMaterialId;
	}

	public void setRawMaterialId(int rawMaterialId) {
		RawMaterialId = rawMaterialId;
	}

	public int getWareHouseId() {
		return WareHouseId;
	}

	public void setWareHouseId(int wareHouseId) {
		WareHouseId = wareHouseId;
	}

	public String getBarcodes() {
		return Barcodes;
	}

	public void setBarcodes(String barcodes) {
		Barcodes = barcodes;
	}

	public Integer getParsingLevelLocationTypeId() {
		return ParsingLevelLocationTypeId;
	}

	public void setParsingLevelLocationTypeId(Integer parsingLevelLocationTypeId) {
		ParsingLevelLocationTypeId = parsingLevelLocationTypeId;
	}

	public Integer getPickUpFeedBackStatusId() {
		return PickUpFeedBackStatusId;
	}

	public void setPickUpFeedBackStatusId(Integer pickUpFeedBackStatusId) {
		PickUpFeedBackStatusId = pickUpFeedBackStatusId;
	}

	public Integer getPickupMissionStatusId() {
		return PickupMissionStatusId;
	}

	public void setPickupMissionStatusId(Integer pickupMissionStatusId) {
		PickupMissionStatusId = pickupMissionStatusId;
	}

	public String getWorkerDepartmentName() {
		return WorkerDepartmentName;
	}

	public void setWorkerDepartmentName(String workerDepartmentName) {
		WorkerDepartmentName = workerDepartmentName;
	}

	public String getWorkerNameSurname() {
		return WorkerNameSurname;
	}

	public void setWorkerNameSurname(String workerNameSurname) {
		WorkerNameSurname = workerNameSurname;
	}

	public String getWorkerPhone() {
		return WorkerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		WorkerPhone = workerPhone;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public int getTotalWeight() {
		return TotalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		TotalWeight = totalWeight;
	}

	public String getCompanyTitle() {
		return CompanyTitle;
	}

	public void setCompanyTitle(String companyTitle) {
		CompanyTitle = companyTitle;
	}

}
