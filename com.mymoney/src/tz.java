import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class tz extends BaseAdapter
{
  public final Map a;
  public final ArrayAdapter b;

  public tz(Context paramContext, int paramInt)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    this.a = localLinkedHashMap;
    ArrayAdapter localArrayAdapter = new ArrayAdapter(paramContext, paramInt);
    this.b = localArrayAdapter;
  }

  public Adapter a(String paramString)
  {
    return (Adapter)this.a.get(paramString);
  }

  public void a()
  {
    this.a.clear();
    this.b.clear();
    notifyDataSetChanged();
  }

  public void a(String paramString, Adapter paramAdapter)
  {
    this.b.add(paramString);
    Object localObject = this.a.put(paramString, paramAdapter);
  }

  public int getCount()
  {
    int i = 0;
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      int j = ((Adapter)localIterator.next()).getCount() + 1;
      i += j;
    }
    return i;
  }

  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.a.keySet().iterator();
    int i = paramInt;
    Object localObject;
    Adapter localAdapter;
    int j;
    if (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localAdapter = (Adapter)this.a.get(localObject);
      j = localAdapter.getCount() + 1;
      if (i != 0);
    }
    while (true)
    {
      return localObject;
      if (i < j)
      {
        int k = i - 1;
        localObject = localAdapter.getItem(k);
        continue;
      }
      i -= j;
      break;
      localObject = null;
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.a.keySet().iterator();
    int i = 1;
    int j = paramInt;
    Adapter localAdapter;
    int k;
    int m;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localAdapter = (Adapter)this.a.get(str);
      k = localAdapter.getCount() + 1;
      if (j == 0)
        m = 0;
    }
    while (true)
    {
      return m;
      if (j < k)
      {
        int n = j - 1;
        m = localAdapter.getItemViewType(n) + i;
        continue;
      }
      j -= k;
      i = localAdapter.getViewTypeCount() + i;
      break;
      m = -1;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.a.keySet().iterator();
    int i = 0;
    int j = paramInt;
    Object localObject;
    int k;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = (Adapter)this.a.get(str);
      k = ((Adapter)localObject).getCount() + 1;
      if (j == 0)
        localObject = this.b.getView(i, paramView, paramViewGroup);
    }
    while (true)
    {
      return localObject;
      if (j < k)
      {
        int m = j - 1;
        localObject = ((Adapter)localObject).getView(m, paramView, paramViewGroup);
        continue;
      }
      int n = j - k;
      i += 1;
      j = n;
      break;
      localObject = null;
    }
  }

  public int getViewTypeCount()
  {
    int i = 1;
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      int j = ((Adapter)localIterator.next()).getViewTypeCount();
      i += j;
    }
    return i;
  }

  public boolean isEnabled(int paramInt)
  {
    if (getItemViewType(paramInt) != 0);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tz
 * JD-Core Version:    0.6.0
 */