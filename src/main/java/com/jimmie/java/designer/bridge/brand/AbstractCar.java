package com.jimmie.java.designer.bridge.brand;

import com.jimmie.java.designer.bridge.transmission.Transmission;

//品牌车
public abstract class AbstractCar {

  protected Transmission gear;
  
  public abstract void run();
  
  public void setTransmission(Transmission gear) {
    this.gear = gear;
  }
  
}
