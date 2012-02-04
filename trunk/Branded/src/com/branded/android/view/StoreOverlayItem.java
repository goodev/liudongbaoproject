/**
 * 
 */
package com.branded.android.view;

import com.branded.android.entity.StoreDetail;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">Áõ¶¬±¦</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-14 ÏÂÎç02:25:05 <br>
 * 
 */
public class StoreOverlayItem extends OverlayItem {
	private StoreDetail store;

	/**
	 * @param point
	 * @param title
	 * @param snippet
	 */
	public StoreOverlayItem(GeoPoint point, String title, String snippet) {
		super(point, title, snippet);
	}

	public StoreOverlayItem(StoreDetail storeInfo) {
		this(new GeoPoint((int) (Double.valueOf(storeInfo.getLat()) * 1000000),
				(int) (Double.valueOf(storeInfo.getLon()) * 1000000)), "", "");
		this.store = storeInfo;

	}

	public StoreDetail getStore() {
		return store;
	}

}
