package com.gs.design.pattern.state.atm;

public class PinValidationState implements AtmState {

  @Override
  public void perform(AtmMachine atmMachine) {

    if (!atmMachine.getAtmCard().isValidPin()) {
      atmMachine.setMessage("Incorrect Pin");
      atmMachine.setAtmState(new ExitMessageDisplayState());
      return;
    }

    System.out.println("Correct pin is entred ");
    atmMachine.setAtmState(new SelectTransactionState());

  }

}
