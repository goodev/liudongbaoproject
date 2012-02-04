import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class fj
{
  private String a = "GZip";
  private int b = 102400;
  private int c = 1024;

  // ERROR //
  private void a(FileInputStream paramFileInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 27	java/io/FileOutputStream
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 30	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: new 32	fi
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 35	fi:<init>	(Ljava/io/OutputStream;)V
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 22	fj:c	I
    //   27: newarray byte
    //   29: astore 6
    //   31: aload_1
    //   32: aload 6
    //   34: invokevirtual 41	java/io/FileInputStream:read	([B)I
    //   37: istore 7
    //   39: iload 7
    //   41: bipush 255
    //   43: if_icmpeq +47 -> 90
    //   46: aload 5
    //   48: aload 6
    //   50: iconst_0
    //   51: iload 7
    //   53: invokevirtual 45	fi:write	([BII)V
    //   56: goto -25 -> 31
    //   59: astore 8
    //   61: aload 4
    //   63: astore_3
    //   64: aload 8
    //   66: astore 4
    //   68: aload 4
    //   70: invokevirtual 48	java/io/IOException:printStackTrace	()V
    //   73: aload_0
    //   74: aload 5
    //   76: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   79: aload_0
    //   80: aload_3
    //   81: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   89: return
    //   90: aload_0
    //   91: aload 5
    //   93: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   96: aload_0
    //   97: aload 4
    //   99: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   102: aload_0
    //   103: aload_1
    //   104: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   107: return
    //   108: astore 9
    //   110: aconst_null
    //   111: astore 5
    //   113: aload_0
    //   114: aload 5
    //   116: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   119: aload_0
    //   120: aload_3
    //   121: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   124: aload_0
    //   125: aload_1
    //   126: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   129: aload 9
    //   131: athrow
    //   132: astore 10
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 4
    //   139: astore_3
    //   140: aload 10
    //   142: astore 9
    //   144: goto -31 -> 113
    //   147: astore 11
    //   149: aload 4
    //   151: astore_3
    //   152: aload 11
    //   154: astore 9
    //   156: goto -43 -> 113
    //   159: astore 9
    //   161: goto -48 -> 113
    //   164: astore 4
    //   166: aconst_null
    //   167: astore 5
    //   169: goto -101 -> 68
    //   172: astore 12
    //   174: aconst_null
    //   175: astore 5
    //   177: aload 4
    //   179: astore_3
    //   180: aload 12
    //   182: astore 4
    //   184: goto -116 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   23	56	59	java/io/IOException
    //   2	12	108	finally
    //   12	23	132	finally
    //   23	56	147	finally
    //   68	73	159	finally
    //   2	12	164	java/io/IOException
    //   12	23	172	java/io/IOException
  }

  private void a(InputStream paramInputStream)
  {
    if (paramInputStream == null)
      return;
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  private void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      return;
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void a(String paramString1, String paramString2)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString1);
    a(localFileInputStream, paramString2);
  }

  // ERROR //
  public void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 37	java/io/FileInputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 63	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: new 67	java/util/zip/GZIPInputStream
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 69	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore 5
    //   23: new 27	java/io/FileOutputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 30	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   31: astore 6
    //   33: sipush 1024
    //   36: istore 7
    //   38: iload 7
    //   40: newarray byte
    //   42: astore 8
    //   44: aload 8
    //   46: arraylength
    //   47: istore 9
    //   49: aload 5
    //   51: aload 8
    //   53: iconst_0
    //   54: iload 9
    //   56: invokevirtual 72	java/util/zip/GZIPInputStream:read	([BII)I
    //   59: istore 10
    //   61: iload 10
    //   63: bipush 255
    //   65: if_icmpeq +60 -> 125
    //   68: aload 6
    //   70: aload 8
    //   72: iconst_0
    //   73: iload 10
    //   75: invokevirtual 73	java/io/FileOutputStream:write	([BII)V
    //   78: goto -34 -> 44
    //   81: astore 11
    //   83: aload 4
    //   85: astore_3
    //   86: aload 11
    //   88: astore 4
    //   90: aload 5
    //   92: astore 12
    //   94: aload 6
    //   96: astore 13
    //   98: aload 12
    //   100: astore 14
    //   102: aload 4
    //   104: invokevirtual 48	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: aload 14
    //   110: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   113: aload_0
    //   114: aload 13
    //   116: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   119: aload_0
    //   120: aload_3
    //   121: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   124: return
    //   125: aload 5
    //   127: invokevirtual 74	java/util/zip/GZIPInputStream:close	()V
    //   130: aload 6
    //   132: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   135: aload 4
    //   137: invokevirtual 76	java/io/FileInputStream:close	()V
    //   140: aload_0
    //   141: aload 5
    //   143: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   146: aload_0
    //   147: aload 6
    //   149: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   152: aload_0
    //   153: aload 4
    //   155: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   158: return
    //   159: astore 15
    //   161: aconst_null
    //   162: astore 13
    //   164: aconst_null
    //   165: astore 14
    //   167: aload_0
    //   168: aload 14
    //   170: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   173: aload_0
    //   174: aload 13
    //   176: invokespecial 50	fj:a	(Ljava/io/OutputStream;)V
    //   179: aload_0
    //   180: aload_3
    //   181: invokespecial 53	fj:a	(Ljava/io/InputStream;)V
    //   184: aload 15
    //   186: athrow
    //   187: astore 16
    //   189: aconst_null
    //   190: astore 14
    //   192: aconst_null
    //   193: astore 17
    //   195: aload 4
    //   197: astore_3
    //   198: aload 16
    //   200: astore 15
    //   202: aload 17
    //   204: astore 13
    //   206: goto -39 -> 167
    //   209: astore 18
    //   211: aload 5
    //   213: astore 14
    //   215: aconst_null
    //   216: astore 13
    //   218: aload 4
    //   220: astore_3
    //   221: aload 18
    //   223: astore 15
    //   225: goto -58 -> 167
    //   228: astore 19
    //   230: aload 4
    //   232: astore_3
    //   233: aload 19
    //   235: astore 15
    //   237: aload 5
    //   239: astore 20
    //   241: aload 6
    //   243: astore 13
    //   245: aload 20
    //   247: astore 14
    //   249: goto -82 -> 167
    //   252: astore 15
    //   254: goto -87 -> 167
    //   257: astore 4
    //   259: aconst_null
    //   260: astore 13
    //   262: aconst_null
    //   263: astore 14
    //   265: goto -163 -> 102
    //   268: astore 21
    //   270: aconst_null
    //   271: astore 14
    //   273: aconst_null
    //   274: astore 22
    //   276: aload 4
    //   278: astore_3
    //   279: aload 21
    //   281: astore 4
    //   283: aload 22
    //   285: astore 13
    //   287: goto -185 -> 102
    //   290: astore 23
    //   292: aload 5
    //   294: astore 14
    //   296: aconst_null
    //   297: astore 13
    //   299: aload 4
    //   301: astore_3
    //   302: aload 23
    //   304: astore 4
    //   306: goto -204 -> 102
    //
    // Exception table:
    //   from	to	target	type
    //   38	78	81	java/io/IOException
    //   125	140	81	java/io/IOException
    //   2	12	159	finally
    //   12	23	187	finally
    //   23	33	209	finally
    //   38	78	228	finally
    //   125	140	228	finally
    //   102	107	252	finally
    //   2	12	257	java/io/IOException
    //   12	23	268	java/io/IOException
    //   23	33	290	java/io/IOException
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fj
 * JD-Core Version:    0.6.0
 */