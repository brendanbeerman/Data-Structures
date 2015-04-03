import java.util.ArrayList;
import java.util.List;

public class stack<T> {
	
	// globals
	private List<T> stack;
	private int top, capacity;
	
	// constructor with out a capacity
	stack () {
		stack = new ArrayList<T>();
		top = -1;
		capacity = -1;
	}
	
	//constructor with a max capacity
	stack (int capacity) {
		if (capacity < 1) { // exits if the size is too small
			System.out.print("\nThe size must be greater than one.");
			System.exit(0);
		}
		
		stack = new ArrayList<T>(capacity);
		top = -1;
		this.capacity = capacity;
	}
	
	public void push (T item) {
		if (top < capacity || capacity == -1) {
			stack.add(item);
			top++;
		} else {
			System.out.print("\nCould not add item, the stack is full.");
		}
	}
	
	public T pop () {
		if (top > -1) {
			T result = stack.get(top);
			stack.remove(top);
			top--;
			return result;
		} else {
			System.out.print("\nNo items to pop.");
			return null;
		}
	}
	
	public T peek () {
		return stack.get(top);
	}
	
	public void clear () {
		stack.clear();
		top = -1;
	}
	
	public int indexOf (T item) {
		return stack.indexOf(item);
	}
	
	public int size () {
		return top;
	}
	
	public void enumerate () {
		for (int i = top; i >= 0; i--) {
			System.out.print("\n" + stack.get(i));
		}
	}
	
}
