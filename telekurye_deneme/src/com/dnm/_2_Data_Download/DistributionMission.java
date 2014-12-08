package com.dnm._2_Data_Download;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.dnm._1_Database.DatabaseHelper;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.splunk.mint.Mint;

@DatabaseTable(tableName = "distrubutionmisyon")
public class DistributionMission implements Parcelable, Comparator<DistributionMission> {

	@DatabaseField(id = true) private int						Id;
	@DatabaseField private int									CourierId;
	@DatabaseField private Date									OperationalDate;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	CreateDate;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	ModifiedDate;
	@DatabaseField private int									PageIndex;
	@DatabaseField private String								AdressText;
	@DatabaseField private String								Name;
	@DatabaseField private String								Surname;
	@DatabaseField private int									SignaturePageIndex;
	@DatabaseField private Double								Latitute;
	@DatabaseField private Double								Longitude;
	@DatabaseField private int									ApprovementStatus;
	@DatabaseField private String								Barcode;
	@DatabaseField private String								ProductName;
	@DatabaseField private int									WaybillDetailToReceiver;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	AppoinmentDate;
	@DatabaseField private int									CityId;
	@DatabaseField private int									CountyId;
	@DatabaseField private int									DistrictId;
	@DatabaseField private int									StreetId;
	@DatabaseField private int									PersonId;
	@DatabaseField private String								City;
	@DatabaseField private String								County;
	@DatabaseField private String								District;
	@DatabaseField private String								Street;
	@DatabaseField private int									WorkOrderId;
	@DatabaseField private int									ParsingLevelLocationTypeId;
	@DatabaseField private Boolean								Freeze;
	@DatabaseField private String								TransferInfo;
	@DatabaseField private Boolean								ReturnHome;
	@DatabaseField private int									BundleId;
	@DatabaseField private String								BundleBarcode;
	@DatabaseField private int									AddressId;
	@DatabaseField private Boolean								AlwaysUploadPhoto;
	@DatabaseField private String								ExtraLogics;
	@DatabaseField private int									ProductId;
	@DatabaseField private int									UniqueCode;
	@DatabaseField private String								CompanyName;
	@DatabaseField private String								AddressInfo;
	@DatabaseField private String								GSMNo;
	@DatabaseField private String								Arguments;
	@DatabaseField private Float								x1;
	@DatabaseField private Float								y1;
	@DatabaseField private Float								x2;
	@DatabaseField private Float								y2;
	@DatabaseField private int									LastEndPointStatusId;
	private List<TransferInfo>									TransferInformation;		// bu liste tek bir stringe çevrilip "TransferInfo" kolonuna setlenecek

	public float												distanceCalculated;

	public void Insert() {

		try {
			Dao<DistributionMission, Integer> pmissionInsert = DatabaseHelper.getDbHelper().getDistributionMissionDataHelper();
			DistributionMission existenceCheck = pmissionInsert.queryForId(this.Id);

			if (existenceCheck != null) {
				pmissionInsert.update(this);
			} else {
				pmissionInsert.create(this);
			}

		} catch (SQLException e) {
			Mint.logException(e);
			e.printStackTrace();
		}
	}

