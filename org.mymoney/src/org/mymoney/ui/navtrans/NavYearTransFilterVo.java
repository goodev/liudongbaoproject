package org.mymoney.ui.navtrans;

import java.util.ArrayList;

public class NavYearTransFilterVo implements Cloneable {

	private static NavYearTransFilterVo instance = null;
	public ArrayList<Integer> categorys = new ArrayList<Integer>();
	public ArrayList<Integer> accounts = new ArrayList<Integer>();
	public ArrayList<Integer> projects = new ArrayList<Integer>();
	public ArrayList<Integer> corporations = new ArrayList<Integer>();

	public static final NavYearTransFilterVo getNavYearTransFilterVo() {
		if (instance == null) {
			instance = new NavYearTransFilterVo();
			instance.init();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "NavYearTransFilterVo ["
				+ (categorys != null ? "categorys=" + categorys + ", " : "")
				+ (accounts != null ? "accounts=" + accounts + ", " : "")
				+ (projects != null ? "projects=" + projects + ", " : "")
				+ (corporations != null ? "corporations=" + corporations : "")
				+ "]";
	}

	private NavYearTransFilterVo() {
		super();

	}

	public void init() {

	}

}
