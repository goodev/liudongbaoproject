package com.branded.android.util;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">������</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-23 ����11:58:11 <br>
 * 
 */
public interface NoteCloseDelayed {
	/**
 *   ��ϢID��ʼֵ
 */
	public int MSG_FIRST_ID = 1;

	/**
	 * 
	 * @return ��Ϣ��������ʱ�䣬��λΪ1/1000�룻
	 */
	public int getDelayedTime();

	/**
	 * 
	 * @return ��ϢWhat;
	 */
	public int getMsgWhat();

	public Object getMsgObj();

	/**
	 * �رն�Ӧ��Note;
	 */
	public void close();

	/**
	 * ��ʾ��Ӧ��Note;
	 */
	public void show();

}