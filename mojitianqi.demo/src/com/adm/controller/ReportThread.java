// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.adm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

// Referenced classes of package com.adm.controller:
//            f

public class ReportThread extends Thread
{
  
       
      

    public static interface ReportListener
    {

        public abstract void onReportEnd(int i);

        public abstract void onReportStart(Map map);
    }


 
 

    public ReportThread(Context context, Map map) {
		// TODO Auto-generated constructor stub
	}



	public static ReportThread fromMap(Context context, Map map)
    {
        return new ReportThread(context, map);
    }

    public static void registerReportListener(ReportListener reportlistener)
    {
        if(e == null)
            e = new ArrayList();
        e.add(reportlistener);
    }

    public static void unregisterReportListener(ReportListener reportlistener)
    {
        if(e != null && e.contains(reportlistener))
            e.remove(reportlistener);
    }

    public void run()
    {
         
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        Iterator iterator = b.entrySet().iterator();
        do
        {
            java.util.Map.Entry entry;
            do
            {
                if(!iterator.hasNext())
                    return jsonobject;
                entry = (java.util.Map.Entry)iterator.next();
            } while(entry == null || entry.getKey() == null || entry.getValue() == null);
            try
            {
                jsonobject.put((String)entry.getKey(), entry.getValue());
            }
            catch(JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        } while(true);
    }

    public static final int STATUS_FAILED = 0;
    public static final int STATUS_NO_RESPONSE = -1;
    public static final int STATUS_SUCCESSFUL = 1;
    public static final int STATUS_WRONG_FORMAT = -2;
    private static final String a = "EXCHANGE_REPORT_CACHE";
    private static ReportListener d;
    private static List e;
    private Map b;
    private Context c;
}
