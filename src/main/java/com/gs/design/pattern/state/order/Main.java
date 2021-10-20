package com.gs.design.pattern.state.order;

public class Main {

  public static void main(String[] args) {
    Package pkg = new Package("Order id 1");
    pkg.displayState();
    pkg.nextState();
    pkg.displayState();
    pkg.nextState();
    pkg.displayState();
    
    pkg.nextState();
    pkg.displayState();    
    
    pkg = new Package("Order id 2");
    pkg.displayState();
    pkg.nextState();
    pkg.nextState();
    pkg.displayState();
  }

}
