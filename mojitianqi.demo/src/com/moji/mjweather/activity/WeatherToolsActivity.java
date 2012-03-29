// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherToolsActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.daysmatter.DaysMatterActivity;
import com.moji.mjweather.recommend.*;
import com.moji.mjweather.util.FileUtil;
import com.moji.mjweather.util.UiUtil;
import com.moji.mjweather.widgetskin.SkinSelector;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package com.moji.mjweather.activity:
//            HuangLiActivity

public class WeatherToolsActivity extends Activity
    implements android.widget.AdapterView.OnItemClickListener
{

    public WeatherToolsActivity()
    {
        Integer ainteger[] = new Integer[4];
        ainteger[0] = Integer.valueOf(0x7f020162);
        ainteger[1] = Integer.valueOf(0x7f02015f);
        ainteger[2] = Integer.valueOf(0x7f02015e);
        ainteger[3] = Integer.valueOf(0x7f02015c);
        mIntegersToolsIcon = ainteger;
        appListAsyncTask = null;
    }

    private void checkDeleteADCache()
    {
        if(System.currentTimeMillis() - Gl.getUpdateImageSuccessTime() > 0xf731400L)
        {
            Gl.saveUpdateImageSuccessTime();
            FileUtil.delAllFile("/sdcard/moji/ad_cache");
        }
        if(System.currentTimeMillis() - Gl.getApkDownloadTime().longValue() > 0x240c8400L)
        {
            Gl.saveApkDownloadTime();
            FileUtil.delAllFile("/sdcard/moji/mojiDownload/");
        }
    }

    private void getExsitData()
    {
        if(ProtocalProxy.getExistData(3))
            updateADSuccessDeal();
        else
            Gl.resetADUpdateTime(3);
    }

    private void getNewADData()
    {
        appListAsyncTask = new AppListAsyncTask(this, 3);
        AppListAsyncTask applistasynctask = appListAsyncTask;
        com.moji.mjweather.recommend.AppListAsyncTask.ListCallBack alistcallback[] = new com.moji.mjweather.recommend.AppListAsyncTask.ListCallBack[1];
        alistcallback[0] = new com.moji.mjweather.recommend.AppListAsyncTask.ListCallBack() {

            public void doCallBack(Message message)
            {
                if(message.what == 1)
                    updateADSuccessDeal();
                else
                    updateADFailureDeal();
            }

            final WeatherToolsActivity this$0;

            
            {
                this$0 = WeatherToolsActivity.this;
                super();
            }
        }
;
        applistasynctask.execute(alistcallback);
    }

    private void setGridview()
    {
        mGridView = (GridView)findViewById(0x7f0d01b6);
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < mIntegersToolsIcon.length; i++)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("ItemImage", mIntegersToolsIcon[i]);
            hashmap.put("ItemText", getResources().getStringArray(0x7f070018)[i]);
            arraylist.add(hashmap);
        }

        String as[] = new String[2];
        as[0] = "ItemImage";
        as[1] = "ItemText";
        int ai[] = new int[2];
        ai[0] = 0x7f0d023d;
        ai[1] = 0x7f0d023e;
        SimpleAdapter simpleadapter = new SimpleAdapter(this, arraylist, 0x7f03006b, as, ai);
        mGridView.setAdapter(simpleadapter);
        mGridView.setOnItemClickListener(this);
    }

    private void updateADFailureDeal()
    {
        banner.setClickable(false);
        rc.setClickable(false);
        rCancel.setClickable(false);
    }

    private void updateADSuccessDeal()
    {
        softs = (ArrayList)RC.categorysMap.get(Integer.valueOf(3));
        if(softs != null && softs.size() > 0)
        {
            soft = (SoftWare)softs.get((int)(Math.random() * (double)softs.size()));
            RecommendDetailActivity.setBannerImage(this, soft, rc, rCancel, banner);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004d);
        getWindow().setFormat(-2);
        mLayout = (LinearLayout)findViewById(0x7f0d01b4);
        mLayout.setBackgroundDrawable(UiUtil.getBgBitmapDrawable());
        setGridview();
        banner = (FrameLayout)findViewById(0x7f0d01f6);
        rc = (ImageView)findViewById(0x7f0d01f7);
        rCancel = (ImageView)findViewById(0x7f0d01f8);
        checkDeleteADCache();
        softs = (ArrayList)RC.categorysMap.get(Integer.valueOf(3));
        if(softs == null)
        {
            if(Gl.getADUpdateSuccessTime(3).equals((new SimpleDateFormat("yyyy/MM/dd")).format(new Date())))
                getExsitData();
            else
                getNewADData();
        } else
        {
            updateADSuccessDeal();
        }
        rc.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                if(soft != null)
                {
                    Intent intent = new Intent(WeatherToolsActivity.this, com/moji/mjweather/recommend/RecommendDetailActivity);
                    intent.putExtra("appid", soft.getAppid());
                    intent.putExtra("place", 3);
                    startActivity(intent);
                }
            }

            final WeatherToolsActivity this$0;

            
            {
                this$0 = WeatherToolsActivity.this;
                super();
            }
        }
);
        rCancel.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                banner.removeAllViews();
            }

            final WeatherToolsActivity this$0;

            
            {
                this$0 = WeatherToolsActivity.this;
                super();
            }
        }
);
        fade = AnimationUtils.loadAnimation(this, 0x7f040009);
        mGridView.startAnimation(fade);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 33
    //                   1 51
    //                   2 69
    //                   3 87;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        startActivity(new Intent(this, com/moji/mjweather/widgetskin/SkinSelector));
        continue; /* Loop/switch isn't completed */
_L3:
        startActivity(new Intent(this, com/moji/mjweather/activity/HuangLiActivity));
        continue; /* Loop/switch isn't completed */
_L4:
        startActivity(new Intent(this, com/moji/mjweather/daysmatter/DaysMatterActivity));
        continue; /* Loop/switch isn't completed */
_L5:
        Intent intent = new Intent(this, com/moji/mjweather/recommend/RecommendListActivity);
        intent.putExtra("place", 1);
        startActivity(intent);
        if(true) goto _L1; else goto _L6
_L6:
    }

    protected void onResume()
    {
        super.onResume();
        MojiLog.v("WeatherToolsActivity", "onResume");
        mGridView.startAnimation(fade);
        softs = (ArrayList)RC.categorysMap.get(Integer.valueOf(3));
        if(softs != null && softs.size() > 0)
        {
            soft = (SoftWare)softs.get((int)(Math.random() * (double)softs.size()));
            RecommendDetailActivity.setBannerImage(this, soft, rc, rCancel, banner);
        }
    }

    private static final String MAP_KEY_IMAGE = "ItemImage";
    private static final String MAP_KEY_TEXT = "ItemText";
    private static final String TAG = "WeatherToolsActivity";
    private static final int TOOLS_AD = 3;
    private static final int TOOLS_DAYSMATTER = 2;
    private static final int TOOLS_HUANGLI = 1;
    private static final int TOOLS_SKIN;
    private AppListAsyncTask appListAsyncTask;
    private FrameLayout banner;
    private Animation fade;
    private GridView mGridView;
    private Integer mIntegersToolsIcon[];
    private LinearLayout mLayout;
    private ImageView rCancel;
    private ImageView rc;
    private SoftWare soft;
    private ArrayList softs;




}
