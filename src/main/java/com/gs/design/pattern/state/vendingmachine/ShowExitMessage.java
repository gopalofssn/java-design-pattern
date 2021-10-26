package com.gs.design.pattern.state.vendingmachine;

import java.math.BigDecimal;

public class ShowExitMessage implements VendingMachineState {

  private String message;

  public ShowExitMessage(String message) {
    this.message = message;
  }

  @Override
  public void perform(VendingMachine vendingMachine) {
    System.out.println(message);
    vendingMachine.setCash(new BigDecimal(0.0));
    vendingMachine.setState(new IdelState());
  }

}
