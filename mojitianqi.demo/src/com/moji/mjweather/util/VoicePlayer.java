// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VoicePlayer.java

package com.moji.mjweather.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
 import com.moji.mjweather.common.MojiLog;
import java.io.File;
 

// Referenced classes of package com.moji.mjweather.util:
//            PlayerUtil

public class VoicePlayer
    
{
    public static interface OnVoiceFinishedListener
    {

        public abstract void onVoiceFinished();
    }

    class VolumeControlThread extends Thread
    {

        public void run()
        {
             
        }

        public void setStop()
        {
            mStop = true;
            setVoiceFinished();
        }

        public void setVoiceFinished()
        {
            mVoiceFinished = true;
        }

        private static final int BACKGROUND_VOLUME = 4;
        private static final int MAX_VOLUME = 13;
        private static final String TAG = "VolumeControlThread";
        private boolean mStop;
        private boolean mVoiceFinished;
         

        public VolumeControlThread()
        {
            
            super();
            setPriority(10);
        }
    }

    class VoiceAsyncTask extends AsyncTask
    {

		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			return null;
		}

   
    }


    public VoicePlayer()
    {
    }

    private void onFinished()
    {
        if(mListener != null)
            mListener.onVoiceFinished();
    }

    private void onVoiceFinished()
    {
       
    }

    public void cleanup()
    {
         
    }

    public boolean init(Context context, OnVoiceFinishedListener onvoicefinishedlistener)
    {
		return isplayWeather;
        
    }

    public void onSpeakingEnd()
    {
        onVoiceFinished();
    }

    public void play(boolean flag, boolean flag1)
    {
        
    }
    public void setBroadcastContent(String s)
    {
        mVoiceContent = s;
    }

    public void stop()
    {
       
    }

    private static final int STREAM_TYPE = 3;
    private static final String TAG = "VoicePlayer";
    private Boolean isplayWeather;
    private Context mContext;
    private OnVoiceFinishedListener mListener;
    private MediaPlayer mMediaPlayer;
    private boolean mPlayBackground;
   
    private VoiceAsyncTask mVoiceAsyncTask;
    private String mVoiceContent;
    private VolumeControlThread mVolumeControlThread;




/*
    static CPackgedVoiceEngine access$102(VoicePlayer voiceplayer, CPackgedVoiceEngine cpackgedvoiceengine)
    {
        voiceplayer.mPlayer = cpackgedvoiceengine;
        return cpackgedvoiceengine;
    }

*/






}
