package com.routeone.order;

import com.routeone.interview.Receipt;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/*
 * Implements Receipt class
 */
public class Order implements Receipt{
  private ArrayList<OrderItem> orderItems;
  private double orderTotal;

  public Order(){

    orderItems = new ArrayList<OrderItem>();
    orderTotal = 0.0;
  }

  public void addItem(OrderItem newItem){
    orderItems.add(newItem);
    orderTotal += newItem.getItemCost();
  }

  /*
   * Implementation of interface method
   */
  public String getFormattedTotal() {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    return formatter.format(orderTotal);
  }

  /*
   * Implementation of interface method
   */
  public List<String> getOrderedItems() {
    Collections.sort(orderItems, new OrderItemComparator());

    List<String> sortedList = new ArrayList<String>();
    ListIterator litr = orderItems.listIterator();
    
    while(litr.hasNext()){
      OrderItem temp = (OrderItem) litr.next();
      sortedList.add(temp.getItemName());
    }

    return sortedList;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
