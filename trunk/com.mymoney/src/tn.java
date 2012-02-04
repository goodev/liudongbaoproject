import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.mymoney.ui.widget.Panel;

public class tn
  implements Runnable
{
  public tn(Panel paramPanel)
  {
  }

  public void run()
  {
    tq localtq1 = Panel.a(this.a);
    tq localtq2 = tq.e;
    int i;
    int j;
    label62: int k;
    int n;
    label129: label226: label249: int i3;
    label316: int i4;
    int i5;
    int i7;
    int i8;
    int i9;
    if (localtq1 == localtq2)
    {
      Panel localPanel1 = this.a;
      if ((Panel.e(this.a) == 0) || (Panel.e(this.a) == 2))
      {
        i = 1;
        if (Panel.j(this.a) <= 0.0F)
          break label425;
        j = 1;
        boolean bool1 = i ^ j;
        boolean bool2 = Panel.a(localPanel1, bool1);
      }
    }
    else
    {
      if (Panel.d(this.a) != 1)
        break label538;
      k = Panel.g(this.a);
      if (Panel.k(this.a))
        break label431;
      if (Panel.e(this.a) == 0)
        int m = -k;
      n = k;
      k = 0;
      tq localtq3 = Panel.a(this.a);
      tq localtq4 = tq.d;
      if (localtq3 != localtq4)
        break label459;
      float f1 = Panel.l(this.a);
      float f2 = n;
      float f3 = Math.abs(f1 - f2);
      float f4 = Panel.l(this.a);
      float f5 = k;
      float f6 = Math.abs(f4 - f5);
      if (f3 < f6)
      {
        Panel localPanel2 = this.a;
        if (Panel.k(this.a))
          break label452;
        int i1 = 1;
        boolean bool3 = Panel.a(localPanel2, i1);
        k = n;
      }
      n = (int)Panel.l(this.a);
      tq localtq5 = Panel.a(this.a);
      tq localtq6 = tq.e;
      if ((localtq5 != localtq6) || (!Panel.m(this.a)))
        break label493;
      float f7 = k - n;
      float f8 = Panel.j(this.a);
      i3 = Math.max((int)(Math.abs(f7 / f8) * 1000.0F), 20);
      i4 = 0;
      i5 = 0;
      int i6 = n;
      i7 = k;
      i8 = i3;
      i9 = i6;
    }
    while (true)
    {
      Panel localPanel3 = this.a;
      float f9 = Panel.b(this.a, 0.0F);
      float f10 = Panel.a(localPanel3, f9);
      if (i8 != 0)
        break label914;
      Panel localPanel4 = this.a;
      tq localtq7 = tq.c;
      tq localtq8 = Panel.a(localPanel4, localtq7);
      if (Panel.k(this.a))
        Panel.c(this.a).setVisibility(8);
      Panel.p(this.a);
      return;
      i = 0;
      break;
      label425: j = 0;
      break label62;
      label431: if (Panel.e(this.a) == 0)
        int i10 = -k;
      int i11 = 0;
      break label129;
      label452: int i2 = 0;
      break label226;
      label459: tq localtq9 = Panel.a(this.a);
      tq localtq10 = tq.e;
      if (localtq9 != localtq10)
        break label249;
      n = (int)Panel.l(this.a);
      break label249;
      label493: int i12 = Panel.n(this.a);
      int i13 = Math.abs(k - n);
      int i14 = i12 * i13;
      int i15 = Panel.g(this.a);
      i3 = i14 / i15;
      break label316;
      label538: int i16 = Panel.f(this.a);
      int i18;
      if (!Panel.k(this.a))
      {
        if (Panel.e(this.a) == 2)
          int i17 = -i16;
        i18 = i16;
        i16 = 0;
        label580: tq localtq11 = Panel.a(this.a);
        tq localtq12 = tq.d;
        if (localtq11 != localtq12)
          break label817;
        float f11 = Panel.o(this.a);
        float f12 = i18;
        float f13 = Math.abs(f11 - f12);
        float f14 = Panel.o(this.a);
        float f15 = i16;
        float f16 = Math.abs(f14 - f15);
        if (f13 < f16)
        {
          Panel localPanel5 = this.a;
          if (Panel.k(this.a))
            break label810;
          int i19 = 1;
          label677: boolean bool4 = Panel.a(localPanel5, i19);
          i16 = i18;
        }
        i18 = (int)Panel.o(this.a);
      }
      while (true)
      {
        tq localtq13 = Panel.a(this.a);
        tq localtq14 = tq.e;
        if ((localtq13 != localtq14) || (!Panel.m(this.a)))
          break label851;
        float f17 = i16 - i18;
        float f18 = Panel.j(this.a);
        int i21 = Math.max((int)(Math.abs(f17 / f18) * 1000.0F), 20);
        i4 = i16;
        i5 = i18;
        i8 = i21;
        i7 = 0;
        i9 = 0;
        break;
        if (Panel.e(this.a) == 2)
          int i22 = -i16;
        int i23 = 0;
        break label580;
        label810: int i20 = 0;
        break label677;
        label817: tq localtq15 = Panel.a(this.a);
        tq localtq16 = tq.e;
        if (localtq15 != localtq16)
          continue;
        i18 = (int)Panel.o(this.a);
      }
      label851: int i24 = Panel.n(this.a);
      int i25 = Math.abs(i16 - i18);
      int i26 = i24 * i25;
      int i27 = Panel.f(this.a);
      int i28 = i26 / i27;
      i4 = i16;
      i5 = i18;
      i8 = i28;
      i7 = 0;
      i9 = 0;
    }
    label914: float f19 = i5;
    float f20 = i4;
    float f21 = i9;
    float f22 = i7;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(f19, f20, f21, f22);
    long l = i8;
    localTranslateAnimation.setDuration(l);
    Animation.AnimationListener localAnimationListener = Panel.q(this.a);
    localTranslateAnimation.setAnimationListener(localAnimationListener);
    tq localtq17 = Panel.a(this.a);
    tq localtq18 = tq.e;
    if ((localtq17 == localtq18) && (Panel.m(this.a)))
    {
      LinearInterpolator localLinearInterpolator = new LinearInterpolator();
      localTranslateAnimation.setInterpolator(localLinearInterpolator);
    }
    while (true)
    {
      this.a.startAnimation(localTranslateAnimation);
      return;
      if (Panel.r(this.a) == null)
        continue;
      Interpolator localInterpolator = Panel.r(this.a);
      localTranslateAnimation.setInterpolator(localInterpolator);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tn
 * JD-Core Version:    0.6.0
 */