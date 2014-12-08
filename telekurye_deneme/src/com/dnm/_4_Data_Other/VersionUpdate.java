package com.dnm._4_Data_Other;

import java.util.Date;

public class VersionUpdate {

	private int		Id;
	private int		CurrentVersion;
	private String	ApkFile;
	private Date	ReleaseDate;
	private Boolean	NeedsUrgentUpdate;
	private Boolean	IsBeforeSync;
	private int		UserId_Create;
	private Date	CreateDate;
	private int		UserId_Modify;
	private Date	ModifiedDate;
	private Boolean	NeedsDatabaseReset;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCurrentVersion() {
		return CurrentVersion;
	}

	public void setCurrentVersion(int currentVersion) {
		CurrentVersion = currentVersion;
	}

	public String getApkFile() {
		return ApkFile;
	}

	public void setApkFile(String apkFile) {
		ApkFile = apkFile;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public Boolean getNeedsUrgentUpdate() {
		return NeedsUrgentUpdate;
	}

	public void setNeedsUrgentUpdate(Boolean needsUrgentUpdate) {
		NeedsUrgentUpdate = needsUrgentUpdate;
	}

	public Boolean getIsBeforeSync() {
		return IsBeforeSync;
	}

	public void setIsBeforeSync(Boolean isBeforeSync) {
		IsBeforeSync = isBeforeSync;
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

	public Boolean getNeedsDatabaseReset() {
		return NeedsDatabaseReset;
	}

	public void setNeedsDatabaseReset(Boolean needsDatabaseReset) {
		NeedsDatabaseReset = needsDatabaseReset;
	}

}
