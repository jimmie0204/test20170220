package com.jimmie.java.designer.bridge.brand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BMWCar extends com.jimmie.java.designer.bridge.brand.AbstractCar {

  private static final Logger LOG = LoggerFactory.getLogger(BMWCar.class);
  
  @Override
  public void run() {
    gear.gear();
    LOG.info("BMW is running");
  };

}
