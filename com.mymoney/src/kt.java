import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.ProjectVo;

public class kt extends tr
{
  private int a;
  private Context b;

  public kt(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.a = paramInt;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    ProjectVo localProjectVo = (ProjectVo)getItem(paramInt1);
    ku localku;
    View localView;
    if (paramView == null)
    {
      localku = new ku(this);
      localView = d().inflate(paramInt2, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(16908308);
      localku.a = localTextView1;
      localView.setTag(localku);
    }
    while (true)
    {
      TextView localTextView2 = localku.a;
      String str = localProjectVo.b();
      localTextView2.setText(str);
      return localView;
      localku = (ku)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((ProjectVo)getItem(paramInt)).a();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramInt == 0)
    {
      LayoutInflater localLayoutInflater = d();
      int i = this.a;
      localView = localLayoutInflater.inflate(i, null, 0);
      ((TextView)localView.findViewById(16908308)).setText("无项目");
    }
    while (true)
    {
      return localView;
      int j = this.a;
      localView = a(paramInt, paramView, paramViewGroup, j);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kt
 * JD-Core Version:    0.6.0
 */