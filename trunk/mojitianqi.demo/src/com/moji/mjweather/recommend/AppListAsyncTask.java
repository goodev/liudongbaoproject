// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AppListAsyncTask.java

package com.moji.mjweather.recommend;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import com.moji.mjweather.Gl;

// Referenced classes of package com.moji.mjweather.recommend:
//            ProtocalProxy

public final class AppListAsyncTask extends AsyncTask
{
    public static interface ListCallBack
    {

        public abstract void doCallBack(Message message);
    }


    public AppListAsyncTask(Context context1, int i)
    {
        mCallBack = null;
        context = context1;
        place = i;
    }

    protected transient Integer doInBackground(ListCallBack alistcallback[])
    {
        mCallBack = alistcallback[0];
        return Integer.valueOf(ProtocalProxy.getAppListReq(context, false, place));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((ListCallBack[])aobj);
    }

    protected void onPostExecute(Integer integer)
    {
        super.onPostExecute(integer);
        Message message = new Message();
        if(integer.intValue() == 0)
        {
            message.what = 1;
            Gl.saveADUpdateSuccessTime(place);
        } else
        {
            message.what = 2;
        }
        if(mCallBack != null)
            mCallBack.doCallBack(message);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Integer)obj);
    }

    private Context context;
    private ListCallBack mCallBack;
    private int place;
}
