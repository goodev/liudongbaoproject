// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileUtil.java

package com.moji.mjweather.util;

import android.content.Context;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import java.io.*;

public class FileUtil {

	private FileUtil() {
	}

	public static boolean copyFile(String s, String s1) {
		return false;

	}

	public static boolean delAllFile(String s) {
		File file = new File(s);
		if (file.exists() && file.isDirectory()) {
			String as[] = file.list();
			int i = 0;
			while (i < as.length) {
				File file1;
				if (s.endsWith(File.separator))
					file1 = new File((new StringBuilder()).append(s)
							.append(as[i]).toString());
				else
					file1 = new File((new StringBuilder()).append(s)
							.append(File.separator).append(as[i]).toString());
				if (file1.isFile())
					file1.delete();
				if (file1.isDirectory()) {
					delAllFile((new StringBuilder()).append(s).append("/")
							.append(as[i]).toString());
					delFolder((new StringBuilder()).append(s).append("/")
							.append(as[i]).toString());
				}
				i++;
			}
		}
		return true;
	}

	public static boolean delFile(String s) {
		(new File(s)).delete();
		boolean flag = true;

		return flag;

	}

	public static void delFolder(String s) {
		delAllFile(s);
		(new File(s)).delete();

	}

	public static void delSysFile(Context context, String s) {
		context.deleteFile(s);
	}

	public static boolean isHaveFile(String s) {
		return (new File(s)).exists();

	}

	public static void newFile(String s, String s1) {
		try {
			File file = new File(s);
			if (!file.exists())

				file.createNewFile();

			if (s1 != null && !s1.equals("")) {
				FileWriter filewriter = new FileWriter(file);
				(new PrintWriter(filewriter)).println(s1);
				filewriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void newFolder(String s) {
		File file = new File(s);
		if (!file.exists())
			file.mkdir();

	}

	public static boolean savePrivateFile(String s, String s1) {
		OutputStreamWriter outputstreamwriter;
		boolean flag;
		outputstreamwriter = null;
		flag = false;
		OutputStreamWriter outputstreamwriter1;
		File file = Gl.Ct().getFileStreamPath(s);
		if (file.exists())
			file.delete();
		try {
			outputstreamwriter1 = new OutputStreamWriter(Gl.Ct()
					.openFileOutput(s, 0), "utf-8");
			outputstreamwriter1.write(s1);
			outputstreamwriter1.flush();
			flag = true;
			if (outputstreamwriter1 != null)
				try {
					outputstreamwriter1.close();
				} catch (IOException ioexception2) {
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	private static final String TAG = "FileUtil";
}
