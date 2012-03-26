// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Util.java

package com.moji.mjweather.util;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.*;
import android.net.*;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Xml;
import android.widget.Toast;
import com.moji.mjweather.Gl;
 
import com.moji.mjweather.common.*;
import com.moji.mjweather.data.CityWeatherInfo;
 
import java.io.InputStream;
import java.text.*;
import java.text.ParseException;
import java.util.*;
import org.apache.http.HttpHost;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.moji.mjweather.util:
//            PlayerUtil

public class Util
{
    static class GPSLocationListener
        implements LocationListener
    {

        public Location getGpsLocation()
        {
            return mLocation;
        }

        public void onLocationChanged(Location location)
        {
            MojiLog.d("Util", "onLocationChanged");
            if(location != null && location.getLatitude() != 0D && location.getLongitude() != 0D)
                mLocation = location;
        }

        public void onProviderDisabled(String s)
        {
        }

        public void onProviderEnabled(String s)
        {
        }

        public void onStatusChanged(String s, int i, Bundle bundle)
        {
        }

        private Location mLocation;

        GPSLocationListener()
        {
            mLocation = null;
        }
    }


    public Util()
    {
    }

    public static String GetAPN(Context context)
    {
        String s;
        if(isNeedAPNProxy())
            s = "cmwap";
        else
            s = "cmnet";
        return s;
    }

    public static HttpHost GetAPNProxy()
    {
        HttpHost httphost;
        if(Proxy.getDefaultHost() != null)
            httphost = new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        else
            httphost = new HttpHost("10.0.0.172", 80);
        return httphost;
    }

    public static String GetIMEI(Context context)
    {
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        String s = telephonymanager.getDeviceId();
        if(s == null || s.equals(""))
        {
            s = telephonymanager.getSubscriberId();
            if(s == null)
                s = "35278404110901160";
        }
        return s;
    }

