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
		
		if (isEmpty()) {
			addToFront(item);
		} else {
			Node<T> current = front;
			
			while (current.getNext()!=null) {
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
		
		while (curr!=null) {
			if (current.getNext() == null) {
				System.out.print(curr.getData());
			} else {
				System.out.print(curr.getData() + " ->");
			}
			current = current.getNext();
		}
		
	}
	
	// finds and returns the data at a given index or null if it is not found
	public T getAt (int index) {
		Node<T> current = front;
		
		if (index < 0 || index >= count) {
			System.out.println("Error. Index out of bounds");
		} else {
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}		
		}
		
		if (current != null) {
			return current.getData();
		} else {
			return null;
		}
	}
	
	// inserts an item at a given index
	public void insertAt (T item, int index) {
		if (index < 0 || index > count) {
			System.out.println("Can't insert. Index out of bounds.");
			System.exit(0);
		} else {
			if (index==0) {
				add(item);
				return;
			}
			Node<T> previous = front;
			
			for (int i = 0; i < index-1; i++) {
				previous = previous.getNext();
			}
			Node<T> new_node = new Node<T>(item, previous.getNext());
			previous.setNext(new_node);
			count++;
		}
	}
	
	// resets the data of a node at a given index
	public void setAt (T item, int index) {
		if (index < 0 || index >= count) {
			System.out.println("Can't set. Index out of bounds");
			System.exit(0);
		}
		else {
			Node<T> current = front;
			
			for (int i = 0; i < index; i++) {
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
		if (index < 0 || index >= count) {
			System.out.println("Can't remove. Index out of bounds");
			System.exit(0);
		} else {
			if (index == 0) {
				result = front.getData();
				front = front.getNext();
			} else {
				Node<T> previous = front;
				for (int i = 0; i < index-1; i++) {
					previous = previous.getNext();
				}	
				result = previous.getNext().getData();
				previous.setNext(previous.getNext().getNext());
					
			}
			count--;
		}
		return result;
	}
	
	// removes the node containing the first occurrence of a given item
	public void remove (T item) {
		int i = indexOf(item);
		if (i==-1) {
			System.out.println("No such item");
			System.exit(0);
		} else {
			removeAt(i);
		}	
	}
	
	/*
	 * Removes all nodes containing a given item
	 * Does the removal in one scan (O(n))
	*/
	public void removeAll (T item) {
		Node<T> curr=front, prev=null;
		
		while (curr!=null)
		{
			if (front.getData().equals(item))
			{
				front = front.getNext();
				curr = curr.getNext();
				count--;
			}
			else if (curr == front)
			{
				prev = curr;
				curr = curr.getNext();
			}
			else
			{
				if (curr!=null)
				{
					if (curr.getData().equals(item))
					{
						prev.setNext(curr.getNext());
						curr= prev.getNext();
						count--;
					}
					else
					{
					prev = curr;
					curr = curr.getNext();
					}
				}
			}
		}
	}
	
   //adds item to the end of the linked list
   public void addToEnd (T item) {
      Node<T> itemnode = new Node<T>(item, null);
      if (isEmpty()) {
         addFront(item);
      } else {
         Node<T> curr = front;
         while (curr.getNext()!=null) {
            curr= curr.getNext();
         }
         curr.setNext(itemnode);
      }
      count++;
   }   
   
}
