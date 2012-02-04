package com.branded.android.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.branded.android.R;
import com.branded.android.entity.MyLocationDetail;
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
 * @author <a href="mailto:liudongbaollz@foxmail.com">Áõ¶¬±¦</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-23 ÏÂÎç12:10:36 <br>
 * 
 */
public class MyLocationNote extends LinearLayout implements NoteCloseDelayed {
	private static final String tag = "MyLocationNote";
	private NoteCloseDelayedHandler noteCloseDelayedHandler = new NoteCloseDelayedHandler(
			this);
	private MapView mapView;
	private MyLocationDetail location;

	public MyLocationNote(MapView mapView, Context context,
			MyLocationDetail mylocation) {
		super(context);
		this.mapView = mapView;
		this.location = mylocation;
		LinearLayout layout = (LinearLayout) inflate(context,
				R.layout.mylocationnote, this);
		TextView addr = (TextView) layout.findViewById(R.id.mylocation_title);
		addr.setText("My Here");
		TextView city_prov_ps = (TextView) layout.findViewById(R.id.mylocation);
		city_prov_ps.setText( mylocation.location.getLatitudeE6()/1000000.00 + ","
				+ mylocation.location.getLongitudeE6()/1000000.00);// 
		this.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Helper.mylog(tag, "onClick:" + v);
				MyLocationNote.this.close();

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.branded.android.util.NoteCloseDelayed#getDelayedTime()
	 */
	public int getDelayedTime() {
		return 5000;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.branded.android.util.NoteCloseDelayed#getMsgObj()
	 */
	public Object getMsgObj() {
		return MyLocationNote.class;
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
		Point displayPoint = projection.toPixels(this.location.location, null);
		adjustMapViewPosion(displayPoint);
		displayPoint = projection.toPixels(this.location.location, null);
		MapView.LayoutParams screenLP = new MapView.LayoutParams(
				MapView.LayoutParams.WRAP_CONTENT,
				MapView.LayoutParams.WRAP_CONTENT, displayPoint.x,
				displayPoint.y, MapView.LayoutParams.LEFT
						| MapView.LayoutParams.BOTTOM);

		mapView.addView(this, screenLP);
		Helper.mylog(tag, "displayPoint:" + displayPoint);
		mapView.invalidate();
		noteCloseDelayedHandler.enableCloseNoteLater();
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

}
