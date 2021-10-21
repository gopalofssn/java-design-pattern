package com.gs.design.pattern.state.traffic;

import java.util.Queue;

public class YellowTrafficLightState implements TrafficLightState {

  @Override
  public void action(TrafficSystem trafficSystem) {
    Queue<String> vehicles = trafficSystem.getVehicles();
    allowTraffic(vehicles, 5, "yellow");   // allowing traffic for 5 seconds before trun to red
    System.out.println("Turning color to Red");
    trafficSystem.setState(new RedTrafficLightState());
  }

}
