// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Workspace.java

package com.moji.mjweather.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.*;
import android.widget.Toast;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.util.*;

// Referenced classes of package com.moji.mjweather.view:
//            CityWeatherInfoView, CityWeatherBgSwitcher, DailyDetailDialog

public class Workspace extends ViewGroup
    implements android.view.View.OnClickListener
{
    public static interface OnCheckNeedUpdateListener
    {

        public abstract void onCheckNeedUpdate(int i);
    }

    public static interface OnCityNameChangeListener
    {

        public abstract void onCityNameChange(int i);
    }

    public static interface OnCityBgChangeListener
    {

        public abstract void onCityBgChange(int i);
    }

    /* member class not found */
    class OnCityIndexChangeListener {}


    public Workspace(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public Workspace(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mTouchState = 0;
 
        initWorkspace();
    }

    private void addMovement(MotionEvent motionevent)
    {
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(motionevent);
    }

    private void changeCityView()
    {
        Gl.saveCurrentCityIndex(mCurrentScreen);
        onCityNameChangeListener.onCityNameChange(mCurrentScreen);
          onCityBgChangeListener.onCityBgChange(WeatherData.getCityInfo(mCurrentScreen).mWeatherMainInfo.mWeatherId);
    }

    private void changeCityViewByScorll()
    {
        Gl.saveCurrentCityIndex(mCurrentScreen);
        onCityBgChangeListener.onCityBgChange(WeatherData.getCityInfo(mCurrentScreen).mWeatherMainInfo.mWeatherId);
    }

    private View createCityTempView()
    {
        mCityViewLayout = mLayoutInflater.inflate(0x7f03003d, null);
        return mCityViewLayout;
    }

    private View createCityView(CityWeatherInfo cityweatherinfo)
    {
        mCityViewLayout = mLayoutInflater.inflate(0x7f03003e, null);
           mCityViewLayout.findViewById(0x7f0d013e).setOnClickListener(this);
        mCityViewLayout.findViewById(0x7f0d0143).setOnClickListener(this);
        mCityViewLayout.findViewById(0x7f0d0148).setOnClickListener(this);
        mCityViewLayout.findViewById(0x7f0d014d).setOnClickListener(this);
        mCityViewLayout.findViewById(0x7f0d010c).setOnClickListener(this);
        mCityViewLayout.findViewById(0x7f0d010b).setOnClickListener(this);
        return mCityViewLayout;
    }

    private void initWorkspace()
    {
        mContext = getContext();
        mScroller = new CustomScroller(mContext, new WorkspaceInterpolator());
        mCurrentScreen = Gl.getCurrentCityIndex();
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        mLayoutInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
        loadCityView();
    }

    private boolean isNeedHandleTouchEvent(int i, boolean flag)
    {
        boolean flag1 = false;
        if(WeatherData.getCityInfo(mCurrentScreen).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET || WeatherData.getCityInfo(mCurrentScreen).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING || !flag && i != -1 && i == 2 && mTouchState != 0 || WeatherData.getCityInfo(mCurrentScreen).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE && getChildCount() == 1 || flag && mCityWeatherBgSwitcher != null && mCityWeatherBgSwitcher.isDoingAnimation())
        {
            if(!flag && WeatherData.getCityInfo(mCurrentScreen).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
                Toast.makeText(mContext, 0x7f0b0041, 0).show();
            flag1 = true;
        }
        return flag1;
    }

    private void releaseVelocityTracker()
    {
        if(mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private void sendDelayChangeBgMsg()
    {
        if((getChildCount() != 1 || WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK) && Gl.getCurrentCityIndex() != mCurrentScreen)
        {
            Message message = new Message();
            message.what = 10;
            delayHandle.sendMessageDelayed(message, 50L);
        }
    }

    private void showDailyDetailDialog(int i)
    {
        StatsUtil.updateStatsPv(com.moji.mjweather.util.StatsUtil.StatsPv.PV_DD);
        
    }

    public void addCity(int i)
    {
        addView(createCityTempView());
        changeCityView();
    }

    public void computeScroll()
    {
        if(!mScroller.computeScrollOffset()) {  
        	
        	if(mTouchState != 1 && !mIsFinish)
            {
                sendDelayChangeBgMsg();
                mIsFinish = true;
            }
        }
        else{
        scrollTo(mScroller.getCurrX(), 0);
        invalidate();
        } 
        
    }

    public int getCurrentScreen()
    {
        return mCurrentScreen;
    }

    public void loadCityView()
    {
        removeAllViews();
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        int i = 0;
        do
        {
            CityWeatherInfo cityweatherinfo;
label0:
            {
                if(i < 9)
                {
                    cityweatherinfo = WeatherData.getCityInfo(i);
                    if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                        break label0;
                }
                return;
            }
            if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
                addView(createCityTempView(), i, layoutparams);
            else
                addView(createCityView(cityweatherinfo), i, layoutparams);
            i++;
        } while(true);
    }

    public void onClick(View view)
    {
         
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
return false;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1 = 0;
        int j1 = getChildCount();
        for(int k1 = 0; k1 < j1; k1++)
        {
            View view = getChildAt(k1);
            if(view.getVisibility() != 8)
            {
                int l1 = view.getMeasuredWidth();
                view.layout(i1, 0, i1 + l1, view.getMeasuredHeight());
                i1 += l1;
            }
        }

    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int k = android.view.View.MeasureSpec.getSize(i);
        int l = getChildCount();
        for(int i1 = 0; i1 < l; i1++)
            getChildAt(i1).measure(i, j);

        scrollTo(k * mCurrentScreen, 0);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
 
        return true;
 
    }

    public void removeCity(int i)
    {
        removeViewAt(i);
        invalidate();
        changeCityView();
    }

    public void replaceCity(int i, boolean flag)
    {
        removeViewAt(i);
        if(flag)
            addView(createCityTempView(), i);
        else
            addView(createCityView(WeatherData.getCityInfo(Gl.getCurrentCityIndex())), i);
        changeCityView();
    }

    public void setBgSwitcher(CityWeatherBgSwitcher cityweatherbgswitcher)
    {
        mCityWeatherBgSwitcher = cityweatherbgswitcher;
    }

    public void setCheckNeedUpdateListener(OnCheckNeedUpdateListener oncheckneedupdatelistener)
    {
        mCityWeatherBgSwitcher.setCheckNeedUpdateListener(oncheckneedupdatelistener);
    }

    public void setCityIndexChangeListener(OnCityIndexChangeListener oncityindexchangelistener)
    {
        onCityIndexChangeListener = oncityindexchangelistener;
    }

    public void setCityNameListener(OnCityNameChangeListener oncitynamechangelistener)
    {
        onCityNameChangeListener = oncitynamechangelistener;
    }

    public void setOnCitybgChangeListener(OnCityBgChangeListener oncitybgchangelistener)
    {
        onCityBgChangeListener = oncitybgchangelistener;
    }

    public void setToScreen(int i)
    {
        if(!mScroller.isFinished())
            mScroller.abortAnimation();
        mCurrentScreen = Math.max(0, Math.min(i, -1 + getChildCount()));
        scrollTo(mCurrentScreen * getWidth(), 0);
        invalidate();
        changeCityView();
    }

    public void snapToDestination()
    {
        int i = getWidth();
        snapToScreen((getScrollX() + i / 2) / i);
    }

    public void snapToScreen(int i)
    {
        int j = Math.max(0, Math.min(i, -1 + getChildCount()));
        if(getScrollX() != j * getWidth())
        {
            int k = j * getWidth() - getScrollX();
            mScroller.startScroll(getScrollX(), 0, k, 0, 400);
            mCurrentScreen = j;
            invalidate();
        }
    }

    private static final int ACTION_EMPTY = -1;
    private static final int CHANGEBACK_DELAY = 50;
    private static final int CHANGEBACK_DELAY_MSG_SIGN = 10;
    private static final int SCROLL_SPEED = 400;
    private static final int SNAP_VELOCITY = 600;
    private static final String TAG = "Workspace";
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private Handler delayHandle;
    private View mCityViewLayout;
    private CityWeatherBgSwitcher mCityWeatherBgSwitcher;
    private Context mContext;
    private int mCurrentScreen;
 
    private float mDraggingMotionX;
    private boolean mIsFinish;
    private LayoutInflater mLayoutInflater;
    private float mMoveMotionX;
    private CustomScroller mScroller;
    private int mTouchSlop;
    private int mTouchState;
    private VelocityTracker mVelocityTracker;
 
    private OnCityBgChangeListener onCityBgChangeListener;
    private OnCityIndexChangeListener onCityIndexChangeListener;
    private OnCityNameChangeListener onCityNameChangeListener;

}
