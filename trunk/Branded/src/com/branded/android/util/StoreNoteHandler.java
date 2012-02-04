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
 * @author <a href="mailto:liudongbaollz@foxmail.com">������</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-20 ����02:13:34 <br>
 * 
 */
public class StoreNoteHandler extends Handler {
	private static final String tag = "StoreNoteHandler";

	public static final int MSG_STORENOTE_CLOSE = 1;
	public static final int STORENOTE_TIMEOUT = 5000; // ������ʾ��Ϣ��ʾʱ��Ϊ5��

	public static final Object OBJ_STORESTORE_CLOSE = new Object();
	private StoreNote storeNote = null;

	/**
	 * @param storeNote
	 * 
	 */
	public StoreNoteHandler(StoreNote storeNote) {
		this.storeNote = storeNote;
	}

	public void handleMessage(Message msg) { // �¼�������
		Helper.mylog(tag, "handleMessage(Message msg)");
		if (msg.obj != OBJ_STORESTORE_CLOSE)
			return;
		switch (msg.what) {
		case MSG_STORENOTE_CLOSE: // ѡ���¼�ID
			this.removeMessages(MSG_STORENOTE_CLOSE);
			storeNote.close();
			break;
		}
	}

	// ������ʾ��Ϣ���ڹر���Ϣ
	public void enableCloseNoteLater() {
		Helper.mylog(tag, "sendNoteViewCloseMsg:noteView" + storeNote);
		Message msg = obtainMessage(MSG_STORENOTE_CLOSE);
		msg.obj = OBJ_STORESTORE_CLOSE;
		sendMessageDelayed(msg, STORENOTE_TIMEOUT);

	}
}
