/**
 * 
 */
package com.branded.android.util;

import android.os.Handler;
import android.os.Message;

import com.branded.android.view.StoreNote;

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
public class StoreNoteHandler extends Handler {
	private static final String tag = "StoreNoteHandler";

	public static final int MSG_STORENOTE_CLOSE = 1;
	public static final int STORENOTE_TIMEOUT = 5000; // 定义提示信息显示时间为5秒

	public static final Object OBJ_STORESTORE_CLOSE = new Object();
	private StoreNote storeNote = null;

	/**
	 * @param storeNote
	 * 
	 */
	public StoreNoteHandler(StoreNote storeNote) {
		this.storeNote = storeNote;
	}

	public void handleMessage(Message msg) { // 事件处理函数
		Helper.mylog(tag, "handleMessage(Message msg)");
		if (msg.obj != OBJ_STORESTORE_CLOSE)
			return;
		switch (msg.what) {
		case MSG_STORENOTE_CLOSE: // 选择事件ID
			this.removeMessages(MSG_STORENOTE_CLOSE);
			storeNote.close();
			break;
		}
	}

	// 设置提示信息窗口关闭信息
	public void enableCloseNoteLater() {
		Helper.mylog(tag, "sendNoteViewCloseMsg:noteView" + storeNote);
		Message msg = obtainMessage(MSG_STORENOTE_CLOSE);
		msg.obj = OBJ_STORESTORE_CLOSE;
		sendMessageDelayed(msg, STORENOTE_TIMEOUT);

	}
}
