import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class hq
{
  private static hq a = new hq();
  private HttpGet b;

  public static hq a()
  {
    return a;
  }

  public void a(boolean paramBoolean)
  {
    j localj = g.a().k();
    k localk = g.a().h();
    aj localaj = ai.a().l();
    String str1 = localk.a();
    Object localObject1 = localj.a();
    int j = 0;
    Object localObject2 = "";
    int k = ((List)localObject1).size();
    if (j < k)
    {
      hk localhk = (hk)((List)localObject1).get(j);
      Object localObject3;
      if (localhk.c().equalsIgnoreCase(str1))
        localObject3 = localObject2;
      while (true)
      {
        j += 1;
        localObject2 = localObject3;
        break;
        StringBuilder localStringBuilder1 = new StringBuilder().append((String)localObject2);
        String str2 = localhk.c();
        localObject3 = str2 + str1;
        int m = ((List)localObject1).size() - 1;
        if (j == m)
          continue;
        localObject3 = (String)localObject3 + ",";
      }
    }
    while (true)
    {
      try
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str3 = gh.f;
        URI localURI = URI.create(str3 + (String)localObject2);
        HttpGet localHttpGet = new HttpGet(localURI);
        this.b = localHttpGet;
        localObject4 = gm.a(this.b);
        i = ((HttpResponse)localObject4).getStatusLine().getStatusCode();
        if (i != 200)
        {
          String str4 = "HTTP status code: " + i + " != " + 200;
          throw new Exception(str4);
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        n = 1;
        if (n == 0)
          return;
        if (!paramBoolean)
          continue;
        b();
        eb localeb1 = eb.a();
        String str5 = ea.q;
        localeb1.a(str5);
        throw new Exception("update currency rate from feidee failer");
      }
      String str6 = EntityUtils.toString(((HttpResponse)localObject4).getEntity());
      JSONObject localJSONObject = new JSONObject(str6);
      String str7 = hr.a;
      Object localObject4 = localJSONObject.getJSONArray(str7);
      int i = ((JSONArray)localObject4).length();
      localObject1 = new ArrayList(i);
      j = 0;
      while (true)
        if (j < i)
        {
          localObject2 = ((JSONArray)localObject4).getJSONObject(j);
          ew localew1 = new ew();
          try
          {
            String str8 = hr.b;
            double d = ((JSONObject)localObject2).getDouble(str8);
            String str9 = hr.c;
            String str10 = ((JSONObject)localObject2).getString(str9);
            String str11 = hr.d;
            String str12 = ((JSONObject)localObject2).getString(str11);
            localew1.a(d);
            localew1.a(str10);
            localew1.b(str12);
            localew1.a(0);
            boolean bool1 = ((List)localObject1).add(localew1);
            j += 1;
          }
          catch (Exception localException1)
          {
            while (true)
              localException1.printStackTrace();
          }
        }
      boolean bool2 = localaj.a();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        ew localew2 = (ew)localIterator.next();
        boolean bool3 = localaj.a(localew2);
      }
      eb localeb2 = eb.a();
      String str13 = ea.q;
      localeb2.a(str13);
      int n = 0;
    }
  }

  public void b()
  {
    j localj = g.a().k();
    k localk = g.a().h();
    aj localaj = ai.a().l();
    List localList = localj.a();
    String str1 = localk.a();
    boolean bool1 = localaj.a();
    int i = 0;
    while (true)
    {
      int j = localList.size();
      if (i >= j)
        return;
      hk localhk = (hk)localList.get(i);
      ew localew = new ew();
      double d = 1.0D;
      String str2 = localhk.c();
      if (!str2.equalsIgnoreCase(str1))
      {
        localew.a(d);
        localew.a(str2);
        localew.b(str1);
        localew.a(0);
        boolean bool2 = localaj.a(localew);
      }
      i += 1;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hq
 * JD-Core Version:    0.6.0
 */