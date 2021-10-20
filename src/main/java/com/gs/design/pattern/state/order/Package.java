package com.gs.design.pattern.state.order;

public class Package {

  private PackageState state = new OrderState();
  private String orderId;
 
  public Package(String orderId) {
    this.orderId = orderId;
  }

  public void displayState() {
    System.out.println(orderId + "- " + state.currentState());
  }

  public void setState(PackageState newState) {
    state = newState;
  }

  public void nextState() {
    state.next(this);
  }
  
}
