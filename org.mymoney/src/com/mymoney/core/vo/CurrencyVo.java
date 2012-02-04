package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class CurrencyVo implements Parcelable, Cloneable {
	public static final Parcelable.Creator<CurrencyVo> CREATOR = new Parcelable.Creator<CurrencyVo>() {
		public CurrencyVo createFromParcel(Parcel in) {
			return new CurrencyVo(in);
		}

		@Override
		public CurrencyVo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new CurrencyVo[size];
		}

	};
	private int _id;
	private String name;
	private String code;
	private String icon;

	private CurrencyVo(Parcel in) {
		this._id = in.readInt();
		this.name = in.readString();
		this.code = in.readString();
		this.icon = in.readString();
	}

	public CurrencyVo() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(_id);
		dest.writeString(name);
		dest.writeString(code);
		dest.writeString(icon);
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _id;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CurrencyVo)) {
			return false;
		}
		CurrencyVo other = (CurrencyVo) obj;
		if (_id != other._id) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (icon == null) {
			if (other.icon != null) {
				return false;
			}
		} else if (!icon.equals(other.icon)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CurrencyVo [_id=" + _id + ", "
				+ (name != null ? "name=" + name + ", " : "")
				+ (code != null ? "code=" + code + ", " : "")
				+ (icon != null ? "icon=" + icon : "") + "]";
	}

}
