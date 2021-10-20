package com.gs.design.pattern.state.order;

public interface PackageState {

  void next(Package pkg);
  
  void prev(Package pkg);
  
  String currentState();
  
}
