package com.gs.design.pattern.state.atm;

enum TransactionType {
  DEPOSIT, WITHDRAW
}


public class AtmCard {

  private boolean isvalidCard;
  private boolean isValidPin;
  private int availableBalance;
  private int amountToWithDraw;
  private int amountToDeposit;
  private TransactionType TransactionType;

  public int getAmountToDeposit() {
    return amountToDeposit;
  }

  public void setAmountToDeposit(int amountToDeposit) {
    this.amountToDeposit = amountToDeposit;
  }

  public TransactionType getTransactionType() {
    return TransactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    TransactionType = transactionType;
  }

  public boolean isIsvalidCard() {
    return isvalidCard;
  }

  public void setIsvalidCard(boolean isvalidCard) {
    this.isvalidCard = isvalidCard;
  }

  public boolean isValidPin() {
    return isValidPin;
  }

  public void setValidPin(boolean isValidPin) {
    this.isValidPin = isValidPin;
  }

  public int getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(int availableBalance) {
    this.availableBalance = availableBalance;
  }

  public int getAmountRequested() {
    return amountToWithDraw;
  }

  public void setAmountRequested(int amountRequested) {
    this.amountToWithDraw = amountRequested;
  }

}
