package com.routeone.order;
import java.util.Comparator;

/*
 * Comparator to sort Items in an order
 * Most expensive item first
 * If items are of equal price then sort by name
 */
public class OrderItemComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    OrderItem itemOne = (OrderItem) o1;
    OrderItem itemTwo = (OrderItem) o2;

    if (itemOne.getItemCost() > itemTwo.getItemCost()){
      return -1;
    } else if (itemOne.getItemCost() < itemTwo.getItemCost()){
      return 1;
    } else {
      return itemOne.getItemName().compareTo(itemTwo.getItemName());
    }
  }
}
