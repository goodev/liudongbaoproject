// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CityManagerActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.*;
import android.content.res.Resources;
import android.os.*;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.*;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.util.*;
import com.moji.mjweather.view.CityManagerAdapter;
import com.moji.mjweather.view.CityManagerDragView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.moji.mjweather.activity:
//            AddCityActivity

public class CityManagerActivity extends Activity
    implements android.widget.AdapterView.OnItemLongClickListener, android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{
    private class UpdateCallbackImpl
        implements WeatherSubscriber
    {

        public void doCallback(com.moji.mjweather.common.WeatherUpdater.Result result)
        {
            MojiLog.d("CityManagerActivity", (new StringBuilder()).append("errCode = ").append(result.errCode).append(" cityIndex:").append(result.cityIndex).toString());
            Message message = mHandler.obtainMessage(0);
            message.arg1 = result.cityIndex;
            message.arg2 = result.errCode;
            mHandler.sendMessage(message);
        }

        

    }

    private static enum ShowClickType  
    {

         
         ST_CANCEL, ST_UPDATEALL, ST_UPDATEONE,ST_USUAL;

        
    }


    public CityManagerActivity()
    {
        MENU_DELECT_ALL = 0;
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
            	switch(message.what)
            	{
               	case 0:
               	 CityManagerActivity.this.mAdapter.notifyDataSetChanged();
                return;
            	case 1 : handleUpdateResult(message);
                Gl.setChangedCity(true);
                Gl.setNeedNotifyTrendState(true); break;
               	case 2:  handleAddCity(message);
                Gl.setChangedCity(true);break;
            	case 3: handleDeleteCity(message);
                Gl.setChangedCity(true);
                Gl.setNeedNotifyTrendState(true);break;
            	default: break;
            	}
                
            }

             
        }
