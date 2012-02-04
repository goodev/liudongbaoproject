package com.mymoney.ui.navtrans;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.TextView;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;
import gi;
import java.util.Map;
import m;

public class NavYearTransactionActivity$YearTransListAdapter extends SimpleCursorTreeAdapter
{
  private Context b;
  private Resources c;

  public NavYearTransactionActivity$YearTransListAdapter(NavYearTransactionActivity paramNavYearTransactionActivity, Cursor paramCursor, Context paramContext, int paramInt1, int paramInt2, String[] paramArrayOfString1, int[] paramArrayOfInt1, String[] paramArrayOfString2, int[] paramArrayOfInt2)
  {
  }

  private long a(int paramInt)
  {
    return gi.b(gi.b(NavYearTransactionActivity.c(this.a)), paramInt);
  }

  private long b(int paramInt)
  {
    return gi.c(gi.b(NavYearTransactionActivity.c(this.a)), paramInt);
  }

  protected void bindChildView(View paramView, Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    View localView1 = paramView;
    int i = 2131231115;
    TextView localTextView1 = (TextView)localView1.findViewById(i);
    View localView2 = paramView;
    int j = 2131231116;
    TextView localTextView2 = (TextView)localView2.findViewById(j);
    View localView3 = paramView;
    int k = 2131231118;
    TextView localTextView3 = (TextView)localView3.findViewById(k);
    View localView4 = paramView;
    int m = 2131231119;
    ImageView localImageView1 = (ImageView)localView4.findViewById(m);
    View localView5 = paramView;
    int n = 2131231120;
    TextView localTextView4 = (TextView)localView5.findViewById(n);
    View localView6 = paramView;
    int i1 = 2131231114;
    ImageView localImageView2 = (ImageView)localView6.findViewById(i1);
    View localView7 = paramView;
    int i2 = 2131231121;
    TextView localTextView5 = (TextView)localView7.findViewById(i2);
    View localView8 = paramView;
    int i3 = 2131231093;
    TextView localTextView6 = (TextView)localView8.findViewById(i3);
    View localView9 = paramView;
    int i4 = 2131231122;
    TextView localTextView7 = (TextView)localView9.findViewById(i4);
    View localView10 = paramView;
    int i5 = 2131231123;
    LinearLayout localLinearLayout = (LinearLayout)localView10.findViewById(i5);
    View localView11 = paramView;
    int i6 = 2131231124;
    TextView localTextView8 = (TextView)localView11.findViewById(i6);
    View localView12 = paramView;
    int i7 = 2131231125;
    TextView localTextView9 = (TextView)localView12.findViewById(i7);
    View localView13 = paramView;
    int i8 = 2131230916;
    ImageView localImageView3 = (ImageView)localView13.findViewById(i8);
    Cursor localCursor1 = paramCursor;
    int i9 = 0;
    String str1 = localCursor1.getString(i9);
    Cursor localCursor2 = paramCursor;
    int i10 = 7;
    String str2 = localCursor2.getString(i10);
    Cursor localCursor3 = paramCursor;
    int i11 = 2;
    String str3 = localCursor3.getString(i11);
    Cursor localCursor4 = paramCursor;
    int i12 = 3;
    String str4 = localCursor4.getString(i12);
    Cursor localCursor5 = paramCursor;
    int i13 = 4;
    String str5 = localCursor5.getString(i13);
    Cursor localCursor6 = paramCursor;
    int i14 = 1;
    String str6 = localCursor6.getString(i14);
    Cursor localCursor7 = paramCursor;
    int i15 = 5;
    String str7 = localCursor7.getString(i15);
    Cursor localCursor8 = paramCursor;
    int i16 = 6;
    String str8 = localCursor8.getString(i16);
    Cursor localCursor9 = paramCursor;
    int i17 = 8;
    boolean bool = Boolean.valueOf(localCursor9.getString(i17)).booleanValue();
    Cursor localCursor10 = paramCursor;
    int i18 = 9;
    String str9 = localCursor10.getString(i18);
    Cursor localCursor11 = paramCursor;
    int i19 = 7;
    int i20 = localCursor11.getInt(i19);
    int i24;
    if (i20 != 0)
    {
      int i21 = 1;
      int i22 = i20;
      if (i21 != i22);
    }
    else
    {
      String str10 = str6;
      int i23 = 2;
      i24 = CategoryIconResourcesHelper.a(str10, i23);
      if (i20 != 0)
        break label956;
      int i25 = this.c.getColor(2131296280);
      TextView localTextView10 = localTextView7;
      int i26 = i25;
      localTextView10.setTextColor(i26);
      int i27 = this.c.getColor(2131296280);
      TextView localTextView11 = localTextView8;
      int i28 = i27;
      localTextView11.setTextColor(i28);
      label537: if (!TextUtils.isEmpty(str4))
        break label1080;
      localImageView1.setVisibility(8);
      localTextView4.setVisibility(8);
      label559: if (i20 != 0)
      {
        int i29 = 1;
        int i30 = i20;
        if (i29 != i30)
        {
          int i31 = 3;
          int i32 = i20;
          if (i31 != i32)
            break label1110;
        }
      }
      ImageView localImageView4 = localImageView3;
      int i33 = 0;
      localImageView4.setVisibility(i33);
      label606: if (!bool)
        break label1127;
      localTextView7.setVisibility(8);
      localLinearLayout.setVisibility(0);
    }
    while (true)
    {
      TextView localTextView12 = localTextView1;
      String str11 = str1;
      localTextView12.setText(str11);
      TextView localTextView13 = localTextView2;
      String str12 = str2;
      localTextView13.setText(str12);
      localTextView3.setText(str3);
      ImageView localImageView5 = localImageView2;
      int i34 = i24;
      localImageView5.setBackgroundResource(i34);
      TextView localTextView14 = localTextView5;
      String str13 = str5;
      localTextView14.setText(str13);
      TextView localTextView15 = localTextView6;
      String str14 = str7;
      localTextView15.setText(str14);
      TextView localTextView16 = localTextView7;
      String str15 = str8;
      localTextView16.setText(str15);
      TextView localTextView17 = localTextView9;
      String str16 = str9;
      localTextView17.setText(str16);
      TextView localTextView18 = localTextView8;
      String str17 = str8;
      localTextView18.setText(str17);
      return;
      int i35 = 2;
      int i36 = i20;
      if (i35 == i36)
      {
        i24 = 2130837782;
        break;
      }
      int i37 = 3;
      int i38 = i20;
      if (i37 == i38)
      {
        i24 = 2130837783;
        break;
      }
      int i39 = 8;
      int i40 = i20;
      if (i39 == i40)
      {
        i24 = 2130837740;
        break;
      }
      int i41 = 9;
      int i42 = i20;
      if (i41 == i42)
      {
        i24 = 2130837740;
        break;
      }
      int i43 = 10;
      int i44 = i20;
      if (i43 == i44)
      {
        i24 = 2130837740;
        break;
      }
      int i45 = 4;
      int i46 = i20;
      if (i45 == i46)
      {
        i24 = 2130837741;
        break;
      }
      int i47 = 5;
      int i48 = i20;
      if (i47 == i48)
      {
        i24 = 2130837761;
        break;
      }
      int i49 = 6;
      int i50 = i20;
      if (i49 == i50)
      {
        i24 = 2130837771;
        break;
      }
      int i51 = 7;
      int i52 = i20;
      if (i51 == i52)
      {
        i24 = 2130837772;
        break;
      }
      throw new RuntimeException("unsupport trans type");
      label956: int i53 = 1;
      int i54 = i20;
      if (i53 == i54)
      {
        int i55 = this.c.getColor(2131296281);
        TextView localTextView19 = localTextView7;
        int i56 = i55;
        localTextView19.setTextColor(i56);
        int i57 = this.c.getColor(2131296281);
        TextView localTextView20 = localTextView8;
        int i58 = i57;
        localTextView20.setTextColor(i58);
        break label537;
      }
      int i59 = this.c.getColor(2131296282);
      TextView localTextView21 = localTextView7;
      int i60 = i59;
      localTextView21.setTextColor(i60);
      int i61 = this.c.getColor(2131296282);
      TextView localTextView22 = localTextView8;
      int i62 = i61;
      localTextView22.setTextColor(i62);
      break label537;
      label1080: ImageView localImageView6 = localImageView1;
      int i63 = 0;
      localImageView6.setVisibility(i63);
      localTextView4.setVisibility(0);
      localTextView4.setText(str4);
      break label559;
      label1110: ImageView localImageView7 = localImageView3;
      int i64 = 4;
      localImageView7.setVisibility(i64);
      break label606;
      label1127: localTextView7.setVisibility(0);
      localLinearLayout.setVisibility(8);
    }
  }

