/**
 * return by getflyerlist
 */
package com.branded.android.entity;

import java.util.List;

public class FlyerList {
	int count;

	List<Flyer> list;

	public int getCount() {
		return count;
	}

	public List<Flyer> getList() {
		return list;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void setList(List<Flyer> list) {
		this.list = list;
	}
}
