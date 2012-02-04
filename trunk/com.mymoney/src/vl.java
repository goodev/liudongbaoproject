import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class vl extends vk
{
  private int a = -15724528;
  private int b = 24;
  protected Context d;
  protected LayoutInflater e;
  protected int f;
  protected int g;
  protected int h;

  protected vl(Context paramContext)
  {
    this(paramContext, -1);
  }

  protected vl(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0);
  }

  protected vl(Context paramContext, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.f = paramInt1;
    this.g = paramInt2;
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.e = localLayoutInflater;
  }

  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = this.e.inflate(paramInt, paramViewGroup, 0);
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

  private TextView a(View paramView, int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0);
    try
    {
      if ((paramView instanceof TextView))
        localObject = (TextView)paramView;
      while (true)
      {
        return localObject;
        if (paramInt == 0)
          continue;
        this = (TextView)paramView.findViewById(paramInt);
        localObject = this;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      int i = Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
    }
    throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", localClassCastException);
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j;
    if (paramInt >= 0)
    {
      int i = a();
      if (paramInt < i)
      {
        if (paramView != null)
          break label103;
        j = this.f;
      }
    }
    label103: for (View localView = a(j, paramViewGroup); ; localView = paramView)
    {
      int k = this.g;
      TextView localTextView = a(localView, k);
      if (localTextView != null)
      {
        Object localObject = b(paramInt);
        if (localObject == null)
          localObject = "";
        localTextView.setText((CharSequence)localObject);
        if (this.f == -1)
          a(localTextView);
      }
      while (true)
      {
        return localView;
        localView = null;
      }
    }
  }

  public View a(View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
      i = this.h;
    for (View localView = a(i, paramViewGroup); ; localView = paramView)
    {
      if ((this.h == -1) && ((localView instanceof TextView)))
      {
        TextView localTextView = (TextView)localView;
        a(localTextView);
      }
      return localView;
    }
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  protected void a(TextView paramTextView)
  {
    int i = this.a;
    paramTextView.setTextColor(i);
    paramTextView.setGravity(17);
    float f1 = this.b;
    paramTextView.setTextSize(f1);
    paramTextView.setLines(1);
    Typeface localTypeface = Typeface.SANS_SERIF;
    paramTextView.setTypeface(localTypeface, 1);
  }

  protected abstract CharSequence b(int paramInt);
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vl
 * JD-Core Version:    0.6.0
 */