package com.jimmie.test.序列化.java序列化;

public  interface Serializer
{
  public byte[] serialize(Object paramObject);

  public Object deserialize(byte[] paramArrayOfByte);
}