    public static String GetJQ(String s)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy\u5E74MM\u6708dd\u65E5");
        Date date;
        String s1 =null;
		try {
			date = simpledateformat.parse(s);
			  s1 = getSoralTerm(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
 
        return s1;
       
    }

    public static String GetJQByDate(Date date)
    {
        return getSoralTerm(date);
    }

    static String GetNongLiDate(String s)
    {
        try
        {
            s = s.replace("\u5E74", ",").split("\\,")[1];
        }
        catch(Exception exception)
        {
            MojiLog.e("Util", (new StringBuilder()).append("GetNongLiDate in = ").append(s).toString(), exception);
        }
        return s;
    }

    static String GetNumericalDate(String s)
    {
        String s1;
        String as[] = s.replace("\u6708", ",").replace("\u65E5", "").split("\\,");
        StringBuilder stringbuilder = new StringBuilder();
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(as[0]);
        StringBuilder stringbuilder1 = stringbuilder.append(String.format("%1$02d", aobj)).append(".");
        Object aobj1[] = new Object[1];
        aobj1[0] = Integer.valueOf(as[1]);
        s1 = stringbuilder1.append(String.format("%1$02d", aobj1)).toString();
        s = s1;
 
        return s;
      
    }

    static String GetNumericalDateFormat2(String s)
    {
        String s1;
        String as[] = s.replace("\u6708", ",").replace("\u65E5", "").split("\\,");
        StringBuilder stringbuilder = new StringBuilder();
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(as[0]);
        StringBuilder stringbuilder1 = stringbuilder.append(String.format("%1$d", aobj)).append(".");
        Object aobj1[] = new Object[1];
        aobj1[0] = Integer.valueOf(as[1]);
        s1 = stringbuilder1.append(String.format("%1$d", aobj1)).toString();
        s = s1;
 
        return s;
        
    }

    public static String GetTWWeekName(int i)
    {
 
        String  
	s = "\u5468\u4E00";
        return s;
 
    }

    public static String GetWeekName(int i)
    {
    	  String  
    		s = "\u5468\u4E00";
    	        return s;
    	 
    }

    public static String GetYearName()
    {
        Date date = new Date();
        return (new SimpleDateFormat("yyyy\u5E74")).format(date);
    }

    public static void IntentClock(Context context, boolean flag)
    {

        setIntent(context, "com.android.alarmclock", "com.android.alarmclock.AlarmClock");  
        Intent intent = new Intent("com.lge.alarm.alarmclocknew.deskclock");
        intent.setFlags(0x10000000);
        context.startActivity(intent);

    }

    public static boolean IsOpenGPS(Context context)
    {
        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
        boolean flag;
        if(locationmanager == null)
            flag = false;
        else
            flag = locationmanager.isProviderEnabled("gps");
        return flag;
    }

    public static long getAppAllocatedMaxMemory()
    {
        if(sMaxMemory == null)
            sMaxMemory = Long.valueOf(Runtime.getRuntime().maxMemory() / 0x100000L);
        MojiLog.d("Util", (new StringBuilder()).append("sMaxMemory = ").append(sMaxMemory).toString());
        return sMaxMemory.longValue();
    }

    public static String getAutoLocationInfo(Context context, boolean flag)
    {
        String s;
        TelephonyManager telephonymanager;
        s = "";
        telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if(telephonymanager.getPhoneType() != 2) {
        	 if(Gl.getGpsLocationState() && IsOpenGPS(context))
                 s = getLocationByGPS(context, flag);
             if(s.equals(""))
                 s = getGsmLocationByNetWork(context);	
        }
        	else  
        	{
        CdmaCellLocation cdmacelllocation = (CdmaCellLocation)telephonymanager.getCellLocation();
        if(cdmacelllocation != null)
        {
            double d = 90D * ((double)cdmacelllocation.getBaseStationLatitude() / 1296000D);
            double d1 = 180D * ((double)cdmacelllocation.getBaseStationLongitude() / 2592000D);
            s = (new StringBuilder()).append(s).append("&cdma_lat=").append((float)d).append("&cdma_lng=").append((float)d1).toString();
        }
        	}
        return (new StringBuilder()).append(s).append("&wifimac=").append(getWifiMacAdress(context)).toString();
    }

    public static String getBefore2013Jieqi(int i, int j, int k)
    {
       return "";
    }

    public static String getConVertDate(String s, boolean flag)
    {
        String s1 = "";
        String as[] = s.split("/");
        if(as.length == 3)
            if(flag)
                s1 = (new StringBuilder()).append(as[0]).append("\u5E74").append(as[1]).append("\u6708").append(as[2]).append("\u65E5").toString();
            else
                s1 = (new StringBuilder()).append(as[1]).append(".").append(as[2]).toString();
        return s1;
    }

    public static String getCurrentDate()
    {
        Date date = new Date();
        return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
    }

    public static String getCurrentTimeString()
    {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date());
    }

