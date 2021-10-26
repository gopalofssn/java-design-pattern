package com.gs.design.pattern.state.vendingmachine;

import java.math.BigDecimal;
import java.util.*;

public class SelectItemState implements VendingMachineState {

  private Map<Integer, Product> itemNumberProductMap = new HashMap<>();

  public SelectItemState() {
    int count = 1;
    for (Product product : Product.values()) {
      System.out.println("Select " + count + " for " + product.name());
      itemNumberProductMap.put(count, product);
      count++;
    }
    System.out.println("Select 9 for exit");
  }

  @Override
  public void perform(VendingMachine vendingMachine) {

    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    int selectedItemNumber = scanner.nextInt();
    
    if (selectedItemNumber == 9) {
      vendingMachine.setState(new ShowExitMessage("collect your money " + vendingMachine.getCash()));
      return;
    }
    
    Product selectedProduct = itemNumberProductMap.get(selectedItemNumber);
    Map<Product, BigDecimal> productsCountMap = vendingMachine.getProductsCostMap();
    BigDecimal productCost = productsCountMap.get(selectedProduct);
    if ( vendingMachine.getCash().compareTo(productCost) < 0) {
      vendingMachine.setState(new ShowExitMessage("Insuffcient cash in, please take money " + vendingMachine.getCash()));
      return;
    }
    
    int availCountForSelectedItem = vendingMachine.getProductsCountMap().get(selectedProduct);
    if ( availCountForSelectedItem <= 0){
      System.out.println("Selected product " + selectedProduct + " is currently unavailable, Notifying to vendor ");
      vendingMachine.setState(new NotifyVendor(selectedProduct));
      return;
    }
    
    vendingMachine.setState(new ItemDispenseState(selectedProduct));
  }

}
