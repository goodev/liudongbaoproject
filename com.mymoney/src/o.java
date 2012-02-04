import com.mymoney.core.vo.AccountGroupVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class o
  implements d
{
  private ad a;

  public o()
  {
    ad localad = ai.a().j();
    this.a = localad;
  }

  private AccountGroupVo a(er paramer)
  {
    AccountGroupVo localAccountGroupVo = new AccountGroupVo();
    long l = paramer.b();
    localAccountGroupVo.a(l);
    String str1 = paramer.c();
    localAccountGroupVo.a(str1);
    String str2 = paramer.h();
    localAccountGroupVo.b(str2);
    int i = paramer.g();
    localAccountGroupVo.a(i);
    int j = paramer.i();
    localAccountGroupVo.b(j);
    boolean bool = paramer.f();
    localAccountGroupVo.a(bool);
    return localAccountGroupVo;
  }

  private List a(List paramList)
  {
    int i = paramList.size();
    ArrayList localArrayList = new ArrayList(i);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      er localer = (er)localIterator.next();
      AccountGroupVo localAccountGroupVo = a(localer);
      boolean bool = localArrayList.add(localAccountGroupVo);
    }
    return localArrayList;
  }

  public List a()
  {
    long l = this.a.a();
    return a(l);
  }

  public List a(long paramLong)
  {
    List localList = this.a.b(paramLong);
    return a(localList);
  }

  public AccountGroupVo b()
  {
    er localer = this.a.b();
    return a(localer);
  }

  public AccountGroupVo b(long paramLong)
  {
    er localer1 = this.a.a(paramLong);
    if (localer1 == null)
      localer1 = er.a();
    Stack localStack = new Stack();
    Object localObject1 = localStack.push(localer1);
    long l1 = localer1.d();
    while (true)
    {
      long l2 = er.c;
      if (l1 == l2)
        break;
      er localer2 = this.a.a(l1);
      Object localObject2 = localStack.push(localer2);
      l1 = localer2.d();
    }
    er localer3 = (er)localStack.pop();
    AccountGroupVo localAccountGroupVo1 = a(localer3);
    AccountGroupVo localAccountGroupVo2;
    for (Object localObject3 = localAccountGroupVo1; !localStack.empty(); localObject3 = localAccountGroupVo2)
    {
      er localer4 = (er)localStack.pop();
      localAccountGroupVo2 = a(localer4);
      ((AccountGroupVo)localObject3).b(localAccountGroupVo2);
    }
    return (AccountGroupVo)localAccountGroupVo1;
  }

  public Map c()
  {
    List localList = this.a.c();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      er localer = (er)localIterator.next();
      String str = localer.c();
      AccountGroupVo localAccountGroupVo = a(localer);
      Object localObject = localHashMap.put(str, localAccountGroupVo);
    }
    return localHashMap;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     o
 * JD-Core Version:    0.6.0
 */