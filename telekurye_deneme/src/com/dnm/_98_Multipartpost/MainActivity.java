//package com.dnm._98_Multipartpost;
//package com.test._98_Multipartpost;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.test._1_Telekurye.R;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Environment;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.Toast;
//
//public class MainActivity extends Activity {
//
//	private static final File	FILE	= new File(Environment.getExternalStorageDirectory() + "/icon.png");
//	private static final String	TAG		= "MainActivity";
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout._1_login);
//
//		Button button = (Button) findViewById(R.id.btn_geri2);
//		button.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//				Log.d(TAG, "send_post_button clicked, sending request");
//				sendPostRequest();
//			}
//		});
//	}
//
//	private void sendPostRequest() {
//		Log.d(TAG, "sendPostRequest");
//		List<PostParameter> params = new ArrayList<PostParameter>();
//		params.add(new PostParameter<String>("f", "login"));
//		params.add(new PostParameter<String>("u", "38010"));
//		params.add(new PostParameter<String>("p", "135283"));
//		params.add(new PostParameter<String>("i", "352728054859749"));
//		// params.add(new PostParameter<File>("headshot", FILE));
//
//		try {
//			MultipartPost post = new MultipartPost(params);
//			post.send("http://rl.telekurye.com.tr/androidservices/Default.aspx");
//
//			Toast.makeText(this, "POST has sent " + post.send("http://rl.telekurye.com.tr/androidservices/Default.aspx"), Toast.LENGTH_SHORT).show();
//		} catch (Exception e) {
//			Log.e(TAG, "sendPostRequest", e);
//			Log.d(TAG, "==================================================");
//			Toast.makeText(this, "Failed to send POST request, see log for details!", Toast.LENGTH_SHORT).show();
//		}
//	}
//}