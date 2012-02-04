package org.mymoney.ui.widget;

import org.mymoney.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class ColorButton extends Button {
	// private int map;
	private Drawable drawable;

	public ColorButton(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		init();
	}

	private void drawDrawable(int paramInt, Canvas paramCanvas) {
		Drawable localDrawable = this.drawable.mutate();
		int i = 255 - paramInt;
		localDrawable.setAlpha(i);
		this.drawable.draw(paramCanvas);
	}

	private void init() {
		this.drawable = getResources().getDrawable(
				R.drawable.common_btn_pressed);
		// this.a = 0xFFF7B3;
		TextPaint localTextPaint = getPaint();
		int i = getTextColors().getDefaultColor();
		localTextPaint.setColor(i);
	}

	public void onDraw(Canvas paramCanvas) {
		super.onDraw(paramCanvas);
		if (isPressed()) {
			drawDrawable(0, paramCanvas);
			return;
		}
		drawDrawable(255, paramCanvas);
	}

	public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3,
			int paramInt4) {
		setDrawableBounds();
	}

	public boolean onTouchEvent(MotionEvent paramMotionEvent) {

		invalidate();

		return super.onTouchEvent(paramMotionEvent);

	}

	private void setDrawableBounds() {
		int i = this.drawable.getIntrinsicWidth();
		int j = this.drawable.getIntrinsicHeight();
		int k = (getWidth() - i) / 2;
		int m = (getHeight() - j) / 2;
		Drawable localDrawable = this.drawable;
		int n = i + k;
		int i1 = j + m;
		localDrawable.setBounds(k, m, n, i1);
	}
}
