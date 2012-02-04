package com.branded.android.activity;

import com.branded.android.R;
import com.branded.android.entity.StoreDetail;
import com.branded.android.rpc.GpsService;
import com.branded.android.util.Helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView; 

public class StoreDetailActivity extends Activity {
	public static final String tag = "StoreDetailActivity";
	private boolean isByAddr;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store_detail);
    	//set title
    	TextView title = (TextView)findViewById(R.id.title);
    	title.setText(R.string.store_info);
    	//end title
		Intent i = getIntent();
		int index = i.getIntExtra("store_index", 0);
		isByAddr = i.getBooleanExtra("isByAddr",false);
		final StoreDetail sd = StoreListActivity.mStoreList.get(index);
		Log.d(tag, "addr:"+sd.getAddr());
		Log.d(tag, "addr:"+sd.getCity());
		Log.d(tag, "addr:"+sd.getProv());
		Log.d(tag, "addr:"+sd.getCtry());
		Log.d(tag, "hours"+sd.getHrs());
		TextView addr = (TextView)findViewById(R.id.store_addr);
		TextView addr1 = (TextView)findViewById(R.id.store_addr1);
		TextView addr2 = (TextView)findViewById(R.id.store_addr2);

		TextView hours = (TextView)findViewById(R.id.store_hours);
//		TextView hours1 = (TextView)findViewById(R.id.store_hours1);
//		TextView hours2 = (TextView)findViewById(R.id.store_hours2);

		Button callBt = (Button)findViewById(R.id.call);
		Button directionsBt = (Button)findViewById(R.id.directions);
		Button localcouponsBt = (Button)findViewById(R.id.localcoupons);
		Button localflyersBt = (Button)findViewById(R.id.localflyers);

		addr.setText(sd.getAddr());
		addr1.setText(sd.getCity()+","+sd.getProv()+" "+sd.getPs());
		addr2.setText("Phone:"+sd.getPn());

		String hoursStr = sd.getHrs().replaceAll(",","\n");
		hours.setText(hoursStr);
		callBt.getBackground().setAlpha(200);
		callBt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Helper.doCall(StoreDetailActivity.this,sd.getPn());
			}});
		
		directionsBt.getBackground().setAlpha(200);
		directionsBt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isByAddr){
					//Helper.doDirection(StoreDetailActivity.this, GpsService.mLatByAddress+","+GpsService.mLonByAddress, sd.getAddr());
					//用地址比较模糊，会出现多个，让你选择，故改为坐标
					Helper.doDirection(StoreDetailActivity.this, GpsService.mLatByAddress+","+GpsService.mLonByAddress, sd.getLat()+","+sd.getLon());
				}else{
					//Helper.doDirection(StoreDetailActivity.this, GpsService.mLocation.getLatitude()+","+GpsService.mLocation.getLongitude(), sd.getAddr());
					Helper.doDirection(StoreDetailActivity.this, GpsService.mLocation.getLatitude()+","+GpsService.mLocation.getLongitude(), sd.getLat()+","+sd.getLon() );
				}
			}});
		
		localcouponsBt.getBackground().setAlpha(200);
		localcouponsBt.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Helper.doCouponList(StoreDetailActivity.this,sd.getSid());
			}});
		
		localflyersBt.getBackground().setAlpha(200);	
		localflyersBt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Helper.doFlyerList(StoreDetailActivity.this,sd.getSid(),isByAddr);
			}});
		
	      Helper.setOnInfoAndHome(this);
	}

}
