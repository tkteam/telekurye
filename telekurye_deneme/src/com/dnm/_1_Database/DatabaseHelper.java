package com.dnm._1_Database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dnm._2_Data_Download.DistributionMission;
import com.dnm._2_Data_Download.MobileMessaging;
import com.dnm._2_Data_Download.PickupMission;
import com.dnm._3_Data_Upload.DistributionMissionFeedBack;
import com.dnm._3_Data_Upload.DistributionMissionFeedBackPhoto;
import com.dnm._3_Data_Upload.MobileMessagingStatusChangelog;
import com.dnm._4_Data_Other.Locations;
import com.dnm._96_Data_kullanilmayanlar.LeafletFeedBackData;
import com.dnm._96_Data_kullanilmayanlar.Missions;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.splunk.mint.Mint;
import com.telekurye.ui2.Login;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String		DB_PATH				= "/data/data/com.example.telekurye_deneme/databases/";
	private static final String		DATABASE_NAME		= "telekurye876.db";
	private final Context			myContext;
	private static DatabaseHelper	dbHelper;
	private static final int		DATABASE_VERSION	= 1;
	private static Object			syncObject			= new Object();

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.myContext = context;
		// this.getReadableDatabase();
		// this.getWritableDatabase();
	}

	public static DatabaseHelper getDbHelper() {
		synchronized (syncObject) {
			if (dbHelper == null) {
				dbHelper = new DatabaseHelper(Login.AppContext);
			}
		}
		return dbHelper;
	}

	private Dao<DistributionMission, Integer>				distributionMissionDataHelper				= null;
	private Dao<Missions, Integer>							missionsDataHelper							= null;
	private Dao<MobileMessaging, Integer>					MobileMessagingDataHelper					= null;
	private Dao<PickupMission, Integer>						pickupMissionDataHelper						= null;

	private Dao<Locations, Integer>							locationsDataHelper							= null;
	private Dao<LeafletFeedBackData, Integer>				leafletFeedBackHelper						= null;
	private Dao<DistributionMissionFeedBack, Integer>		distributionMissionFeedbackDataHelper		= null;
	private Dao<MobileMessagingStatusChangelog, Integer>	MobileMessagingStatusChangelogDataHelper	= null;
	private Dao<DistributionMissionFeedBackPhoto, Integer>	distributionMissionFeedbackPhotoDataHelper	= null;

	// private Dao<LeafletFeedBackDataPhotos, Integer> photosDataHelper = null;
	// private Dao<PickUpOrderFeedback, Integer> pickupOrderDataHelper = null;
	// private Dao<PickupOrderFeedbackPhotos, Integer> pickupOrderFeedBackPhotosHelper = null;
	// private Dao<Settings, Integer> settingsDataHelper = null;

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {

			TableUtils.createTable(connectionSource, DistributionMission.class);
			TableUtils.createTable(connectionSource, Missions.class);
			TableUtils.createTable(connectionSource, MobileMessaging.class);
			TableUtils.createTable(connectionSource, PickupMission.class);
			TableUtils.createTable(connectionSource, Locations.class);
			TableUtils.createTable(connectionSource, LeafletFeedBackData.class);
			TableUtils.createTable(connectionSource, DistributionMissionFeedBack.class);
			TableUtils.createTable(connectionSource, MobileMessagingStatusChangelog.class);
			TableUtils.createTable(connectionSource, DistributionMissionFeedBackPhoto.class);
			// TableUtils.createTable(connectionSource, LeafletFeedBackDataPhotos.class);
			// TableUtils.createTable(connectionSource, PickUpOrderFeedback.class);
			// TableUtils.createTable(connectionSource, PickupOrderFeedbackPhotos.class);
			// TableUtils.createTable(connectionSource, Settings.class);

		} catch (java.sql.SQLException e) {
			Mint.logException(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");

			TableUtils.dropTable(connectionSource, DistributionMission.class, true);
			TableUtils.dropTable(connectionSource, Missions.class, true);
			TableUtils.dropTable(connectionSource, MobileMessaging.class, true);
			TableUtils.dropTable(connectionSource, PickupMission.class, true);
			TableUtils.dropTable(connectionSource, Locations.class, true);
			TableUtils.dropTable(connectionSource, LeafletFeedBackData.class, true);
			TableUtils.dropTable(connectionSource, DistributionMissionFeedBack.class, true);
			TableUtils.dropTable(connectionSource, MobileMessagingStatusChangelog.class, true);
			TableUtils.dropTable(connectionSource, DistributionMissionFeedBackPhoto.class, true);

			onCreate(db, connectionSource);
		} catch (java.sql.SQLException e) {
			Mint.logException(e);
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	public Dao<DistributionMission, Integer> getDistributionMissionDataHelper() throws SQLException {
		if (distributionMissionDataHelper == null) {
			distributionMissionDataHelper = getDao(DistributionMission.class);
		}
		return distributionMissionDataHelper;
	}

	public Dao<Missions, Integer> getMissionsDataHelper() throws SQLException {
		if (missionsDataHelper == null) {
			missionsDataHelper = getDao(Missions.class);
		}
		return missionsDataHelper;
	}

	public Dao<MobileMessaging, Integer> getMobileMessagingDataHelper() throws SQLException {
		if (MobileMessagingDataHelper == null) {
			MobileMessagingDataHelper = getDao(MobileMessaging.class);
		}
		return MobileMessagingDataHelper;
	}

	public Dao<PickupMission, Integer> getPickupMissionDataHelper() throws SQLException {
		if (pickupMissionDataHelper == null) {
			pickupMissionDataHelper = getDao(PickupMission.class);
		}
		return pickupMissionDataHelper;
	}

	public Dao<Locations, Integer> getLocationsDataHelper() throws SQLException {
		if (locationsDataHelper == null) {
			locationsDataHelper = getDao(Locations.class);
		}
		return locationsDataHelper;
	}

	public Dao<LeafletFeedBackData, Integer> getLeafletFeedBackDataDataHelper() throws SQLException {
		if (leafletFeedBackHelper == null) {
			leafletFeedBackHelper = getDao(LeafletFeedBackData.class);
		}
		return leafletFeedBackHelper;
	}

	public Dao<DistributionMissionFeedBack, Integer> getDistributionMissionFeedbackDataHelper() throws SQLException {
		if (distributionMissionFeedbackDataHelper == null) {
			distributionMissionFeedbackDataHelper = getDao(DistributionMissionFeedBack.class);
		}
		return distributionMissionFeedbackDataHelper;
	}

	public Dao<MobileMessagingStatusChangelog, Integer> getMobileMessagingStatusChangelogDataHelper() throws SQLException {
		if (MobileMessagingStatusChangelogDataHelper == null) {
			MobileMessagingStatusChangelogDataHelper = getDao(MobileMessagingStatusChangelog.class);
		}
		return MobileMessagingStatusChangelogDataHelper;
	}

	public Dao<DistributionMissionFeedBackPhoto, Integer> getDistributionMissionFeedbackPhotoDataHelper() throws SQLException {
		if (distributionMissionFeedbackPhotoDataHelper == null) {
			distributionMissionFeedbackPhotoDataHelper = getDao(DistributionMissionFeedBackPhoto.class);
		}
		return distributionMissionFeedbackPhotoDataHelper;
	}

	// public Dao<LeafletFeedBackDataPhotos, Integer> getPhotosDataHelper() throws SQLException {
	// if (photosDataHelper == null) {
	// photosDataHelper = getDao(LeafletFeedBackDataPhotos.class);
	// }
	// return photosDataHelper;
	// }
	//
	// public Dao<PickUpOrderFeedback, Integer> getPickupOrderDataHelper() throws SQLException {
	// if (pickupOrderDataHelper == null) {
	// pickupOrderDataHelper = getDao(PickUpOrderFeedback.class);
	// }
	// return pickupOrderDataHelper;
	// }
	//
	//
	// public Dao<PickupOrderFeedbackPhotos, Integer> getPickupOrderFeedBackPhotosHelper() throws SQLException {
	// if (pickupOrderFeedBackPhotosHelper == null) {
	// pickupOrderFeedBackPhotosHelper = getDao(PickupOrderFeedbackPhotos.class);
	// }
	// return pickupOrderFeedBackPhotosHelper;
	// }
	//
	// public Dao<Settings, Integer> getSettingsDataHelper() throws SQLException {
	// if (settingsDataHelper == null) {
	// settingsDataHelper = getDao(Settings.class);
	// }
	// return settingsDataHelper;
	// }
}
