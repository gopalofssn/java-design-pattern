package com.gs.design.pattern.state.order;

public class ReceivedState implements PackageState {

  @Override
  public void next(Package pkg) {

    System.out.println("Order is in Last State - " + currentState());
  }

  @Override
  public void prev(Package pkg) {
    
    pkg.setState(new DeliveredState());
  }

  @Override
  public String currentState() {
    return "Received State";
  }

}
