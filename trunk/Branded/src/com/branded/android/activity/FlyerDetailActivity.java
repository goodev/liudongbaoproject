package com.branded.android.activity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
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
import android.widget.Toast;
import android.widget.ZoomControls;

import com.branded.android.R;

import com.branded.android.entity.Flyer;

import com.branded.android.util.Helper;
import com.branded.android.util.RestClient;

public class FlyerDetailActivity extends Activity {
	public static final String tag = "FlyerDetailActivity";
	int index;
	int page=1;
	ImageView iv;
	//ImageView ivBar;
	TextView tv ;
	TextView tv2 ;
	ZoomControls  zc;
    private Runnable mZoomControlRunnable;
    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flyer_detail);
		iv = (ImageView)findViewById(R.id.flyer_detail_img);
		tv = (TextView)findViewById(R.id.fbrief);
		tv2 = (TextView)findViewById(R.id.fexpiry);
		
		Intent intent = getIntent();
		index = intent.getIntExtra("flyer_index", 0);
		final int sid =  intent.getIntExtra("sid", 0);
		 
		showDetail(sid,index,page); //ȱʡpage=1
    	
		TextView title = (TextView)findViewById(R.id.title);
    	title.setText(FlyerListActivity.mFlyerList.get(index).getFtitle());
		
    	final Button preBt = (Button)findViewById(R.id.pre_flyer);
		final Button nextBt= (Button)findViewById(R.id.next_flyer);
		final Button curr_total = (Button)findViewById(R.id.curr_total);
		if(page==1){
			preBt.setEnabled(false);
			preBt.setVisibility(View.INVISIBLE);
		}else if(page==FlyerListActivity.mFlyerList.get(index).getPages()){
			nextBt.setEnabled(false);
			nextBt.setVisibility(View.INVISIBLE);
		}
		preBt.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(page>1){
					page--;
					showDetail(sid,index,page);
				}
				if(page==1){
					preBt.setEnabled(false);
					preBt.setVisibility(View.INVISIBLE);
				}
				if(nextBt.isEnabled()==false){
					nextBt.setEnabled(true);
					nextBt.setVisibility(View.VISIBLE);
				}
        		curr_total.setText((page)+"/"+FlyerListActivity.mFlyerList.get(index).getPages());

			}});
		nextBt.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(page<FlyerListActivity.mFlyerList.get(index).getPages()){
					page++;
					showDetail(sid,index,page);
				}
				if(page==FlyerListActivity.mFlyerList.get(index).getPages()){
					nextBt.setEnabled(false);
					nextBt.setVisibility(View.INVISIBLE);
				}
				if(preBt.isEnabled()==false){
					preBt.setEnabled(true);
					preBt.setVisibility(View.VISIBLE);
				}
        		curr_total.setText((page)+"/"+FlyerListActivity.mFlyerList.get(index).getPages());

			}});
		
		final String[] arr = new String[FlyerListActivity.mFlyerList.get(index).getPages()];
		for(int i=0;i<arr.length;i++){
			arr[i]="Page "+String.valueOf(i+1);
		}
		
		final EfficientAdapter adapter = new EfficientAdapter(this,arr,index,page-1);
		
		curr_total.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				adapter.mDisabledIndex=page-1;
 				 new AlertDialog.Builder(FlyerDetailActivity.this)
