package com.gs.design.pattern.state.atm;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CardReadTests {

  private AtmMachine atmMachine = new AtmMachine();

  @Test
  public void testWithValidCard() {
    AtmCard atmCard = new AtmCardBuilder()
                           .buildWithValidCard()
                           .build();
    atmMachine.setAtmCard(atmCard);
    atmMachine.perform();
    assertTrue(atmMachine.atmState instanceof PinValidationState);
    
  }

  
  @Test
  public void testWithInValidCard() {
    AtmCard atmCard = new AtmCardBuilder()
                           .buildWithInValidCard()
                           .build();
    atmMachine.setAtmCard(atmCard);
    atmMachine.perform();
    assertTrue(atmMachine.atmState instanceof ExitMessageDisplayState);
    assertSame("Invalid Card", atmMachine.getMessage());
  }
  
}
