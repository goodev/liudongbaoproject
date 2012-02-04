/**
 * 
 */
package com.branded.android.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.branded.android.R;
import com.branded.android.entity.MyLocationDetail;
import com.branded.android.util.Helper;
import com.branded.android.util.NoteCloseDelayed;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

/**
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">Áõ¶¬±¦</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-22 ÏÂÎç03:40:20 <br>
 * 
 */
public class MyLocationOverlay extends ItemizedOverlay<MyLocationOverlayItem> {
	private static final String tag = "MyLocationOverlay";
	private MapView mapView;
	private MyLocationDetail mylocation;

	public MyLocationOverlay(Context context, MapView mapView,
			MyLocationDetail mylocation) {
		super(Helper.getDrawable(mapView.getContext(),
				R.drawable.gps_icon));
		this.mylocation = mylocation;
		this.mapView = mapView;
		populate();
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		Projection projection = mapView.getProjection();
		Helper.mylog(tag, "mapView.getMapCenter()_____"
				+ mapView.getMapCenter());
		MyLocationOverlayItem item = getItem(0);
		Point point = projection.toPixels(item.getPoint(), null);
		Paint paint2 = new Paint();
		paint2.setColor(Color.WHITE);
		paint2.setStrokeWidth(1);
		paint2.setStyle(Paint.Style.FILL_AND_STROKE);
		paint2.setTextSize(12);
		Bitmap bitmap = Helper.getDrawable(mapView.getContext(),
				R.drawable.gps_mylocation).getBitmap();
		int bitMapWidthHalf = bitmap.getWidth() / 2;
		int bitMapHeightHalf = bitmap.getHeight() / 2;
		canvas.drawBitmap(bitmap, point.x - bitMapWidthHalf, point.y
				- bitMapHeightHalf, paint2);
		super.draw(canvas, mapView, shadow);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.android.maps.ItemizedOverlay#onTap(int)
	 */
	@Override
	protected boolean onTap(int index) {
		Helper.mylog(tag, "onTap(int index)" + index);
		NoteCloseDelayed noteView = new MyLocationNote(mapView, mapView
				.getContext(), mylocation);
		noteView.show();
		return super.onTap(index);
	}

	@Override
	protected MyLocationOverlayItem createItem(int i) {
		return new MyLocationOverlayItem(this.mylocation);
	}

	@Override
	public int size() {
		return 1;
	}
}
