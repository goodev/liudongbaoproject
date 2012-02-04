package com.branded.android.util;

import android.location.Location;

import com.branded.android.entity.StoreDetail;

public class StoreDetailComparator implements java.util.Comparator<StoreDetail>{
	public String getLatStr() {
		return latStr;
	}
	public void setLatStr(String latStr) {
		this.latStr = latStr;
	}
	public String getLonStr() {
		return lonStr;
	}
	public void setLonStr(String lonStr) {
		this.lonStr = lonStr;
	}
	private String latStr;
	private String lonStr;
	public int compare(StoreDetail object1, StoreDetail object2) {
		// TODO Auto-generated method stub
		float []results = new float[2];
		Location.distanceBetween(Double.valueOf(latStr),Double.valueOf(lonStr),object1.getLat(), object1.getLon(), results);
		float []results2 = new float[2];
		Location.distanceBetween(Double.valueOf(latStr),Double.valueOf(lonStr),object2.getLat(), object2.getLon(), results2);

		if(results[0]>results2[0]){
			return 1;
		}else if(results[0]<results2[0]){
			return -1;
		}else{
			return 0;
		}
		
	}

}
