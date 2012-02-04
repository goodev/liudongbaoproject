import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class jr extends tr
  implements vn
{
  protected int a;
  private int b = -15724528;
  private int c = 24;
  private Context d;
  private int e;
  private LayoutInflater f;

  public jr(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.d = paramContext;
    this.e = paramInt;
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.f = localLayoutInflater;
  }

  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = this.f.inflate(paramInt, paramViewGroup, 0);
    case 0:
    case -1:
    }
    while (true)
    {
      return localObject;
      localObject = null;
      continue;
      Context localContext = this.d;
      localObject = new TextView(localContext);
    }
  }

  public int a()
  {
    return b().size();
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    return null;
  }

  public View a(View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
      i = this.a;
    for (View localView = a(i, paramViewGroup); ; localView = paramView)
    {
      if ((this.a == -1) && ((localView instanceof TextView)))
      {
        TextView localTextView = (TextView)localView;
        a(localTextView);
      }
      return localView;
    }
  }

  protected void a(TextView paramTextView)
  {
    int i = this.b;
    paramTextView.setTextColor(i);
    paramTextView.setGravity(17);
    float f1 = this.c;
    paramTextView.setTextSize(f1);
    paramTextView.setLines(1);
    paramTextView.setSingleLine(1);
    Typeface localTypeface = Typeface.SANS_SERIF;
    paramTextView.setTypeface(localTypeface, 1);
  }

  public long getItemId(int paramInt)
  {
    return 65535L;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jr
 * JD-Core Version:    0.6.0
 */