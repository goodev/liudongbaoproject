package com.branded.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.branded.android.entity.BaCoupon;
import com.branded.android.entity.BaCouponInfo;
import com.branded.android.entity.City;
import com.branded.android.entity.Config;
import com.branded.android.entity.Flyer;
import com.branded.android.entity.FlyerList;
import com.branded.android.entity.StoreDetail;
import com.branded.android.entity.StoreList;
import com.branded.android.exception.ReturnException;

public class RestClient {
	private static final String ex_input_error = "Input error";
	private static final String ex_no_data = "No data";
	private static final String ex_no_permission = "No permission";
	private static final String ex_unknown_error = "Unknown Error";

	public static Config getAppBasic() throws ClientProtocolException,
			IOException, ReturnException {
		return getAppBasic("1", "3", "1.0.0");// android is 3
	}

	/**
	 * get basic and configuration of the app, include name, latest version,
	 * stores and/or list of images used for skin.
	 * 
	 * @param bi
	 *            brandid, id of the branded app
	 * @param ptype
	 *            phone type
	 * @param ver
	 *            current version
	 * @param fmt
	 *            return format, xml/json
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 *             example:
	 *             http://ads.cellflare.com/Cfsrv/restservice/brand/getappbasic
	 *             ?bi=1&ptype=0&ver=1.0.0&fmt=json
	 */
	public static Config getAppBasic(String bi, String ptype, String ver)
			throws ClientProtocolException, IOException, ReturnException {
		String url = "http://ads.cellflare.com/Cfsrv/restservice/brand/getappbasic?";
		url += "bi=" + bi + "&ptype=" + ptype + "&ver=" + ver + "&fmt=json";
		String retStr = getString(url);
		Config cfg = null;
		try {
			JSONObject json = new JSONObject(retStr);
			Log.i("RestClient", "<jsonobject>\n" + json.toString()
					+ "\n</jsonobject>");

			// A Simple JSONObject Parsing
			JSONArray nameArray = json.names();
			JSONArray valArray = json.toJSONArray(nameArray);
			cfg = new Config();
			for (int i = 0; i < nameArray.length(); i++) {
				// Log.i("RestClient","<jsonname"+i+">\n"+nameArray.getString(i)+"\n</jsonname"+i+">\n"
				// +"<jsonvalue"+i+">\n"+valArray.getString(i)+"\n</jsonvalue"+i+">");
				String nameStr = nameArray.getString(i);
				String valueStr = valArray.getString(i);
				if ("cn".equalsIgnoreCase(nameStr)) {
					cfg.setCn(valueStr);
				} else if ("bn".equalsIgnoreCase(nameStr)) {
					cfg.setBn(valueStr);
				} else if ("scount".equalsIgnoreCase(nameStr)) {
					cfg.setScount(Integer.valueOf(valueStr).intValue());
				} else if ("tid".equalsIgnoreCase(nameStr)) {
					cfg.setTid(Integer.valueOf(valueStr).intValue());
				} else if ("lver".equalsIgnoreCase(nameStr)) {
					cfg.setLver(valueStr);
				} else if ("phone".equalsIgnoreCase(nameStr)) {
					cfg.setPhone(valueStr);
				} else if ("ft".equalsIgnoreCase(nameStr)) {
					cfg.setFt(Integer.valueOf(valueStr).intValue());
				} else if ("img".equalsIgnoreCase(nameStr)) {
					cfg.setImg(valueStr);
				} else if ("img_name".equalsIgnoreCase(nameStr)) {
					cfg.setImg_name(valueStr);
				} else if ("img_ver".equalsIgnoreCase(nameStr)) {
					cfg.setImg_ver(Integer.valueOf(valueStr).intValue());
				}

				else if ("ds".equalsIgnoreCase(nameStr)) {
					cfg.setDs(valueStr);
				} else if ("em".equalsIgnoreCase(nameStr)) {
					cfg.setEm(valueStr);
				} else if ("url".equalsIgnoreCase(nameStr)) {
					cfg.setUrl(valueStr);
				} else if ("hrs".equalsIgnoreCase(nameStr)) {
					cfg.setHrs(valueStr);
				}
			}

			// A Simple JSONObject Value Pushing
			// json.put("sample key", "sample value");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cfg;
	}

	/**
	 * For app download the newest image for app's skin
	 * 
	 * @param tid
	 *            Theme ID, id of the theme the branded app currently use
	 * @param name
	 *            Name of the image, such as 'background'
	 * @param ver
	 *            Version of the image
	 * @param size
	 *            Width x Height. resversed, ignored
	 * @return 
	 *         Example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getappimage
	 *         ?tid=1&name=background&ver=0
	 */
	public static Bitmap getAppImage(String tid, String name, String ver,
			String size) {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getappimage?";
		url += "tid=" + tid + "&name=" + name + "&ver=" + ver + "&size=" + size;
		Bitmap ret = returnBitMap(url);
		return ret;
	}

	public static StoreList getBrandStores(String url)
			throws ClientProtocolException, IOException, ReturnException {
		String retStr = getString(url);
		StoreList storeList = null;
		try {
			JSONObject json = new JSONObject(retStr);
			Log.i("RestClient", "<jsonobject>" + json.toString()
					+ "</jsonobject>");

			// A Simple JSONObject Parsing
			JSONArray nameArray = json.names();
			JSONArray valArray = json.toJSONArray(nameArray);
			storeList = new StoreList();
			List<StoreDetail> list = new ArrayList<StoreDetail>();
			for (int i = 0; i < nameArray.length(); i++) {
				String nameStr = nameArray.getString(i);
				// String valueStr =valArray.getString(i);
				if ("count".equalsIgnoreCase(nameStr)) {
					storeList.setCount(Integer.valueOf(valArray.getString(i)));
				} else if ("list".equalsIgnoreCase(nameStr)) {
					JSONArray arrChild = valArray.getJSONArray(i);
					for (int k = 0; k < arrChild.length(); k++) {
						JSONObject json2 = arrChild.getJSONObject(k);
						JSONArray nameArray2 = json2.names();
						JSONArray valArray2 = json2.toJSONArray(nameArray2);
						StoreDetail sd = new StoreDetail();
						for (int m = 0; m < nameArray2.length(); m++) {
							String nameStr2 = nameArray2.getString(m);
							String valueStr2 = valArray2.getString(m);
							if ("sid".equalsIgnoreCase(nameStr2)) {
								sd.setSid(Integer.valueOf(valueStr2));
							} else if ("sn".equalsIgnoreCase(nameStr2)) {
								sd.setSn(valueStr2);
							} else if ("url".equalsIgnoreCase(nameStr2)) {
								sd.setUrl(valueStr2);
							} else if ("ctry".equalsIgnoreCase(nameStr2)) {
								sd.setCtry(valueStr2);
							} else if ("prov".equalsIgnoreCase(nameStr2)) {
								sd.setProv(valueStr2);
							} else if ("city".equalsIgnoreCase(nameStr2)) {
								sd.setCity(valueStr2);
							} else if ("addr".equalsIgnoreCase(nameStr2)) {
								sd.setAddr(valueStr2);
							} else if ("pn".equalsIgnoreCase(nameStr2)) {
								sd.setPn(valueStr2);
							} else if ("lat".equalsIgnoreCase(nameStr2)) {
								sd.setLat(Double.valueOf(valueStr2));
							} else if ("lon".equalsIgnoreCase(nameStr2)) {
								sd.setLon(Double.valueOf(valueStr2));
							} else if ("hrs".equalsIgnoreCase(nameStr2)) {
								sd.setHrs(valueStr2);
							} else if ("cc".equalsIgnoreCase(nameStr2)) {
								sd.setCc(Integer.valueOf(valueStr2));
							} else if ("fc".equalsIgnoreCase(nameStr2)) {
								sd.setFc(Integer.valueOf(valueStr2));
							} else if ("ps".equalsIgnoreCase(nameStr2)) {
								sd.setPs(valueStr2);
							} else if ("em".equalsIgnoreCase(nameStr2)) {
								sd.setEm(valueStr2);
							} else if ("ds".equalsIgnoreCase(nameStr2)) {
								sd.setDs(valueStr2);
							}
						}
						list.add(sd);
					}
					storeList.setList(list);
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return storeList;
	}

	/**
	 * get/search store by user's criteria (latitude/longitude or city) if use
	 * city/prov/country, use the return data from getstorecities as parameters
	 * if lat/lon/r specified, city/prov/country will be ignored
	 * 
	 * @param bi
	 *            brandid, id of the branded app
	 * @param city
	 *            City name, use + to replace ' ', and delete "'"
	 * @param prov
	 *            Province code, such as ON, BC, CA
	 * @param ctry
	 *            Code of country
	 * @param la
	 *            Latitude, best keep 6 decimals
	 * @param lo
	 *            Longitude, , best keep 6 decimals
	 * @param r
	 *            Radius from users location , int, unit meter, default 50000
	 *            (50 km)
	 * @param fmt
	 *            return format, xml/json
	 * @return 
	 *         example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getbrandstores
	 *         ?bi=1&la=43.733852&lo=-79.33111&r=40000&fmt=xml
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static StoreList getBrandStoresByCity(String bi, String city,
			String prov, String ctry) throws ClientProtocolException,
			IOException, ReturnException {
		if (city != null) {
			city = city.replaceAll(" ", "+").replaceAll("'", "");
		}

		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getbrandstores?";
		url += "bi=" + bi + "&city=" + city + "&prov=" + prov + "&ctry=" + ctry
				+ "&fmt=json";

		return getBrandStores(url);
	}

	public static StoreList getBrandStoresByLoc(String bi, String la,
			String lo, String r) throws ClientProtocolException, IOException,
			ReturnException {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getbrandstores?";
		url += "bi=" + bi + "&la=" + la + "&lo=" + lo + "&r=" + r + "&fmt=json";
		return getBrandStores(url);
	}

	public static Bitmap getCouponDetail(String sid, String cid) {
		return getCouponDetail("1", sid, cid, "icon", "60", "60");
	}

	/**
	 * get the detail or coupon page or coupon image for a coupon
	 * 
	 * @param bi
	 *            brandid, id of the branded app
	 * @param sid
	 *            Storeid
	 * @param cid
	 *            Couponid
	 * @param fmt
	 *            return format, xml/json/page/img
	 * @param type
	 *            Only use for fmt=image, if set to icon, return small image
	 * @param w
	 *            Only use for fmt=image, Width of the image
	 * @param h
	 *            Only use for fmt=image, Height of the image
	 * @return 
	 *         Example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getcoupondetail
	 *         ?bi=1&sid=1&cid=137&type=icon&w=40&h=40&fmt=image
	 */
	public static Bitmap getCouponDetail(String bi, String sid, String cid,
			String type, String w, String h) {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getcoupondetail?";
		url += "bi=" + bi + "&sid=" + sid + "&cid=" + cid + "&type=" + type
				+ "&w=" + w + "&h=" + h + "&fmt=image";
		Bitmap ret = returnBitMap(url);
		return ret;
	}
	/**
	 * 
	 *@param code: the barcode
	 *@param txt: indicate if need add text info under the barcode, 0 - no need, 1 - yes
	 *@param ch: the character for begining/end
	 * @return
	 */
	public static Bitmap getCodeBarImg(String code,String txt,String ch) {
		if(code==null||code.equals("")){
			return null;
		}
		String url = "http://ads.cellflare.com/cfsrv/RESTService/images/barcode?";
		url += "code="+code+"&txt="+txt+"&ch="+ch;
		Bitmap ret = returnBitMap(url);
		return ret;
	}
	/**
	 * get all coupon list for a store
	 * 
	 * @param bi
	 * @param sid
	 * @param fmt
	 * @return example:
	 *         http://ads.cellflare.com/Cfsrv/RESTService/brand/getcouponlist
	 *         ?bi=1&sid=1&fmt=xml
	 * @throws ReturnException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static BaCouponInfo getCouponList(String bi, String sid)
			throws ClientProtocolException, IOException, ReturnException {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getcouponlist?";
		url += "bi=" + bi + "&sid=" + sid + "&fmt=json";
		String retStr = getString(url);
		BaCouponInfo bci = new BaCouponInfo();
		try {
			JSONObject json = new JSONObject(retStr);
			Log.i("RestClient", "<jsonobject>" + json.toString()
					+ "</jsonobject>");

			JSONArray nameArray = json.names();
			JSONArray valArray = json.toJSONArray(nameArray);
			List<BaCoupon> list = new ArrayList<BaCoupon>();
			for (int i = 0; i < nameArray.length(); i++) {
				String nameStr = nameArray.getString(i);
				// String valueStr =valArray.getString(i);
				if ("count".equalsIgnoreCase(nameStr)) {
					bci.setCount(Integer.valueOf(valArray.getString(i)));
				} else if ("list".equalsIgnoreCase(nameStr)) {
					JSONArray arrChild = valArray.getJSONArray(i);
					for (int k = 0; k < arrChild.length(); k++) {
						JSONObject json2 = arrChild.getJSONObject(k);
						JSONArray nameArray2 = json2.names();
						JSONArray valArray2 = json2.toJSONArray(nameArray2);
						BaCoupon bc = new BaCoupon();
						for (int m = 0; m < nameArray2.length(); m++) {
							String nameStr2 = nameArray2.getString(m);
							String valueStr2 = valArray2.getString(m);
							if ("cid".equalsIgnoreCase(nameStr2)) {
								bc.setCid(Integer.valueOf(valueStr2));
							} else if ("ctitle".equalsIgnoreCase(nameStr2)) {
								bc.setCtitle(valueStr2);
							} else if ("ccode".equalsIgnoreCase(nameStr2)) {
								bc.setCcode(valueStr2);
							} else if ("cvdate".equalsIgnoreCase(nameStr2)) {
								bc.setCvdate(valueStr2);
							} else if ("cvtime".equalsIgnoreCase(nameStr2)) {
								bc.setCvtime(valueStr2);
							} else if ("ctype".equalsIgnoreCase(nameStr2)) {
								bc.setCtype(Integer.valueOf(valueStr2));
							}else if ("cbrief".equalsIgnoreCase(nameStr2)) {
								bc.setCbrief(valueStr2);
							}
						}
						list.add(bc);
					}
					bci.setList(list);
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return bci;
	}

	public static Bitmap getFlyerDetail(String sid, String fid, String pg) {
		return getFlyerDetail("1", sid, fid, pg, "icon", "60", "60");
	}

	/**
	 * get one flyer/menu page (mostly image) details for a flyer
	 * 
	 * @param bi
	 *            brandid, id of the branded app
	 * @param sid
	 *            Store Id
	 * @param fid
	 *            Flyer Id
	 * @param pg
	 *            Number of page
	 * @param fmt
	 *            return format, xml/json/page/image
	 * @param type
	 *            Only use for fmt=image, if set to icon, return small image, if
	 *            the flyer type isn't image, return null
	 * @param w
	 *            Only use for fmt=image, Width of the image
	 * @param h
	 *            Only use for fmt=image, Height of the image
	 * @return 
	 *         Example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getflyerdetail
	 *         ?bi=1&sid=1&fid=137&pg=1&type=icon&h=50&w=50&fmt=image
	 */
	public static Bitmap getFlyerDetail(String bi, String sid, String fid,
			String pg, String type, String w, String h) {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getflyerdetail?";
		url += "bi=" + bi + "&sid=" + sid + "&fid=" + fid +"&pg="+pg+ "&type=" + type
				+ "&w=" + w + "&h=" + h + "&fmt=image";
		Bitmap ret = returnBitMap(url);
		return ret;
	}

	/**
	 * get the list of flyer/menu list for a store
	 * 
	 * @param bi
	 * @param sid
	 * @param fmt
	 * @return 
	 *         Example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getflyerlist
	 *         ?bi=1&sid=1&fmt=xml
	 * @throws ReturnException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static FlyerList getFlyerList(String bi, String sid)
			throws ClientProtocolException, IOException, ReturnException {

		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getflyerlist?";
		url += "bi=" + bi + "&sid=" + sid + "&fmt=json";
		String retStr = getString(url);
		FlyerList fi = new FlyerList();
		try {
			JSONObject json = new JSONObject(retStr);
			Log.i("RestClient", "<jsonobject>" + json.toString()
					+ "</jsonobject>");

			JSONArray nameArray = json.names();
			JSONArray valArray = json.toJSONArray(nameArray);
			List<Flyer> list = new ArrayList<Flyer>();
			for (int i = 0; i < nameArray.length(); i++) {
				String nameStr = nameArray.getString(i);
				// String valueStr =valArray.getString(i);
				if ("count".equalsIgnoreCase(nameStr)) {
					fi.setCount(Integer.valueOf(valArray.getString(i)));
				} else if ("list".equalsIgnoreCase(nameStr)) {
					JSONArray arrChild = valArray.getJSONArray(i);
					for (int k = 0; k < arrChild.length(); k++) {
						JSONObject json2 = arrChild.getJSONObject(k);
						JSONArray nameArray2 = json2.names();
						JSONArray valArray2 = json2.toJSONArray(nameArray2);
						Flyer flyer = new Flyer();
						for (int m = 0; m < nameArray2.length(); m++) {
							String nameStr2 = nameArray2.getString(m);
							String valueStr2 = valArray2.getString(m);
							if ("fid".equalsIgnoreCase(nameStr2)) {
								flyer.setFid(Integer.valueOf(valueStr2));
							} else if ("ftitle".equalsIgnoreCase(nameStr2)) {
								flyer.setFtitle(valueStr2);
							} else if ("fvdate".equalsIgnoreCase(nameStr2)) {
								flyer.setFvdate(valueStr2);
							} else if ("ptype".equalsIgnoreCase(nameStr2)) {
								flyer.setPtype(Integer.valueOf(valueStr2));
							} else if ("rtype".equalsIgnoreCase(nameStr2)) {
								flyer.setRtype(Integer.valueOf(valueStr2));
							} else if ("pages".equalsIgnoreCase(nameStr2)) {
								flyer.setPages(Integer.valueOf(valueStr2));
							}
						}
						flyer.setImgMap(new HashMap<Integer, Bitmap>());//保证map非空，以便后面省略判断
						list.add(flyer);
					}
					fi.setList(list);
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return fi;
	}

	public static Bitmap getLogo(String w, String h) {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getlogo?";
		url += "bi=1" + "&type=icon" + w + "&h=" + h;
		Bitmap ret = returnBitMap(url);
		return ret;
	}

	/**
	 * Get the app's logo if needed
	 * 
	 * @param bi
	 * @param type
	 * @param w
	 * @param h
	 * @return 
	 *         Example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getlogo?bi
	 *         =1&w=40&h=40&type=icon
	 */
	public static Bitmap getLogo(String bi, String type, String w, String h) {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getlogo?";
		url += "bi=" + bi + "&type=" + type + w + "&h=" + h;
		Bitmap ret = returnBitMap(url);
		return ret;
	}

	/**
	 * Get the messages from server for keep the display message up to date
	 * 
	 * @param bi
	 *            brandid, id of the branded app
	 * @param lan
	 *            Language, use en-us,fr-ca, etc. default or not found use
	 *            English
	 * @param ptype
	 *            phone type
	 * @param fmt
	 *            return format, xml/json
	 * @return 
	 *         Example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getmessages
	 *         ?bi=1&lan=en-us&ptype=0
	 * @throws ReturnException
	 * @throws IOException
	 * @throws ClientProtocolException
	 *             mGPSNotAvailable :We are sorry, but your location could not
	 *             obtained at this time. Please try searching by postal
	 *             code/location. mGPSNoPermission :You have not accepted the
	 *             terms of use for the Google Location Service, or the Google
	 *             Service is off. mGPSServiceOff :No Location source available.
	 *             Both Google and GPS are off. mAddrNotResolved :No locations
	 *             found for the postal code/address that you entered. mNoStore
	 *             :Sorry, there are no locations close to the postal
	 *             code/address that you entered. mNoCoupon :There are currently
	 *             no coupons available. mNoFlyer :There are currently no flyers
	 *             available mAbout :About.
	 */
	public static Map getMessages(String bi, String lan, String ptype)
			throws ClientProtocolException, IOException, ReturnException {
		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getmessages?";
		url += "bi=" + bi + "&lan=" + lan + "&ptype=" + ptype + "&fmt=json";
		String retStr = getString(url);
		Map<String, String> map = new HashMap<String, String>();
		try {
			JSONArray jarr = new JSONArray(retStr);
			if (jarr != null) {
				for (int i = 0; i < jarr.length(); i++) {
					JSONObject json = jarr.getJSONObject(i);
					JSONArray nameArray = json.names();
					JSONArray valArray = json.toJSONArray(nameArray);
					String key = null, value = null;
					for (int k = 0; k < nameArray.length(); k++) {
						String nameStr = nameArray.getString(k);
						String valueStr = valArray.getString(k);
						if ("mkey".equalsIgnoreCase(nameStr)) {
							key = valueStr;
						} else {
							value = valueStr;
						}
					}
					if (key != null) {
						map.put(key, value);
					}
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

	public static List<City> getStoreCities() throws ClientProtocolException,
			IOException, ReturnException {
		return getStoreCities("1");
	}

	/**
	 * get cities list of store, when need search by cities, call it get the
	 * cities as list items for selection (for domino's pizza, so far no search
	 * by cities, no need to use it)
	 * 
	 * @param bi
	 * @param fmt
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 *             example:http://ads.cellflare.com/Cfsrv/restservice/brand/getstorecities
	 *             ?bi=1&fmt=xml
	 */
	public static List<City> getStoreCities(String bi)
			throws ClientProtocolException, IOException, ReturnException {

		String url = "http://ads.cellflare.com/Cfsrv/restservice/brand/getstorecities?";
		url += "bi=" + bi + "&fmt=json";
		String retStr = getString(url);
		ArrayList<City> list = new ArrayList<City>();
		try {
			JSONArray jarr = new JSONArray(retStr);
			if (jarr != null) {
				for (int i = 0; i < jarr.length(); i++) {
					JSONObject json = jarr.getJSONObject(i);
					JSONArray nameArray = json.names();
					JSONArray valArray = json.toJSONArray(nameArray);
					City city = new City();
					for (int k = 0; k < nameArray.length(); k++) {
						String nameStr = nameArray.getString(k);
						String valueStr = valArray.getString(k);
						// Log.i("RestClient",nameArray.getString(k)+":"+valArray.getString(k)+"\n");
						if ("city".equalsIgnoreCase(nameStr)) {
							city.setCity(valueStr);
						} else if ("prov".equalsIgnoreCase(nameStr)) {
							city.setProv(valueStr);
						} else if ("ctry".equalsIgnoreCase(nameStr)) {
							city.setCtry(valueStr);
						}
					}
					list.add(city);
				}

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * get details of a store it is not necessary to call this service, all
	 * information include in store list
	 * 
	 * @param bi
	 * @param sid
	 * @param fmt
	 * @return 
	 *         example:http://ads.cellflare.com/Cfsrv/RESTService/brand/getstoredetail
	 *         ?bi=1&sid=1&fmt=xml
	 * @throws ReturnException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static StoreDetail getStoreDetail(String bi, String sid)
			throws ClientProtocolException, IOException, ReturnException {

		String url = "http://ads.cellflare.com/Cfsrv/RESTService/brand/getstoredetail?";
		url += "bi=" + bi + "&sid=" + sid + "&fmt=json";
		String retStr = getString(url);
		StoreDetail sd = null;
		try {
			JSONObject json = new JSONObject(retStr);
			Log.i("RestClient", "<jsonobject>\n" + json.toString()
					+ "\n</jsonobject>");
			JSONArray nameArray = json.names();
			JSONArray valArray = json.toJSONArray(nameArray);
			sd = new StoreDetail();
			for (int i = 0; i < nameArray.length(); i++) {
				// Log.i("RestClient","<jsonname"+i+">\n"+nameArray.getString(i)+"\n</jsonname"+i+">\n"
				// +"<jsonvalue"+i+">\n"+valArray.getString(i)+"\n</jsonvalue"+i+">");
				String nameStr = nameArray.getString(i);
				String valueStr = valArray.getString(i);
				if ("sid".equalsIgnoreCase(nameStr)) {
					sd.setSid(Integer.valueOf(valueStr));
				} else if ("sn".equalsIgnoreCase(nameStr)) {
					sd.setSn(valueStr);
				} else if ("url".equalsIgnoreCase(nameStr)) {
					sd.setUrl(valueStr);
				} else if ("ctry".equalsIgnoreCase(nameStr)) {
					sd.setCtry(valueStr);
				} else if ("prov".equalsIgnoreCase(nameStr)) {
					sd.setProv(valueStr);
				} else if ("city".equalsIgnoreCase(nameStr)) {
					sd.setCity(valueStr);
				} else if ("addr".equalsIgnoreCase(nameStr)) {
					sd.setAddr(valueStr);
				} else if ("pn".equalsIgnoreCase(nameStr)) {
					sd.setPn(valueStr);
				} else if ("lat".equalsIgnoreCase(nameStr)) {
					sd.setLat(Double.valueOf(valueStr));
				} else if ("lon".equalsIgnoreCase(nameStr)) {
					sd.setLon(Double.valueOf(valueStr));
				} else if ("hrs".equalsIgnoreCase(nameStr)) {
					sd.setHrs(valueStr);
				} else if ("cc".equalsIgnoreCase(nameStr)) {
					sd.setCc(Integer.valueOf(valueStr));
				} else if ("fc".equalsIgnoreCase(nameStr)) {
					sd.setFc(Integer.valueOf(valueStr));
				} else if ("ps".equalsIgnoreCase(nameStr)) {
					sd.setPs(valueStr);
				} else if ("em".equalsIgnoreCase(nameStr)) {
					sd.setEm(valueStr);
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sd;

	}

	// /////////////////////////
	public static String getString(String url) throws ClientProtocolException,
			IOException, ReturnException {
		String result = null;
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response;
		InputStream instream = null;
		try {
			response = httpclient.execute(httpget);
			// Examine the response status
			Log.i("RestClient", response.getStatusLine().toString());

			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				// A Simple JSON Response Read
				instream = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(instream));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				result = sb.toString();
			}
		} finally {
			if (instream != null) {
				instream.close();
			}
		}
		if (ex_input_error.equalsIgnoreCase(result)) {
			throw new ReturnException(ex_input_error);
		} else if (ex_no_data.equalsIgnoreCase(result)) {
			throw new ReturnException(ex_no_data);
		} else if (ex_no_permission.equalsIgnoreCase(result)) {
			throw new ReturnException(ex_no_permission);
		} else if (ex_unknown_error.equalsIgnoreCase(result)) {
			throw new ReturnException(ex_unknown_error);
		}

		return result;
	}

	public static Bitmap returnBitMap(String url) {
		URL myFileUrl = null;
		Bitmap bitmap = null;
		InputStream is = null;
		HttpURLConnection conn = null;
		try {
			myFileUrl = new URL(url);
			conn = (HttpURLConnection) myFileUrl.openConnection();
			conn.setDoInput(true);
			conn.connect();
			is = conn.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);
			is.close();
		} catch (Exception e) {
			Log.e("ContactsActivity", "returnBitMap error1:" + e.getMessage());
		} finally {
			try {
				is.close();
				conn.disconnect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.e("ContactsActivity", "returnBitMap error2:"
						+ e.getMessage());
			}
		}
		return bitmap;
	}
}