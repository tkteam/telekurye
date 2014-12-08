package com.telekurye.camera;

import java.io.File;

public final class BaseAlbumDirFactory extends AlbumStorageDirFactory {

	@Override
	public File getAlbumStorageDir(String albumName) {
		// return new File(Environment.getExternalStorageDirectory() + CAMERA_DIR + albumName);
		return new File("/storage/sdcard0/" + albumName);
	}
}
