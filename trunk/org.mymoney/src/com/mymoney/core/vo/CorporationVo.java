package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class CorporationVo
  implements Parcelable
{
	public static final Parcelable.Creator<CorporationVo> CREATOR = new Parcelable.Creator<CorporationVo>() {
		public CorporationVo createFromParcel(Parcel in) {
			return new CorporationVo(in);
		}

		@Override
		public CorporationVo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new CorporationVo[size];
		}

	};

	public CorporationVo(Parcel in) {
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

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.vo.CorporationVo
 * JD-Core Version:    0.6.0
 */