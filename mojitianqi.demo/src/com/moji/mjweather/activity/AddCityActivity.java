// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddCityActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.widgetskin.SkinInfo;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.moji.mjweather.activity:
//            CityManagerActivity

public class AddCityActivity extends Activity
    implements TextWatcher
{
    class CitySqlite
    {

        public void close()
        {
            if(connCity != null)
                connCity.close();
        }

        public Cursor getChooseCity(String s)
        {
            String s1 = (new StringBuilder()).append("select cityname,provincename from city c inner join province p on c.provinceid=p.provinceid where c.cityname like '").append(s).append("%' or c.pycityname like '").append(s).append("%' or c.pyshort like '").append(s).append("%' or p.provincename like '").append(s).append("%'").toString();
            return connCity.rawQuery(s1, null);
        }

        public String getCityId(String s)
        {
            String s1 = "";
            String s2 = (new StringBuilder()).append("select cityid from city where cityname='").append(s).append("'").toString();
            Cursor cursor;
            for(cursor = connCity.rawQuery(s2, null); cursor != null && cursor.moveToNext();)
                s1 = cursor.getString(0);

            if(cursor != null)
                cursor.close();
            return s1;
        }

        public void initDBCity()
        {
            File file;
            file = context.getDatabasePath("mojicity.db");
            File file1 = new File(file.toString().substring(0, file.toString().lastIndexOf("/")));
            if(!file1.exists())
                file1.mkdir();
            if(!file.exists())                
            return;
            InputStream inputstream = context.getResources().openRawResource(0x7f060001);
            FileOutputStream fileoutputstream;
			try {
				fileoutputstream = new FileOutputStream(file);
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
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
             
 
        }

        private SQLiteDatabase connCity;
        Context context;
    

        public CitySqlite(Context context1)
        {
         
            super();
            connCity = null;
            context = context1;
            initDBCity();
            connCity = context1.openOrCreateDatabase("mojicity.db", 0, null);
        }
    }

    class CityGridAdapter extends BaseAdapter
    {

        public int getCount()
        {
            return cityList.size();
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
            LinearLayout linearlayout;
            TextView textview;
            TextView textview1;
            String s;
            String s1;
            linearlayout = (LinearLayout)m_layoutInflater.inflate(0x7f03002f, null);
            textview = (TextView)linearlayout.findViewById(0x7f0d00d6);
            textview1 = (TextView)linearlayout.findViewById(0x7f0d00d7);
            Map map = (Map)cityList.get(i);
            s = (String)map.get("cityName");
            s1 = (String)map.get("cityProvince");
            textview.setText(s);
            textview1.setVisibility(0);
            textview1.setText((new StringBuilder()).append(" - ").append(s1).toString());
            if(isSelectCity(s))
                textview.setBackgroundResource(0x7f020113);
         
            linearlayout.setGravity(17);
            if(i == 0 && mDisplayLocation && SkinInfo.getScreeType() != com.moji.mjweather.widgetskin.SkinInfo.ScreenResolution.SR_240_320)
                textview.getPaint().setFakeBoldText(true);
            textview.setText(s);
            if(isSelectCity(s) || i == 0 && isLocationCity())
                textview.setBackgroundResource(0x7f020113);
            return linearlayout;
        }

        public void setDate(List list)
        {
            cityList = list;
        }

        public void setGridItemType(int i)
        {
            m_gridItemType = i;
        }

        private List cityList;
        private int m_gridItemType;
        private LayoutInflater m_layoutInflater;
 

        public CityGridAdapter(Context context)
        {
 
            super();
            m_gridItemType = 3;
            m_layoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }


    public AddCityActivity()
    {
    }

    private boolean isLocationCity()
    {
       for( int i = 0;(CityManagerActivity.getList()!= null && i < CityManagerActivity.getList().size());i++)
       {
    	   if(WeatherData.getCityInfo(i).m_cityID == -99) return false;
       }
       
       return true;

    }

    private boolean isSelectCity(String s)
    {
        boolean flag;
        if(mCityNameList.contains(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void selectCity()
    {
        mCityNameList = new ArrayList();
        for(int i = 0; CityManagerActivity.getList() != null && i < CityManagerActivity.getList().size(); i++)
            mCityNameList.add(WeatherData.getCityInfo(i).mCityName);

    }

    public void afterTextChanged(Editable editable)
    {
        String s;
        s = editable.toString().toLowerCase();
        if(s.contains("'") || s.contains("%"))
            s = "?";
        MojiLog.v("AddCityActivity", "----afterTextChanged");
        if(!TextUtils.isEmpty(s))
        {
        	 if(s.length() <= 20)
                 setGridAdapter(s, 1);
        }
        	else  
        setGridAdapter(s, 3);
 
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public List getCityList(String s)
    {
        Cursor cursor = mCitySqlite.getChooseCity(s);
        mCityList = new ArrayList();
        while(cursor.moveToNext()) 
        {
            String s1 = cursor.getString(0);
            String s2 = cursor.getString(1);
            mCityValuesMap = new HashMap();
            mCityValuesMap.put("cityProvince", s2);
            mCityValuesMap.put("cityName", s1);
            mCityList.add(mCityValuesMap);
            mCityValuesMap = null;
        }
        cursor.close();
        return mCityList;
    }

    public List getHotCityList()
    {
        mCityList = new ArrayList();
        int i;
        if(mDisplayLocation)
        {
            mHotCity = mHotCitys;
            mHotCityId = mHotCityIds;
        } else
        {
            mHotCity = new String[-1 + mHotCitys.length];
            mHotCityId = new String[-1 + mHotCitys.length];
            System.arraycopy(mHotCitys, 1, mHotCity, 0, -1 + mHotCitys.length);
            System.arraycopy(mHotCityIds, 1, mHotCityId, 0, -1 + mHotCitys.length);
        }
        for(i = 0; i < mHotCity.length; i++)
        {
            mCityValuesMap = new HashMap();
            mCityValuesMap.put("cityid", mHotCityId[i]);
            mCityValuesMap.put("cityName", mHotCity[i]);
            mCityList.add(mCityValuesMap);
            mCityValuesMap = null;
        }

        return mCityList;
    }

    public void init()
    {
        selectCity();
        mHotCitys = getResources().getStringArray(0x7f070004);
        mHotCityIds = getResources().getStringArray(0x7f070005);
        mCitySqlite = new CitySqlite(this);
        mBtnClear = (ImageButton)findViewById(0x7f0d000c);
        mBtnClear.setVisibility(8);
        mCityGrid = (GridView)findViewById(0x7f0d000e);
        mFindKey = (EditText)findViewById(0x7f0d000b);
        mFindKey.addTextChangedListener(this);
        mHotTitle = (TextView)findViewById(0x7f0d000d);
        mCityGridAdapter = new CityGridAdapter(this);
        mCityGridAdapter.setDate(getHotCityList());
        mCityGrid.setAdapter(mCityGridAdapter);
        View view = findViewById(0x1020004);
        mCityGrid.setEmptyView(view);
        mCityGrid.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                Handler handler = Gl.getHandler();
                if(TextUtils.isEmpty(mFindKey.getText()))
                {
                    if(mDisplayLocation)
                    {
                        if(i == 0)
                        {
                            Message message3 = handler.obtainMessage(2);
                            message3.arg1 = mCityIndex;
                            message3.arg2 = -99;
                            message3.obj = mHotCity[i];
                            handler.sendMessageDelayed(message3, 200L);
                        } else
                        {
                            Message message2 = handler.obtainMessage(2);
                            message2.arg1 = mCityIndex;
                            message2.arg2 = Integer.parseInt(mHotCityId[i]);
                            message2.obj = mHotCity[i];
                            handler.sendMessageDelayed(message2, 200L);
                        }
                    } else
                    {
                        Message message1 = handler.obtainMessage(2);
                        message1.arg1 = mCityIndex;
                        message1.arg2 = Integer.parseInt(mHotCityId[i]);
                        message1.obj = mHotCity[i];
                        handler.sendMessageDelayed(message1, 200L);
                    }
                    finish();
                } else
                {
                    String s = ((Map)mCityList.get(i)).get("cityName").toString();
                    Message message = handler.obtainMessage(2);
                    message.arg1 = mCityIndex;
                    message.arg2 = Integer.parseInt(mCitySqlite.getCityId(s));
                    message.obj = s;
                    handler.sendMessageDelayed(message, 200L);
                    finish();
                }
            }

           
        }
);
        mBtnClear.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
                mFindKey.setText(null);
            }

          
        }
);
    }

    public boolean isCityNameorWord(String s)
    {
        return Pattern.compile("^([A-Za-z]+$)|([\u4E00-\u9FA5]{0,}$)").matcher(s).matches();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030003);
        Bundle bundle1 = getIntent().getExtras();
        mCityIndex = bundle1.getInt("cityindex");
        mDisplayLocation = bundle1.getBoolean("isNoDisplayLocation");
        setWindow();
        init();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        mCitySqlite.close();
        MojiLog.v("AddCityActivity", "onDestroy()");
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag;
        if(!TextUtils.isEmpty(mFindKey.getText()))
        {
            if(i == 4)
                mFindKey.setText(null);
            flag = true;
        } else
        {
            flag = super.onKeyDown(i, keyevent);
        }
        return flag;
    }

    protected void onPause()
    {
        super.onPause();
        finish();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void setGridAdapter(String s, int i)
    {
        if(!mCityList.isEmpty())
        {
            mCityList.clear();
            mCityList = null;
        }
        mCityGrid.setNumColumns(i);
        if(TextUtils.isEmpty(s))
        {
            mCityGridAdapter.setGridItemType(3);
            mHotTitle.setVisibility(0);
            mBtnClear.setVisibility(8);
            mCityGridAdapter.setDate(getHotCityList());
            mCityGridAdapter.notifyDataSetChanged();
        } else
        {
            mCityGridAdapter.setGridItemType(1);
            mHotTitle.setVisibility(8);
            mBtnClear.setVisibility(0);
            mCityGridAdapter.setDate(getCityList(s));
            mCityGridAdapter.notifyDataSetChanged();
        }
    }

    public void setWindow()
    {
        Display display = getWindowManager().getDefaultDisplay();
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.height = (int)(0.90000000000000002D * (double)display.getHeight());
        layoutparams.width = (int)(0.97999999999999998D * (double)display.getWidth());
        getWindow().setAttributes(layoutparams);
    }

    private static final int BUFFER_READ_COUNT = 0;
    private static final int BUFFER_SIZE = 8192;
    private static final int COLUMN_INDEX_FIRST = 0;
    private static final int COLUMN_INDEX_SECOND = 1;
    private static final int COPYARRAY_DES_POST = 0;
    private static final int COPYARRAY_SRC_POST = 1;
    private static final int DB_MODEL = 0;
    private static final int EDITTEXT_MAX_SIZE = 20;
    private static final int GRID_FIRST_ITME_SIZE = 1;
    private static final int GRID_ITME_FIRST = 0;
    private static final int HANDLER_DELAY_TIME = 200;
    private static final String KEY_CITY_ID = "cityid";
    private static final String KEY_CITY_NAME = "cityName";
    private static final String KEY_CITY_PROVINCE = "cityProvince";
    private static final String MATCHER_STYLE_STRING = "^([A-Za-z]+$)|([\u4E00-\u9FA5]{0,}$)";
    private static final int M_GridItemType_1 = 1;
    private static final int M_GridItemType_3 = 3;
    private static final double SCALE_ACTIVIYT_HEIGHT = 0.90000000000000002D;
    private static final double SCALE_ACTIVIYT_WIDTH = 0.97999999999999998D;
    private static final String STRING_EMPTY = "";
    private static final String STRING_SPLIT = " - ";
    private static final String STRING_SPLIT_NEWLINE = "/";
    private static final String TAG = "AddCityActivity";
    private static String mHotCityIds[] = new String[34];
    private static String mHotCitys[] = new String[34];
    private ImageButton mBtnClear;
    private GridView mCityGrid;
    private CityGridAdapter mCityGridAdapter;
    private int mCityIndex;
    private List mCityList;
    private ArrayList mCityNameList;
    private CitySqlite mCitySqlite;
    private Map mCityValuesMap;
    private boolean mDisplayLocation;
    private EditText mFindKey;
    private String mHotCity[];
    private String mHotCityId[];
    private TextView mHotTitle;










}
