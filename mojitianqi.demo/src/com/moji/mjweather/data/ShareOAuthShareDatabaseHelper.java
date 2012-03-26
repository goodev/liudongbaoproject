// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ShareOAuthShareDatabaseHelper.java

package com.moji.mjweather.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShareOAuthShareDatabaseHelper extends SQLiteOpenHelper {

	public ShareOAuthShareDatabaseHelper(Context context) {
		super(context, "mojiWeather.db", null, 1);
	}

	public void onCreate(SQLiteDatabase sqlitedatabase) {
		sqlitedatabase
				.execSQL("CREATE TABLE IF NOT EXISTS ACCOUNT(id integer PRIMARY KEY AUTOINCREMENT NOT NULL, username varchar(40), password varchar(40), shareAccountType varchar(20), available varchar(2))");
		sqlitedatabase
				.execSQL("CREATE TABLE IF NOT EXISTS CONTACTS(id integer PRIMARY KEY AUTOINCREMENT NOT NULL, name varchar(40), number varchar(20))");
	}

	public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j) {
		sqlitedatabase.execSQL("DROP TABLE IF EXISTS ACCOUNT");
		sqlitedatabase.execSQL("DROP TABLE IF EXISTS CONTACTS");
		onCreate(sqlitedatabase);
	}
}
