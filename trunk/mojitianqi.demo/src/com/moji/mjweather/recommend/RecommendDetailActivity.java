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
   
        public ImageAdapter(Context context)
        {
            
            super();
            mContext = context;
        }
    }


    public RecommendDetailActivity()
    {
        tasks = new ArrayList();
         mImageList = new ArrayList();
        handler = new Handler() {

            public void handleMessage(Message message)
            {
               
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
