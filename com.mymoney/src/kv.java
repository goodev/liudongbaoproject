import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;

public class kv extends tr
{
  private Context a;
  private Resources b;
  private boolean c;
  private boolean d;

  public kv(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    Resources localResources = this.a.getResources();
    this.b = localResources;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    TransactionVo localTransactionVo = (TransactionVo)getItem(paramInt1);
    kw localkw1;
    View localView;
    if (paramView == null)
    {
      localkw1 = new kw;
      kw localkw2 = localkw1;
      kv localkv = this;
      localkw2.<init>(localkv);
      LayoutInflater localLayoutInflater = d();
      int i = paramInt2;
      ViewGroup localViewGroup = null;
      int j = 0;
      localView = localLayoutInflater.inflate(i, localViewGroup, j);
      TextView localTextView1 = (TextView)localView.findViewById(2131231118);
      localkw1.a = localTextView1;
      ImageView localImageView1 = (ImageView)localView.findViewById(2131231119);
      localkw1.b = localImageView1;
      TextView localTextView2 = (TextView)localView.findViewById(2131231120);
      localkw1.c = localTextView2;
      ImageView localImageView2 = (ImageView)localView.findViewById(2131231114);
      localkw1.d = localImageView2;
      TextView localTextView3 = (TextView)localView.findViewById(2131231121);
      localkw1.e = localTextView3;
      TextView localTextView4 = (TextView)localView.findViewById(2131231093);
      localkw1.f = localTextView4;
      TextView localTextView5 = (TextView)localView.findViewById(2131231122);
      localkw1.g = localTextView5;
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131231123);
      localkw1.h = localLinearLayout;
      TextView localTextView6 = (TextView)localView.findViewById(2131231124);
      localkw1.i = localTextView6;
      TextView localTextView7 = (TextView)localView.findViewById(2131231125);
      localkw1.j = localTextView7;
      ImageView localImageView3 = (ImageView)localView.findViewById(2131230916);
      localkw1.k = localImageView3;
      localView.setTag(localkw1);
    }
    int k;
    AccountVo localAccountVo1;
    AccountVo localAccountVo2;
    String str4;
    String str5;
    Object localObject1;
    Object localObject2;
    int n;
    Object localObject3;
    label455: label611: label637: Object localObject4;
    label543: label563: Object localObject5;
    while (true)
    {
      k = localTransactionVo.k();
      CategoryVo localCategoryVo = localTransactionVo.f();
      localAccountVo1 = localTransactionVo.g();
      localAccountVo2 = localTransactionVo.p();
      double d1 = localTransactionVo.b();
      String str1 = localTransactionVo.l();
      String str2 = gs.a(d1, str1);
      String str3 = gi.f(localTransactionVo.j());
      str4 = "";
      str5 = localTransactionVo.c();
      if ((k == 0) || (1 == k))
      {
        String str6 = CategoryVo.c(localCategoryVo);
        String str7 = CategoryVo.b(localCategoryVo);
        int m = CategoryIconResourcesHelper.a(str6, 2);
        localObject1 = str4;
        localObject2 = str7;
        n = m;
        localObject3 = str5;
        if (k == 0)
        {
          TextView localTextView8 = localkw1.g;
          int i1 = this.b.getColor(2131296280);
          localTextView8.setTextColor(i1);
          TextView localTextView9 = localkw1.i;
          int i2 = this.b.getColor(2131296280);
          localTextView9.setTextColor(i2);
          if (!localTransactionVo.n())
            break label1628;
          localkw1.g.setVisibility(8);
          localkw1.h.setVisibility(0);
          TextView localTextView10 = localkw1.j;
          StringBuilder localStringBuilder1 = new StringBuilder().append("折合:");
          double d2 = localTransactionVo.m();
          String str8 = ApplicationContext.g;
          String str9 = gs.a(d2, str8);
          String str10 = str9;
          localTextView10.setText(str10);
          if ((k != 0) && (1 != k))
            break label1650;
          localkw1.k.setVisibility(0);
          localkw1.d.setBackgroundResource(n);
          localkw1.a.setText((CharSequence)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
            break label1699;
          localkw1.b.setVisibility(8);
          localkw1.c.setVisibility(8);
          localkw1.e.setText(str3);
          if (!this.d)
            break label1730;
          localkw1.e.setVisibility(0);
          localkw1.g.setText(str2);
          localkw1.i.setText(str2);
          localkw1.f.setText((CharSequence)localObject3);
          return localView;
          localkw1 = (kw)paramView.getTag();
          localView = paramView;
          continue;
        }
      }
      else if (2 == k)
      {
        if (!this.c)
          break;
        localObject4 = "转入";
        localObject5 = str5;
      }
    }
    while (true)
    {
      int i3 = 2130837782;
      localObject1 = str4;
      localObject2 = localObject4;
      localObject3 = localObject5;
      n = i3;
      break;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str11 = localAccountVo1.b();
      String str12 = str11 + "(转入)";
      if (TextUtils.isEmpty(str5))
      {
        String str13 = "转入";
        localObject4 = str12;
        localObject5 = str13;
        continue;
        String str14;
        Object localObject6;
        Object localObject7;
        if (3 == k)
          if (this.c)
          {
            str14 = str4;
            localObject6 = "转出";
            localObject7 = str5;
          }
        while (true)
        {
          int i4 = 2130837783;
          localObject2 = localObject6;
          localObject1 = str14;
          localObject3 = localObject7;
          n = i4;
          break;
          String str15 = localAccountVo1.b();
          str14 = localAccountVo2.b();
          if (TextUtils.isEmpty(str5))
          {
            String str16 = "转账";
            localObject6 = str15;
            localObject7 = str16;
            continue;
            Object localObject8;
            Object localObject9;
            if (8 == k)
              if (this.c)
              {
                localObject8 = "余额变更";
                localObject9 = str5;
              }
            while (true)
            {
              int i5 = 2130837740;
              localObject1 = str4;
              localObject2 = localObject8;
              localObject3 = localObject9;
              n = i5;
              break;
              String str17 = localAccountVo1.b();
              if (TextUtils.isEmpty(str5))
              {
                String str18 = "余额变更";
                localObject8 = str17;
                localObject9 = str18;
                continue;
                Object localObject10;
                Object localObject11;
                if (9 == k)
                  if (this.c)
                  {
                    localObject10 = "负债变更";
                    localObject11 = str5;
                  }
                while (true)
                {
                  int i6 = 2130837740;
                  localObject1 = str4;
                  localObject2 = localObject10;
                  localObject3 = localObject11;
                  n = i6;
                  break;
                  String str19 = localAccountVo1.b();
                  if (TextUtils.isEmpty(str5))
                  {
                    String str20 = "负债变更";
                    localObject10 = str19;
                    localObject11 = str20;
                    continue;
                    Object localObject12;
                    Object localObject13;
                    if (10 == k)
                      if (this.c)
                      {
                        localObject12 = "债权变更";
                        localObject13 = str5;
                      }
                    while (true)
                    {
                      int i7 = 2130837740;
                      localObject1 = str4;
                      localObject2 = localObject12;
                      localObject3 = localObject13;
                      n = i7;
                      break;
                      String str21 = localAccountVo1.b();
                      if (TextUtils.isEmpty(str5))
                      {
                        String str22 = "债权变更";
                        localObject12 = str21;
                        localObject13 = str22;
                        continue;
                        Object localObject14;
                        Object localObject15;
                        if (4 == k)
                          if (this.c)
                          {
                            localObject14 = "欠债";
                            localObject15 = str5;
                          }
                        while (true)
                        {
                          int i8 = 2130837741;
                          localObject1 = str4;
                          localObject2 = localObject14;
                          localObject3 = localObject15;
                          n = i8;
                          break;
                          StringBuilder localStringBuilder3 = new StringBuilder();
                          String str23 = localAccountVo1.b();
                          String str24 = str23 + "(欠债)";
                          if (TextUtils.isEmpty(str5))
                          {
                            String str25 = "欠债";
                            localObject14 = str24;
                            localObject15 = str25;
                            continue;
                            Object localObject16;
                            Object localObject17;
                            if (5 == k)
                              if (this.c)
                              {
                                localObject16 = "借出";
                                localObject17 = str5;
                              }
                            while (true)
                            {
                              int i9 = 2130837761;
                              localObject1 = str4;
                              localObject2 = localObject16;
                              localObject3 = localObject17;
                              n = i9;
                              break;
                              StringBuilder localStringBuilder4 = new StringBuilder();
                              String str26 = localAccountVo1.b();
                              String str27 = str26 + "(借出)";
                              if (TextUtils.isEmpty(str5))
                              {
                                String str28 = "借出";
                                localObject16 = str27;
                                localObject17 = str28;
                                continue;
                                Object localObject18;
                                Object localObject19;
                                if (6 == k)
                                  if (this.c)
                                  {
                                    localObject18 = "还入";
                                    localObject19 = str5;
                                  }
                                while (true)
                                {
                                  int i10 = 2130837771;
                                  localObject1 = str4;
                                  localObject2 = localObject18;
                                  localObject3 = localObject19;
                                  n = i10;
                                  break;
                                  StringBuilder localStringBuilder5 = new StringBuilder();
                                  String str29 = localAccountVo1.b();
                                  String str30 = str29 + "(还入)";
                                  if (TextUtils.isEmpty(str5))
                                  {
                                    String str31 = "还入";
                                    localObject18 = str30;
                                    localObject19 = str31;
                                    continue;
                                    Object localObject20;
                                    Object localObject21;
                                    if (7 == k)
                                      if (this.c)
                                      {
                                        localObject20 = "还出";
                                        localObject21 = str5;
                                      }
                                    while (true)
                                    {
                                      int i11 = 2130837772;
                                      localObject1 = str4;
                                      localObject2 = localObject20;
                                      localObject3 = localObject21;
                                      n = i11;
                                      break;
                                      StringBuilder localStringBuilder6 = new StringBuilder();
                                      String str32 = localAccountVo1.b();
                                      String str33 = str32 + "(还出)";
                                      if (TextUtils.isEmpty(str5))
                                      {
                                        String str34 = "还出";
                                        localObject20 = str33;
                                        localObject21 = str34;
                                        continue;
                                        throw new RuntimeException("unsupport trans type");
                                        if (1 == k)
                                        {
                                          TextView localTextView11 = localkw1.g;
                                          int i12 = this.b.getColor(2131296281);
                                          localTextView11.setTextColor(i12);
                                          TextView localTextView12 = localkw1.i;
                                          int i13 = this.b.getColor(2131296281);
                                          localTextView12.setTextColor(i13);
                                          break label455;
                                        }
                                        TextView localTextView13 = localkw1.g;
                                        int i14 = this.b.getColor(2131296282);
                                        localTextView13.setTextColor(i14);
                                        TextView localTextView14 = localkw1.i;
                                        int i15 = this.b.getColor(2131296282);
                                        localTextView14.setTextColor(i15);
                                        break label455;
                                        label1628: localkw1.g.setVisibility(0);
                                        localkw1.h.setVisibility(8);
                                        break label543;
                                        label1650: if (3 == k)
                                        {
                                          if (this.c)
                                          {
                                            localkw1.k.setVisibility(4);
                                            break label563;
                                          }
                                          localkw1.k.setVisibility(0);
                                          break label563;
                                        }
                                        localkw1.k.setVisibility(4);
                                        break label563;
                                        label1699: localkw1.b.setVisibility(0);
                                        localkw1.c.setVisibility(0);
                                        localkw1.c.setText((CharSequence)localObject1);
                                        break label611;
                                        label1730: localkw1.e.setVisibility(8);
                                        break label637;
                                      }
                                      localObject20 = str33;
                                      localObject21 = str5;
                                    }
                                  }
                                  localObject18 = str30;
                                  localObject19 = str5;
                                }
                              }
                              localObject16 = str27;
                              localObject17 = str5;
                            }
                          }
                          localObject14 = str24;
                          localObject15 = str5;
                        }
                      }
                      localObject12 = str21;
                      localObject13 = str5;
                    }
                  }
                  localObject10 = str19;
                  localObject11 = str5;
                }
              }
              localObject8 = str17;
              localObject9 = str5;
            }
          }
          localObject6 = str15;
          localObject7 = str5;
        }
      }
      localObject4 = str12;
      localObject5 = str5;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((TransactionVo)getItem(paramInt)).a();
  }

  public boolean isEnabled(int paramInt)
  {
    TransactionVo localTransactionVo = (TransactionVo)getItem(paramInt);
    int i = 0;
    int j = localTransactionVo.k();
    if ((1 == j) || (j == 0))
      i = 1;
    return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kv
 * JD-Core Version:    0.6.0
 */