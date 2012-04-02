// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SkinDownloadListActivity.java

package com.moji.mjweather.widgetskin;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.HttpUtil;
import com.moji.mjweather.util.SkinUtil;
import com.moji.mjweather.util.UiUtil;

// Referenced classes of package com.moji.mjweather.widgetskin:
//            BitmapCacheManager, SkinDownloadDetailActivity

public class SkinDownloadListActivity extends ListActivity
{
    private static class ViewHolder
    {

        ImageView m_imageView;
        TextView skinAuthor;
        TextView skinDetailInfo;
        TextView skinName;
        ImageView usingImgageView;

        private ViewHolder()
        {
        }

    }

    private class UpdateDownloadCountThread extends Thread
    {

        public void run()
        {
            super.run();
            
 
        }

        private String sUrl;
       

        public UpdateDownloadCountThread(String s)
        {
           
            super();
            sUrl = s;
        }
    }

    /* member class not found */
    class COSDSkinDownloadListAdapter {}

    /* member class not found */
    class LoadSkinListThread {}


    public SkinDownloadListActivity()
    {
        m_currentTopItemIndex = -1;
        m_currentShowItemCount = -1;
        mMojiFilePath = SkinUtil.getMojiDir();
    }

    private void checkInstall()
    {
       
    }

    private void checkInvalidateSkinList()
    {
        
    }

    private void checkUnInstall(List list)
    {
         
    }

  
    private String listToString(List list)
    {
        String s = "";
        for(int i = 0; i < list.size(); i++)
        {
            s = (new StringBuilder()).append(s).append((String)list.get(i)).toString();
            if(i != -1 + list.size())
                s = (new StringBuilder()).append(s).append(",").toString();
        }

        return s;
    }

    private List stringToList(String s)
    {
        ArrayList arraylist = new ArrayList();
        if(!s.equals(""))
        {
            String as[] = s.split(",");
            for(int i = 0; i < as.length; i++)
                arraylist.add(as[i]);

        }
        return arraylist;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MojiLog.v("SkinDownloadListActivity", "onCreate ");
        setContentView(0x7f030068);
        mSkinResName = getResources().getStringArray(0x7f07000a);
        m_listViewd = getListView();
        m_listViewd.setDividerHeight(2);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(BitmapFactory.decodeResource(Gl.Ct().getResources(), 0x7f020126));
        m_listViewd.setDivider(bitmapdrawable);
        m_listViewd.setBackgroundDrawable(UiUtil.getBgBitmapDrawable());
        m_listViewd.setCacheColorHint(0);
        mCDialogManager = new CDialogManager(this, null);
         Gl.saveSkinApkInstalled(false);
        checkInstall();
  
        SkinUtil.createDirs();
        m_skinDirectoryList = SkinUtil.getSkinDirList(this);
        m_eventHandler = new Handler() {

            public void handleMessage(Message message)
            {
               switch( message.what)
               {
               
               case 0: mDialog.setMessage((String)message.obj);break;
               case 101: break;
               default: return;
               }
                
            }

            
        }
;
       
    }

    protected Dialog onCreateDialog(int i)
    {
 
        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(0);
        mDialog.setMessage(getResources().getString(0x7f0b017f));
        mDialog.setCancelable(false);
        mDialog.show();
        return mDialog;
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        if(listview.getHeaderViewsCount() == 0)
        {
            Intent intent = new Intent(this, SkinDownloadDetailActivity.class);
            intent.putExtra("skinInfo", (Parcelable)m_skinInfoList.get(i));
            intent.putExtra("dirPathName", (String)m_skinDirectoryList.get(i));
            startActivity(intent);
        } else
        {
            Intent intent1 = new Intent(this,  SkinDownloadDetailActivity.class);
            intent1.putExtra("skinInfo", (Parcelable)m_skinInfoList.get(i - listview.getHeaderViewsCount()));
            intent1.putExtra("dirPathName", (String)m_skinDirectoryList.get(i - listview.getHeaderViewsCount()));
            startActivity(intent1);
        }
    }

    protected void onRestart()
    {
        super.onRestart();
        MojiLog.d("SkinDownloadListActivity", "onRestart");
        Gl.saveSkinApkInstalled(false);
        checkInvalidateSkinList();
    }

    protected void onResume()
    {
        super.onResume();
        MojiLog.d("SkinDownloadListActivity", "onResume");
        if(Gl.getSkinApkInstalled())
        {
            Gl.saveSkinApkInstalled(false);
            checkInvalidateSkinList();
        }
    }

    private static final int LOAD_SKIN = 1;
    private static final int MSG_LOAD_SKININFO_FINISH = 101;
    private static final String TAG = "SkinDownloadListActivity";
    private static String mSkinResName[];
    private CDialogManager mCDialogManager;
    private ProgressDialog mDialog;
    private String mMojiFilePath;
    private int m_currentShowItemCount;
    private int m_currentTopItemIndex;
    private Handler m_eventHandler;
 
    private ListView m_listViewd;
    private android.widget.AbsListView.OnScrollListener m_scrollLisenter;
    private List m_skinDirectoryList;
    private List m_skinInfoList;
    private COSDSkinDownloadListAdapter m_skinSdCardListAdapter;




/*
    static List access$102(SkinDownloadListActivity skindownloadlistactivity, List list)
    {
        skindownloadlistactivity.m_skinInfoList = list;
        return list;
    }

*/





/*
    static COSDSkinDownloadListAdapter access$402(SkinDownloadListActivity skindownloadlistactivity, COSDSkinDownloadListAdapter cosdskindownloadlistadapter)
    {
        skindownloadlistactivity.m_skinSdCardListAdapter = cosdskindownloadlistadapter;
        return cosdskindownloadlistadapter;
    }

*/



/*
    static int access$502(SkinDownloadListActivity skindownloadlistactivity, int i)
    {
        skindownloadlistactivity.m_currentTopItemIndex = i;
        return i;
    }

*/



/*
    static int access$602(SkinDownloadListActivity skindownloadlistactivity, int i)
    {
        skindownloadlistactivity.m_currentShowItemCount = i;
        return i;
    }

*/

}
