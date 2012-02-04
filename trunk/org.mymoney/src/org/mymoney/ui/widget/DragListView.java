package org.mymoney.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class DragListView extends ListView {

	public DragListView(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
		return super.onInterceptTouchEvent(paramMotionEvent);
	}

	public boolean onTouchEvent(MotionEvent paramMotionEvent) {
		return super.onTouchEvent(paramMotionEvent);
	}
}
