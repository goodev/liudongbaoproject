// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SoftWareListAdapter.java

package com.moji.mjweather.recommend;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.*;
import android.widget.*;
import java.util.*;

// Referenced classes of package com.moji.mjweather.recommend:
//            SoftWare, RecommendListActivity, AppUtil, AsyncImageLoader, 
//            RC, Downloader

public class SoftWareListAdapter extends BaseAdapter
{
    private static class SoftListItemHolder
    {

        TextView appDesc;
        LinearLayout downloadArea;
        TextView downloadStatus;
        ImageView softicon;
        TextView softname;
        ImageView statusImage;

        private SoftListItemHolder()
        {
        }

    }

    private class ImageCallback
        implements AsyncImageLoader.ImageCallback
    {

        public void imageLoaded(Drawable drawable, String s)
        {
            ImageView imageview = (ImageView)listView.findViewWithTag(s);
            if(imageview != null)
                if(drawable != null)
                    imageview.setImageDrawable(drawable);
                else
                    imageview.setImageResource(0x7f0200c6);
        }

        ListView listView;
        final SoftWareListAdapter this$0;

        public ImageCallback(ListView listview)
        {
            this$0 = SoftWareListAdapter.this;
            super();
            listView = listview;
        }
    }


    public SoftWareListAdapter(Activity activity, List list, int i)
    {
        mContext = activity;
        mPlace = i;
        mInflater = LayoutInflater.from(mContext);
        mListView = (ListView)activity.findViewById(0x7f0d020c);
        sortSoftWareList(list);
        mData = list;
    }

    private void sortSoftWareList(List list)
    {
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            SoftWare software = (SoftWare)iterator.next();
            software.refreshState(mContext);
            if(RecommendListActivity.stateMap.containsKey(software.getAppid()))
                software.setSoftstate(((Integer)RecommendListActivity.stateMap.get(software.getAppid())).intValue());
        } while(true);
    }

    public int getCount()
    {
        return mData.size();
    }

    public Object getItem(int i)
    {
        return mData.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        SoftListItemHolder softlistitemholder;
        final SoftWare soft;
        String s;
        int i;
        if(view == null)
        {
            view = mInflater.inflate(0x7f03005d, null);
            softlistitemholder = new SoftListItemHolder();
            softlistitemholder.softname = (TextView)view.findViewById(0x7f0d0214);
            softlistitemholder.appDesc = (TextView)view.findViewById(0x7f0d0215);
            softlistitemholder.softicon = (ImageView)view.findViewById(0x7f0d0213);
            softlistitemholder.statusImage = (ImageView)view.findViewById(0x7f0d0217);
            softlistitemholder.downloadStatus = (TextView)view.findViewById(0x7f0d0218);
            softlistitemholder.downloadArea = (LinearLayout)view.findViewById(0x7f0d0216);
            view.setTag(softlistitemholder);
        } else
        {
            softlistitemholder = (SoftListItemHolder)view.getTag();
        }
        softlistitemholder.softicon.setImageResource(0x7f0200c6);
        soft = (SoftWare)getItem(position);
        s = soft.getAppIconPath();
        if(!s.equalsIgnoreCase(""))
        {
            softlistitemholder.softicon.setTag(s);
            String s1 = (new StringBuilder()).append("icon_").append(soft.getAppid()).append(".png").toString();
            Drawable drawable = AppUtil.searchDrawable(s1);
            if(drawable == null)
                drawable = AsyncImageLoader.loadDrawable(s1, s, new ImageCallback(mListView));
            if(drawable != null)
                softlistitemholder.softicon.setImageDrawable(drawable);
            else
                softlistitemholder.softicon.setImageResource(0x7f0200c6);
        } else
        {
            softlistitemholder.softicon.setImageResource(0x7f0200c6);
        }
        i = soft.getSoftstate();
        if(i == 2)
        {
            softlistitemholder.downloadStatus.setTextColor(RC.DOWNLOAD_TEXT_COLOR);
            softlistitemholder.downloadStatus.setText(0x7f0b0254);
            softlistitemholder.statusImage.setImageResource(0x7f020106);
            softlistitemholder.downloadArea.setBackgroundResource(0x7f02010e);
        } else
        if(i == 1)
        {
            softlistitemholder.downloadStatus.setTextColor(RC.INSTALLED_TEXT_COLOR);
            softlistitemholder.downloadStatus.setText(0x7f0b0255);
            softlistitemholder.statusImage.setImageResource(0x7f020109);
            softlistitemholder.downloadArea.setBackgroundResource(0x7f080014);
        } else
        if(i == 3)
        {
            softlistitemholder.downloadStatus.setTextColor(RC.DOWNLOAD_TEXT_COLOR);
            softlistitemholder.downloadStatus.setText(0x7f0b0258);
            softlistitemholder.statusImage.setImageResource(0x7f02010f);
            softlistitemholder.downloadArea.setBackgroundResource(0x7f020110);
        } else
        if(i == 4)
        {
            softlistitemholder.downloadStatus.setTextColor(RC.DOWNLOAD_TEXT_COLOR);
            softlistitemholder.downloadStatus.setText(0x7f0b0256);
            softlistitemholder.statusImage.setImageResource(0x7f020108);
            softlistitemholder.downloadArea.setBackgroundResource(0x7f02010e);
        } else
        if(i == 5)
        {
            softlistitemholder.downloadStatus.setTextColor(RC.DOWNLOAD_TEXT_COLOR);
            softlistitemholder.downloadStatus.setText(0x7f0b0257);
            softlistitemholder.statusImage.setImageResource(0x7f020106);
            softlistitemholder.downloadArea.setBackgroundResource(0x7f02010e);
        }
        if(i != 1)
            softlistitemholder.downloadArea.setOnClickListener(new android.view.View.OnClickListener() {

                public void onClick(View view1)
                {
                    Downloader.download(true, mPlace, 1 + position, soft, mContext);
                }

                final SoftWareListAdapter this$0;
                final int val$position;
                final SoftWare val$soft;

            
            {
                this$0 = SoftWareListAdapter.this;
                position = i;
                soft = software;
                super();
            }
            }
);
        else
            softlistitemholder.downloadArea.setOnClickListener(null);
        softlistitemholder.softname.setTag(soft.getAppid());
        softlistitemholder.softname.setText(soft.getAppName());
        softlistitemholder.appDesc.setText(soft.getAppDesc());
        return view;
    }

    public void refresh()
    {
        sortSoftWareList(mData);
        notifyDataSetChanged();
    }

    public void setData(List list)
    {
        sortSoftWareList(list);
        mData = list;
        notifyDataSetChanged();
    }

    private Context mContext;
    private List mData;
    private LayoutInflater mInflater;
    private ListView mListView;
    private int mPlace;


}
