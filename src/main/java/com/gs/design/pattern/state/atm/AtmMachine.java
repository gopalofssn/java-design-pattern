package com.gs.design.pattern.state.atm;

public class AtmMachine {

  private int balance = 1000;
  public AtmState atmState = new CardReadState();
  private String message;
  private AtmCard atmCard;
  
  public AtmCard getAtmCard() {
    return atmCard;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void setAtmCard(AtmCard atmCard) {
    this.atmCard = atmCard;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public void withdraw(int amount) {
    balance -= amount;
  }

  public void setAtmState(AtmState atmState) {
    this.atmState = atmState;
  }

  public int getBalance() {
    return balance;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
  
  public void perform() {
    atmState.perform(this);
  }

}
