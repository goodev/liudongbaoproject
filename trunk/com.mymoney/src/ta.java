import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.mymoney.ui.widget.CategoryIconRadioGroup;

public class ta
  implements CompoundButton.OnCheckedChangeListener
{
  private ta(CategoryIconRadioGroup paramCategoryIconRadioGroup)
  {
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    CategoryIconRadioGroup localCategoryIconRadioGroup = this.a;
    int i = paramCompoundButton.getId();
    localCategoryIconRadioGroup.check(i);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ta
 * JD-Core Version:    0.6.0
 */