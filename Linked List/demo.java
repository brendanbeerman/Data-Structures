public class demo {

	public static void main (String[] args) {
		LinkedList<String> demo_list = new LinkedList<String>();
		
		System.out.print("Demo for the linked list class.");
		
		demo_list.addToFront("Halifax"); // testing adding to the front and the back
		demo_list.addToFront("Moncton");
		demo_list.addToEnd("Victoria");
		demo_list.addToFront("Winnipeg");
		demo_list.addToEnd("Halifax");
		demo_list.addToFront("Halifax");
		demo_list.addToFront("Montreal");
		
		demo_list.enumerate(); // display current list
		
		System.out.print("\nIndex 5 has: " + demo_list.getAt(5)); // testing get at an index
		
		demo_list.insertAt("Banff", 5); // inserting element at specific position
		System.out.print("\nIndex 5 now has: " + demo_list.getAt(5));
		
		System.out.print("\nIndex 1 was: " + demo_list.getAt(1)); // test setAt method
		demo_list.setAt("Quebec", 1); 
		System.out.print("\nIndex 1 is now: " + demo_list.getAt(1));
		
		System.out.print("\nIndex of Winnipeg is: " + demo_list.indexOf("Winnipeg")); // test index of
		
		demo_list.enumerate();
		
		demo_list.remove("Winnipeg"); // test removeAt
		demo_list.enumerate();
		
		demo_list.removeAll("Halifax"); // test removeAll
		demo_list.enumerate();
	}

}
