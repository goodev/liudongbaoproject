// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VoicePlayAlarmService.java

package com.moji.mjweather.service;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.IBinder;
import android.view.Window;
import android.widget.Toast;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.*;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class VoicePlayAlarmService extends Service
{

    public VoicePlayAlarmService()
    {
    }

    private void alarmPlayVoice()
    {
        Date date1;
        int i;
        int j;
        Date date = new Date(System.currentTimeMillis());
        date1 = PlayerUtil.getVoicePlayDate();
        i = PlayerUtil.getMinutesNum(date);
        j = PlayerUtil.getMinutesNum(date1);
        MojiLog.d("VoicePlayAlarmService", (new StringBuilder()).append("nowTimeMinutesNums = ").append(i).toString());
        MojiLog.d("VoicePlayAlarmService", (new StringBuilder()).append("playTimeMinutesNums = ").append(j).toString());
        if(i != j) goto _L2; else goto _L1
_L1:
        if(Util.isNeedUpdateWeatherData(Gl.getCurrentCityIndex()))
        {
            MojiLog.d("VoicePlayAlarmService", "alarmPlayVoice update weather");
            Util.updateWeatherData(Gl.getCurrentCityIndex());
        }
        if(isExistsVoiceData())
        {
            String s = Util.getCurrentTimeString();
            if(!Gl.getLastAutoVoiceTime().equals(s))
            {
                MojiLog.d("VoicePlayAlarmService", "alarmPlayVoice play");
                if(PlayerUtil.isBroadcasting)
                {
                    Toast.makeText(this, 0x7f0b021f, 0).show();
                } else
                {
                    Gl.saveLastAutoVoiceTime(s);
                    showVoiceCancelDialog();
                    startVoicePlay();
                }
            }
            setNextPlayAlarm(0x5265c00L + System.currentTimeMillis());
        } else
        {
            stopSelf();
        }
_L4:
        return;
_L2:
        if(i < j)
        {
            MojiLog.d("VoicePlayAlarmService", "alarmPlayVoice need wait");
            setNextPlayAlarm(date1.getTime());
        } else
        if(i > j)
        {
            MojiLog.d("VoicePlayAlarmService", "alarmPlayVoice Gone");
            setNextPlayAlarm(0x5265c00L + date1.getTime());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void checkVoicePlay()
    {
        if(!Gl.getAutoVoicePlay()) goto _L2; else goto _L1
_L1:
        if(!Gl.getAlarmOnlyWorkingDay() || isWorkingDay()) goto _L4; else goto _L3
_L3:
        int i = Calendar.getInstance().get(7);
        if(i != 7) goto _L6; else goto _L5
_L5:
        setNextPlayAlarm(0xa4cb800L + System.currentTimeMillis());
_L8:
        return;
_L6:
        if(i == 1)
            setNextPlayAlarm(0x5265c00L + System.currentTimeMillis());
        continue; /* Loop/switch isn't completed */
_L4:
        alarmPlayVoice();
        continue; /* Loop/switch isn't completed */
_L2:
        stopSelf();
        if(true) goto _L8; else goto _L7
_L7:
    }

    private boolean isExistsVoiceData()
    {
        File file = new File(PlayerUtil.TTS_DATA_BKD_PATH);
        File file1 = new File(PlayerUtil.TTS_DATA_FRD_PATH);
        boolean flag;
        if(!file.exists() || !file1.exists())
            flag = false;
        else
            flag = true;
        return flag;
    }

    private boolean isWorkingDay()
    {
        boolean flag = true;
        int i = Calendar.getInstance().get(7);
        if(i == flag || i == 7)
            flag = false;
        return flag;
    }

    private void setNextPlayAlarm(long l)
    {
        PendingIntent pendingintent = PendingIntent.getService(this, 0, new Intent(this, com/moji/mjweather/service/VoicePlayAlarmService), 0);
        AlarmManager alarmmanager = (AlarmManager)getSystemService("alarm");
        alarmmanager.cancel(pendingintent);
        alarmmanager.set(0, l, pendingintent);
        stopSelf();
    }

    private void showVoiceCancelDialog()
    {
        mAlarmVoiceDialog = (new android.app.AlertDialog.Builder(this)).setIcon(0x7f0200c5).setTitle(0x7f0b01d8).setMessage(0x7f0b01d9).setNegativeButton(0x7f0b0018, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Toast.makeText(VoicePlayAlarmService.this, 0x7f0b01da, 0).show();
                stopVoicePlay();
            }

            final VoicePlayAlarmService this$0;

            
            {
                this$0 = VoicePlayAlarmService.this;
                super();
            }
        }
).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialoginterface)
            {
                Toast.makeText(VoicePlayAlarmService.this, 0x7f0b01da, 0).show();
                stopVoicePlay();
            }

            final VoicePlayAlarmService this$0;

            
            {
                this$0 = VoicePlayAlarmService.this;
                super();
            }
        }
).create();
        mAlarmVoiceDialog.getWindow().setType(2003);
        mAlarmVoiceDialog.show();
    }

    private void startVoicePlay()
    {
        if(mVoicePlayer == null)
            mVoicePlayer = new VoicePlayer();
        mVoicePlayer.init(this, new com.moji.mjweather.util.VoicePlayer.OnVoiceFinishedListener() {

            public void onVoiceFinished()
            {
                PlayerUtil.isBroadcasting = false;
                mVoicePlayer.cleanup();
                if(mAlarmVoiceDialog != null)
                    mAlarmVoiceDialog.dismiss();
            }

            final VoicePlayAlarmService this$0;

            
            {
                this$0 = VoicePlayAlarmService.this;
                super();
            }
        }
);
        mVoicePlayer.play(false, true);
        PlayerUtil.isBroadcasting = true;
    }

    private void stopVoicePlay()
    {
        if(mVoicePlayer != null)
        {
            mVoicePlayer.stop();
            PlayerUtil.isBroadcasting = false;
        }
        stopSelf();
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onStart(Intent intent, int i)
    {
        super.onStart(intent, i);
        MojiLog.v("VoicePlayAlarmService", "onStart");
        checkVoicePlay();
    }

    private static final String TAG = "VoicePlayAlarmService";
    private static final int WEEK_SATURDAY = 7;
    private static final int WEEK_SUNDAY = 1;
    private Dialog mAlarmVoiceDialog;
    private VoicePlayer mVoicePlayer;



}
