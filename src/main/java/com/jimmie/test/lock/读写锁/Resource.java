package com.jimmie.test.lock.读写锁;

//资源
class Resource{
  private int value;

  public void setValue(int value) {
     this.value = value;
  }
  public int getValue() {
     return value;
  }
}