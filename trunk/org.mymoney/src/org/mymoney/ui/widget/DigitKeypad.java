package org.mymoney.ui.widget;

import org.mymoney.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class DigitKeypad extends LinearLayout {
	public DigitKeypad(Context context, AttributeSet attrs) {
		super(context, attrs);
		((LayoutInflater) context.getSystemService("layout_inflater")).inflate(
				 R.layout.widget_digit_keypad, this, true);
	}

	@Override
	protected void onMeasure(int paramInt1, int paramInt2) {

		int i1 = View.MeasureSpec.getSize(paramInt1);
		int i2 = View.MeasureSpec.getSize(paramInt2);
		super.onMeasure(paramInt1, paramInt2);
	}
}
