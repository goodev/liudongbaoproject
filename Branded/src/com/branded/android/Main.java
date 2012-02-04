package com.branded.android;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.branded.android.activity.StoreListActivity;
import com.branded.android.entity.LocAddr;
import com.branded.android.entity.StoreList;
import com.branded.android.exception.ReturnException;
import com.branded.android.rpc.GpsService;
import com.branded.android.util.AsyncFromServer;
import com.branded.android.util.BrandedConstants;
import com.branded.android.util.Helper;
import com.branded.android.util.RestClient;
import com.branded.android.util.StoreDetailComparator;
 
 
public class Main extends Activity {
    ArrayAdapter<String> adapter;
    AutoCompleteTextView tv;
	static ArrayList<String> inputed =new ArrayList<String>();
	
	private class LocFromAddressOrPostal extends	//内部类实现根据输入的地址/邮编，返回地址、坐标列表信息，供选择。
			AsyncTask<String, Void, List<LocAddr>> {
		private String error = null;
		private ProgressDialog dialog = new ProgressDialog(Main.this);
		private boolean isFatalError = false;
		protected List<LocAddr> doInBackground(String... urls) { // 下次遇到复杂一点的格式，用xml解析方便些。
			ArrayList<LocAddr> retList = new ArrayList<LocAddr>();
			try {
				String para = urls[0];// String url =
										// "http://maps.google.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=false";
				para = para.replaceAll(" ", "+");
				String retStr = RestClient.getString(para);
				// Log.d(tag, "result:"+retStr);
				// parse result
				JSONObject json = new JSONObject(retStr);
				JSONArray nameArray = json.names();
				JSONArray valArray = json.toJSONArray(nameArray);
				for (int i = 0; i < nameArray.length(); i++) {
					String nameStr = nameArray.getString(i);
					// String valueStr =valArray.getString(i);
					if ("status".equalsIgnoreCase(nameStr)) {
						String valueStr = valArray.getString(i);
						if("ZERO_RESULTS".equalsIgnoreCase(valueStr)){
							throw new ReturnException("Address Not Resolved");
						}
						else if (!"OK".equalsIgnoreCase(valueStr)) {
							throw new JSONException("Exception from google:"
									+ valueStr);
						}
					} else if ("results".equalsIgnoreCase(nameStr)) {
						JSONArray valueObj = valArray.getJSONArray(i);

						for (int k = 0; k < valueObj.length(); k++)// 可能有多个result
						{
							JSONObject json2 = valueObj.getJSONObject(k);
							JSONArray nameArray2 = json2.names();
							JSONArray valArray2 = json2.toJSONArray(nameArray2);

							LocAddr locAdrr = new LocAddr();

							for (int m = 0; m < nameArray2.length(); m++) {
								String nameStr2 = nameArray2.getString(m);
								// Object valueStr2 =valArray2.getJSONObject(m);
								// Log.d(nameStr2,
								// "##########################");
								if ("formatted_address"
										.equalsIgnoreCase(nameStr2)) {
									locAdrr.setAddr(valArray2.getString(m));
								} else if ("geometry"
										.equalsIgnoreCase(nameStr2)) {
									JSONObject json3 = valArray2
											.getJSONObject(m);
									JSONArray nameArray3 = json3.names();
									JSONArray valArray3 = json3
											.toJSONArray(nameArray3);
									for (int n = 0; n < nameArray3.length(); n++) {
										String nameStr3 = nameArray3
												.getString(n);
										// Object valueStr2
										// =valArray2.getJSONObject(m);
										if ("location"
												.equalsIgnoreCase(nameStr3)) {
											JSONObject json4 = valArray3
													.getJSONObject(n);
											JSONArray nameArray4 = json4
													.names();
											JSONArray valArray4 = json4
													.toJSONArray(nameArray4);
											for (int j = 0; j < nameArray4
													.length(); j++) {
												String nameStr4 = nameArray4
														.getString(j);
												String valueStr4 = valArray4
														.getString(j);
												if ("lat"
														.equalsIgnoreCase(nameStr4)) {
													locAdrr.setLat(valueStr4);
												} else if ("lng"
														.equalsIgnoreCase(nameStr4)) {
													locAdrr.setLon(valueStr4);
												}
											}
										}
									}
								}
							}

							retList.add(locAdrr);
						}
					}
				}

				// end parse
				return retList;

			} catch (ClientProtocolException e) {
				error = e.getMessage();
				isFatalError=true;
				//cancel(true);
			} catch (IOException e) {
				error = e.getMessage();
				isFatalError=true;
				//cancel(true);
			} catch (ReturnException e) {
				error = e.getMessage();
				// cancel(true);
				Log.d(tag, "server exception,can not get msg.");
			} catch (JSONException e) {
				error = e.getMessage();
				isFatalError=true;
				// cancel(true);
				Log.d(tag, "JSONException:" + error);
			} catch(Exception e){
				error = e.getMessage();
				isFatalError=true;
				Log.d(tag, "othter Exception:" + error);
			}

			return null;// 正常情况下，前面就返回值了。
		}

		protected void onPostExecute(List<LocAddr> unused) {
			dialog.dismiss();
			dialog = null;

			if (error != null) {
				
				if(isFatalError==false){
					new AlertDialog.Builder(Main.this).setIcon(
							android.R.drawable.ic_dialog_alert).setTitle(error)
							.setMessage(BrandedConstants.msgMap.get("mAddrNotResolved"))
							.setPositiveButton(R.string.BUTTON_OK,
									new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog,
												int whichButton) {

										}
									}).show();
				}else{
					//Toast.makeText(Main.this, error, Toast.LENGTH_LONG).show();
					new AlertDialog.Builder(Main.this).setIcon(
							android.R.drawable.ic_dialog_alert).setTitle("error:")
							.setMessage(error)
							.setPositiveButton(R.string.BUTTON_OK,
									new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog,
												int whichButton) {

										}
									}).show();
				}
				
				if(isFatalError==true){
					System.exit(1);
				}
			}
			// else {
			// Toast.makeText(Main.this, "Source: " , Toast.LENGTH_LONG).show();
			// }
		}

		protected void onPreExecute() {
			dialog.setMessage(getResources().getText(R.string.while_retrieving_tip));
			dialog.show();
		}
	}
	private static final String tag = "Main";

	List listM = null;// 用于提示用户选择输入的地址

	/**
	 * 
	 * @param type
	 *            :GPS or ADDR
	 * @param lat
	 * @param lon
	 */
	private void gotoStoreListView(String type, String lat, String lon) {

		// StoreList slist =
		// RestClient.getBrandStores("1",loc.getLatitude(),loc.getLongitude(),BrandedConstants.defaultRadius
		// );
		StoreList slist = null;
		AsyncFromServer afs = new AsyncFromServer(Main.this);

		afs.execute(BrandedConstants.getbrandstoresByLoc, "1", lat, lon, String
				.valueOf(BrandedConstants.defaultRadius));
		// test:la=43.733852&lo=-79.33111&r=40000 FIXME 改为上行，下面写死测试
		// afs.execute(BrandedConstants.getbrandstoresByLoc,"1",String.valueOf(43.733852),String.valueOf(-79.33111),String.valueOf(BrandedConstants.defaultRadius));
		try {
			slist = (StoreList) afs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (slist == null || slist.getCount() == 0) {
			String txtTip = "";
			if (BrandedConstants.TYPE_BY_ADDR.equalsIgnoreCase(type)){
				txtTip = BrandedConstants.msgMap.get("mNoStoreForInput");
			}else{
				txtTip = BrandedConstants.msgMap.get("mNoStoreForGPS");
			}
			new AlertDialog.Builder(Main.this).setIcon(
					android.R.drawable.ic_dialog_alert).setTitle("Store not found")
					.setMessage(txtTip)
					.setPositiveButton(R.string.BUTTON_OK,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {

								}
							}).show();
		} else {
			StoreDetailComparator sdc = new StoreDetailComparator();

			StoreListActivity.mStoreList = slist.getList();
			
			Intent intent = new Intent();
			intent.setClass(Main.this, StoreListActivity.class);
			
			if (BrandedConstants.TYPE_BY_ADDR.equalsIgnoreCase(type)) {
				GpsService.mLatByAddress = new Double(lat);
				GpsService.mLonByAddress = new Double(lon);
				intent.putExtra(BrandedConstants.TYPE_BY_ADDR, true);
				
				sdc.setLatStr(lat);
				sdc.setLonStr(lon);
				Collections.sort(StoreListActivity.mStoreList,sdc);
			}else{
				sdc.setLatStr(String.valueOf(GpsService.mLocation.getLatitude()));
				sdc.setLonStr(String.valueOf(GpsService.mLocation.getLongitude()));
				Collections.sort(StoreListActivity.mStoreList,sdc);
			}
			startActivity(intent);
		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		// 启动gps监听
		Intent service = new Intent("com.branded.intent.action.IGpsService");
		startService(service);

		// 初始化全局变量：提示信息;
		//new AsyncFromServer(this).execute(BrandedConstants.getmessages);
		AsyncFromServer afs = new AsyncFromServer(this);
		afs.execute(BrandedConstants.getmessages);

		Button bt1 = (Button) findViewById(R.id.mainButton1);
		Button bt2 = (Button) findViewById(R.id.mainButton2);
		final ImageButton bt_info = (ImageButton)findViewById(R.id.info);
		bt1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// if(Helper.isGPSEnabled(Main.this)){

				Location loc = Helper.getCurrentLocation2();
				//如果得不到，下面试图再取一下//////////////////////////////////////////////////////
				if(loc==null){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					loc = Helper.getCurrentLocation2();
					if(loc==null){
						LocationManager mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
						Criteria criteria = new Criteria();
						criteria.setAccuracy(Criteria.ACCURACY_FINE);
						criteria.setAltitudeRequired(false);
						criteria.setBearingRequired(false);
						criteria.setCostAllowed(true);
						criteria.setSpeedRequired(false);
						criteria.setPowerRequirement(Criteria.POWER_LOW);
						String provider = mLocationManager.getBestProvider(criteria, true);
						loc = mLocationManager.getLastKnownLocation(provider);
						if(loc!=null){
							GpsService.mLocation=loc;
						}	
					}
				}
				//end 试图///////////////////////////////////////////////////////////////////////////

				if (loc != null) {
					gotoStoreListView(BrandedConstants.TYPE_BY_GPS, String
							.valueOf(loc.getLatitude()), String.valueOf(loc
							.getLongitude()));
					GpsService.isByAddr=false;
				} else {
					new AlertDialog.Builder(Main.this).setIcon(
							android.R.drawable.ic_dialog_alert).setTitle(
							"Gps is not available").setMessage(
							(String) BrandedConstants.msgMap
									.get("mGPSNotAvailable"))
							.setPositiveButton(R.string.BUTTON_OK,
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int whichButton) {

										}
									})
							// .setNegativeButton(R.string.login_as_other_user_no,
							// new DialogInterface.OnClickListener() {
							// public void onClick(DialogInterface dialog, int
							// whichButton) {
							//
							// trackingTB.setChecked(false);
							// }
							// })
							.show();
				}

			}
		});
		bt2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				LayoutInflater factory = LayoutInflater.from(Main.this);
				final View textEntryView = factory.inflate(R.layout.find_store,null);
		        adapter = new ArrayAdapter<String>(Main.this,android.R.layout.simple_dropdown_item_1line, inputed);	
				tv = (AutoCompleteTextView) textEntryView.findViewById(R.id.find_edit);
				tv.setAdapter(adapter);
				new AlertDialog.Builder(Main.this).setIcon(
						R.drawable.search).setTitle(
						R.string.find_store_title).setView(textEntryView)
						.setPositiveButton(R.string.BUTTON_OK,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										//TextView tv = (TextView) textEntryView.findViewById(R.id.find_edit);
										String inputAddr= tv.getText()+"";
										if(!inputed.contains(inputAddr)){
											inputed.add(inputAddr);
										}
										Log.d(tag, ""+tv.getText());
										if(inputAddr.indexOf('\n')>-1){
											Toast.makeText(Main.this, "Can not include ENTER.", Toast.LENGTH_LONG).show();
											return;
										}
										String url = "http://maps.google.com/maps/api/geocode/json?address="
												+ tv.getText()
												+ ",canada&sensor=false";
										LocFromAddressOrPostal locFrom = new LocFromAddressOrPostal();
										locFrom.execute(url);

										try {
											final List<LocAddr> list = locFrom.get(7, TimeUnit.SECONDS);// 超过7秒可中断报错
											//final List<LocAddr> list = locFrom.get();
											// ///////////////////////
											if (list == null|| list.size() == 0) {// 提示无结果
//异步中已提示了，这里略去。												
//												Log.d(tag, "no record");
//												String msg = BrandedConstants.msgMap.get("mAddrNotResolved");
//												if (msg == null) {
//													msg = getResources().getString(R.string.mAddrNotResolved);
//												}
//												Toast.makeText(Main.this, msg,Toast.LENGTH_LONG).show();
											} else if (list.size() > 5) {// 提示输入更明确些
												Log.d(tag,
														"more than 5 records");
												String msg = BrandedConstants.msgMap
														.get("mMultiAddrFound");
												if (msg == null) {
													msg = getResources()
															.getString(
																	R.string.mMultiAddrFound);
												}
												Toast.makeText(Main.this, msg,
														Toast.LENGTH_LONG)
														.show();
											} else if (list.size() == 1) {// 一个直接定位
												Log.d(tag, list.get(0).getLat()
														+ ","
														+ list.get(0).getLon());

												gotoStoreListView(
														BrandedConstants.TYPE_BY_ADDR,
														list.get(0).getLat(),
														list.get(0).getLon());
												GpsService.isByAddr=true;

											} else { // 大于1小于等于5,让用户选择
												Log.d(tag, "need select.");
												String arrAddr[] = new String[list
														.size()];
												String arrLat[] = new String[list
														.size()];
												String arrLon[] = new String[list
														.size()];

												listM = new ArrayList<Map>();

												for (int i = 0; i < list.size(); i++) {
													Log.d(list.get(i).getAddr(),list.get(i).getLat()+ list.get(i).getLon());
													arrAddr[i] = list.get(i)
															.getAddr();
													arrLat[i] = list.get(i)
															.getLat();
													arrLon[i] = list.get(i)
															.getLon();

													HashMap hm = new HashMap();
													hm.put("_addr_",arrAddr[i]);
													listM.add(hm);
												}
												// ///////////////////////
												// final int selected;
												new AlertDialog.Builder(
														Main.this)
														.setIcon(
																android.R.drawable.ic_dialog_alert)
														.setTitle("select one")

														// .setItems(arrAddr,
														// new
														// DialogInterface.OnClickListener()
														// {//用这行字体太大，否则用这行代替setAdapter最简单
														// public void
														// onClick(DialogInterface
														// dialog, int
														// whichButton) {
														// Log.d("whichButton",whichButton+"");
														//									                    	
														// }
														// })
														// 下面用系统定义的，只有几种特定大小，但不需要定义xml文件
														// .setAdapter(new
														// SimpleAdapter(Main.this,
														// listM,//ListM是一个存map的list，key是下面的_addr_,value将显示在text1所指的组件上，注意，可以自定义xml，也可以用系统缺省的simple_list_item_1和缺省的组件android.R.id.text1。
														// android.R.layout.simple_list_item_1,
														// new String[] {
														// "_addr_" },
														// //android.R.layout.simple_gallery_item,
														// new String[] {
														// "title" },
														// new int[] {
														// android.R.id.text1
														// }),new
														// DialogInterface.OnClickListener()
														// {
														// public void
														// onClick(DialogInterface
														// dialog, int
														// whichButton) {
														// Log.d("whichButton",whichButton+"");
														//									                    	
														// }
														// })
														// 下面用自定义的xml，完全控制字体大小，但需要定义xml
														.setAdapter(
																new SimpleAdapter(
																		Main.this,
																		listM,// ListM是一个存map的list，key是下面的_addr_,value将显示在text1所指的组件上，注意，可以自定义xml，也可以用系统缺省的simple_list_item_1和缺省的组件android.R.id.text1。
																		R.layout.addr_select_item,
																		new String[] { "_addr_" },
																		// android.R.layout.simple_gallery_item,
																		// new
																		// String[]
																		// {
																		// "title"
																		// },
																		new int[] { R.id.addrForSelect }),
																new DialogInterface.OnClickListener() {
																	public void onClick(
																			DialogInterface dialog,
																			int whichButton) {
																		Log
																				.d(
																						"whichButton",
																						whichButton
																								+ "");

																		gotoStoreListView(
																				BrandedConstants.TYPE_BY_ADDR,
																				list
																						.get(
																								whichButton)
																						.getLat(),
																				list
																						.get(
																								whichButton)
																						.getLon());
																		GpsService.isByAddr=true;
																	}
																})

														// .setPositiveButton(R.string.BUTTON_OK,
														// new
														// DialogInterface.OnClickListener()
														// {
														// public void
														// onClick(DialogInterface
														// dialog, int
														// whichButton) {
														// }
														// })
														//								                  
														// .setNegativeButton(R.string.BUTTON_CANCEL,
														// new
														// DialogInterface.OnClickListener()
														// {
														// public void
														// onClick(DialogInterface
														// dialog, int
														// whichButton) {
														// }
														// })

														.show();

												// ////////////////////////
											}
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (ExecutionException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (Exception e) { // 超时提示
											// FIXME:
											e.printStackTrace();
										}
										//

										//
									}
								}).setNegativeButton(R.string.BUTTON_CANCEL,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
									}
								}).show();

			}
		});

		
		bt_info.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Helper.doAbout(bt_info.getContext());
			}});
	
		//第一次显示一个提示
		SharedPreferences settings = getSharedPreferences(BrandedConstants.PREFS_NAME, 0);
		boolean isFirstRun = settings.getBoolean("isFirstRun", true);
		if(isFirstRun){
			SharedPreferences.Editor editor = settings.edit();
			editor.putBoolean("isFirstRun",false);
			editor.commit();
			new AlertDialog.Builder(Main.this)
					//.setIcon(android.R.drawable.ic_dialog_alert)
					.setMessage(R.string.first_show)
					.setPositiveButton("Close", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int whichButton) {
			            	
			            }
					}).show();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent service = new Intent("com.branded.intent.action.IGpsService");
			stopService(service);
			Log.d(tag,"gps service stoped.");
		}
		return super.onKeyDown(keyCode, event);
		
//		  ActivityManager activityManager = (ActivityManager)getSystemService(Activity.ACTIVITY_SERVICE); 
//		  activityManager.restartPackage("com.branded.android");
		 
	}
	@Override
	protected void onResume() {
		// 这里主要是因为可以通过startActivity（而不是返回键）跳转到about，而跳转回到main会自动关闭gps服务，如果来回多跳几次，再用返回键返回，那么可能从main到main时，gps已经关闭，
		// 这里代码是保证main退出前，gps是启动的。
		if(!Helper.isServiceRunning(this, "com.branded.android.rpc.GpsService")){
			Intent service = new Intent("com.branded.intent.action.IGpsService");
			startService(service);
			Log.d(tag,"startService in onResume");
		}
		super.onResume();
	}
}