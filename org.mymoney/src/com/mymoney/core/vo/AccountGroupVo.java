package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class AccountGroupVo implements Parcelable, Cloneable {
	public static final Parcelable.Creator<AccountGroupVo> CREATOR = new Parcelable.Creator<AccountGroupVo>() {
		public AccountGroupVo createFromParcel(Parcel in) {
			return new AccountGroupVo(in);
		}

		@Override
		public AccountGroupVo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new AccountGroupVo[size];
		}

	};
	private int _id;
	private String name;
	private String path;
	private int depth;

	private AccountGroupVo(Parcel in) {
		this._id = in.readInt();
		this.name = in.readString();
		this.path = in.readString();
		this.depth = in.readInt();
	}

	public AccountGroupVo() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(_id);
		dest.writeString(name);
		dest.writeString(path);
		dest.writeInt(depth);
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _id;
		result = prime * result + depth;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		if (!(obj instanceof AccountGroupVo)) {
			return false;
		}
		AccountGroupVo other = (AccountGroupVo) obj;
		if (_id != other._id) {
			return false;
		}
		if (depth != other.depth) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (path == null) {
			if (other.path != null) {
				return false;
			}
		} else if (!path.equals(other.path)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AccountGroupVo [_id=" + _id + ", "
				+ (name != null ? "name=" + name + ", " : "")
				+ (path != null ? "path=" + path + ", " : "") + "depth="
				+ depth + "]";
	}

}
