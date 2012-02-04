package com.branded.android.util;

import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.branded.android.Main;
import com.branded.android.R;
import com.branded.android.TestActivity;
import com.branded.android.TestListActivity;
import com.branded.android.activity.AboutActivity;
import com.branded.android.activity.CouponListActivity;
import com.branded.android.activity.FlyerListActivity;
import com.branded.android.activity.StoreDetailActivity;
import com.branded.android.activity.StoreListActivity;
import com.branded.android.activity.StoreMapActivity;
import com.branded.android.entity.BaCoupon;
import com.branded.android.entity.BaCouponInfo;
import com.branded.android.entity.Flyer;
import com.branded.android.entity.FlyerList;
import com.branded.android.rpc.GpsService;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Projection;

/**
 * 
 * 
 * Description: <br>
 * 对了，如何你需要真实storeList数据，测试时地址输入可以是： m3c m1w2m3 l5j2x1 以上都是邮编 或 18 wynford
 * dr，这个会返回多个地址
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">刘冬宝</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-14 下午02:25:32 <br>
 * 
 */
public class Helper {
	private static final String tag = "Helper";

	public static Dialog createDirectionAlertDialog(final Activity activity) {
		LayoutInflater factory = LayoutInflater.from(activity);
		final View textEntryView = factory.inflate(
				R.layout.direction_alert_dialog, null);
		Dialog dialog = new AlertDialog.Builder(activity).setIcon(
				R.drawable.search).setTitle(R.string.find_store_title)
				.setMessage(R.string.mGPSNotAvailable).setView(textEntryView)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						EditText saddr = (EditText) textEntryView
								.findViewById(R.id.saddr);
						mylog(tag, "saddr:" + saddr.getText().toString());
						Helper.doDirection(activity,
								saddr.getText().toString(),
								"2560 SHEPARD AVE. #8");
					}
				}).setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

								/*
								 * User clicked cancel so do some stuff
								 */
							}
						}).create();
		return dialog;
	}

	public static void doAbout(Context context) {
		mylog(tag, "doAbout");
		Intent i = new Intent();
		i.setClass(context, AboutActivity.class);
		context.startActivity(i);

	}

	public static void doCall(Activity activity, String tel) {
		mylog(tag, "doCall");
		// ACTION_DIAL tel:123
		Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel));
		activity.startActivity(i);
	}

	public static void doDirection(Activity activity, String saddr, String daddr) {
		//参数说明：http://mapki.com/wiki/Google_Map_Parameters
		// String url =
		// "http://maps.google.com/maps?f=d&source=s_d&saddr=31.249351,121.45905&daddr=31.186371,121.489885&hl=zh&t=m&"
		String url = "http://maps.google.com/maps?f=d&source=s_d&t=m&dirflg=d";// &dirflg=r,w,d
		// &saddr=5920 Turney Drive&daddr=2560 SHEPARD AVE. #8&hl=zh
		url += "&saddr=" + saddr + "&daddr=" + daddr;
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		mylog(tag, url);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				& Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		i.setClassName("com.google.android.apps.maps",
				"com.google.android.maps.MapsActivity");

		activity.startActivity(i);
		// http://ads.cellflare.com/cfsrv/RESTService/brand/getbrandstores?bi=1&la=43.7391&lo=-79.34&r=40000&fmt=xml

	}

	public static void doMain(Context context) {
		mylog(tag, "doMain");
		Intent i = new Intent();
		i.setClass(context, Main.class);
		context.startActivity(i);

	}

	public static void doMapView(Activity activity, boolean isByAddr) {
		mylog(tag, "doMapView");
		Intent i = new Intent();
		i.putExtra("isByAddr", isByAddr);
		i.setClass(activity, StoreMapActivity.class);
		activity.startActivity(i);

	}

	public static void doCouponList(Activity activity, int sid) {
		mylog(tag, "doCouponList");
		gotoCouponListView(activity, sid);

	}

	public static void doFlyerList(Activity activity, int sid, boolean isByAddr) {
		// TODO Auto-generated method stub
		gotoFlyerListView(activity, sid, isByAddr);
	}

	public static Point gePointToPixels(MapView mapView, GeoPoint geoLoc) {
		Projection projection = mapView.getProjection();
		Point point = projection.toPixels(geoLoc, null);
		mylog(tag, "geoLoc:" + geoLoc + "/point:" + point);
		return point;
	}
	//返回gps或者用户输入地址后获得的坐标
	public static GeoPoint getCurrenLocation() {
		// 结合定位服务
//		String location_service = Context.LOCATION_SERVICE;
//		LocationManager locationManager = (LocationManager) context
//				.getSystemService(location_service);
//		Criteria criteria = new Criteria();
//		criteria.setAccuracy(Criteria.ACCURACY_FINE);
//		criteria.setAltitudeRequired(false);
//		criteria.setBearingRequired(false);
//		criteria.setCostAllowed(true);
//		criteria.setPowerRequirement(Criteria.POWER_LOW);
//		String provider = locationManager.getBestProvider(criteria, true);
//		Location location = locationManager.getLastKnownLocation(provider);
//		if (location == null) {
//			return null;
//		}
//		double latitude = location.getLatitude();
//		double longitude = location.getLongitude();
//		return new GeoPoint((int) (latitude * 1E6), (int) (longitude * 1E6));

		if(GpsService.isByAddr==false){
			Location location= getCurrentLocation2();
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			return new GeoPoint((int) (latitude * 1E6), (int) (longitude * 1E6));
		}else{
			return new GeoPoint((int) ((GpsService.mLatByAddress) * 1E6), (int) (GpsService.mLonByAddress * 1E6));
		}
	}
	//返回gps坐标
	public static Location getCurrentLocation2() {
		Location location = null;
		if (GpsService.mLocation == null) {
			return null;
		} else {
			location = new Location(GpsService.mLocation);// 克隆一个
		}
		return location;

	}

	public static BitmapDrawable getDrawable(Context context, int resId) {
		Resources res = context.getResources();
		BitmapDrawable db = (BitmapDrawable) res.getDrawable(resId);
		mylog(tag, db.getClass().getName());
		return db;

	}

	public static boolean isGPSEnabled(Context context) {
		LocationManager locationManager = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	public static void mylog(String tag, String msg) {
		if (BrandedConstants.isDebugVersion) {
			Log.i(tag, msg);
		}
	}

	private static void gotoCouponListView(final Activity activity,
			final int sid) {

		BaCouponInfo bciList = null;
		AsyncFromServer afs = new AsyncFromServer(activity);

		afs.execute(BrandedConstants.getcouponlist, "1", String.valueOf(sid));
		try {
			bciList = (BaCouponInfo) afs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bciList == null || bciList.getCount() == 0) {
			new AlertDialog.Builder(activity).setIcon(
					android.R.drawable.ic_dialog_alert).setTitle("Coupon not found")
					.setMessage(
							(String) BrandedConstants.msgMap.get("mNoCoupon"))
					.setPositiveButton(R.string.BUTTON_OK,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {

								}
							}).show();
			return;
		} else {
			CouponListActivity.mCouponList = bciList.getList();
			Intent intent = new Intent();
			intent.putExtra("sid", sid);
			intent.setClass(activity, CouponListActivity.class);
			activity.startActivity(intent);
		}
		// 上面先显示文本，下面接着获取显示图片，并通知

		// for(int i=0;i<CouponListActivity.mCouponList.size();i++){
		// AsyncFromServer afs2 = new AsyncFromServer(activity,false);
		// BaCoupon bc = CouponListActivity.mCouponList.get(i);
		// int cid =bc.getCid();
		// afs2.execute(BrandedConstants.getcoupondetail,
		// String.valueOf(sid),String.valueOf(cid));
		// try {
		// Bitmap bmp = (Bitmap)afs2.get();
		// bc.setImg(bmp);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (ExecutionException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// Intent it = new Intent();
		// it.setAction(CouponListActivity.BROADCAST_FOR_COUPONS);
		// activity.sendBroadcast(it);

		new Thread(new Runnable() {
			public void run() {
				Intent it = new Intent();
				// 先取list的小图片
				for (int i = 0; i < CouponListActivity.mCouponList.size(); i++) {
					BaCoupon bc = CouponListActivity.mCouponList.get(i);
					int cid = bc.getCid();
					Bitmap bmp = RestClient.getCouponDetail(
							String.valueOf(sid), String.valueOf(cid));
					bc.setImg(bmp);
					if (i % 2 == 0) {
						it.setAction(CouponListActivity.BROADCAST_FOR_COUPONS);
						activity.sendBroadcast(it);
					}
				}

				it.setAction(CouponListActivity.BROADCAST_FOR_COUPONS);
				activity.sendBroadcast(it);
				// 取详细页面的大图片
				for (int i = 0; i < CouponListActivity.mCouponList.size(); i++) {
					BaCoupon bc = CouponListActivity.mCouponList.get(i);
					int cid = bc.getCid();
					Bitmap bmp = RestClient.getCouponDetail("1", String
							.valueOf(sid), String.valueOf(cid), "", "240",
							"240");
					bc.setBigImg(bmp);

					// bmp = RestClient.getCodeBarImg(bc.getCcode(), "1", "*");
					// bc.setBarImg(bmp);

					it
							.setAction(CouponListActivity.BROADCAST_FOR_COUPONS_DETAIL);
					activity.sendBroadcast(it);

				}
				// it.setAction(CouponListActivity.BROADCAST_FOR_COUPONS_DETAIL);
				// activity.sendBroadcast(it);

				// //取条形码
				for (int i = 0; i < CouponListActivity.mCouponList.size(); i++) {
					BaCoupon bc = CouponListActivity.mCouponList.get(i);
					int cid = bc.getCid();
					Bitmap bmp = RestClient.getCodeBarImg(bc.getCcode(), "1",
							"*");
					bc.setBarImg(bmp);

					it
							.setAction(CouponListActivity.BROADCAST_FOR_COUPONS_DETAIL);
					activity.sendBroadcast(it);

				}
				// it.setAction(CouponListActivity.BROADCAST_FOR_COUPONS_DETAIL);
				// activity.sendBroadcast(it);
			}
		}).start();
	}

	private static void gotoFlyerListView(final Activity activity,
			final int sid, boolean isByAddr) {
		// TODO Auto-generated method stub

		FlyerList fList = null;
		AsyncFromServer afs = new AsyncFromServer(activity);

		afs.execute(BrandedConstants.getflyerlist, "1", String.valueOf(sid));//bi=1
		try {
			fList = (FlyerList) afs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fList == null || fList.getCount() == 0) {
			new AlertDialog.Builder(activity).setIcon(
					android.R.drawable.ic_dialog_alert).setTitle("Flyer not found")
					.setMessage(
							(String) BrandedConstants.msgMap.get("mNoFlyer"))
					.setPositiveButton(R.string.BUTTON_OK,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {

								}
							}).show();
			return;
		} else {
			FlyerListActivity.mFlyerList = fList.getList();
			Intent intent = new Intent();
			intent.putExtra("sid", sid);
			intent.putExtra("isByAddr", isByAddr);
			intent.setClass(activity, FlyerListActivity.class);
			activity.startActivity(intent);
		}
		// 上面先显示文本，下面接着获取显示图片，并通知

		// for(int i=0;i<FlyerListActivity.mFlyerList.size();i++){
		// AsyncFromServer afs2 = new AsyncFromServer(activity,false);
		// BaCoupon bc = FlyerListActivity.mFlyerList.get(i);
		// int fid =bc.getFid();
		// afs2.execute(BrandedConstants.getflyerdetail,
		// String.valueOf(sid),String.valueOf(fid));
		// try {
		// Bitmap bmp = (Bitmap)afs2.get();
		// bc.setImg(bmp);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (ExecutionException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// Intent it = new Intent();
		// it.setAction(CouponListActivity.BROADCAST_FOR_FlYERS);
		// activity.sendBroadcast(it);

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < FlyerListActivity.mFlyerList.size(); i++) {
					Flyer flyer = FlyerListActivity.mFlyerList.get(i);
					int fid = flyer.getFid();
					Bitmap bmp = RestClient.getFlyerDetail(String.valueOf(sid),
							String.valueOf(fid), "1");//page=1，存放在0对应的map中，作为小图片，map其余都存大图片
					flyer.getImgMap().put(0, bmp);//getImgMap 非空，已在getFlyerList中初始化,主要，page本来是从1开始的，但是这里利用0来表示list的小图标
				}
				Intent it = new Intent();
				it.setAction(FlyerListActivity.BROADCAST_FOR_FLYERS);
				activity.sendBroadcast(it);

			}
		}).start();

	}

	public static void doTestList(Activity activity) {
		mylog(tag, "doTestList");
		Intent i = new Intent();
		i.setClass(activity, TestListActivity.class);
		activity.startActivity(i);

	}

	public static boolean isServiceRunning(Context context, String className) {

		boolean isRunning = false;

		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Activity.ACTIVITY_SERVICE);

		List<ActivityManager.RunningServiceInfo> serviceList = activityManager
				.getRunningServices(Integer.MAX_VALUE);

		if (!(serviceList.size() > 0)) {
			return false;
		}

		for (int i = 0; i < serviceList.size(); i++) {
			// Log.d("TEST",serviceList.get(i).service.getClassName());
			if (serviceList.get(i).service.getClassName().equals(className) == true) {
				isRunning = true;
				break;
			}
		}
		return isRunning;
	}

	public static void doStoreDetailActivity(Activity activity, int position,
			boolean isByAddr) {
		Intent i = new Intent();
		i.putExtra("store_index", position);
		i.putExtra("isByAddr", isByAddr);
		i.setClass(activity, StoreDetailActivity.class);
		activity.startActivity(i);

	}
	public static Bitmap scaleBitmap(Bitmap bitmapOrg,float scale) {
		if(bitmapOrg==null){
			return null;
		}
		
	    int width = bitmapOrg.getWidth(); 
	    int height = bitmapOrg.getHeight(); 

	    
	    // calculate the scale - in this case = 0.4f 
	    float scaleWidth =  scale; 
	    float scaleHeight = scale; 
	    
	    Matrix matrix = new Matrix(); 
		    matrix.postScale(scaleWidth, scaleHeight); 
	    // rotate the Bitmap 
	   // matrix.postRotate(45); 旋转

	    // recreate the new Bitmap 
	    Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0,  width ,  height , matrix, true); 
		return resizedBitmap;
	}
	public static void setOnInfoAndHome(Activity activity){
		
		final ImageButton bt_info = (ImageButton)activity.findViewById(R.id.info);
		bt_info.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
			String name =bt_info.getContext().getClass().getName();
			if(!"com.branded.android.activity.AboutActivity".equals(name)){
				Helper.doAbout(bt_info.getContext());
			}
			}});
		final ImageButton bt_search = (ImageButton)activity.findViewById(R.id.search);
		bt_search.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				//finish();
				//Helper.doMain(AboutActivity.this);
			String name =bt_search.getContext().getClass().getName();
			if(!"com.branded.android.Main".equals(name)){
				Helper.doMain(bt_search.getContext());
			}				
			}});	
	}
	public static void sendEmail(Context ctx,String email,String content){
	
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
        emailIntent.setType("plain/text"); 
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{email}); 
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "mySubject"); 
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,  content); 
        ctx.startActivity(Intent.createChooser(emailIntent, "Choose Email Client"));
	}
	public static void gotoWeb(Context ctx,String url){
		Uri uri = Uri.parse(url);
		Intent i = new Intent(Intent.ACTION_VIEW, uri);
		ctx.startActivity(i);
	}
}
