package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class AccountVo implements Parcelable, Cloneable {
	public static final Parcelable.Creator<AccountVo> CREATOR = new Parcelable.Creator<AccountVo>() {
		public AccountVo createFromParcel(Parcel in) {
			return new AccountVo(in);
		}

		@Override
		public AccountVo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new AccountVo[size];
		}

	};

	public AccountVo(Parcel in) {
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
