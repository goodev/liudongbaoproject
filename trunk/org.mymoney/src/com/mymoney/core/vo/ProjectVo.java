package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class ProjectVo
  implements Parcelable
{
	public static final Parcelable.Creator<ProjectVo> CREATOR = new Parcelable.Creator<ProjectVo>() {
		public ProjectVo createFromParcel(Parcel in) {
			return new ProjectVo(in);
		}

		@Override
		public ProjectVo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new ProjectVo[size];
		}

	};

	public ProjectVo(Parcel in) {
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
 * Qualified Name:     com.mymoney.core.vo.ProjectVo
 * JD-Core Version:    0.6.0
 */