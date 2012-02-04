package com.mymoney.core.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import gu;

public class MyMoneyContentProvider extends ContentProvider
{
  private static final UriMatcher a = new UriMatcher(-1);
  private static final String[] b;

  static
  {
    a.addURI("com.mymoney.provider.MyMoney", "preference", 1);
    String[] arrayOfString = new String[1];
    String str = gu.q;
    arrayOfString[0] = str;
    b = arrayOfString;
  }

  private Cursor a()
  {
    String[] arrayOfString = b;
    MatrixCursor localMatrixCursor = new MatrixCursor(arrayOfString, 1);
    MatrixCursor.RowBuilder localRowBuilder1 = localMatrixCursor.newRow();
    Boolean localBoolean = Boolean.valueOf(gu.h());
    MatrixCursor.RowBuilder localRowBuilder2 = localRowBuilder1.add(localBoolean);
    return localMatrixCursor;
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("不支持删除操作!");
  }

  public String getType(Uri paramUri)
  {
    switch (a.match(paramUri))
    {
    default:
      String str = "Unknown URI " + paramUri;
      throw new IllegalArgumentException(str);
    case 1:
    }
    return "vnd.android.cursor.item/vnd.mymoney.preference";
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("不支持新增操作!");
  }

  public boolean onCreate()
  {
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    switch (a.match(paramUri))
    {
    default:
      String str = "Unknown URI " + paramUri;
      throw new IllegalArgumentException(str);
    case 1:
    }
    return a();
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("不支持更新操作!");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.provider.MyMoneyContentProvider
 * JD-Core Version:    0.6.0
 */