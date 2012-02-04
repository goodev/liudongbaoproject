import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.AccountGroupVo;

public class kj extends tr
{
  private int a;
  private Context b;

  public kj(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.a = paramInt;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    AccountGroupVo localAccountGroupVo = (AccountGroupVo)getItem(paramInt1);
    kk localkk;
    View localView;
    if (paramView == null)
    {
      localkk = new kk(this);
      localView = d().inflate(paramInt2, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(16908308);
      localkk.a = localTextView1;
      localView.setTag(localkk);
    }
    while (true)
    {
      TextView localTextView2 = localkk.a;
      String str = localAccountGroupVo.b();
      localTextView2.setText(str);
      return localView;
      localkk = (kk)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((AccountGroupVo)getItem(paramInt)).a();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = this.a;
    return a(paramInt, paramView, paramViewGroup, i);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kj
 * JD-Core Version:    0.6.0
 */