package com.gs.design.pattern.state.order;

public class PaymentProcessingState implements PackageState {

  @Override
  public void handle(Package pkg) {
    randomWait();
    System.out.println("order id " + pkg.getOrderId() + " is in payment processing state");
    pkg.setState(new WarehouseProcessingState());

  }

}
