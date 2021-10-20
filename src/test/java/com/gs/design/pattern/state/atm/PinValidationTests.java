package com.gs.design.pattern.state.atm;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PinValidationTests {

  private AtmMachine atmMachine = new AtmMachine();
  
  @Test
  public void correctPinTest() {
    AtmCard atmCard = new AtmCardBuilder()
                          .buildWithValidCard()
                          .buildWithValidPin()
                          .build();
    atmMachine.setAtmCard(atmCard);
    assertTrue(atmMachine.atmState instanceof CardReadState);
    atmMachine.perform(); 
 
    assertTrue(atmMachine.atmState instanceof PinValidationState);
    atmMachine.perform();

    assertTrue(atmMachine.atmState instanceof SelectTransactionState);
    
  }
  
  @Test
  public void incorrectPinTest() {
    AtmCard atmCard = new AtmCardBuilder()
        .buildWithValidCard()
        .buildWithInValidPin()
        .build();
    atmMachine.setAtmCard(atmCard);
    assertTrue(atmMachine.atmState instanceof CardReadState);
    atmMachine.perform(); 
 
    assertTrue(atmMachine.atmState instanceof PinValidationState);
    atmMachine.perform();

    assertTrue(atmMachine.atmState instanceof ExitMessageDisplayState);
    atmMachine.perform();
    assertSame("Incorrect Pin", atmMachine.getMessage());
  }
}