//                 .setItems(arr, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                    	showDetail(sid,index,which+1);
//                    	page=which+1;
//                		curr_total.setText((page)+"/"+FlyerListActivity.mFlyerList.get(index).getPages());
//        				
//
//        				nextBt.setEnabled(true);
//        				nextBt.setVisibility(View.VISIBLE);
//        				preBt.setEnabled(true);
//        				preBt.setVisibility(View.VISIBLE);
//
//        				if(page==1){
//        					preBt.setEnabled(false);
//        					preBt.setVisibility(View.INVISIBLE);
//        				}
//        				if(page==FlyerListActivity.mFlyerList.get(index).getPages()){
//        					nextBt.setEnabled(false);
//        					nextBt.setVisibility(View.INVISIBLE);
//        				}
//                    }
//                 })

                 .setAdapter(adapter,new DialogInterface.OnClickListener() {
						public void onClick(
								DialogInterface dialog,
								int which) {

	                    	showDetail(sid,index,which+1);
	                    	page=which+1;
	                		curr_total.setText((page)+"/"+FlyerListActivity.mFlyerList.get(index).getPages());
	        				

	        				nextBt.setEnabled(true);
	        				nextBt.setVisibility(View.VISIBLE);
	        				preBt.setEnabled(true);
	        				preBt.setVisibility(View.VISIBLE);

	        				if(page==1){
	        					preBt.setEnabled(false);
	        					preBt.setVisibility(View.INVISIBLE);
	        				}
	        				if(page==FlyerListActivity.mFlyerList.get(index).getPages()){
	        					nextBt.setEnabled(false);
	        					nextBt.setVisibility(View.INVISIBLE);
	        				}
	                    
						}})
                 .show();
			}});
		curr_total.setText((page)+"/"+FlyerListActivity.mFlyerList.get(index).getPages());

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
				iv.setImageBitmap(Helper.scaleBitmap(FlyerListActivity.mFlyerList.get(index).getImgMap().get(page),2.0f));
				Log.d(tag,"ZoomIn");
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable,
                        ZOOM_CONTROLS_TIMEOUT);
			}});
        zc.setOnZoomOutClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				iv.setImageBitmap(Helper.scaleBitmap(FlyerListActivity.mFlyerList.get(index).getImgMap().get(page),1f));
				Log.d(tag,"ZoomOut");
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable,
                        ZOOM_CONTROLS_TIMEOUT);
			}});
        zc.setVisibility(View.INVISIBLE);
   
		//����
		final GestureDetector gestureDetector = new GestureDetector(new OnGestureListener(){

			public boolean onDown(MotionEvent arg0) {
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
//		iv.setScrollbarFadingEnabled(true);
//		iv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//		iv.setScrollContainer(true);
		//////////////////////
	      Helper.setOnInfoAndHome(this);
	}
	public void showDetail(int sid,int index,int page){
		tv.setText(FlyerListActivity.mFlyerList.get(index).getFbrief());
        //---------------------------
        String date = FlyerListActivity.mFlyerList.get(index).getFvdate();
        if(date!=null&& !date.equals("")){
	        date =date.substring(date.indexOf(',')+1 );//2010-05-11,2010-06-11
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

        //------------------------------
        
        if(FlyerListActivity.mFlyerList.get(index).getImgMap().get(page)!=null){
        	iv.setImageBitmap(FlyerListActivity.mFlyerList.get(index).getImgMap().get(page));
        }else{
    		BmpAsyncTask afs = new BmpAsyncTask(this);
    		Flyer flyer = FlyerListActivity.mFlyerList.get(index);
    		int fid =flyer.getFid();
     		afs.execute( "1",String.valueOf(sid),String.valueOf(fid),String.valueOf(page),"","240","240");	
        }
	}
	//���ﵥ��д����Ϊ��Ҫ��onPostExecute�������������н�����������ֱ�ӵ���.get()��ͬ���ȴ������¼�����������������
	private class BmpAsyncTask extends AsyncTask<String, Void, Bitmap> {
		Context context;
		private String error = null;
		private boolean isFatalError = false;
		private ProgressDialog dialog = null;

		
		public BmpAsyncTask(Context ctx) {
			context = ctx;
			iv = (ImageView)findViewById(R.id.flyer_detail_img);
//			tv = (TextView)findViewById(R.id.fbrief);
//			tv2 = (TextView)findViewById(R.id.fexpiry);
		}
		@Override
		protected Bitmap doInBackground(String... urls) {
			try {
				return RestClient.getFlyerDetail(urls[0],urls[1], urls[2],urls[3], urls[4],urls[5], urls[6]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				error = e.getMessage();
				e.printStackTrace();
				return null;
			}
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
				//iv.setImageBitmap(FlyerListActivity.mFlyerList.get(index).getImg());
				if(unused!=null){
					iv.setImageBitmap(unused);//ֻ��ͼƬ����Ҫ������ȡ��ͼƬ(ԭ��list�е���Сͼ��)�������ֶδ�list������С�
					FlyerListActivity.mFlyerList.get(index).getImgMap().put(page,unused);
				}else{
					iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.flyer_icon));
				}			
			}
		}

		// private Object returnValue = null;
		protected void onPreExecute() {// ִ��Ԥ������������UI�߳�,
				dialog = new ProgressDialog(context);
				dialog.setMessage(getResources().getText(R.string.while_retrieving_tip));
				dialog.show();
		}

	}
	private static class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        String[] mStrArr;
        int mDisabledIndex;//�������page������index
        int mIndex;
        public EfficientAdapter(Context context,String[] strArr,int index2,int disabledIndex) {
            mInflater = LayoutInflater.from(context);
            mStrArr = strArr;
            mIndex = index2;
            mDisabledIndex = disabledIndex;
        }


        public int getCount() {
            return FlyerListActivity.mFlyerList.get(mIndex).getPages();
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
//            if(position%2==0){
//            	convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            }
//            else{
//            	convertView.setBackgroundColor(Color.parseColor("#EEEEEE"));            	
//            }
            
            
            holder.text_1.setText(mStrArr[position]);
            //holder.couponOrFlyerIcon.setImageBitmap(FlyerListActivity.mFlyerList.get(mIndex).getImgMap().get(position+1));
            //����ȥ��ͼƬ����Ϊ����һ���ų���һ�������鲻̫�á�
            holder.couponOrFlyerIcon.setLayoutParams(new  LinearLayout.LayoutParams(10,60));//�ͷ�λ�ó���
            if(position==mDisabledIndex){
            	//holder.text_1.setEnabled(false);
            	holder.text_1.setTextColor(Color.GRAY);
            }else{
            	//holder.text_1.setEnabled(true);
            	holder.text_1.setTextColor(Color.BLACK);
            }
            //convertView.setLayoutParams(new  LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 60));
            parent.setLayoutParams(new  LinearLayout.LayoutParams(150,LayoutParams.WRAP_CONTENT));
            return convertView;
        }

        static class ViewHolder {
            TextView text_1;
            ImageView couponOrFlyerIcon;
        }
    }
}
