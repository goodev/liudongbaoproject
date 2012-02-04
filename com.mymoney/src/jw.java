import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.CorporationVo;
import java.util.List;

public class jw extends jr
{
  private Context b;
  private int c;
  private LayoutInflater d;

  public jw(Context paramContext, int paramInt)
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
    CorporationVo localCorporationVo = (CorporationVo)getItem(paramInt);
    jx localjx;
    View localView;
    if (paramView == null)
    {
      localjx = new jx(this);
      LayoutInflater localLayoutInflater = this.d;
      int i = this.c;
      localView = localLayoutInflater.inflate(i, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(2131230794);
      localjx.a = localTextView1;
      localView.setTag(localjx);
    }
    while (true)
    {
      TextView localTextView2 = localjx.a;
      String str = localCorporationVo.b();
      localTextView2.setText(str);
      return localView;
      localjx = (jx)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((CorporationVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jw
 * JD-Core Version:    0.6.0
 */