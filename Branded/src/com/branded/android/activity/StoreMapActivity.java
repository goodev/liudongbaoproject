package com.branded.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.branded.android.R;
import com.branded.android.util.BrandedConstants;
import com.branded.android.util.Helper;
import com.branded.android.util.MapMode;
import com.branded.android.view.StoreMapView;
import com.google.android.maps.MapActivity;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">Áõ¶¬±¦</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-14 ÏÂÎç02:24:45 <br>
 * 
 */
public class StoreMapActivity extends MapActivity {
	StoreMapView mapView;
	private boolean isByAddr;

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		isByAddr = i.getBooleanExtra("isByAddr", false);
		setContentView(R.layout.map);
		mapView = (StoreMapView) findViewById(R.id.map);
		BrandedConstants.isNeedAdjustZoomlevel=true;
		mapView.init(this,isByAddr);
		Button satellite = (Button) findViewById(R.id.SatelliteMode);
		satellite.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				mapView.update(MapMode.Satellite);

			}
		});
		Button normal = (Button) findViewById(R.id.NormalMode);
		normal.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				mapView.update(MapMode.Normal);

			}
		});
		
		 Helper.setOnInfoAndHome(this);
	}
}