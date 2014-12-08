package com.telekurye.camera;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.splunk.mint.Mint;
import com.telekurye.camera.ScalingUtilities.ScalingLogic;
import com.telekurye.ui2.R;
import com.telekurye.utils.Info;

public class CapturePhoto {

	public static final int			SHOT_IMAGE				= 1;
	public static final int			PICK_IMAGE				= 2;

	private static final String		JPEG_FILE_PREFIX		= "IMG_";
	private static final String		JPEG_FILE_SUFFIX		= ".jpg";

	private AlbumStorageDirFactory	mAlbumStorageDirFactory	= null;
	private Activity				activity;
	private String					mCurrentPhotoPath;
	private int						actionCode;

	public File						f;

	public CapturePhoto(Activity activity) {

		this.activity = activity;

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
			mAlbumStorageDirFactory = new FroyoAlbumDirFactory();
		} else {
			mAlbumStorageDirFactory = new BaseAlbumDirFactory();
		}
	}

	public int getActionCode() {
		return this.actionCode;
	}

	public void dispatchTakePictureIntent(int actionCode, int requestCode) {
		Intent takePictureIntent = null;

		this.actionCode = actionCode;

		switch (actionCode) {
			case SHOT_IMAGE:
				File f = null;
				takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				try {
					f = setUpPhotoFile();
					mCurrentPhotoPath = f.getAbsolutePath();
					takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
				} catch (IOException e) {
					e.printStackTrace();
					Mint.logException(e);
					f = null;
					mCurrentPhotoPath = null;
				}
				break;

			case PICK_IMAGE:
				takePictureIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				break;
			default:
				break;
		} // switch /storage/sdcard0/Pictures/sefagurel/IMG_20141016_160714_-959195403.jpg

		if (takePictureIntent != null) {
			activity.startActivityForResult(takePictureIntent, requestCode);
		}

	}

	public void handleCameraPhoto(ImageView imageView) throws IOException {
		if (mCurrentPhotoPath != null) {

			/* Decode the JPEG file into a Bitmap */
			BitmapFactory.Options bmOptions = new BitmapFactory.Options();

			Bitmap bmp = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
			Bitmap scaledBitmap = ScalingUtilities.createScaledBitmap(bmp, bmp.getWidth() / 3, bmp.getHeight() / 3, ScalingLogic.FIT, ScalingUtilities.getFileOrientation(mCurrentPhotoPath));
			bmp.recycle();

			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			scaledBitmap.compress(Bitmap.CompressFormat.JPEG, Info.SCALED_PHOTO_PERCENT, bytes);

			File f = new File(mCurrentPhotoPath);
			f.createNewFile();
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(bytes.toByteArray());
			fo.close();
			scaledBitmap.recycle();
			Bitmap bmp2 = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

			/* Associate the Bitmap to the ImageView */
			imageView.setScaleType(ScaleType.FIT_XY);
			imageView.setImageBitmap(bmp2);
			imageView.setVisibility(View.VISIBLE);
			imageView.setTag(f.getName());

			galleryAddPic();
			mCurrentPhotoPath = null;
		}
	}

	public void handleMediaPhoto(Uri targetUri, ImageView imageView) {

		try {
			Bitmap bmp = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), targetUri);
			// Bitmap scaledBitmap = ScalingUtilities.createScaledBitmap(bmp, imageView.getWidth(), imageView.getHeight(), ScalingLogic.CROP, ScalingUtilities.getGalleryOrientation(activity,
			// targetUri));
			// bmp.recycle();

			/* Associate the Bitmap to the ImageView */
			imageView.setScaleType(ScaleType.FIT_XY);
			imageView.setImageBitmap(bmp);
			imageView.setVisibility(View.VISIBLE);
			imageView.setTag(mCurrentPhotoPath);
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	// private void setPic() {
	//
	// /* There isn't enough memory to open up more than a couple camera photos */
	// /* So pre-scale the target bitmap into which the file is decoded */
	//
	// /* Get the size of the ImageView */
	// int targetW = imageView.getWidth();
	// int targetH = imageView.getHeight();
	//
	// /* Get the size of the image */
	// BitmapFactory.Options bmOptions = new BitmapFactory.Options();
	// bmOptions.inJustDecodeBounds = true;
	// BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
	// int photoW = bmOptions.outWidth;
	// int photoH = bmOptions.outHeight;
	//
	// /* Figure out which way needs to be reduced less */
	// int scaleFactor = 1;
	// if ((targetW > 0) || (targetH > 0)) {
	// scaleFactor = Math.min(photoW / targetW, photoH / targetH);
	// }
	//
	// /* Set bitmap options to scale the image decode target */
	// bmOptions.inJustDecodeBounds = false;
	// bmOptions.inSampleSize = scaleFactor;
	// bmOptions.inPurgeable = true;
	//
	// /* Decode the JPEG file into a Bitmap */
	// Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
	//
	// /* Associate the Bitmap to the ImageView */
	// imageView.setImageBitmap(bitmap);
	// imageView.setVisibility(View.VISIBLE);
	// }

	private void galleryAddPic() {
		Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
		f = new File(mCurrentPhotoPath);
		Uri contentUri = Uri.fromFile(f);
		mediaScanIntent.setData(contentUri);
		activity.sendBroadcast(mediaScanIntent);
	}

	private File setUpPhotoFile() throws IOException {
		f = createImageFile();
		mCurrentPhotoPath = f.getAbsolutePath();
		return f;
	}

	private File createImageFile() throws IOException {
		// Create an image file name
		// String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		// String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_"; //UUID.randomUUID().toString()
		String imageFileName = UUID.randomUUID().toString() + JPEG_FILE_SUFFIX;

		File albumF = getAlbumDir();

		File tmpDirFile = albumF;
		if (tmpDirFile == null) {
			String tmpDir = System.getProperty("java.io.tmpdir", ".");
			tmpDirFile = new File(tmpDir);
		}
		File result;
		do {
			result = new File(tmpDirFile, imageFileName);
		} while (!result.createNewFile());

		// File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
		return result;
	}

	private String getAlbumName() {
		return activity.getString(R.string.album_name);
	}

	private File getAlbumDir() {
		File storageDir = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());
			if (storageDir != null) {
				if (!storageDir.mkdirs()) {
					if (!storageDir.exists()) {
						Log.d("CameraSample", "failed to create directory");
						return null;
					}
				}
			}
		} else {
			Log.v(activity.getString(R.string.app_name), "External storage is not mounted READ/WRITE.");
		}
		return storageDir;
	}

}
