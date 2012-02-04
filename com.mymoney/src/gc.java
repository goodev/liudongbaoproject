 enum gc
{
  static
  {
    gc[] arrayOfgc = new gc[2];
    gc localgc1 = a;
    arrayOfgc[0] = localgc1;
    gc localgc2 = b;
    arrayOfgc[1] = localgc2;
    c = arrayOfgc;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gc
 * JD-Core Version:    0.6.0
 */