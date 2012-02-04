/**
 * 用于邮编或地址查询坐标的返回值封装
 */
package com.branded.android.entity;

public class LocAddr {
	String addr; // result/<formatted_address>Ontario M1W 2M3,

	// Canada</formatted_address>
	String lat; // result/geometry/location/<lat>43.7930845</lat>

	String lon; // result/geometry/location/<lng>-79.3167161</lng>

	public String getAddr() {
		return addr;
	}

	public String getLat() {
		return lat;
	}

	public String getLon() {
		return lon;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
					public void setLat(String lat) {
		this.lat = lat;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
}
