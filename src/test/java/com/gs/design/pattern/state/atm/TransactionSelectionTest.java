package com.gs.design.pattern.state.atm;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TransactionSelectionTest {
 
  @Test
  public void withDrawTransactionTest1() {
    AtmMachine atmMachine = new AtmMachine();
    AtmCard atmCard = new AtmCardBuilder()
                          .buildWithValidCard()
                          .buildWithValidPin()
                          .buildWithWithDrawal(500, 200)
                          .build();
    atmMachine.setAtmCard(atmCard);
    assertTrue(atmMachine.atmState instanceof CardReadState);
    atmMachine.perform(); 
 
    assertTrue(atmMachine.atmState instanceof PinValidationState);
    atmMachine.perform();

    assertTrue(atmMachine.atmState instanceof SelectTransactionState);
    atmMachine.perform();
    
    assertTrue(atmMachine.atmState instanceof WithDrawTransactionState);
    atmMachine.perform();
    
    assertTrue(atmMachine.atmState instanceof ExitMessageDisplayState);
    atmMachine.perform();
    
    assertTrue(800 == atmMachine.getBalance());
  }
  
  
  @Test
  public void withDrawTransactionTest2() {
    AtmMachine atmMachine = new AtmMachine();
    AtmCard atmCard = new AtmCardBuilder()
                          .buildWithValidCard()
                          .buildWithValidPin()
                          .buildWithWithDrawal(200, 500)
                          .build();
    atmMachine.setAtmCard(atmCard);
    assertTrue(atmMachine.atmState instanceof CardReadState);
    atmMachine.perform(); 
 
    assertTrue(atmMachine.atmState instanceof PinValidationState);
    atmMachine.perform();

    assertTrue(atmMachine.atmState instanceof SelectTransactionState);
    atmMachine.perform();
    
    assertTrue(atmMachine.atmState instanceof WithDrawTransactionState);
    atmMachine.perform();
    
    assertTrue(atmMachine.atmState instanceof ExitMessageDisplayState);
    atmMachine.perform();
    
    assertTrue(1000 == atmMachine.getBalance());
  }
  
  
  @Test
  public void depositTransactionTest() {
    AtmMachine atmMachine = new AtmMachine();
    AtmCard atmCard = new AtmCardBuilder()
                          .buildWithValidCard()
                          .buildWithValidPin()
                          .buildWithDeposit(500)
                          .build();
    atmMachine.setAtmCard(atmCard);
    assertTrue(atmMachine.atmState instanceof CardReadState);
    atmMachine.perform(); 
 
    assertTrue(atmMachine.atmState instanceof PinValidationState);
    atmMachine.perform();

    assertTrue(atmMachine.atmState instanceof SelectTransactionState);
    atmMachine.perform();
    
    assertTrue(atmMachine.atmState instanceof DepositTransactionState);
    atmMachine.perform();
    
    assertTrue(atmMachine.atmState instanceof ExitMessageDisplayState);
    atmMachine.perform();
    
    assertTrue(1500 == atmMachine.getBalance());
  }
  
}
