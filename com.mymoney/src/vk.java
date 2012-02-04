import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public abstract class vk
  implements vn
{
  private List a;

  public View a(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a == null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.a = localLinkedList;
    }
    boolean bool = this.a.add(paramDataSetObserver);
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a == null)
      return;
    boolean bool = this.a.remove(paramDataSetObserver);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vk
 * JD-Core Version:    0.6.0
 */