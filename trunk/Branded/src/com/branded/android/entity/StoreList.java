package com.branded.android.entity;

import java.util.List;

public class StoreList {
	int count;

	List<StoreDetail> list;

	public int getCount() {
		return count;
	}

	public List<StoreDetail> getList() {
		return list;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void setList(List<StoreDetail> list) {
		this.list = list;
	}
}
