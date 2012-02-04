package com.branded.android.util;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">刘冬宝</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-23 上午11:58:11 <br>
 * 
 */
public interface NoteCloseDelayed {
	/**
 *   消息ID初始值
 */
	public int MSG_FIRST_ID = 1;

	/**
	 * 
	 * @return 消息发送延期时间，单位为1/1000秒；
	 */
	public int getDelayedTime();

	/**
	 * 
	 * @return 消息What;
	 */
	public int getMsgWhat();

	public Object getMsgObj();

	/**
	 * 关闭对应的Note;
	 */
	public void close();

	/**
	 * 显示对应的Note;
	 */
	public void show();

}