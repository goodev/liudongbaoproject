package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryVo implements Parcelable, Cloneable {
	public static final Parcelable.Creator<CategoryVo> CREATOR = new Parcelable.Creator<CategoryVo>() {
		public CategoryVo createFromParcel(Parcel in) {
			return new CategoryVo(in);
		}

		@Override
		public CategoryVo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new CategoryVo[size];
		}

	};

	public CategoryVo(Parcel in) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

	}

}
