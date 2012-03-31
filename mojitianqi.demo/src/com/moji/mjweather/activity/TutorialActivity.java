// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TutorialActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.moji.mjweather.Gl;

public class TutorialActivity extends Activity
{
    static class ViewHolder
    {

        ImageView mBottom;
        LinearLayout mLayout;
        ImageView mTop;

        ViewHolder()
        {
        }
    }

    class GalleryAdapter extends BaseAdapter
    {

        public int getCount()
        {
            return 2;
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
            if(view == null)
            {
                mHolder = new ViewHolder();
                view = mLayoutInflater.inflate(0x7f03006f, null);
                mHolder.mLayout = (LinearLayout)view.findViewById(0x7f0d0241);
                mHolder.mLayout.setLayoutParams(new android.widget.Gallery.LayoutParams(-1, -1));
                mHolder.mTop = (ImageView)view.findViewById(0x7f0d0242);
                mHolder.mBottom = (ImageView)view.findViewById(0x7f0d0243);
                view.setTag(mHolder);
            } else
            {
                mHolder = (ViewHolder)view.getTag();
            }
            if(i == 0)
            {
                mHolder.mTop.setImageResource(0x7f020141);
            } else
            {
                mHolder.mTop.setVisibility(8);
                mHolder.mBottom.setImageResource(0x7f020142);
                mGallery.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView adapterview, View view1, int j, long l)
                    {
                        if(j == 1)
                        {
                            Gl.saveIsFirstRun(false);
                            finish();
                        }
                    }

                   
                }
);
            }
            return view;
        }

        private ViewHolder mHolder;
        private LayoutInflater mLayoutInflater;
         

        public GalleryAdapter(Context context)
        {
           
            super();
            mLayoutInflater = null;
            mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }


    public TutorialActivity()
    {
        mGallery = null;
        mAdapter = null;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFormat(-2);
        setContentView(0x7f03006e);
        mGallery = (Gallery)findViewById(0x7f0d0240);
        mAdapter = new GalleryAdapter(this);
        mGallery.setAdapter(mAdapter);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if(i == 4)
        {
            Gl.saveIsFirstRun(false);
            finish();
        }
        return super.onKeyDown(i, keyevent);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    private GalleryAdapter mAdapter;
    private Gallery mGallery;

}
