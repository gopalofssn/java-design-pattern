package com.gs.design.pattern.state.atm;

public class DepositTransactionState implements AtmState {

  @Override
  public void perform(AtmMachine atmMachine) {

    int amountToDeposit = atmMachine.getAtmCard().getAmountToDeposit();
    atmMachine.deposit(amountToDeposit);
    atmMachine.setMessage("Amount " + amountToDeposit + " is deposited and collect your card");
    atmMachine.setAtmState(new ExitMessageDisplayState());
  }

}
