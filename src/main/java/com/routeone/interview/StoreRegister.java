package com.routeone.interview;

import java.io.File;
import java.util.List;
import java.util.HashMap;
import java.util.ListIterator;
import com.routeone.inventory.CreateInventory;
import com.routeone.inventory.ItemDetails;
import com.routeone.order.Order;
import com.routeone.order.OrderItem;

/*
 * Provided code stub.  Added class fields and filled in method code
 */
public class StoreRegister {

    private HashMap<String, ItemDetails> inventory;
    private boolean inventoryLoaded = false;

    public void loadInventory(File inventoryFile){
      inventory = new HashMap<String, ItemDetails>();

      inventoryLoaded =  CreateInventory.loadInventory(inventoryFile, inventory);

    }
 
    public Receipt checkoutOrder(List<String> items) {
      if (inventoryLoaded){
        Order newOrder = new Order();
      
        ListIterator litr = items.listIterator();
        while(litr.hasNext()){
          String itemName = (String) litr.next();

          ItemDetails item = inventory.get(itemName);
          OrderItem newItem = new OrderItem(itemName, item.getCost());

          newOrder.addItem(newItem);

        }

        return newOrder;
      }

      return null;
    }
}