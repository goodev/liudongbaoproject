package com.branded.android.entity;

import java.util.ArrayList;
import java.util.HashMap;

import android.graphics.Bitmap;

public class Flyer {
	int fid;

	String ftitle;

	String fvdate;

	int ptype;

	int rtype;

	int pages;

	String fbrief;

	HashMap<Integer,Bitmap>  imgMap;//不是一起返回的，是单独返回的。
	
	public int getFid() {
		return fid;
	}

	public String getFtitle() {
		return ftitle;
	}

	public String getFvdate() {
		return fvdate;
	}

	public int getPages() {
		return pages;
	}

	public int getPtype() {
		return ptype;
	}

	public int getRtype() {
		return rtype;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public void setFvdate(String fvdate) {
		this.fvdate = fvdate;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}
	public void setRtype(int rtype) {
		this.rtype = rtype;
	}
	public String getFbrief() {
		return fbrief;
	}

	public void setFbrief(String fbrief) {
		this.fbrief = fbrief;
	}
	public HashMap<Integer, Bitmap> getImgMap() {
		return imgMap;
	}

	public void setImgMap(HashMap<Integer, Bitmap> imgMap) {
		this.imgMap = imgMap;
	}
}
