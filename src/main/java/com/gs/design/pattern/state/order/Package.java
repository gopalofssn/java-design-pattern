package com.gs.design.pattern.state.order;

public class Package {

  private PackageState state = new OrderPlacedState();
  private String orderId;
 
  public Package(String orderId) {
    this.orderId = orderId;
  }

  public void setState(PackageState newState) {
    state = newState;
    perform();
  }
  
  public void perform() {
    state.handle(this);    
  }

  public String getOrderId() {
    return orderId;
  }
  
}
