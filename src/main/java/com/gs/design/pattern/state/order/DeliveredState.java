package com.gs.design.pattern.state.order;

public class DeliveredState implements PackageState {

  @Override
  public void handle(Package pkg) {
    System.out.println("order id " + pkg.getOrderId() + " is Delivered");   
  }

}
