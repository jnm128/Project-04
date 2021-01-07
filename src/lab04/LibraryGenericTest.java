package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    System.out.println("Testing done.");
    
    // FILL IN for tests
    
    // FOR LAB: write tests for getInventoryList
    ArrayList<LibraryBook<String>> Inventory = lib1.getInventoryList();
    	for (int i = 1; i<= Inventory.size()-1; ++i)
    		if(Inventory.get(i).getIsbn()< Inventory.get(i-1).getIsbn())
    			System.err.println("TEST FAILED: getInventoryList for Library<String>");
    	
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    //Get InventoryList for lib3
    
    ArrayList<LibraryBook<String>> lib3Inventory1 = lib3.getInventoryList();
	for (int i = 1; i<= Inventory.size()-1; ++i)
		if(lib3Inventory1.get(i).getIsbn()< lib3Inventory1.get(i-1).getIsbn())
			System.err.println("TEST FAILED: getInventoryList for Library<String>");
	
	
	
	
    //getOrderByAuthorTest
    ArrayList<LibraryBook<String>> lib3Inventory2 = lib3.getOrderedByAuthor();
    for (int i = 1; i<= lib3Inventory1.size()-1; ++i) {
    	//System.out.println(lib3Inventory2.get(i).getAuthor());
		if(lib3Inventory2.get(i).getAuthor().compareTo(lib3Inventory2.get(i-1).getAuthor())<0) {
			  System.err.println("TEST FAILED: getOrderedByAuthor for Library<String>");
		}
		
			
    }	
    //getOverdueList testing
  
			String patron3= "Jason Doe";
			String patron4 ="Janice Doe";
			lib3.checkout(9781843190042L,patron3,1,11,2012);
			lib3.checkout(9781843190073L, patron4, 9,12 ,2011);
			
			ArrayList<LibraryBook<String>> lib3inventory3 = lib3.getOverdueList(11, 11, 2011);
			 for (int i = 1; i<= lib3inventory3.size()-1; ++i) {
				 if(lib3inventory3.get(i).getDueDate().compareTo(lib3inventory3.get(i-1).getDueDate())<0) {
					 System.err.println("TEST FAILED: getOverdueList for Library<String>");
				 }
			 }

			
			
	

			
    
    
  }
}
