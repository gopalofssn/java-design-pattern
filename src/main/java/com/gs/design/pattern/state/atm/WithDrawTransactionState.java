package com.gs.design.pattern.state.atm;

public class WithDrawTransactionState implements AtmState {

  @Override
  public void perform(AtmMachine atmMachine) {
     
    int availableBalance = atmMachine.getAtmCard().getAvailableBalance();
    int amountRequested = atmMachine.getAtmCard().getAmountRequested();

    if (amountRequested > availableBalance) {
      atmMachine.setMessage("amountRequested is higher than availableBalance in account");
      atmMachine.setAtmState(new ExitMessageDisplayState());
      return;
    }

    if (amountRequested > atmMachine.getBalance()) {
      atmMachine.setMessage("amountRequested is higher than available Balance in atm machine");
      atmMachine.setAtmState(new ExitMessageDisplayState());
      return;
    }
    
    atmMachine.withdraw(amountRequested);
    atmMachine.setMessage("Collect your money " + amountRequested + " and card");
    atmMachine.setAtmState(new ExitMessageDisplayState());
  }

}
