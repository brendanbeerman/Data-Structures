package stackArrays;

public class stack {
	// globals
	private String []stack;
	private int top;
	private int size;
	
	// constructor
	stack (int s) {
		if(s < 1) {
			System.out.print("\nCannot make a stack with no size.");
			System.exit(0);
		}
		stack = new String[s];
		top = -1;
		size = s;
	}
	
	// utilities
	public void push (String item) {
		if (top == size) {
			System.out.print("\nCannot add an item to a full stack");
			return;
		}
		
		top++;
		stack[top] = item;
	}
	
	public String pop () {
		if (top == -1) {
			System.out.print("\nCannot pop a stack with no items.");
			return null;
		} else {
			String result = stack[top];
			top--;
			return result;
		}	
	}
	
	public String peek () {
		if (top == -1) {
			return null;
		}
		
		return stack[top];
	}
	
	public int indexOf (String item) {
		int i = 0;
		
		for ( ; i <= top; i++) {
			if (stack[i].equals(item)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int size () {
		return top;
	}
	
	public void clear () {
		stack = new String[size];
		top = 0;
	}
	
	public void enumerate () {
		for (int i = top; i >= 0; i--) {
			System.out.print("\n" + stack[i]);
		}
	}
	
}
