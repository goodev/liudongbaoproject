package com.flurry.android;

import android.util.Log;

public class Flog
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  private static boolean a = 0;

  static int a(String paramString1, String paramString2)
  {
    if (a);
    for (int i = 0; ; i = Log.d(paramString1, paramString2))
      return i;
  }

  static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a);
    for (int i = 0; ; i = Log.d(paramString1, paramString2, paramThrowable))
      return i;
  }

  static boolean a(String paramString)
  {
    return Log.isLoggable(paramString, 3);
  }

  static int b(String paramString1, String paramString2)
  {
    if (a);
    for (int i = 0; ; i = Log.e(paramString1, paramString2))
      return i;
  }

  static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a);
    for (int i = 0; ; i = Log.e(paramString1, paramString2, paramThrowable))
      return i;
  }

  static int c(String paramString1, String paramString2)
  {
    if (a);
    for (int i = 0; ; i = Log.w(paramString1, paramString2))
      return i;
  }

  public static void disableLog()
  {
    a = 1;
  }

  public static void enableLog()
  {
    a = 0;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.flurry.android.Flog
 * JD-Core Version:    0.6.0
 */