package com.branded.android.activity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.branded.android.R;
import com.branded.android.entity.BaCoupon;
import com.branded.android.util.Helper;

	public class CouponListActivity extends Activity    {
	public static final String tag = "CouponListActivity";
	public static final String BROADCAST_FOR_COUPONS="BROADCAST_FOR_COUPONS";
	public static final String BROADCAST_FOR_COUPONS_DETAIL="BROADCAST_FOR_COUPONS_DETAIL";
	public static List<BaCoupon> mCouponList;
	private EfficientAdapter adapter = null;

	private static class EfficientAdapter extends BaseAdapter {
	        private LayoutInflater mInflater;
	        private Bitmap defaultIcon;
	        public EfficientAdapter(Context context) {
	            // Cache the LayoutInflate to avoid asking for a new one each time.
	            mInflater = LayoutInflater.from(context);
	            defaultIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.coupon_icon);
	            //或者：Bitmap buffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);buffer.eraseColor(Color.TRANSPARENT); 
	        }


	        public int getCount() {
	            return mCouponList.size();
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
	                convertView = mInflater.inflate(R.layout.coupon_item, null);
	                holder = new ViewHolder();
	                holder.text_1 = (TextView) convertView.findViewById(R.id.text_1);
	                holder.text_2 = (TextView) convertView.findViewById(R.id.text_2);
	                holder.text_3 = (TextView) convertView.findViewById(R.id.text_3);
	                holder.couponIcon = (ImageView) convertView.findViewById(R.id.coupon_icon);
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
	            
	            
	            holder.text_1.setText(mCouponList.get(position).getCtitle());
	            holder.text_2.setText(mCouponList.get(position). getCbrief());

	            //---------------------------
	            String date = mCouponList.get(position).getCvdate();
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
	            holder.text_3.setText("Expiry: "+ dateStr);//  
	            Bitmap bmp = mCouponList.get(position).getImg();
	            if(bmp==null){
		            holder.couponIcon.setImageBitmap(defaultIcon);

	            }else{
		            holder.couponIcon.setImageBitmap(mCouponList.get(position).getImg());
	            }
//				holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : mIcon2);
//	            mIcon = returnBitMap("http://www.cellflare.com/getimages.aspx?code=angwan@sina.com");

	            return convertView;
	        }

	        static class ViewHolder {
	            TextView text_1;
	            TextView text_2;
	            TextView text_3;
	            ImageView couponIcon;
	        }
	    }

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Intent intent = getIntent();
	        final int sid = intent.getIntExtra("sid", 0 );
 			adapter = new EfficientAdapter(this);
	    	this.setContentView(R.layout.list);	//list.xml中，可以部分是item，比较灵活，而cellflare中，是直接setListAdapter，整个屏幕是一个list，不太灵活
	    	//set title
	    	TextView title = (TextView)findViewById(R.id.title);
	    	title.setText(R.string.coupon_list_title);
	    	//end title
			ListView list = (ListView) this.findViewById(R.id.mylist);
			list.setAdapter(adapter);
	        list.setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
						long arg3) {
					Log.d(tag,"onItemClick:"+arg2);

					Intent i = new Intent();
					i.putExtra("coupon_index", arg2);
					i.putExtra("sid",sid);
					i.setClass(CouponListActivity.this, CouponDetailActivity.class);
					CouponListActivity.this.startActivity(i);
				}});
			//
	        list.setBackgroundColor(Color.parseColor("#FFFFFF"));
	        //
	
		      Button mapViewButton = (Button)findViewById(R.id.mapview_bt);
		      mapViewButton.setVisibility(View.INVISIBLE);// 某些界面没有这个按钮，可隐藏
	        
		      Helper.setOnInfoAndHome(this);
	   }

   @Override
    protected void onResume() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(BROADCAST_FOR_COUPONS);
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
