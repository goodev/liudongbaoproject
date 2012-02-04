package org.achartengine.chart;

import java.text.NumberFormat;
import java.util.Timer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class AnimationPieChartForMymoney extends View {
	public static float a;
	private static String ac;
	private static int k = 360;
	private static final int[] o;
	private static String S;
	static {
		int[] arrayOfInt = new int[11];
		int i1 = Color.rgb(255, 0, 68);
		arrayOfInt[0] = i1;
		int i2 = Color.rgb(5, 173, 207);
		arrayOfInt[1] = i2;
		int i3 = Color.rgb(4, 227, 66);
		arrayOfInt[2] = i3;
		int i4 = Color.rgb(255, 145, 0);
		arrayOfInt[3] = i4;
		int i5 = Color.rgb(193, 18, 213);
		arrayOfInt[4] = i5;
		int i6 = Color.rgb(255, 0, 0);
		arrayOfInt[5] = i6;
		int i7 = Color.rgb(74, 91, 255);
		arrayOfInt[6] = i7;
		int i8 = Color.rgb(186, 255, 38);
		arrayOfInt[7] = i8;
		int i9 = Color.rgb(239, 197, 0);
		arrayOfInt[8] = i9;
		int i10 = Color.rgb(120, 120, 120);
		arrayOfInt[9] = i10;
		arrayOfInt[10] = -16776961;
		o = arrayOfInt;
		S = "";
		ac = "";
		a = 0.0008F;
	}
	private float[] A;
	private Paint aa;
	private Paint ab;
	private float aC;
	private String ad;
	private long aD;
	private String ae;
	private long aE;
	private String af;
	private float aF;
	private int ag;
	private float ah;
	private float aH;
	private float ai;
	private float aI;
	private float aj;
	private float ak;

	private float al;
	private float am;
	private float an;
	private float ao;
	private float ap;

	private float aq;
	private float ar;
	private float as;
	private float at;

	private float au;
	private Rect av;
	private float aw;
	private long[] ax;
	private float[] ay;
	private int az;
	Canvas b;
	private float[] B;
	private Context c;
	private float[] C;
	private String d;
	private long D;
	private int E;
	private boolean f;
	private long F;
	private Timer g;
	private float[] G;
	private int h;
	private float[] H;
	private int i;
	private float I;
	private float J;
	private long K;
	private long L;
	private float M;
	private AccelerateDecelerateInterpolator n;
	private long N;
	private float O;
	private NumberFormat p;
	private double q;

	private int Q;
	private Paint r;
	private boolean R;
	private int s;
	private float t;
	private int T;
	private float u;
	private float v;
	private String V;
	private Drawable W;
	private RectF x;
	private Drawable X;
	private float y;
	private Paint Y;
	private float[] z;

	private Paint Z;

	public AnimationPieChartForMymoney(Context paramContext) {
		this(paramContext, null);
	}

	public AnimationPieChartForMymoney(Context paramContext,
			AttributeSet paramAttributeSet) {
		this(paramContext, paramAttributeSet, 0);
	}

	public AnimationPieChartForMymoney(Context paramContext,
			AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	private void e() {
		this.Q = 0;
		this.q = 0.0D;
		this.I = 0.0F;
	}

	protected void onAttachedToWindow() {
		super.onAttachedToWindow();

	}

	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();

	}

	protected void onDraw(Canvas paramCanvas) {
		super.onDraw(paramCanvas);
	}

	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		return super.onKeyDown(paramInt, paramKeyEvent);

	}

	public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
		return super.onKeyUp(paramInt, paramKeyEvent);
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}

	public boolean onTouchEvent(MotionEvent paramMotionEvent) {
		return super.onTouchEvent(paramMotionEvent);
	}
}
