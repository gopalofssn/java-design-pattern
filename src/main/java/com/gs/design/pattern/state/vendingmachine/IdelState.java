package com.gs.design.pattern.state.vendingmachine;

public class IdelState implements VendingMachineState {

  @Override
  public void perform(VendingMachine vendingMachine) {
    System.out.println("insert coins or bills");
    vendingMachine.setState(new CashInState());
  }

}