    public static Date getDateByTime(String s)
    {
        String s1;
        SimpleDateFormat simpledateformat;
        Date date;
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int j = 1 + calendar.get(2);
        int k = calendar.get(5);
        s1 = (new StringBuilder()).append(i).append("-").append(j).append("-").append(k).append("  ").append(s).toString();
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        date = null;
        Date date1;
		try {
			 date =simpledateformat.parse(s1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
 
        return date;
         
    }

    public static String getDateDiffDescription(String s)
    {
  
        String  s2 = "\u6628\u5929";
        return s2;
 
    }

    public static String getDateType1(String s)
    {
        String as[] = s.split("/");
        String s1;
        if(as.length == 3)
        {
            StringBuilder stringbuilder = new StringBuilder();
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(as[1]);
            StringBuilder stringbuilder1 = stringbuilder.append(String.format("%1$d", aobj)).append("\u6708");
            Object aobj1[] = new Object[1];
            aobj1[0] = Integer.valueOf(as[2]);
            s1 = stringbuilder1.append(String.format("%1$d", aobj1)).append("\u65E5").toString();
        } else
        {
            s1 = "";
        }
        return s1;
    }

    public static String getGsmLocationByNetWork(Context context)
    {
        String s = "";
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        GsmCellLocation gsmcelllocation = (GsmCellLocation)telephonymanager.getCellLocation();
        String s1 = telephonymanager.getNetworkOperator();
        if(gsmcelllocation != null && gsmcelllocation.getCid() != -1 && s1.length() == 5)
        {
            s = (new StringBuilder()).append("&mcc=").append(s1.substring(0, 3)).append("&mnc=").append(s1.substring(3, 5)).append("&lac=").append(gsmcelllocation.getLac()).append("&cid=").append(gsmcelllocation.getCid()).toString();
            MojiLog.d("Util", (new StringBuilder()).append("GSM location  = ").append(s).toString());
        }
        return s;
    }

    public static String getLocationByGPS(Context context, boolean flag)
    {
        LocationManager locationmanager;
        String s;
        GPSLocationListener gpslocationlistener;
        Location location;
        int i;
        if(!flag)
            Toast.makeText(context, 0x7f0b01c1, 0).show();
        locationmanager = (LocationManager)context.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        s = locationmanager.getBestProvider(criteria, true);
        gpslocationlistener = new GPSLocationListener();
        locationmanager.requestLocationUpdates(s, 0L, 0F, gpslocationlistener);
        Gl.setIsLocationbyGPS(true);
        location = gpslocationlistener.getGpsLocation();
        i = 0;
 
        return s ;
    }

    public static String getParserDate(String s)
    {
        String s1 = "";
        if(s.length() > 0)
            s1 = (new StringBuilder()).append(s.split("/")[1]).append("/").append(s.split("/")[2]).toString();
        return s1;
    }

    private static String getSoralTerm(int i, int j, int k)
    {
        int l;
        int i1;
        l = sTerm(i, 2 * (j + -1));
        i1 = sTerm(i, 1 + 2 * (j + -1));
        String s =null;
        if(k < l){   s = (new StringBuilder()).append("\u8DDD").append(SolarTerm[2 * (j + -1)]).append("\u8FD8\u6709").append(l - k).append("\u5929").toString();
 
        return s;}
 
        if(k == l)
        {
            s = (new StringBuilder()).append("\u4ECA\u65E5\u8282\u6C14\u662F").append(SolarTerm[2 * (j + -1)]).toString();
            
        }
        if(k == i1)
        {
            s = (new StringBuilder()).append("\u4ECA\u65E5\u8282\u6C14\u662F").append(SolarTerm[1 + 2 * (j + -1)]).toString();
            
        }
        if(k > l && k < i1)
        {
            s = (new StringBuilder()).append("\u8DDD").append(SolarTerm[1 + 2 * (j + -1)]).append("\u8FD8\u6709").append(i1 - k).append("\u5929").toString();
            
        }
        if(k > i1)
        {
            if(j == 12)
            {
                int k1 = sTerm(i + 1, 0);
                String s3 = (new StringBuilder()).append(i).append("-").append(j).append("-").append(k).toString();
                String s4 = (new StringBuilder()).append(i + 1).append("-").append(1).append("-").append(k1).toString();
                SimpleDateFormat simpledateformat1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date2;
                Date date3;
                long l2;
                try
                {
                    date2 = simpledateformat1.parse(s4);
                    date3 = simpledateformat1.parse(s3);
                    l2 = (date2.getTime() - date3.getTime()) / 0x5265c00L;
                    s = (new StringBuilder()).append("\u8DDD").append(SolarTerm[0]).append("\u8FD8\u6709").append(l2).append("\u5929").toString();
                }
                catch(ParseException parseexception1)
                {
                    MojiLog.e("Util", "getSoralTerm m==12 ParseException ", parseexception1);
                    s = "";
                    
                }
              
               
            }
            int j1 = sTerm(i, j * 2);
            String s1 = (new StringBuilder()).append(i).append("-").append(j).append("-").append(k).toString();
            String s2 = (new StringBuilder()).append(i).append("-").append(j + 1).append("-").append(j1).toString();
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            Date date1;
            long l1;
            try
            {
                date = simpledateformat.parse(s2);
                date1 = simpledateformat.parse(s1);
                l1 = (date.getTime() - date1.getTime()) / 0x5265c00L;
                s = (new StringBuilder()).append("\u8DDD").append(SolarTerm[j * 2]).append("\u8FD8\u6709").append(l1).append("\u5929").toString();
            }
            catch(ParseException parseexception)
            {
                MojiLog.e("Util", "getSoralTerm m!=12 ParseException ", parseexception);
                s = "";
                
            }
            
           
        }
 return s;
    }

    private static String getSoralTerm(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(1);
        int j = 1 + calendar.get(2);
        int k = calendar.get(5);
        int l = k + (i * 10000 + j * 100);
        String s;
        if(l > 0x132b856 && l < 0x1332d97)
            s = getBefore2013Jieqi(i, j, k);
        else
            s = getSoralTerm(i, j, k);
        return s;
    }

    public static int getWeekOfYearWithCPlan(Date date)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setFirstDayOfWeek(2);
        gregoriancalendar.setMinimalDaysInFirstWeek(4);
        gregoriancalendar.setTime(date);
        int i = gregoriancalendar.get(3);
        int j = gregoriancalendar.get(1);
        int k = 1 + gregoriancalendar.get(2);
        if(k == 1 && i > 6)
            j--;
        if(k == 12 && i == 1)
            j++;
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        MojiLog.d("Util", (new StringBuilder()).append(simpledateformat.format(date)).append(" ,weeknum: ").append(i).append(" ,year: ").append(j).toString());
        return i;
    }

    public static String getWifiMacAdress(Context context)
    {
        String s = "";
        WifiInfo wifiinfo = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
        if(wifiinfo != null && isWifi(context))
            s = wifiinfo.getBSSID();
        return s;
    }

    public static void intentCalendar(Context context, boolean flag)
    {
      
        setIntent(context, "com.android.calendar", "com.android.calendar.LaunchActivity");
         
    }

    public static boolean is24HourFormat(Context context)
    {
        String s = android.provider.Settings.System.getString(context.getContentResolver(), "time_12_24");
        boolean flag;
        if(s != null && !s.equals("12"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isAirplaneModeOn()
    {
        boolean flag = false;
        if(android.provider.Settings.System.getInt(Gl.Ct().getContentResolver(), "airplane_mode_on", 0) != 0)
            flag = true;
        return flag;
    }

    public static boolean isAndroidMarketAvailable(Context context)
    {
       return false;
    }

    public static boolean isBetweenTimes(String s, String s1, String s2)
    {
        SimpleDateFormat simpledateformat;
        long l;
        long l1;
        long l2;
        simpledateformat = new SimpleDateFormat("HH:mm");
        l = 0L;
        l1 = 0L;
        l2 = 0L;
        long l3;
        try {
			l = simpledateformat.parse(s).getTime();
			 l1 = simpledateformat.parse(s1).getTime();
		        l3 = simpledateformat.parse(s2).getTime();
		        l2 = l3;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
 
        boolean flag;
        if(l >= l1 && l <= l2)
            flag = true;
        else
            flag = false;
        return flag;
         
    }

    public static boolean isCDMAPhoneTye(Context context)
    {
        boolean flag;
        if(((TelephonyManager)context.getSystemService("phone")).getPhoneType() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isConnectInternet(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        if(networkinfo != null)
            flag = networkinfo.isAvailable();
        else
            flag = false;
        return flag;
    }

    public static boolean isNeedAPNProxy()
    {
        boolean flag = false;
        if(Proxy.getDefaultHost() != null && (new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort())).toString().length() > 0)
            flag = true;
        return flag;
    }

    public static boolean isNeedUpdateWeatherData(int i)
    {
        boolean flag;
        CityWeatherInfo cityweatherinfo;
        Date date;
        Date date1;
        flag = true;
        MojiLog.v("Util", "NeedUpdateWeatherData ");
        cityweatherinfo = WeatherData.getCityInfo(i);
        date = new Date();
        date1 = null;
        Date date2;
		try {
			date2 = (new SimpleDateFormat("yyyy-MM-dd")).parse(cityweatherinfo.m_lastUpdateDate);
			date1 = date2;
			 
	        if(date1 != null && (date.getTime() - date1.getTime()) / 0x5265c00L <= 0L)
	            flag = false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return flag;
        
    }

    public static boolean isToday(String s)
    {
        String s1 = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        boolean flag;
        if(s != null && s.equals(s1))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isUsingWap(Context context)
    {
        boolean flag = true;
        String s = GetAPN(context);
        if("cmwap".equals(s) != flag && "uniwap".equals(s) != flag && "3gwap".equals(s) != flag || isWifi(context))
            flag = false;
        return flag;
    }

    public static boolean isWifi(Context context)
    {
        boolean flag = true;
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if(networkinfo == null || networkinfo.getType() != 1)
            flag = false;
        return flag;
    }

    public static Map parseNewVersionOrPushInfo(InputStream inputstream)
    {
        return parseNewVersionOrPushInfo(inputstream, "supd");
    }

    public static Map parseNewVersionOrPushInfo(InputStream inputstream, String s)
    {
        HashMap hashmap;
        XmlPullParser xmlpullparser;
        hashmap = new HashMap();
        xmlpullparser = Xml.newPullParser();
        int i;
        try {
			xmlpullparser.setInput(inputstream, "utf-8");
			i = xmlpullparser.getEventType();
			  
	        i = xmlpullparser.next();
	     int j=0;
	        if(xmlpullparser.getAttributeValue(j) != null)
	            hashmap.put(xmlpullparser.getAttributeName(j), xmlpullparser.getAttributeValue(j));
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
 
        return hashmap;

    }

    private static int sTerm(int i, int j)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900, 0, 6, 2, 5, 0);
        long l = calendar.getTime().getTime();
        calendar.setTime(new Date((long)(31556925974.700001D * (double)(i + -1900) + (double)(60000L * STermInfo[j]) + (double)l)));
        return calendar.get(5);
    }

    public static void sendNotification(String s)
    {
        Context context = Gl.Ct();
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        Notification notification = new Notification(0x7f0200c5, context.getResources().getString(0x7f0b0176), System.currentTimeMillis());
        PendingIntent pendingintent = PendingIntent.getActivity(context, 0, new Intent(context, Gl.getMainActivityClass()), 0);
        if(Gl.getNoticedBySound())
            notification.defaults = 1 | notification.defaults;
        if(Gl.getNoticedByVibrate())
            notification.defaults = 2 | notification.defaults;
        notification.flags = 0x10 | notification.flags;
        String s1 = context.getResources().getString(0x7f0b0177);
        notification.tickerText = s;
        notification.setLatestEventInfo(context, s1, s, pendingintent);
        notificationmanager.notify(0, notification);
    }

    private static void setIntent(Context context, String s, String s1)
    {
        Intent intent = new Intent();
        intent.setClassName(s, s1);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static boolean updateWeatherData(int i)
    {
        MojiLog.v("Util", "UpdateWeatherData ");
        boolean flag = AbstractWeatherUpdater.isSucceed(AbstractWeatherUpdater.createInstance().updateSync(i));
        if(!flag)
            flag = AbstractWeatherUpdater.isSucceed(AbstractWeatherUpdater.createInstance().updateSync(i));
        return flag;
    }

    public static boolean widgetIntentCustomLoader(Context context, int i, String s)
    {
        String as[] = Gl.getHotAreaCustomLoaderValue(i, s).split("\\|");
        boolean flag=true;
        if(as[0].equals("none"))
            flag = true;
        else
        if(as[0].equals("default"))
            flag = false;
        else
        if(as[0].equals("voice"))
        {
            flag = true;
            PlayerUtil.playVoiceOnWidget(context);
        } else
        if(as[0].equals("9grid"))
        {
             
        } else
        if(as[0].equals("huangli"))
        {
             
        } else
        if(as[0].equals("updatenow"))
        {
            flag = true;
            if(!isConnectInternet(context))
            {
                Toast.makeText(context, 0x7f0b0160, 1).show();
            } else
            {
                Toast.makeText(context, 0x7f0b0170, 1).show();
                
            }
        } else
        {
            flag = true;
            try
            {
                Intent intent = new Intent();
                intent.setClassName(as[0], as[1]);
                intent.setFlags(0x10000000);
                intent.setAction("android.intent.action.MAIN");
                context.startActivity(intent);
            }
            catch(Exception exception)
            {
                MojiLog.e("Util", "widgetIntentCustomLoader intent error ", exception);
            }
        }
        return flag;
    }

    private static final long STermInfo[];
    private static final String SolarTerm[];
    static String SolarTermB2013[];
    private static final String TAG = "Util";
    private static final String TYPE_ACTION_9GRID = "9grid";
    private static final String TYPE_ACTION_DEFAULT = "default";
    private static final String TYPE_ACTION_HUANGLI = "huangli";
    private static final String TYPE_ACTION_NOSET = "none";
    private static final String TYPE_ACTION_UPDATENOW = "updatenow";
    private static final String TYPE_ACTION_VOICE = "voice";
    private static final String TYPE_CALENDAR_CLASS_ANDROID = "com.android.calendar.LaunchActivity";
    private static final String TYPE_CALENDAR_CLASS_HTC = "com.htc.calendar.MonthActivity";
    private static final String TYPE_CALENDAR_PKG_ANDROID = "com.android.calendar";
    private static final String TYPE_CALENDAR_PKG_GOOGLE = "com.google.android.calendar";
    private static final String TYPE_CALENDAR_PKG_HTC = "com.htc.calendar";
    private static final String TYPE_CLOCK_CLASS_ANDROID = "com.android.alarmclock.AlarmClock";
    private static final String TYPE_CLOCK_CLASS_ANDROIDDESK = "com.android.deskclock.AlarmClock";
    private static final String TYPE_CLOCK_CLASS_HTC = "com.htc.android.worldclock.WorldClockTabControl";
    private static final String TYPE_CLOCK_CLASS_LG_ACTION = "android.intent.action.SET_ALARM";
    private static final String TYPE_CLOCK_CLASS_LG_P970 = "com.lge.alarm.alarmclocknew.deskclock";
    private static final String TYPE_CLOCK_CLASS_MOTO_MB860 = "com.motorola.blur.alarmclock.AlarmClock";
    private static final String TYPE_CLOCK_CLASS_SEC = "com.sec.android.app.clockpackage.ClockPackage";
    private static final String TYPE_CLOCK_PKG_ANDROID = "com.android.alarmclock";
    private static final String TYPE_CLOCK_PKG_ANDROIDDESK = "com.android.deskclock";
    private static final String TYPE_CLOCK_PKG_GOOGLE = "com.google.android.deskclock";
    private static final String TYPE_CLOCK_PKG_HTC = "com.htc.android.worldclock";
    private static final String TYPE_CLOCK_PKG_MOTO_MB860 = "com.motorola.blur.alarmclock";
    private static final String TYPE_CLOCK_PKG_SEC = "com.sec.android.app.clockpackage";
    private static final String TYPE_SPLIT_STRING = "\\|";
    static int dateBefore2013[];
    private static Long sMaxMemory = null;

    static 
    {
        long al[] = new long[24];
        al[0] = 0L;
        al[1] = 21208L;
        al[2] = 42467L;
        al[3] = 63836L;
        al[4] = 0x14d59L;
        al[5] = 0x1a206L;
        al[6] = 0x1f763L;
        al[7] = 0x24d89L;
        al[8] = 0x2a45dL;
        al[9] = 0x2fbdfL;
        al[10] = 0x353d8L;
        al[11] = 0x3ac35L;
        al[12] = 0x404afL;
        al[13] = 0x45d25L;
        al[14] = 0x4b553L;
        al[15] = 0x50d19L;
        al[16] = 0x56446L;
        al[17] = 0x5bac6L;
        al[18] = 0x61087L;
        al[19] = 0x6658aL;
        al[20] = 0x6b9dbL;
        al[21] = 0x70d90L;
        al[22] = 0x760ccL;
        al[23] = 0x7b3b6L;
        STermInfo = al;
        String as[] = new String[24];
        as[0] = "\u5C0F\u5BD2";
        as[1] = "\u5927\u5BD2";
        as[2] = "\u7ACB\u6625";
        as[3] = "\u96E8\u6C34";
        as[4] = "\u60CA\u86F0";
        as[5] = "\u6625\u5206";
        as[6] = "\u6E05\u660E";
        as[7] = "\u8C37\u96E8";
        as[8] = "\u7ACB\u590F";
        as[9] = "\u5C0F\u6EE1";
        as[10] = "\u8292\u79CD";
        as[11] = "\u590F\u81F3";
        as[12] = "\u5C0F\u6691";
        as[13] = "\u5927\u6691";
        as[14] = "\u7ACB\u79CB";
        as[15] = "\u5904\u6691";
        as[16] = "\u767D\u9732";
        as[17] = "\u79CB\u5206";
        as[18] = "\u5BD2\u9732";
        as[19] = "\u971C\u964D";
        as[20] = "\u7ACB\u51AC";
        as[21] = "\u5C0F\u96EA";
        as[22] = "\u5927\u96EA";
        as[23] = "\u51AC\u81F3";
        SolarTerm = as;
        int ai[] = new int[74];
        ai[0] = 0x132b857;
        ai[1] = 0x132b866;
        ai[2] = 0x132db1a;
        ai[3] = 0x132db28;
        ai[4] = 0x132db7c;
        ai[5] = 0x132db8b;
        ai[6] = 0x132dbe2;
        ai[7] = 0x132dbf1;
        ai[8] = 0x132dc45;
        ai[9] = 0x132dc54;
        ai[10] = 0x132dcaa;
        ai[11] = 0x132dcb9;
        ai[12] = 0x132dd0e;
        ai[13] = 0x132dd1e;
        ai[14] = 0x132dd73;
        ai[15] = 0x132dd83;
        ai[16] = 0x132ddd8;
        ai[17] = 0x132dde7;
        ai[18] = 0x132de3c;
        ai[19] = 0x132de4b;
        ai[20] = 0x132dea0;
        ai[21] = 0x132deb0;
        ai[22] = 0x132df04;
        ai[23] = 0x132df13;
        ai[24] = 0x132df67;
        ai[25] = 0x132df76;
        ai[26] = 0x133022a;
        ai[27] = 0x1330239;
        ai[28] = 0x133028c;
        ai[29] = 0x133029b;
        ai[30] = 0x13302f1;
        ai[31] = 0x1330300;
        ai[32] = 0x1330354;
        ai[33] = 0x1330364;
        ai[34] = 0x13303b9;
        ai[35] = 0x13303c8;
        ai[36] = 0x133041d;
        ai[37] = 0x133042d;
        ai[38] = 0x1330483;
        ai[39] = 0x1330492;
        ai[40] = 0x13304e7;
        ai[41] = 0x13304f7;
        ai[42] = 0x133054b;
        ai[43] = 0x133055a;
        ai[44] = 0x13305b0;
        ai[45] = 0x13305bf;
        ai[46] = 0x1330613;
        ai[47] = 0x1330622;
        ai[48] = 0x1330677;
        ai[49] = 0x1330685;
        ai[50] = 0x1332939;
        ai[51] = 0x1332948;
        ai[52] = 0x133299c;
        ai[53] = 0x13329aa;
        ai[54] = 0x1332a01;
        ai[55] = 0x1332a10;
        ai[56] = 0x1332a64;
        ai[57] = 0x1332a74;
        ai[58] = 0x1332ac9;
        ai[59] = 0x1332ad9;
        ai[60] = 0x1332b2d;
        ai[61] = 0x1332b3d;
        ai[62] = 0x1332b93;
        ai[63] = 0x1332ba2;
        ai[64] = 0x1332bf7;
        ai[65] = 0x1332c07;
        ai[66] = 0x1332c5b;
        ai[67] = 0x1332c6b;
        ai[68] = 0x1332cc0;
        ai[69] = 0x1332ccf;
        ai[70] = 0x1332d23;
        ai[71] = 0x1332d32;
        ai[72] = 0x1332d87;
        ai[73] = 0x1332d96;
        dateBefore2013 = ai;
        String as1[] = new String[74];
        as1[0] = "\u5927\u96EA";
        as1[1] = "\u51AC\u81F3";
        as1[2] = "\u5C0F\u5BD2";
        as1[3] = "\u5927\u5BD2";
        as1[4] = "\u7ACB\u6625";
        as1[5] = "\u96E8\u6C34";
        as1[6] = "\u60CA\u86F0";
        as1[7] = "\u6625\u5206";
        as1[8] = "\u6E05\u660E";
        as1[9] = "\u8C37\u96E8";
        as1[10] = "\u7ACB\u590F";
        as1[11] = "\u5C0F\u6EE1";
        as1[12] = "\u8292\u79CD";
        as1[13] = "\u590F\u81F3";
        as1[14] = "\u5C0F\u6691";
        as1[15] = "\u5927\u6691";
        as1[16] = "\u7ACB\u79CB";
        as1[17] = "\u5904\u6691";
        as1[18] = "\u767D\u9732";
        as1[19] = "\u79CB\u5206";
        as1[20] = "\u5BD2\u9732";
        as1[21] = "\u971C\u964D";
        as1[22] = "\u7ACB\u51AC";
        as1[23] = "\u5C0F\u96EA";
        as1[24] = "\u5927\u96EA";
        as1[25] = "\u51AC\u81F3";
        as1[26] = "\u5C0F\u5BD2";
        as1[27] = "\u5927\u5BD2";
        as1[28] = "\u7ACB\u6625";
        as1[29] = "\u96E8\u6C34";
        as1[30] = "\u60CA\u86F0";
        as1[31] = "\u6625\u5206";
        as1[32] = "\u6E05\u660E";
        as1[33] = "\u8C37\u96E8";
        as1[34] = "\u7ACB\u590F";
        as1[35] = "\u5C0F\u6EE1";
        as1[36] = "\u8292\u79CD";
        as1[37] = "\u590F\u81F3";
        as1[38] = "\u5C0F\u6691";
        as1[39] = "\u5927\u6691";
        as1[40] = "\u7ACB\u79CB";
        as1[41] = "\u5904\u6691";
        as1[42] = "\u767D\u9732";
        as1[43] = "\u79CB\u5206";
        as1[44] = "\u5BD2\u9732";
        as1[45] = "\u971C\u964D";
        as1[46] = "\u7ACB\u51AC";
        as1[47] = "\u5C0F\u96EA";
        as1[48] = "\u5927\u96EA";
        as1[49] = "\u51AC\u81F3";
        as1[50] = "\u5C0F\u5BD2";
        as1[51] = "\u5927\u5BD2";
        as1[52] = "\u7ACB\u6625";
        as1[53] = "\u96E8\u6C34";
        as1[54] = "\u60CA\u86F0";
        as1[55] = "\u6625\u5206";
        as1[56] = "\u6E05\u660E";
        as1[57] = "\u8C37\u96E8";
        as1[58] = "\u7ACB\u590F";
        as1[59] = "\u5C0F\u6EE1";
        as1[60] = "\u8292\u79CD";
        as1[61] = "\u590F\u81F3";
        as1[62] = "\u5C0F\u6691";
        as1[63] = "\u5927\u6691";
        as1[64] = "\u7ACB\u79CB";
        as1[65] = "\u5904\u6691";
        as1[66] = "\u767D\u9732";
        as1[67] = "\u79CB\u5206";
        as1[68] = "\u5BD2\u9732";
        as1[69] = "\u971C\u964D";
        as1[70] = "\u7ACB\u51AC";
        as1[71] = "\u5C0F\u96EA";
        as1[72] = "\u5927\u96EA";
        as1[73] = "\u51AC\u81F3";
        SolarTermB2013 = as1;
    }
}
