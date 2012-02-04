import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.AccountVo;

public class kn extends tr
{
  private int a;
  private Context b;

  public kn(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.a = paramInt;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    AccountVo localAccountVo = (AccountVo)getItem(paramInt1);
    ko localko;
    View localView;
    if (paramView == null)
    {
      localko = new ko(this);
      localView = d().inflate(paramInt2, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(16908308);
      localko.a = localTextView1;
      localView.setTag(localko);
    }
    while (true)
    {
      TextView localTextView2 = localko.a;
      String str = localAccountVo.i();
      localTextView2.setText(str);
      return localView;
      localko = (ko)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((AccountVo)getItem(paramInt)).a();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = this.a;
    return a(paramInt, paramView, paramViewGroup, i);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kn
 * JD-Core Version:    0.6.0
 */