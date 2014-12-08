package com.dnm._97_ApnSettings;

import android.content.ContentValues;

public class ApnValues {

	private String	ID;
	private String	NAME;
	private String	APN;
	private String	PROXY;
	private String	PORT;
	private String	MMSPROXY;
	private String	MMSPORT;
	private String	SERVER;
	private String	USER;
	private String	PASSWORD;
	private String	MMSC;
	private String	MCC;
	private String	MNC;
	private String	NUMERIC;
	private String	AUTH_TYPE;
	private String	TYPE;
	private String	CURRENT;

	public ContentValues getValues() {

		ContentValues values = new ContentValues();

		if (getID() != null)
			values.put("id", getID());
		if (getNAME() != null)
			values.put("name", getNAME());
		if (getAPN() != null)
			values.put("apn", getAPN());
		if (getPROXY() != null)
			values.put("proxy", getPROXY());
		if (getPORT() != null)
			values.put("port", getPORT());
		if (getMMSPROXY() != null)
			values.put("mmsproxy", getMMSPROXY());
		if (getMMSPORT() != null)
			values.put("mmsport", getMMSPORT());
		if (getSERVER() != null)
			values.put("server", getSERVER());
		if (getUSER() != null)
			values.put("user", getUSER());
		if (getPASSWORD() != null)
			values.put("password", getPASSWORD());
		if (getMMSC() != null)
			values.put("mmsc", getMMSC());
		if (getMCC() != null)
			values.put("mcc", getMCC());
		if (getMNC() != null)
			values.put("mnc", getMNC());
		if (getNUMERIC() != null)
			values.put("numeric", getNUMERIC());
		if (getAUTH_TYPE() != null)
			values.put("authtype", getAUTH_TYPE());
		if (getTYPE() != null)
			values.put("type", getTYPE());
		if (getCURRENT() != null)
			values.put("current", getCURRENT());

		return values;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getAPN() {
		return APN;
	}

	public void setAPN(String aPN) {
		APN = aPN;
	}

	public String getPROXY() {
		return PROXY;
	}

	public void setPROXY(String pROXY) {
		PROXY = pROXY;
	}

	public String getPORT() {
		return PORT;
	}

	public void setPORT(String pORT) {
		PORT = pORT;
	}

	public String getMMSPROXY() {
		return MMSPROXY;
	}

	public void setMMSPROXY(String mMSPROXY) {
		MMSPROXY = mMSPROXY;
	}

	public String getMMSPORT() {
		return MMSPORT;
	}

	public void setMMSPORT(String mMSPORT) {
		MMSPORT = mMSPORT;
	}

	public String getSERVER() {
		return SERVER;
	}

	public void setSERVER(String sERVER) {
		SERVER = sERVER;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getMMSC() {
		return MMSC;
	}

	public void setMMSC(String mMSC) {
		MMSC = mMSC;
	}

	public String getMCC() {
		return MCC;
	}

	public void setMCC(String mCC) {
		MCC = mCC;
	}

	public String getMNC() {
		return MNC;
	}

	public void setMNC(String mNC) {
		MNC = mNC;
	}

	public String getNUMERIC() {
		return NUMERIC;
	}

	public void setNUMERIC(String nUMERIC) {
		NUMERIC = nUMERIC;
	}

	public String getAUTH_TYPE() {
		return AUTH_TYPE;
	}

	public void setAUTH_TYPE(String aUTH_TYPE) {
		AUTH_TYPE = aUTH_TYPE;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getCURRENT() {
		return CURRENT;
	}

	public void setCURRENT(String cURRENT) {
		CURRENT = cURRENT;
	}

}
