package com.routeone.inventory;
/*
 * Class to store details of each inventory item.
 * category is not actually used and component is duplicated with map key
 *
 */
public class ItemDetails {
  private String component;
  private double cost;
  private String category;

  public ItemDetails(String component, double cost, String category){
    this.component = component;
    this.cost  = cost;
    this.category = category;
  }

  public String getComponent(){
    return this.component;
  }

  public String getCategory(){
    return this.category;
  }

  public double getCost() {
    return this.cost;
  }

}
