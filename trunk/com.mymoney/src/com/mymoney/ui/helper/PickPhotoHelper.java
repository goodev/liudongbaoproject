package com.mymoney.ui.helper;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;

public class PickPhotoHelper
{
  public static Intent a()
  {
    Uri localUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
    return new Intent("android.intent.action.PICK", localUri);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.helper.PickPhotoHelper
 * JD-Core Version:    0.6.0
 */