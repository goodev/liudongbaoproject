package com.branded.android.activity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.branded.android.R;
import com.branded.android.util.Helper;

public class CouponDetailActivity extends Activity {
	public static final String tag = "StoreDetailActivity";
	int index;
	ImageView iv;
	ImageView ivBar;
	TextView tv ;
	TextView tv2 ;
	ZoomControls  zc;
	HashMap<Integer,Boolean> needRefresh = new HashMap<Integer, Boolean>();//�����ĳindex��ͼƬ�Ŵ�󣬴�ʱ��̨֪ͨˢ�£��������¼���Ŵ�ͼƬ����ˢ��ԭʼ�ġ�
    private Runnable mZoomControlRunnable;
    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coupon_detail);
    	//set title
    	TextView title = (TextView)findViewById(R.id.title);
    	title.setText(R.string.coupon_list_title);
    	//end title
		
		Intent intent = getIntent();
		index = intent.getIntExtra("coupon_index", 0);
		final int sid =  intent.getIntExtra("sid", 0);
	
		iv = (ImageView)findViewById(R.id.coupon_detail_img);
		ivBar = (ImageView)findViewById(R.id.coupon_bar_img);
		tv = (TextView)findViewById(R.id.cbrief);
		tv2 = (TextView)findViewById(R.id.expiry);
 		
		showDetail(sid,index); 
		if(CouponListActivity.mCouponList.get(index).getBigImg()==null){
			needRefresh.put(index, true);
			//����СͼƬ��ʾ���ȴ�ͼƬ�������ٸ���
			iv.setImageBitmap(CouponListActivity.mCouponList.get(index).getImg());
		}
		final Button preBt = (Button)findViewById(R.id.pre_coupon);
		final Button nextBt= (Button)findViewById(R.id.next_coupon);
		final Button curr_total = (Button)findViewById(R.id.curr_total);
		if(index==0){
			preBt.setEnabled(false);
			preBt.setVisibility(View.INVISIBLE);
		}else if(index==CouponListActivity.mCouponList.size()-1){
			nextBt.setEnabled(false);
			nextBt.setVisibility(View.INVISIBLE);
		}
		preBt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(index>0){
					index--;
					showDetail(sid,index);
					if(CouponListActivity.mCouponList.get(index).getBigImg()==null){
						needRefresh.put(index, true);
						iv.setImageBitmap(CouponListActivity.mCouponList.get(index).getImg());
					}
				}
				if(index==0){
					preBt.setEnabled(false);
					preBt.setVisibility(View.INVISIBLE);
				}
				if(nextBt.isEnabled()==false){
					nextBt.setEnabled(true);
					nextBt.setVisibility(View.VISIBLE);
				}
				curr_total.setText((index+1)+"/"+CouponListActivity.mCouponList.size());
			}});
		nextBt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(index<CouponListActivity.mCouponList.size()-1){
					index++;
					showDetail(sid,index);
					if(CouponListActivity.mCouponList.get(index).getBigImg()==null){
						needRefresh.put(index, true);
						iv.setImageBitmap(CouponListActivity.mCouponList.get(index).getImg());
					}	
				}
				if(index==CouponListActivity.mCouponList.size()-1){
					nextBt.setEnabled(false);
					nextBt.setVisibility(View.INVISIBLE);
				}
				if(preBt.isEnabled()==false){
					preBt.setEnabled(true);
					preBt.setVisibility(View.VISIBLE);
				}
				curr_total.setText((index+1)+"/"+CouponListActivity.mCouponList.size());
			}});
	///////////////////////////////////////////////////////////////////////////////
		String[] arr = new String[CouponListActivity.mCouponList.size()];
		for(int i=0;i<arr.length;i++){
			arr[i]="  No."+String.valueOf(i+1);
		}
		final EfficientAdapter adapter = new EfficientAdapter(this,arr,index);
		curr_total.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				adapter.mDisabledIndex=index;
				
				new AlertDialog.Builder(CouponDetailActivity.this)
