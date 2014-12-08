//package com.telekurye.ui2;
//
//import java.text.SimpleDateFormat;
//
//import com.telekurye.helpers.InfoHelper;
//import com.telekurye.helpers.PhoneStatusChangedHandler;
//import com.telekurye.helpers.SyncEventHandler;
//import com.telekurye.helpers.SyncHelper;
//import com.telekurye.helpers.SyncStartEndEventHandler;
//import com.telekurye.helpers.TelephoneStaus;
//import com.telekurye.helpers.Tools;
//
//import android.R.color;
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Color;
//import android.graphics.Typeface;
//import android.os.Handler;
//import android.os.Message;
//import android.util.AttributeSet;
//import android.view.Gravity;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//public class Statusbar extends LinearLayout{
//    
//	TextView tvSynctime,tvVersion,tvTime,tvNetworkStatus,tvBattery;
//	ImageView SyncIcon,PhotoUploadIcon;
//	TelephoneStaus ts;
//	String  time="";
//
//	  PhoneStatusChangedHandler batteryStatusHandler,connectionStatusHandler,timeChangedHandler;
//	  
//	  SyncStartEndEventHandler syncStartEndEvent, photoUploadStartEndEvent;
//	  
//	  
//	public Statusbar(Context context,AttributeSet attrs) {
//		super(context,attrs);
//	    this.setOrientation(HORIZONTAL);
//	  
//	  
//        //Textview Layout params
//        LayoutParams lptvSynctime=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        //lptvSynctime.weight=30;
//        lptvSynctime.leftMargin=5;
//        lptvSynctime.topMargin=4;
//        lptvSynctime.width=125;
//        tvSynctime=new TextView(context);
//        tvSynctime.setTextSize(14);
//        tvSynctime.setPadding(5, 0, 0, 0);
//        tvSynctime.setTextColor(Color.parseColor("#FFFFFF"));
//        tvSynctime.setTypeface(null, Typeface.BOLD);
//        String lastsynctime ="";
//		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
//
//		lastsynctime = formatter.format(Tools.getLastSyncDate());
//	    time="Senk: "+ lastsynctime;
//	    tvSynctime.setText(time);
//        addView(tvSynctime,lptvSynctime);
//        
//        
//        
//        LayoutParams lpsyncHeader=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        //lptvHeader.weight=10;
//        lpsyncHeader.height = 28;
//        lpsyncHeader.width = 28;
//        lpsyncHeader.topMargin=7;
//        lpsyncHeader.leftMargin = 5;
//        SyncIcon = new ImageView(context);
//        SyncIcon.setImageResource(R.drawable.sync);
//        addView(SyncIcon,lpsyncHeader);
//        
//        
//        PhotoUploadIcon = new ImageView(context);
//        PhotoUploadIcon.setImageResource(R.drawable.upload); 
//        addView(PhotoUploadIcon,lpsyncHeader);
//
//    
//        
//        PhotoUploadIcon.setVisibility(View.GONE);
//        
//        
//        LayoutParams lptvEmpty=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        lptvEmpty.weight = 30;
//        TextView tvEmpty=new TextView(context);
//        addView(tvEmpty,lptvEmpty);
//        
//        //Textview Layout params
//        LayoutParams lptvHeader=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        //lptvHeader.weight=10;
//        lptvHeader.width = 50;
//        lptvHeader.topMargin=5;
//        lptvHeader.rightMargin = 5;
//        
//        tvVersion=new TextView(context);
//        tvVersion.setTextSize(12);
//        tvVersion.setTextColor(Color.parseColor("#FFFFFF"));
//        tvVersion.setTypeface(null, Typeface.BOLD);
//        addView(tvVersion,lptvHeader);
//   
//        // network
//        LayoutParams lptvNetwork=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        //lptvNetwork.weight=20;
//        lptvNetwork.width = 60;
//        lptvNetwork.topMargin=5;
//        lptvNetwork.rightMargin = 5;
//        tvNetworkStatus=new TextView(context);
//        tvNetworkStatus.setText("saat");
//        tvNetworkStatus.setTextSize(12);
//        tvNetworkStatus.setTextColor(Color.parseColor("#FFFFFF"));
//        tvNetworkStatus.setTypeface(null, Typeface.BOLD);
//        addView(tvNetworkStatus,lptvNetwork);
//        
//        //battery
//        LayoutParams lptvBattery=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        //lptvBattery.weight=15;
//        lptvBattery.width = 75;
//        lptvBattery.topMargin=5;
//        lptvBattery.rightMargin = 15;
//        tvBattery=new TextView(context);
//        tvBattery.setTextSize(12);
//        tvBattery.setTextColor(Color.parseColor("#FFFFFF"));
//        tvBattery.setTypeface(null, Typeface.BOLD);
//        tvBattery.setGravity(Gravity.CENTER_VERTICAL);
//        addView(tvBattery,lptvBattery);
//        
//        //Textview Layout params
//        LayoutParams lptvTime=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        //lptvTime.weight=15;
//        lptvTime.width = 60;
//        lptvTime.topMargin=4;
//        lptvTime.rightMargin = 10;
//        tvTime=new TextView(context);
//    	tvTime.setText("saat");
//    	tvTime.setTextSize(15);
//    	tvTime.setTextColor(Color.parseColor("#FFFFFF"));
//    	tvTime.setTypeface(null, Typeface.BOLD);
//    	tvTime.setGravity(Gravity.CENTER_VERTICAL);
//        addView(tvTime,lptvTime);
//        
//        tvVersion.setText("v."+ Integer.toString(InfoHelper.CURRENT_VERSION));
//        
//        ts=TelephoneStaus.GetInstance();
//        
//        
//        timeChangedHandler = new PhoneStatusChangedHandler() {
//			
//			@Override
//			public void OnReceived(String newState) {
//				tvTime.setText(newState);
//				
//				String lastsynctime = null;
//				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
//
//				lastsynctime = formatter.format(Tools.getLastSyncDate());
//				time="Senk: " + lastsynctime;
//				tvSynctime.post(new Runnable() {
//					@Override
//					public void run() {
//						tvSynctime.setText(time);
//					}
//				});
//
//				if ((Tools.getDateNow().getTime() - Tools.getLastSyncDate().getTime()) > InfoHelper.SYNCHRONIZATION_ERROR_TIME_INTERVAL) 
//				{
//					tvSynctime.post(new Runnable() {
//						@Override
//						public void run() {
//							tvSynctime.setBackgroundColor(Color.parseColor("#FF0000"));
//						}
//					});
//				}
//				else {
//					tvSynctime.post(new Runnable() {
//						@Override
//						public void run() {
//							tvSynctime.setBackgroundColor(Color.TRANSPARENT);
//						}
//					});
//				}
//			}
//		};
//        
//        ts.SetTimeChangedEvent(timeChangedHandler);
//        
//        
//        
//        connectionStatusHandler = new PhoneStatusChangedHandler() {
//			
//			@Override
//			public void OnReceived(String newState) {
//				// TODO Auto-generated method stub
//				tvNetworkStatus.setText(newState);
//			}
//		};
//        
//        
//        ts.SetConnectionStatusChangedEvent(connectionStatusHandler);
//        
//        
//        batteryStatusHandler = new PhoneStatusChangedHandler() {
//			
//			@Override
//			public void OnReceived(String newState) {
//				// TODO Auto-generated method stub
//				tvBattery.setText("Pil:"+newState);
//			}
//		};
//        
//        
//        ts.SetBatteryStatusChangedEvent(batteryStatusHandler);
//        
//        SyncIcon.setVisibility(View.GONE);
//	 
//        
//        ts.ForceBroadcastAll();
//        
//        photoUploadStartEndEvent = new SyncStartEndEventHandler() {
//			
//			@Override
//			public void OnStart() {
//				// TODO Auto-generated method stub
//				  PhotoUploadIcon.post(new Runnable() {
//						@Override
//						public void run() {
//							PhotoUploadIcon.setVisibility(View.VISIBLE);
//						}
//					});
//			}
//			
//			@Override
//			public void OnEnd() {
//				// TODO Auto-generated method stub
//				  PhotoUploadIcon.post(new Runnable() {
//						@Override
//						public void run() {
//							PhotoUploadIcon.setVisibility(View.GONE);
//						}
//					});
//			}
//		};
//		
//		
//		SyncHelper.AddPhotoUploadStartEndEvent(photoUploadStartEndEvent);
//        
//        syncStartEndEvent = new SyncStartEndEventHandler() {
//			
//			@Override
//			public void OnStart() {
//				// TODO Auto-generated method stub
//				SyncIcon.post(new Runnable() {
//					@Override
//					public void run() {
//						SyncIcon.setVisibility(View.VISIBLE);
//					}
//				});
//			}
//			
//			@Override
//			public void OnEnd() {
//				// TODO Auto-generated method stub
//				String lastsynctime = null;
//				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
//
//				lastsynctime = formatter.format(Tools.getLastSyncDate());
//				time="Senk: " + lastsynctime;
//				tvSynctime.post(new Runnable() {
//					@Override
//					public void run() {
//						tvSynctime.setText(time);
//					}
//				});
//				
//				
//			
//		 		
//		 		tvTime.post(new Runnable() {
//					
//					@Override
//					public void run() {
//						SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
//						String timeNow = formatter.format(Tools.getDateNow());
//
//						// TODO Auto-generated method stub
//						tvTime.setText(timeNow);
//					}
//				});
//			
//				
//
//				if ((Tools.getDateNow().getTime() - Tools.getLastSyncDate().getTime()) > InfoHelper.SYNCHRONIZATION_ERROR_TIME_INTERVAL) 
//				{
//					tvSynctime.post(new Runnable() {
//						@Override
//						public void run() {
//							tvSynctime.setBackgroundColor(Color.parseColor("#FF0000"));
//						}
//					});
//				}
//				else {
//					tvSynctime.post(new Runnable() {
//						@Override
//						public void run() {
//							tvSynctime.setBackgroundColor(Color.TRANSPARENT);
//						}
//					});
//				}
//				
//				SyncIcon.post(new Runnable() {
//					@Override
//					public void run() {
//						SyncIcon.setVisibility(View.GONE);
//					}
//				});
//			}
//		};
//		
//		
//        SyncHelper.AddStartEndEvent(syncStartEndEvent);
//	    
////	    SyncHelper.SetSyncEventHandler(new SyncEventHandler() {
////			
////			@Override
////			public void OnSyncFinished(Boolean errors) {
////				// TODO Auto-generated method stub
////				
////				
//////				if(errors==false){
////			      tvSynctime.post(new Runnable() {
////					
////					@Override
////					public void run() {
////						String lastsynctime = null;
////						SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
////
////						lastsynctime = formatter.format(Tools.getLastSyncDate());
////
////						
////								time="Senk: " + lastsynctime;
////							
////								tvSynctime.setText(time);
////								
////						
////						}
////					});
//////				}
//////				else {
//////					
//////						tvSynctime.post(new Runnable() {
//////						
//////						@Override
//////						public void run() {
//////							// TODO Auto-generated method stub
//////							String lastsynctime = null;
//////							SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
//////
//////							lastsynctime = formatter.format(Tools.getLastSyncDate());
//////
//////							
//////									time="Senk: " + lastsynctime;
//////									//tvSynctime.setBackgroundColor(Color.parseColor("#FF0000"));
//////									tvSynctime.setText(time);
//////							
//////						}
//////					});
//////					
//////				}
////				
////			}
////			
////			@Override
////			public void OnStateChanged(String syncState) {
////				// TODO Auto-generated method stub
////				
////			}
////		});
//		
//		
//	}
//	
//	
//	@Override
//	protected void onDetachedFromWindow() {
//		// TODO Auto-generated method stub
//		super.onDetachedFromWindow();
//		ts.RemoveBatteryStatusChangedEvent(batteryStatusHandler);
//		ts.RemoveConnectionStatusChangedEvent(connectionStatusHandler);
//		ts.RemoveTimeChangedEvent(timeChangedHandler);
//		SyncHelper.RemoveStartEndEvent(syncStartEndEvent);
//		SyncHelper.RemovePhotoUploadStartEndEvent(photoUploadStartEndEvent);
//	}
//
//	
//
//	
//}
