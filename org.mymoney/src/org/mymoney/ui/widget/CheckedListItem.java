package org.mymoney.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import org.mymoney.R;

public class CheckedListItem extends RelativeLayout implements Checkable {
	private static final int[] checkDrawableStates = { android.R.attr.state_checked };
	private boolean isChecked;
	private Drawable checkDrawable;
	private int m_right;
	private int intrinsic_width;

	public CheckedListItem(Context paramContext) {
		this(paramContext, null);
	}

	public CheckedListItem(Context paramContext, AttributeSet paramAttributeSet) {
		this(paramContext, paramAttributeSet, 0);
	}

	public CheckedListItem(Context paramContext,
			AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
		Drawable checkDrawable = paramContext.getResources().getDrawable(
				R.drawable.widget_btn_radio);
		if (checkDrawable != null)
			setCheckDrawable(checkDrawable);
	}

	private void drawDragDrawable(Canvas paramCanvas) {
		Drawable dragDrawable = getResources()
				.getDrawable(R.drawable.icon_drag);
		if (dragDrawable == null)
			return;
		int intrinsicHeight = dragDrawable.getIntrinsicHeight();
		int top = (getHeight() - intrinsicHeight) / 2;
		int right = getWidth();
		int left = right - dragDrawable.getIntrinsicWidth();
		int bottom = intrinsicHeight + top;
		dragDrawable.setBounds(left, top, right, bottom);
		dragDrawable.draw(paramCanvas);
	}

	public void setCheckDrawable(Drawable pCheckDrawable) {
		if (pCheckDrawable != null) {
			if (this.checkDrawable != null) {
				this.checkDrawable.setCallback(null);
				unscheduleDrawable(checkDrawable);
			}
			pCheckDrawable.setCallback(this);
			if (getVisibility() == VISIBLE) {
				pCheckDrawable.setVisible(true, false);
				pCheckDrawable.setState(checkDrawableStates);
				intrinsic_width = pCheckDrawable.getIntrinsicWidth();
				int[] states = getDrawableState();
				pCheckDrawable.setState(states);
			}
		}
		this.checkDrawable = pCheckDrawable;
		requestLayout();

	}

	public void setCheck(boolean isChecked) {
		this.isChecked = isChecked;
		invalidate();
	}

	protected void drawableStateChanged() {
		super.drawableStateChanged();
		if (this.checkDrawable == null)
			return;
		int[] states = getDrawableState();
		checkDrawable.setState(states);
		invalidate();
	}

	public boolean isChecked() {
		return this.isChecked;
	}

	protected int[] onCreateDrawableState(int extraSpace) {
		int i = extraSpace + 1;
		int[] states = super.onCreateDrawableState(i);
		if (isChecked()) {
			mergeDrawableStates(states, checkDrawableStates);
		}
		return states;
	}

	protected void onDraw(Canvas paramCanvas) {
		super.onDraw(paramCanvas);

		drawDragDrawable(paramCanvas);

		if (!this.isChecked)
			return;
		drawCheckDrawable(paramCanvas);
	}

	private void drawCheckDrawable(Canvas paramCanvas) {
		Drawable localDrawable = this.checkDrawable;
		if (localDrawable != null) {
			int intrinsicHeight = localDrawable.getIntrinsicHeight();
			int width = getWidth();
			int left = width - this.intrinsic_width - m_right;
			int top = (getHeight() - intrinsicHeight) / 2;
			int right = width - m_right;
			int bottom = intrinsicHeight + top;
			localDrawable.setBounds(left, top, right, bottom);
			localDrawable.draw(paramCanvas);
		}
	}

	public void setChecked(boolean isChecked) {
		if (this.isChecked == isChecked)
			return;
		this.isChecked = isChecked;
		refreshDrawableState();
	}

	public void setPadding(int left, int top, int right, int bottom) {
		super.setPadding(left, top, right, bottom);
		this.m_right = right;
	}

	public void toggle() {
		setChecked(!this.isChecked);

	}
}
