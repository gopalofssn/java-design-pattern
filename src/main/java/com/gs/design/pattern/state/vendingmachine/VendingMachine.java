package com.gs.design.pattern.state.vendingmachine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

enum Product {
  COKE, PEPSI, DR_PEPPERS
}


public class VendingMachine {

  private Map<Product, BigDecimal> productsCostMap;
  private Map<Product, Integer> productsCountMap;
  private VendingMachineState state = new IdelState();
  private BigDecimal cash;
  
  public VendingMachine() {
    productsCostMap = new HashMap<Product, BigDecimal>();
    productsCountMap = new HashMap<Product, Integer>();
    loadproductsCostMap();
    loadproductsCountMap();
  }

  private void loadproductsCountMap() {
    productsCountMap.put(Product.COKE, 2);
    productsCountMap.put(Product.PEPSI, 2);
    productsCountMap.put(Product.DR_PEPPERS, 8);
  }

  private void loadproductsCostMap() {
    productsCostMap.put(Product.COKE, round(1.49) );
    productsCostMap.put(Product.PEPSI, round(1.79));
    productsCostMap.put(Product.DR_PEPPERS, round(1.07));
  }

  private BigDecimal round(double number) {
    return round(new BigDecimal(number));
  }

  private BigDecimal round(BigDecimal number) {
    return number.setScale(2, RoundingMode.HALF_EVEN);
  }

  public void setState(VendingMachineState state) {
    this.state = state;
    handle();
  }
  
  public void handle() {
    if (state instanceof IdelState) {
      System.out.println(this.toString());
    }
    state.perform(this);
  }

  public BigDecimal getCash() {
    return cash;
  }

  public void setCash(BigDecimal cash) {
    this.cash = round(cash);
  }
  
  public void reduceProductByOne(Product product) {
    int count = productsCountMap.get(product);
    count--;
    productsCountMap.put(product, count);
  }

  public Map<Product, Integer> getProductsCountMap() {
    return new HashMap<>(productsCountMap);
  } 
  
  public Map<Product, BigDecimal> getProductsCostMap() {
    return new HashMap<>(productsCostMap);
  }

  @Override
  public String toString() {
    return "VendingMachine [productsCostMap=" + productsCostMap + ", productsCountMap="
        + productsCountMap + ", cash=" + cash + "]";
  } 
  
  
}
