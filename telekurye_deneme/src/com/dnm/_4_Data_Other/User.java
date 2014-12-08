package com.dnm._4_Data_Other;

import java.util.Date;

public class User<T> {
	private int		Id;
	private String	WebPassword;
	private int		UserId_Create;
	private Date	CreateDate;
	private int		UserId_Modify;
	private Date	ModifiedDate;
	private T		Person;
	private String	UserName;
	private Boolean	NeedsDatabaseReset;
	private int		DeviceId;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getWebPassword() {
		return WebPassword;
	}

	public void setWebPassword(String webPassword) {
		WebPassword = webPassword;
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

	public T getPerson() {
		return Person;
	}

	public void setPerson(T person) {
		Person = person;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Boolean getNeedsDatabaseReset() {
		return NeedsDatabaseReset;
	}

	public void setNeedsDatabaseReset(Boolean needsDatabaseReset) {
		NeedsDatabaseReset = needsDatabaseReset;
	}

	public int getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(int deviceId) {
		DeviceId = deviceId;
	}

}
