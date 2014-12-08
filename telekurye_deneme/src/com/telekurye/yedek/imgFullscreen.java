//package com.telekurye.yedek;
//
//import com.example.telekurye_deneme.R;
//import com.example.telekurye_deneme.R.id;
//import com.example.telekurye_deneme.R.layout;
//
//import roboguice.activity.RoboActivity;
//import roboguice.inject.InjectView;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ImageView.ScaleType;
//
//public class imgFullscreen extends RoboActivity {
//
//	@InjectView(R.id.imgFullscreen) ImageView	imgFullscreen;
//	@InjectView(R.id.btnKapat) Button			btnKapat;
//
//	String										value;
//	private int									value2;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.imgfullscreen);
//
//		Bundle extras = getIntent().getExtras();
//		if (extras != null) {
//			value = extras.getString("imgfull");
//			value2 = extras.getInt("DistributionMissionID");
//		}
//
//		Bitmap bmp = BitmapFactory.decodeFile(value);
//		imgFullscreen.setScaleType(ScaleType.FIT_XY);
//		imgFullscreen.setImageBitmap(bmp);
//
//		btnKapat.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				onBackPressed();
////				Intent i = new Intent(imgFullscreen.this, DistributionMissionFeedBack.class);
////				i.putExtra("DistributionMissionID", value2);
////				startActivity(i);
//
//			}
//		});
//		
//		
//
//	}
//}
