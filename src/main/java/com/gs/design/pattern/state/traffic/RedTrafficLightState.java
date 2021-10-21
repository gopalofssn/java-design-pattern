package com.gs.design.pattern.state.traffic;

public class RedTrafficLightState implements TrafficLightState {

  @Override
  public void action(TrafficSystem trafficSystem) {
    System.out.println("vehicles are stopped. People are crossing road for next 10 seconds....");
    try {
      Thread.sleep(10000); //simply wait 10 secs
    } catch (InterruptedException e) {}
    System.out.println("Turning color to Green");
    trafficSystem.setState(new GreenTrafficLightState());
  }

}
