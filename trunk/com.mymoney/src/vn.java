import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract interface vn
{
  public abstract int a();

  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);

  public abstract View a(View paramView, ViewGroup paramViewGroup);

  public abstract void registerDataSetObserver(DataSetObserver paramDataSetObserver);

  public abstract void unregisterDataSetObserver(DataSetObserver paramDataSetObserver);
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vn
 * JD-Core Version:    0.6.0
 */