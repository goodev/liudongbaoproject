package com.branded.android.view;

import java.util.List;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import com.branded.android.activity.StoreListActivity;
import com.branded.android.activity.StoreMapActivity;
import com.branded.android.entity.MyLocationDetail;
import com.branded.android.entity.StoreDetail;
import com.branded.android.util.Helper;
import com.branded.android.util.MapMode;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">刘冬宝</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-14 下午02:24:34 <br>
 * 
 */
public class StoreMapView extends MapView {
	private static final String tag = "StoreMapView";
	public static final int defaultZoomLevel = 9;
	private MapController mapCon;
	private List<Overlay> overlays;
	private MyLocationOverlay myLocationOverlay;
	private StoreOverlay storeOverlay = null;
	private StoreMapActivity storeMapActivity;
	private boolean isByAddr;

	/**
	 * @return the isByAddr
	 */
	public boolean isByAddr() {
		return isByAddr;
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public StoreMapView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public StoreMapView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * @param context
	 * @param apiKey
	 */
	public StoreMapView(Context context, String apiKey) {
		super(context, apiKey);
	}

	private List<StoreDetail> getStoreList() {
		return StoreListActivity.mStoreList;
	/*	List<StoreDetail> list = new ArrayList<StoreDetail>();

		StoreDetail store1 = new StoreDetail();
		store1.setAddr("5920 Turney Drive");
		store1.setCc(2);
		store1.setCity("Mississauga");
		store1.setCtry("CA");
		store1.setEm("");
		store1.setFc(1);
		store1.setHrs("");
		store1.setLat(43.580475);
		store1.setLon(-79.726711);
		store1.setPn("905-567-7777");
		store1.setProv("ON");
		store1.setPs("L5M 2R8");
		store1.setSid(72);
		store1.setSn("Dominos Pizza -10285");
		store1.setUrl("");
		list.add(store1);

		StoreDetail store2 = new StoreDetail();
		store2.setAddr("2560 SHEPARD AVE. #8");
		store2.setCc(2);
		store2.setCity("Mississauga");
		store2.setCtry("CA");
		store2.setEm("");
		store2.setFc(1);
		store2.setHrs("");
		store2.setLat(43.580508);
		store2.setLon(-79.6139);
		store2.setPn("905-270-3030");
		store2.setProv("ON");
		store2.setPs("L5A 4C8");
		store2.setSid(73);
		store2.setSn("Dominos Pizza -10295");
		store2.setUrl("");
		list.add(store2);

		StoreDetail store3 = new StoreDetail();
		store3.setAddr("6750 Winston Churchill Blvd.");
		store3.setCc(2);
		store3.setCity("Mississauga");
		store3.setCtry("CA");
		store3.setEm("");
		store3.setFc(1);
		store3.setHrs("");
		store3.setLat(43.584221);
		store3.setLon(-79.765728);
		store3.setPn("905-824-0300");
		store3.setProv("ON");
		store3.setPs("L5N 4C4");
		store3.setSid(74);
		store3.setSn("Dominos Pizza -10344");
		store3.setUrl("");
		list.add(store3);

		return list;
*/	}

	/**
	 * @return the storeMapActivity
	 */
	public StoreMapActivity getStoreMapActivity() {
		return storeMapActivity;
	}

	public void init(StoreMapActivity storeMapActivity, boolean isByAddr) {
		mapCon = getController();
		this.isByAddr = isByAddr;
		this.storeMapActivity = storeMapActivity;
		overlays = getOverlays();
		MyLocationDetail myLocation = null;
//		if (Helper.getCurrenLocation() != null) {
			myLocation = new MyLocationDetail(Helper.getCurrenLocation());
//		} else {
//			myLocation = new MyLocationDetail(getStoreCenter());
//		}

		myLocationOverlay = new MyLocationOverlay(this.getContext(), this,
				myLocation);
		overlays.add(myLocationOverlay);
//		GeoPoint currentLocation = Helper.getCurrenLocation();
//		if (currentLocation == null) {
//			currentLocation = getStoreCenter();
//		} else {
//
//		}
//		mapCon.setCenter(currentLocation);
		mapCon.setZoom(StoreMapView.defaultZoomLevel);


		
		this.storeOverlay = new StoreOverlay(this, getStoreList());
		this.overlays.add(storeOverlay);
		// init map mode
		// setTraffic(true);
		// setSatellite(false);
		// setStreetView(true);

		// this.setSatellite(false);
		// this.setStreetView(true);
		// this.setTraffic(false);

		setCenterAndZoomlevel();
		
		setBuiltInZoomControls(true);
	}

	/**
	 * @param contactOverlay
	 *            the contactOverlay to set
	 */
	public void setContactOverlay(StoreOverlay storeOverlay) {
		this.storeOverlay = storeOverlay;

	}

	//感觉不如用坐标最大和最小位置判断,暂不用，改为setCenterAndZoomlevel来设置中心和放缩级别
//	private GeoPoint getStoreCenter() {
//		List<StoreDetail> list = getStoreList();
//		int count = list.size();
//		Helper.mylog(tag, "getStoreList:" + count);
//		double totalLan = 0.0;
//		double totalLon = 0.0;
//		for (int i = 0; i < count; i++) {
//			StoreDetail store = list.get(i);
//			totalLan += store.getLat();
//			totalLon += store.getLon();
//		}
//		return (new GeoPoint((int) (totalLan * 1000000 / count),
//				(int) (totalLon * 1000000 / count)));
//	}

	public void update(MapMode mapMode) {
		setTraffic(false);
		setSatellite(false);
		setStreetView(false);
		switch (mapMode) {
		case Satellite:
			this.setSatellite(true);
			break;
		case Traffic:
			this.setTraffic(true);
			break;
		case StreetView:
			this.setStreetView(true);
			break;
		case Normal:
			break;
		}
		this.invalidate();

	}
	public void setCenterAndZoomlevel(){

		DisplayMetrics dm = getContext().getApplicationContext().getResources().getDisplayMetrics();
		//计算中点
		long minX=0;
		long minY=0;
		long maxX=0;
		long maxY=0;
		for (int j = 0; j < this.storeOverlay.size(); j++) {
			StoreOverlayItem item = this.storeOverlay.getItem(j);
			Point point = Helper.gePointToPixels(this, item.getPoint());		
			if(j==0){
				minX = point.x;
				minY = point.y;
				maxX = point.x;
				maxY = point.y;
			}
			if(point.x<minX){
				minX = point.x;
			}
			if(point.y<minY){
				minY = point.y;
			}
			if(point.x>maxX){
				maxX = point.x;
			}
			if(point.y>maxY){
				maxY = point.y;
			}
		}
		//加上自己坐标判断
		Point point2 = Helper.gePointToPixels(this, Helper.getCurrenLocation());
		if(point2.x<minX){
			minX = point2.x;
		}
		if(point2.y<minY){
			minY = point2.y;
		}
		if(point2.x>maxX){
			maxX = point2.x;
		}
		if(point2.y>maxY){
			maxY = point2.y;
		}
		//
		Projection projection = getProjection();
		GeoPoint center = projection.fromPixels( (int)(minX+maxX)/2,(int)(minY+maxY)/2);

		mapCon.setCenter(center);
		mapCon.setZoom(StoreMapView.defaultZoomLevel);
//		Log.e("current zoom level:",getZoomLevel()+"");
		for (int i = 20; i > 0; i--) {
			this.mapCon.setZoom(i);
			boolean canDisplayAll = true;
			for (int j = 0; j < this.storeOverlay.size()+1; j++) {//多加一个自己
				Point point=null;
				if(j < this.storeOverlay.size()){
					StoreOverlayItem item = this.storeOverlay.getItem(j);
					point = Helper.gePointToPixels(this, item.getPoint());
				}else{//自己
					point = point2;
				}
				//留点边缘缝隙
				boolean canDisplay = ((dm.widthPixels - 20) > point.x && point.x > 30)&& ((dm.heightPixels - 10) > point.y && point.y > 30);
				canDisplayAll &= canDisplay;
				if(!canDisplayAll){
					break;
				}
			}

			if (canDisplayAll)
				return;
		}
		
	
	}
}
