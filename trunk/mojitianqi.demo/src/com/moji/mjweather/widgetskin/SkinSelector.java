// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SkinSelector.java

package com.moji.mjweather.widgetskin;

import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.widget.*;
import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.recommend.*;
import com.moji.mjweather.util.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package com.moji.mjweather.widgetskin:
//            HottestSkinListActivity, NewestSkinListActivity, SkinDownloadListActivity

public class SkinSelector extends TabActivity
    implements android.widget.RadioGroup.OnCheckedChangeListener
{

    public SkinSelector()
    {
        appListAsyncTask = null;
    }

    private CDialogManager getDialog()
    {
        if(mDialogManager == null)
            mDialogManager = new CDialogManager(this, null);
        return mDialogManager;
    }

    private void getExsitData()
    {
         
    }

    private void getNewADData()
    {
         
    }

    private void updateADFailureDeal()
    {
    }

    private void updateADSuccessDeal()
    {
       
    }

  

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        switch(i)
        {
        case 2131558948:mTabHost.setCurrentTabByTag("hottest");break;
        case 2131558949: mTabHost.setCurrentTabByTag("newest");break;
        case 2131558950:mTabHost.setCurrentTabByTag("installed");break;
        default:return;
               }
       
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        instance = this;
        requestWindowFeature(1);
        setContentView(0x7f030064);
        StatsUtil.updateStatsPv(com.moji.mjweather.util.StatsUtil.StatsPv.PV_SKIN);
        boolean flag = Environment.getExternalStorageState().equals("mounted");
        SkinUtil.createDirs();
        mTabHost = getTabHost();
        mTabHost.addTab(mTabHost.newTabSpec("hottest").setIndicator(getResources().getString(0x7f0b019f)).setContent(new Intent(this, HottestSkinListActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("newest").setIndicator(getResources().getString(0x7f0b019e)).setContent(new Intent(this,NewestSkinListActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("installed").setIndicator(getResources().getString(0x7f0b01a0)).setContent(new Intent(this,  SkinDownloadListActivity.class)));
        mRadioGroup = (RadioGroup)findViewById(0x7f0d0223);
        mRadioGroup.setOnCheckedChangeListener(this);
        installRadioButton = (RadioButton)findViewById(0x7f0d0226);
        if(!flag)
        {
            getDialog().ShowCloseActivityDialog(0x7f0b019c);
        } else
        {
            if(Util.isConnectInternet(this))
            {
                mTabHost.setCurrentTabByTag("hottest");
            } else
            {
                mTabHost.setCurrentTabByTag("installed");
                installRadioButton.setChecked(true);
            }
            mTabHost.setOnTabChangedListener(new android.widget.TabHost.OnTabChangeListener() {

                public void onTabChanged(String s)
                {
                    if(s.equals("hottest") || s.equals("newest"))
                    {
                        if(!Util.isConnectInternet(SkinSelector.this))
                        {
                            mTabHost.setCurrentTabByTag("installed");
                            installRadioButton.setChecked(true);
                            Toast.makeText(SkinSelector.this, 0x7f0b0160, 0).show();
                        }
                        if(!Util.isWifi(SkinSelector.this) && Gl.getShowWifiWarning())
                            (new android.app.AlertDialog.Builder(SkinSelector.this)).setIcon(0x7f0200c5).setTitle(0x7f0b002f).setMessage(0x7f0b019d).setPositiveButton(0x7f0b0022, new android.content.DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    Gl.saveShowWifiWarning(false);
                                }

                                 
                            }
).setNegativeButton(0x7f0b0026, new android.content.DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    finish();
                                }
 
                            }
).setNeutralButton(0x7f0b0023, new android.content.DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                }

                                
                            }
).show();
                    } else
                    if(!s.equals("installed"));
                }

                
            }
);
            softs = (ArrayList)RC.categorysMap.get(Integer.valueOf(4));
            if(softs == null)
            {
                if(Gl.getADUpdateSuccessTime(4).equals((new SimpleDateFormat("yyyy/MM/dd")).format(new Date())))
                    getExsitData();
                else
                    getNewADData();
            } else
            {
                updateADSuccessDeal();
            }
        }
    }

    protected void onDestroy()
    {
        SkinUtil.emptyImageCache();
        super.onDestroy();
    }

    

    public static final String ACTION_SOFT_ITEM = "com.moji.mjchina.recommend.soft_item";
    public static final String ITEM_ID = "itemId";
    private static final String TAB_HOTTEST = "hottest";
    private static final String TAB_INSTALLED = "installed";
    private static final String TAB_NEWEST = "newest";
    public static SkinSelector instance = null;
    private AppListAsyncTask appListAsyncTask;
    private RadioButton installRadioButton;
    private CDialogManager mDialogManager;
    private RadioGroup mRadioGroup;
    private TabHost mTabHost;
 
    private ArrayList softs;





}
