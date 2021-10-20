package com.gs.design.pattern.state.order;

public class DeliveredState implements PackageState {

  @Override
  public void next(Package pkg) {

    pkg.setState(new ReceivedState());
  }

  @Override
  public void prev(Package pkg) {

    pkg.setState(new OrderState());
  }

  @Override
  public String currentState() {
    
    return "Delivered State";
  }

}