//                 .setItems(arr, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                    	showDetail(sid,which);
//                    	index=which;
//                    	curr_total.setText((which+1)+"/"+CouponListActivity.mCouponList.size());
//        				
//
//        				nextBt.setEnabled(true);
//        				nextBt.setVisibility(View.VISIBLE);
//        				preBt.setEnabled(true);
//        				preBt.setVisibility(View.VISIBLE);
//
//        				if(index==0){
//        					preBt.setEnabled(false);
//        					preBt.setVisibility(View.INVISIBLE);
//        				}
//        				if(index==CouponListActivity.mCouponList.size()-1){
//        					nextBt.setEnabled(false);
//        					nextBt.setVisibility(View.INVISIBLE);
//        				}
//                    }
//                 })
                 .setAdapter(adapter,new DialogInterface.OnClickListener() {
						public void onClick(
								DialogInterface dialog,
								int which) {

	                    	showDetail(sid,which);
	                    	index=which;
	                    	curr_total.setText((which+1)+"/"+CouponListActivity.mCouponList.size());
	        				

	        				nextBt.setEnabled(true);
	        				nextBt.setVisibility(View.VISIBLE);
	        				preBt.setEnabled(true);
	        				preBt.setVisibility(View.VISIBLE);

	        				if(index==0){
	        					preBt.setEnabled(false);
	        					preBt.setVisibility(View.INVISIBLE);
	        				}
	        				if(index==CouponListActivity.mCouponList.size()-1){
	        					nextBt.setEnabled(false);
	        					nextBt.setVisibility(View.INVISIBLE);
	        				}
	                    
						}})
				. 
                 show();
			}});
		
		
		curr_total.setText((index+1)+"/"+CouponListActivity.mCouponList.size());
		//////////////////////////////////////////////////////////////////////
		
		
		

		//����ͼƬ
        zc = (ZoomControls )findViewById(R.id.zoomControls);
	    class PrivateHandler extends Handler {
	        @Override
	        public void handleMessage(Message msg) {
 
	            switch (msg.what) {
                default:
                    super.handleMessage(msg);
                    break;
	            }
	        }
	    }
	    final Handler mPrivateHandler = new PrivateHandler();
	    mZoomControlRunnable = new Runnable() {
	            public void run() {
	                
	                /* Don't dismiss the controls if the user has
	                 * focus on them. Wait and check again later.
	                 */
	                if (!zc.hasFocus()) {
	                    zc.hide();
	                } else {
	                    mPrivateHandler.removeCallbacks(mZoomControlRunnable);
	                    mPrivateHandler.postDelayed(mZoomControlRunnable,
	                            ZOOM_CONTROLS_TIMEOUT);
	                }
	            }
	        };
        zc.setOnZoomInClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				iv.setImageBitmap(Helper.scaleBitmap(CouponListActivity.mCouponList.get(index).getBigImg(),2.0f));
				Log.d(tag,"ZoomIn");
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable,
                        ZOOM_CONTROLS_TIMEOUT);
			}});
        zc.setOnZoomOutClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				iv.setImageBitmap(Helper.scaleBitmap(CouponListActivity.mCouponList.get(index).getBigImg(),1f));
				Log.d(tag,"ZoomOut");
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable,
                        ZOOM_CONTROLS_TIMEOUT);
			}});
        zc.setVisibility(View.INVISIBLE);
   
		//����
		final GestureDetector gestureDetector = new GestureDetector(new OnGestureListener(){

			public boolean onDown(MotionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("dddddddddddddddddd onDown");
				zc.setVisibility(View.VISIBLE);
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable,
                        ZOOM_CONTROLS_TIMEOUT);
				return false;
			}

			public boolean onFling(MotionEvent arg0, MotionEvent arg1,
					float arg2, float arg3) {
				// TODO Auto-generated method stub
				//System.out.println("dddddddddddddddddd onFling");
				return false;
			}

			public void onLongPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("ddddddddddddddddddx onLongPress");
			}

			public boolean onScroll(MotionEvent arg0, MotionEvent arg1,
					float arg2, float arg3) {
				// TODO Auto-generated method stub
				//System.out.println("dddddddddddddd onScroll");
				return false;
			}

			public void onShowPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("dddddddddddddd onShowPress");
			}

			public boolean onSingleTapUp(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("dddddddddddddd onSingleTapUp");
				return false;
			}}); 
		iv.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				gestureDetector.onTouchEvent(event);

				return false;
			}});
		//iv.setScrollbarFadingEnabled(true);
		//iv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		//iv.setScrollContainer(true);
		//////////////////////
	      Helper.setOnInfoAndHome(this);
	}
	
	public void showDetail(int sid,int index){
		iv.setImageBitmap(CouponListActivity.mCouponList.get(index).getBigImg());
		ivBar.setImageBitmap(CouponListActivity.mCouponList.get(index).getBarImg());
		tv.setText(CouponListActivity.mCouponList.get(index).getCbrief());
        //---------------------------
        String date = CouponListActivity.mCouponList.get(index).getCvdate();
        date =date.substring(date.indexOf(',')+1,date.indexOf('|'));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //mmһ��Ҫ��д!
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
		tv2.setText("Expiry:"+dateStr);
	}
	
	/*
	public void showDetail(int sid,int index){
		BmpAsyncTask afs = new BmpAsyncTask(this);
		BaCoupon bc = CouponListActivity.mCouponList.get(index);
		int cid =bc.getCid();
		//ע�⣬���õ���getcoupondetail2��������getcoupondetail���÷���ֵ�Ḳ��ԭ����type=icon����û��ϵ��ֻ��ͼƬ��С���ѣ����ҵ�����ʱ���ǻ����iconͼƬ����ô�����ԭ���ǽ�ʡ�ڴ档
	
		afs.execute(BrandedConstants.getcoupondetail2, "1",String.valueOf(sid),String.valueOf(cid),"","240","240");

//		try {
//			Bitmap bmp = (Bitmap)afs.get();
//			if(bmp!=null){
//				bc.setImg(bmp);
//			}else{
//				bc.setImg(BitmapFactory.decodeResource(getResources(), R.drawable.coupon_icon));
//			}
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


	}
	//���ﵥ��д����Ϊ��Ҫ��onPostExecute�������������н�����������ֱ�ӵ���.get()��ͬ���ȴ������¼�����������������
	private class BmpAsyncTask extends AsyncTask<String, Void, Bitmap> {
		Context context;
		private String error = null;
		private boolean isFatalError = false;
		private ProgressDialog dialog = null;
		ImageView iv;
		TextView tv ;
		TextView tv2 ;
		
		public BmpAsyncTask(Context ctx) {
			context = ctx;
			iv = (ImageView)findViewById(R.id.coupon_detail_img);
			tv = (TextView)findViewById(R.id.cbrief);
			tv2 = (TextView)findViewById(R.id.expiry);
		}
		@Override
		protected Bitmap doInBackground(String... urls) {
			return RestClient.getCouponDetail(urls[1], urls[2],urls[3], urls[4],urls[5], urls[6]);
		}
		protected void onPostExecute(Bitmap unused) {// ������UI�߳�,
			// //��extends����ķ��ͣ�����������ֵ������ֵ���еķ���ֵҪƥ��
			// returnValue = unused; ����ͨ���������get������ȡ�ý��
		
				dialog.dismiss();
				dialog = null;
		
			if (error != null) {
				Toast.makeText(context, error, Toast.LENGTH_LONG).show();
				if (isFatalError) {
					new AlertDialog.Builder(context)
							.setIcon(android.R.drawable.ic_dialog_alert)
							.setTitle("Fatal Error")
							.setMessage(
									"Network or other fatal error,Please try again later.")
							.setPositiveButton(R.string.BUTTON_OK,
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int whichButton) {
											System.exit(1);
										}
									}).show();

				}

			}else{
				//iv.setImageBitmap(CouponListActivity.mCouponList.get(index).getImg());
				if(unused!=null){
					iv.setImageBitmap(unused);//ֻ��ͼƬ����Ҫ������ȡ��ͼƬ(ԭ��list�е���Сͼ��)�������ֶδ�list������С�
				}else{
					iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coupon_icon));
				}
				
				tv.setText(CouponListActivity.mCouponList.get(index).getCbrief());
				
		        //---------------------------
		        String date = CouponListActivity.mCouponList.get(index).getCvdate();
		        date =date.substring(date.indexOf(',')+1,date.indexOf('|'));
		        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //mmһ��Ҫ��д!
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
				tv2.setText("Expiry:"+dateStr);
		        //------------------------------
			}
		}

		// private Object returnValue = null;
		protected void onPreExecute() {// ִ��Ԥ������������UI�߳�,
				dialog = new ProgressDialog(context);
				dialog.setMessage("get from network, please wait..");
				dialog.show();
		}

	}
	
	*/
	   @Override
	    protected void onResume() {
			IntentFilter filter = new IntentFilter();
			filter.addAction(CouponListActivity.BROADCAST_FOR_COUPONS_DETAIL);
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
				Boolean isNeedRefresh = needRefresh.get(index);
				if(	isNeedRefresh!=null && isNeedRefresh && CouponListActivity.mCouponList.get(index).getBigImg()!=null){
					iv.setImageBitmap(CouponListActivity.mCouponList.get(index).getBigImg());
					needRefresh.put(index, false);
				}
				ivBar.setImageBitmap(CouponListActivity.mCouponList.get(index).getBarImg());

				Log.d("adapter","notifyDataSetChanged");
			}

		};	
		
		
		private static class EfficientAdapter extends BaseAdapter {

	        private LayoutInflater mInflater;
	        String[] mStrArr;
	        int mDisabledIndex;
	        public EfficientAdapter(Context context,String[] strArr,int disabledIndex) {
	            mInflater = LayoutInflater.from(context);
	            mStrArr = strArr;
	            mDisabledIndex = disabledIndex;
	        }


	        public int getCount() {
	            return CouponListActivity.mCouponList.size();
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
	                convertView = mInflater.inflate(R.layout.list_forward, null);
	                holder = new ViewHolder();
	                holder.text_1 = (TextView) convertView.findViewById(R.id.text_1);
	                holder.couponOrFlyerIcon = (ImageView)convertView.findViewById(R.id.couponOrFlyer_icon);
	                convertView.setTag(holder);

	            } else {
	                holder = (ViewHolder) convertView.getTag();
	            }
	            //Odd/Even use different color 
//	            if(position%2==0){
//	            	convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
//	            }
//	            else{
//	            	convertView.setBackgroundColor(Color.parseColor("#EEEEEE"));            	
//	            }
	            
	            
	            holder.text_1.setText(mStrArr[position]);
	            holder.couponOrFlyerIcon.setImageBitmap(CouponListActivity.mCouponList.get(position).getImg());
	            if(position==mDisabledIndex){
	            	//holder.text_1.setEnabled(false);
	            	holder.text_1.setTextColor(Color.GRAY);
	            }else{
	            	//holder.text_1.setEnabled(true);
	            	holder.text_1.setTextColor(Color.BLACK);
	            }
	            parent.setLayoutParams(new  LinearLayout.LayoutParams(150,LayoutParams.WRAP_CONTENT));
	            return convertView;
	        }

	        static class ViewHolder {
	            TextView text_1;
	            ImageView couponOrFlyerIcon;
	        }
	    
		}
}
