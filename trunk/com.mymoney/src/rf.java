import android.content.Context;
import android.widget.ArrayAdapter;
import com.mymoney.ui.setting.SettingWeekStartActivity;

public class rf extends ArrayAdapter
{
  public rf(SettingWeekStartActivity paramSettingWeekStartActivity, Context paramContext, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    super(paramContext, paramInt1, paramInt2, paramArrayOfString);
  }

  public long getItemId(int paramInt)
  {
    long l;
    if ((paramInt == 0) || (paramInt == 1))
      l = paramInt;
    while (true)
    {
      return l;
      l = 6L;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     rf
 * JD-Core Version:    0.6.0
 */