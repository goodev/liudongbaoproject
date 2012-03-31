// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HuangLiActivity.java

package com.moji.mjweather.activity;

import android.app.*;
import android.content.*;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.*;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.PlayerUtil;
import com.moji.mjweather.util.StatsUtil;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HuangLiActivity extends Activity
    implements android.app.DatePickerDialog.OnDateSetListener
{
    private class HuangLiDBHelper
    {

        

		public HuangLiDBHelper(HuangLiActivity huangLiActivity) {
			super();
			// TODO Auto-generated constructor stub
		}

		private void init(Context context)
        {
            File file;
            String s;
            file = context.getDatabasePath("huangli.db");
            s = file.toString();
            String s1 = s.substring(0, s.lastIndexOf("/"));
            File file1 = new File(s1);
            MojiLog.d("HuangLiActivity", (new StringBuilder()).append("dbFileFullName = ").append(s).toString());
            MojiLog.d("HuangLiActivity", (new StringBuilder()).append("dbDirFullName = ").append(s1).toString());
            if(!file1.exists())
                file1.mkdir();
            if(!file.exists())
            {  try
            {
                InputStream inputstream = context.getResources().openRawResource(0x7f060000);
                FileOutputStream fileoutputstream = new FileOutputStream(file);
                byte abyte0[] = new byte[8192];
                  do
                {
                    int i = inputstream.read(abyte0);
                    if(i <= 0)
                        break;
                    fileoutputstream.write(abyte0, 0, i);
                } while(true);
              
                    fileoutputstream.close();
                    inputstream.close();
                    Gl.saveHuangLiDBVersion(2);
                    MojiLog.d("HuangLiActivity", "copy done!");
                }
                // Misplaced declaration of an exception variable
                catch(Exception exception)
                {
                    MojiLog.e("HuangLiActivity", "failed to copy or open db: ", exception);
                }
            }
            if(mDB == null)
                try
                {
                    mDB = context.openOrCreateDatabase("huangli.db", 0, null);
                }
                catch(Exception exception2)
                {
                    MojiLog.e("HuangLiActivity", "failed to open db: ", exception2);
                }
 
            mDB = context.openOrCreateDatabase(s, 0, null);
 
        }

        public void close()
        {
            if(mDB != null)
                mDB.close();
        }

        public HuangLiItem getHuangLiData(String s)
        {
            String s1;
            HuangLiItem huangliitem;
            Cursor cursor;
            s1 = (new StringBuilder()).append("select * from HL_s where sDate='").append(s).append("'").toString();
            huangliitem = new HuangLiItem();
            cursor = null;
            if(mDB != null)
                cursor = mDB.rawQuery(s1, null);
            if(cursor != null && cursor.moveToNext())
            {
                huangliitem.mHuangLiYear = cursor.getString(cursor.getColumnIndex("nYear"));
                huangliitem.mHuangLiMonth = cursor.getString(cursor.getColumnIndex("nMonth"));
                huangliitem.mHuangLiDay = cursor.getString(cursor.getColumnIndex("nDay"));
                huangliitem.mNongLiDate = cursor.getString(cursor.getColumnIndex("nToDay"));
                huangliitem.mYi = cursor.getString(cursor.getColumnIndex("Yi"));
                huangliitem.mJi = cursor.getString(cursor.getColumnIndex("Ji"));
                huangliitem.mChong = cursor.getString(cursor.getColumnIndex("Chong"));
                huangliitem.mSha = cursor.getString(cursor.getColumnIndex("Sha"));
                huangliitem.mCheng = cursor.getString(cursor.getColumnIndex("Cheng"));
                huangliitem.mZhengchong = cursor.getString(cursor.getColumnIndex("ZhengChong"));
                huangliitem.mTaishen = cursor.getString(cursor.getColumnIndex("TaiShen"));
                huangliitem.mJieqi = cursor.getString(cursor.getColumnIndex("SolarTerm"));
            }
            if(cursor != null)
                cursor.close();
            return huangliitem;
        }

        private static final String COLUMN_CHENG = "Cheng";
        private static final String COLUMN_CHONG = "Chong";
        private static final String COLUMN_DATE = "sDate";
        private static final String COLUMN_DAY = "nDay";
        private static final String COLUMN_JI = "Ji";
        private static final String COLUMN_JIE_QI = "SolarTerm";
        private static final String COLUMN_MONTH = "nMonth";
        private static final String COLUMN_SHA = "Sha";
        private static final String COLUMN_TAI_SHEN = "TaiShen";
        private static final String COLUMN_TODAY = "nToDay";
        private static final String COLUMN_YEAR = "nYear";
        private static final String COLUMN_YI = "Yi";
        private static final String COLUMN_ZHENG_CHONG = "ZhengChong";
        private static final String DATABASE_NAME = "huangli.db";
        private static final String TABLE_NAME = "HL_s";
        private SQLiteDatabase mDB;
        
    }

    public class HuangLiItem
    {

        String mCheng;
        String mChong;
        String mHuangLiDay;
        String mHuangLiMonth;
        String mHuangLiYear;
        String mJi;
        String mJieqi;
        String mNongLiDate;
        String mSha;
        String mTaishen;
        String mYi;
        String mZhengchong;
 

        public HuangLiItem()
        {
 
            super();
            mHuangLiYear = getResources().getString(0x7f0b01e3);
            mHuangLiMonth = "";
            mHuangLiDay = "";
            mNongLiDate = getResources().getString(0x7f0b01e3);
            mYi = getResources().getString(0x7f0b01e3);
            mJi = getResources().getString(0x7f0b01e3);
            mChong = getResources().getString(0x7f0b01e3);
            mSha = getResources().getString(0x7f0b01e3);
            mCheng = getResources().getString(0x7f0b01e3);
            mZhengchong = getResources().getString(0x7f0b01e3);
            mTaishen = getResources().getString(0x7f0b01e3);
            mJieqi = "";
        }
    }


    public HuangLiActivity()
    {
        mShareTextString = "";
        mIsFirstPage = true;
        mHaveData = true;
        mainHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
               switch( message.what)
               {
               case 1:  mBroadcastButton.setBackgroundResource(0x7f02014a); break;
               default: return;
               }
              
            }

           
        }
