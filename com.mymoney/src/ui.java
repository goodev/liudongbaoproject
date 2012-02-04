import com.mymoney.ui.widget.common.ImageViewTouchBase;

public class ui
  implements Runnable
{
  public ui(ImageViewTouchBase paramImageViewTouchBase, gw paramgw, boolean paramBoolean)
  {
  }

  public void run()
  {
    ImageViewTouchBase localImageViewTouchBase = this.c;
    gw localgw = this.a;
    boolean bool = this.b;
    localImageViewTouchBase.a(localgw, bool);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ui
 * JD-Core Version:    0.6.0
 */