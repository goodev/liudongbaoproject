/**
 * return by 	getcouponlist
 */
package com.branded.android.entity;

import java.util.List;

public class BaCouponInfo {
	int count;

	List<BaCoupon> list;

	public int getCount() {
		return count;
	}

	public List<BaCoupon> getList() {
		return list;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void setList(List<BaCoupon> list) {
		this.list = list;
	}
}
