package com.dnm._2_Data_Download;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "TransferInfo")
public class TransferInfo {
	@DatabaseField(id = true) private int	Id;
	@DatabaseField private String			DocumentName;
	@DatabaseField private Integer			TransferDirection;
	@DatabaseField private String			Description;

	public String getDocumentName() {
		return DocumentName;
	}

	public void setDocumentName(String documentName) {
		DocumentName = documentName;
	}

	public Integer getTransferDirection() {
		return TransferDirection;
	}

	public void setTransferDirection(Integer transferDirection) {
		TransferDirection = transferDirection;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
