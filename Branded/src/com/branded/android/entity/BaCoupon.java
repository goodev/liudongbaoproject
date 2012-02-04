package com.branded.android.entity;

import android.graphics.Bitmap;

public class BaCoupon {
	int cid;

	String ctitle;

	String ccode;

	String cvdate;

	String cvtime;

	int ctype;

	String cbrief;
	

	Bitmap img;//小图标 不是一起返回的，是单独返回的。


	Bitmap 	barImg;//ccode's barcode，单独返回
	
	Bitmap bigImg;//大图标
	
	
	
	
	public String getCcode() {
		return ccode;
	}

	public int getCid() {
		return cid;
	}

	public String getCtitle() {
		return ctitle;
	}

	public int getCtype() {
		return ctype;
	}

	public String getCvdate() {
		return cvdate;
	}

	public String getCvtime() {
		return cvtime;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	public void setCvdate(String cvdate) {
		this.cvdate = cvdate;
	}
	public void setCvtime(String cvtime) {
		this.cvtime = cvtime;
	}
	public String getCbrief() {
		return cbrief;
	}

	public void setCbrief(String cbrief) {
		this.cbrief = cbrief;
	}
	public Bitmap getImg() {
		return img;
	}

	public void setImg(Bitmap img) {
		this.img = img;
	}
	public Bitmap getBarImg() {
		return barImg;
	}

	public void setBarImg(Bitmap barImg) {
		this.barImg = barImg;
	}
	public Bitmap getBigImg() {
		return bigImg;
	}

	public void setBigImg(Bitmap bigImg) {
		this.bigImg = bigImg;
	}
}
