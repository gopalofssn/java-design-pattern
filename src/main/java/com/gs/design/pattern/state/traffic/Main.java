package com.gs.design.pattern.state.traffic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    
    ExecutorService executor = Executors.newFixedThreadPool(2);
    
    TrafficSystem trafficSystem = new TrafficSystem();
   
    executor.submit(
        () -> trafficSystem.perform()
    );
   
    executor.submit(
        () -> {
          for (int i = 0; i < 1000; i++) {
            while (trafficSystem.getVehicles().remainingCapacity() == 0) {}
            trafficSystem.addVehicle("vehicle " + i);
          }
        }  
    );
    
  }
}
