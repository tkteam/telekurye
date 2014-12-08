package com.dnm._7_TypeTokenClasses;

import java.util.Date;

public class SyncRequest<T> {

	private Date	LastSyncDate;
	private Date	EndSyncDate;
	private T		TypedObjects;

	public Date getLastSyncDate() {
		return LastSyncDate;
	}

	public void setLastSyncDate(Date lastSyncDate) {
		LastSyncDate = lastSyncDate;
	}

	public Date getEndSyncDate() {
		return EndSyncDate;
	}

	public void setEndSyncDate(Date endSyncDate) {
		EndSyncDate = endSyncDate;
	}

	public T getTypedObjects() {
		return TypedObjects;
	}

	public void setTypedObjects(T typedObjects) {
		TypedObjects = typedObjects;
	}

}