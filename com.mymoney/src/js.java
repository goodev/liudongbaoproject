import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.AccountVo;
import java.util.List;

public class js extends jr
{
  private Context b;
  private int c;
  private LayoutInflater d;

  public js(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.c = paramInt;
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.d = localLayoutInflater;
  }

  public int a()
  {
    return b().size();
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AccountVo localAccountVo = (AccountVo)getItem(paramInt);
    jt localjt;
    View localView;
    if (paramView == null)
    {
      localjt = new jt(this);
      LayoutInflater localLayoutInflater = this.d;
      int i = this.c;
      localView = localLayoutInflater.inflate(i, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(2131230794);
      localjt.a = localTextView1;
      localView.setTag(localjt);
    }
    while (true)
    {
      TextView localTextView2 = localjt.a;
      String str = localAccountVo.i();
      localTextView2.setText(str);
      return localView;
      localjt = (jt)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((AccountVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     js
 * JD-Core Version:    0.6.0
 */