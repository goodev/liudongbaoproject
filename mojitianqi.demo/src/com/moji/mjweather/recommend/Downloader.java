// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Downloader.java

package com.moji.mjweather.recommend;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.RemoteViews;
import android.widget.Toast;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.moji.mjweather.recommend:
//            SoftWare, AppUtil, AdUtil, RecommendDetailActivity

public final class Downloader
{
    static final class DownloadAsyncTask extends AsyncTask
    {
        final class UpdateThread extends Thread
        {

            public void run()
            {
                int i = ratio.get();
_L2:
                if(i > 100)
                    break; /* Loop/switch isn't completed */
                mNotification.contentView.setProgressBar(0x7f0d0211, 100, i, false);
                mNotification.contentView.setTextViewText(0x7f0d020e, (new StringBuilder()).append(i).append("%").toString());
                nm.notify(mNotifyId, mNotification);
                Thread.sleep(500L);
                i = ratio.get();
                if(true) goto _L2; else goto _L1
                InterruptedException interruptedexception;
                interruptedexception;
                interruptedexception.printStackTrace();
_L1:
            }

            final DownloadAsyncTask this$0;

            UpdateThread()
            {
                this$0 = DownloadAsyncTask.this;
                super();
            }
        }


        protected transient Boolean doInBackground(String as[])
        {
            HttpURLConnection httpurlconnection = null;
            httpurlconnection = (HttpURLConnection)(new URL(as[0])).openConnection();
            httpurlconnection.setConnectTimeout(30000);
            httpurlconnection.setReadTimeout(30000);
            if(httpurlconnection.getResponseCode() != 200) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            FileOutputStream fileoutputstream;
            InputStream inputstream;
            i = httpurlconnection.getContentLength();
            File file = new File((new StringBuilder()).append("/sdcard/moji/mojiDownload/").append(mFileName).append(".xxx").toString());
            if(!file.exists())
                file.createNewFile();
            byte abyte0[] = new byte[4096];
            j = 0;
            fileoutputstream = new FileOutputStream(file);
            inputstream = httpurlconnection.getInputStream();
            mUpdateThread.start();
            do
            {
                int k = inputstream.read(abyte0);
                if(k <= 0)
                    break;
                fileoutputstream.write(abyte0, 0, k);
                j += k;
                Integer ainteger[] = new Integer[1];
                ainteger[0] = Integer.valueOf((j * 100) / i);
                publishProgress(ainteger);
            } while(true);
              goto _L3
            MalformedURLException malformedurlexception;
            malformedurlexception;
            Downloader.sendFailureBroadcast(mContext, mAppId);
            malformedurlexception.printStackTrace();
            if(httpurlconnection != null)
                httpurlconnection.disconnect();
_L6:
            Boolean boolean1 = Boolean.valueOf(false);
_L4:
            return boolean1;
_L3:
            Boolean boolean2;
            fileoutputstream.close();
            inputstream.close();
            if(j != i)
                break; /* Loop/switch isn't completed */
            boolean2 = Boolean.valueOf(true);
            boolean1 = boolean2;
            if(httpurlconnection != null)
                httpurlconnection.disconnect();
            if(true) goto _L4; else goto _L2
_L2:
            if(httpurlconnection != null)
                httpurlconnection.disconnect();
            continue; /* Loop/switch isn't completed */
            IOException ioexception;
            ioexception;
            Downloader.sendFailureBroadcast(mContext, mAppId);
            ioexception.printStackTrace();
            if(httpurlconnection != null)
                httpurlconnection.disconnect();
            if(true) goto _L6; else goto _L5
_L5:
            Exception exception;
            exception;
            if(httpurlconnection != null)
                httpurlconnection.disconnect();
            throw exception;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onPostExecute(Boolean boolean1)
        {
            if(mUpdateThread.isAlive())
                mUpdateThread.interrupt();
            mNotification.contentView.setViewVisibility(0x7f0d0211, 8);
            mNotification.contentView.setTextViewText(0x7f0d020e, (new StringBuilder()).append(ratio.get()).append("%").toString());
            mNotification.contentView.setViewVisibility(0x7f0d0212, 0);
            if(boolean1.booleanValue())
            {
                mNotification.tickerText = mContext.getString(0x7f0b0261);
                mNotification.contentView.setTextViewText(0x7f0d0212, mContext.getString(0x7f0b0261));
            } else
            {
                mNotification.tickerText = mContext.getString(0x7f0b0262);
                mNotification.contentView.setTextViewText(0x7f0d0212, mContext.getString(0x7f0b0262));
            }
            mNotification.flags = 16;
            nm.notify(mNotifyId, mNotification);
            if(boolean1.booleanValue())
            {
                Intent intent = new Intent("com.moji.mjweather.recommend.package_download_finish");
                intent.setData(Uri.parse("package:"));
                intent.putExtra("appid", mAppId);
                mContext.sendBroadcast(intent);
                File file = new File((new StringBuilder()).append("/sdcard/moji/mojiDownload/").append(mFileName).append(".xxx").toString());
                if(file != null && mFileName != null)
                {
                    file.renameTo(new File("/sdcard/moji/mojiDownload/", mFileName));
                    file.delete();
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    intent1.setFlags(0x14000000);
                    intent1.setDataAndType(Uri.parse((new StringBuilder()).append("file:///sdcard/moji/mojiDownload/").append(mFileName).toString()), "application/vnd.android.package-archive");
                    mContext.startActivity(intent1);
                }
                if(mIsDirect)
                    AdUtil.uploadStatsDDLS(mPlace, mPosition, mAppId);
                else
                    AdUtil.uploadStatsDLS(mPlace, mPosition, mAppId);
            } else
            {
                Downloader.sendFailureBroadcast(mContext, mAppId);
            }
            nm.cancel(mNotifyId);
            Downloader.downloading.remove(mFileName);
            synchronized(sync_obj)
            {
                notifyCount = -1 + notifyCount;
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Boolean)obj);
        }

