package com.gs.design.pattern.state.traffic;

import java.util.concurrent.ArrayBlockingQueue;

public class TrafficSystem {
  
    private TrafficLightState state = new GreenTrafficLightState();
    private ArrayBlockingQueue<String> vehicles = new ArrayBlockingQueue<>(50); // Street only allow 15 cars max
    
    public void setState(TrafficLightState state) {
      this.state = state;
      perform();
    }
    
    public void perform() {
      state.action(this);      
    }

    public void addVehicle(String vehicleName) {
      vehicles.add(vehicleName);
    }
    
    public ArrayBlockingQueue<String> getVehicles(){
      return vehicles;
    }
}
