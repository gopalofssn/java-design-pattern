package com.gs.design.pattern.state.traffic;

import java.util.Queue;

public interface TrafficLightState {

  public void action(TrafficSystem trafficSystem);

  default void allowTraffic(Queue<String> vehicles, int seconds, String lightColor) {

    for (int i = 0; i < seconds; i++) { 
      if (!vehicles.isEmpty()) {
        String vehile = vehicles.poll();
        System.out.println(vehile + " is moved ahead in " + lightColor +" light");
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {}

    }
  }

}
