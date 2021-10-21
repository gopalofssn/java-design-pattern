package com.gs.design.pattern.state.order;

public class ShippedState implements PackageState {

  @Override
  public void handle(Package pkg) {
    randomWait();
    System.out.println("order id " + pkg.getOrderId() + " is in shipped state");
    pkg.setState(new DeliveredState());

  }

}
