package com.branded.android.activity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.branded.android.R;
import com.branded.android.entity.Flyer;
import com.branded.android.util.Helper;

	public class FlyerListActivity extends  Activity   {
	public static final String tag = "FlyerListActivity";
	public static final String BROADCAST_FOR_FLYERS="BROADCAST_FOR_FLYERS";
	public static List<Flyer> mFlyerList;
	private EfficientAdapter adapter = null;
	private boolean isByAddr;


	private static class EfficientAdapter extends BaseAdapter {
	        private LayoutInflater mInflater;
	        private Bitmap defaultIcon;
	        public EfficientAdapter(Context context) {
	            // Cache the LayoutInflate to avoid asking for a new one each time.
	            mInflater = LayoutInflater.from(context);
	            defaultIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.flyer_icon);
	            //或者：Bitmap buffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);buffer.eraseColor(Color.TRANSPARENT); 
	        }


	        public int getCount() {
	            return mFlyerList.size();
	        }


	        public Object getItem(int position) {
	            return position;
	        }


	        public long getItemId(int position) {
	            return position;
	        }


	        public View getView(int position, View convertView, ViewGroup parent) {
	            ViewHolder holder;
	            if (convertView == null) {
	                convertView = mInflater.inflate(R.layout.flyer_item, null);
	                holder = new ViewHolder();
	                holder.text_1 = (TextView) convertView.findViewById(R.id.txt_title);
	                holder.text_2 = (TextView) convertView.findViewById(R.id.txt_brief);
	                holder.text_3 = (TextView) convertView.findViewById(R.id.txt_vdate);
	                holder.flyerIcon = (ImageView) convertView.findViewById(R.id.flyer_icon);
	                convertView.setTag(holder);

	            } else {
	                holder = (ViewHolder) convertView.getTag();
	            }
	            //Odd/Even use different color 
	            if(position%2==0){
	            	convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            }
	            else{
	            	convertView.setBackgroundColor(Color.parseColor("#EEEEEE"));            	
	            }
	            
	            
	            holder.text_1.setText(mFlyerList.get(position).getFtitle());
	            holder.text_2.setText(mFlyerList.get(position). getFbrief());

	            //---------------------------
	            String date = mFlyerList.get(position).getFvdate();
	            if(date!=null&&"".equals(date)){
		            date =date.substring(date.indexOf(',')+1,date.indexOf('|'));
		            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //mm一定要大写!
			   		String dateStr="";
					 try {
						 Date d = df.parse(date);
						 DateFormat fullDateFormat =
							 DateFormat.getDateTimeInstance(
							 DateFormat.FULL,
							 DateFormat.DEFAULT,
							 new Locale("en"));
						 dateStr = fullDateFormat.format(d);
						 dateStr = dateStr.substring(0,dateStr.indexOf(':')-2).replaceFirst(" ", "");
			
					} catch (ParseException e) {
						e.printStackTrace();
						Log.e(tag, "transfer date fail"+e);
					}
		            //------------------------------
		            holder.text_3.setText("Expiry:"+ dateStr);//  
	            }

	            
	            Bitmap bmp = mFlyerList.get(position).getImgMap().get(0);//flyer的detail的第一个page的图
	            if(bmp==null){
	      	            holder.flyerIcon.setImageBitmap(defaultIcon);      	
	            }else{
      	            holder.flyerIcon.setImageBitmap(mFlyerList.get(position).getImgMap().get(0));//page=0,被存放了list的小图标      	
	            }
 
//				holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : mIcon2);
//	            mIcon = returnBitMap("http://www.cellflare.com/getimages.aspx?code=angwan@sina.com");

	            return convertView;
	        }

	        static class ViewHolder {
	            TextView text_1;
	            TextView text_2;
	            TextView text_3;
	            ImageView flyerIcon;
	        }
	    }

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Intent intent = getIntent();
			isByAddr = intent.getBooleanExtra("isByAddr",false);

	        final int sid = intent.getIntExtra("sid", 0 );
 //			if(StoreListActivity.mFlyerList==null ||StoreListActivity.mFlyerList.size()==0){
//			  //  setContentView(R.layout.contacts_no_rows);
//			   // return;
//			}
	        
	    	this.setContentView(R.layout.list);
	    	//set title
	    	TextView title = (TextView)findViewById(R.id.title);
	    	title.setText(R.string.flyer_list_title);
	    	//end title
			adapter = new EfficientAdapter(this);
			ListView list = (ListView) this.findViewById(R.id.mylist);
	        list.setAdapter(adapter);

	        list.setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
						long arg3) {
					Log.d(tag,"onItemClick:"+arg2);
					Intent i = new Intent();
					i.putExtra("flyer_index", arg2);
					i.putExtra("sid",sid);
					i.setClass(FlyerListActivity.this, FlyerDetailActivity.class);
					FlyerListActivity.this.startActivity(i);
				}});
			//
	        list.setBackgroundColor(Color.parseColor("#FFFFFF"));
	        //
 
	        
	      Button mapViewButton = (Button)findViewById(R.id.mapview_bt);
	      mapViewButton.setVisibility(View.INVISIBLE);// 某些界面没有这个按钮，可隐藏
//	      mapViewButton.setOnClickListener(new OnClickListener(){
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Log.d(tag, "mapview button is onClicked");
//				Helper.doMapView(FlyerListActivity.this,isByAddr);
//			}});
//	      
	        
	      Helper.setOnInfoAndHome(this);
	   }

 

   @Override
    protected void onResume() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(BROADCAST_FOR_FLYERS);
		this.registerReceiver(mBr, filter);
       
		super.onResume();
    }

    
    @Override
    protected void onPause() {
    	this.unregisterReceiver(mBr);
    	
        super.onPause();
    }
	    
	public BroadcastReceiver mBr = new BroadcastReceiver() {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			adapter.notifyDataSetChanged();
			Log.d("adapter","notifyDataSetChanged");
		}

	};		    
 
}