        protected void onPreExecute()
        {
            nm = (NotificationManager)mContext.getSystemService("notification");
            long l = System.currentTimeMillis();
            mNotification = new Notification(0x1080081, mContext.getString(0x7f0b0260), l);
            mNotification.icon = 0x1080081;
            Notification notification = mNotification;
            notification.flags = 2 | notification.flags;
            RemoteViews remoteviews = new RemoteViews(mContext.getPackageName(), 0x7f03005c);
            mNotification.contentView = remoteviews;
            mNotification.contentView.setTextViewText(0x7f0d020f, mAppName);
            Intent intent = new Intent(mContext, com/moji/mjweather/recommend/RecommendDetailActivity);
            intent.setFlags(0x14000000);
            intent.putExtra("appid", mAppId);
            intent.putExtra("title", mAppName);
            intent.putExtra("place", mPlace);
            intent.putExtra("position", mPosition);
            PendingIntent pendingintent = PendingIntent.getActivity(mContext, mNotifyId, intent, 0x8000000);
            mNotification.contentIntent = pendingintent;
            nm.notify(mNotifyId, mNotification);
            Intent intent1 = new Intent("com.moji.mjweather.recommend.package_downloading");
            intent1.setData(Uri.parse("package:"));
            intent1.putExtra("appid", mAppId);
            mContext.sendBroadcast(intent1);
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            ratio.set(ainteger[0].intValue());
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }

        private static final int CONNECTTIMEOUT = 30000;
        private static final int DOWNLOAD_BUFFER_SIZE = 4096;
        private static final int MAX_PROGRESS = 100;
        private static final int READTIMEOUT = 30000;
        private static int notifyCount = 0;
        private static int notifyId = 0;
        private static Object sync_obj = new Object();
        private String mAppId;
        private String mAppName;
        private Context mContext;
        private String mFileName;
        private boolean mIsDirect;
        private Notification mNotification;
        private int mNotifyId;
        private int mPlace;
        private int mPosition;
        private UpdateThread mUpdateThread;
        private NotificationManager nm;
        private AtomicInteger ratio;






        DownloadAsyncTask(Context context, String s, String s1, String s2, boolean flag, int i, int j)
        {
            ratio = new AtomicInteger(0);
            mContext = context;
            mIsDirect = flag;
            mAppId = s;
            mAppName = s1;
            mFileName = s2;
            mPlace = i;
            mPosition = j;
            synchronized(sync_obj)
            {
                if(notifyCount == 0)
                    notifyId = 0;
                int k = notifyId;
                notifyId = k + 1;
                mNotifyId = k;
                notifyCount = 1 + notifyCount;
            }
            mUpdateThread = new UpdateThread();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }
    }


    public Downloader()
    {
    }

    public static void download(boolean flag, int i, int j, SoftWare software, Context context)
    {
        if(software.getSoftstate() != 1)
            if(!Environment.getExternalStorageState().equals("mounted"))
            {
                Toast.makeText(context, 0x7f0b025f, 1).show();
            } else
            {
                String s = software.getAppDownPath();
                String s1 = (new StringBuilder()).append(software.getAppid()).append(".apk").toString();
                if(s1 != null && AppUtil.judgeFileExist(context, s1))
                {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(0x10000000);
                    intent.setDataAndType(Uri.parse((new StringBuilder()).append("file:///sdcard/moji/mojiDownload/").append(s1).toString()), "application/vnd.android.package-archive");
                    context.startActivity(intent);
                } else
                if(downloading.contains(s1))
                    Toast.makeText(context, 0x7f0b0260, 0).show();
                else
                if(((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo() == null)
                {
                    Toast.makeText(context, 0x7f0b0264, 0).show();
                } else
                {
                    DownloadAsyncTask downloadasynctask;
                    String as[];
                    if(flag)
                        AdUtil.uploadStatsDDL(i, j, software.getAppid());
                    else
                        AdUtil.uploadStatsDL(i, j, software.getAppid());
                    downloading.add(s1);
                    downloadasynctask = new DownloadAsyncTask(context.getApplicationContext(), software.getAppid(), software.getAppName(), s1, flag, i, j);
                    as = new String[1];
                    as[0] = s;
                    downloadasynctask.execute(as);
                }
            }
    }

    private static void sendFailureBroadcast(Context context, String s)
    {
        Intent intent = new Intent("com.moji.mjweather.recommend.package_download_failure");
        intent.setData(Uri.parse("package:"));
        intent.putExtra("appid", s);
        context.sendBroadcast(intent);
    }

    public static ArrayList downloading = new ArrayList();


}
