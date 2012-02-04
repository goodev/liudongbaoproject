import android.os.AsyncTask;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.ui.setting.SettingAddOrEditAccountActivity;
import java.util.List;

public class pg extends AsyncTask
{
  private int b;
  private int c;
  private hk d;

  public pg(SettingAddOrEditAccountActivity paramSettingAddOrEditAccountActivity)
  {
  }

  private boolean a()
  {
    int i = SettingAddOrEditAccountActivity.u(this.a);
    if (1 == i);
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean b()
  {
    if (SettingAddOrEditAccountActivity.u(this.a) == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity1 = this.a;
    AccountGroupVo localAccountGroupVo1 = SettingAddOrEditAccountActivity.a(this.a).b();
    AccountGroupVo localAccountGroupVo2 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity1, localAccountGroupVo1);
    SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity2 = this.a;
    List localList1 = SettingAddOrEditAccountActivity.a(this.a).a();
    List localList2 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity2, localList1);
    if (b())
    {
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity3 = this.a;
      e locale = SettingAddOrEditAccountActivity.c(this.a);
      long l1 = SettingAddOrEditAccountActivity.b(this.a);
      AccountVo localAccountVo1 = locale.d(l1);
      AccountVo localAccountVo2 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity3, localAccountVo1);
      AccountGroupVo localAccountGroupVo3 = SettingAddOrEditAccountActivity.d(this.a).c().c();
      AccountGroupVo localAccountGroupVo4 = localAccountGroupVo3.c();
      int i = SettingAddOrEditAccountActivity.e(this.a).indexOf(localAccountGroupVo3);
      this.b = i;
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity4 = this.a;
      d locald1 = SettingAddOrEditAccountActivity.a(this.a);
      long l2 = localAccountGroupVo3.a();
      List localList3 = locald1.a(l2);
      List localList4 = SettingAddOrEditAccountActivity.b(localSettingAddOrEditAccountActivity4, localList3);
      int j = SettingAddOrEditAccountActivity.f(this.a).indexOf(localAccountGroupVo4);
      this.c = j;
      j localj1 = SettingAddOrEditAccountActivity.g(this.a);
      String str1 = SettingAddOrEditAccountActivity.d(this.a).d();
      hk localhk1 = localj1.a(str1);
      this.d = localhk1;
    }
    while (true)
    {
      return null;
      if (!a())
        continue;
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity5 = this.a;
      AccountVo localAccountVo3 = new AccountVo();
      AccountVo localAccountVo4 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity5, localAccountVo3);
      this.b = 0;
      this.c = 0;
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity6 = this.a;
      d locald2 = SettingAddOrEditAccountActivity.a(this.a);
      long l3 = ((AccountGroupVo)SettingAddOrEditAccountActivity.e(this.a).get(0)).a();
      List localList5 = locald2.a(l3);
      List localList6 = SettingAddOrEditAccountActivity.b(localSettingAddOrEditAccountActivity6, localList5);
      j localj2 = SettingAddOrEditAccountActivity.g(this.a);
      String str2 = SettingAddOrEditAccountActivity.h(this.a).a();
      hk localhk2 = localj2.a(str2);
      this.d = localhk2;
    }
  }

  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    if (b())
    {
      int i = SettingAddOrEditAccountActivity.d(this.a).c().c().d();
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity1 = this.a;
      String str1 = SettingAddOrEditAccountActivity.d(this.a).b();
      String str2 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity1, str1);
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity2 = this.a;
      String str3 = SettingAddOrEditAccountActivity.d(this.a).d();
      String str4 = SettingAddOrEditAccountActivity.b(localSettingAddOrEditAccountActivity2, str3);
      switch (i)
      {
      default:
        EditText localEditText1 = SettingAddOrEditAccountActivity.k(this.a);
        String str5 = SettingAddOrEditAccountActivity.d(this.a).b();
        localEditText1.setText(str5);
        EditText localEditText2 = SettingAddOrEditAccountActivity.l(this.a);
        String str6 = SettingAddOrEditAccountActivity.d(this.a).h();
        localEditText2.setText(str6);
        if (!SettingAddOrEditAccountActivity.d(this.a).j())
          break;
        SettingAddOrEditAccountActivity.m(this.a).setText("是");
        SettingAddOrEditAccountActivity.n(this.a).setChecked(1);
      case 0:
      case 1:
      case 2:
      }
    }
    while (true)
    {
      TextView localTextView = SettingAddOrEditAccountActivity.o(this.a);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str7 = this.d.b();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str7).append("(");
      String str8 = this.d.c();
      String str9 = str8 + ")";
      localTextView.setText(str9);
      kj localkj1 = SettingAddOrEditAccountActivity.p(this.a);
      List localList1 = SettingAddOrEditAccountActivity.e(this.a);
      localkj1.a(localList1);
      kj localkj2 = SettingAddOrEditAccountActivity.q(this.a);
      List localList2 = SettingAddOrEditAccountActivity.f(this.a);
      localkj2.a(localList2);
      Spinner localSpinner1 = SettingAddOrEditAccountActivity.r(this.a);
      int j = this.b;
      localSpinner1.setSelection(j);
      Spinner localSpinner2 = SettingAddOrEditAccountActivity.s(this.a);
      int k = this.c;
      localSpinner2.setSelection(k);
      EditText localEditText3 = SettingAddOrEditAccountActivity.j(this.a);
      ph localph = new ph(this);
      localEditText3.addTextChangedListener(localph);
      return;
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity3 = this.a;
      double d1 = SettingAddOrEditAccountActivity.d(this.a).e();
      double d2 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity3, d1);
      EditText localEditText4 = SettingAddOrEditAccountActivity.j(this.a);
      String str10 = gs.a(SettingAddOrEditAccountActivity.i(this.a));
      localEditText4.setText(str10);
      break;
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity4 = this.a;
      double d3 = SettingAddOrEditAccountActivity.d(this.a).g();
      double d4 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity4, d3);
      EditText localEditText5 = SettingAddOrEditAccountActivity.j(this.a);
      String str11 = gs.a(SettingAddOrEditAccountActivity.i(this.a));
      localEditText5.setText(str11);
      break;
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity5 = this.a;
      double d5 = SettingAddOrEditAccountActivity.d(this.a).f();
      double d6 = SettingAddOrEditAccountActivity.a(localSettingAddOrEditAccountActivity5, d5);
      EditText localEditText6 = SettingAddOrEditAccountActivity.j(this.a);
      String str12 = gs.a(SettingAddOrEditAccountActivity.i(this.a));
      localEditText6.setText(str12);
      break;
      SettingAddOrEditAccountActivity.m(this.a).setText("否");
      SettingAddOrEditAccountActivity.n(this.a).setChecked(0);
      continue;
      if (!a())
        continue;
      SettingAddOrEditAccountActivity.j(this.a).setText("0");
      SettingAddOrEditAccountActivity.m(this.a).setText("否");
      SettingAddOrEditAccountActivity.n(this.a).setChecked(0);
      SettingAddOrEditAccountActivity localSettingAddOrEditAccountActivity6 = this.a;
      String str13 = ApplicationContext.g;
      String str14 = SettingAddOrEditAccountActivity.b(localSettingAddOrEditAccountActivity6, str13);
    }
  }

  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pg
 * JD-Core Version:    0.6.0
 */