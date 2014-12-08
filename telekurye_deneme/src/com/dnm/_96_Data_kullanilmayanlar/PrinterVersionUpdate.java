package com.dnm._96_Data_kullanilmayanlar;

import java.util.Date;

public class PrinterVersionUpdate {

	private int					Id;
	private int					VersionNumber;
	private String				DataFileURL;
	private Date				ReleaseDate;
	private int					UserId_Create;
	private Date				CreateDate;
	private int					UserId_Modify;
	private Date				ModifiedDate;

	public static final String	PREFS_PRINTER_VERSION		= "version_log";
	public static final String	PREFS_PRINTER_LAST_VERSION	= "last_version";

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getVersionNumber() {
		return VersionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		VersionNumber = versionNumber;
	}

	public String getDataFileURL() {
		return DataFileURL;
	}

	public void setDataFileURL(String dataFileURL) {
		DataFileURL = dataFileURL;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
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
