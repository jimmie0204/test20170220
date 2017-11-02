package com.jimmie.test.序列化.java序列化;

public class SerializerFactory
{
  public static Object getSerializer(String className)
  {
    try
    {
      return Class.forName(className).newInstance();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}