package com.gs.design.pattern.state.atm;

public class SelectTransactionState implements AtmState {

  @Override
  public void perform(AtmMachine atmMachine) {
    
    if ( atmMachine.getAtmCard().getTransactionType().equals(TransactionType.WITHDRAW)) {
      atmMachine.setAtmState(new WithDrawTransactionState());
      return;
    }
    
    atmMachine.setAtmState(new DepositTransactionState());
    
  }
  
}
