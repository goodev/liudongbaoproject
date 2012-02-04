package com.branded.android.activity;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.branded.android.R;
import com.branded.android.entity.Config;
import com.branded.android.exception.ReturnException;
import com.branded.android.util.AsyncFromServer;
import com.branded.android.util.BrandedConstants;
import com.branded.android.util.Helper;
import com.branded.android.util.RestClient;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">刘冬宝</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-18 下午03:13:44 <br>
 * 
 */
public class AboutActivity extends Activity {
	private static final String tag="AboutActivity";
	TextView dsTV;
	TextView pnTV;
	TextView emTV;
	TextView urlTV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		//下面去掉标题栏
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//下面去掉通知栏
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.setContentView(R.layout.about);
		dsTV = (TextView)findViewById(R.id.ds);
		pnTV = (TextView)findViewById(R.id.pn);
		emTV = (TextView)findViewById(R.id.em);
		urlTV = (TextView)findViewById(R.id.url);
		
		LinearLayout layout = (LinearLayout) this.findViewById(R.id.about_info);
		layout.getBackground().setAlpha(140);
		
		if(BrandedConstants.aboutCfg==null){
			AboutAsyncTask aat = new AboutAsyncTask(this);
			aat.execute("");
		}else{
			dsTV.setText(BrandedConstants.aboutCfg.getDs());
			pnTV.setText("Phone: "+BrandedConstants.aboutCfg.getPhone());
			emTV.setText(BrandedConstants.aboutCfg.getEm());
			urlTV.setText(BrandedConstants.aboutCfg.getUrl());
		}

		emTV.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Helper.sendEmail(AboutActivity.this, BrandedConstants.aboutCfg.getEm(), "");
			}});
		urlTV.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				Helper.gotoWeb(AboutActivity.this, "http://"+BrandedConstants.aboutCfg.getUrl());
			}});
		final ImageButton bt_search = (ImageButton)findViewById(R.id.search);
		bt_search.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				//finish();
				//Helper.doMain(AboutActivity.this);
				Helper.doMain(bt_search.getContext());
			}});
	}
	private class AboutAsyncTask extends AsyncTask<String, Void, Config> {
		Context context;
		private String error = null;
		private boolean isFatalError = false;
		private ProgressDialog dialog = null;

		
		public AboutAsyncTask(Context ctx) {
			context = ctx;
		}
		@Override
		protected Config doInBackground(String... urls) {
			try {
				return RestClient.getAppBasic();
			} catch (ClientProtocolException e) {
				error = e.getMessage();
				isFatalError=true;
				e.printStackTrace();
			} catch (IOException e) {
				error = e.getMessage();
				isFatalError=true;
				e.printStackTrace();
			} catch (ReturnException e) {
				error = e.getMessage();

			} catch (Exception e){
				error = e.getMessage();
				isFatalError=true;
			}
			return null;
		}
		protected void onPostExecute(Config unused) {// 运行于UI线程,
			// //跟extends后面的泛型（参数，进度值，返回值）中的返回值要匹配
			// returnValue = unused; 可以通过调用类的get方法，取得结果
				dialog.dismiss();
				dialog = null;
				BrandedConstants.aboutCfg = unused;
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
 				if(unused!=null){
 					dsTV.setText(BrandedConstants.aboutCfg.getDs());
 					pnTV.setText("Phone: "+BrandedConstants.aboutCfg.getPhone());
 					emTV.setText(BrandedConstants.aboutCfg.getEm());
 					urlTV.setText(BrandedConstants.aboutCfg.getUrl());
  				}else{
  					Log.d(tag, "cat not get about info from server");
 				}			
			}
		}

		// private Object returnValue = null;
		protected void onPreExecute() {// 执行预处理，它运行于UI线程,
				dialog = new ProgressDialog(context);
				dialog.setMessage(getResources().getText(R.string.while_retrieving_tip));
				dialog.show();
		}

	}
}
