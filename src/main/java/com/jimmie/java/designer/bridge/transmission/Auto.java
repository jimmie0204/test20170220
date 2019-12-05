package com.jimmie.java.designer.bridge.transmission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Auto extends com.jimmie.java.designer.bridge.transmission.Transmission {

  private static final Logger LOG = LoggerFactory.getLogger(Auto.class);

  @Override
  public void gear() {
    LOG.info("Auto transmission");
  }
}
