package com.gs.design.pattern.state.atm;

public class AtmCardBuilder {

  private AtmCard atmCard = new AtmCard();

  public AtmCardBuilder buildWithValidCard() {
    atmCard.setIsvalidCard(true);
    return this;
  }

  public AtmCard build() {
    return atmCard;
  }

  public AtmCardBuilder buildWithInValidCard() {
    atmCard.setIsvalidCard(false);
    return this;
  }

  public AtmCardBuilder buildWithValidPin() {
    atmCard.setValidPin(true);
    return this;
  }

  public AtmCardBuilder buildWithInValidPin() {
    atmCard.setValidPin(false);
    return this;
  }

  public AtmCardBuilder buildWithWithDrawal(int accountBalance, int amountToWithDraw) {
    atmCard.setTransactionType(TransactionType.WITHDRAW);
    atmCard.setAvailableBalance(accountBalance);
    atmCard.setAmountRequested(amountToWithDraw);
    return this;
  }

  public AtmCardBuilder buildWithDeposit(int amount) {
    atmCard.setTransactionType(TransactionType.DEPOSIT);
    atmCard.setAmountToDeposit(amount);
    return this;
  }

}
