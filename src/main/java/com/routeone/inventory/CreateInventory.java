package com.routeone.inventory;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

/*
 * Factory class to load one instance of inventory
 */
public class CreateInventory {
  
  private CreateInventory() {    
  }

  public static boolean loadInventory(File file, HashMap<String, ItemDetails> inventory){
    try{
      Scanner fileReader = new Scanner(file);
      while (fileReader.hasNext()) {
        String item = fileReader.nextLine();
        String[] details = item.split(",");

        String itemName = details[0];
        double itemCost = Double.parseDouble(details[1]);
        String itemCategory = details[2];
        
        ItemDetails newItem = new ItemDetails(itemName, itemCost, itemCategory);
        inventory.put(itemName, newItem);
      }

      fileReader.close();

    } catch (Exception exc){
      //Would typically record exception details in a log file here
      return false;
    }

    return true;
  }
}
