package com.gs.design.pattern.state.vendingmachine;

import java.math.BigDecimal;
import java.util.Scanner;

public class CashInState implements VendingMachineState {

  @Override
  public void perform(VendingMachine vendingMachine) {
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Deposisted cash - ");
    BigDecimal input = scanner.nextBigDecimal();
    vendingMachine.setCash(input);
    vendingMachine.setState( new SelectItemState());
  }

}
