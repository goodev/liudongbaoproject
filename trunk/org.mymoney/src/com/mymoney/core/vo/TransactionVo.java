package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class TransactionVo implements Parcelable {
	public static final Parcelable.Creator<TransactionVo> CREATOR = new Parcelable.Creator<TransactionVo>() {
		public TransactionVo createFromParcel(Parcel in) {
			return new TransactionVo(in);
		}

		@Override
		public TransactionVo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new TransactionVo[size];
		}

	};

	public TransactionVo(Parcel in) {
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
