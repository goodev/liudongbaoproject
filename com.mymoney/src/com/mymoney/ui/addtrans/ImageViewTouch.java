package com.mymoney.ui.addtrans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.mymoney.ui.widget.common.ImageViewTouchBase;

public class ImageViewTouch extends ImageViewTouchBase
{
  private final TransactionPhotoEditActivity g;

  public ImageViewTouch(Context paramContext)
  {
    super(paramContext);
    TransactionPhotoEditActivity localTransactionPhotoEditActivity = (TransactionPhotoEditActivity)paramContext;
    this.g = localTransactionPhotoEditActivity;
  }

  public ImageViewTouch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TransactionPhotoEditActivity localTransactionPhotoEditActivity = (TransactionPhotoEditActivity)paramContext;
    this.g = localTransactionPhotoEditActivity;
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    super.b(paramFloat1, paramFloat2);
    a(1, 1);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.g.c);
    boolean bool;
    for (int i = 0; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.addtrans.ImageViewTouch
 * JD-Core Version:    0.6.0
 */