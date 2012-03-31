// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RecommendListActivity.java

package com.moji.mjweather.recommend;

import android.app.Activity;
import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;
import com.moji.mjweather.Gl;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package com.moji.mjweather.recommend:
//            PackageInfoReceiver, RC, ProtocalProxy, AdUtil, 
//            AppListAsyncTask, SoftWareListAdapter, SoftWare, RecommendDetailActivity

public class RecommendListActivity extends Activity
{

    public RecommendListActivity()
    {
        appListAsyncTask = null;
        place = 0;
        isSuccess = false;
        handler = new Handler() {

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 1 2: default 28
            //                           1 34
            //                           2 111;
                   goto _L1 _L2 _L3
_L1:
                super.handleMessage(message);
                return;
_L2:
                loading.setVisibility(8);
                softadapter = new SoftWareListAdapter(RecommendListActivity.this, (List)RC.categorysMap.get(Integer.valueOf(place)), place);
                softlist.setAdapter(softadapter);
                continue; /* Loop/switch isn't completed */
_L3:
                tv.setText(getString(0x7f0b0263));
                pb.setVisibility(8);
                if(true) goto _L1; else goto _L4
_L4:
            }

            final RecommendListActivity this$0;

            
            {
                this$0 = RecommendListActivity.this;
                super();
            }
        }
;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        instance = this;
        requestWindowFeature(1);
        setContentView(0x7f03005b);
        PackageInfoReceiver.registerReceiver(this, null);
        place = getIntent().getIntExtra("place", 0);
        loading = (LinearLayout)findViewById(0x7f0d020b);
        pb = (ProgressBar)findViewById(0x7f0d0209);
        tv = (TextView)findViewById(0x7f0d020a);
        loading.setVisibility(0);
        ArrayList arraylist = (ArrayList)RC.categorysMap.get(Integer.valueOf(place));
        softlist = (ListView)findViewById(0x7f0d020c);
        softlist.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Object obj = adapterview.getAdapter().getItem(i);
                if(obj instanceof SoftWare)
                {
                    SoftWare software = (SoftWare)obj;
                    Intent intent = new Intent(RecommendListActivity.this, com/moji/mjweather/recommend/RecommendDetailActivity);
                    intent.putExtra("appid", software.getAppid());
                    intent.putExtra("place", place);
                    intent.putExtra("position", i + 1);
                    startActivity(intent);
                }
            }

            final RecommendListActivity this$0;

            
            {
                this$0 = RecommendListActivity.this;
                super();
            }
        }
);
        if(arraylist == null)
        {
            if(Gl.getADUpdateSuccessTime(place).equals((new SimpleDateFormat("yyyy/MM/dd")).format(new Date())))
            {
                isSuccess = ProtocalProxy.getExistData(place);
                Message message1 = new Message();
                if(isSuccess)
                {
                    message1.what = 1;
                } else
                {
                    Gl.resetADUpdateTime(place);
                    message1.what = 2;
                }
                handler.sendMessage(message1);
            } else
            {
                appListAsyncTask = new AppListAsyncTask(this, place);
                AppListAsyncTask applistasynctask = appListAsyncTask;
                AppListAsyncTask.ListCallBack alistcallback[] = new AppListAsyncTask.ListCallBack[1];
                alistcallback[0] = new AppListAsyncTask.ListCallBack() {

                    public void doCallBack(Message message2)
                    {
                        handler.sendMessage(message2);
                    }

                    final RecommendListActivity this$0;

            
            {
                this$0 = RecommendListActivity.this;
                super();
            }
                }
;
                applistasynctask.execute(alistcallback);
            }
        } else
        {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
        AdUtil.uploadStatsShow(place);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if(instance == this)
            instance = null;
        PackageInfoReceiver.unregisterReceiver(this, null);
        if(appListAsyncTask != null && !appListAsyncTask.isCancelled())
            appListAsyncTask.cancel(true);
    }

    public void onDownloadFinish()
    {
        if(softadapter != null)
            softadapter.refresh();
    }

    public void onDownloading()
    {
        if(softadapter != null)
            softadapter.refresh();
    }

    public void onInstalled()
    {
        if(softadapter != null)
            softadapter.refresh();
    }

    public void onReplaced()
    {
        if(softadapter != null)
            softadapter.refresh();
    }

    protected void onResume()
    {
        if(softadapter != null)
            softadapter.refresh();
        super.onResume();
    }

    public void onUninstalled()
    {
        if(softadapter != null)
            softadapter.refresh();
    }

    public void refreshListData(List list)
    {
        if(softadapter != null)
            softadapter.setData(list);
    }

    private static final int FAILURE = 2;
    private static final int SUCCESS = 1;
    public static RecommendListActivity instance = null;
    public static HashMap stateMap = new HashMap();
    private AppListAsyncTask appListAsyncTask;
    private Handler handler;
    private boolean isSuccess;
    private LinearLayout loading;
    private ProgressBar pb;
    private int place;
    private SoftWareListAdapter softadapter;
    private ListView softlist;
    private TextView tv;





/*
    static SoftWareListAdapter access$102(RecommendListActivity recommendlistactivity, SoftWareListAdapter softwarelistadapter)
    {
        recommendlistactivity.softadapter = softwarelistadapter;
        return softwarelistadapter;
    }

*/





}
