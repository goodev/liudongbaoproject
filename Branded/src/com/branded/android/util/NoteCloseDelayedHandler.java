/**
 * 
 */
package com.branded.android.util;

import android.os.Handler;
import android.os.Message;

/**
 * 
 * 
 * Description: <br>
 * 
 * @author <a href="mailto:liudongbaollz@foxmail.com">刘冬宝</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-20 下午02:13:34 <br>
 * 
 */
public class NoteCloseDelayedHandler extends Handler {
	private static final String tag = "NoteCloseDelayedHandler";

	private NoteCloseDelayed noteCloseDelayed = null;

	/**
	 * @param storeNote
	 * 
	 */
	public NoteCloseDelayedHandler(NoteCloseDelayed storeNote) {
		this.noteCloseDelayed = storeNote;
	}

	public void handleMessage(Message msg) { // 事件处理函数
		Helper.mylog(tag, "handleMessage(Message msg)");
		if (msg.obj != noteCloseDelayed.getMsgObj())
			return;
		removeMessages(noteCloseDelayed.getMsgWhat());
		noteCloseDelayed.close();
	}

	// 设置提示信息窗口关闭信息
	public void enableCloseNoteLater() {
		Helper.mylog(tag, "enableCloseNoteLater" + noteCloseDelayed);
		Message msg = obtainMessage(noteCloseDelayed.getMsgWhat());
		msg.obj = noteCloseDelayed.getMsgObj();
		sendMessageDelayed(msg, noteCloseDelayed.getDelayedTime());

	}
}
