import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.AccountVo;

public class kl extends tr
{
  private int a;
  private Context b;

  public kl(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.a = paramInt;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    AccountVo localAccountVo = (AccountVo)getItem(paramInt1);
    km localkm;
    View localView;
    if (paramView == null)
    {
      localkm = new km(this);
      localView = d().inflate(paramInt2, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(16908308);
      localkm.a = localTextView1;
      localView.setTag(localkm);
    }
    while (true)
    {
      TextView localTextView2 = localkm.a;
      String str = localAccountVo.i();
      localTextView2.setText(str);
      return localView;
      localkm = (km)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((AccountVo)getItem(paramInt)).a();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = d().inflate(2130903112, null, 0);
      ((TextView)localView.findViewById(16908308)).setText("无账户");
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
 * Qualified Name:     kl
 * JD-Core Version:    0.6.0
 */