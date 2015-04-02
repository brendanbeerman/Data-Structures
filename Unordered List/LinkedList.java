public class LinkedList<T> {
	
	// globals
	private Node<T> front;
	private int count;
	
	// constructor
	public LinkedList () {
		front = null;
		count = 0;
	}
	
	// adds an item to the front of the linked list
	public void addToFront (T item) {
		Node<T> new_node = new Node<T>(item, front);
		front = new_node;
		count++;
	}
	
	// adds item to the end of the linked list
	public void addToEnd (T item) {
		Node<T> new_node = new Node<T>(item, null);
		
		if (isEmpty()) { // empty list the new_node becomes the front
			addToFront(item);
		} else { // iterate through the list to append the new_node
			Node<T> current = front;
			
			while (current.getNext()!=null) { // find the last node
				current = current.getNext();
			}
			current.setNext(new_node);
			count++;
		}
	} 
	
	// returns count, the current size of the linked list
	public int size () {
		return count;
	}
	
	// clears the linked list by making the front null
	public void clear () {
		front = null;
		count = 0;
	}
	
	// returns true if the linked list is empty
	public boolean isEmpty () {
		return (count == 0);
	}
	
	// scans the linked list and prints the data in order
	public void enumerate () {
		Node<T> current = front;
		System.out.print("\n");
		
		while (current!=null) {
			if (current.getNext() == null) {
				System.out.print(current.getData());
			} else {
				System.out.print(current.getData() + " -> ");
			}
			current = current.getNext();
		}
		
	}
	
	// finds and returns the data at a given index or null if it is not found
	public T getAt (int index) {
		Node<T> current = front;
		
		if (index < 0 || index >= count) { // entered index does not exist
			System.out.println("Error. Index out of bounds");
			System.exit(0);
		} else { // gets the node at the index
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}		
		}
		
		if (current != null) { // returns the data
			return current.getData();
		} else { // returns null if there was no data
			return null;
		}
	}
	
	// inserts an item at a given index
	public void insertAt (T item, int index) {
		if (index < 0 || index > count) { // exits if index is out of bounds
			System.out.println("Can't insert. Index out of bounds.");
			System.exit(0);
		} else { // can add the item
			if (index == 0) {
				addToFront(item);
				return;
			}
			Node<T> previous = front;
			
			for (int i = 0; i < index-1; i++) { // to find the place
				previous = previous.getNext();
			}
			Node<T> new_node = new Node<T>(item, previous.getNext()); // appends the rest of the list to the new node
			previous.setNext(new_node); // appends the new node to the first part of the list
			count++;
		}
	}
	
	// resets the data of a node at a given index
	public void setAt (T item, int index) {
		if (index < 0 || index >= count) { // exits if the node would not exist
			System.out.println("Can't set. Index out of bounds");
			System.exit(0);
		}
		else {
			Node<T> current = front;
			
			for (int i = 0; i < index; i++) { // finding the node
				current = current.getNext();
			}	
			current.setData(item);
		}
	}
	
	// returns the index of the first occurrence of a given item, -1 if not found
	public int indexOf (T item) {
		Node<T> current = front;
		
		for (int i = 0; i < count; i++) {
			if (item.equals(current.getData())) {
				return i;
			}	
			current = current.getNext();
		}
		return -1;
	}
	
	// removes the node at a given index and returns the data
	public T removeAt (int index) {
		T result = null;
		if (index < 0 || index >= count) { // exits if the index is not there
			System.out.println("Can't remove. Index out of bounds");
			System.exit(0);
		} else { 
			if (index == 0) { // sets the new front node
				result = front.getData();
				front = front.getNext();
			} else {  // iterates through 
				Node<T> previous = front;
				for (int i = 0; i < index-1; i++) { // finds the node at the index
					previous = previous.getNext();
				}	
				result = previous.getNext().getData(); // the removed element
				previous.setNext(previous.getNext().getNext()); // sets the previous node's next node to be the removed's next node
					
			}
			count--;
		}
		return result;
	}
	
	// removes the node containing the first occurrence of a given item
	public void remove (T item) {
		int i = indexOf(item);
		if (i == -1) { // exits if the item does not exist
			System.out.println("No such item");
			System.exit(0);
		} else { // removes the item
			removeAt(i);
		}	
	}
	
	/*
	 * Removes all nodes containing a given item
	 * Does the removal in one scan (O(n))
	*/
	public void removeAll (T item) {
		Node<T> current = front, previous = null;
		
		while (current != null) {
			if (front.getData().equals(item)) { // checks the first node of the list
				front = front.getNext();
				current = current.getNext();
				count--;
			} else if (current == front) { // iterates to the next set of nodes
				previous = current;
				current = current.getNext();
			} else { //
				if (current != null) { // 
					if (current.getData().equals(item)) { // removes the node if it is a match
						previous.setNext(current.getNext());
						current= previous.getNext();
						count--;
					} else { // iterates to next set of nodes
						previous = current;
						current = current.getNext();
					}
				}
			}
		}
	}  
   
}
