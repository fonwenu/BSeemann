import com.routeone.interview.StoreRegister;
import java.io.File;
import com.routeone.order.Order;
import java.util.ArrayList;
import java.util.ListIterator;

/*
 * Class to test code
*/
public class Main {

  //File name of inventory file - 
  //private static String TEST_INVENTORY = "Coding Test\\test_inventory.csv";
  private static String TEST_INVENTORY = "..\\..\\..\\test_inventory.csv";

  public static void main(String[] args){

    /*
     * Test case has multiples of an item
     * - PC800
     */
    ArrayList<String> testCaseOne = new ArrayList<String>();
    testCaseOne.add("PC800");
    testCaseOne.add("Mouse");
    testCaseOne.add("GenericMotherboard");
    testCaseOne.add("GenericProcessor");
    testCaseOne.add("HardDrive500GB");
    testCaseOne.add("PC800");
    testCaseOne.add("LCD");

    /*
     * Test case has items at the same price, should then sort alphabetical
     * - DeluxeKeyboard & PC1033
     * - LCD & HardDrive1TB
     */
    ArrayList<String> testCaseTwo = new ArrayList<String>();
    testCaseTwo.add("WirelessMouse");
    testCaseTwo.add("GenericMotherboardV2");
    testCaseTwo.add("DeluxeKeyboard");
    testCaseTwo.add("LCD");
    testCaseTwo.add("GenericProcessor");
    testCaseTwo.add("PC1033");
    testCaseTwo.add("HardDrive1TB");

    /*
     * Test case has invalid item, should error out
     * - IntelProcessor
     */
    ArrayList<String> testCaseThree = new ArrayList<String>();
    testCaseThree.add("PC800");
    testCaseThree.add("GenericMotherboard");
    testCaseThree.add("IntelProcessor");
    testCaseThree.add("LCD");
    testCaseThree.add("Keyboard");

    StoreRegister store = new StoreRegister();

    //Simulates test where there was a problem loading the inventory
    runTest(store, testCaseOne, "Test Case One A - Inventory not loaded yet");

    File inventory = new File(TEST_INVENTORY);
    store.loadInventory(inventory);

    //Run Test One
    runTest(store, testCaseOne, "Test Case One B - Duplicate Items");

    //Run Test Two
    runTest(store, testCaseTwo, "Test Case Two - Items with same Price");

    //Run Test Three
    runTest(store, testCaseThree, "Test Case Three - Invalid Item");

  }
  
  /*
   * Method to run each test case
   */
  private static void runTest(StoreRegister store, ArrayList<String> order, String test_case){
    System.out.println("Test Case: " + test_case);
    System.out.println("Original Order: " + printItemArray(order));

    try {
      Order testOrder = (Order)store.checkoutOrder(order);
    
      ArrayList<String> testOrderResult = (ArrayList<String>) testOrder.getOrderedItems();
      String testOrderTotal = testOrder.getFormattedTotal();

      System.out.println("Order total: " + testOrderTotal);
      
      System.out.println("Items Ordered: " + printItemArray(testOrderResult));
      
    } catch (Exception exc) {
      System.out.println("Error with order");
    }
    System.out.println("\n");
  }
  
  /*
   * Function to format list of items
   */
  private static String printItemArray(ArrayList<String> arrayList){
    ListIterator litr = arrayList.listIterator();
    StringBuilder printString = new StringBuilder();
    boolean firstItem = true;      
    while (litr.hasNext()){
      if (firstItem){
        firstItem = false;                   
      } else {
        printString.append(", ");
      }
      printString.append((String) litr.next());        
    }
    
    return printString.toString();
  }

}
