package com.gs.design.pattern.state.vendingmachine;

public class NotifyVendor implements VendingMachineState {

  private Product product;

  public NotifyVendor(Product product) {
    this.product = product;
  }

  @Override
  public void perform(VendingMachine vendingMachine) {
    System.out.println("Notified vendor about unavailable product " + product);
    vendingMachine.setState( new SelectItemState());
  }

}
