package com.branded.android.rpc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class GpsService extends Service {
	// 下面定义的都是 远程服务才用的
	public class GpsServiceImpl extends IGpsService.Stub {
		public void stopTracking() throws RemoteException {

		}
	}
	private static final String tag = "Branded-GpsService";
	public static Location mLocation = null;
	public static double mLatByAddress = 0;// 非gps得到，通过地址/邮编得到的。

	public static double mLonByAddress = 0;
	public static boolean isByAddr = false;
	public LocationManager mLocationManager = null;
	String provider = null;

	Criteria criteria = null;

	private final LocationListener mLocationListener = new LocationListener() {

		public void onLocationChanged(Location location) {
			if (location == null)
				return;
			if (mLocation == null) {
				mLocation = new Location(location);
			} else {
				mLocation.set(location);
			}
		}

		//

		public void onProviderDisabled(String provider) {
			Log.d("GpsService", "onProviderDisabled is called..");
		}

		public void onProviderEnabled(String provider) {
			Log.d("GpsService", "onProviderEnabled is called..");
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.d("GpsService", "onStatusChanged is called..");
			switch (status) {
			case LocationProvider.AVAILABLE:
				Log.v("Status", "AVAILABLE");
				break;
			case LocationProvider.OUT_OF_SERVICE:
				Log.v("Status", "OUT_OF_SERVICE");
				break;
			case LocationProvider.TEMPORARILY_UNAVAILABLE:
				Log.v("Status", "TEMPORARILY_UNAVAILABLE");
				break;
			}
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return new GpsServiceImpl();
	}

	@Override
	public void onCreate() {
		Log.d("service:", "onCreate");
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// //
		criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(true);
		criteria.setBearingRequired(true);
		criteria.setCostAllowed(true);
		criteria.setSpeedRequired(true);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		provider = mLocationManager.getBestProvider(criteria, true);
		// Location location = mLocationManager.getLastKnownLocation(provider);
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(tag, "service onDestroy is called.");
		if (mLocationManager != null) {
			mLocationManager.removeUpdates(mLocationListener);
			mLocationManager = null;
		}
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub

		if (mLocationManager != null) {
			mLocationManager.removeUpdates(mLocationListener);
		}
		if (mLocationManager == null) {
			mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		}
		try {
			mLocationManager.requestLocationUpdates(
					//LocationManager.GPS_PROVIDER, 1 * 1000, 0,
					provider,1,0,
					mLocationListener);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("ERR:GpsService", "try to requestLocationUpdates");
		}
		//add 2010-9-19
		if(mLocation==null){
			mLocation = mLocationManager.getLastKnownLocation(provider);
			if(mLocation==null){
				Log.d(tag,"Gps onStart,getLastKnownLocation(provider),mLocation:null");
			}else{
				Log.d(tag,"Gps onStart,getLastKnownLocation(provider),lat:"+mLocation.getLatitude()+",lon"+mLocation.getLongitude());
			}
			
		}
		super.onStart(intent, startId);
	}
}
