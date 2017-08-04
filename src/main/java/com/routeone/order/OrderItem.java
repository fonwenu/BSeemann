package com.routeone.order;

/*
 * Each item of an order
 */
public class OrderItem {
  private String itemName;
  private double itemCost;
  
  public OrderItem(String newName, double newCost){
    this.itemName = newName;
    this.itemCost = newCost;
  }
  
  public String getItemName(){
    return this.itemName;
  }

  public double getItemCost(){
    return this.itemCost;
  }
}
