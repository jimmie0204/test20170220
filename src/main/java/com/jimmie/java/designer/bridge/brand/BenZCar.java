package com.jimmie.java.designer.bridge.brand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BenZCar extends com.jimmie.java.designer.bridge.brand.AbstractCar {

  private static final Logger LOG = LoggerFactory.getLogger(BenZCar.class);
  
  @Override
  public void run() {
    gear.gear();
    LOG.info("BenZCar is running");
  };

}
