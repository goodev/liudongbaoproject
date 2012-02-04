package com.branded.android.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.branded.android.R;
import com.branded.android.entity.StoreDetail;
import com.branded.android.util.BrandedConstants;
import com.branded.android.util.Helper;
import com.branded.android.util.NoteCloseDelayed;
import com.branded.android.util.NoteCloseDelayedHandler;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Projection;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">刘冬宝</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-14 下午02:24:22 <br>
 * 
 */
public class StoreNote extends LinearLayout implements NoteCloseDelayed {
	private static final String tag = "StoreNote";
	private NoteCloseDelayedHandler storeNoteHandler = new NoteCloseDelayedHandler(
			this);
	private StoreDetail store = null;
	private StoreMapView mapView = null;
	private int index;

	public StoreNote(StoreMapView newMapView, Context context,
			StoreDetail store, int index) {
		super(context);
		this.store = store;
		this.mapView = newMapView;
		this.index = index;
		LinearLayout layout = (LinearLayout) inflate(context,R.layout.noteview, this);

		// layout.getBackground().setAlpha(144);
		
		TextView domino_title = (TextView) layout.findViewById(R.id.domino_title);	
		domino_title.setText(store.getSn());
		TextView addr = (TextView) layout.findViewById(R.id.addr);
		addr.setText(store.getAddr());// 123 Major Mackenzie Dr E
		TextView city_prov_ps = (TextView) layout
				.findViewById(R.id.city_prov_ps);
		city_prov_ps.setText(store.getCity() + "," + store.getProv() + " "
				+ store.getPs());// Markham, ON M2S 3C2
		TextView phone = (TextView) layout.findViewById(R.id.phone);
		phone.setText("Phone: "+store.getPn());
		this.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Helper.mylog(tag, "onClick:" + v);
				StoreNote.this.close();

			}
		});
		TextView view_more = (TextView) layout.findViewById(R.id.view_more);
		view_more.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Helper.mylog(tag, "view_more,onClick:" + v);
				StoreNote.this.close();
				Helper.doStoreDetailActivity(mapView.getStoreMapActivity(),
						StoreNote.this.index, mapView.isByAddr());
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.branded.android.util.NoteCloseDelayed#close()
	 */
	public void close() {
		setVisibility(View.INVISIBLE);
		int width = this.getWidth();
		int height = this.getHeight();
		Helper.mylog(tag, "width:" + width);
		Helper.mylog(tag, "height:" + height);
		this.mapView.removeView(this);

	}

	private void adjustMapViewPosion(Point displayPoint) {
		Bitmap bitmap = Helper
				.getDrawable(getContext(), R.drawable.map_tip_fix).getBitmap();
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		Helper.mylog(tag, "width:" + width);
		Helper.mylog(tag, "height:" + height);
		DisplayMetrics dm = getContext().getApplicationContext().getResources()
				.getDisplayMetrics();
		Helper.mylog(tag, "widthPixels:" + dm.widthPixels + "____heightPixels:"
				+ dm.heightPixels);

		int x = 0;
		int y = 0;
		int scrollX = (displayPoint.x + width) - dm.widthPixels;
		if (scrollX >= 0) {
			x = scrollX;
		}
		int scrollY = (displayPoint.y + height) - dm.heightPixels;
		if (scrollY >= 0) {
			y = scrollY;
		} else {
			scrollY = (displayPoint.y - height);
			if (scrollY <= 0) {
				y = scrollY;
			}
		}

		Helper.mylog(tag, "scrollX:" + scrollX + "__scrollY:" + scrollY);
		mapView.getController().scrollBy(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.branded.android.util.NoteCloseDelayed#getDelayedTime()
	 */
	public int getDelayedTime() {
		//return 5000;
		return BrandedConstants.defaultDelay_MapTip;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.branded.android.util.NoteCloseDelayed#getMsgObj()
	 */
	public Object getMsgObj() {
		return StoreNote.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.branded.android.view.NoteCloseDelayed#getMsgWhat()
	 */
	public int getMsgWhat() {
		return MSG_FIRST_ID + hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.branded.android.util.NoteCloseDelayed#show()
	 */
	public void show() {
		Projection projection = mapView.getProjection();
		GeoPoint geoLoc = new GeoPoint(
				(int) (Double.valueOf(store.getLat()) * 1000000), (int) (Double
						.valueOf(store.getLon()) * 1000000));
		Point displayPoint = projection.toPixels(geoLoc, null);
		//
		Bitmap bitmap = Helper.getDrawable(mapView.getContext(),
				R.drawable.gps_icon).getBitmap();
		//int bitMapWidthHalf = bitmap.getWidth()/2;
		int bitMapHeightHalf = bitmap.getHeight()/2;
		displayPoint.y=displayPoint.y-bitMapHeightHalf;//marker的下端中心指向坐标点，所以提示框也修改指向位置
		//
		adjustMapViewPosion(displayPoint);
		displayPoint = projection.toPixels(geoLoc, null);
		displayPoint.y=displayPoint.y-bitMapHeightHalf;///////
		MapView.LayoutParams screenLP = new MapView.LayoutParams(
				MapView.LayoutParams.WRAP_CONTENT,
				MapView.LayoutParams.WRAP_CONTENT, displayPoint.x,
				displayPoint.y, MapView.LayoutParams.LEFT
						| MapView.LayoutParams.BOTTOM);

		mapView.addView(this, screenLP);
		Helper.mylog(tag, "displayPoint:" + displayPoint);
		mapView.invalidate();
		storeNoteHandler.enableCloseNoteLater();
	}

}
