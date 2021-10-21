package com.gs.design.pattern.state.order;

public class WarehouseProcessingState implements PackageState {

  @Override
  public void handle(Package pkg) {
    randomWait();
    System.out.println("order id " + pkg.getOrderId() + " is in warehouse processing state");
    pkg.setState(new ShippedState());

  }

}
