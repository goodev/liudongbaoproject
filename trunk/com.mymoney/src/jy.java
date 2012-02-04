import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.ProjectVo;
import java.util.List;

public class jy extends jr
{
  private Context b;
  private int c;
  private LayoutInflater d;

  public jy(Context paramContext, int paramInt)
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
    ProjectVo localProjectVo = (ProjectVo)getItem(paramInt);
    jz localjz;
    View localView;
    if (paramView == null)
    {
      localjz = new jz(this);
      LayoutInflater localLayoutInflater = this.d;
      int i = this.c;
      localView = localLayoutInflater.inflate(i, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(2131230794);
      localjz.a = localTextView1;
      localView.setTag(localjz);
    }
    while (true)
    {
      TextView localTextView2 = localjz.a;
      String str = localProjectVo.b();
      localTextView2.setText(str);
      return localView;
      localjz = (jz)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((ProjectVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jy
 * JD-Core Version:    0.6.0
 */