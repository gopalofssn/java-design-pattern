package com.gs.design.pattern.state.order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    
    ExecutorService executor = Executors.newFixedThreadPool(10);
    
    for (int i = 0; i < 10; i++) {
      final int orderid = i;
      executor.submit(
          () -> {
            Package pkg = new Package("Order id " + orderid);
            pkg.perform();
          }
       );
      
    }
    
  }

}
