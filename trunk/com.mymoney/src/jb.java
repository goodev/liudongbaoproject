import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import java.util.List;

public class jb extends AsyncTask
{
  public jb(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  private void a()
  {
    Button localButton1 = AddOrEditTransactionActivity.b(this.a);
    String str1 = gi.f(AddOrEditTransactionActivity.a(this.a));
    localButton1.setText(str1);
    Button localButton2 = AddOrEditTransactionActivity.ac(this.a);
    String str2 = gs.a(AddOrEditTransactionActivity.ab(this.a), null);
    localButton2.setText(str2);
    Button localButton3 = AddOrEditTransactionActivity.f(this.a);
    String str3 = AddOrEditTransactionActivity.e(this.a);
    localButton3.setText(str3);
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    if (!AddOrEditTransactionActivity.o(this.a))
    {
      AddOrEditTransactionActivity.p(this.a);
      if (AddOrEditTransactionActivity.i(this.a) != 3)
        break label257;
      AddOrEditTransactionActivity localAddOrEditTransactionActivity1 = this.a;
      m localm = AddOrEditTransactionActivity.h(this.a);
      long l1 = AddOrEditTransactionActivity.g(this.a);
      TransactionVo localTransactionVo1 = localm.a(l1);
      TransactionVo localTransactionVo2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity1, localTransactionVo1);
      if (CategoryVo.a(AddOrEditTransactionActivity.j(this.a).f()) != 0L)
        break label223;
      AddOrEditTransactionActivity localAddOrEditTransactionActivity2 = this.a;
      jc localjc = new jc(this);
      localAddOrEditTransactionActivity2.runOnUiThread(localjc);
      if (!AddOrEditTransactionActivity.q(this.a))
        break label177;
      AddOrEditTransactionActivity localAddOrEditTransactionActivity3 = this.a;
      long l2 = AddOrEditTransactionActivity.r(this.a).b().e().a();
      AddOrEditTransactionActivity.b(localAddOrEditTransactionActivity3, l2);
    }
    while (true)
    {
      AddOrEditTransactionActivity.w(this.a);
      AddOrEditTransactionActivity.x(this.a);
      AddOrEditTransactionActivity.y(this.a);
      return null;
      label177: if (!AddOrEditTransactionActivity.s(this.a))
        continue;
      AddOrEditTransactionActivity localAddOrEditTransactionActivity4 = this.a;
      long l3 = AddOrEditTransactionActivity.r(this.a).c().e().a();
      AddOrEditTransactionActivity.b(localAddOrEditTransactionActivity4, l3);
      continue;
      label223: AddOrEditTransactionActivity localAddOrEditTransactionActivity5 = this.a;
      long l4 = AddOrEditTransactionActivity.j(this.a).f().e().a();
      AddOrEditTransactionActivity.b(localAddOrEditTransactionActivity5, l4);
    }
    label257: AddOrEditTransactionActivity localAddOrEditTransactionActivity6 = this.a;
    CategoryVo localCategoryVo1 = AddOrEditTransactionActivity.r(this.a).b();
    CategoryVo localCategoryVo2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity6, localCategoryVo1);
    AddOrEditTransactionActivity localAddOrEditTransactionActivity7 = this.a;
    CategoryVo localCategoryVo3 = AddOrEditTransactionActivity.r(this.a).c();
    CategoryVo localCategoryVo4 = AddOrEditTransactionActivity.b(localAddOrEditTransactionActivity7, localCategoryVo3);
    if (AddOrEditTransactionActivity.q(this.a))
    {
      AddOrEditTransactionActivity localAddOrEditTransactionActivity8 = this.a;
      CategoryVo localCategoryVo5 = AddOrEditTransactionActivity.t(this.a);
      CategoryVo localCategoryVo6 = AddOrEditTransactionActivity.c(localAddOrEditTransactionActivity8, localCategoryVo5);
    }
    while (true)
    {
      AddOrEditTransactionActivity localAddOrEditTransactionActivity9 = this.a;
      AccountVo localAccountVo1 = AddOrEditTransactionActivity.r(this.a).e();
      AccountVo localAccountVo2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity9, localAccountVo1);
      AddOrEditTransactionActivity localAddOrEditTransactionActivity10 = this.a;
      CorporationVo localCorporationVo1 = AddOrEditTransactionActivity.r(this.a).f();
      CorporationVo localCorporationVo2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity10, localCorporationVo1);
      AddOrEditTransactionActivity localAddOrEditTransactionActivity11 = this.a;
      long l5 = AddOrEditTransactionActivity.v(this.a).e().a();
      AddOrEditTransactionActivity.b(localAddOrEditTransactionActivity11, l5);
      AddOrEditTransactionActivity localAddOrEditTransactionActivity12 = this.a;
      ProjectVo localProjectVo1 = AddOrEditTransactionActivity.r(this.a).d();
      ProjectVo localProjectVo2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity12, localProjectVo1);
      break;
      if (!AddOrEditTransactionActivity.s(this.a))
        continue;
      AddOrEditTransactionActivity localAddOrEditTransactionActivity13 = this.a;
      CategoryVo localCategoryVo7 = AddOrEditTransactionActivity.u(this.a);
      CategoryVo localCategoryVo8 = AddOrEditTransactionActivity.c(localAddOrEditTransactionActivity13, localCategoryVo7);
    }
  }

  protected void a(Void paramVoid)
  {
    Object localObject1;
    if (AddOrEditTransactionActivity.o(this.a))
    {
      kp localkp1 = AddOrEditTransactionActivity.A(this.a);
      List localList1 = AddOrEditTransactionActivity.z(this.a);
      localkp1.a(localList1);
      Spinner localSpinner1 = AddOrEditTransactionActivity.C(this.a);
      int i = AddOrEditTransactionActivity.B(this.a);
      localSpinner1.setSelection(i);
      kp localkp2 = AddOrEditTransactionActivity.E(this.a);
      List localList2 = AddOrEditTransactionActivity.D(this.a);
      localkp2.a(localList2);
      Spinner localSpinner2 = AddOrEditTransactionActivity.G(this.a);
      int j = AddOrEditTransactionActivity.F(this.a);
      localSpinner2.setSelection(j);
      kl localkl1 = AddOrEditTransactionActivity.I(this.a);
      List localList3 = AddOrEditTransactionActivity.H(this.a);
      localkl1.a(localList3);
      Spinner localSpinner3 = AddOrEditTransactionActivity.K(this.a);
      int k = AddOrEditTransactionActivity.J(this.a);
      localSpinner3.setSelection(k);
      kr localkr1 = AddOrEditTransactionActivity.M(this.a);
      List localList4 = AddOrEditTransactionActivity.L(this.a);
      localkr1.a(localList4);
      Spinner localSpinner4 = AddOrEditTransactionActivity.O(this.a);
      int m = AddOrEditTransactionActivity.N(this.a);
      localSpinner4.setSelection(m);
      kt localkt1 = AddOrEditTransactionActivity.Q(this.a);
      List localList5 = AddOrEditTransactionActivity.P(this.a);
      localkt1.a(localList5);
      Spinner localSpinner5 = AddOrEditTransactionActivity.S(this.a);
      int n = AddOrEditTransactionActivity.R(this.a);
      localSpinner5.setSelection(n);
      String str1 = AddOrEditTransactionActivity.b();
      StringBuilder localStringBuilder1 = new StringBuilder().append("mSubcategoryList size is ");
      int i1 = AddOrEditTransactionActivity.D(this.a).size();
      String str2 = i1;
      gj.a(str1, str2);
      String str3 = AddOrEditTransactionActivity.b();
      StringBuilder localStringBuilder2 = new StringBuilder().append("mSubcategorySpnSelectedPosition is ");
      int i2 = AddOrEditTransactionActivity.F(this.a);
      String str4 = i2;
      gj.a(str3, str4);
      a();
      List localList6 = AddOrEditTransactionActivity.z(this.a);
      int i3 = AddOrEditTransactionActivity.B(this.a);
      localObject1 = (CategoryVo)localList6.get(i3);
      if (AddOrEditTransactionActivity.i(this.a) != 2)
        return;
      AddOrEditTransactionActivity.X(this.a).setEnabled(1);
      AddOrEditTransactionActivity.Y(this.a).setEnabled(1);
      if (!AddOrEditTransactionActivity.q(this.a))
        break label1221;
      AddOrEditTransactionActivity.Z(this.a).check(2131230732);
    }
    while (true)
    {
      if (localObject1 == null)
        return;
      f localf = AddOrEditTransactionActivity.aa(this.a);
      long l1 = ((CategoryVo)localObject1).a();
      hh localhh = localf.a(l1);
      AddOrEditTransactionActivity.a(this.a, localhh);
      return;
      String str7;
      label711: Object localObject2;
      Object localObject3;
      AccountVo localAccountVo2;
      Object localObject4;
      if (AddOrEditTransactionActivity.i(this.a) == 3)
      {
        CategoryVo localCategoryVo1 = AddOrEditTransactionActivity.j(this.a).f().e();
        AccountVo localAccountVo1 = AddOrEditTransactionActivity.j(this.a).g();
        CorporationVo localCorporationVo1 = AddOrEditTransactionActivity.j(this.a).h();
        ProjectVo localProjectVo1 = AddOrEditTransactionActivity.j(this.a).i();
        AddOrEditTransactionActivity localAddOrEditTransactionActivity1 = this.a;
        long l2 = AddOrEditTransactionActivity.j(this.a).j();
        long l3 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity1, l2);
        AddOrEditTransactionActivity localAddOrEditTransactionActivity2 = this.a;
        double d1 = AddOrEditTransactionActivity.j(this.a).b();
        double d2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity2, d1);
        AddOrEditTransactionActivity localAddOrEditTransactionActivity3 = this.a;
        String str5 = AddOrEditTransactionActivity.j(this.a).c();
        String str6 = AddOrEditTransactionActivity.f(localAddOrEditTransactionActivity3, str5);
        AddOrEditTransactionActivity localAddOrEditTransactionActivity4 = this.a;
        long l4 = AddOrEditTransactionActivity.j(this.a).g().a();
        long l5 = AddOrEditTransactionActivity.c(localAddOrEditTransactionActivity4, l4);
        str7 = AddOrEditTransactionActivity.j(this.a).d();
        if (!TextUtils.isEmpty(str7))
        {
          if (Environment.getExternalStorageState().equals("removed"))
            hb.b(AddOrEditTransactionActivity.a(), "未加载sd卡,与该账单相关的照片无法显示");
        }
        else
        {
          ProjectVo localProjectVo2 = localProjectVo1;
          localObject2 = localCategoryVo1;
          localObject3 = localProjectVo2;
          localAccountVo2 = localAccountVo1;
          localObject4 = localCorporationVo1;
        }
      }
      AccountVo localAccountVo4;
      for (Object localObject5 = localAccountVo2; ; localObject5 = localAccountVo4)
      {
        a();
        kp localkp3 = AddOrEditTransactionActivity.A(this.a);
        List localList7 = AddOrEditTransactionActivity.z(this.a);
        localkp3.a(localList7);
        Spinner localSpinner6 = AddOrEditTransactionActivity.C(this.a);
        int i4 = AddOrEditTransactionActivity.z(this.a).indexOf(localObject2);
        localSpinner6.setSelection(i4);
        if (localObject2 != null)
        {
          CategoryVo localCategoryVo2 = ((CategoryVo)localObject2).e();
          kp localkp4 = AddOrEditTransactionActivity.E(this.a);
          List localList8 = AddOrEditTransactionActivity.D(this.a);
          localkp4.a(localList8);
          Spinner localSpinner7 = AddOrEditTransactionActivity.G(this.a);
          int i5 = AddOrEditTransactionActivity.D(this.a).indexOf(localCategoryVo2);
          localSpinner7.setSelection(i5);
        }
        kl localkl2 = AddOrEditTransactionActivity.I(this.a);
        List localList9 = AddOrEditTransactionActivity.H(this.a);
        localkl2.a(localList9);
        int i6 = AddOrEditTransactionActivity.H(this.a).indexOf(localObject5);
        if ((i6 == -1) && (AddOrEditTransactionActivity.H(this.a).size() > 1))
          i6 = 1;
        AddOrEditTransactionActivity.K(this.a).setSelection(i6);
        kr localkr2 = AddOrEditTransactionActivity.M(this.a);
        List localList10 = AddOrEditTransactionActivity.L(this.a);
        localkr2.a(localList10);
        int i7 = AddOrEditTransactionActivity.L(this.a).indexOf(localObject4);
        if (i7 == -1)
          i7 = AddOrEditTransactionActivity.b;
        AddOrEditTransactionActivity.O(this.a).setSelection(i7);
        kt localkt2 = AddOrEditTransactionActivity.Q(this.a);
        List localList11 = AddOrEditTransactionActivity.P(this.a);
        localkt2.a(localList11);
        int i8 = AddOrEditTransactionActivity.P(this.a).indexOf(localObject3);
        if (i8 == -1)
          i8 = AddOrEditTransactionActivity.b;
        AddOrEditTransactionActivity.S(this.a).setSelection(i8);
        localObject1 = localObject2;
        break;
        AddOrEditTransactionActivity localAddOrEditTransactionActivity5 = this.a;
        String str8 = eo.a(str7);
        int i9 = AddOrEditTransactionActivity.c;
        int i10 = AddOrEditTransactionActivity.d;
        Bitmap localBitmap1 = gp.a(str8, i9, i10, 1);
        Bitmap localBitmap2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity5, localBitmap1);
        if (AddOrEditTransactionActivity.n(this.a) != null)
        {
          AddOrEditTransactionActivity.T(this.a);
          break label711;
        }
        hb.b(AddOrEditTransactionActivity.a(), "无法找到与该账单相关的照片,请确认是否已经在sd卡中");
        break label711;
        CategoryVo localCategoryVo3 = AddOrEditTransactionActivity.v(this.a).e();
        AccountVo localAccountVo3 = AddOrEditTransactionActivity.U(this.a);
        CorporationVo localCorporationVo2 = AddOrEditTransactionActivity.V(this.a);
        ProjectVo localProjectVo3 = AddOrEditTransactionActivity.W(this.a);
        localObject2 = localCategoryVo3;
        localObject3 = localProjectVo3;
        localAccountVo4 = localAccountVo3;
        localObject4 = localCorporationVo2;
      }
      label1221: if (!AddOrEditTransactionActivity.s(this.a))
        continue;
      AddOrEditTransactionActivity.Z(this.a).check(2131230733);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jb
 * JD-Core Version:    0.6.0
 */