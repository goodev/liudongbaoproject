package com.branded.android.activity;

import java.math.BigDecimal;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.branded.android.R;
import com.branded.android.entity.StoreDetail;
import com.branded.android.rpc.GpsService;
import com.branded.android.util.BrandedConstants;
import com.branded.android.util.Helper;

	//public class StoreListActivity extends ListActivity implements ListView.OnScrollListener  {
	public class StoreListActivity extends Activity  {
	public static final String tag = "StoreListActivity";
	public static List<StoreDetail> mStoreList;
	private EfficientAdapter adapter = null;
	private boolean isByAddr;
//    Handler mHandler = new Handler();
//    private WindowManager mWindowManager;
//    private View mView_bottom;
//    private View mView_top;
//    private boolean mReady;
	private static class EfficientAdapter extends BaseAdapter {
	        private LayoutInflater mInflater;
	        private Bitmap transparencyBmp;
	        private boolean m_isByAddr;
	        public EfficientAdapter(Context context,boolean isByAddr) {
	            // Cache the LayoutInflate to avoid asking for a new one each time.
	        	m_isByAddr = isByAddr;
	            mInflater = LayoutInflater.from(context);
	            transparencyBmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.one_point);
	            //或者：Bitmap buffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);buffer.eraseColor(Color.TRANSPARENT); 
	        }


	        public int getCount() {
	            return mStoreList.size();
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
	                convertView = mInflater.inflate(R.layout.store_item, null);
	                holder = new ViewHolder();
	                holder.numStreet = (TextView) convertView.findViewById(R.id.numStreet);
	                holder.cityPro = (TextView) convertView.findViewById(R.id.cityPro);
	                holder.distance = (TextView) convertView.findViewById(R.id.distance);
	                holder.flyerIcon = (ImageView) convertView.findViewById(R.id.flyerIcon);
	                holder.couponIcon = (ImageView) convertView.findViewById(R.id.couponIcon);
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
	            
	            
	            holder.numStreet.setText(mStoreList.get(position).getAddr());
	            holder.cityPro.setText(mStoreList.get(position).getCity()+","+mStoreList.get(position).getProv()+" "+ mStoreList.get(position).getPs());
				float []results = new float[2];
				
				if(m_isByAddr){
		            Location.distanceBetween(GpsService.mLatByAddress, GpsService.mLonByAddress, mStoreList.get(position).getLat(), mStoreList.get(position).getLon(), results);
				}else{
		            Location.distanceBetween(GpsService.mLocation.getLatitude(), GpsService.mLocation.getLongitude(), mStoreList.get(position).getLat(), mStoreList.get(position).getLon(), results);
				}
	    	       
	            BigDecimal dist = new BigDecimal(results[0]/1000);
	            holder.distance.setText(String.valueOf(dist.setScale(2,BigDecimal.ROUND_HALF_UP))+" km");//FIXME 
	            
	            //holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : mIcon2);
//	            mIcon = returnBitMap("http://www.cellflare.com/getimages.aspx?code=angwan@sina.com");
	            if( mStoreList.get(position).getCc()<=0 ){
	            	holder.couponIcon.setImageBitmap(transparencyBmp);
	            }

	            if( mStoreList.get(position).getFc()<=0 ){
	            	holder.flyerIcon.setImageBitmap(transparencyBmp);
	            }
	           
	            return convertView;
	        }

	        static class ViewHolder {
	            TextView numStreet;
	            TextView cityPro;
	            TextView distance;
	            ImageView flyerIcon;
	            ImageView couponIcon;
	        }
	    }
	@Override
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

//	        this.getListView().setBackgroundColor(Color.parseColor("#E4E4E2"));//global backgroud;
//			if(StoreListActivity.mStoreList==null ||StoreListActivity.mStoreList.size()==0){
//			  //  setContentView(R.layout.contacts_no_rows);
//			   // return;
//			}
	        
	    	this.setContentView(R.layout.list);
	    	//set title
	    	TextView title = (TextView)findViewById(R.id.title);
	    	title.setText("Results-List("+mStoreList.size()+")");
	    	//end title
			ListView list = (ListView) this.findViewById(R.id.mylist);
			
	  	    Intent i = getIntent();
	  	    isByAddr = i.getBooleanExtra(BrandedConstants.TYPE_BY_ADDR,false);
			adapter = new EfficientAdapter(this,isByAddr);
			//setListAdapter(adapter);
			list.setAdapter(adapter);
			
	        list.setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Log.d(tag,"onItemClick:"+position);
								Helper.doStoreDetailActivity(StoreListActivity.this,position,isByAddr);
					
				}});	
	
	        list.setBackgroundColor(Color.parseColor("#FFFFFF"));
	    
		      Button mapViewButton = (Button)findViewById(R.id.mapview_bt);
		      //mapViewButton.setVisibility(View.INVISIBLE); 某些界面没有这个按钮，可隐藏
		      mapViewButton.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.d(tag, "mapview button is onClicked");
					Helper.doMapView(StoreListActivity.this,StoreListActivity.this.isByAddr);
				}});
		      Helper.setOnInfoAndHome(this);
	 }
	
	
	//////////////////////////////////////////////////////////////////
