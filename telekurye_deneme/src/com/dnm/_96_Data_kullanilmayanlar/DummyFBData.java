package com.dnm._96_Data_kullanilmayanlar;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "DummyDFData")
public class DummyFBData {

	@DatabaseField(generatedId = true) private int				Id;
	@DatabaseField private float								Latitude;
	@DatabaseField private float								Longitude;
	@DatabaseField(format = "yyyy-MM-dd HH:mm:ss") private Date	Createdate;
	@DatabaseField private String								Relationname;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void setLatitude(float latitude) {
		Latitude = latitude;
	}

	public float getLongitude() {
		return Longitude;
	}

	public void setLongitude(float longitude) {
		Longitude = longitude;
	}

	public Date getCreatedate() {
		return Createdate;
	}

	public void setCreatedate(Date createdate) {
		Createdate = createdate;
	}

	public String getRelationname() {
		return Relationname;
	}

	public void setRelationname(String relationname) {
		Relationname = relationname;
	}

}
