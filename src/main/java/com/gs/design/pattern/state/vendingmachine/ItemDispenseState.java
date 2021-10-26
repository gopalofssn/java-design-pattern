package com.gs.design.pattern.state.vendingmachine;

import java.math.BigDecimal;
import java.util.Map;

public class ItemDispenseState implements VendingMachineState {

  private Product selectedProduct;

  public ItemDispenseState(Product selectedProduct) {
    this.selectedProduct = selectedProduct;
  }

  @Override
  public void perform(VendingMachine vendingMachine) {
    Map<Product, BigDecimal> productsCountMap = vendingMachine.getProductsCostMap();
    BigDecimal productCost = productsCountMap.get(selectedProduct);
    BigDecimal remianing = vendingMachine.getCash().subtract(productCost);
    vendingMachine.reduceProductByOne(selectedProduct);
    vendingMachine.setState(new ShowExitMessage("Collect remianing " + remianing + " and product " + selectedProduct));
  }

}
