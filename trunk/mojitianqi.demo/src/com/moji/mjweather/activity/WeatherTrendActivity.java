// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherTrendActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.*;
import android.os.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.*;
import com.moji.mjweather.data.*;
import com.moji.mjweather.util.*;
import com.moji.mjweather.view.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.moji.mjweather.activity:
//            CityManagerActivity

public class WeatherTrendActivity extends Activity
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener
{
    private class UpdateCallbackImpl
        implements WeatherSubscriber
    {

        public void doCallback(com.moji.mjweather.common.WeatherUpdater.Result result)
        {
            Message message = updateHandler.obtainMessage(0);
            message.obj = result;
            updateHandler.sendMessage(message);
        }

        final WeatherTrendActivity this$0;

        private UpdateCallbackImpl()
        {
            this$0 = WeatherTrendActivity.this;
            super();
        }

    }

    private class SwitcherView extends View
    {

        private void adjustSwitcherPos()
        {
            int i = mProgressBarWidth + SCREEN_OFFSET;
            if(mIsUpdating)
            {
                mTabRect.offset(-i, 0F);
                mTextSplitLineX = mTextSplitLineX - i;
            } else
            {
                mTabRect.offset(i, 0F);
                mTextSplitLineX = i + mTextSplitLineX;
            }
            invalidate();
        }

        private void init()
        {
            float f;
            mTextPaint = new Paint();
            f = (UiUtil.getScreenWidth() * TEXT_SIZE) / 540;
            if(Gl.getScreenTypeIntValue() != 0) goto _L2; else goto _L1
_L1:
            f = 10F;
_L4:
            mTextPaint.setTextSize(f);
            mTextPaint.setColor(-1);
            mBtnWidth = (int)(2.5F * (f * (float)getResources().getString(0x7f0b014a).length()));
            mTabLeftHighlight = ProcessBmp(BitmapFactory.decodeResource(getResources(), 0x7f020165), 2 * mBtnWidth, BACK_HEIGHT, 0);
            mTabRightHighlight = ProcessBmp(BitmapFactory.decodeResource(getResources(), 0x7f020166), 2 * mBtnWidth, BACK_HEIGHT, 0);
            return;
_L2:
            if(12F > f)
                f = 12F;
            else
            if(25F < f)
                f = 25F;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public Bitmap ProcessBmp(Bitmap bitmap, float f, float f1, int i)
        {
            int j = bitmap.getWidth();
            int k = bitmap.getHeight();
            Matrix matrix = new Matrix();
            if(f != (float)j && f1 != (float)k)
                matrix.postScale(f / (float)j, f1 / (float)k);
            else
                matrix.postScale(1F, 1F);
            if(i != 0)
                matrix.postRotate(i);
            return Bitmap.createBitmap(bitmap, 0, 0, j, k, matrix, true);
        }

        protected void onDraw(Canvas canvas)
        {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            if(mTabRect == null)
            {
                int k = getWidth() / 2 - mBtnWidth;
                int l = getHeight() / 2 - BACK_HEIGHT / 2;
                mTabRect = new RectF(k, l, k + 2 * mBtnWidth, l + BACK_HEIGHT);
            }
            int i;
            String s;
            int j;
            if(mIsTempType)
                canvas.drawBitmap(mTabRightHighlight, mTabRect.left, mTabRect.top, mTextPaint);
            else
                canvas.drawBitmap(mTabLeftHighlight, mTabRect.left, mTabRect.top, mTextPaint);
            i = getHeight() / 2;
            s = new String();
            mTextPaint.setColor(-1);
            if(mIsUpdating)
            {
                if(Gl.getScreenTypeIntValue() != 0)
                    s = getResources().getString(0x7f0b0050);
            } else
            {
                s = (new StringBuilder()).append(s).append(mCityInfo.mWeatherMainInfo.mLastUpdateTime).toString();
                if(s.length() > 0)
                    s = (new StringBuilder()).append(s).append(getResources().getString(0x7f0b0143)).toString();
            }
            UiUtil.drawTextInCenterByVertical(canvas, s, mTextPaint, SCREEN_OFFSET, i);
            if(mTextSplitLineX == 0)
                mTextSplitLineX = getWidth() / 2;
            j = mBtnWidth / 2;
            if(mIsTempType)
            {
                mTextPaint.setColor(-1);
                UiUtil.drawTextInCenter(canvas, getResources().getString(0x7f0b014a), mTextPaint, mTextSplitLineX - j, i);
                mTextPaint.setColor(0xff888888);
                UiUtil.drawTextInCenter(canvas, getResources().getString(0x7f0b014b), mTextPaint, j + mTextSplitLineX, i);
            } else
            {
                UiUtil.drawTextInCenter(canvas, getResources().getString(0x7f0b014b), mTextPaint, j + mTextSplitLineX, i);
                mTextPaint.setColor(0xff888888);
                UiUtil.drawTextInCenter(canvas, getResources().getString(0x7f0b014a), mTextPaint, mTextSplitLineX - j, i);
            }
        }

        public boolean onTouchEvent(MotionEvent motionevent)
        {
            if(!mIsUpdating && !mIsDoingFadeAnimation && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE && mCityInfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            int i = motionevent.getAction();
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            switch(i)
            {
            case 0: // '\0'
                if(mTabRect.contains(f, f1))
                    mAllowSwitch = true;
                break;

            case 1: // '\001'
                if(mAllowSwitch)
                {
                    mAllowSwitch = false;
                    if(mTabRect.contains(f, f1))
                        changeTrendType();
                }
                break;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private final int BACK_HEIGHT;
        private final float BACK_SCALE;
        private final float SCALE;
        private final int SCREEN_OFFSET;
        private final int TEXT_MAX_SIZE;
        private final int TEXT_MIN_SIZE;
        private final int TEXT_MIN_SIZE_240x320;
        private final int TEXT_SCALE;
        private final int TEXT_SIZE;
        private boolean mAllowSwitch;
        private int mBtnWidth;
        private final int mProgressBarWidth;
        private Bitmap mTabLeftHighlight;
        private RectF mTabRect;
        private Bitmap mTabRightHighlight;
        private Paint mTextPaint;
        private int mTextSplitLineX;
        final WeatherTrendActivity this$0;


        public SwitcherView(Context context)
        {
            this(context, null);
        }

        public SwitcherView(Context context, AttributeSet attributeset)
        {
            this(context, attributeset, 0);
        }

        public SwitcherView(Context context, AttributeSet attributeset, int i)
        {
            this$0 = WeatherTrendActivity.this;
            super(context, attributeset, i);
            SCALE = getResources().getDisplayMetrics().density;
            TEXT_SIZE = (int)(0.5F + 13F * SCALE);
            SCREEN_OFFSET = (int)(0.5F + 5F * SCALE);
            BACK_HEIGHT = (int)(0.5F + 30F * SCALE);
            TEXT_MIN_SIZE = 12;
            TEXT_MIN_SIZE_240x320 = 10;
            TEXT_MAX_SIZE = 25;
            BACK_SCALE = 2.5F;
            mProgressBarWidth = (int)(0.5F + 22F * SCALE);
            TEXT_SCALE = 540;
            mTabLeftHighlight = null;
            mTabRightHighlight = null;
            mTextPaint = null;
            mTabRect = null;
            mAllowSwitch = false;
            mBtnWidth = 0;
            mTextSplitLineX = 0;
            init();
        }
    }

    private class TrendView extends View
    {

        private void calculateCityCount()
        {
            mCityCount = 0;
            for(int i = 0; i < 9; i++)
                if(WeatherData.getCityInfo(i).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                    int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        private void prepareDrawBuffer()
        {
            if(mTrendDrawBuffer == null)
            {
                mTrendDrawBuffer = getNewBuffer();
                if(mIsTempType)
                {
                    DrawTrendTempView.onDraw(WeatherTrendActivity.this, mContent.getWidth(), mContent.getHeight(), mTrendDrawBuffer, mCanvas, mCityInfo);
                } else
                {
                    DrawTrendWindView.init(mCityInfo, WeatherTrendActivity.this);
                    DrawTrendWindView.onDraw(WeatherTrendActivity.this, mContent.getWidth(), mContent.getHeight(), mTrendDrawBuffer, mCanvas, mCityInfo);
                }
            }
        }

        protected void onDraw(Canvas canvas)
        {
            RectF rectf = new RectF(0F, mLineTopMagin, mContent.getWidth(), 1F + mLineTopMagin);
            int i = mContent.getHeight() / 25;
            for(int j = 0; j < i; j++)
            {
                mLineBmp.draw(canvas, rectf);
                rectf.offset(0F, 25F);
            }

            if(mCityInfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING && mCityInfo.m_lastUpdateTime.length() > 0 || mCityInfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
            {
                showAllView();
                prepareDrawBuffer();
                canvas.drawBitmap(mTrendDrawBuffer, 0F, 0F, mPaintBuffer);
            } else
            {
                hideAllView();
            }
        }

        public boolean onTouchEvent(MotionEvent motionevent)
        {
            if(!mIsUpdating) goto _L2; else goto _L1
_L1:
            makeToast(ToastType.TOAST_UPDATING);
_L10:
            return true;
_L2:
            if(mIsDoingFadeAnimation) goto _L4; else goto _L3
_L3:
            motionevent.getAction();
            JVM INSTR tableswitch 0 1: default 60
        //                       0 63
        //                       1 74;
               goto _L5 _L6 _L7
_L5:
            break; /* Loop/switch isn't completed */
_L6:
            moveX = motionevent.getX();
            break; /* Loop/switch isn't completed */
_L7:
            boolean flag;
            if(Math.abs(moveX - motionevent.getX()) <= 50F)
                break; /* Loop/switch isn't completed */
            calculateCityCount();
            flag = false;
            if(moveX >= motionevent.getX()) goto _L9; else goto _L8
_L8:
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        private static final int LINE_DISTANCE = 25;
        float moveX;
        final WeatherTrendActivity this$0;

        public TrendView(Context context)
        {
            this(context, null);
        }

        public TrendView(Context context, AttributeSet attributeset)
        {
            this(context, attributeset, 0);
        }

        public TrendView(Context context, AttributeSet attributeset, int i)
        {
            this$0 = WeatherTrendActivity.this;
            super(context, attributeset, i);
            moveX = 0F;
        }
    }

    static final class ToastType extends Enum
    {

        public static ToastType valueOf(String s)
        {
            return (ToastType)Enum.valueOf(com/moji/mjweather/activity/WeatherTrendActivity$ToastType, s);
        }

        public static ToastType[] values()
        {
            return (ToastType[])$VALUES.clone();
        }

        private static final ToastType $VALUES[];
        public static final ToastType TOAST_CANCEL_UPDATE;
        public static final ToastType TOAST_FIRST_CITY;
        public static final ToastType TOAST_LAST_CITY;
        public static final ToastType TOAST_UPDATING;

        static 
        {
            TOAST_UPDATING = new ToastType("TOAST_UPDATING", 0);
            TOAST_FIRST_CITY = new ToastType("TOAST_FIRST_CITY", 1);
            TOAST_LAST_CITY = new ToastType("TOAST_LAST_CITY", 2);
            TOAST_CANCEL_UPDATE = new ToastType("TOAST_CANCEL_UPDATE", 3);
            ToastType atoasttype[] = new ToastType[4];
            atoasttype[0] = TOAST_UPDATING;
            atoasttype[1] = TOAST_FIRST_CITY;
            atoasttype[2] = TOAST_LAST_CITY;
            atoasttype[3] = TOAST_CANCEL_UPDATE;
            $VALUES = atoasttype;
        }

        private ToastType(String s, int i)
        {
            super(s, i);
        }
    }


    public WeatherTrendActivity()
    {
        mTop = null;
        mBottom = null;
        mCityName = null;
        mWeekDays = new TextView[5];
        mDates = new TextView[5];
        mWeatherDays = new TextView[5];
        mWeatherNights = new TextView[5];
        mTrendView = null;
        mCurrentCityIndex = 44;
        mFadeAnim = null;
        mTrendDrawBuffer = null;
        mUpdateCallbackImpl = null;
        mWeatherUpdater = null;
        mCDialogManager = null;
        mCanvas = null;
        mContent = null;
        mCityManager = null;
        mUpdateBtn = null;
        mScale = 0F;
        mLineTopMagin = 0F;
        mLineBmp = null;
        mPaintBuffer = new Paint();
        mIsTempType = true;
        mSwitcherView = null;
        mIsUpdating = false;
        mIsDoingFadeAnimation = false;
        mProgressBar = null;
        mCityCount = 0;
        mIsFromCityView = false;
        mIsBacklayoutChanged = false;
        mToasts = null;
        updateHandler = new Handler() {

            public void handleMessage(Message message)
            {
                handleMessage(message);
                mIsUpdating = false;
                if(mIsBacklayoutChanged)
                {
                    mIsBacklayoutChanged = false;
                    adjustBacklayout();
                }
                message.what;
                JVM INSTR tableswitch 0 0: default 64
            //                           0 72;
                   goto _L1 _L2
_L1:
                changeUpdateBtnState();
                return;
_L2:
                com.moji.mjweather.common.WeatherUpdater.Result result = (com.moji.mjweather.common.WeatherUpdater.Result)message.obj;
                if(AbstractWeatherUpdater.isSucceed(result))
                {
                    Gl.Ct().deleteFile((new StringBuilder()).append(mCityInfo.m_cityID).append(".txt").toString());
                    mCityInfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK;
                    changeBg(mCityInfo);
                    createTrendView();
                    startFadeAnimation();
                } else
                {
                    mCDialogManager.CancelCurrentDialog();
                    mCDialogManager.ShowMsgOKDialogFromString((String)result.errMsg);
                    if(mWeatherUpdater != null)
                        mWeatherUpdater.cancel();
                }
                if(true) goto _L1; else goto _L3
_L3:
            }

            final WeatherTrendActivity this$0;

            
            {
                this$0 = WeatherTrendActivity.this;
                super();
            }
        }
;
    }

    private void addUpdateListener()
    {
        if(mUpdateCallbackImpl == null)
        {
            mUpdateCallbackImpl = new UpdateCallbackImpl();
            WeatherPublisher.getInstance().subscribe(mUpdateCallbackImpl);
        }
    }

    private void adjustBacklayout()
    {
        if(Util.isConnectInternet(this))
        {
            if(mIsUpdating)
                mProgressBar.setVisibility(0);
            else
                mProgressBar.setVisibility(8);
            mSwitcherView.adjustSwitcherPos();
        }
    }

    private void cancelUpdateWeather(boolean flag)
    {
        if(mCityInfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
            if(mCityInfo.m_lastUpdateTime.length() == 0)
                mCityInfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
            else
                mCityInfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK;
        if(mWeatherUpdater != null)
            mWeatherUpdater.cancel();
        if(flag)
            makeToast(ToastType.TOAST_CANCEL_UPDATE);
        mIsUpdating = false;
        changeUpdateBtnState();
        if(mIsBacklayoutChanged)
        {
            mIsBacklayoutChanged = false;
            adjustBacklayout();
        }
    }

    private void changeBg(CityWeatherInfo cityweatherinfo)
    {
        mCityWeatherBgSwitcher.setBgImageFromTrend(cityweatherinfo.mWeatherMainInfo.mWeatherId);
    }

    private void changeUpdateBtnState()
    {
        if(mIsUpdating)
            mUpdateBtn.setImageResource(0x7f020044);
        else
            mUpdateBtn.setImageResource(0x7f02014e);
    }

    private void createSwicherView()
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0d01bb);
        linearlayout.setPadding(0, 0, 0, 0);
        if(mProgressBar == null)
        {
            mProgressBar = (ProgressBar)findViewById(0x7f0d01bc);
            mProgressBar.setVisibility(8);
        }
        if(mSwitcherView == null)
        {
            mSwitcherView = new SwitcherView(linearlayout.getContext());
            linearlayout.addView(mSwitcherView);
        }
    }

    private void createTrendView()
    {
        mCurrentCityIndex = Gl.getCurrentCityIndex();
        mCityInfo = WeatherData.getCityInfo(mCurrentCityIndex);
        resetTrendBuffer();
        mContent.removeAllViews();
        mTrendView = null;
        mTrendView = new TrendView(this);
        mContent.addView(mTrendView);
        createSwicherView();
        init();
    }

    private Bitmap getNewBuffer()
    {
        Bitmap bitmap = Bitmap.createBitmap(mContent.getWidth(), mContent.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(bitmap);
        return bitmap;
    }

    private TextView getTextViewByID(String s)
    {
        return (TextView)findViewById(getResources().getIdentifier(s, "id", getPackageName()));
    }

    private void hideAllView()
    {
        if(mTop == null)
        {
            mTop = (LinearLayout)findViewById(0x7f0d01bd);
            mBottom = (LinearLayout)findViewById(0x7f0d01c9);
        }
        mTop.setVisibility(4);
        mBottom.setVisibility(4);
    }

    private void init()
    {
        for(int i = 0; i < 5; i++)
        {
            int j = i + 1;
            mWeekDays[i] = getTextViewByID((new StringBuilder()).append("weekday").append(j).toString());
            mDates[i] = getTextViewByID((new StringBuilder()).append("date").append(j).toString());
            mWeatherDays[i] = getTextViewByID((new StringBuilder()).append("weatherday").append(j).toString());
            mWeatherNights[i] = getTextViewByID((new StringBuilder()).append("weathernight").append(j).toString());
        }

        mCityName = (TextView)findViewById(0x7f0d01b5);
        mCityName.setOnClickListener(this);
        mCityName.setText((new StringBuilder()).append(mCityInfo.mCityName).append(getString(0x7f0b004a)).toString());
        if(mCityInfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING && mCityInfo.m_lastUpdateTime.length() > 0 || mCityInfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
        {
            if(mIsTempType)
                setDescriptionTemp();
            else
                setDescriptionWind();
        } else
        {
            hideAllView();
        }
    }

    private void initToast()
    {
        mToasts = new ArrayList();
        mToasts.add(Toast.makeText(this, getResources().getString(0x7f0b0041), 0));
        mToasts.add(Toast.makeText(this, getResources().getString(0x7f0b003b), 0));
        mToasts.add(Toast.makeText(this, getResources().getString(0x7f0b003c), 0));
        mToasts.add(Toast.makeText(this, getResources().getString(0x7f0b0039), 0));
    }

    private void makeToast(ToastType toasttype)
    {
        if(mToasts == null)
            initToast();
        ((Toast)mToasts.get(toasttype.ordinal())).show();
    }

    private void removeUpdateListener()
    {
        if(mUpdateCallbackImpl != null)
        {
            cancelUpdateWeather(false);
            WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
            mUpdateCallbackImpl = null;
        }
    }

    private void resetTrendBuffer()
    {
        if(mTrendDrawBuffer != null)
        {
            mTrendDrawBuffer.recycle();
            mTrendDrawBuffer = null;
        }
    }

    private void setDescriptionTemp()
    {
        CityWeatherInfo cityweatherinfo;
        cityweatherinfo = WeatherData.getCityInfo(mCurrentCityIndex);
        mCityName.setText((new StringBuilder()).append(cityweatherinfo.mCityName).append(getString(0x7f0b004b)).toString());
        break MISSING_BLOCK_LABEL_42;
        if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET && cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE && cityweatherinfo.mWeatherTrendInfoList.size() != 0)
        {
            int i = 0;
            while(i < 5) 
            {
                WeatherTrendInfo weathertrendinfo = (WeatherTrendInfo)cityweatherinfo.mWeatherTrendInfoList.get(i);
                mWeekDays[i].setText(Util.GetWeekName(weathertrendinfo.mWeek));
                mDates[i].setText(Util.getConVertDate(weathertrendinfo.mDate, false));
                if(weathertrendinfo.mHighTempDes.length() >= 4)
                    mWeatherDays[i].setTextSize(14F);
                mWeatherDays[i].setText(weathertrendinfo.mHighTempDes);
                if(weathertrendinfo.mLowTempDes.length() >= 4)
                    mWeatherNights[i].setTextSize(14F);
                mWeatherNights[i].setText(weathertrendinfo.mLowTempDes);
                i++;
            }
        }
        return;
    }

    private void setDescriptionWind()
    {
        CityWeatherInfo cityweatherinfo;
        cityweatherinfo = WeatherData.getCityInfo(mCurrentCityIndex);
        mCityName.setText((new StringBuilder()).append(cityweatherinfo.mCityName).append(getString(0x7f0b004c)).toString());
        break MISSING_BLOCK_LABEL_42;
        if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET && cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE && cityweatherinfo.mWeatherTrendInfoList.size() != 0)
        {
            int i = 0;
            while(i < 5) 
            {
                WeatherTrendInfo weathertrendinfo = (WeatherTrendInfo)cityweatherinfo.mWeatherTrendInfoList.get(i);
                mWeekDays[i].setText(Util.GetWeekName(weathertrendinfo.mWeek));
                mDates[i].setText(Util.getConVertDate(weathertrendinfo.mDate, false));
                if(weathertrendinfo.mHighTempWindDirection.length() >= 4)
                    mWeatherDays[i].setTextSize(14F);
                mWeatherDays[i].setText(weathertrendinfo.mHighTempWindDirection);
                if(weathertrendinfo.mLowTempWindDirection.length() >= 4)
                    mWeatherNights[i].setTextSize(14F);
                mWeatherNights[i].setText(weathertrendinfo.mLowTempWindDirection);
                i++;
            }
        }
        return;
    }

    private void showAllView()
    {
        if(mTop == null)
        {
            mTop = (LinearLayout)findViewById(0x7f0d01bd);
            mBottom = (LinearLayout)findViewById(0x7f0d01c9);
        }
        if(mTop.getVisibility() == 4)
        {
            mTop.setVisibility(0);
            mBottom.setVisibility(0);
        }
    }

    private void startFadeAnimation()
    {
        if(android.os.Build.VERSION.SDK_INT > 4)
            mContent.startAnimation(mFadeAnim);
    }

    private boolean updateWeather(int i)
    {
        boolean flag = true;
        if(!Util.isConnectInternet(this))
        {
            mCDialogManager.CancelCurrentDialog();
            mCDialogManager.ShowMsgOKDialog(0x7f0b0032);
            flag = false;
        } else
        {
            addUpdateListener();
            WeatherData.getCityInfo(i).mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING;
            if(mWeatherUpdater == null)
                mWeatherUpdater = AbstractWeatherUpdater.createInstance();
            mWeatherUpdater.update(i);
            Gl.setChangedCity(flag);
            mIsUpdating = flag;
            changeUpdateBtnState();
        }
        return flag;
    }

    public void changeTrendType()
    {
        resetTrendBuffer();
        boolean flag;
        if(!mIsTempType)
            flag = true;
        else
            flag = false;
        mIsTempType = flag;
        if(mIsTempType)
            setDescriptionTemp();
        else
            setDescriptionWind();
        startFadeAnimation();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if(!Gl.needNotifyTrendCityChanged()) goto _L2; else goto _L1
_L1:
        Gl.setNeedNotifyTrendState(false);
        createTrendView();
_L4:
        return;
_L2:
        mIsFromCityView = true;
        if(i == 100 && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE && updateWeather(Gl.getCurrentCityIndex()))
        {
            mIsBacklayoutChanged = true;
            adjustBacklayout();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onAnimationEnd(Animation animation)
    {
        mIsDoingFadeAnimation = false;
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        mIsDoingFadeAnimation = true;
    }

    public void onClick(View view)
    {
        if(view.getId() != 0x7f0d01b8) goto _L2; else goto _L1
_L1:
        startActivityForResult(new Intent(this, com/moji/mjweather/activity/CityManagerActivity), 100);
_L4:
        return;
_L2:
        if(view.getId() == 0x7f0d01b5)
            startActivityForResult(new Intent(this, com/moji/mjweather/activity/CityManagerActivity), 100);
        else
        if(!mIsUpdating)
        {
            if(mCityInfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET && updateWeather(Gl.getCurrentCityIndex()))
            {
                mIsBacklayoutChanged = true;
                adjustBacklayout();
            }
        } else
        {
            cancelUpdateWeather(true);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004e);
        mCityManager = (ImageView)findViewById(0x7f0d01b8);
        mCityManager.setOnClickListener(this);
        mUpdateBtn = (ImageView)findViewById(0x7f0d01b9);
        mUpdateBtn.setOnClickListener(this);
        mContent = (LinearLayout)findViewById(0x7f0d01c8);
        createTrendView();
        mFadeAnim = AnimationUtils.loadAnimation(this, 0x7f040008);
        mFadeAnim.setDuration(500L);
        mFadeAnim.setAnimationListener(this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 0x7f020164);
        mLineBmp = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
        mScale = getResources().getDisplayMetrics().density;
        mLineTopMagin = 0.5F + 10F * mScale;
        mCityWeatherBgSwitcher = (CityWeatherBgSwitcher)getParent().findViewById(0x7f0d01ad);
        mCDialogManager = new CDialogManager(this, updateHandler);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        if(keyevent.getKeyCode() == 4 && mCityInfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
            cancelUpdateWeather(flag);
        else
            flag = super.onKeyDown(i, keyevent);
        return flag;
    }

    protected void onPause()
    {
        super.onPause();
        removeUpdateListener();
    }

    protected void onResume()
    {
        super.onResume();
        MojiLog.v("WeatherTrendActivity", "onResume");
        if(!Gl.needNotifyTrendCityChanged()) goto _L2; else goto _L1
_L1:
        Gl.setNeedNotifyTrendState(false);
        createTrendView();
        startFadeAnimation();
_L4:
        return;
_L2:
        boolean flag;
        flag = false;
        if(mCurrentCityIndex != Gl.getCurrentCityIndex())
        {
            flag = true;
            createTrendView();
        }
        if(mIsFromCityView)
            break; /* Loop/switch isn't completed */
        startFadeAnimation();
_L5:
        StatsUtil.updateStatsPv(com.moji.mjweather.util.StatsUtil.StatsPv.PV_TC);
        if(true) goto _L4; else goto _L3
_L3:
        mIsFromCityView = false;
        if(flag)
        {
            changeBg(mCityInfo);
            startFadeAnimation();
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    private static final int ALLOW_SLIDE_DISTANCE = 50;
    private static final int ANI_DURATION = 500;
    private static final String DEFTYPE_ID = "id";
    private static final int FORECAST_COUNT_MAX = 5;
    private static final int MAX_CITY_COUNT = 9;
    private static final int MSG_UPDATE_CALLBACK = 0;
    private static final int REQUESTCODE = 100;
    private static final String TAG = "WeatherTrendActivity";
    private static final String TEXTVIEW_ID_DATE = "date";
    private static final String TEXTVIEW_ID_WEATHERDAY = "weatherday";
    private static final String TEXTVIEW_ID_WEATHERNIGHT = "weathernight";
    private static final String TEXTVIEW_ID_WEEK = "weekday";
    private static final int TEXT_SIZE_MIN = 14;
    private static final int WEATHER_DESCRIPTION_MAX = 4;
    private LinearLayout mBottom;
    private CDialogManager mCDialogManager;
    private Canvas mCanvas;
    private int mCityCount;
    private CityWeatherInfo mCityInfo;
    private ImageView mCityManager;
    private TextView mCityName;
    private CityWeatherBgSwitcher mCityWeatherBgSwitcher;
    private LinearLayout mContent;
    private int mCurrentCityIndex;
    private TextView mDates[];
    private Animation mFadeAnim;
    private boolean mIsBacklayoutChanged;
    private boolean mIsDoingFadeAnimation;
    private boolean mIsFromCityView;
    private boolean mIsTempType;
    private boolean mIsUpdating;
    private NinePatch mLineBmp;
    private float mLineTopMagin;
    private Paint mPaintBuffer;
    private ProgressBar mProgressBar;
    private float mScale;
    private SwitcherView mSwitcherView;
    private ArrayList mToasts;
    private LinearLayout mTop;
    private Bitmap mTrendDrawBuffer;
    private TrendView mTrendView;
    private ImageView mUpdateBtn;
    private UpdateCallbackImpl mUpdateCallbackImpl;
    private TextView mWeatherDays[];
    private TextView mWeatherNights[];
    private WeatherUpdater mWeatherUpdater;
    private TextView mWeekDays[];
    Handler updateHandler;



/*
    static boolean access$002(WeatherTrendActivity weathertrendactivity, boolean flag)
    {
        weathertrendactivity.mIsUpdating = flag;
        return flag;
    }

*/



/*
    static boolean access$102(WeatherTrendActivity weathertrendactivity, boolean flag)
    {
        weathertrendactivity.mIsBacklayoutChanged = flag;
        return flag;
    }

*/



/*
    static Bitmap access$1202(WeatherTrendActivity weathertrendactivity, Bitmap bitmap)
    {
        weathertrendactivity.mTrendDrawBuffer = bitmap;
        return bitmap;
    }

*/













/*
    static int access$2202(WeatherTrendActivity weathertrendactivity, int i)
    {
        weathertrendactivity.mCityCount = i;
        return i;
    }

*/


/*
    static int access$2208(WeatherTrendActivity weathertrendactivity)
    {
        int i = weathertrendactivity.mCityCount;
        weathertrendactivity.mCityCount = i + 1;
        return i;
    }

*/





/*
    static int access$2502(WeatherTrendActivity weathertrendactivity, int i)
    {
        weathertrendactivity.mCurrentCityIndex = i;
        return i;
    }

*/


/*
    static int access$2508(WeatherTrendActivity weathertrendactivity)
    {
        int i = weathertrendactivity.mCurrentCityIndex;
        weathertrendactivity.mCurrentCityIndex = i + 1;
        return i;
    }

*/


/*
    static int access$2510(WeatherTrendActivity weathertrendactivity)
    {
        int i = weathertrendactivity.mCurrentCityIndex;
        weathertrendactivity.mCurrentCityIndex = i + -1;
        return i;
    }

*/







/*
    static CityWeatherInfo access$302(WeatherTrendActivity weathertrendactivity, CityWeatherInfo cityweatherinfo)
    {
        weathertrendactivity.mCityInfo = cityweatherinfo;
        return cityweatherinfo;
    }

*/






}
