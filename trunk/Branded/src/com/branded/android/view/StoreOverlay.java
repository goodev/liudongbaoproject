package com.branded.android.view;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.branded.android.R;
import com.branded.android.entity.StoreDetail;
import com.branded.android.util.BrandedConstants;
import com.branded.android.util.Helper;
import com.branded.android.util.NoteCloseDelayed;
import com.google.android.maps.ItemizedOverlay;
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
 * @creatdate 2010-5-14 下午02:24:54 <br>
 * 
 */
public class StoreOverlay extends ItemizedOverlay<StoreOverlayItem> {
	private static final String tag = "StoreOverlay";

	private List<StoreDetail> stores = null;

	private StoreMapView mapView;

	public StoreOverlay(StoreMapView nMapView, List<StoreDetail> stores) {
		super(Helper.getDrawable(nMapView.getContext(),
				R.drawable.gps_icon));
		this.stores = stores;
		this.mapView = nMapView;
		populate();
	}

	@Override
	protected StoreOverlayItem createItem(int i) {
		StoreOverlayItem oi = new StoreOverlayItem(stores.get(i));
		return oi;
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		Projection projection = mapView.getProjection();
		Helper.mylog(tag, "mapView.getMapCenter()_____"
				+ mapView.getMapCenter());
		Bitmap bitmap = Helper.getDrawable(mapView.getContext(),
				R.drawable.gps_icon).getBitmap();
		int bitMapWidthHalf = bitmap.getWidth()/2;
		int bitMapHeightHalf = bitmap.getHeight()/2;
		for (int index = size() - 1; index >= 0; index--) {
			StoreOverlayItem item = getItem(index);
			Point point = projection.toPixels(item.getPoint(), null);

			Helper.mylog(tag, item.getStore().getAddr() + "_____"
					+ item.getPoint());

			Paint paint2 = new Paint();
			paint2.setColor(Color.WHITE);
			paint2.setStrokeWidth(1);
			paint2.setStyle(Paint.Style.FILL_AND_STROKE);
			paint2.setTextSize(12);
			//canvas.drawBitmap(bitmap, point.x-bitMapWidthHalf, point.y-bitMapHeightHalf, paint2);
			canvas.drawBitmap(bitmap, point.x-bitMapWidthHalf, point.y-bitmap.getHeight() , paint2);
		}
		//FIXME:特别说明，本来不需在这里设置初始化放大级别，不过由于目前在mapview的init中设置合适级时，不能达到效果，改到这里。原因是在init中设备坐标point可能为负。
		if(BrandedConstants.isNeedAdjustZoomlevel){
			this.mapView.setCenterAndZoomlevel();//add 
			BrandedConstants.isNeedAdjustZoomlevel=false;
		}
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
		NoteCloseDelayed noteView = new StoreNote( mapView, mapView
				.getContext(), this.getItem(index).getStore(),index);
		noteView.show();
		return super.onTap(index);
	}

	@Override
	public int size() {
		return stores.size();
	}
}