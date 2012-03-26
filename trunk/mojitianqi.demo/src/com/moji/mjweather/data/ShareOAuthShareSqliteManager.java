// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ShareOAuthShareSqliteManager.java

package com.moji.mjweather.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.moji.mjweather.data:
//            ShareOAuthShareDatabaseHelper

public class ShareOAuthShareSqliteManager {

	public ShareOAuthShareSqliteManager(Context context) {
		dbOpenHelper = new ShareOAuthShareDatabaseHelper(context);
	}

	public boolean checkAvailable(String s, String s1) {
		boolean flag = true;
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		String as[] = new String[2];
		as[0] = s;
		as[1] = s1;
		Cursor cursor = sqlitedatabase
				.rawQuery(
						"select available from ACCOUNT where username=? and shareAccountType=?",
						as);
		if (cursor.moveToFirst()) {
			if (!"1".equals(cursor.getString(cursor.getColumnIndex("available"))))
				flag = false;
		} else {
			flag = false;
		}
		return flag;
	}

	public void close() {
		dbOpenHelper.getReadableDatabase().close();
	}

	public void deleteAccount(Integer integer) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getWritableDatabase();
		String as[] = new String[1];
		as[0] = integer.toString();
		sqlitedatabase.execSQL("delete from ACCOUNT where id=?", as);
	}

	public void deleteContact(String s) {
		dbOpenHelper.getReadableDatabase().execSQL(
				(new StringBuilder())
						.append("delete from CONTACTS where number='")
						.append(s).append("'").toString());
	}

	public void deleteContactById(String s) {
		dbOpenHelper.getReadableDatabase().execSQL(
				(new StringBuilder()).append("delete from CONTACTS where id='")
						.append(s).append("'").toString());
	}

	public Cursor getBlogTableCursor() {
		return dbOpenHelper.getWritableDatabase().rawQuery(
				"select * from ACCOUNT ORDER BY id ASC", null);
	}

	public Cursor getContactTableCursor() {
		return dbOpenHelper.getWritableDatabase().rawQuery(
				"select * from CONTACTS", null);
	}

	public Cursor getContactsInfo(String s) {
		return dbOpenHelper.getWritableDatabase().rawQuery(
				(new StringBuilder())
						.append("select * from CONTACTS where id in( ")
						.append(s).append(")").toString(), null);
	}

	public String getPassword(Integer integer) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		String as[] = new String[1];
		as[0] = integer.toString();
		Cursor cursor = sqlitedatabase.rawQuery(
				"select password from ACCOUNT where id=?", as);
		String s;
		if (cursor.moveToFirst())
			s = cursor.getString(cursor.getColumnIndex("password"));
		else
			s = null;
		return s;
	}

	public boolean getSendSMSCount() {
		boolean flag = false;
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		Cursor cursor = sqlitedatabase.rawQuery(
				"select count(*) from CONTACTS", null);
		cursor.moveToFirst();
		if (cursor.getLong(0) > 0) {
			sqlitedatabase.close();
			cursor.close();
			flag = true;
		} else {
			sqlitedatabase.close();
			cursor.close();
		}
		return flag;
	}

	public String getShareAccountType(Integer integer) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		String as[] = new String[1];
		as[0] = integer.toString();
		Cursor cursor = sqlitedatabase.rawQuery(
				"select shareAccountType from ACCOUNT where id=?", as);
		String s;
		if (cursor.moveToFirst())
			s = cursor.getString(cursor.getColumnIndex("shareAccountType"));
		else
			s = null;
		return s;
	}

	public boolean getShareMicroBlogCount() {
		boolean flag = false;
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		Cursor cursor = sqlitedatabase.rawQuery("select count(*) from ACCOUNT",
				null);
		cursor.moveToFirst();
		if (cursor.getLong(0) > 0L) {
			cursor.close();
			sqlitedatabase.close();
			flag = true;
		} else {
			cursor.close();
			sqlitedatabase.close();
		}
		return flag;
	}

	public String getUsername(Integer integer) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		String as[] = new String[1];
		as[0] = integer.toString();
		Cursor cursor = sqlitedatabase.rawQuery(
				"select username from ACCOUNT where id=?", as);
		String s;
		if (cursor.moveToFirst())
			s = cursor.getString(cursor.getColumnIndex("username"));
		else
			s = null;
		return s;
	}

	public void insert(String s, String s1, String s2) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		Object aobj[] = new Object[3];
		aobj[0] = s;
		aobj[1] = s1;
		aobj[2] = s2;
		sqlitedatabase.execSQL(
				"insert into CONTACTS(id,name,number) values(?,?,?)", aobj);
	}

	public boolean isRepeatRegister(String s, String s1) {
		boolean flag = true;
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getReadableDatabase();
		String as[] = new String[2];
		as[0] = s;
		as[1] = s1;
		Cursor cursor = sqlitedatabase
				.rawQuery(
						"select count(*) from ACCOUNT where username=? and shareAccountType=?",
						as);
		cursor.moveToFirst();
		if (cursor.getLong(0) <= 0L)
			flag = false;
		return flag;
	}

	public void resetPassword(String s, String s1, String s2, boolean flag) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getWritableDatabase();
		Object aobj[] = new Object[4];
		aobj[0] = Boolean.valueOf(flag);
		aobj[1] = s1;
		aobj[2] = s;
		aobj[3] = s2;
		sqlitedatabase
				.execSQL(
						"update ACCOUNT set available=?, password=? where username=? and shareAccountType=?",
						aobj);
	}

	public void saveAccount(String s, String s1, String s2, boolean flag) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getWritableDatabase();
		Object aobj[] = new Object[4];
		aobj[0] = s;
		aobj[1] = s1;
		aobj[2] = s2;
		aobj[3] = Boolean.valueOf(flag);
		sqlitedatabase
				.execSQL(
						"insert into ACCOUNT (username,password,shareAccountType,available) values(?,?,?,?)",
						aobj);
	}

	public void updateAvailable(String s, String s1, boolean flag) {
		SQLiteDatabase sqlitedatabase = dbOpenHelper.getWritableDatabase();
		Object aobj[] = new Object[3];
		aobj[0] = Boolean.valueOf(flag);
		aobj[1] = s;
		aobj[2] = s1;
		sqlitedatabase
				.execSQL(
						"update ACCOUNT set available=? where username=? and shareAccountType=?",
						aobj);
	}

	public ShareOAuthShareDatabaseHelper dbOpenHelper;
}
