// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SkinUtil.java

package com.moji.mjweather.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Environment;

import com.moji.mjweather.widgetskin.SkinDrawIconInfo;

// Referenced classes of package com.moji.mjweather.util:
//            FileUtil, HttpUtil

public class SkinUtil {
	public static class SkinSwitcher extends Thread {

		public static void switchSkinAsync(Context context, String s,
				AyncWorkListener ayncworklistener) {
			(new SkinSwitcher(context, s, ayncworklistener)).start();
		}

		public void run() {

		}

		private Context mContext;
		private AyncWorkListener mListener;
		private String mSkinDir;

		private SkinSwitcher() {
		}

		private SkinSwitcher(Context context, String s,
				AyncWorkListener ayncworklistener) {
			mContext = context;
			mSkinDir = s;
			mListener = ayncworklistener;
		}
	}

	public static interface AyncWorkListener {

		public abstract void onFinished(boolean flag);

		public abstract void onStarted();
	}

	public static interface DownloadProgressListener {

		public abstract void onProgressChanged(int i);

		public abstract void onProgressStarted(int i);
	}

	public SkinUtil() {
	}

	public static void createDirs() {
		FileUtil.newFolder(sMojiDir);
		FileUtil.newFolder((new StringBuilder()).append(sSdcardDir)
				.append("/moji/temp").toString());
		FileUtil.newFolder(sImgNotDeleteCacheDir);
		FileUtil.newFolder(sImgCacheDir);
		FileUtil.newFile(
				(new StringBuilder()).append(getMojiDir()).append(".nomedia")
						.toString(), null);
	}

	public static Bitmap createDrawBuffer(int i,
			com.moji.mjweather.widgetskin.SkinInfo.SkinType skintype, float f) {
		return null;
	}

	public static boolean createFastLoadSkinNumber(Context context, String s) {
		return false;
	}

	public static void deleteFastSkinNumberFiles(Context context, String s) {

	}

	public static boolean download(Context context, String s, String s1,
			String s2) {
		return download(context, s, s1, s2, null);
	}

	public static boolean download(Context context, String s, String s1,
			String s2, DownloadProgressListener downloadprogresslistener) {
		return false;
	}

	public static boolean download(Context context, String s, String s1,
			String s2, String s3, String s4) {
		boolean flag;
		if (s3 != null && !s3.equals("")) {
			flag = download(context, s, s1, (new StringBuilder()).append(s3)
					.append(s4).toString());
			if (flag)
				flag = FileUtil.copyFile((new StringBuilder()).append(s3)
						.append(s4).toString(), (new StringBuilder())
						.append(s2).append(s4).toString());
		} else {
			flag = download(context, s, s1, (new StringBuilder()).append(s2)
					.append(s4).toString());
		}
		return flag;
	}

	public static void drawBitmapToLayer(Context context, Bitmap bitmap,
			SkinDrawIconInfo skindrawiconinfo, Canvas canvas,
			PaintFlagsDrawFilter paintflagsdrawfilter,
			PaintFlagsDrawFilter paintflagsdrawfilter1, Paint paint) {
		if (bitmap.getWidth() == skindrawiconinfo.mWidth
				&& bitmap.getHeight() == skindrawiconinfo.mHeight) {
			canvas.drawBitmap(bitmap, skindrawiconinfo.mX, skindrawiconinfo.mY,
					paint);
		} else {
			Matrix matrix = new Matrix();
			matrix.postScale(
					(float) skindrawiconinfo.mWidth / (float) bitmap.getWidth(),
					(float) skindrawiconinfo.mHeight
							/ (float) bitmap.getHeight());
			matrix.postTranslate(skindrawiconinfo.mX, skindrawiconinfo.mY);
			canvas.setDrawFilter(paintflagsdrawfilter);
			canvas.drawBitmap(bitmap, matrix, paint);
			canvas.setDrawFilter(paintflagsdrawfilter1);
		}
	}

	public static void emptyImageCache() {
		FileUtil.delAllFile(getImgCacheDir());
	}

