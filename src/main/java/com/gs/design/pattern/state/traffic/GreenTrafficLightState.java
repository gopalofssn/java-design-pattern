package com.gs.design.pattern.state.traffic;

import java.util.Queue;

public class GreenTrafficLightState implements TrafficLightState {

  @Override
  public void action(TrafficSystem trafficSystem) {
    Queue<String> vehicles = trafficSystem.getVehicles();
    allowTraffic(vehicles, 15, "green");    // allowing traffic for 15 seconds
    System.out.println("Turning color to Yellow");
    trafficSystem.setState(new YellowTrafficLightState());
  }

}
