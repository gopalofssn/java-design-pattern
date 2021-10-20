package com.gs.design.pattern.state.atm;

public class ExitMessageDisplayState implements AtmState {

  @Override
  public void perform(AtmMachine atmMachine) {
    
    System.out.println(atmMachine.getMessage());
    atmMachine.setAtmState(new CardReadState());
    atmMachine.setAtmCard(null);
  }

}