/*
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        this.getListView().setBackgroundColor(Color.parseColor("#E4E4E2"));//global backgroud;
//			if(StoreListActivity.mStoreList==null ||StoreListActivity.mStoreList.size()==0){
//			  //  setContentView(R.layout.contacts_no_rows);
//			   // return;
//			}
	        
	  	    Intent i = getIntent();
    	    final boolean isByAddr = i.getBooleanExtra(BrandedConstants.TYPE_BY_ADDR,false);
			adapter = new EfficientAdapter(this,isByAddr);
	        setListAdapter(adapter);

	        getListView().setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
						long arg3) {
					Log.d(tag,"onItemClick:"+arg2);
					Intent i = new Intent();
					i.putExtra("store_index", arg2);
					i.putExtra("isByAddr",isByAddr);
					i.setClass(StoreListActivity.this, StoreDetailActivity.class);
					StoreListActivity.this.startActivity(i);
				}});
			//
	        registerForContextMenu(this.getListView());  
	        //
	        getListView().setOnScrollListener(this);
	        mWindowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
	        LayoutInflater inflate = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        
	        
	        mView_bottom = (View) inflate.inflate(R.layout.list_bottom,null);
	        mView_bottom.setVisibility(View.INVISIBLE);
	      
	        mView_top = (View) inflate.inflate(R.layout.list_top, null);
	        mView_top.setVisibility(View.INVISIBLE);
	     
	        mHandler.post(new Runnable() {

	            public void run() {
	            	mReady = true;
//	                WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
//	                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
//	                        WindowManager.LayoutParams.TYPE_APPLICATION,
//	                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
//	                                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//	                        PixelFormat.TRANSLUCENT);
//	                mWindowManager.addView(mView_bottom, lp);
	                
	                WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
	                        LayoutParams.WRAP_CONTENT,
	                        55,
	                        WindowManager.LayoutParams.TYPE_APPLICATION,
	                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE  ,
	                        PixelFormat.TRANSPARENT);
	                lp.gravity= Gravity.RIGHT | Gravity.BOTTOM; 
	                mWindowManager.addView(mView_bottom, lp);
	                
	                WindowManager.LayoutParams lp2 = new WindowManager.LayoutParams(
	                        LayoutParams.WRAP_CONTENT  , 
	                        LayoutParams.WRAP_CONTENT  ,
	                        WindowManager.LayoutParams.TYPE_APPLICATION,
	                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE ,
	                        PixelFormat.TRANSLUCENT);
	                lp2.gravity= Gravity.CENTER| Gravity.TOP; 
	                mWindowManager.addView(mView_top, lp2);
	                
	            }});
	        
	      Button mapViewButton = (Button)mView_bottom.findViewById(R.id.mapview_bt);
	      mapViewButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d(tag, "mapview button is onClicked");
				Helper.doMapView(StoreListActivity.this);
			}});
	      
	   }

		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			// TODO Auto-generated method stub
			 if (mReady) {
				 mView_bottom.setVisibility(View.VISIBLE);
				 mView_top.setVisibility(View.VISIBLE);
			 }
	           
	            //mHandler.removeCallbacks(mRemoveWindow);
	            //mHandler.postDelayed(mRemoveWindow, 3000);
		}

		public void onScrollStateChanged(AbsListView view, int scrollState) {
			// TODO Auto-generated method stub
			
		}

   @Override
    protected void onResume() {
        super.onResume();
        mReady = true;
    }

    
    @Override
    protected void onPause() {
        super.onPause();
        mReady = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWindowManager.removeView(mView_bottom);
        mWindowManager.removeView(mView_top);
        mReady = false;
    }
*/  
	    
 
}