	public static SyncRequest<List<DistributionMission>> GetAllDataForSync() {

		SyncRequest<List<DistributionMission>> sr = new SyncRequest<List<DistributionMission>>();

		try {

			String startDateString = "2014-10-03 11:26:36";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate;
			startDate = df.parse(startDateString);
			sr.setLastSyncDate(startDate);
			sr.setEndSyncDate(startDate);

			Dao<DistributionMission, Integer> dao = DatabaseHelper.getDbHelper().getDistributionMissionDataHelper();

			List<DistributionMission> data = dao.queryForAll();

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

	public int getCourierId() {
		return CourierId;
	}

	public void setCourierId(int courierId) {
		CourierId = courierId;
	}

	public Date getOperationalDate() {
		return OperationalDate;
	}

	public void setOperationalDate(Date operationalDate) {
		OperationalDate = operationalDate;
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

	public int getPageIndex() {
		return PageIndex;
	}

	public void setPageIndex(int pageIndex) {
		PageIndex = pageIndex;
	}

	public String getAdressText() {
		return AdressText;
	}

	public void setAdressText(String adressText) {
		AdressText = adressText;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getSignaturePageIndex() {
		return SignaturePageIndex;
	}

	public void setSignaturePageIndex(int signaturePageIndex) {
		SignaturePageIndex = signaturePageIndex;
	}

	public Double getLatitute() {
		return Latitute;
	}

	public void setLatitute(Double latitute) {
		Latitute = latitute;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public int getApprovementStatus() {
		return ApprovementStatus;
	}

	public void setApprovementStatus(int approvementStatus) {
		ApprovementStatus = approvementStatus;
	}

	public String getBarcode() {
		return Barcode;
	}

	public void setBarcode(String barcode) {
		Barcode = barcode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getWaybillDetailToReceiver() {
		return WaybillDetailToReceiver;
	}

	public void setWaybillDetailToReceiver(int waybillDetailToReceiver) {
		WaybillDetailToReceiver = waybillDetailToReceiver;
	}

	public Date getAppoinmentDate() {
		return AppoinmentDate;
	}

	public void setAppoinmentDate(Date appoinmentDate) {
		AppoinmentDate = appoinmentDate;
	}

	public int getCityId() {
		return CityId;
	}

	public void setCityId(int cityId) {
		CityId = cityId;
	}

	public int getCountyId() {
		return CountyId;
	}

	public void setCountyId(int countyId) {
		CountyId = countyId;
	}

	public int getDistrictId() {
		return DistrictId;
	}

	public void setDistrictId(int districtId) {
		DistrictId = districtId;
	}

	public int getStreetId() {
		return StreetId;
	}

	public void setStreetId(int streetId) {
		StreetId = streetId;
	}

	public int getPersonId() {
		return PersonId;
	}

	public void setPersonId(int personId) {
		PersonId = personId;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCounty() {
		return County;
	}

	public void setCounty(String county) {
		County = county;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getWorkOrderId() {
		return WorkOrderId;
	}

	public void setWorkOrderId(int workOrderId) {
		WorkOrderId = workOrderId;
	}

	public int getParsingLevelLocationTypeId() {
		return ParsingLevelLocationTypeId;
	}

	public void setParsingLevelLocationTypeId(int parsingLevelLocationTypeId) {
		ParsingLevelLocationTypeId = parsingLevelLocationTypeId;
	}

	public Boolean getFreeze() {
		return Freeze;
	}

	public void setFreeze(Boolean freeze) {
		Freeze = freeze;
	}

	public String getTransferInfo() {
		return TransferInfo;
	}

	public void setTransferInfo(String transferInfo) {
		TransferInfo = transferInfo;
	}

	public Boolean getReturnHome() {
		return ReturnHome;
	}

	public void setReturnHome(Boolean returnHome) {
		ReturnHome = returnHome;
	}

	public int getBundleId() {
		return BundleId;
	}

	public void setBundleId(int bundleId) {
		BundleId = bundleId;
	}

	public String getBundleBarcode() {
		return BundleBarcode;
	}

	public void setBundleBarcode(String bundleBarcode) {
		BundleBarcode = bundleBarcode;
	}

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public Boolean getAlwaysUploadPhoto() {
		return AlwaysUploadPhoto;
	}

	public void setAlwaysUploadPhoto(Boolean alwaysUploadPhoto) {
		AlwaysUploadPhoto = alwaysUploadPhoto;
	}

	public String getExtraLogics() {
		return ExtraLogics;
	}

	public void setExtraLogics(String extraLogics) {
		ExtraLogics = extraLogics;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getUniqueCode() {
		return UniqueCode;
	}

	public void setUniqueCode(int uniqueCode) {
		UniqueCode = uniqueCode;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getAddressInfo() {
		return AddressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		AddressInfo = addressInfo;
	}

	public String getGSMNo() {
		return GSMNo;
	}

	public void setGSMNo(String gSMNo) {
		GSMNo = gSMNo;
	}

	public String getArguments() {
		return Arguments;
	}

	public void setArguments(String arguments) {
		Arguments = arguments;
	}

	public Float getX1() {
		return x1;
	}

	public void setX1(Float x1) {
		this.x1 = x1;
	}

	public Float getY1() {
		return y1;
	}

	public void setY1(Float y1) {
		this.y1 = y1;
	}

	public Float getX2() {
		return x2;
	}

	public void setX2(Float x2) {
		this.x2 = x2;
	}

	public Float getY2() {
		return y2;
	}

	public void setY2(Float y2) {
		this.y2 = y2;
	}

	public int getLastEndPointStatusId() {
		return LastEndPointStatusId;
	}

	public void setLastEndPointStatusId(int lastEndPointStatusId) {
		LastEndPointStatusId = lastEndPointStatusId;
	}

	public List<TransferInfo> getTransferInformation() {
		return TransferInformation;
	}

	public void setTransferInformation(List<TransferInfo> transferInformation) {
		TransferInformation = transferInformation;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(DistributionMission lhs, DistributionMission rhs) {
		return lhs.getUniqueCode() - rhs.getUniqueCode();
	}

}
