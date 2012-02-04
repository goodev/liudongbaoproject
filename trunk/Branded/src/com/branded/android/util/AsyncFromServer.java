package com.branded.android.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.branded.android.R;
import com.branded.android.exception.ReturnException;

public class AsyncFromServer extends AsyncTask<String, Void, Object> {// 参数、进度值、结果值,其中的“参数”包含：1=method,2=method's
																		// parm

	Context context;

	private String error = null;
	private boolean isFatalError = false;
	private ProgressDialog dialog = null;// new ProgressDialog(Main.this);
	boolean isShowProgress;
	public AsyncFromServer(Context ctx) {
		context = ctx;
		isShowProgress = true;
	}
	public AsyncFromServer(Context ctx, boolean isShowPro) {
		context = ctx;
		isShowProgress = isShowPro;
	}

	@Override
	protected Object doInBackground(String... urls) {// 非UI//返回值跟extends后面的泛型（参数，进度值，返回值）中的返回值要匹配

		try {
			if (urls[0].equalsIgnoreCase("getappbasic")) {
				return RestClient.getAppBasic(urls[1], urls[2], urls[3]);
			}else if (urls[0].equalsIgnoreCase("getstorecities")) {
				return RestClient.getStoreCities(urls[1]);
			} else if (urls[0].equalsIgnoreCase("getbrandstoresBycity")) {
				return RestClient.getBrandStoresByCity(urls[1], urls[2],
						urls[3], urls[4]);
			} else if (urls[0].equalsIgnoreCase("getbrandstoresByLoc")) {
				return RestClient.getBrandStoresByLoc(urls[1], urls[2],
						urls[3], urls[4]);
			} else if (urls[0].equalsIgnoreCase("getstoredetail")) {
				return RestClient.getStoreDetail(urls[1], urls[2]);
			} else if (urls[0].equalsIgnoreCase("getcouponlist")) {
				return RestClient.getCouponList(urls[1], urls[2]);
			} else if (urls[0].equalsIgnoreCase("getcoupondetail")) {
				return RestClient.getCouponDetail(urls[1], urls[2]);
			} else if (urls[0].equalsIgnoreCase("getcoupondetail2")) {
				return RestClient.getCouponDetail(urls[1], urls[2],urls[3], urls[4],urls[5], urls[6]);
			}else if (urls[0].equalsIgnoreCase("getflyerlist")) {
				return RestClient.getFlyerList(urls[1], urls[2]);
			} else if (urls[0].equalsIgnoreCase("getflyerdetail")) {
				return RestClient.getFlyerDetail(urls[1], urls[2], urls[3]);
			}  else if (urls[0].equalsIgnoreCase("getflyerdetail2")) {
				return RestClient.getFlyerDetail(urls[1], urls[2],urls[3], urls[4],urls[5], urls[6],urls[7]);
			} else if (urls[0].equalsIgnoreCase("getappimage")) {
				return RestClient.getAppImage(urls[1], urls[2], urls[3],
						urls[4]);
			} else if (urls[0].equalsIgnoreCase("getlogo")) {
				return RestClient.getLogo(urls[1], urls[2]);
			} else if (urls[0].equalsIgnoreCase("getmessages")) {
				if (BrandedConstants.msgMap == null
						|| BrandedConstants.msgMap.size() == 0) {
					BrandedConstants.msgMap = RestClient.getMessages("1",
							"en-us", "0");
				}
				return BrandedConstants.msgMap;// RestClient.getMessages(urls[1],urls[2],urls[3]);
			}
		} catch (ClientProtocolException e) {
			error = e.getMessage();
			isFatalError = true;
			//cancel(true);
		} catch (IOException e) {
			error = e.getMessage();
			isFatalError = true;
			//cancel(true);
		} catch (ReturnException e) {
			error = e.getMessage();
			// cancel(true);//已经返回，无需cancel
			Log.d("Async", "server exception,can not get msg.");
		} catch(Exception e){//所有其他异常
			error=e.getMessage();
			isFatalError = true;
		}

		return null;
	}

	protected void onPostExecute(Object unused) {// 运行于UI线程,
													// //跟extends后面的泛型（参数，进度值，返回值）中的返回值要匹配
	// returnValue = unused; 可以通过调用类的get方法，取得结果
		if (isShowProgress) {
			dialog.dismiss();
			dialog = null;
		}
		if (error != null) {
			Toast.makeText(context, error, Toast.LENGTH_LONG).show();
			if(isFatalError){
				new AlertDialog.Builder(context).setIcon(
				android.R.drawable.ic_dialog_alert).setTitle(
				"Fatal Error").setMessage("Network or other fatal error,Please try again later.")
				.setPositiveButton(R.string.BUTTON_OK,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialog,
									int whichButton) {
								System.exit(1);
							}
						})
				.show();
				
			}
			
		}
		// else {
		// Toast.makeText(Main.this, "Source: " , Toast.LENGTH_LONG).show();
		// }
	}

	// private Object returnValue = null;
	protected void onPreExecute() {// 执行预处理，它运行于UI线程,
		if (isShowProgress) {
			dialog = new ProgressDialog(context);
			dialog.setMessage(context.getResources().getText(R.string.while_retrieving_tip));
			dialog.show();
		}
	}

}
