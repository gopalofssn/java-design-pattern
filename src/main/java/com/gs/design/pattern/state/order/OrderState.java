package com.gs.design.pattern.state.order;

public class OrderState implements PackageState {

  @Override
  public void next(Package pkg) {
    
    pkg.setState(new DeliveredState());
  }

  @Override
  public void prev(Package pkg) {

    System.out.println("Package is in root state");
  }

  @Override
  public String currentState() {
    
    return "Order state";
  }

}
