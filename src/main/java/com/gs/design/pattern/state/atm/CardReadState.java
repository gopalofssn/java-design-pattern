package com.gs.design.pattern.state.atm;

public class CardReadState implements AtmState {

  @Override
  public void perform(AtmMachine atmMachine) {

    if (!atmMachine.getAtmCard().isIsvalidCard()) {
      atmMachine.setMessage("Invalid Card");
      atmMachine.setAtmState(new ExitMessageDisplayState());
      return;
    }
    
    System.out.println("Card is inserted & it's valid card");
    atmMachine.setAtmState(new PinValidationState());


  }

}