	public static boolean existsInternalSkin(Context context) {
		File file = new File(getInternalSkinDir(context));
		boolean flag;
		if (file.exists() && file.list() != null)
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static boolean existsSkin(Context context, String s) {
		return existsSkin(context, s, getSkinDirList(context));
	}

	public static boolean existsSkin(Context context, String s, List list) {
		return list.contains((new StringBuilder()).append("skin").append(s)
				.toString());
	}

	public static int getAMPMResID(boolean flag) {
		int i;
		if (!flag)
			i = 0x7f02018c;
		else
			i = 0x7f02018e;
		return i;
	}

	public static Bitmap getAMPMSkinBitmap(Context context, boolean flag,
			String s) {
		Bitmap bitmap;
		if (!flag)
			bitmap = BitmapFactory.decodeFile((new StringBuilder())
					.append(getMojiDir()).append(s).append("/w_amw.png")
					.toString());
		else
			bitmap = BitmapFactory.decodeFile((new StringBuilder())
					.append(getMojiDir()).append(s).append("/w_pmw.png")
					.toString());
		return bitmap;
	}

	public static Bitmap getBmpByResId(Context context, int i) {
		return BitmapFactory.decodeStream(context.getResources()
				.openRawResource(i));
	}

	public static Bitmap getColonSkinBitmap(Context context, boolean flag,
			String s) {

		Bitmap bitmap = getBmpByResId(context, 0x7f020047);
		return bitmap;

	}

	public static String getImgCacheDir() {
		return sImgCacheDir;
	}

	public static String getImgNotDeleteCacheDir() {
		return sImgNotDeleteCacheDir;
	}

	public static String getInternalSkinDir(Context context) {
		if (sInternalSkinDir == null || sInternalSkinDir.equals(""))
			sInternalSkinDir = (new StringBuilder())
					.append(context.getFilesDir()).append("/").append("skin")
					.append("/").toString();
		return sInternalSkinDir;
	}

	public static String getLifeImgCacheDir() {
		return sLifeImgCacheDir;
	}

	public static String getMojiDir() {
		return sMojiDir;
	}

	public static int getNumBitmapResID(int i) {
		int j;
		if (i >= 0 && i <= 9)
			j = NUM_BMP_RES_IDS[i];
		else
			j = 0;
		return j;
	}

	public static String getSdCardDir() {
		return sSdcardDir.toString();
	}

	public static Bitmap getSkinBmpByName(Context context, String s, String s1) {
		Bitmap bitmap = BitmapFactory.decodeFile((new StringBuilder())
				.append(getMojiDir()).append(s).append("/").append(s1)
				.toString());
		if (bitmap == null)
			bitmap = getBmpByResId(context, 0x7f0200f2);
		return bitmap;
	}

	public static List getSkinDirList(Context context) {
		ArrayList arraylist = new ArrayList();
		arraylist.add("ORG");
		getSkinDirList(((List) (arraylist)), getMojiDir(), "skin");
		return arraylist;
	}

	private static void getSkinDirList(List list, String s, String s1) {
		String as[];
		int i;
		int j;
		as = (new File(s)).list();
		if (as == null)
			return;
		i = as.length;
		j = 0;

		if (j >= i)
			return;
		String s2 = as[j];
		if (s2.startsWith(s1)
				&& (new File((new StringBuilder()).append(s).append(s2)
						.toString())).isDirectory() && s2.startsWith(s1)
				&& s2.length() > s1.length())
			list.add(s2);
		j++;

	}

	public static Bitmap getTimeNumberSkinBitmap(Context context, boolean flag,
			String s, int i) {

		Bitmap bitmap = getBmpByResId(context, getNumBitmapResID(i));

		return bitmap;

	}

	public static void saveBitmapToPrivateDir(Context context, String s,
			Bitmap bitmap) {

	}

	private static final int DRAW_BUFFER_HEIGHT_1[];
	private static final int DRAW_BUFFER_HEIGHT_1_old[];
	private static final int DRAW_BUFFER_HEIGHT_2[];
	private static final int DRAW_BUFFER_HEIGHT_2_old[];
	private static final int DRAW_BUFFER_WIDTH_4[];
	private static final int DRAW_BUFFER_WIDTH_4_old[];
	private static final int NUMBER_OF_SKIN_PIC = 10;
	private static final com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType NUMBER_TYPES[];
	private static final int NUM_BMP_RES_IDS[];
	private static final String TAG = "SkinUtil";
	private static String sImgCacheDir;
	private static String sImgNotDeleteCacheDir;
	private static String sInternalSkinDir;
	private static String sLifeImgCacheDir;
	private static String sMojiDir;
	private static String sSdcardDir;

	static {
		int ai[] = new int[10];
		ai[0] = 0x7f0200f6;
		ai[1] = 0x7f0200f7;
		ai[2] = 0x7f0200f8;
		ai[3] = 0x7f0200f9;
		ai[4] = 0x7f0200fa;
		ai[5] = 0x7f0200fb;
		ai[6] = 0x7f0200fc;
		ai[7] = 0x7f0200fd;
		ai[8] = 0x7f0200fe;
		ai[9] = 0x7f0200ff;
		NUM_BMP_RES_IDS = ai;
		int ai1[] = new int[13];
		ai1[0] = 240;
		ai1[1] = 320;
		ai1[2] = 480;
		ai1[3] = 480;
		ai1[4] = 0;
		ai1[5] = 240;
		ai1[6] = 0;
		ai1[7] = 640;
		ai1[8] = 540;
		ai1[9] = 800;
		ai1[10] = 720;
		ai1[11] = 720;
		ai1[12] = 600;
		DRAW_BUFFER_WIDTH_4_old = ai1;
		int ai2[] = new int[13];
		ai2[0] = 130;
		ai2[1] = 198;
		ai2[2] = 324;
		ai2[3] = 342;
		ai2[4] = 0;
		ai2[5] = 160;
		ai2[6] = 0;
		ai2[7] = 400;
		ai2[8] = 337;
		ai2[9] = 420;
		ai2[10] = 400;
		ai2[11] = 400;
		ai2[12] = 320;
		DRAW_BUFFER_HEIGHT_2_old = ai2;
		int ai3[] = new int[13];
		ai3[0] = 73;
		ai3[1] = 100;
		ai3[2] = 150;
		ai3[3] = 150;
		ai3[4] = 0;
		ai3[5] = 75;
		ai3[6] = 0;
		ai3[7] = 200;
		ai3[8] = 169;
		ai3[9] = 230;
		ai3[10] = 230;
		ai3[11] = 230;
		ai3[12] = 150;
		DRAW_BUFFER_HEIGHT_1_old = ai3;
		int ai4[] = new int[13];
		ai4[0] = 240;
		ai4[1] = 320;
		ai4[2] = 480;
		ai4[3] = 480;
		ai4[4] = 0;
		ai4[5] = 240;
		ai4[6] = 0;
		ai4[7] = 640;
		ai4[8] = 540;
		ai4[9] = 800;
		ai4[10] = 720;
		ai4[11] = 720;
		ai4[12] = 600;
		DRAW_BUFFER_WIDTH_4 = ai4;
		int ai5[] = new int[13];
		ai5[0] = 125;
		ai5[1] = 194;
		ai5[2] = 321;
		ai5[3] = 342;
		ai5[4] = 0;
		ai5[5] = 160;
		ai5[6] = 0;
		ai5[7] = 350;
		ai5[8] = 337;
		ai5[9] = 420;
		ai5[10] = 400;
		ai5[11] = 400;
		ai5[12] = 320;
		DRAW_BUFFER_HEIGHT_2 = ai5;
		int ai6[] = new int[13];
		ai6[0] = 60;
		ai6[1] = 98;
		ai6[2] = 150;
		ai6[3] = 150;
		ai6[4] = 0;
		ai6[5] = 75;
		ai6[6] = 0;
		ai6[7] = 170;
		ai6[8] = 150;
		ai6[9] = 230;
		ai6[10] = 230;
		ai6[11] = 230;
		ai6[12] = 150;
		DRAW_BUFFER_HEIGHT_1 = ai6;
		com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType abitmapcontenttype[] = new com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType[4];
		abitmapcontenttype[0] = com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_TIME_HOUR_TENS;
		abitmapcontenttype[1] = com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_TIME_HOUR_UNITS;
		abitmapcontenttype[2] = com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_TIME_MINUTE_TENS;
		abitmapcontenttype[3] = com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_TIME_MINUTE_UNITS;
		NUMBER_TYPES = abitmapcontenttype;
		sSdcardDir = Environment.getExternalStorageDirectory().toString();
		sImgCacheDir = (new StringBuilder()).append(sSdcardDir)
				.append("/moji/imgCache/").toString();
		sImgNotDeleteCacheDir = (new StringBuilder()).append(sSdcardDir)
				.append("/moji/imgNotDeleteCache/").toString();
		sMojiDir = (new StringBuilder()).append(sSdcardDir).append("/moji/")
				.toString();
		sLifeImgCacheDir = (new StringBuilder()).append(sSdcardDir)
				.append("/moji/imgLifeCache/").toString();
	}
}
