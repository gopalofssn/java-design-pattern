package com.gs.design.pattern.state.order;

public class OrderPlacedState implements PackageState {

  @Override
  public void handle(Package pkg) {
    randomWait();
    System.out.println("order id " + pkg.getOrderId() + " is in order placed state");
    pkg.setState(new PaymentProcessingState());
  }
  
}
