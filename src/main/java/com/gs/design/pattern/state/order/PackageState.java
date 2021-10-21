package com.gs.design.pattern.state.order;

import java.util.Random;

public interface PackageState {

  void handle(Package pkg);

  default void randomWait() {
    Random random = new Random();
    int x = random.nextInt(9000) + 1000;
    try {
      Thread.sleep(x);
    } catch (InterruptedException e) {}
  }
  
}
