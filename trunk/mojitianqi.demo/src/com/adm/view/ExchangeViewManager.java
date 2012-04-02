// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.adm.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.adm.controller.ReportThread;

// Referenced classes of package com.adm.view:
//            Y, y, J, w, 
//            h, e, T, A, 
//            EmbededContainer, z

public class ExchangeViewManager
{

    public ExchangeViewManager(Context context)
    {
        
 
    }
 

    public   void addView(int j, ImageView imageview, Drawable adrawable[])
    {
        
    }

    public   void addView(ViewGroup viewgroup, int j, String as[])
    {
 
    }

    public void addView(ViewGroup viewgroup, ListView listview)
    {
         
    }

    public void hideBanner()
    {
        
    }

    public void hideBanner(int j)
    {
        
    }

    public void setBannerOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        
    }

    public void setHypertextlinkDuration(int j)
    {
         
    }

    public void setReportListener(com.adm.controller.ReportThread.ReportListener reportlistener)
    {
        ReportThread.registerReportListener(reportlistener);
    }

   
}
