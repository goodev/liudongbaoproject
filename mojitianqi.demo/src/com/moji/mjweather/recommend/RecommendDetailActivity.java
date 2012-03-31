// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RecommendDetailActivity.java

package com.moji.mjweather.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.moji.mjweather.recommend:
//            RC, SoftWare, AppUtil, AsyncImageLoader, 
//            RecommendListActivity, PackageInfoReceiver, AdUtil, GetSoftWareDetailTask, 
//            GetSoftImageTask, Downloader

public class RecommendDetailActivity extends Activity
    implements AsyncImageLoader.ImageCallback
{
    public class ImageAdapter extends BaseAdapter
    {

        public int getCount()
        {
            return mImageList.size();
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Drawable drawable = (Drawable)((SoftReference)mImageList.get(i)).get();
            ImageView imageview;
            if(view == null)
            {
                imageview = new ImageView(mContext);
                ImageView _tmp = imageview;
            } else
            {
                imageview = (ImageView)view;
            }
            imageview.setImageDrawable(drawable);
            imageview.setAdjustViewBounds(true);
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            imageview.setLayoutParams(new android.widget.Gallery.LayoutParams((int)(108F * getResources().getDisplayMetrics().density), (int)(180F * getResources().getDisplayMetrics().density)));
            return imageview;
        }

        private Context mContext;
        final RecommendDetailActivity this$0;

        public ImageAdapter(Context context)
        {
            this$0 = RecommendDetailActivity.this;
            super();
            mContext = context;
        }
    }


    public RecommendDetailActivity()
    {
        tasks = new ArrayList();
        mTask = null;
        mImageList = new ArrayList();
        handler = new Handler() {

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 1 2: default 28
            //                           1 29
            //                           2 469;
                   goto _L1 _L2 _L3
_L1:
                return;
_L2:
                if(mSoft != null)
                {
                    setVisibility();
                    iconIV.setImageResource(0x7f0200c6);
                    String s = mSoft.getAppIconPath();
                    String s1 = (new StringBuilder()).append("icon_").append(mSoft.getAppid()).append(".png").toString();
                    Drawable drawable = AppUtil.searchDrawable(s1);
                    String s2;
                    String as[];
                    if(drawable != null)
                        iconIV.setImageDrawable(drawable);
                    else
                        drawable = AsyncImageLoader.loadDrawable(s1, s, new AsyncImageLoader.ImageCallback() {

                            public void imageLoaded(Drawable drawable1, String s4)
                            {
                                if(drawable1 != null)
                                    iconIV.setImageDrawable(drawable1);
                                else
                                    iconIV.setImageResource(0x7f0200c6);
                            }

                            final _cls1 this$1;

                    
                    {
                        this$1 = _cls1.this;
                        super();
                    }
                        }
);
                    if(drawable != null)
                        iconIV.setImageDrawable(drawable);
                    else
                        iconIV.setImageResource(0x7f0200c6);
                    setText(titleNameTV, mSoft.getAppName());
                    setText(appNameTV, mSoft.getAppName());
                    setText(appDescTV, mSoft.getAppDesc().replaceAll("\r", "").replaceAll("\n", ""));
                    setText(appVersionTV, mSoft.getAppPkgVersionName());
                    setText(appSizeTV, mSoft.getAppSize());
                    s2 = mSoft.getAppPicturePath();
                    new String[5];
                    as = s2.split(";");
                    for(int i = 0; i < as.length; i++)
                    {
                        String s3 = (new StringBuilder()).append(mSoft.getAppid()).append("_").append(i).append(".png").toString();
                        GetSoftImageTask getsoftimagetask = new GetSoftImageTask(RecommendDetailActivity.this);
                        tasks.add(getsoftimagetask);
                        Object aobj[] = new Object[3];
                        aobj[0] = RecommendDetailActivity.this;
                        aobj[1] = as[i];
                        aobj[2] = s3;
                        getsoftimagetask.execute(aobj);
                    }

                    setDownloadBtn();
                }
                continue; /* Loop/switch isn't completed */
_L3:
                if(adapter == null)
                {
                    adapter = new ImageAdapter(RecommendDetailActivity.this);
                    gallery.setAdapter(adapter);
                }
                adapter.notifyDataSetChanged();
                gallery.setSelection(adapter.getCount() / 2);
                if(true) goto _L1; else goto _L4
_L4:
            }

            final RecommendDetailActivity this$0;

            
            {
                this$0 = RecommendDetailActivity.this;
                super();
            }
        }
;
    }

    public static Bitmap drawableToBitmap(Drawable drawable)
    {
        Bitmap bitmap = null;
        if(drawable != null)
        {
            int i = drawable.getIntrinsicWidth();
            int j = drawable.getIntrinsicHeight();
            android.graphics.Bitmap.Config config;
            Canvas canvas;
            if(drawable.getOpacity() != -1)
                config = android.graphics.Bitmap.Config.ARGB_8888;
            else
                config = android.graphics.Bitmap.Config.RGB_565;
            bitmap = Bitmap.createBitmap(i, j, config);
            canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
        }
        return bitmap;
    }

    private void initView()
    {
        ssloading = (LinearLayout)findViewById(0x7f0d01fa);
        content = (LinearLayout)findViewById(0x7f0d01fb);
        downloadArea = (LinearLayout)findViewById(0x7f0d0202);
        titleNameTV = (TextView)findViewById(0x7f0d01f9);
        downloadStatus = (TextView)findViewById(0x7f0d0204);
        downloadStatusImage = (ImageView)findViewById(0x7f0d0203);
        iconIV = (ImageView)findViewById(0x7f0d01fc);
        appNameTV = (TextView)findViewById(0x7f0d01fd);
        appDescTV = (TextView)findViewById(0x7f0d0207);
        gallery = (Gallery)findViewById(0x7f0d0205);
        appVersionTV = (TextView)findViewById(0x7f0d01ff);
        appSizeTV = (TextView)findViewById(0x7f0d0201);
    }

    private void requestData(String s)
    {
        ArrayList arraylist;
        if(mSoft != null)
            break MISSING_BLOCK_LABEL_126;
        arraylist = (ArrayList)RC.categorysMap.get(Integer.valueOf(mPlace));
        if(arraylist == null || arraylist.size() <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if(arraylist.size() <= 0) goto _L2; else goto _L3
_L3:
        SoftWare software = (SoftWare)arraylist.get(i);
        if(!software.getAppid().equals(getIntent().getStringExtra("appid"))) goto _L5; else goto _L4
_L4:
        mSoft = software;
        Message message1 = new Message();
        message1.what = 1;
        if(handler != null)
            handler.sendMessage(message1);
_L2:
        return;
_L5:
        i++;
          goto _L6
        Message message = new Message();
        message.what = 1;
        if(handler != null)
            handler.sendMessage(message);
          goto _L2
    }

    public static void setBannerImage(Context context, SoftWare software, final ImageView rc, final ImageView rCancel, final FrameLayout banner)
    {
        if(software == null) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        Drawable drawable;
        s = software.getAppBannerUrl();
        s1 = (new StringBuilder()).append("banner_").append(software.getAppid()).append(".png").toString();
        drawable = AppUtil.searchDrawable(s1);
        if(drawable == null) goto _L4; else goto _L3
_L3:
        banner.setVisibility(0);
        rc.setImageDrawable(drawable);
        rCancel.setImageResource(0x7f020105);
_L2:
        return;
_L4:
        Drawable drawable1 = AsyncImageLoader.loadDrawable(s1, s, new AsyncImageLoader.ImageCallback() {

            public void imageLoaded(Drawable drawable2, String s2)
            {
                if(drawable2 != null)
                {
                    banner.setVisibility(0);
                    rc.setImageDrawable(drawable2);
                    rCancel.setImageResource(0x7f020105);
                } else
                {
                    banner.setVisibility(8);
                }
            }

            final FrameLayout val$banner;
            final ImageView val$rCancel;
            final ImageView val$rc;

            
            {
                banner = framelayout;
                rc = imageview;
                rCancel = imageview1;
                super();
            }
        }
);
        if(drawable1 != null)
        {
            banner.setVisibility(0);
            rc.setImageDrawable(drawable1);
            rCancel.setImageResource(0x7f020105);
        }
        if(true) goto _L2; else goto _L5
_L5:
    }

    private void setDownloadBtn()
    {
        String s;
        if(RecommendListActivity.stateMap.containsKey(mAppid))
            s = mAppid;
        else
            s = "";
        setDownloadBtn(s);
    }

    private void setDownloadBtn(String s)
    {
        int i;
        if(mSoft.getAppid().equals(s))
        {
            i = ((Integer)RecommendListActivity.stateMap.get(s)).intValue();
        } else
        {
            i = AppUtil.check(this, mSoft.getAppPkgName(), mSoft.getAppPkgVersionCode());
            int j = AppUtil.checkIfHaveDownlaod(mSoft.getAppid());
            if(j == 5)
            {
                switch(i)
                {
                case 2: // '\002'
                    i = j;
                    break;
                }
                continue;
            }
        }
        do
        {
            if(i == 2)
            {
                downloadStatusImage.setBackgroundResource(0x7f020106);
                downloadStatus.setTextColor(RC.DOWNLOAD_TEXT_COLOR);
                downloadStatus.setText(0x7f0b0254);
                downloadArea.setBackgroundResource(0x7f020107);
            } else
            if(i == 1)
            {
                downloadStatusImage.setBackgroundResource(0x7f020109);
                downloadStatus.setTextColor(RC.INSTALLED_TEXT_COLOR);
                downloadStatus.setText(0x7f0b0255);
                downloadArea.setBackgroundResource(0x7f080014);
            } else
            if(i == 3)
            {
                downloadStatusImage.setBackgroundResource(0x7f02010f);
                downloadStatus.setTextColor(RC.DOWNLOAD_TEXT_COLOR);
                downloadStatus.setText(0x7f0b0258);
                downloadArea.setBackgroundResource(0x7f020110);
            } else
            if(i == 4)
            {
                downloadStatusImage.setBackgroundResource(0x7f020108);
                downloadStatus.setTextColor(RC.INSTALLED_TEXT_COLOR);
                downloadStatus.setText(0x7f0b0256);
                downloadArea.setBackgroundResource(0x7f080014);
            } else
            if(i == 5)
            {
                downloadStatusImage.setBackgroundResource(0x7f020106);
                downloadStatus.setTextColor(RC.DOWNLOAD_TEXT_COLOR);
                downloadStatus.setText(0x7f0b0257);
                downloadArea.setBackgroundResource(0x7f020107);
            }
            if(i != 1)
                downloadArea.setOnClickListener(new android.view.View.OnClickListener() {

                    public void onClick(View view)
                    {
                        Downloader.download(false, mPlace, mPosition, mSoft, RecommendDetailActivity.this);
                    }

                    final RecommendDetailActivity this$0;

            
            {
                this$0 = RecommendDetailActivity.this;
                super();
            }
                }
);
            else
                downloadArea.setOnClickListener(null);
            return;
        } while(true);
    }

    private void setText(TextView textview, String s)
    {
        if(TextUtils.isEmpty(s) || s.equals("") || s.equals("null"))
            textview.setText("");
        else
            textview.setText(s.trim());
    }

    private void setVisibility()
    {
        ssloading.setVisibility(8);
        content.setVisibility(0);
    }

    public void imageLoaded(Drawable drawable, String s)
    {
        if(mImageList != null)
        {
            mImageList.add(new SoftReference(drawable));
            Message message = new Message();
            message.what = 2;
            handler.sendMessage(message);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        instance = this;
        PackageInfoReceiver.registerReceiver(this, null);
        requestWindowFeature(1);
        setContentView(0x7f030059);
        Intent intent = getIntent();
        if(intent == null)
        {
            finish();
        } else
        {
            mAppid = intent.getStringExtra("appid");
            mPlace = getIntent().getIntExtra("place", 0);
            mPosition = getIntent().getIntExtra("position", 0);
            initView();
            ssloading.setVisibility(0);
            content.setVisibility(8);
            AdUtil.uploadStatsClick(mPlace, mPosition, mAppid);
        }
    }

    protected void onDestroy()
    {
        if(instance == this)
            instance = null;
        PackageInfoReceiver.unregisterReceiver(this, null);
        if(mTask != null)
            mTask.cancel(true);
        for(int i = 0; i < tasks.size(); i++)
            ((GetSoftImageTask)tasks.get(i)).cancel(true);

        if(mImageList != null)
        {
            for(int j = 0; j < mImageList.size(); j++)
            {
                Drawable drawable = (Drawable)((SoftReference)mImageList.get(j)).get();
                if(!(drawable instanceof BitmapDrawable) || drawable == null)
                    continue;
                BitmapDrawable bitmapdrawable = (BitmapDrawable)drawable;
                if(!bitmapdrawable.getBitmap().isRecycled())
                    bitmapdrawable.getBitmap().recycle();
            }

            mImageList.clear();
        }
        tasks.clear();
        System.gc();
        super.onDestroy();
    }

    public void onDownloadFinish()
    {
        setDownloadBtn();
    }

    public void onDownloading()
    {
        setDownloadBtn();
    }

    public void onInstalled()
    {
        setDownloadBtn();
    }

    public void onReplaced()
    {
        setDownloadBtn();
    }

    protected void onResume()
    {
        super.onResume();
        requestData(mAppid);
    }

    public void onUninstalled()
    {
        setDownloadBtn();
    }

    private static final int LOAD_IMAGE_SUCCESS = 2;
    private static final int REQUST_DATA_SUCCESS = 1;
    public static RecommendDetailActivity instance = null;
    private ImageAdapter adapter;
    private TextView appDescTV;
    private TextView appNameTV;
    private TextView appSizeTV;
    private TextView appVersionTV;
    private LinearLayout content;
    private LinearLayout downloadArea;
    private TextView downloadStatus;
    private ImageView downloadStatusImage;
    private Gallery gallery;
    public Handler handler;
    private ImageView iconIV;
    private String mAppid;
    private ArrayList mImageList;
    private int mPlace;
    private int mPosition;
    private SoftWare mSoft;
    private GetSoftWareDetailTask mTask;
    private LinearLayout ssloading;
    private ArrayList tasks;
    private TextView titleNameTV;







/*
    static ImageAdapter access$1102(RecommendDetailActivity recommenddetailactivity, ImageAdapter imageadapter)
    {
        recommenddetailactivity.adapter = imageadapter;
        return imageadapter;
    }

*/












}