  protected void bindGroupView(View paramView, Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131230813);
    TextView localTextView2 = (TextView)paramView.findViewById(2131230814);
    TextView localTextView3 = (TextView)paramView.findViewById(2131230857);
    String str1 = paramCursor.getString(1);
    String str2 = paramCursor.getString(2);
    String str3 = paramCursor.getString(3);
    int i = this.c.getColor(2131296281);
    localTextView2.setTextColor(i);
    int j = this.c.getColor(2131296280);
    localTextView3.setTextColor(j);
    String str4 = str1 + "月";
    localTextView1.setText(str4);
    localTextView2.setText(str2);
    localTextView3.setText(str3);
  }

  protected Cursor getChildrenCursor(Cursor paramCursor)
  {
    int i = paramCursor.getInt(0);
    Map localMap1 = NavYearTransactionActivity.i(this.a);
    Integer localInteger1 = Integer.valueOf(i);
    Cursor localCursor = (Cursor)localMap1.get(localInteger1);
    if (localCursor == null)
    {
      int j = i - 1;
      long l1 = a(j);
      int k = i - 1;
      long l2 = b(k);
      m localm = NavYearTransactionActivity.a(this.a);
      long[] arrayOfLong1 = NavYearTransactionActivity.j(this.a).c();
      long[] arrayOfLong2 = NavYearTransactionActivity.j(this.a).d();
      long[] arrayOfLong3 = NavYearTransactionActivity.j(this.a).e();
      long[] arrayOfLong4 = NavYearTransactionActivity.j(this.a).f();
      String str = NavYearTransactionActivity.j(this.a).g();
      localCursor = localm.a(l1, l2, arrayOfLong1, null, arrayOfLong2, arrayOfLong3, arrayOfLong4, str);
      Map localMap2 = NavYearTransactionActivity.i(this.a);
      Integer localInteger2 = Integer.valueOf(i);
      Object localObject = localMap2.put(localInteger2, localCursor);
    }
    return localCursor;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.navtrans.NavYearTransactionActivity.YearTransListAdapter
 * JD-Core Version:    0.6.0
 */