;
    }

    private void cancelUpdate()
    {
        Gl.setIsLocationbyGPS(false);
        if(mWeatherUpdater != null)
            mWeatherUpdater.cancel();
    }

    private void deleteAllCity()
    {
        int i = 0;
        while(i < mList.size()) 
        {
            int j;
            String s;
            String s1;
            if(WeatherData.getCityInfo(i).mWeatherMainInfo.mCityId != 0)
                j = WeatherData.getCityInfo(i).mWeatherMainInfo.mCityId;
            else
                j = WeatherData.getCityInfo(i).m_cityID;
            s = (new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeEntry").append("_").append(j).append(".xml").toString();
            Gl.removeLifeInfoDate(j, "LifeEntry");
            FileUtil.delFile(s);
            s1 = (new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeOrder").append("_").append(j).append(".xml").toString();
            Gl.removeLifeInfoDate(j, "LifeOrder");
            FileUtil.delFile(s1);
            WeatherData.createCityInfo(i);
            Gl.removeCityInfo(i);
            i++;
        }
        Gl.saveAutoShareCity(-1);
    }

    private void deleteCity(Message message)
    {
        if(WeatherData.getCityInfo(0).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET) {
        getDialog().CancelCurrentDialog();
        getDialog().ShowMsgOKDialogFromString(getString(0x7f0b0036));
 
        return;
        }
        int i;
        String s;
        String s1;
        int j;
        File file;
        int k;
        if(WeatherData.getCityInfo(message.arg1).mWeatherMainInfo.mCityId != 0)
            i = WeatherData.getCityInfo(message.arg1).mWeatherMainInfo.mCityId;
        else
            i = WeatherData.getCityInfo(message.arg1).m_cityID;
        s = (new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeEntry").append("_").append(i).append(".xml").toString();
        Gl.removeLifeInfoDate(i, "LifeEntry");
        FileUtil.delFile(s);
        s1 = (new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeOrder").append("_").append(i).append(".xml").toString();
        Gl.removeLifeInfoDate(i, "LifeOrder");
        FileUtil.delFile(s1);
        j = Gl.getAutoShareCity().intValue();
        if(j != -1)
        {
            if(j == message.arg1)
                getDialog().ShowMsgOKDialogFromString(getString(0x7f0b0038));
            Gl.saveAutoShareCity(j + -1);
        }
        file = getFileStreamPath((new StringBuilder()).append("weatherCityindex").append(message.arg1).append(".xml").toString());
        if(file.exists())
            file.delete();
        k = message.arg1;
        do
        {
            CityWeatherInfo cityweatherinfo;
label0:
            {
                if(k < 8)
                {
                    cityweatherinfo = WeatherData.getCityInfo(k + 1);
                    if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                        break label0;
                    WeatherData.createCityInfo(k);
                    Gl.removeCityInfo(k);
                }
                if(message.arg1 == 8)
                {
                    WeatherData.createCityInfo(8);
                    Gl.removeCityInfo(8);
                }
                Gl.saveCurrentCityIndex(0);
                WeatherAlert.cancelAllAlertNotifications();
                if(WeatherData.getCityInfo(0).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                {
                    getDialog().CancelCurrentDialog();
                    showCitySelectActivity(0, true);
                }
            }
            if(true)
                continue;
            Gl.saveCityInfo(k, cityweatherinfo);
            WeatherData.setCityInfo(k);
            File file1 = getFileStreamPath((new StringBuilder()).append("weatherCityindex").append(k + 1).append(".xml").toString());
            if(file1.exists())
                file1.renameTo(new File((new StringBuilder()).append(getFilesDir().toString()).append("/").append("weatherCityindex").append(k).append(".xml").toString()));
            if(k == 7)
            {
                WeatherData.createCityInfo(k + 1);
                Gl.removeCityInfo(k + 1);
            }
            k++;
        } while(true);
         
    }

    private CDialogManager getDialog()
    {
        if(mDialogManager == null)
            mDialogManager = new CDialogManager(this, mHandler);
        return mDialogManager;
    }

    public static List getList()
    {
        return mList;
    }

    private void handleAddCity(Message message)
    {
       for( int i = 0;i< 9;i++)
       {
    	   if(WeatherData.getCityInfo(i).m_cityID == message.arg2) 
    	   {
    		   getDialog().CancelCurrentDialog();
    	        if(message.arg2 != -99)
    	            getDialog().ShowMsgOKDialog(0x7f0b0035);
    	        else
    	            getDialog().ShowMsgOKDialog(0x7f0b003f);
    	   }
    		    
       }
       CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(message.arg1);
        cityweatherinfo.Clean();
        cityweatherinfo.m_cityID = message.arg2;
        cityweatherinfo.mCityName = message.obj.toString();
        cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
        cityweatherinfo.mWeatherMainInfo.mWeatherDescription = "";
        cityweatherinfo.m_lastUpdateTime = "";
        Gl.saveCityInfo(message.arg1, cityweatherinfo);
        Gl.saveCurrentCityIndex(message.arg1);
        initList();
 
    }

    private void handleDeleteCity(Message message)
    {
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(message.arg1);
        Gl.Ct().deleteFile((new StringBuilder()).append(cityweatherinfo.m_cityID).append(".txt").toString());
        if(((Boolean)message.obj).booleanValue())
            deleteAllCity();
        else
            deleteCity(message);
        WeatherAlert.cancelAllAlertNotifications();
        initList();
    }

    private void handleUpdateResult(Message message)
    {
        if(mShowClickType == ShowClickType.ST_UPDATEONE)
            setUpdateButton();
        else
        if(mShowClickType == ShowClickType.ST_UPDATEALL && 1 + message.arg1 < mList.size())
            updateWeather(1 + message.arg1);
        else
            setUpdateButton();
        WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
    }

    private void initList()
    {
        int i;
        if(mList == null)
            mList = new ArrayList();
        else
            mList.clear();
        for(i = 0; i < 9; i++)
            if(WeatherData.getCityInfo(i).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                mList.add((new StringBuilder()).append("CityIndex_").append(i % 9).toString());

    }

    private void setCancelButton()
    {
        mUpdateAllButton.setImageResource(0x7f020044);
    }

    private void setUpdateButton()
    {
        mShowClickType = ShowClickType.ST_USUAL;
        mUpdateAllButton.setImageResource(0x7f020045);
    }

    private void showCityEditDialog(CityWeatherInfo cityweatherinfo, final int index)
    {
        (new android.app.AlertDialog.Builder(this)).setTitle((new StringBuilder()).append(getResources().getString(0x7f0b0214)).append(cityweatherinfo.mCityName).append(getResources().getString(0x7f0b0215)).toString()).setItems(0x7f070000, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
               switch( i)
               {
               case 0: return;
               case 1:   if(!Util.isConnectInternet(CityManagerActivity.this))
               {
                   getDialog().CancelCurrentDialog();
                   getDialog().ShowMsgOKDialog(0x7f0b0032);
               } else
               {
                   mShowClickType = ShowClickType.ST_UPDATEONE;
                   setCancelButton();
                   updateWeather(index);
               } break;
               case 2:  showCitySelectActivity(index, true); break;
               default:  if(WeatherData.getCityInfo(index).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
               {
                   getDialog().CancelCurrentDialog();
                   getDialog().ShowMsgOKDialogFromString(getString(0x7f0b0036));
               } else
               {
                   getDialog().ShowDeleteCityYesNo(0x7f0b0156, false, index);
               } break;
               
               }
                 
            }
 
        }
).create().show();
    }

    private void showCitySelectActivity(int i, boolean flag)
    {
        Gl.setHandler(mHandler);
        Intent intent = new Intent(this,  AddCityActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("cityindex", i);
        bundle.putBoolean("isNoDisplayLocation", flag);
        intent.putExtras(bundle);
        startActivity(intent);
        if(android.os.Build.VERSION.SDK_INT > 4)
            (new Object() {

                public void overridePendingTransition(Activity activity, int j, int k)
                {
                    activity.overridePendingTransition(j, k);
                }

              
            }
).overridePendingTransition(this, 0x7f040000, 0x7f040001);
    }

    private void updateWeather(int i)
    {
        if(mUpdateCallbackImpl == null)
            mUpdateCallbackImpl = new UpdateCallbackImpl();
        WeatherPublisher.getInstance().subscribe(mUpdateCallbackImpl);
        mBeforeType = WeatherData.getCityInfo(i).mShowType;
        WeatherData.getCityInfo(i).mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING;
        mUpdatingIndex = i;
        mAdapter.notifyDataSetChanged();
        if(mWeatherUpdater == null)
            mWeatherUpdater = AbstractWeatherUpdater.createInstance();
        mWeatherUpdater.update(i);
    }

    public void onClick(View view)
    {
        if(view == mUpdateAllButton && CityManagerAdapter.mPlusIndex != 0)
            if(mShowClickType == ShowClickType.ST_USUAL && mList.size() > 0)
            {
                if(!Util.isConnectInternet(this))
                {
                    getDialog().CancelCurrentDialog();
                    getDialog().ShowMsgOKDialog(0x7f0b0032);
                } else
                {
                    mShowClickType = ShowClickType.ST_UPDATEALL;
                    setCancelButton();
                    updateWeather(0);
                    Toast.makeText(this, getResources().getString(0x7f0b0144), 0).show();
                }
            } else
            {
                mShowClickType = ShowClickType.ST_USUAL;
                WeatherData.getCityInfo(mUpdatingIndex).mShowType = mBeforeType;
                setUpdateButton();
                cancelUpdate();
                WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
                mAdapter.notifyDataSetChanged();
            }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MojiLog.d("CityManagerActivity", "onCreate");
        requestWindowFeature(1);
        setContentView(0x7f030008);
        CityManagerDragView citymanagerdragview = (CityManagerDragView)findViewById(0x7f0d002c);
        ((LinearLayout)findViewById(0x7f0d0027)).setBackgroundDrawable(UiUtil.getBgBitmapDrawable());
        mUpdateAllButton = (ImageView)findViewById(0x7f0d002b);
        mUpdateAllButton.setOnClickListener(this);
        mShowClickType = ShowClickType.ST_USUAL;
        initList();
        mAdapter = new CityManagerAdapter(this, mList);
        citymanagerdragview.setAdapter(mAdapter);
        citymanagerdragview.setOnItemClickListener(this);
        citymanagerdragview.setOnItemLongClickListener(this);
        citymanagerdragview.setSelector(0x7f02003f);
        anim = AnimationUtils.loadAnimation(this, 0x7f040008);
        findViewById(0x7f0d0027).startAnimation(anim);
        StatsUtil.updateStatsPv(com.moji.mjweather.util.StatsUtil.StatsPv.PV_CM);
    }

    protected void onDestroy()
    {
        MojiLog.d("CityManagerActivity", "onDestroy");
        Gl.setHandler(null);
        super.onDestroy();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if(CityManagerAdapter.mPlusIndex != i || CityManagerAdapter.mPlusIndex == -1 || mShowClickType != ShowClickType.ST_USUAL) 
        {
        	if(mShowClickType == ShowClickType.ST_USUAL)
            {
                Gl.saveCurrentCityIndex(i);
                finish();
            }
        }
        	else 
    showCitySelectActivity(i, true);
 
        
         
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(i);
        boolean flag;
        if(mShowClickType != ShowClickType.ST_USUAL || i == CityManagerAdapter.mPlusIndex)
        {
            flag = false;
        } else
        {
            showCityEditDialog(cityweatherinfo, i);
            flag = true;
        }
        return flag;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        if(i != 84) 
        {
        	if(i == 4 && CityManagerAdapter.mPlusIndex != 0 && mShowClickType != ShowClickType.ST_USUAL && mList.size() > 0)
            {
                mShowClickType = ShowClickType.ST_USUAL;
                WeatherData.getCityInfo(mUpdatingIndex).mShowType = mBeforeType;
                setUpdateButton();
                cancelUpdate();
                WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(this, 0x7f0b0039, 0).show();
            
            }
        }
        	
        	else 
        	{
        		if(CityManagerAdapter.mPlusIndex == -1) 

        		{
        			 flag = super.onKeyDown(i, keyevent);
        		}
        			else 
        			{
        				 showCitySelectActivity(CityManagerAdapter.mPlusIndex, flag);
        			}
        	}
        	
 
        return flag;
 
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch(menuitem.getItemId())
        {
        case 0:return super.onOptionsItemSelected(menuitem);
        case 30:  getDialog().ShowDeleteCityYesNo(0x7f0b0157, true, 0);break;
        default:break;
        }
        return false;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = true;
        menu.clear();
        if(mList.size() > 0 && mShowClickType != ShowClickType.ST_UPDATEALL)
            menu.add(0, MENU_DELECT_ALL, 1, 0x7f0b0011);
        else
            flag = false;
        return flag;
    }

    public static final int GRID_MAX_COUNT = 9;
    public static final String KEY_CITY_INDEX = "cityindex";
    public static final String KEY_CITY_LOCATION = "isNoDisplayLocation";
    private static final String TAG = "CityManagerActivity";
    private static List mList;
    private final boolean DELETE_ALL = true;
    private int MENU_DELECT_ALL;
    private Animation anim;
    private CityManagerAdapter mAdapter;
    private com.moji.mjweather.data.CityWeatherInfo.ShowType mBeforeType;
    private CDialogManager mDialogManager;
    Handler mHandler;
    private ShowClickType mShowClickType;
    private ImageView mUpdateAllButton;
    private UpdateCallbackImpl mUpdateCallbackImpl;
    private int mUpdatingIndex;
    private WeatherUpdater mWeatherUpdater;







/*
    static ShowClickType access$502(CityManagerActivity citymanageractivity, ShowClickType showclicktype)
    {
        citymanageractivity.mShowClickType = showclicktype;
        return showclicktype;
    }

*/



}
