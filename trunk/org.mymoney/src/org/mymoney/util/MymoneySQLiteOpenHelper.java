package org.mymoney.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MymoneySQLiteOpenHelper extends SQLiteOpenHelper {
	private static SQLiteDatabase database = null;
	private static final String DATABASE_NAME = "mymoney.sqlite";
	private static final int DATABASE_VERSION = 1;
	private Context context = null;
	private String database_path = null;

	public MymoneySQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		database_path = "/data/data/" + context.getPackageName()
				+ "/databases/";
		this.context = context;
	}

	@Override
	public synchronized void close() {
		super.close();
		database = null;
	}

	@Override
	public synchronized SQLiteDatabase getWritableDatabase() {
		if (database != null && database.isOpen())
			return database;
		if (new java.io.File(database_path + DATABASE_NAME).exists()) {
			database = super.getWritableDatabase();
			return database;
		}
		InputStream localInputStream = null;
		FileOutputStream localFileOutputStream = null;
		try {
			AssetManager localAssetManager = this.context.getResources()
					.getAssets();
			localInputStream = localAssetManager.open(DATABASE_NAME);
			new java.io.File(database_path).mkdirs();
			localFileOutputStream = new FileOutputStream(database_path
					+ DATABASE_NAME);
			byte[] arrayOfByte = new byte[1024];
			while (true) {
				int j = localInputStream.read(arrayOfByte);
				if (j <= 0)
					break;
				localFileOutputStream.write(arrayOfByte, 0, j);
			}
		} catch (Exception localIOException) {
			localIOException.printStackTrace();
		}
		try {
			localFileOutputStream.close();
			localInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		database = super.getWritableDatabase();
		return database;

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
