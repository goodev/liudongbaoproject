package com.branded.android;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.branded.android.util.Helper;
import com.google.android.maps.GeoPoint;

public class TestActivity extends Activity {
	private static final String tag = "TestActivity";

	protected void doAbout() {
		Helper.mylog(tag, "doAbout");
		Helper.doAbout(this);
	}

	protected void doCall(String tel) {
		Helper.mylog(tag, "doCall");
		Helper.doCall(this, tel);
	}

	protected void doDirection(String saddr, String daddr) {
		Helper.mylog(tag, "doDirection");
		Helper.doDirection(this, saddr, daddr);
	}

	protected void doMain() {
		Helper.mylog(tag, "doMapView");
		Helper.doMain(this);
	}

	protected void doTestList() {
		Helper.mylog(tag, "doTestList");
		Helper.doTestList(this);
	}

	protected void doMapView() {
		Helper.mylog(tag, "doMapView");
		Helper.doMapView(this,true);
	}

	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.testmain);
		Button about = (Button) this.findViewById(R.id.About);
		about.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				doAbout();

			}

		});

		Button call = (Button) this.findViewById(R.id.Call);
		call.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				doCall("905-567-7777");

			}

		});
		Button direction = (Button) this.findViewById(R.id.Direction);
		direction.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				GeoPoint currentLoc = Helper
						.getCurrenLocation();
				if (currentLoc == null) {
					Dialog dialog = Helper
							.createDirectionAlertDialog(TestActivity.this);
					dialog.show();
				} else {
					doDirection(currentLoc.getLatitudeE6() / 1e6 + ","
							+ currentLoc.getLongitudeE6() / 1e6,
							"43.580475 ,-79.6139");
				}

			}

		});
		Button mapView = (Button) this.findViewById(R.id.MapView);
		mapView.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				doMapView();

			}

		});
		Button main = (Button) this.findViewById(R.id.Main);
		main.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				doMain();
			}

		});
		Button testList = (Button) this.findViewById(R.id.TestList);
		testList.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				doTestList();
			}

		});
	}
}
