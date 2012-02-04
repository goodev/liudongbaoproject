import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.CorporationVo;

public class kr extends tr
{
  private int a;
  private Context b;

  public kr(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.a = paramInt;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    CorporationVo localCorporationVo = (CorporationVo)getItem(paramInt1);
    ks localks;
    View localView;
    if (paramView == null)
    {
      localks = new ks(this);
      localView = d().inflate(paramInt2, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(16908308);
      localks.a = localTextView1;
      localView.setTag(localks);
    }
    while (true)
    {
      TextView localTextView2 = localks.a;
      String str = localCorporationVo.b();
      localTextView2.setText(str);
      return localView;
      localks = (ks)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((CorporationVo)getItem(paramInt)).a();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = d().inflate(2130903112, null, 0);
      ((TextView)localView.findViewById(16908308)).setText("无商家");
    }
    while (true)
    {
      return localView;
      int i = this.a;
      localView = a(paramInt, paramView, paramViewGroup, i);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kr
 * JD-Core Version:    0.6.0
 */