;
    }

    private boolean checkData(HuangLiItem huangliitem)
    {
        boolean flag = false;
        if(huangliitem.mNongLiDate.equals(getString(0x7f0b01e3)))
        {
            showDialog(2);
            mHaveData = flag;
        } else
        {
            flag = true;
        }
        return flag;
    }

    private void fling(MotionEvent motionevent)
    {
        int action = motionevent.getAction();
        switch(action){
        case 0:   spanx = motionevent.getX();
        spany = motionevent.getY(); break;
        case 1: MojiLog.d("HuangLiActivity", (new StringBuilder()).append("x=").append(spanx - motionevent.getX()).append("y=").append(spany - motionevent.getY()).toString());
        if(spanx - motionevent.getX() > dptopx(120) && spany - motionevent.getY() < dptopx(150) && spany - motionevent.getY() > dptopx(-150))
        {
            mHaveData = true;
            if(mIsFirstPage)
            {
                mCalendar2.add(5, 1);
                HuangLiItem huangliitem3 = mDBHelper.getHuangLiData(mDateFormat.format(mCalendar2.getTime()));
                if(checkData(huangliitem3))
                {
                    setTexts2(huangliitem3);
                    mIsFirstPage = false;
                } else
                {
                    mCalendar2.add(5, -1);
                    mCalendar.add(5, -1);
                }
                mCalendar.add(5, 1);
            } else
            {
                mCalendar.add(5, 1);
                HuangLiItem huangliitem2 = mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime()));
                if(checkData(huangliitem2))
                {
                    setTexts(huangliitem2);
                    mIsFirstPage = true;
                } else
                {
                    mCalendar2.add(5, -1);
                    mCalendar.add(5, -1);
                }
                mCalendar2.add(5, 1);
            }
            mViewFlipper.setInAnimation(getApplicationContext(), 0x7f040055);
            mViewFlipper.setOutAnimation(getApplicationContext(), 0x7f040056);
            if(mHaveData)
                mViewFlipper.showNext();
        } else
        if(spanx - motionevent.getX() < dptopx(-120) && spany - motionevent.getY() < dptopx(150) && spany - motionevent.getY() > dptopx(-150))
        {
            mHaveData = true;
            if(mIsFirstPage)
            {
                mCalendar2.add(5, -1);
                HuangLiItem huangliitem1 = mDBHelper.getHuangLiData(mDateFormat.format(mCalendar2.getTime()));
                if(checkData(huangliitem1))
                {
                    setTexts2(huangliitem1);
                    mIsFirstPage = false;
                } else
                {
                    mCalendar2.add(5, 1);
                    mCalendar.add(5, 1);
                }
                mCalendar.add(5, -1);
            } else
            {
                mCalendar.add(5, -1);
                HuangLiItem huangliitem = mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime()));
                if(checkData(huangliitem))
                {
                    setTexts(huangliitem);
                    mIsFirstPage = true;
                } else
                {
                    mCalendar2.add(5, 1);
                    mCalendar.add(5, 1);
                }
                mCalendar2.add(5, -1);
            }
            mViewFlipper.setInAnimation(getApplicationContext(), 0x7f040057);
            mViewFlipper.setOutAnimation(getApplicationContext(), 0x7f040058);
            if(mHaveData)
                mViewFlipper.showPrevious();
        } break;
        default:return;
        }
        
    }

    private String getBroadcastHuangliContent()
    {
        return mBraodcastContent.replace(" ", ",");
    }

    private String getNongli(HuangLiItem huangliitem)
    {
        if(sNongliDay1 == null)
        {
            sNongliDay1 = getResources().getStringArray(0x7f070013);
            sNongliDay2 = getResources().getStringArray(0x7f070014);
            sNongliMonth1 = getResources().getStringArray(0x7f070015);
            sNongliMonth2 = getResources().getStringArray(0x7f070016);
        }
        String s = huangliitem.mNongLiDate;
        for(int i = 0; i < sNongliMonth1.length; i++)
            s = s.replace(sNongliMonth1[i], sNongliMonth2[i]);

        for(int j = 0; j < sNongliDay1.length; j++)
            s = s.replace(sNongliDay1[j], sNongliDay2[j]);

        return s;
    }

    private void setTexts(HuangLiItem huangliitem)
    {
        mDateButton.setText((new StringBuilder()).append(mDateFormatWithDay.format(mCalendar.getTime())).append("\u25BC").toString());
        mDateMonthTV.setText(mDateFormatWithMonth.format(mCalendar.getTime()));
        mDateYearTV.setText(mDateFormatWithYear.format(mCalendar.getTime()));
        mDateWeekTV.setText(mDateFormatWithWeek.format(mCalendar.getTime()));
        mDateDay.setText(mDateFormatWithDay2.format(mCalendar.getTime()));
        mHuangLiDateDayTV.setText(huangliitem.mHuangLiDay);
        mHuangLiDateTV.setText((new StringBuilder()).append(huangliitem.mHuangLiYear).append(huangliitem.mHuangLiMonth).toString());
        mNongLiDateTV.setText(getNongli(huangliitem));
        mYiTV.setText(huangliitem.mYi);
        mJiTV.setText(huangliitem.mJi);
        mChongTV.setText(huangliitem.mChong);
        mShaTV.setText(huangliitem.mSha);
        mChengTV.setText(huangliitem.mCheng);
        mZhengchongTV.setText(huangliitem.mZhengchong);
        mTaishenTV.setText(huangliitem.mTaishen);
        mJieqiTV.setText(huangliitem.mJieqi);
        mShareTextString = (new StringBuilder()).append(mDateFormatWithDayOfWeek.format(mCalendar.getTime())).append("\n").append(getNongli(huangliitem)).append("\n").append(huangliitem.mHuangLiYear).append(" ").append(huangliitem.mHuangLiMonth).append(" ").append(huangliitem.mHuangLiDay).append("\n").append(getString(0x7f0b01e5)).append(huangliitem.mYi).append("\n").append(getString(0x7f0b01e6)).append(huangliitem.mJi).append("\n").append(getString(0x7f0b01e7)).append(huangliitem.mChong).append("\n").append(getString(0x7f0b01e8)).append(huangliitem.mSha).append("\n").append(getString(0x7f0b01e9)).append(huangliitem.mCheng).append("\n").append(getString(0x7f0b01ea)).append("\uFF1A").append(huangliitem.mZhengchong).append("\n").append(getString(0x7f0b01eb)).append("\uFF1A").append(huangliitem.mTaishen).toString();
        mBraodcastContent = (new StringBuilder()).append(getResources().getString(0x7f0b0126)).append(getNongli(huangliitem)).append(",").append(getResources().getString(0x7f0b01f2)).append(huangliitem.mHuangLiYear).append(",").append(huangliitem.mHuangLiMonth).append(",").append(huangliitem.mHuangLiDay).append(",").append(getString(0x7f0b01e5)).append(huangliitem.mYi).append(",").append(getString(0x7f0b01e6)).append(huangliitem.mJi).toString();
    }

    private void setTexts2(HuangLiItem huangliitem)
    {
        mDateButton.setText((new StringBuilder()).append(mDateFormatWithDay.format(mCalendar2.getTime())).append("\u25BC").toString());
        mDateMonthTV2.setText(mDateFormatWithMonth.format(mCalendar2.getTime()));
        mDateYearTV2.setText(mDateFormatWithYear.format(mCalendar2.getTime()));
        mDateWeekTV2.setText(mDateFormatWithWeek.format(mCalendar2.getTime()));
        mDateDay2.setText(mDateFormatWithDay2.format(mCalendar2.getTime()));
        mHuangLiDateDayTV2.setText(huangliitem.mHuangLiDay);
        mHuangLiDateTV2.setText((new StringBuilder()).append(huangliitem.mHuangLiYear).append(huangliitem.mHuangLiMonth).toString());
        mNongLiDateTV2.setText(getNongli(huangliitem));
        mYiTV2.setText(huangliitem.mYi);
        mJiTV2.setText(huangliitem.mJi);
        mChongTV2.setText(huangliitem.mChong);
        mShaTV2.setText(huangliitem.mSha);
        mChengTV2.setText(huangliitem.mCheng);
        mZhengchongTV2.setText(huangliitem.mZhengchong);
        mTaishenTV2.setText(huangliitem.mTaishen);
        mJieqiTV2.setText(huangliitem.mJieqi);
        mShareTextString = (new StringBuilder()).append(mDateFormatWithDayOfWeek.format(mCalendar2.getTime())).append("\n").append(getNongli(huangliitem)).append("\n").append(huangliitem.mHuangLiYear).append(" ").append(huangliitem.mHuangLiMonth).append(" ").append(huangliitem.mHuangLiDay).append("\n").append(getString(0x7f0b01e5)).append(huangliitem.mYi).append("\n").append(getString(0x7f0b01e6)).append(huangliitem.mJi).append("\n").append(getString(0x7f0b01e7)).append(huangliitem.mChong).append("\n").append(getString(0x7f0b01e8)).append(huangliitem.mSha).append("\n").append(getString(0x7f0b01e9)).append(huangliitem.mCheng).append("\n").append(getString(0x7f0b01ea)).append("\uFF1A").append(huangliitem.mZhengchong).append("\n").append(getString(0x7f0b01eb)).append("\uFF1A").append(huangliitem.mTaishen).toString();
        mBraodcastContent = (new StringBuilder()).append(getResources().getString(0x7f0b0126)).append(getNongli(huangliitem)).append(",").append(getResources().getString(0x7f0b01f2)).append(huangliitem.mHuangLiYear).append(",").append(huangliitem.mHuangLiMonth).append(",").append(huangliitem.mHuangLiDay).append(",").append(getString(0x7f0b01e5)).append(huangliitem.mYi).append(",").append(getString(0x7f0b01e6)).append(huangliitem.mJi).toString();
    }

    protected float dptopx(int i)
    {
        return 0.5F + getResources().getDisplayMetrics().density * (float)i;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        StatsUtil.updateStatsPv(com.moji.mjweather.util.StatsUtil.StatsPv.PV_ALM);
        requestWindowFeature(1);
        setContentView(0x7f030043);
        mCDialogManager = new CDialogManager(this, mainHandler);
        mDateYearTV = (TextView)findViewById(0x7f0d015a);
        mDateMonthTV = (TextView)findViewById(0x7f0d0159);
        mDateWeekTV = (TextView)findViewById(0x7f0d015b);
        mDateDay = (TextView)findViewById(0x7f0d015c);
        mHuangLiDateTV = (TextView)findViewById(0x7f0d015f);
        mHuangLiDateDayTV = (TextView)findViewById(0x7f0d0160);
        mNongLiDateTV = (TextView)findViewById(0x7f0d0163);
        mYiTV = (TextView)findViewById(0x7f0d016c);
        mJiTV = (TextView)findViewById(0x7f0d016e);
        mChongTV = (TextView)findViewById(0x7f0d016f);
        mShaTV = (TextView)findViewById(0x7f0d0170);
        mChengTV = (TextView)findViewById(0x7f0d0171);
        mZhengchongTV = (TextView)findViewById(0x7f0d0172);
        mTaishenTV = (TextView)findViewById(0x7f0d0168);
        mJieqiTV = (TextView)findViewById(0x7f0d0164);
        mShareButton = (Button)findViewById(0x7f0d0155);
        mDateButton = (Button)findViewById(0x7f0d0153);
        mBackButton = (Button)findViewById(0x7f0d0152);
        mBroadcastButton = (Button)findViewById(0x7f0d0154);
        mScrollView = (ScrollView)findViewById(0x7f0d0156);
        mViewFlipper = (ViewFlipper)findViewById(0x7f0d0157);
        mDateYearTV2 = (TextView)findViewById(0x7f0d0175);
        mDateMonthTV2 = (TextView)findViewById(0x7f0d0174);
        mDateWeekTV2 = (TextView)findViewById(0x7f0d0176);
        mDateDay2 = (TextView)findViewById(0x7f0d0177);
        mHuangLiDateTV2 = (TextView)findViewById(0x7f0d0178);
        mHuangLiDateDayTV2 = (TextView)findViewById(0x7f0d0179);
        mNongLiDateTV2 = (TextView)findViewById(0x7f0d017a);
        mYiTV2 = (TextView)findViewById(0x7f0d017d);
        mJiTV2 = (TextView)findViewById(0x7f0d017e);
        mChongTV2 = (TextView)findViewById(0x7f0d017f);
        mShaTV2 = (TextView)findViewById(0x7f0d0180);
        mChengTV2 = (TextView)findViewById(0x7f0d0181);
        mZhengchongTV2 = (TextView)findViewById(0x7f0d0182);
        mTaishenTV2 = (TextView)findViewById(0x7f0d017c);
        mJieqiTV2 = (TextView)findViewById(0x7f0d017b);
        mCalendar = Calendar.getInstance();
        mCalendar2 = Calendar.getInstance();
        mDBHelper = new HuangLiDBHelper(this);
        mScrollView.setOnTouchListener(new android.view.View.OnTouchListener() {

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                fling(motionevent);
                return false;
            }

           
        }
);
        mDateButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                showDialog(1);
            }
 
        }
);
        mShareButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                StatsUtil.updateStatsCount(com.moji.mjweather.util.StatsUtil.StatsCount.COUNT_ALM);
                mShareButton.setEnabled(false);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", mShareTextString);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, getResources().getString(0x7f0b01ed)));
            }
 
        }
);
        mBackButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                if(mDateFormat.format(mCalendar.getTime()).equals(mDateFormat.format(Calendar.getInstance().getTime())))
                {
                    Toast.makeText(getApplicationContext(), (new StringBuilder()).append(getString(0x7f0b01f0)).append(mDateFormatWithDay.format(Calendar.getInstance().getTime())).append(getString(0x7f0b01f1)).toString(), 0).show();
                } else
                {
                    long l = mCalendar.getTimeInMillis();
                    mCalendar = Calendar.getInstance();
                    mCalendar2 = Calendar.getInstance();
                    if(l < mCalendar.getTimeInMillis())
                    {
                        if(mIsFirstPage)
                        {
                            setTexts2(mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime())));
                            mIsFirstPage = false;
                        } else
                        {
                            setTexts(mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime())));
                            mIsFirstPage = true;
                        }
                        mViewFlipper.setInAnimation(getApplicationContext(), 0x7f040055);
                        mViewFlipper.setOutAnimation(getApplicationContext(), 0x7f040056);
                        mViewFlipper.showNext();
                    } else
                    {
                        if(mIsFirstPage)
                        {
                            setTexts2(mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime())));
                            mIsFirstPage = false;
                        } else
                        {
                            setTexts(mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime())));
                            mIsFirstPage = true;
                        }
                        mViewFlipper.setInAnimation(getApplicationContext(), 0x7f040057);
                        mViewFlipper.setOutAnimation(getApplicationContext(), 0x7f040058);
                        mViewFlipper.showPrevious();
                    }
                }
            }
 
        }
);
        mBroadcastButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                //PlayerUtil.broadcastHuangliContent(mCDialogManager, HuangLiActivity.this, mainHandler, getBroadcastHuangliContent());
                if(PlayerUtil.isBroadcasting)
                    mBroadcastButton.setBackgroundResource(0x7f02014b);
                else
                    mBroadcastButton.setBackgroundResource(0x7f02014a);
            }

           
        }
);
        HuangLiItem huangliitem = mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime()));
        checkData(huangliitem);
        setTexts(huangliitem);
        setTexts2(huangliitem);
    }

    protected Dialog onCreateDialog(int i)
    {
        Object obj;
        if(i == 1)
            obj = new DatePickerDialog(this, this, mCalendar.get(1), mCalendar.get(2), mCalendar.get(5));
        else
        if(i == 2)
            obj = (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b01fb)).setMessage(getString(0x7f0b01e2)).setPositiveButton(getString(0x7f0b0017), new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    showDialog(1);
                }

                
            }
).setNegativeButton(getString(0x7f0b0018), new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j)
                {
                }

                 
            }
).create();
        else
            obj = null;
        return ((Dialog) (obj));
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        long l = mCalendar.getTimeInMillis();
        mCalendar.set(i, j, k);
        mCalendar2.set(i, j, k);
        long l1 = mCalendar.getTimeInMillis();
        HuangLiItem huangliitem = mDBHelper.getHuangLiData(mDateFormat.format(mCalendar.getTime()));
        if(huangliitem.mNongLiDate.equals(getString(0x7f0b01e3)))
            showDialog(2);
        else
        if(l < l1)
        {
            if(mIsFirstPage)
            {
                setTexts2(huangliitem);
                mIsFirstPage = false;
            } else
            {
                setTexts(huangliitem);
                mIsFirstPage = true;
            }
            mViewFlipper.setInAnimation(getApplicationContext(), 0x7f040055);
            mViewFlipper.setOutAnimation(getApplicationContext(), 0x7f040056);
            mViewFlipper.showNext();
        } else
        {
            if(mIsFirstPage)
            {
                setTexts2(huangliitem);
                mIsFirstPage = false;
            } else
            {
                setTexts(huangliitem);
                mIsFirstPage = true;
            }
            mViewFlipper.setInAnimation(getApplicationContext(), 0x7f040057);
            mViewFlipper.setOutAnimation(getApplicationContext(), 0x7f040058);
            mViewFlipper.showPrevious();
        }
    }

    protected void onDestroy()
    {
        mDBHelper.close();
        super.onDestroy();
    }

    protected void onResume()
    {
        mShareButton.setEnabled(true);
        super.onResume();
    }

    protected void onStart()
    {
        mShareButton.setEnabled(true);
        super.onStart();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        fling(motionevent);
        return super.onTouchEvent(motionevent);
    }

    private static final int DATE_PICKER_ID = 1;
    private static final int DIALOG_NODATA_ID = 2;
    private static final String TAG = "HuangLiActivity";
    private static final String TRIANGLE = "\u25BC";
    private static String sNongliDay1[];
    private static String sNongliDay2[];
    private static String sNongliMonth1[];
    private static String sNongliMonth2[];
    private Button mBackButton;
    private String mBraodcastContent;
    private Button mBroadcastButton;
    private CDialogManager mCDialogManager;
    private Calendar mCalendar;
    private Calendar mCalendar2;
    private TextView mChengTV;
    private TextView mChengTV2;
    private TextView mChongTV;
    private TextView mChongTV2;
    private HuangLiDBHelper mDBHelper;
    private Button mDateButton;
    private TextView mDateDay;
    private TextView mDateDay2;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    private final SimpleDateFormat mDateFormatWithDay = new SimpleDateFormat("yyyy\u5E74MM\u6708dd\u65E5");
    private final SimpleDateFormat mDateFormatWithDay2 = new SimpleDateFormat("dd");
    private final SimpleDateFormat mDateFormatWithDayOfWeek = new SimpleDateFormat("yyyy-MM-dd EEE");
    private final SimpleDateFormat mDateFormatWithMonth = new SimpleDateFormat("MM\u6708");
    private final SimpleDateFormat mDateFormatWithWeek = new SimpleDateFormat("EEE");
    private final SimpleDateFormat mDateFormatWithYear = new SimpleDateFormat("yyyy");
    private TextView mDateMonthTV;
    private TextView mDateMonthTV2;
    private TextView mDateWeekTV;
    private TextView mDateWeekTV2;
    private TextView mDateYearTV;
    private TextView mDateYearTV2;
    private boolean mHaveData;
    private TextView mHuangLiDateDayTV;
    private TextView mHuangLiDateDayTV2;
    private TextView mHuangLiDateTV;
    private TextView mHuangLiDateTV2;
    private boolean mIsFirstPage;
    private TextView mJiTV;
    private TextView mJiTV2;
    private TextView mJieqiTV;
    private TextView mJieqiTV2;
    private TextView mNongLiDateTV;
    private TextView mNongLiDateTV2;
    private ScrollView mScrollView;
    private TextView mShaTV;
    private TextView mShaTV2;
    private Button mShareButton;
    private String mShareTextString;
    private TextView mTaishenTV;
    private TextView mTaishenTV2;
    private ViewFlipper mViewFlipper;
    private TextView mYiTV;
    private TextView mYiTV2;
    private TextView mZhengchongTV;
    private TextView mZhengchongTV2;
    Handler mainHandler;
    private float spanx;
    private float spany;












/*
    static Calendar access$402(HuangLiActivity huangliactivity, Calendar calendar)
    {
        huangliactivity.mCalendar = calendar;
        return calendar;
    }

*/



/*
    static Calendar access$602(HuangLiActivity huangliactivity, Calendar calendar)
    {
        huangliactivity.mCalendar2 = calendar;
        return calendar;
    }

*/



/*
    static boolean access$702(HuangLiActivity huangliactivity, boolean flag)
    {
        huangliactivity.mIsFirstPage = flag;
        return flag;
    }

*/


}
