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
 * @author <a href="mailto:liudongbaollz@foxmail.com">������</a><br>
 * @e-mail: liudongbaollz@foxmail.com <br>
 * @version 1.0 <br>
 * @creatdate 2010-5-20 ����02:13:34 <br>
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

	public void handleMessage(Message msg) { // �¼�������
		Helper.mylog(tag, "handleMessage(Message msg)");
		if (msg.obj != noteCloseDelayed.getMsgObj())
			return;
		removeMessages(noteCloseDelayed.getMsgWhat());
		noteCloseDelayed.close();
	}

	// ������ʾ��Ϣ���ڹر���Ϣ
	public void enableCloseNoteLater() {
		Helper.mylog(tag, "enableCloseNoteLater" + noteCloseDelayed);
		Message msg = obtainMessage(noteCloseDelayed.getMsgWhat());
		msg.obj = noteCloseDelayed.getMsgObj();
		sendMessageDelayed(msg, noteCloseDelayed.getDelayedTime());

	}
}
