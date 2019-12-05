package com.jimmie.java.designer.bridge.client;


import com.jimmie.java.designer.bridge.brand.AbstractCar;
import com.jimmie.java.designer.bridge.brand.BMWCar;
import com.jimmie.java.designer.bridge.brand.BenZCar;
import com.jimmie.java.designer.bridge.transmission.Auto;
import com.jimmie.java.designer.bridge.transmission.Manual;
import com.jimmie.java.designer.bridge.transmission.Transmission;

public class BridgeClient {

  public static void main(String[] args) {
    Transmission auto = new Auto();
    AbstractCar bmw = new BMWCar();
    bmw.setTransmission(auto);
    bmw.run();
    

    Transmission manual = new Manual();
    AbstractCar benz = new BenZCar();
    benz.setTransmission(manual);
    benz.run();
  }

}
