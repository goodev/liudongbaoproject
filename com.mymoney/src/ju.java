import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;
import java.util.List;

public class ju extends jr
{
  private Context b;
  private int c;
  private LayoutInflater d;

  public ju(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.c = paramInt;
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.d = localLayoutInflater;
  }

  public int a()
  {
    return b().size();
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CategoryVo localCategoryVo = (CategoryVo)getItem(paramInt);
    jv localjv;
    View localView;
    if (paramView == null)
    {
      localjv = new jv(this);
      LayoutInflater localLayoutInflater = this.d;
      int i = this.c;
      localView = localLayoutInflater.inflate(i, null, 0);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131230793);
      localjv.a = localImageView1;
      TextView localTextView1 = (TextView)localView.findViewById(2131230794);
      localjv.b = localTextView1;
      localView.setTag(localjv);
    }
    while (true)
    {
      ImageView localImageView2 = localjv.a;
      String str1 = localCategoryVo.f();
      int j = localCategoryVo.c();
      int k = CategoryIconResourcesHelper.a(str1, j);
      localImageView2.setBackgroundResource(k);
      TextView localTextView2 = localjv.b;
      String str2 = localCategoryVo.b();
      localTextView2.setText(str2);
      return localView;
      localjv = (jv)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((CategoryVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ju
 * JD-Core Version:    0.6.0
 */