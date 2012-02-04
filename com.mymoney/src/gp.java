import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class gp
{
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = 1;
    Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
    if ((localOptions.outHeight > 0) && (localOptions.outWidth > 0))
    {
      localOptions.inJustDecodeBounds = 0;
      int n;
      for (localOptions.inSampleSize = 2; ; localOptions.inSampleSize = n)
      {
        int i = localOptions.outWidth;
        int j = localOptions.inSampleSize;
        if (i / j <= paramInt1)
          break;
        int k = localOptions.outHeight;
        int m = localOptions.inSampleSize;
        if (k / m <= paramInt2)
          break;
        n = localOptions.inSampleSize + 1;
      }
      int i1 = localOptions.inSampleSize - 1;
      localOptions.inSampleSize = i1;
      localBitmap1 = BitmapFactory.decodeFile(paramString, localOptions);
      if ((localBitmap1 != null) && (paramBoolean))
        localBitmap1 = Bitmap.createScaledBitmap(localBitmap1, paramInt1, paramInt2, 0);
    }
    return localBitmap1;
  }

  public static Drawable a(Bitmap paramBitmap)
  {
    return new BitmapDrawable(paramBitmap);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gp
 * JD-Core Version:    0.6.0
 */