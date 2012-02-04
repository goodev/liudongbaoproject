/**
 * 
 */
package com.branded.android.view;

import com.branded.android.entity.MyLocationDetail;
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
 * @creatdate 2010-5-23 ÏÂÎç04:06:00 <br>
 * 
 */
public class MyLocationOverlayItem extends OverlayItem {
	private MyLocationDetail mylocation;

	/**
	 * @param point
	 * @param title
	 * @param snippet
	 */
	public MyLocationOverlayItem(GeoPoint point, String title, String snippet) {
		super(point, title, snippet);
	}

	public MyLocationOverlayItem(MyLocationDetail mylocation) {
		this(mylocation.location, "", "");
		this.mylocation = mylocation;

	}

	public MyLocationDetail getMylocation() {
		return mylocation;
	}

}
