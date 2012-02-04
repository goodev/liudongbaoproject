/**
 * (list)return by 	getstorecities
 */
package com.branded.android.entity;

public class City {
	String ctry;// contry
	String prov;
	String city;

	public String getCity() {
		return city;
	}

	public String getCtry() {
		return ctry;
	}

	public String getProv() {
		return prov;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCtry(String ctry) {
		this.ctry = ctry;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}
}
