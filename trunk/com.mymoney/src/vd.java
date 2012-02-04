import android.view.View;
import android.widget.LinearLayout;
import com.mymoney.ui.widget.wheelview.WheelView;
import java.util.LinkedList;
import java.util.List;

public class vd
{
  private List a;
  private List b;
  private WheelView c;

  public vd(WheelView paramWheelView)
  {
    this.c = paramWheelView;
  }

  private View a(List paramList)
  {
    View localView1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localView1 = (View)paramList.get(0);
      Object localObject = paramList.remove(0);
    }
    for (View localView2 = localView1; ; localView2 = null)
      return localView2;
  }

  private List a(View paramView, List paramList)
  {
    if (paramList == null);
    for (Object localObject = new LinkedList(); ; localObject = paramList)
    {
      boolean bool = ((List)localObject).add(paramView);
      return localObject;
    }
  }

  private void a(View paramView, int paramInt)
  {
    int i = this.c.a().a();
    if (((paramInt < 0) || (paramInt >= i)) && (!this.c.e()))
    {
      List localList1 = this.b;
      List localList2 = a(paramView, localList1);
      this.b = localList2;
      return;
    }
    while (true)
    {
      int j;
      int k;
      if (j < 0)
      {
        int m = j + k;
        continue;
      }
      int n = j % k;
      List localList3 = this.a;
      List localList4 = a(paramView, localList3);
      this.a = localList4;
      return;
      int i1 = paramInt;
    }
  }

  public int a(LinearLayout paramLinearLayout, int paramInt, up paramup)
  {
    int i = 0;
    int j = paramInt;
    int k = paramInt;
    int m = paramLinearLayout.getChildCount();
    if (i < m)
    {
      if (!paramup.a(j))
      {
        View localView = paramLinearLayout.getChildAt(i);
        a(localView, j);
        paramLinearLayout.removeViewAt(i);
        if (i == 0)
          k += 1;
      }
      while (true)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return k;
  }

  public View a()
  {
    List localList = this.a;
    return a(localList);
  }

  public View b()
  {
    List localList = this.b;
    return a(localList);
  }

  public void c()
  {
    if (this.a != null)
      this.a.clear();
    if (this.b == null)
      return;
    this.b.clear();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vd
 * JD-Core Version:    0.6.0
 */