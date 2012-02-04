import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class tr extends BaseAdapter
{
  private List a;
  private final Object b;
  private int c;
  private int d;
  private boolean e;
  private Context f;
  private LayoutInflater g;

  public tr(Context paramContext, int paramInt)
  {
    Object localObject = new Object();
    this.b = localObject;
    this.e = 1;
    ArrayList localArrayList = new ArrayList();
    a(paramContext, paramInt, localArrayList);
  }

  private void a(Context paramContext, int paramInt, List paramList)
  {
    this.f = paramContext;
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.g = localLayoutInflater;
    this.d = paramInt;
    this.c = paramInt;
    this.a = paramList;
  }

  protected abstract View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2);

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(Object paramObject)
  {
    boolean bool = this.a.add(paramObject);
    if (!this.e)
      return;
    notifyDataSetChanged();
  }

  public void a(Object paramObject, int paramInt)
  {
    this.a.add(paramInt, paramObject);
    if (!this.e)
      return;
    notifyDataSetChanged();
  }

  public void a(List paramList)
  {
    this.a = paramList;
    if (!this.e)
      return;
    notifyDataSetChanged();
  }

  public List b()
  {
    return this.a;
  }

  public void b(Object paramObject)
  {
    boolean bool = this.a.remove(paramObject);
    if (!this.e)
      return;
    notifyDataSetChanged();
  }

  public int c()
  {
    return this.c;
  }

  public int c(Object paramObject)
  {
    return this.a.indexOf(paramObject);
  }

  public LayoutInflater d()
  {
    return this.g;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = this.d;
    return a(paramInt, paramView, paramViewGroup, i);
  }

  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = this.c;
    return a(paramInt, paramView, paramViewGroup, i);
  }

  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.e = 1;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tr
 * JD-Core Version:    0.6.0
 */